package com.company;

public class Salary {

    private String name;
    private double salary;
    private double salaryVatValue;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalaryVatValue() {
        return salaryVatValue;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalaryVatValue(double salaryVatValue) {
        this.salaryVatValue = salaryVatValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
