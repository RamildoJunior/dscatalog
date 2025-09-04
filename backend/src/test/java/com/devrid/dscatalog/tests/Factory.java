package com.devrid.dscatalog.tests;

import com.devrid.dscatalog.dto.ProductDTO;
import com.devrid.dscatalog.entities.Category;
import com.devrid.dscatalog.entities.Product;

import java.time.Instant;

public class Factory {

    public static Product createProduct() {
        Product product = new Product(1l, "Phone", "Good Phone", 800.0, "https://img.com/img.png",
                Instant.parse("2020-10-20T03:00:00Z"));
        product.getCategories().add(new Category());
        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());


    }
}
