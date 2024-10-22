package lk.ijse.gdse66.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class OrderDTO {
    String order_id;
    LocalDate date;
    String cust_id;
    BigDecimal discount;
    BigDecimal total;
    List<OrderDetailsDTO> order_list;

    public OrderDTO(String order_id, LocalDate date, String cust_id, BigDecimal discount, BigDecimal total) {
        this.order_id = order_id;
        this.date = date;
        this.cust_id = cust_id;
        this.discount = discount;
        this.total = total;
    }
}
