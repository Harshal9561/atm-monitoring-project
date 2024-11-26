package com.bank.atm.monitor.service;

import lombok.Data;

@Data
public class TransactionSummary {
    private String atmId;
    private int totalTransactions;
    private int depositTransactions;
    private int withdrawalTransactions;
    private int balanceInquiryTransactions;

}
