package com.bank.atm.monitor.dto;

import com.bank.atm.monitor.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class TransactionBreakdownResponse {

    private String type;
    private long transactionCount;
    private List<Customer> customers;

    public TransactionBreakdownResponse(String type) {
        this.type = type;
        this.transactionCount = 0;
        this.customers = new ArrayList<>();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(long transactionCount) {
        this.transactionCount = transactionCount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
