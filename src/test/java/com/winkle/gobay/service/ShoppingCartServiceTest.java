/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.service;

import com.winkle.gobay.entity.Item;
import com.winkle.gobay.entity.Product;
import java.util.List;
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
public class ShoppingCartServiceTest {
    
    //private Item expResult;
    private List<Item> expResult;
    private ShoppingCartService service;
    
    public ShoppingCartServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        service = new ShoppingCartService();
        //expResult = service.getItem(Long.parseLong("18"));
        expResult = service.getItems();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addItems method, of class ShoppingCartService.
     */
    /*@Test
    public void testAddItems() {
        System.out.println("addItems");
        Product product = null;
        int amount = 0;
        ShoppingCartService instance = new ShoppingCartService();
        instance.addItems(product, amount);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }//*/

    /**
     * Test of deleteItems method, of class ShoppingCartService.
     */
    /*@Test
    public void testDeleteItems() {
        System.out.println("deleteItems");
        Long id = null;
        ShoppingCartService instance = new ShoppingCartService();
        instance.deleteItems(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }//*/

    /**
     * Test of getItems method, of class ShoppingCartService.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        ShoppingCartService instance = new ShoppingCartService();
        //List<Item> expResult = null;
        List<Item> result = instance.getItems();
        for(Item item : result){
            System.out.println(item.toString());
        }
        for(Item item : expResult){
            System.out.println(item.toString());
        }
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }//*/

    /**
     * Test of getItem method, of class ShoppingCartService.
     */
    /*@Test
    public void testGetItem() {
        System.out.println("getItem");
        Long id = Long.parseLong("18");
        ShoppingCartService instance = new ShoppingCartService();
        
        Item result = instance.getItem(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }//*/
    
}
