package com.bank.atm.monitor.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class CameraMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String mediaType;
    private String filePath;
    private LocalDateTime timestamp;
    private int atmId;

    public CameraMedia(String mediaType, String filePath, LocalDateTime timestamp, int atmId) {
        this.mediaType = mediaType;
        this.filePath = filePath;
        this.timestamp = timestamp;
        this.atmId = atmId;
    }
}


