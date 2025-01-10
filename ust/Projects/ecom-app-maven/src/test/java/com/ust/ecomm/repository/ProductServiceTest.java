package com.ust.ecomm.repository;

import com.ust.ecomm.model.Product;
import com.ust.ecomm.service.ProductService;
import com.ust.ecomm.service.ProductServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    ProductRepostioryImpl productRepo;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void addProductTest(){
        //Given
        Product p1 = new Product("Samsung", 1, 80000.00, 100);
        //When
        Mockito.doNothing().when(productRepo).addProduct(p1);
        Mockito.when(productRepo.getProductById(1)).thenReturn(p1);
        //Then
        productService.addProduct(p1);
        //Verify
        Assertions.assertEquals(p1, productService.getProductById(1));
        Mockito.verify(productRepo, Mockito.times(1)).addProduct(p1);


    }
    public void viewAllProductsTest(){
        //Given
        //When
        //Then
        //
    }

}
