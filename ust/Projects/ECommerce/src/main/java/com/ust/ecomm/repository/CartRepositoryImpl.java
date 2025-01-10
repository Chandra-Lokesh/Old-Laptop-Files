package com.ust.ecomm.repository;

import com.ust.ecomm.model.Product;
import java.util.*;

public class CartRepositoryImpl implements CartRepository {

//    private Product products[] = new Product[10];
    private ArrayList<Product> products = new ArrayList<>();
    int currentIndex = 0;

    public void addProduct(Product product) {
//        products[currentIndex++] = product;
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
