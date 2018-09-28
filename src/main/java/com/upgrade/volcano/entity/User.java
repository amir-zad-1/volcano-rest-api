package com.upgrade.volcano.entity;

public class User extends Model {


    private int id;
    private String email;
    private String firstName;
    private String lastName;

    public User(int id, String firstname, String lastname, String email) {
        firstName = firstname;
        lastName = lastname;
        this.email = email;
        this.id = id;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s (%s)", firstName, lastName, email);
    }

}
