/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.eventmaster;

import java.util.Scanner;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP 15S-EQ2019NS
 */
public class Main {

    public static void main(String[] args) {
        Location loc = new Location();
        ArrayList<Event> events = new ArrayList<>();
        Ticket ticketManager = new Ticket();
        Finance finance = new Finance();

        int option = 0;
        do {
            String input = JOptionPane.showInputDialog("Welcome to EventMaster Pro\n 1. Add event\n 2. Add location\n 3. Show locations\n 4. Export events\n 5. Assign ticket\n 6. Validate ticket\n 7. Export tickets\n 8. Show profits\n 9. Exit\n Choose an option: "
            );

            if (input == null) {
                option = 9;
            } else {
                try {
                    option = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid option");
                    continue;
                }
            }

            switch (option) {
                case 1: {
                    String name = JOptionPane.showInputDialog("Event name: ");
                    String date = JOptionPane.showInputDialog("Date (YYYYMMDD): ");
                    String time = JOptionPane.showInputDialog("Time: ");
                    String location = JOptionPane.showInputDialog("Location: ");

                    if (!loc.isAvailable(location)) {
                        int opt = JOptionPane.showConfirmDialog(null,"Location doesn't exist. Do you want to register it?", "Add Location",JOptionPane.YES_NO_OPTION);
                        if (opt == JOptionPane.YES_OPTION) {
                            String capacityStr = JOptionPane.showInputDialog("Capacity: ");
                            String priceStr = JOptionPane.showInputDialog("Price: ");
                            try {
                                int capacity = Integer.parseInt(capacityStr);
                                double price = Double.parseDouble(priceStr);
                                loc.addLocation(location, capacity, price);
                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Invalid capacity or price.");
                                break; 
                            }
                        } else {
                            break; 
                        }
                    }

                    boolean locationExists = false;
                    for (int i = 0; i < events.size(); i++) {
                        Event e = events.get(i);
                        if (e.getLocation().equalsIgnoreCase(location) && e.getDate().equalsIgnoreCase(date)) {
                            locationExists = true;
                            break;
                        }
                    }

                    if (locationExists) {
                        JOptionPane.showMessageDialog(null, "Event already exists");
                        break;
                    }

                    events.add(new Event(name, date, time, location));
                    JOptionPane.showMessageDialog(null, "Event added");
                }
                break;

                case 2: {
                    String locName = JOptionPane.showInputDialog("Location name: ");
                    if (locName == null) {
                        break;
                    }
                    String capacityStr = JOptionPane.showInputDialog("Capacity: ");
                    if (capacityStr == null) {
                        break;
                    }
                    String priceStr = JOptionPane.showInputDialog("Price: ");
                    if (priceStr == null) {
                        break;
                    }

                    try {
                        int capacity = Integer.parseInt(capacityStr);
                        double price = Double.parseDouble(priceStr);
                        loc.addLocation(locName, capacity, price);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value");
                    }
                    break;
                }

                case 3:
                    loc.showLocations();
                    break;

                case 4:
                    Event.exportEvents(events);
                    break;

                case 5: {
                    String type = JOptionPane.showInputDialog("Ticket type: ");
                    if (type == null) {
                        break;
                    }
                    String valueStr = JOptionPane.showInputDialog("Value: ");
                    if (valueStr == null) {
                        break;
                    }

                    try {
                        double value = Double.parseDouble(valueStr);
                        ticketManager.assignTicket(type, value);
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid value");
                    }
                    break;
                }

                case 6: {
                    String id = JOptionPane.showInputDialog("Enter ticketID: ");
                    if (id == null) {
                        break;
                    }

                    boolean isValid = ticketManager.validateTicket(id);
                    if (isValid) {
                        JOptionPane.showMessageDialog(null, "Valid ticket");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid ticket");
                    }
                    break;
                }

                case 7:
                    ticketManager.exportToCSV();
                    break;

                case 8: {
                    double expenses = 0;

                    for (int i = 0; i < events.size(); i++) {
                        Event e = events.get(i);
                        if (loc.isAvailable(e.getLocation())) {
                            double priceLoc = loc.getLocationPrice(e.getLocation());
                            expenses = expenses + priceLoc;
                        }
                    }

                    double income = ticketManager.getTotalIncome();
                    finance.calculateProfit(income, expenses);
                    break;
                }

                case 9:
                    JOptionPane.showMessageDialog(null, "Exiting");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option");
            }
        } while (option != 9);
    }
}
