/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.controller;

import com.winkle.gobay.dao.ProductDAO;
import com.winkle.gobay.entity.Item;
import com.winkle.gobay.entity.Product;
import com.winkle.gobay.service.PurchaseService;
import com.winkle.gobay.service.ShoppingCartService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Argos
 */
public class PayController extends HttpServlet {
    
    private PurchaseService service;
    private ShoppingCartService cart;
    private ProductDAO dao;
    private List<Item> list;

    @Override
    public void init() throws ServletException {
        cart = new ShoppingCartService();
        service = new PurchaseService();
        dao = new ProductDAO();
        list = new ArrayList<Item>();
    }
    
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("pay.jsp");

        if (request.getParameterNames().hasMoreElements()) {
            if (request.getParameter("buy") != null) {
                Item item = new Item();
                Product product = new Product();
                product = dao.getProduct(Long.parseLong(request.getParameter("ItemID")));
                
                int cant = Integer.parseInt(request.getParameter("cantidad"));
                double total = cant * product.getPrice();
                
                item.setAmount(cant);
                item.setSubtotal(product.getPrice() * cant);
                item.setProduct(product);
                
                list.add(item);
                
                //service.registerPurchase(total);
                
            }
            if (request.getParameter("buyAll") != null) {
                list = cart.getItems();
            }
        }
        
        request.setAttribute("list", list);
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //RequestDispatcher dispatcher = request.getRequestDispatcher("pay.jsp");
        //Never do this!!! 
        service.registerPurchase(Double.parseDouble(request.getParameter("total")));
        this.doGet(request, response);
        //dispatcher.forward(request, response);
    }

}
