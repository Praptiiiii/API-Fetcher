package com.example.backendServer1.controller;

import com.example.backendServer1.dto.TransactionSuccessDTO;
import com.example.backendServer1.dto.TransactionSuccessResponseDTO;
import com.example.backendServer1.service.TransactionSuccessService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The {@code TransactionSuccessController} class handles HTTP requests related to successful transactions.
 * It provides endpoints for retrieving information about successful transactions for a given account number.
 * This controller is responsible for interacting with the {@link TransactionSuccessService} to fetch and
 * transform the data before sending it as a response.
 *
 * @author prapti
 */
@RestController
@RequestMapping("/backendserver1")
@Validated
public class TransactionSuccessController {

    /**
     * The {@link TransactionSuccessService} instance that provides business logic for successful transactions.
     */
    private final TransactionSuccessService service;

    /**
     * Constructs a new {@code TransactionSuccessController} with the specified {@link TransactionSuccessService}.
     *
     * @param service The {@code TransactionSuccessService} instance to be used by this controller.
     */
    @Autowired
    public TransactionSuccessController(TransactionSuccessService service) {
        this.service = service;
    }

    /**
     * Retrieves a list of successful transactions for the specified account number.
     *
     * @param accountNumber The account number for which successful transactions are to be retrieved.
     * @return A {@link ResponseEntity} containing the {@link TransactionSuccessResponseDTO} with the
     *         account number and a list of successful transactions, or a bad request response if the account
     *         number is empty or null.
     */
    @GetMapping("/success/{accountNumber}")
    public ResponseEntity<TransactionSuccessResponseDTO> getSuccessTransactions(
            @PathVariable @NotEmpty(message = "Account number cannot be empty") String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        List<TransactionSuccessDTO> successTransactions = service.getSuccessTransactionsDTO(accountNumber);
        TransactionSuccessResponseDTO responseDTO = new TransactionSuccessResponseDTO();
        responseDTO.setAccountNumber(accountNumber);
        responseDTO.setSuccess(successTransactions);
        return ResponseEntity.ok(responseDTO);
    }
}
