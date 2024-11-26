package com.bank.atm.monitor.controller;

import com.bank.atm.monitor.dto.CustomerTransactionResponse;
import com.bank.atm.monitor.dto.MediaDTO;
import com.bank.atm.monitor.dto.TransactionBreakdownResponse;
import com.bank.atm.monitor.model.ATMStatus;
import com.bank.atm.monitor.model.FailureLog;
import com.bank.atm.monitor.service.*;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/atm-monitor")
public class ATMMonitorController {
    @Autowired
    CustomerService customerService;
    @Autowired
    TransactionService transactionService;
    @Autowired
    FailureLogService failureLogService;
    @Autowired
    CameraMediaService cameraMediaService;
    @Autowired
    ATMService atmService;

    @GetMapping("/customers/last24hours")
    public CustomerTransactionResponse getCustomersWithTransactionsInLast24Hours() {
        return customerService.getCustomersWithTransactionsInLast24Hours();
    }

    @GetMapping("/transactions/breakdown")
    public Map<String, TransactionBreakdownResponse> getTransactionBreakdown() {
        return transactionService.getTransactionBreakdownByType();
    }


    @GetMapping("/failures")
    public List<FailureLog> getFailures(@RequestParam String start, @RequestParam String end) {
        LocalDateTime startTime = LocalDateTime.parse(start);
        LocalDateTime endTime = LocalDateTime.parse(end);
        return failureLogService.getFailuresByTimeRange(startTime, endTime);
    }

    @GetMapping("/media")
    public ResponseEntity<List<MediaDTO>> getMediaByTimeRange(@RequestParam("startTime") String startTime,
                                                              @RequestParam("endTime") String endTime) {
        try {
            List<MediaDTO> mediaList = cameraMediaService.getMediaByTimeRange(startTime, endTime);

            if (mediaList.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            System.out.println("Resources: " + mediaList);
            return ResponseEntity.ok(mediaList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).build();
        }
    }


    @GetMapping("/atm/status/{atmId}")
    public ResponseEntity<ATMStatus> getATMStatus(@PathVariable String atmId) {
        ATMStatus status = atmService.getATMStatus(atmId);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/atm/transactions/{atmId}/summary")
    public ResponseEntity<TransactionSummary> getTransactionSummary(@PathVariable String atmId) {
        TransactionSummary summary = atmService.getTransactionSummary(atmId);
        return ResponseEntity.ok(summary);
    }
}