package com.sajal.springcrud.controller;

import com.sajal.springcrud.entity.Product;
import com.sajal.springcrud.repository.ProductRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/crud/products")
public class CrudController {
    private final ProductRepository productRepository;

    public CrudController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DataAccessException("Product not found with id: " + id) {
                });

        // Update the product fields
        product = new Product(
                product.id(),
                productDetails.name(),
                productDetails.description(),
                productDetails.price()
        );

        return productRepository.save(product);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable Integer id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new DataAccessException("Product not found with id: " + id) {
                });
        productRepository.delete(product);
    }

    @GetMapping("/search")
    public List<Product> findProductsByName(@RequestParam String name) {
        return productRepository.findByNameContaining(name);
    }

}
