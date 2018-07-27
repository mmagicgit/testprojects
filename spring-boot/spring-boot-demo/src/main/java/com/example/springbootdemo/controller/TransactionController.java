package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    @GetMapping
    public List<Transaction> list() {
        Transaction transaction = new Transaction();
        transaction.setAmount(BigDecimal.TEN);
        transaction.setSubject("Money I found on street");
        transaction.setTimestamp(Instant.now());
        transaction.setUsername("marcelo");
        return Collections.singletonList(transaction);
    }

}
