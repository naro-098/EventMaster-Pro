/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 15S-EQ2019NS
 */
public class Event {
    private String name;
    private String date;
    private String time;
    private String location;

    public Event(String name, String date, String time, String location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public String toCSV() {
        return name + "," + date + "," + time + "," + location;
    }

  public static void exportEvents(ArrayList<Event> events) {
    if (events.isEmpty()) {
    JOptionPane.showMessageDialog(null, "There are no events to export");
    return;
}

    FileWriter writer = null;
    try {
        writer = new FileWriter("files/events/events.csv");
        writer.write("Name,Date,Time,Location\n");
        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            String line = e.toCSV() + "\n";
            writer.write(line);
        }
        JOptionPane.showMessageDialog(null, "Events exported");
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error");
    } finally {
        if (writer != null) {
            try {
                writer.close();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
    }
}

}