package com.parth.contest.view;

import com.parth.contest.model.CategoryModel;
import com.parth.contest.model.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CategoryService {
    RestTemplate rest;

    CategoryService() {
        this.rest = new RestTemplate();
    }


    public ProductModel[] getAllCategoryProduct(String name) {
        ProductModel[] data = rest.getForObject("https://fakestoreapi.com/products/category/jewelery", ProductModel[].class);
        return data;
    }

    public String[] getAllCategoriesByName() {
        String[] data = rest.getForObject("https://fakestoreapi.com/products/categories", String[].class);
        return data;
    }
}