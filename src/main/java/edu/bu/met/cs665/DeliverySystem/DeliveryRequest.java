package edu.bu.met.cs665.DeliverySystem;

/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 10/10/2023
 * File Name: DeliveryRequest.java
 * Description: this class is about making a deliveryRequest, and find the best driver for the order.
 */
public class DeliveryRequest {
    String product;
    String destination;
    String carType;
    Driver driver;
    boolean completed;
    int orderNumber;
    boolean pick = false;


    public DeliveryRequest(int orderNumber, String carType, String product, String destination) {
        this.destination = destination;
        this.driver = null;
        this.orderNumber = orderNumber;
        this.carType = carType;
        this.completed = false;
        this.product = product;

    }
    public int getOrderNumber() {
        return orderNumber;
    }

    public void picked() {
        pick = true;
    }

    public boolean checkStatus() {
        return pick;
    }

    public String getCar() {
        return carType;
    }

    public void complete() {
        completed = true;
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
    public void printInfo() {
        System.out.println("Product need to accept: " + product);
        System.out.println("Destination: " + destination);
        System.out.println("Require car type: " + carType);
        if(!completed){
            System.out.println("Status: not complete yet");
        }
        else{
            System.out.println("Status: complete");
        }
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