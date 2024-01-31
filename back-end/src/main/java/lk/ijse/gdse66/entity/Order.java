package lk.ijse.gdse66.entity;

import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Order {

    private String order_id;
    private LocalDate date;
    private String cust_id;
    private BigDecimal discount;
    private BigDecimal total;
}
