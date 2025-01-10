package com.ust.ecomm.service;

import com.ust.ecomm.model.Product;

public interface CartService {

    public void addToCart(Product product);

    public void viewAllCartItems();

    public double calculateTotalPrice();

    public void applyDiscount();

    public boolean isDuplicate(Product p);

}