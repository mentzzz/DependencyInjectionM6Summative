package com.dependencyinjection.m6summative.dao;


import com.dependencyinjection.m6summative.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {

    InvoiceItem getInvoiceItem(int id );

    List<InvoiceItem> getAllInvoiceItems();

    InvoiceItem addInvoiceItem( InvoiceItem invoiceItem );

    void updateInvoiceItem( InvoiceItem invoiceItem );

    void deleteInvoiceItem( int id );

}
