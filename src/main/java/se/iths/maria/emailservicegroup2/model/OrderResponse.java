package se.iths.maria.emailservicegroup2.model;

import java.math.BigDecimal;
import java.util.List;


public record OrderResponse(
        String customerName,
        List<OrderItem> items,
        BigDecimal totalPrice) {


}
