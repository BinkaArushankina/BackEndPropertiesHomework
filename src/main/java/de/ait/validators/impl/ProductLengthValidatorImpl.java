package de.ait.validators.impl;
import de.ait.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductLengthValidatorImpl implements ProductValidator {

    private final int minLength;

    public ProductLengthValidatorImpl(@Value("${min.productname.length}") int minLength) {
        this.minLength = minLength;
    }

    @Override
    public void validate(String name) {
        if (name.length() < minLength) {
            throw new IllegalArgumentException("product name is too short");
        }
    }
}
