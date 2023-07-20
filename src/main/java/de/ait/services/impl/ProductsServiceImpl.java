package de.ait.services.impl;
import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;
import de.ait.services.ProductsService;
import de.ait.validators.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {

    private final ProductsRepository productsRepository;

    private final ProductValidator productValidator;
    @Override
    public void signUp(String name, String quantity) {

        productValidator.validate(name);

        Product product = new Product(name, quantity);

        productsRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }
}
