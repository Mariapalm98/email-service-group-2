package se.iths.maria.emailservicegroup2.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    private String name;
    private int quantity;
    private BigDecimal price;
}
