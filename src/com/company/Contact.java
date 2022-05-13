package com.company;

public class Contact {
    private String name;
    private String mobileNumber;

    public Contact(String name, String mobileNumber) {
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }
}
