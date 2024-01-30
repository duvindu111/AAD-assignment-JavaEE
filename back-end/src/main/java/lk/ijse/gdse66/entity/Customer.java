package lk.ijse.gdse66.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer {
    private String id;
    private String name;
    private String address;
    private String contact;
}
