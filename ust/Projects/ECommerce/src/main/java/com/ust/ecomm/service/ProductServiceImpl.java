package com.ust.ecomm.service;

import com.ust.ecomm.exception.ProductNotFoundException;
import com.ust.ecomm.model.Product;
import com.ust.ecomm.repository.ProductRepository;
import com.ust.ecomm.repository.ProductRepostioryImpl;
import java.util.*;

public class ProductServiceImpl implements ProductService{

    ProductRepository productRepo = new ProductRepostioryImpl();

    @Override
    public void addProduct(Product product) {
        productRepo.addProduct(product);
    }

    @Override
    public void viewAllProducts() {
        ArrayList<Product> products = productRepo.getAllProducts();
        for(Product p: products){
            p.displayDetails();
        }
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.getProductById(id);
    }

}
