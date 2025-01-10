package com.ust.ecomm.model;

public class Product {
    private String productName;
    private int productId;
    private double price;
    private int quantityInStock;

    public Product(String productName, int productId, double price, int quantityInStock){
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void displayDetails() {
        System.out.print("\n{" +
                " \nproductName='" + productName + '\'' +
                ", \nproductId=" + productId +
                ", \nprice=" + price +
                ", \nquantityInStock=" + quantityInStock);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productId=" + productId +
                ", price=" + price +
                ", quantityInStock=" + quantityInStock +
                '}';
    }
}
