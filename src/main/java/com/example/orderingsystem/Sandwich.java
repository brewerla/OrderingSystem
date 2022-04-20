package com.example.orderingsystem;

public class Sandwich {

    private String size;
    private String bread;
    private String meat;
    private String cheese;
    private String veggies;
    private String sauce;



    public Sandwich(String size, String bread, String meat, String cheese, String veggies, String sauce) {
        this.size = size;
        this.bread = bread;
        this.meat = meat;
        this.cheese = cheese;
        this.veggies = veggies;
        this.sauce = sauce;
    }
    public Sandwich(String size) {
        this.size = size;

    }
    @Override
    public String toString(){return size + " " + bread + ": " + meat + " " + cheese + " " + veggies + " " + sauce;}
}//
