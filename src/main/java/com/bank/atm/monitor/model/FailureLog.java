package com.bank.atm.monitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class FailureLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String failureType;
    private String incidentContext;
    private LocalDateTime failureTime;
    private int atmId;

    public FailureLog(String failureType, String incidentContext, LocalDateTime failureTime, int atmId) {
        this.failureType = failureType;
        this.incidentContext = incidentContext;
        this.failureTime = failureTime;
        this.atmId = atmId;
    }


}
