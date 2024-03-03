package com.udem.devops.entregable1.services;

import com.udem.devops.entregable1.entities.ProductEntity;
import com.udem.devops.entregable1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    public ProductEntity getProductById(String id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public ProductEntity createProduct(ProductEntity product) {
        return productRepository.save(product);
    }

    public ProductEntity updateProduct(String id, ProductEntity product) {
        Optional<ProductEntity> existingProduct = productRepository.findById(id);
        if (existingProduct.isPresent()) {
            ProductEntity updatedProduct = existingProduct.get();
            updatedProduct.setSize(product.getSize());
            updatedProduct.setColor(product.getColor());
            updatedProduct.setMaterial(product.getMaterial());
            updatedProduct.setWarranty(product.getWarranty());
            updatedProduct.setOrigin(product.getOrigin());
            return productRepository.save(updatedProduct);
        } else {
            return null;
        }
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }
}