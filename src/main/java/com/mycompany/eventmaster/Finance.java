/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster;

import javax.swing.JOptionPane;

/**
 *
 * @author HP 15S-EQ2019NS
 */

public class Finance {
    public void calculateProfit(double income, double expenses) {
        double profit = income - expenses;
        String message = "Incomes: $" + income + "- Expenses: $" + expenses + "\n" +
                         "Profit: $" + profit;
        JOptionPane.showMessageDialog(null, message, "Profits", JOptionPane.INFORMATION_MESSAGE);
    }
}

