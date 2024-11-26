package com.bank.atm.monitor.repository;

import com.bank.atm.monitor.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByTransactionTimeBetween(LocalDateTime start, LocalDateTime end);

}
