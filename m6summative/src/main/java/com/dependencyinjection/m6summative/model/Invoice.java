package com.dependencyinjection.m6summative.model;

import java.util.Date;
import java.util.Objects;

public class Invoice {
    private int invoiceId;
    private int customerId;
    private Date orderDate;
    private Date pickupDate;
    private Date returnDate;
    private double lateFee;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public double getLateFee() {
        return lateFee;
    }

    public void setLateFee(double lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return getInvoiceId() == invoice.getInvoiceId() &&
                getCustomerId() == invoice.getCustomerId() &&
                Double.compare(invoice.getLateFee(), getLateFee()) == 0 &&
                getOrderDate().equals(invoice.getOrderDate()) &&
                getPickupDate().equals(invoice.getPickupDate()) &&
                getReturnDate().equals(invoice.getReturnDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getCustomerId(), getOrderDate(), getPickupDate(), getReturnDate(), getLateFee());
    }
}
