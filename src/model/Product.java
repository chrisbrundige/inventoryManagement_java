package model;

import java.util.ArrayList;

public class Product {
    //private ArrayList<Part> associatedParts = new ArrayList<Part>();
    private int id;
    private String Name;
    private double price;
    private int stock;
    private int min;
    private int max;

    /**Constructor*/

    public Product( int id, String name, double price, int stock, int min, int max) {
        //this.associatedParts = associatedParts;
        this.id = id;
        Name = name;
        this.price = price;
        this.stock = stock;
        this.min = min;
        this.max = max;
    }

    /**
     * Special Functions
     */

    public void addAssociatedPart(Part part) {

    }

    public boolean deleteAssociatedPart(Part part) {

        return true;

    }




    /**
     * getters & setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
