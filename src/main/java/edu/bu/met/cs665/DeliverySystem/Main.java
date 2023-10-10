package edu.bu.met.cs665.DeliverySystem;
/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: Main.java
 * Description: they main step for this program. some function is for test and check the correctness.
 */
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a shop
        Shop shop = new Shop("Shop A");

        // Create a delivery request
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car", "Product X", "123 Main St");

        // Add the delivery request to the shop
        shop.addDeliveryRequest(deliveryRequest);

        // List the orders in the shop
        System.out.println(deliveryRequest);
        deliveryRequest.printInfo();


        // Create drivers
        Driver driver1 = new Driver("Driver 1", "Car");
        Driver driver2 = new Driver("Driver 2", "Scooter");

        // Add drivers to the shop
        shop.addDriver(driver1);
        shop.addDriver(driver2);

        // List the drivers in the shop
        System.out.println("\nDrivers in " + shop.getName() + ":");
        shop.listDrivers();

        // Assign the delivery request to an available driver
        List<Driver> availableDrivers = shop.getAvailableDrivers();
        if (!availableDrivers.isEmpty()) {
            Driver assignedDriver = availableDrivers.get(0);
            assignedDriver.setOrder(deliveryRequest);
            deliveryRequest.setDriver(assignedDriver);
            System.out.println("\n" + assignedDriver.getName() + " has been assigned the delivery.");
        } else {
            System.out.println("\nNo available drivers to assign the delivery.");
        }

        // Simulate the delivery being completed
        if (deliveryRequest.getDriver() != null) {
            deliveryRequest.picked();
            deliveryRequest.complete();
            System.out.println("\nDelivery marked as completed for Order Number " + deliveryRequest.getOrderNumber());
        } else {
            System.out.println("\nDelivery could not be completed as no driver was assigned.");
        }
    }


}
