package com.bank.atm.monitor.model;


import lombok.Data;

@Data
public class ATMStatus {
    private String atmId;
    private String status; // Could be "ONLINE", "OFFLINE", "MAINTENANCE"
    private String lastChecked;

}
