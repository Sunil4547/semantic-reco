package org.example.service;

import org.example.model.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products;

    public ProductService() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = getClass().getResourceAsStream("/products.json");
            products = mapper.readValue(is, new TypeReference<List<Product>>() {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getProducts() {
        return products;
    }
}