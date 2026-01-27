package com.aiokleo.JavaVisitorPattern.TaxVisitor;

import java.text.DecimalFormat;

public class TaxVisitor implements Visitor{

    DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public TaxVisitor() {
    }
    @Override
    public double visit(Liquor liquorItem) {
        return Double.parseDouble(decimalFormat.format(liquorItem.getPrice() * .18 + liquorItem.getPrice()));
    }

    @Override
    public double visit(Tobacco tobaccoItem) {
        return Double.parseDouble(decimalFormat.format(tobaccoItem.getPrice() * .32 + tobaccoItem.getPrice()));
    }

    @Override
    public double visit(Necessity necessityItem) {
        return Double.parseDouble(decimalFormat.format(necessityItem.getPrice() * .15 + necessityItem.getPrice()));
    }
}
