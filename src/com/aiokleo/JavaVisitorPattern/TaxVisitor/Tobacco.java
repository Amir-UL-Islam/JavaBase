package com.aiokleo.JavaVisitorPattern.TaxVisitor;

public class Tobacco {
    // Basic Functionalities
    // But What if I need some extra functionality? Like Tax Count ?
    private double price;
    public Tobacco(double item){
        this.price = item;
    }
    public double getPrice() {
        return price;
    }
}
