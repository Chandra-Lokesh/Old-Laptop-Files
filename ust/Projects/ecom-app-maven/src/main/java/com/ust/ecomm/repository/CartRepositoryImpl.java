package com.ust.ecomm.repository;

import com.ust.ecomm.model.Product;

import java.util.ArrayList;

public class CartRepositoryImpl implements CartRepository {

    private ArrayList<Product> products = new ArrayList<>();
    int currentIndex = 0;

    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProduct(int id) {
        for(Product p: products){
            if(p.getProductId() == id)
                return p;
        }
        return null;
    }

    public ArrayList<Product> getAllProducts() {
        return products;
    }

}
