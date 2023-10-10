package edu.bu.met.cs665.DeliverySystem;

/**
 * Name: Yibo Bao
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/20/2023
 * File NameL DelieveryRequest.java
 * Description: This file is mainly about the delievery order, in this
 * file we can acces the details of orders created by the shop.
 * For example, if the order had been picked up by other driver,it
 * can not be pick up by other driver.
 */
public class DeliveryRequest {
    String product;
    String destination;
    String carType;
    Driver driver;
    boolean completed;
    int orderNumber;
    String poster;
    static boolean pick = false;


    public DeliveryRequest(int orderNumber, String carType, String poster, String product, String destination) {
        this.destination = destination;
        this.driver = null;
        this.orderNumber = orderNumber;
        this.carType = carType;
        this.completed = false;
        this.poster = poster;
        this.product = product;

    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public void picked() {
        pick = true;
    }

    public boolean checkStatus() {
        if (!pick) {
            return false;
        }
        return true;
    }

    public String getCar() {
        return carType;
    }

    public void complete() {
        completed = true;
    }

    public void show() {
        System.out.println("Poster: " + poster);
        System.out.println("Order Number: " + orderNumber);
        System.out.println("Car: " + carType);
    }

    public String getProduct() {
        return null;
    }

    public String getDestination() {
        return null;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setOrderNumber(int i) {
    }

    public void setDriver(Driver uu) {
        driver = uu;
    }

    public Driver getDriver() {
        return driver;
    }
}