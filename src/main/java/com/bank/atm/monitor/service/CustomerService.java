package com.bank.atm.monitor.service;

import com.bank.atm.monitor.dto.CustomerTransactionResponse;
import com.bank.atm.monitor.model.Customer;
import com.bank.atm.monitor.model.Transaction;
import com.bank.atm.monitor.repository.CustomerRepository;
import com.bank.atm.monitor.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {


    @Autowired
    TransactionRepository transactionRepository;

    public CustomerTransactionResponse getCustomersWithTransactionsInLast24Hours() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime twentyFourHoursAgo = now.minusDays(1);

        // Find all transactions in the last 24 hours
        List<Transaction> recentTransactions = transactionRepository.findByTransactionTimeBetween(twentyFourHoursAgo, now);

        // Extract unique customers from these transactions
        List<Customer> customers = recentTransactions.stream()
                .map(Transaction::getCustomer)  // Get the customer for each transaction
                .distinct()                     // Remove duplicate customers
                .collect(Collectors.toList());

        long customerCount = customers.size();

        return new CustomerTransactionResponse(customerCount, customers);
    }
}
