package com.bank.atm.monitor.service;

import com.bank.atm.monitor.model.ATMStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ATMService {
    public ATMStatus getATMStatus(String atmId) {
        ATMStatus status = new ATMStatus();
        status.setAtmId(atmId);
        status.setStatus("ONLINE");
        status.setLastChecked(LocalDateTime.now().toString());
        return status;
    }

    public TransactionSummary getTransactionSummary(String atmId) {
        TransactionSummary summary = new TransactionSummary();
        summary.setAtmId(atmId);
        summary.setTotalTransactions(150);
        summary.setDepositTransactions(50);
        summary.setWithdrawalTransactions(70);
        summary.setBalanceInquiryTransactions(30);
        return summary;
    }
}

