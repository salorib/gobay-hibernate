/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.service;

import com.winkle.gobay.HibernateUtil;
import com.winkle.gobay.entity.Purchase;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Argos
 */
public class PurchaseService implements IPurchaseService{
    
    private Session session;
    private Transaction transaction;

    @Override
    public void registerPurchase(double total) {
        Purchase purchase = new Purchase();
        
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = null;
        
        purchase.setTotal(total);
        
        try{
            transaction = session.beginTransaction();
            session.save(purchase);
            transaction.commit();
        }catch(HibernateException e){
            transaction.rollback();
            e.printStackTrace();
        }finally{
            session.close();
        }
        
    }
    
}
