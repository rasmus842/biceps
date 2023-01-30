package ee.biceps.api.db.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@EqualsAndHashCode
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

