package com.bank.atm.monitor.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String type;
    private Double amount;
    private LocalDateTime transactionTime;

    @ManyToOne
    private Customer customer;

}
