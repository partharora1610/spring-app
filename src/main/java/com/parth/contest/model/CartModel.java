package com.parth.contest.model;

import java.util.Date;

public class CartModel {
    int id;
    int userId;
    Date date;
    CartProduct[] prodcuts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public CartProduct[] getProdcuts() {
        return prodcuts;
    }

    public void setProdcuts(CartProduct[] prodcuts) {
        this.prodcuts = prodcuts;
    }

    public CartModel(int id, int userId, Date date, CartProduct[] prodcuts) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.prodcuts = prodcuts;
    }
}


class CartProduct {
    int productId;
    int quantity;

    public CartProduct(int productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}