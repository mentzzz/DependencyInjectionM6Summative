package com.dependencyinjection.m6summative.viewmodel;

import com.dependencyinjection.m6summative.model.Customer;
import com.dependencyinjection.m6summative.model.InvoiceItem;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class InvoiceViewModel {
    private int invoiceId;
    private Date orderDate;
    private Date pickupDate;
    private Date returnDate;
    private double lateFee;
    private Customer customer;
    private List<InvoiceItem> invoiceItems = new ArrayList<>();

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
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

    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceViewModel that = (InvoiceViewModel) o;
        return getInvoiceId() == that.getInvoiceId() &&
                Double.compare(that.getLateFee(), getLateFee()) == 0 &&
                getOrderDate().equals(that.getOrderDate()) &&
                getPickupDate().equals(that.getPickupDate()) &&
                getReturnDate().equals(that.getReturnDate()) &&
                getCustomer().equals(that.getCustomer()) &&
                getInvoiceItems().equals(that.getInvoiceItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getInvoiceId(), getOrderDate(), getPickupDate(), getReturnDate(), getLateFee(), getCustomer(), getInvoiceItems());
    }
}
