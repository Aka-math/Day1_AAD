package com.example.myapplication.javaexs;

public class Gst extends IncomeTax{

    Calculator calculator; //declaration

    @Override  //redefine
    public int calculateTax(int income) {
        calculator = new Calculator();  //instantiation
        calculator.someValue = 123;    //initialization
        int oldtax = super.calculateTax(income);
        int newTax = 1000;
        int gst = oldtax + newTax;
        return  gst;
    }
}
