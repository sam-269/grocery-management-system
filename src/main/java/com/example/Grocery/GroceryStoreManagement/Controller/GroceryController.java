package com.example.Grocery.GroceryStoreManagement.Controller;

import com.example.Grocery.GroceryStoreManagement.Entity.Grocery;
import com.example.Grocery.GroceryStoreManagement.Exceptions.NonExistingItemIdException;
import com.example.Grocery.GroceryStoreManagement.Service.GroceryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GroceryController {

    @Autowired
    private GroceryService groceryService;

    @PostMapping("/groceries")
    public String addGrocery(@RequestBody Grocery grocery){
        return groceryService.insertGrocery(grocery);
    }

    @GetMapping("/groceries")
    public List<Grocery> getGrocery(){
        return groceryService.getAllGroceries();
    }

    @GetMapping("/groceries/{itemNumber}")
    public Optional<Grocery> getGroceryById(@PathVariable int itemNumber) throws NonExistingItemIdException {
        return groceryService.getGroceryById(itemNumber);
    }

    @DeleteMapping("/groceries/{itemNumber}")
    public void deleteGroceryById(@PathVariable int itemNumber) throws NonExistingItemIdException {
        groceryService.deleteGroceryById(itemNumber);
    }

    @PutMapping("/groceries")
    public void updateGrocery(@RequestBody Grocery grocery) throws NonExistingItemIdException {
        groceryService.updateGrocery(grocery);
    }

}