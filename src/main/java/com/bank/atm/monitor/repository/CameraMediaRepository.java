package com.bank.atm.monitor.repository;

import com.bank.atm.monitor.model.CameraMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CameraMediaRepository extends JpaRepository<CameraMedia, Long> {
    List<CameraMedia> findByTimestampBetween(LocalDateTime startTime, LocalDateTime endTime);
}
