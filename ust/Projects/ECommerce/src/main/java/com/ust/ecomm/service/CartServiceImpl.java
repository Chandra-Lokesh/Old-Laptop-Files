package com.ust.ecomm.service;

import com.ust.ecomm.model.Clothing;
import com.ust.ecomm.model.Electronics;
import com.ust.ecomm.model.Product;
import com.ust.ecomm.repository.CartRepository;
import com.ust.ecomm.repository.CartRepositoryImpl;
import java.util.*;

public class CartServiceImpl implements CartService{

    private CartRepository cartRepo = new CartRepositoryImpl();

    public void addToCart(Product product) {
        cartRepo.addProduct(product);
    }

    public void viewAllCartItems() {
        ArrayList<Product> cartItems = cartRepo.getAllProducts();
        if(cartItems.isEmpty()){
            System.out.println("No Items in the Cart!");
            return;
        }

        for(Product p: cartItems){
            p.displayDetails();
        }
    }

    public double calculateTotalPrice() {
        double total = 0;
        ArrayList<Product> cartItems = cartRepo.getAllProducts();
        for(Product p: cartItems){
            total += p.getPrice();
        }
        return total;
    }

    public void applyDiscount() {
        ArrayList<Product> products = cartRepo.getAllProducts();
        double price;
        for(Product p: products){
            if(p instanceof Electronics){
                price = p.getPrice();
                price = price - price * 0.1;
                p.setPrice(price);
            } else if (p instanceof Clothing) {
                price = p.getPrice();
                price = price - price * 0.2;
                p.setPrice(price);
            }
        }
    }

    @Override
    public boolean isDuplicate(Product product) {
        ArrayList<Product> products = cartRepo.getAllProducts();
        for(Product p: products){
            if(p == null)
                break;
            if(product.getProductId() == p.getProductId())
                return true;
        }
        return false;
    }
}
