package de.ait.services;

import de.ait.models.Product;

import java.util.List;

public interface ProductsService {
    void signUp(String name , String quantity);

    List<Product> getAllProducts();
}
