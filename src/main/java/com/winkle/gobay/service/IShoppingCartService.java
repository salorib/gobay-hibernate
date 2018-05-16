/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.winkle.gobay.service;

import com.winkle.gobay.entity.Item;
import com.winkle.gobay.entity.Product;
import java.util.List;

/**
 *
 * @author Argos
 */
public interface IShoppingCartService {
    void addItems(Product product, int amount);
    void deleteItems(Long id);
    List<Item> getItems();
}
