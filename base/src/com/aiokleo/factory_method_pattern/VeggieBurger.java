package com.aiokleo.factory_method_pattern;

public class VeggieBurger {
    public int productId;
    public boolean combos;
    public String addOns;
    public void prepare() {
        System.out.println("VeggieBurger is preparing");
    }
}
