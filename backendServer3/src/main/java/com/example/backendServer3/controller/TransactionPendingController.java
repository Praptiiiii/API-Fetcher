package com.example.backendServer3.controller;

import com.example.backendServer3.service.TransactionPendingService;
import com.example.backendServer3.dto.PendingDTO;
import com.example.backendServer3.dto.TransactionPendingDTO;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The {@code TransactionPendingController} class is a Spring MVC controller that handles HTTP requests related to pending transactions.
 * It exposes an endpoint for retrieving pending transactions based on the provided account number.
 *
 * This controller class validates input parameters and delegates the processing to the associated service class.
 * It utilizes Spring annotations for request mapping, dependency injection, and validation.
 *
 * @author prapti
 */
@RestController
@RequestMapping("/backendserver3")
@Validated
public class TransactionPendingController {

    /**
     * The service responsible for processing pending transactions.
     */
    @Autowired
    private TransactionPendingService service;

    /**
     * Retrieves pending transactions for a given account number and returns a response containing the pending transactions.
     *
     * @param accountNumber The account number for which pending transactions need to be retrieved.
     * @return ResponseEntity containing the response DTO with the account number and pending transactions, or a bad request response if the account number is empty.
     */
    @GetMapping("/pending/{accountNumber}")
    public ResponseEntity<TransactionPendingDTO> getPendingTransactions(
            @PathVariable @NotEmpty(message = "Account number cannot be empty") String accountNumber) {
        if (accountNumber.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }

        List<PendingDTO> pendingTransactions = service.getPendingTransactionsDTO(accountNumber);

        TransactionPendingDTO responseDTO = new TransactionPendingDTO();
        responseDTO.setAccountNumber(accountNumber);
        responseDTO.setPending(pendingTransactions);

        return ResponseEntity.ok(responseDTO);
    }
}
