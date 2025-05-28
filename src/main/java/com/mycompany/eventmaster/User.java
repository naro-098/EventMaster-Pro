/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.eventmaster;

/**
 *
 * @author HP 15S-EQ2019NS
 */
public abstract class User {

    protected String name;
    protected String contact;
    protected String technicalRequirements;

    public User(String name, String contact, String technicalRequirements) {
        this.name = name;
        this.contact = contact;
        this.technicalRequirements = technicalRequirements;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getTechnicalRequirements() {
        return technicalRequirements;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setTechnicalRequirements(String technicalRequirements) {
        this.technicalRequirements = technicalRequirements;
    }
}
