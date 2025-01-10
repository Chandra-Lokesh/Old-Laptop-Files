package com.ust.ecomm.model;

public class Clothing extends Product {
    private Size size;
    private String material;

    public Clothing(String productName, int productId, double price, int quantityInStock, Size size, String material) {
        super(productName, productId, price, quantityInStock);
        this.size = size;
        this.material = material;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println(", \nsize=" + size +
                ", \nmaterial='" + material +
                "\n}");
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size=" + size +
                ", material='" + material + '\'' +
                "} " + super.toString();
    }
}
