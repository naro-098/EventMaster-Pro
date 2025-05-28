/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 15S-EQ2019NS
 */
public class Location implements Validator {
    private class LocationInfo {
        int capacity;
        double price;
        public LocationInfo(int capacity, double price) {
            this.capacity = capacity;
            this.price = price;
        }
    }

    private HashMap<String, LocationInfo> locations = new HashMap<>();

    public Location() {
        locations.put("Plaza Mayor", new LocationInfo(2000, 1000000));
        locations.put("La Macarena", new LocationInfo(1500, 750000));
        locations.put("Club Unión", new LocationInfo(200, 500000));
        locations.put("Estadio Atanasio Girardot", new LocationInfo(45000, 2500000));
        locations.put("Aeroparque Juan Pablo II", new LocationInfo(3000, 3500000));
        locations.put("Teatro Universidad de Medellín", new LocationInfo(1500, 1800000));
        locations.put("Parque Norte", new LocationInfo(1800, 7500000));
    }
    
    public void addLocation(String name, int capacity, double price) {
        if (locations.containsKey(name)) {
            JOptionPane.showMessageDialog(null, "Location already exists.", "Add Location", JOptionPane.WARNING_MESSAGE);
        } else {
            locations.put(name, new LocationInfo(capacity, price));
            JOptionPane.showMessageDialog(null, "Location added", "Add Location", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public boolean isAvailable(String locationName) {
        return locations.containsKey(locationName);
    }

    public double getLocationPrice(String locationName) {
        return locations.get(locationName).price;
    }

   public void showLocations() {
    String text = "";
    Object[] keys = locations.keySet().toArray();
    for (int i = 0; i < keys.length; i++) {
        String locationName = (String) keys[i];
        LocationInfo info = locations.get(locationName);
        text = text + "Location: " + locationName+ ", capacity: " + info.capacity+ ", price: " + info.price+ "\n";
    }
    JOptionPane.showMessageDialog(null, text, "Locations", JOptionPane.INFORMATION_MESSAGE);
}


}
