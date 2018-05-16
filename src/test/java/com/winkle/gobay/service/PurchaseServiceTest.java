/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.service;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Argos
 */
public class PurchaseServiceTest {
    
    public PurchaseServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of registerPurchase method, of class PurchaseService.
     */
    @Test
    public void testRegisterPurchase() {
        System.out.println("registerPurchase");
        double total = 0.0;
        PurchaseService instance = new PurchaseService();
        instance.registerPurchase(total);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
