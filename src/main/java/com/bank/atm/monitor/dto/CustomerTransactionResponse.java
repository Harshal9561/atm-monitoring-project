package com.bank.atm.monitor.dto;

import com.bank.atm.monitor.model.Customer;

import java.util.List;

public class CustomerTransactionResponse {

    private long totalCount;
    private List<Customer> customers;

    public CustomerTransactionResponse(long totalCount, List<Customer> customers) {
        this.totalCount = totalCount;
        this.customers = customers;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
