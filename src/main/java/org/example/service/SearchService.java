package org.example.service;

import org.example.model.Product;
import org.example.util.TextBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SearchService {

    private final EmbeddingService embeddingService;
    private final List<Product> products;
    private final List<double[]> embeddings;

    public SearchService(EmbeddingService embeddingService, ProductService productService) {
        this.embeddingService = embeddingService;
        this.products = productService.getProducts();
        this.embeddings = new ArrayList<>();

        for (Product p : products) {
            embeddings.add(embeddingService.embed(TextBuilder.build(p)));
        }
    }

    public List<Product> search(String query) {
        double[] qVec = embeddingService.embed(query);

        List<Map.Entry<Product, Double>> scored = new ArrayList<>();

        for (int i = 0; i < products.size(); i++) {
            double score = cosine(qVec, embeddings.get(i));
            scored.add(Map.entry(products.get(i), score));
        }

        scored.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

        List<Product> results = new ArrayList<>();
        for (int i = 0; i < Math.min(5, scored.size()); i++) {
            results.add(scored.get(i).getKey());
        }

        return results;
    }

    private double cosine(double[] a, double[] b) {
        double dot = 0, normA = 0, normB = 0;

        int len = Math.min(a.length, b.length);

        for (int i = 0; i < len; i++) {
            dot += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }

        return dot / (Math.sqrt(normA) * Math.sqrt(normB) + 1e-9);
    }
}