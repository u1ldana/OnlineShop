package kz.aitu.onlineshop.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;
    private String name;
    private double totalPrice;
    private int quantity;
    private int buyerId;
    private int productId;
}
