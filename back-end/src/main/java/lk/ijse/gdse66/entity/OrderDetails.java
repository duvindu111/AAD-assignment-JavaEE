package lk.ijse.gdse66.entity;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetails {

    private String order_id;
    private String item_code;
    private BigDecimal unit_price;
    private int qty;

}
