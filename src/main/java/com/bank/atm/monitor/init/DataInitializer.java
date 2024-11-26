package com.bank.atm.monitor.init;

import com.bank.atm.monitor.model.CameraMedia;
import com.bank.atm.monitor.model.Customer;
import com.bank.atm.monitor.model.FailureLog;
import com.bank.atm.monitor.model.Transaction;
import com.bank.atm.monitor.repository.CameraMediaRepository;
import com.bank.atm.monitor.repository.CustomerRepository;
import com.bank.atm.monitor.repository.FailureLogRepository;
import com.bank.atm.monitor.repository.TransactionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataInitializer {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private FailureLogRepository failureLogRepository;
    @Autowired
    private CameraMediaRepository cameraMediaRepository;

    @PostConstruct
    public void initData() {
        Customer customer1 = new Customer();
        customer1.setName("John Doe");
        customer1.setLastTransactionTime(LocalDateTime.now());
        customerRepository.save(customer1);

        Customer customer2 = new Customer();
        customer2.setName("Jane Smith");
        customer2.setLastTransactionTime(LocalDateTime.now().minusDays(1));
        customerRepository.save(customer2);

        // Add test transactions
        // Transaction 1 - Deposit
        Transaction transaction1 = new Transaction();
        transaction1.setType("Deposit");
        transaction1.setAmount(500.0);
        transaction1.setTransactionTime(LocalDateTime.now().minusHours(1)); // within last 24 hours
        transaction1.setCustomer(customer1);
        transactionRepository.save(transaction1);

        // Transaction 2 - Withdrawal
        Transaction transaction2 = new Transaction();
        transaction2.setType("Withdrawal");
        transaction2.setAmount(500.0);
        transaction2.setTransactionTime(LocalDateTime.now().minusHours(2)); // within last 24 hours
        transaction2.setCustomer(customer1);
        transactionRepository.save(transaction2);

        // Transaction 3 - Balance Inquiry
        Transaction transaction3 = new Transaction();
        transaction3.setType("Balance Inquiry");
        transaction3.setAmount(0.0);
        transaction3.setTransactionTime(LocalDateTime.now().minusDays(1)); // not within last 24 hours
        transaction3.setCustomer(customer2);
        transactionRepository.save(transaction3);

        // Add test failures
        FailureLog failure1 = new FailureLog();
        failure1.setFailureType("System Downtime");
        failure1.setIncidentContext("ATM crashed during transaction");
        failure1.setFailureTime(LocalDateTime.now());
        failure1.setAtmId(1);
        failureLogRepository.save(failure1);

        FailureLog failure2 = new FailureLog();
        failure2.setFailureType("Device Failure");
        failure2.setIncidentContext("ATM not responding");
        failure2.setFailureTime(LocalDateTime.now().minusDays(1));
        failure2.setAtmId(2);
        failureLogRepository.save(failure2);

        // Add test camera media (images and videos)
        CameraMedia media1 = new CameraMedia();
        media1.setMediaType("Image");
        media1.setFilePath("/path/to/image1.jpg");
        media1.setTimestamp(LocalDateTime.now());
        media1.setAtmId(1);
        cameraMediaRepository.save(media1);

        CameraMedia media2 = new CameraMedia();
        media2.setMediaType("Video");
        media2.setFilePath("/path/to/video1.mp4");
        media2.setTimestamp(LocalDateTime.now().minusDays(1));
        media2.setAtmId(2);
        cameraMediaRepository.save(media2);
    }
}
