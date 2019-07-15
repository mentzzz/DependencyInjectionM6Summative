package com.dependencyinjection.m6summative.controller;

import com.dependencyinjection.m6summative.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    private ServiceLayer serviceLayer;

    @RequestMapping(value="/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@RequestBody InvoiceViewModel invoiceViewModel) {
        serviceLayer.saveInvoice(invoiceViewModel);
        return invoiceViewModel;
    }

    //*** METHODS COMMENTED OUT UNTIL WE FIGURE OUT IF WE CAN MAKE THESE QUERIES PER INSTRUCTIONS ***

//    @RequestMapping(value="/invoice/{id}", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public InvoiceViewModel getInvoice(@PathVariable(name="id") int id) {
//        return serviceLayer.findInvoice(id);
//    }

//    @RequestMapping(value="/invoice/{id}", method = RequestMethod.PUT)
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void updateInvoice(@RequestBody InvoiceViewModel invoiceViewModel, @PathVariable(name = "id") int id) {
//        if (id != invoiceViewModel.getInvoiceId()) {
//            throw new IllegalArgumentException("Invoice ID on path must match the ID in the Invoice object.");
//        }
//        serviceLayer.saveInvoice(invoiceViewModel);
//    }

    @RequestMapping(value="/invoice/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteInvoice(@PathVariable(name = "id") int id) {
        serviceLayer.removeInvoice(id);
    }

//    @RequestMapping(value="/invoice", method = RequestMethod.GET)
//    @ResponseStatus(HttpStatus.OK)
//    public List<InvoiceViewModel> getAllInvoices() {
//        return serviceLayer.findAllInvoices();
//    }

    @RequestMapping(value="/invoice/customer/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceViewModel> findInvoicesByCustomer(@PathVariable(name="id") int id) {
        return serviceLayer.findInvoicesByCustomer(id);
    }

}
