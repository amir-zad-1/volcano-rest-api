package com.upgrade.volcano.entity;

public class Customer extends Model {

    private int id;
    private String email;
    private String firstName;
    private String lastName;

    public Customer(String firstname, String lastname, String email) {
        firstName = firstname;
        lastName = lastname;
        this.email = email;

    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", firstName, lastName, email);
    }

}
