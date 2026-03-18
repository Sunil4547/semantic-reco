package org.example.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmbeddingService {

    public Map<String, Integer> vocab = new HashMap<>();

    public double[] embed(String text) {
        String[] words = text.toLowerCase().split("\\W+");

        for (String w : words) {
            vocab.putIfAbsent(w, vocab.size());
        }

        double[] vector = new double[vocab.size()];

        for (String w : words) {
            int idx = vocab.get(w);
            vector[idx] += 1.0;
        }

        return vector;
    }
}