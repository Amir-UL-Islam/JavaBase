package com.aiokleo.factory_method_pattern;

public class BeefBurger {
    public int productId;
    public boolean angus;
    public String addOns;
    public void prepare() {
        System.out.println("BeefBurger is preparing");
    }
}
