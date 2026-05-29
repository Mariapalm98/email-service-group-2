package se.iths.maria.emailservicegroup2.model;

import java.math.BigDecimal;
import java.util.List;


public record OrderResponse(
        Long id,
        String customerName,
        List<ProductInfo> items,
        BigDecimal totalPrice) {


}
