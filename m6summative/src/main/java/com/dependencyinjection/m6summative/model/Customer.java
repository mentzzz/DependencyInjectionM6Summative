package com.dependencyinjection.m6summative.model;

import java.util.Objects;

public class Customer {

    private int customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getCustomerId() == customer.getCustomerId() &&
                getFirstName().equals(customer.getFirstName()) &&
                getLastName().equals(customer.getLastName()) &&
                getEmail().equals(customer.getEmail()) &&
                getCompany().equals(customer.getCompany()) &&
                getPhone().equals(customer.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCustomerId(), getFirstName(), getLastName(), getEmail(), getCompany(), getPhone());
    }
}
