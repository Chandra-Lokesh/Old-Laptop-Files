package com.ust.ecomm.model;

public class Electronics extends Product {
    String brand;
    int warrantyPeriod;

    public Electronics(String productName, int productId, double price, int quantityInStock, String brand, int warrantyPeriod) {
        super(productName, productId, price, quantityInStock);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(",\nbrand='" + brand +
                ", \nwarrantyPeriod=" + warrantyPeriod +
                "\n}");
    }

    @Override
    public String toString() {
        return "Electronics{" +
                "brand='" + brand + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                "} " + super.toString();
    }
}
