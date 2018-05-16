/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.controller;

import com.winkle.gobay.dao.ProductDAO;
import com.winkle.gobay.entity.Product;
import com.winkle.gobay.service.ShoppingCartService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Argos
 */
public class ShoppingCartController extends HttpServlet {

    private ShoppingCartService service;
    private ProductDAO dao;
    private Product product;

    @Override
    public void init() throws ServletException {
        service = new ShoppingCartService();
        dao = new ProductDAO();
        product = new Product();
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("shoppingcart.jsp");

        if (request.getParameterNames().hasMoreElements()) {
            if (request.getParameter("add") != null) {

                int cantidad = Integer.parseInt(request.getParameter("cantidad"));
                product = dao.getProduct(Long.parseLong(request.getParameter("ItemID")));
                service.addItems(product, cantidad);

            }
            if (request.getParameter("delete") != null) {
                service.deleteItems(Long.parseLong(request.getParameter("ItemID")));
            }
        }

        request.setAttribute("listCompra", service.getItems());
        dispatcher.forward(request, response);

    }

}
