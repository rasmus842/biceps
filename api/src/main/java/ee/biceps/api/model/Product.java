package ee.biceps.api.model;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String description;
    private Integer price;
    private String unit;
    private Integer availableAmount;
    private String category;
    private String imagePath;
}

