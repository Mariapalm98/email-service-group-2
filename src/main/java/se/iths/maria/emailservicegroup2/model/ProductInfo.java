package se.iths.maria.emailservicegroup2.model;

import java.math.BigDecimal;

public record ProductInfo(
        String name,
        String description,
        BigDecimal price,
        int quantity
) {
}
