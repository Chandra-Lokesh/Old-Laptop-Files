package com.ust.ecomm.repository;

import com.ust.ecomm.model.Product;

import java.util.ArrayList;

public class ProductRepostioryImpl implements ProductRepository{

    int idx = 0;
    private ArrayList<Product> products = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        products.add(product);
    }

    @Override
    public ArrayList<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id){
        for(Product p: products){
            if(p.getProductId() == id){
                return p;
            }
        }
        return null;
    }
}
