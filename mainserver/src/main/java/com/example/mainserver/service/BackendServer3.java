package com.example.mainserver.service;

import com.example.mainserver.dto.PendingTransactionDTO;
import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

/**
 * Implementation of the {@link BackendServer} interface for handling pending transactions from Backend Server 3.
 *
 */
@Service
public class BackendServer3 implements BackendServer {

    /**
     * WebClient used for making HTTP requests to Backend Server 3.
     */
    private final WebClient webClient;

    /**
     * Constructs a new {@code BackendServer3} instance with the provided WebClient.
     *
     * @param webClient The WebClient used for making HTTP requests.
     */
    public BackendServer3(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Retrieves consolidated transaction data for the specified account number from Backend Server 3.
     *
     * @param accountNumber The account number for which consolidated transactions are requested.
     * @return The consolidated transaction data in the form of {@link ConsolidatedTransactionDTO}.
     */
    @Override
    public ConsolidatedTransactionDTO getTransactions(String accountNumber) {
        // Making an HTTP request to Backend Server 3 to fetch pending transactions
        PendingTransactionDTO pendingTransactionDTO = webClient.get()
                .uri("http://localhost:8082/backendserver3/pending/" + accountNumber)
                .retrieve()
                .bodyToMono(PendingTransactionDTO.class)
                .block();

        // Creating a ConsolidatedTransactionDTO with the retrieved pending transactions
        return new ConsolidatedTransactionDTO<>(
                Collections.emptyList(),
                Collections.emptyList(),
                pendingTransactionDTO.getPending()
        );
    }
}
