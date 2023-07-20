package de.ait.repositories.impl;
import de.ait.models.Product;
import de.ait.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductsRepositoryFileImpl implements ProductsRepository {

    private final String fileName;

    public ProductsRepositoryFileImpl(@Value("${txt.file.name}") String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void save(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(product.getName() + "#" + product.getQuantity());
        } catch (IOException e) {
            throw new IllegalArgumentException("file problem");
        }
    }

    @Override
    public List<Product> findAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            return reader.lines()
                    .map(line -> line.split("#"))
                    .map(array -> new Product(array[0], array[1]))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("file problem");
        }
    }
}
