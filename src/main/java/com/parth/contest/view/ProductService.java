package com.parth.contest.view;


import com.parth.contest.model.ProductModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductService {
    RestTemplate rest;

    ProductService() {
        this.rest = new RestTemplate();
    }

    public ProductModel getProduct(int id) {
        ProductModel data = rest.getForObject("https://fakestoreapi.com/products/" + id, ProductModel.class);
        return data;
    }

    public ProductModel createProduct(ProductModel pm) {
        ProductModel data = rest.postForObject("https://fakestoreapi.com/products", pm, ProductModel.class);
        return data;
    }

    public ProductModel[] getAllProduct() {
        ProductModel[] data = rest.getForObject("https://fakestoreapi.com/products", ProductModel[].class);
        return data;
    }

    public void updateProduct(ProductModel pm) {
        int id = pm.getId();
        System.out.println(id);
        rest.put("https://fakestoreapi.com/products/" + id, pm);
    }

    public void deleteProduct(ProductModel pm) {
        int id = pm.getId();
        rest.delete("https://fakestoreapi.com/products/" + id);
    }


}