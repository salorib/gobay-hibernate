/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.dao;

import com.winkle.gobay.entity.Product;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author Argos
 */
public class ProductDAOTest {
    
    private List<Product> expResult;
    private Product expResultProduct;
    
    public ProductDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        ProductDAO instance = new ProductDAO();
        expResult = instance.getProducts();
        expResultProduct = instance.getProduct(Long.parseLong("2"));
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addProduct method, of class ProductDAO.
     */
    /*@org.junit.Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = new Product();
            product.setId(Long.parseLong("1"));
            product.setName("Product 1");
            product.setPrice(99.99);
        ProductDAO instance = new ProductDAO();
        instance.addProduct(product);
        // TODO review the generated test code and remove the default call to fail.
    }//*/

    /**
     * Test of deleteProduct method, of class ProductDAO.
     */
   /* @org.junit.Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        Long id = null;
        ProductDAO instance = new ProductDAO();
        instance.deleteProduct(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }//*/

    /**
     * Test of getProduct method, of class ProductDAO.
     */
    @org.junit.Test
    public void testGetProduct() {
        System.out.println("getProduct");
        Long id = Long.parseLong("2");
        ProductDAO instance = new ProductDAO();
        //Product expResult = null;
        Product result = instance.getProduct(id);
    
        System.out.println(result.toString() + " " + expResultProduct.toString());
        
        assertEquals(expResultProduct, result);
        // TODO review the generated test code and remove the default call to fail.
    }//*/

    /**
     * Test of getProducts method, of class ProductDAO.
     */
    /*@org.junit.Test
    public void testGetProducts() {
        System.out.println("getProducts");
        ProductDAO instance = new ProductDAO();
        //List<Product> expResult = null;
        List<Product> result = instance.getProducts();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }//*/
    
}
