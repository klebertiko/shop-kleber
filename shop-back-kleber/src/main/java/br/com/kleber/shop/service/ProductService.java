package br.com.kleber.shop.service;

import br.com.kleber.shop.model.Product;
import br.com.kleber.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Collection<Product> findAll() {
        return this.productRepository.findAll();
    }

    public Product findOne(final Long id) {
        return this.productRepository.findOne(id);
    }

    public void save(Product product) {
        this.productRepository.save(product);
    }
}