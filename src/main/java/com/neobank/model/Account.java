package com.neobank.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String iban;
    private double balance;

    @ManyToOne
    private User user;
}
