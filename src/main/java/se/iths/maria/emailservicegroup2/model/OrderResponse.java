package se.iths.maria.emailservicegroup2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderResponse {
    private String customerName;
    private List<OrderItem> items;
    private BigDecimal totalPrice;


}
