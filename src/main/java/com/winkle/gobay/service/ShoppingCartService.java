/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.service;

import com.winkle.gobay.HibernateUtil;
import com.winkle.gobay.entity.Item;
import com.winkle.gobay.entity.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Argos
 */
public class ShoppingCartService implements IShoppingCartService {

    private Session session;
    private Transaction transaction;

    @Override
    public void addItems(Product product, int amount) {
        Item item = new Item();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        item.setProduct(product);
        item.setAmount(amount);
        item.setSubtotal(amount * product.getPrice());
        product.getItems().add(item);
        
        Hibernate.initialize(item.getProduct());
        

        try {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteItems(Long id) {
        Item item = new Item();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        try {
            transaction = session.beginTransaction();
            //item = (Item) session.createQuery("from item where id_producto = "+ id).uniqueResult();
            item = (Item) session.get(Item.class, id);
            session.delete(item);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Item> getItems() {
        List<Item> cart = new ArrayList<Item>();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        try {
            transaction = session.beginTransaction();
            cart = session.createQuery("from Item").list();
            
            for(Item item : cart){
                Hibernate.initialize(item.getProduct());
            }//*/
            
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return cart;
    }

}
