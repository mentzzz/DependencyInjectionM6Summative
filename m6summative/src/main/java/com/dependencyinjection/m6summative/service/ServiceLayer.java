package com.dependencyinjection.m6summative.service;

import com.dependencyinjection.m6summative.dao.CustomerDao;
import com.dependencyinjection.m6summative.dao.InvoiceDao;
import com.dependencyinjection.m6summative.dao.InvoiceItemDao;
import com.dependencyinjection.m6summative.dao.ItemDao;
import com.dependencyinjection.m6summative.model.Customer;
import com.dependencyinjection.m6summative.model.Invoice;
import com.dependencyinjection.m6summative.model.InvoiceItem;
import com.dependencyinjection.m6summative.model.Item;
import com.dependencyinjection.m6summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ServiceLayer {

    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;


    @Autowired
    public ServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    //
    // invoice API
    //

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {

        // save invoice
       Invoice invoice = new Invoice();
       invoice.setCustomerId(viewModel.getCustomer().getCustomerId());
       invoice.setOrderDate(viewModel.getOrderDate());
       invoice.setPickupDate(viewModel.getPickupDate());
       invoice.setReturnDate(viewModel.getReturnDate());
       invoice.setLateFee(viewModel.getLateFee());

       invoice = invoiceDao.addInvoice(invoice);
       viewModel.setInvoiceId(invoice.getInvoiceId());


       // save invoice-items with invoice id
        List<InvoiceItem> invoiceItemArray = viewModel.getInvoiceItems();

        invoiceItemArray.stream()
                .forEach(inv ->
                {
                    inv.setInvoiceId(viewModel.getInvoiceId());
                    invoiceItemDao.addInvoiceItem(inv);
                });
        invoiceItemArray = invoiceItemDao.getInvoiceItemByInvoice(viewModel.getInvoiceId());
        viewModel.setInvoiceItems(invoiceItemArray);

        return viewModel;
    }


    public InvoiceViewModel findInvoice( int id ) {
        // get the invoice object
        Invoice invoice = new Invoice();

        return buildInvoiceViewModel(invoice);
    }

    public List<InvoiceViewModel> findAllInvoices() {
        // get a list of all invoices
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        // create a new ivm list
        List<InvoiceViewModel> ivmList = new ArrayList<>();

        for ( Invoice inv: invoiceList ) {
            InvoiceViewModel ivm = buildInvoiceViewModel(inv);
            ivmList.add(ivm);
        }

        return ivmList;

    }

    @Transactional
    public void removeInvoice( int id ) {

        // remove all associated invoice_items first
        List<InvoiceItem> inventoryItemList = invoiceItemDao.getInvoiceItemByInvoice(id);

        inventoryItemList.stream()
                .forEach(item -> invoiceDao.deleteInvoice(item.getInvoiceItemId()));

        // remove invoice
        invoiceDao.deleteInvoice(id);

    }

    //
    // Customer API
    //

    public Customer saveCustomer(Customer customer) {

        return customerDao.addCustomer(customer);
    }

    public Customer findCustomer(int id) {

        return customerDao.getCustomer(id);
    }

    public List<Customer> findAllCustomers() {

        return customerDao.getAllCustomers();
    }

    public void updateCustomer(Customer customer) {

        customerDao.updateCustomer(customer);
    }

    public void removeCustomer(int id) {

        customerDao.deleteCustomer(id);
    }


    //
    // item API
    //

    public Item saveItem(Item item) {

        return itemDao.addItem(item);
    }

    public Item findItem(int id) {

        return itemDao.getItem(id);
    }

    public List<Item> findAllItems() {

        return itemDao.getAllItems();
    }

    public void updateItem(Item item) {

        itemDao.updateItem(item);
    }

    public void removeItem(int id) {

        itemDao.deleteItem(id);
    }





    // Helper Methods
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        // get the associated invoice
        Invoice invoiceIvm = invoiceDao.getInvoice(invoice.getInvoiceId());

        // get the associated customer
        Customer customerIvm = customerDao.getCustomer(invoiceIvm.getCustomerId());

        // get the associated invoice_items
        List<InvoiceItem> itemList = invoiceItemDao.getInvoiceItemByInvoice(invoice.getInvoiceId());


        // may need to also get each item associated with the invoice_item


        // assemble the InvocieViewModel
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setInvoiceId(invoice.getInvoiceId());
        ivm.setOrderDate(invoice.getOrderDate());
        ivm.setPickupDate(invoice.getPickupDate());
        ivm.setReturnDate(invoice.getReturnDate());
        ivm.setLateFee(invoice.getLateFee());
        ivm.setCustomer(customerIvm);
        ivm.setInvoiceItems(itemList);


        return ivm;

    }


}
