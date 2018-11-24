package com.company;

public class TaxValue {

    private String name;
    private double value;
    private double vatValue;
    private boolean isCost;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getVatValue() {
        return vatValue;
    }

    public void setVatValue(double vatValue) {
        this.vatValue = vatValue;
    }

    public void setCost(boolean cost) {
        isCost = cost;
    }

    public boolean isCost() {
        return isCost;
    }

}
