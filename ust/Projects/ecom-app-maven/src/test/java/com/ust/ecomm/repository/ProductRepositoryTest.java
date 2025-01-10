package com.ust.ecomm.repository;

import com.ust.ecomm.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class ProductRepositoryTest {

    ProductRepository productRepo = new ProductRepostioryImpl();

    @Test
    public void addProductTest(){
        Product p1 = new Product("Samsung", 1, 80000.00, 100);
        Product p2 = new Product("Samsung TV", 2, 120000.00, 500);
        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
        Assertions.assertEquals(2, productRepo.getAllProducts().size());
        Assertions.assertEquals(p2, productRepo.getProductById(2));
    }

    @Test
    public void getAllProductsTest(){
        Product p1 = new Product("Nokia", 3, 30000.00, 50);
        Product p2 = new Product("LG TV", 4, 120000.00, 200);
        productRepo.addProduct(p1);
        productRepo.addProduct(p2);
        Assertions.assertEquals(2, productRepo.getAllProducts().size());
    }

}
