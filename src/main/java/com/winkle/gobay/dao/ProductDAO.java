/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.dao;

import com.winkle.gobay.HibernateUtil;
import com.winkle.gobay.entity.Product;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Argos
 */
public class ProductDAO implements IProductDAO {

    private Session session;
    private Transaction transaction;

    @Override
    public void addProduct(Product product) {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        try {
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();

        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = new Product();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        try {
            transaction = session.beginTransaction();
            product = (Product) session.get(Product.class, id);
            session.delete(product);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public Product getProduct(Long id) {
        Product product = new Product();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        try {
            transaction = session.beginTransaction();
            product = (Product) session.get(Product.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        
        return product;
    }

    @Override
    public List<Product> getProducts() {
        List<Product> catalog = new ArrayList<Product>();
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;

        try {
            transaction = session.beginTransaction();
            catalog = session.createQuery("from Product").list();
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return catalog;
    }

}
