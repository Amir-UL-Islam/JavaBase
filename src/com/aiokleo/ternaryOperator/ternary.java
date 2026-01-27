package com.aiokleo.ternaryOperator;

import com.sun.source.tree.IfTree;

public class ternary {
    public void IfElse() {
        int income = 2000;
        String Category = "Economical";

        if (income > 2000){
            Category = "FirstClass";
        }
    }

    public void ternaryIfElse(){
        int income = 2000;
        String Category = income > 2000 ? "FirstClass" : "Economical";
    }

    public static void main(String[] args) {
        ternary ifElse = new ternary();
        ifElse.IfElse();

        ternary ternary = new ternary();
        ternary.ternaryIfElse();
    }

}
