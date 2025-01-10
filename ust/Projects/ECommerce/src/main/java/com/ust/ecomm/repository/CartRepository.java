package com.ust.ecomm.repository;

import com.ust.ecomm.model.Product;

import java.util.ArrayList;

public interface CartRepository {

    public void addProduct(Product product);

    public Product findProduct(int id);

    public ArrayList<Product> getAllProducts();

}
