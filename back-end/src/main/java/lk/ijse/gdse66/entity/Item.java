package lk.ijse.gdse66.entity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Item {

    private String code;
    private String name;
    private BigDecimal price;
    private int qty;
}
