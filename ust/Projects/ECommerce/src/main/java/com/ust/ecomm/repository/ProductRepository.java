package com.ust.ecomm.repository;

import com.ust.ecomm.exception.ProductNotFoundException;
import com.ust.ecomm.model.Product;
import java.util.*;

public interface ProductRepository {
    public void addProduct(Product product);
    public ArrayList<Product> getAllProducts();
    public Product getProductById(int id);
}
