package edu.bu.met.cs665.DeliverySystem;

/**
 * Name: Xiangyu Hu
 * Course: CS-665 Software Designs & Patterns
 * Date: 02/20/2023
 * File Name: Shop.java
 * Description: This class is for create a shop. add driver and add orders.
 */
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private String name;
    private ArrayList<DeliveryRequest> orders = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
    }

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(this, message);
        }
    }

    public void addDeliveryRequest(DeliveryRequest deliveryRequest) {
        orders.add(deliveryRequest);
        notifyObservers("New delivery request added: " + deliveryRequest.getProduct());
    }


    public ArrayList<Observer> getRiders() {
        return this.observers ;
    }

    public ArrayList<DeliveryRequest>getOrders() {
        return orders;
    }

    public String getName() {
        return name;
    }

    public void listDrivers() {
        for (Observer observer : this.observers) {
            if (observer instanceof Driver) {
                Driver driver = (Driver) observer;
                System.out.println("Driver: " + driver.getName());
            }
        }
    }
    public void addDriver(Driver driver) {
        this.observers .add(driver);
    }
    public List<Observer> getAvailableDrivers() {
        List<Observer> availableDrivers = new ArrayList<>();
        for (Observer observer : this.observers) {
            if (observer instanceof Driver) {
                Driver driver = (Driver) observer;
                if (driver.isAvailable()) {
                    availableDrivers.add(driver);
                }
            }
        }
        return availableDrivers;
    }
}
