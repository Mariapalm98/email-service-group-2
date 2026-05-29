package se.iths.maria.emailservicegroup2.model;

import java.math.BigDecimal;

public record ProductInfo(
        Long id,
        String name,
        String description,
        BigDecimal price,
        int quantity
) {
}
