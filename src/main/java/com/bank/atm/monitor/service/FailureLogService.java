package com.bank.atm.monitor.service;

import com.bank.atm.monitor.model.FailureLog;
import com.bank.atm.monitor.repository.FailureLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FailureLogService {
    private final FailureLogRepository failureLogRepository;

    public FailureLogService(FailureLogRepository failureLogRepository) {
        this.failureLogRepository = failureLogRepository;
    }

    public List<FailureLog> getFailuresByTimeRange(LocalDateTime start, LocalDateTime end) {
        return failureLogRepository.findByFailureTimeBetween(start, end);
    }
}
