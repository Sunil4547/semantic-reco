package org.example.controller;

import org.example.model.Product;
import org.example.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendationController {

    private final SearchService searchService;

    public RecommendationController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping("/recommend")
    public List<Product> recommend(@RequestParam String q) {
        return searchService.search(q);
    }
}