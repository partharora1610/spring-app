package com.parth.contest.controller;

import com.parth.contest.model.ProductModel;
import com.parth.contest.view.CategoryService;
import org.springframework.web.bind.annotation.*;

@RestController

public class CategoryController {

    CategoryService cs;


    CategoryController(CategoryService cs) {
        this.cs = cs;
    }

    @GetMapping("/category")
    public String[] getAllCatgories() {
        String[] data = cs.getAllCategoriesByName();
        return data;
    }

    @GetMapping("/category/{id}")
    public String getAllProduct(@PathVariable String name) {
        ProductModel[] data = cs.getAllCategoryProduct(name);
        return data.toString();
    }
}
