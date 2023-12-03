package edu.bu.met.cs665.DeliverySystem;

public interface Observer {
    void update(Shop shop, String updateMessage);
}