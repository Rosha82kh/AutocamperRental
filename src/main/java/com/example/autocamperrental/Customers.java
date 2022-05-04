package com.example.autocamperrental;

public class Customers {
    String first_name,last_name,driving_license,phone_no,Email,city;

    public Customers() {
    }
    public Customers(String first_name, String last_name, String driving_license, String phone_no, String email, String city) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.driving_license = driving_license;
        this.phone_no = phone_no;
        Email = email;
        this.city = city;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
