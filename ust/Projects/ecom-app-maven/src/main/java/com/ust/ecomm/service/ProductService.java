package com.ust.ecomm.service;

import com.ust.ecomm.model.Product;

public interface ProductService {
    public void addProduct(Product product);
    public void viewAllProducts();
    public Product getProductById(int id);

}
