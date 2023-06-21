package ru.clevertec.ecl.springboottaskclevertec.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "user_t")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String userName;
    @Column(nullable = false)
    private Double balance;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
