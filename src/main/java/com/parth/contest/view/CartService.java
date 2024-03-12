package com.parth.contest.view;


import com.parth.contest.model.CartModel;
import com.parth.contest.model.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

@Service
public class CartService {
    RestTemplate rest;

    CartService() {
        this.rest = new RestTemplate();
    }

    public CartModel[] getAllCart() {
        CartModel[] data = rest.getForObject("https://fakestoreapi.com/carts", CartModel[].class);
        return data;

    }

    public List<CartModel> getAllCartInDateRange(String startDate, String endDate) {
        CartModel[] data = rest.getForObject("https://fakestoreapi.com/carts?startdate=" + startDate + "&enddate=" + endDate, CartModel[].class);
        return List.of(data);
    }

    public CartModel[] getUserCart(int id) {
        CartModel[] data = rest.getForObject("https://fakestoreapi.com/carts/user/" + id, CartModel[].class);
        return data;

    }


    public CartModel getASingle(int id) {
        CartModel data = rest.getForObject("https://fakestoreapi.com/carts/" + id, CartModel.class);
        return data;

    }

    public CartModel addNewCart(CartModel pm) {
        CartModel data = rest.postForObject("https://fakestoreapi.com/carts", pm, CartModel.class);
        return data;
    }


    public void updateCart(CartModel pm) {
        int id = pm.getId();
        rest.put("https://fakestoreapi.com/carts/" + id, pm);
    }

    public void deleteCart(CartModel pm) {
        int id = pm.getId();
        rest.delete("https://fakestoreapi.com/carts/" + id);
    }

}
