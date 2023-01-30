package ee.biceps.api.db.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShoppingCart {
    private Long id;
    private Long accountId;
    private Long productId;
    private int amount;
    private BigDecimal totalPrice;
    private String status;
}
