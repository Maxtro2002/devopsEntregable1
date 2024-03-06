package com.udem.devops.entregable1.controllers;

import com.udem.devops.entregable1.entities.ProductEntity;
import com.udem.devops.entregable1.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @InjectMocks
    ProductController productController;

    @Mock
    ProductService productService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllProducts() {
        ProductEntity product1 = new ProductEntity();
        ProductEntity product2 = new ProductEntity();
        List<ProductEntity> products = Arrays.asList(product1, product2);

        when(productService.getAllProducts()).thenReturn(products);

        ResponseEntity<List<ProductEntity>> response = productController.getAllProducts();

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(products, response.getBody());
        verify(productService, times(1)).getAllProducts();
    }

    @Test
    public void testGetProductById() {
        ProductEntity product = new ProductEntity();
        String id = "1";

        when(productService.getProductById(id)).thenReturn(product);

        ResponseEntity<ProductEntity> response = productController.getProductById(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).getProductById(id);
    }

    @Test
    public void testCreateProduct() {
        ProductEntity product = new ProductEntity();

        when(productService.createProduct(product)).thenReturn(product);

        ResponseEntity<ProductEntity> response = productController.createProduct(product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).createProduct(product);
    }

    @Test
    public void testUpdateProduct() {
        ProductEntity product = new ProductEntity();
        String id = "1";

        when(productService.updateProduct(id, product)).thenReturn(product);

        ResponseEntity<ProductEntity> response = productController.updateProduct(id, product);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(product, response.getBody());
        verify(productService, times(1)).updateProduct(id, product);
    }

    @Test
    public void testDeleteProduct() {
        String id = "1";

        ResponseEntity<Void> response = productController.deleteProduct(id);

        assertEquals(200, response.getStatusCodeValue());
        verify(productService, times(1)).deleteProduct(id);
    }

}