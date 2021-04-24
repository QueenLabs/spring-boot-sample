package com.sample.api.service;

import com.sample.api.exeption.ProductException;
import com.sample.api.model.Product;
import com.sample.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product createProduct(Product product) {
        Optional<Product> productOptional = productRepository.findByName(product.getName());
        if (productOptional.isPresent()) {
            throw new ProductException("Product With Name " + product.getName() + "GEUS AYA");
        }

        return productRepository.save(product);
    }
}
