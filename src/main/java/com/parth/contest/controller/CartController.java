package com.parth.contest.controller;


import com.parth.contest.model.CartModel;
import com.parth.contest.view.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CartController {
    CartService ps;

    CartController(CartService ps) {
        this.ps = ps;
    }

    @GetMapping("/cart")
    public String getCart() {
        CartModel[] data = ps.getAllCart();
        return data.toString();
    }

    @GetMapping("/cart/user/{name}")
    public String getUserCart(@PathVariable int name) {
        CartModel[] data = ps.getUserCart(name);
        return data.toString();
    }

    @GetMapping("/cart/{id}")
    public String getASingle(@PathVariable int id) {
        CartModel data = ps.getASingle(id);
        return data.toString();
    }

    @GetMapping("/cart/{start}/{end}")
    public List<CartModel> getCartInDateRange(@PathVariable String start, @PathVariable String end) {
        List<CartModel> data = ps.getAllCartInDateRange(start, end);
        return data;
    }


    @PostMapping("/cart/new")
    public String addCart(@RequestBody CartModel pm) {
        ps.addNewCart(pm);
        return "Product created";
    }

    @PutMapping("/cart/{id}")
    public String updateCart(@RequestBody CartModel pm) {
        ps.updateCart(pm);
        return "Product updated";
    }

    @DeleteMapping("/cart/{id}")
    public String deleteCart(@RequestBody CartModel pm) {
        ps.deleteCart(pm);
        return "Product Deleted";
    }

}
