package org.example.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Product {

    @JsonProperty("main_category")
    private String mainCategory;

    private String title;

    @JsonProperty("average_rating")
    private Double averageRating;

    @JsonProperty("rating_number")
    private Integer ratingNumber;

    private Double price;

    private List<String> features;

    private List<String> description;

    private List<Image> images;

    private List<Video> videos;

    private String store;

    private List<String> categories;

    private Map<String, Object> details;

    @JsonProperty("parent_asin")
    private String parentAsin;

    @JsonProperty("bought_together")
    private List<String> boughtTogether;

    @Data
    public static class Image {
        private String thumb;
        private String large;

        @JsonProperty("hi_res")
        private String hiRes;
        private String variant;
    }

    @Data
    public static class Video {
        private String title;
        private String url;
    }
}
