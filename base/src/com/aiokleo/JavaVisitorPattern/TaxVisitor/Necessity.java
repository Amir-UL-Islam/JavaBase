package com.aiokleo.JavaVisitorPattern.TaxVisitor;

public class Necessity {
    // Basic Functionalities
    private double price;
    public Necessity(double item){
        this.price = item;
    }
    public double getPrice() {
        return price;
    }
    public void VisitedWithTaxVisitor(TaxVisitor taxVisitor){
        taxVisitor.visit(this);
    }
}
