package com.bank.atm.monitor.repository;

import com.bank.atm.monitor.model.FailureLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FailureLogRepository extends JpaRepository<FailureLog, Long> {
    List<FailureLog> findByFailureTimeBetween(LocalDateTime start, LocalDateTime end);
}
