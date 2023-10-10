package edu.bu.met.cs665.DeliverySystem;
/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: Driver.java
 * Description: this class is about set the driver information.
 */
public class Driver {
    DeliveryRequest order;
    String name;
    boolean isAvailable;
    String carType;

    public Driver(String nn, String cc) {
        name = nn;
        carType = cc.toLowerCase();
        isAvailable = true;
    }
    public boolean isAvailable() {
        return this.isAvailable;
    }

    public void setAvailable(boolean b) {
        this.isAvailable = true;
    }

    public void setUnavailable() {
        this.isAvailable = false;
    }
    public DeliveryRequest getOrder() {
        return this.order;
    }

    public void setOrder(DeliveryRequest oo) {
        this.order = oo;
    }
    public void deliverOrder() {
        if (order != null) {
            System.out.println("Delivering order: " + order.getProduct() + " to " + order.getDestination());
            order = null;  // Reset the order after delivery
        } else {
            System.out.println("No order assigned for delivery.");
        }
    }
    public boolean isAvailableAndMatchesCarType(String desiredCarType) {
        return isAvailable && carType.equalsIgnoreCase(desiredCarType);
    }

    public String getName() {
        return name;
    }
}
