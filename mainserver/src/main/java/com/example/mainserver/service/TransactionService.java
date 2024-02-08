package com.example.mainserver.service;

import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import com.example.mainserver.factory.TransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Service class for fetching consolidated transactions based on the specified account number and status.
 *
 */
@Service
public class TransactionService {

    /**
     * Factory for obtaining the appropriate backend server based on the transaction status.
     */
    private final TransactionFactory backendServerFactory;

    /**
     * Constructs a new {@code TransactionService} instance with the provided backend server factory.
     *
     * @param backendServerFactory The factory for obtaining the appropriate backend server.
     */
    @Autowired
    public TransactionService(TransactionFactory backendServerFactory) {
        this.backendServerFactory = backendServerFactory;
    }

    /**
     * Fetches consolidated transactions asynchronously for the specified account number and status.
     *
     * @param accountNumber The account number for which consolidated transactions are requested.
     * @param status        The status of transactions to fetch ("SUCCESS," "FAILURE," "PENDING," or "ALL").
     * @return A {@link CompletableFuture} containing the consolidated transactions.
     */
    public CompletableFuture<ConsolidatedTransactionDTO> fetchTransactions(String accountNumber, String status) {
       if(!status.equalsIgnoreCase("ALL")&& !status.equalsIgnoreCase("SUCCESS")&& !status.equalsIgnoreCase("FAILURE")&& !status.equalsIgnoreCase("PENDING")){
           throw new IllegalArgumentException("Status Invalid");
       }
        if (status.equalsIgnoreCase("ALL")) {
            CompletableFuture<ConsolidatedTransactionDTO> allPendingTransactions = CompletableFuture
                    .supplyAsync(() -> backendServerFactory.getBackendServer("PENDING").getTransactions(accountNumber));
            CompletableFuture<ConsolidatedTransactionDTO> allSuccessTransactions = CompletableFuture
                    .supplyAsync(() -> backendServerFactory.getBackendServer("SUCCESS").getTransactions(accountNumber));
            CompletableFuture<ConsolidatedTransactionDTO> allFailureTransactions = CompletableFuture
                    .supplyAsync(() -> backendServerFactory.getBackendServer("FAILURE").getTransactions(accountNumber));

            return CompletableFuture.allOf(allPendingTransactions, allSuccessTransactions, allFailureTransactions)
                    .thenApply(ignoredVoid -> new ConsolidatedTransactionDTO(
                            allSuccessTransactions.join().getSuccess(),
                            allFailureTransactions.join().getFailure(),
                            allPendingTransactions.join().getPending()));
        } else {
            CompletableFuture<ConsolidatedTransactionDTO> allPendingTransactions = CompletableFuture
                    .supplyAsync(() -> backendServerFactory.getBackendServer(status).getTransactions(accountNumber));
            CompletableFuture<ConsolidatedTransactionDTO> allSuccessTransactions = CompletableFuture
                    .supplyAsync(() -> backendServerFactory.getBackendServer(status).getTransactions(accountNumber));
            CompletableFuture<ConsolidatedTransactionDTO> allFailureTransactions = CompletableFuture
                    .supplyAsync(() -> backendServerFactory.getBackendServer(status).getTransactions(accountNumber));

            return CompletableFuture.allOf(allPendingTransactions, allSuccessTransactions, allFailureTransactions)
                    .thenApply(ignoredVoid -> new ConsolidatedTransactionDTO(
                            allSuccessTransactions.join().getSuccess(),
                            allFailureTransactions.join().getFailure(),
                            allPendingTransactions.join().getPending()));
        }
    }
}
