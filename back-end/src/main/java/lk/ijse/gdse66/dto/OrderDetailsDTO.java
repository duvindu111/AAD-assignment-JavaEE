package lk.ijse.gdse66.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDetailsDTO {

    String order_id;
    String item_code;
    BigDecimal unit_price;
    int qty;
}
