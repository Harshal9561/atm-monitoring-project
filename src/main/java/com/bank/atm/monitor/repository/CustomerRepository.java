package com.bank.atm.monitor.repository;

import com.bank.atm.monitor.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    long countByLastTransactionTimeBetween(LocalDateTime start, LocalDateTime end);
}

