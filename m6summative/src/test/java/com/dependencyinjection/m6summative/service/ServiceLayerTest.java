package com.dependencyinjection.m6summative.service;

import com.dependencyinjection.m6summative.dao.*;
import com.dependencyinjection.m6summative.model.Customer;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;


public class ServiceLayerTest {

    ServiceLayer service;
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;
    ItemDao itemDao;


    @Before
    public void setUp() throws Exception {

        setUpCustomerMock();
        setUpInvoiceMock();
        setUpInvoiceItemMock();
        setUpItemMock();

    }



    private void setUpCustomerMock() {

        customerDao = mock(CustomerDaoJdbsTemplateImpl.class);

        Customer customer = new Customer();
        customer.setCustomerId(1);
        customer.setFirstName("brian");
        customer.setLastName("smith");
        customer.setEmail("brian@mail");
        customer.setCompany("ezShop");
        customer.setPhone("7048887777");

        Customer customer2 = new Customer();
        customer2.setFirstName("brian");
        customer2.setLastName("smith");
        customer2.setEmail("brian@mail");
        customer2.setCompany("ezShop");
        customer2.setPhone("7048887777");


        List<Customer> cList = new ArrayList<>();
        cList.add(customer);

        doReturn(customer).when(customerDao).addCustomer(customer2);
        doReturn(customer).when(customerDao).getCustomer(1);
        doReturn(cList).when(customerDao).getAllCustomers();

    }

    private void setUpInvoiceMock() {
    }

    private void setUpInvoiceItemMock() {
    }

    private void setUpItemMock() {
    }












}
