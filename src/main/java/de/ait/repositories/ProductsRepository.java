package de.ait.repositories;

import de.ait.models.Product;

import java.util.List;

public interface ProductsRepository {

    void save(Product product);

    List<Product> findAll();
}
