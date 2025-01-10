package com.ust.ecomm;

import com.ust.ecomm.exception.CheckProductExceptions;
import com.ust.ecomm.exception.DuplicateProductException;
import com.ust.ecomm.exception.InvalidProductIdException;
import com.ust.ecomm.exception.ProductNotFoundException;
import com.ust.ecomm.model.*;
import com.ust.ecomm.service.CartService;
import com.ust.ecomm.service.CartServiceImpl;
import com.ust.ecomm.service.ProductService;
import com.ust.ecomm.service.ProductServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DuplicateProductException, ProductNotFoundException{

        Scanner sc = new Scanner(System.in);

        ProductService productService = new ProductServiceImpl();
        CartService cartService = new CartServiceImpl();

        // Electronics
        Product p1 = new Electronics("iPhone 15", 1, 90000.00, 123, "Apple", 3);
        Product p2 = new Electronics("Macbook Pro", 2, 170000.00, 55, "Apple", 2);

        // Clothing
        Product p3 = new Clothing("T-Shirt", 3, 400.00, 200, Size.MEDIUM, "Cotton");
        Product p4 = new Clothing("Hoodie", 4, 800.00, 120, Size.X_LARGE, "Cotton");

        CheckProductExceptions.checkExceptions(p1);
        productService.addProduct(p1);

        CheckProductExceptions.checkExceptions(p2);
        productService.addProduct(p2);

        CheckProductExceptions.checkExceptions(p3);
        productService.addProduct(p3);

        CheckProductExceptions.checkExceptions(p4);
        productService.addProduct(p4);

//        System.out.println(p1.toString());
//        System.out.println(p2.toString());
//        System.out.println(p3.toString());
//        System.out.println(p4.toString());

        while(true){
            System.out.println("Welcome to my shopping app:\n" +
                    "1: View all products\n" +
                    "2: Add product to cart\n" +
                    "3: View cart\n" +
                    "4: Exit\n" +
                    "Select an option:\n");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    productService.viewAllProducts();
                    break;
                case 2:
                    System.out.println("Enter product id: ");
                    int id = sc.nextInt();
                    if(id < 0)
                        throw new InvalidProductIdException("Product Id should be Positive!");
                    Product newCartItem = productService.getProductById(id);
                    if(newCartItem != null){
                        if(cartService.isDuplicate(newCartItem)){
                            throw new DuplicateProductException("Product Exist in Cart!");
                        }
                        else{
                            cartService.addToCart(newCartItem);
                        }
                    }
                    else{
                        throw new ProductNotFoundException("Product Not Found!");
                    }
                    break;
                case 3:
                    cartService.viewAllCartItems();
                    double totalAmount = cartService.calculateTotalPrice();
                    System.out.println("Total Amount Before Discount: " + totalAmount);

                    cartService.applyDiscount();

                    double discountedAmount = cartService.calculateTotalPrice();
                    System.out.println("Total Amount After Discount: " + discountedAmount);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Enter valid option");
            }
        }

    }
}