package com.example.jurguenzambrano.mycustomers;

/**
 * Created by Jurguen Zambrano on 2/04/2017.
 */

public class Customer {
    private String name;
    private String title;
    private String company;
    private String contact;
    private String address;
    private int pictureId;
    private double latitud;
    private double altitud;

    public Customer(String name, String title, String company, String contact, String address, double latitud, double altitud, int pictureId) {
        this.contact = contact;
        this.company = company;
        this.name = name;
        this.address = address;
        this.title = title;
        this.pictureId = pictureId;
        this.latitud = latitud;
        this.altitud = altitud;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getAltitud() {
        return altitud;
    }

    public void setAltitud(double altitud) {
        this.altitud = altitud;
    }
}
