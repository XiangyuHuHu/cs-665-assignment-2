package edu.bu.met.cs665.DeliverySystem;

/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/20/2023
 * File Name: Shop.java
 * Description: This file is mainly about the shop object, which can hire
 * the driver and post the order to the driver.
 */
import java.util.ArrayList;
import java.util.List;

public class Shop {
    public String name;
    ArrayList<DeliveryRequest> orders = new ArrayList<DeliveryRequest>();
    ArrayList<Driver> riders = new ArrayList<Driver>();
    public static int orderNumber = 1;


    public Shop(String name) {
        this.name = name;
    }

    public ArrayList<Driver> getRiders() {
        return this.riders;
    }

    public ArrayList<DeliveryRequest>getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }

    public void listDrivers() {
        for (Driver driver : this.riders) {
            System.out.println("Driver: " + driver.getName());
        }
    }
    public void addDriver(Driver driver) {
        this.riders.add(driver);
    }
    public void listOrders() {
        for (DeliveryRequest order : orders) {
            order.show();  // Display order details
        }
    }
    public void addDeliveryRequest(DeliveryRequest deliveryRequest) {
        // Assign a unique order number to the delivery request
        deliveryRequest.setOrderNumber(orderNumber++);
        orders.add(deliveryRequest);
    }
    public List<Driver> getAvailableDrivers() {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : this.riders) {
            if (driver.isAvailable()) {
                availableDrivers.add(driver);
            }
        }
        return availableDrivers;
    }
}
