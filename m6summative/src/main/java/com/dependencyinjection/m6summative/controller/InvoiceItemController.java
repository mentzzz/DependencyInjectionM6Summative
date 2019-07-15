package com.dependencyinjection.m6summative.controller;

import com.dependencyinjection.m6summative.dao.InvoiceItemDao;
import com.dependencyinjection.m6summative.model.InvoiceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceItemController {

    @Autowired
    private InvoiceItemDao invoiceItemDao;

    @RequestMapping(value="/invoice-item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceItem addInvoiceItem(@RequestBody InvoiceItem invoiceItem) {
        invoiceItemDao.addInvoiceItem(invoiceItem);
        return invoiceItem;
    }

    //*** METHODS COMMENTED OUT UNTIL WE FIGURE OUT IF WE CAN MAKE THESE QUERIES PER INSTRUCTIONS ***

//    @RequestMapping(value="/invoice-item/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public InvoiceItem getInvoiceItem(@PathVariable(name="id") int id) {
//        return invoiceItemDao.getInvoiceItem(id);
//    }

//    @RequestMapping(value="/invoice-item/{id}", method = RequestMethod.PUT)
//@ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateInvoiceItem(@RequestBody InvoiceItem invoiceItem, @PathVariable(name = "id") int id) {
//        if (id != invoiceItem.getInvoiceItemId()) {
//            throw new IllegalArgumentException("Invoice Item ID on path must match the ID in the InvoiceItem object.");
//        }
//        invoiceItemDao.updateInvoiceItem(invoiceItem);
//    }

    @RequestMapping(value="/invoice-item/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoiceItem(@PathVariable(name = "id") int id) {
        invoiceItemDao.deleteInvoiceItem(id);
    }

//    @RequestMapping(value="/invoice-item", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceItem> getAllInvoiceItems() {
//        return invoiceItemDao.getAllInvoiceItems();
//    }

//    @RequestMapping(value="/invoice-item", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceItem> getAllInvoiceItems() {
//        return invoiceItemDao.getAllInvoiceItems();
//    }

//    @RequestMapping(value="/invoice-item/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceItem> getInvoiceItemByInvoice(@PathVariable(name="id") int id) {
//        return invoiceItemDao.getInvoiceItemByInvoice(id);
//    }


}
