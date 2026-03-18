package org.example.util;

import org.example.model.Product;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextBuilder {

    public static String build(Product p) {

        String title = repeat(safe(p.getTitle()), 3);                 // high weight
        String category = repeat(safe(p.getMainCategory()), 2);       // medium weight

        String features = joinList(p.getFeatures());
        String description = joinList(p.getDescription());
        String categories = joinList(p.getCategories());

        String details = mapToText(p.getDetails());
        String store = safe(p.getStore());

        String boughtTogether = joinList(p.getBoughtTogether());

        return String.join(" ",
                title,
                category,
                features,
                description,
                categories,
                details,
                store,
                boughtTogether
        ).replaceAll("\\s+", " ").trim();
    }

    // 🔹 Helper: Safe string
    private static String safe(String s) {
        return s != null ? s : "";
    }

    // 🔹 Helper: Join list safely
    private static String joinList(List<String> list) {
        if (list == null || list.isEmpty()) return "";
        return list.stream()
                .filter(s -> s != null && !s.isBlank())
                .collect(Collectors.joining(" "));
    }

    // 🔹 Helper: Convert map to readable text
    private static String mapToText(Map<String, Object> map) {
        if (map == null || map.isEmpty()) return "";

        return map.entrySet().stream()
                .map(e -> e.getKey() + " " + String.valueOf(e.getValue()))
                .collect(Collectors.joining(" "));
    }

    // 🔹 Helper: Repeat important fields for weighting
    private static String repeat(String text, int times) {
        if (text == null || text.isBlank()) return "";
        return String.join(" ", Collections.nCopies(times, text));
    }
}