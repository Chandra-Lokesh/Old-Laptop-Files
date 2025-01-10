package com.ust.ecomm.exception;

import com.ust.ecomm.model.Product;

public class CheckProductExceptions {
    public static void checkExceptions(Product p){
        if(p.getProductId() < 0)
            throw new InvalidProductIdException("Product Id should be Positive!");
        if(p.getProductName() == null || p.getProductName().strip().equals(""))
            throw new NullProductNameException("Give Product Name!");
        if(p.getPrice() < 0)
            throw new InvalidProductPriceException("Price should be Positive!");



    }
}
