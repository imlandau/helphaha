package com.androidtutorialshub.loginregister.activities;

/**
 * Instances of this class are objects that will be added to the cart.
 */
public class Item {
    // the price of the item
    private double price;
    // the number of items (the number of times the item should be added to the cart)
    private int quantity;
    // the name of the item
    private String name;

    /**
     * The default constructor for an Item
     */
    Item() {
        this.price = 0;
        this.quantity = 0;
        this.name = "";
    } // end default Item constructor

    /**
     * Constructs an item object that can be added to the cart
     * @param price The price of the item
     * @param name The name of the item
     */
    Item(double price, int quantity, String name) {
        this.price = price;
        this.quantity = quantity;
        this.name = name;
    } // end Item constructor

    public double getPrice() {
        return price;
    } // end getPrice

    public int getQuantity() {
        return quantity;
    } // end getQuantity

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    } // end setQuantity

    public String getName() {
        return name;
    } // end getName

    public String toString() {
        return this.name + "\nQuantity: " + this.quantity + "Price per unit: " +
                this.price + "\nSubtotal: $" + this.price*this.quantity + "\n\n";
    } // end toString

} // end class
