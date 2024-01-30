package lk.ijse.gdse66.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Orders {

    private String order_id;
    private Date date;
    private String cust_id;
    private BigDecimal discount;
    private BigDecimal total;
}
