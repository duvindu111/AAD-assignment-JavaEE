package lk.ijse.gdse66.dto;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ItemDTO {

    private String code;
    private String name;
    private BigDecimal price;
    private int qty;
}
