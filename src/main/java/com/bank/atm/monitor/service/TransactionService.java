package com.bank.atm.monitor.service;

import com.bank.atm.monitor.dto.TransactionBreakdownResponse;
import com.bank.atm.monitor.model.Customer;
import com.bank.atm.monitor.model.Transaction;
import com.bank.atm.monitor.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Map<String, TransactionBreakdownResponse> getTransactionBreakdownByType() {
        List<Transaction> transactions = transactionRepository.findAll();

        // Create a map to hold the breakdown
        Map<String, TransactionBreakdownResponse> breakdown = new HashMap<>();

        for (Transaction transaction : transactions) {
            String type = transaction.getType();
            Customer customer = transaction.getCustomer();

            // Get or create a breakdown entry for this transaction type
            TransactionBreakdownResponse response = breakdown.getOrDefault(type, new TransactionBreakdownResponse(type));

            // Add the customer to the response (no duplicates)
            if (!response.getCustomers().contains(customer)) {
                response.getCustomers().add(customer);
            }

            // Increment the transaction count for this type
            response.setTransactionCount(response.getTransactionCount() + 1);

            breakdown.put(type, response);
        }

        return breakdown;
    }
}
