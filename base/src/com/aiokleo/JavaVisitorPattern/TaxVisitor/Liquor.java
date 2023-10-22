package com.aiokleo.JavaVisitorPattern.TaxVisitor;

public class Liquor {
    // Basic Functionalities
    private double price;
    public Liquor(double item){
        this.price = item;
    }
    public double getPrice() {
        return price;
    }
}
