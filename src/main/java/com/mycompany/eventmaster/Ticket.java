/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;
/**
 *
 * @author HP 15S-EQ2019NS
 */
public class Ticket {
    private ArrayList<String> ticketIDs;
    private ArrayList<Double> ticketValues;

    public Ticket() {
        ticketIDs = new ArrayList<>();
        ticketValues = new ArrayList<>();
    }

    public void assignTicket(String type, double value) {
        String ticketID = type + "-" + (ticketIDs.size() + 1);
        ticketIDs.add(ticketID);
        ticketValues.add(value);
        JOptionPane.showMessageDialog(null, "Ticket assigned: " + ticketID);
    }

    public boolean validateTicket(String ticketID) {
        for (int i = 0; i < ticketIDs.size(); i++) {
            if (ticketIDs.get(i).equals(ticketID)) {
                return true;
            }
        }
        return false;
    }

    public void exportToCSV() {
        FileWriter writer = null;
        try {
            writer = new FileWriter("files/tickets/tickets.csv");
            writer.write("TicketID,Value\n");
            for (int i = 0; i < ticketIDs.size(); i++) {
                String line = ticketIDs.get(i) + "," + ticketValues.get(i) + "\n";
                writer.write(line);
            }
            JOptionPane.showMessageDialog(null, "Tickets exported");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error exporting tickets");
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

    public double getTotalIncome() {
        double total = 0;
        for (int i = 0; i < ticketValues.size(); i++) {
            total += ticketValues.get(i);
        }
        return total;
    }
}
