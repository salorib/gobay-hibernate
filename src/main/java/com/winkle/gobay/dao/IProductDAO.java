/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.dao;

import com.winkle.gobay.entity.Product;
import java.util.List;

/**
 *
 * @author Argos
 */
public interface IProductDAO {
    void addProduct(Product product);
    void deleteProduct(Long id);
    Product getProduct(Long id);
    List<Product> getProducts();
}
