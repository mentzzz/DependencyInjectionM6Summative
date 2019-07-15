package com.dependencyinjection.m6summative.controller;

import com.dependencyinjection.m6summative.dao.ItemDao;
import com.dependencyinjection.m6summative.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemDao itemDao;

    @RequestMapping(value="/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item addItem(@RequestBody Item item) {
        itemDao.addItem(item);
        return item;
    }

    @RequestMapping(value="/item/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Item getItem(@PathVariable(name="id") int id) {
        return itemDao.getItem(id);
    }

    @RequestMapping(value="/item/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateItem(@RequestBody Item item, @PathVariable(name = "id") int id) {
        if (id != item.getItemId()) {
            throw new IllegalArgumentException("Item ID on path must match the ID in the Item object.");
        }
        itemDao.updateItem(item);
    }

    @RequestMapping(value="/item/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteItem(@PathVariable(name = "id") int id) {
        itemDao.deleteItem(id);
    }

    @RequestMapping(value="/item", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Item> getAllItems() {
        return itemDao.getAllItems();
    }
}
