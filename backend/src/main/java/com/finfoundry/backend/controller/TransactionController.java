package com.finfoundry.backend.controller;

import com.finfoundry.backend.dto.inputDTO.CreateTransactionRequest;
import com.finfoundry.backend.dto.outputDTO.TransactionDTO;
import com.finfoundry.backend.mapper.TransactionMapper;
import com.finfoundry.backend.model.Transaction;
import com.finfoundry.backend.service.TransactionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transactions")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from frontend
public class TransactionController {

    private final TransactionService transactionService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TransactionDTO>> getTransactionsByUser(@PathVariable Long userId) {
        List<TransactionDTO> dtos = transactionService.getTransactionsByUser(userId);
        return ResponseEntity.ok(dtos);
    }

    // @PostMapping
    // public ResponseEntity<TransactionDTO> createTransaction(@Valid @RequestBody CreateTransactionRequest createTransactionRequest) {
    //     TransactionDTO transaction = transactionService.createTransaction(createTransactionRequest);
    //     return ResponseEntity.ok(transaction);
    // }
}