package mk.finki.ukim.mk.lab.model;

import lombok.Data;

@Data
public class Order {
    private Long orderId;
    private String pizzaType;
    private String pizzaSize;
    private String clientName;
    private String clientAddress;
}
