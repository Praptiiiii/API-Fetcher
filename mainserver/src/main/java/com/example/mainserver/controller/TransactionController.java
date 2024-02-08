package com.example.mainserver.controller;

import com.example.mainserver.service.TransactionService;
import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;


/**
 * Controller class for handling transaction-related HTTP requests.
 * It provides an endpoint to fetch consolidated transactions for a given account number and status.
 * Uses the TransactionService to process the requests asynchronously.
 *
 * @author prapti
 */
@RestController
public class TransactionController {

    private final TransactionService transactionService;
    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    /**
     * Constructor to initialize the TransactionController with the TransactionService.
     *
     * @param transactionService The service responsible for handling transaction-related operations.
     */
    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**
     * Handles HTTP GET requests to retrieve consolidated transactions for a given account number and status.
     * Executes asynchronously using CompletableFuture.
     *
     * @param accountNumber The account number for which transactions are to be fetched.
     * @param status        The status of transactions to be included (default is "ALL").
     * @return A CompletableFuture wrapping a ResponseEntity with the consolidated transaction data.
     */
    @GetMapping("/transactions/{accountNumber}")
    public CompletableFuture<ResponseEntity<ConsolidatedTransactionDTO>> getConsolidatedTransactions(
            @PathVariable String accountNumber,
            @RequestParam(defaultValue = "ALL") String status) {

        CompletableFuture<ConsolidatedTransactionDTO> futureResult = transactionService.fetchTransactions(accountNumber, status);

        return futureResult.handle((result, throwable) -> {
            if (throwable != null) {
                log.error("Error occurred while fetching transactions", throwable);
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
            } else {
                return ResponseEntity.ok(result);
            }
        });
    }
}
