package com.dependencyinjection.m6summative.controller;

import com.dependencyinjection.m6summative.dao.CustomerDao;
import com.dependencyinjection.m6summative.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerDao customerDao;

    @RequestMapping(value="/customer", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer) {
        customerDao.addCustomer(customer);
        return customer;
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable(name="id") int id) {
        return customerDao.getCustomer(id);
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer, @PathVariable(name = "id") int id) {
        if (id != customer.getCustomerId()) {
            throw new IllegalArgumentException("Customer ID on path must match the ID in the Customer object.");
        }
        customerDao.updateCustomer(customer);
    }

    @RequestMapping(value="/customer/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable(name = "id") int id) {
        customerDao.deleteCustomer(id);
    }

    @RequestMapping(value="/customer", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomers();
    }

}
