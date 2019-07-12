package com.dependencyinjection.m6summative.dao;

import com.dependencyinjection.m6summative.model.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoJdbsTemplateImplTest {



    @Autowired
    protected CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        // clean out the test db
        List<Customer> cList = CustomerDao.getAllCustomers();

        cList.stream()
                .forEach(customer -> CustomerDao.deleteCustomer(customer.getCustomer_id()));
    }


    @Test
    public void addGetDeleteCustomer() {

    }


}
