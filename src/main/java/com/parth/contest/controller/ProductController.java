package com.parth.contest.controller;

import com.parth.contest.model.ProductModel;
import com.parth.contest.view.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    ProductService ps;

    ProductController(ProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable int id) {
        ProductModel data = ps.getProduct(id);
        return data.toString();
    }

    @GetMapping("/products")
    public String getAllProduct() {
        ProductModel[] data = ps.getAllProduct();
        return data.toString();
    }


    @PostMapping("/product")
    public String createProduct(@RequestBody ProductModel pm) {
        ps.createProduct(pm);
        return "Product created";
    }

    @PutMapping("/product/{id}")
    public String updateProduct(@RequestBody ProductModel pm) {
        ps.updateProduct(pm);
        return "Product updated";
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@RequestBody ProductModel pm) {
        ps.deleteProduct(pm);
        return "Product Deleted";
    }
}
