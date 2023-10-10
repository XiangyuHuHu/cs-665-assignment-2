package edu.bu.met.cs665;

import org.junit.Test;

import edu.bu.met.cs665.DeliverySystem.DeliveryRequest;
import edu.bu.met.cs665.DeliverySystem.Driver;
import edu.bu.met.cs665.DeliverySystem.Shop;

import java.util.List;

import static org.junit.Assert.*;

public class TestDelieverRequest {

    public TestDelieverRequest() {
    }

    @Test
    public void testAddDriver() {

        Shop shop = new Shop("Shop A");
        Driver[] drivers = new Driver[5];
        for (int i = 0; i < 5; i++) {
            drivers[i] = new Driver("Driver " + (i + 1), "Car");
            shop.addDriver(drivers[i]);
        }
        assertEquals(5, shop.getRiders().size());
    }

    @Test
    public void testAddDeliveryRequest() {
        Shop shop = new Shop("Shop A");
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car",  "Product X", "123 Main St");
        shop.addDeliveryRequest(deliveryRequest);

        assertEquals(1, shop.getOrders().size());
        assertEquals(deliveryRequest, shop.getOrders().get(0));
    }

    @Test
    public void testGetAvailableDrivers() {
        Shop shop = new Shop("Shop A");
        Driver driver1 = new Driver("Driver 1", "Car");
        Driver driver2 = new Driver("Driver 2", "Scooter");
        Driver driver3 = new Driver("Driver 3", "bike");
        Driver driver4 = new Driver("Driver 4", "Car");
        Driver driver5 = new Driver("Driver 5", "Car");
        // Mark driver2 as unavailable
        driver2.setUnavailable();
        shop.addDriver(driver1);
        shop.addDriver(driver2);
        shop.addDriver(driver3);
        shop.addDriver(driver4);
        shop.addDriver(driver5);

        List<Driver> availableDrivers = shop.getAvailableDrivers();
        assertEquals(4, availableDrivers.size());
        assertTrue(availableDrivers.contains(driver1));
        assertFalse(availableDrivers.contains(driver2));
        assertTrue(availableDrivers.contains(driver3));
    }
    @Test
    public void testGetOrderNumber() {
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car",  "Product X", "123 Main St");
        assertEquals(1, deliveryRequest.getOrderNumber());
    }

    @Test
    public void testCheckStatus() {
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car",  "Product X", "123 Main St");
        assertFalse(deliveryRequest.checkStatus());

        deliveryRequest.picked();
        assertTrue(deliveryRequest.checkStatus());
    }

    @Test
    public void testGetCar() {
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car",  "Product X", "123 Main St");
        assertEquals("Car", deliveryRequest.getCar());
    }

    @Test
    public void testComplete() {
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car",  "Product X", "123 Main St");
        assertFalse(deliveryRequest.isCompleted());
        deliveryRequest.complete();
        assertTrue(deliveryRequest.isCompleted());
    }

    @Test
    public void testGetDriver() {
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car",  "Product X", "123 Main St");
        assertNull(deliveryRequest.getDriver());

        Driver driver = new Driver("Driver 1", "Car");
        deliveryRequest.setDriver(driver);

        assertNotNull(deliveryRequest.getDriver());
        assertEquals(driver, deliveryRequest.getDriver());
    }
    @Test
    public void testIsAvailableInitially() {
        Driver driver = new Driver("Driver 1", "Car");
        assertTrue(driver.isAvailable());
    }

    @Test
    public void testSetUnavailable() {
        Driver driver = new Driver("Driver 1", "Car");
        driver.setUnavailable();
        assertFalse(driver.isAvailable());
    }

    @Test
    public void testSetOrder() {
        Driver driver = new Driver("Driver 1", "Car");
        assertNull(driver.getOrder());
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car", "Product X", "123 Main St");
        driver.setOrder(deliveryRequest);

        assertEquals(deliveryRequest, driver.getOrder());
    }

    @Test
    public void testDeliverOrder() {
        Driver driver = new Driver("Driver 1", "Car");
        DeliveryRequest deliveryRequest = new DeliveryRequest(1, "Car", "Product X", "123 Main St");
        driver.setOrder(deliveryRequest);

        // Deliver the order
        driver.deliverOrder();

        assertNull(driver.getOrder());
    }

    @Test
    public void testIsAvailableAndMatchesCarType() {
        Driver driver = new Driver("Driver 1", "Car");
        assertTrue(driver.isAvailableAndMatchesCarType("Car"));
        assertFalse(driver.isAvailableAndMatchesCarType("Scooter"));
    }

    @Test
    public void testGetName() {
        Driver driver = new Driver("Driver 1", "Car");
        assertEquals("Driver 1", driver.getName());
    }





}
