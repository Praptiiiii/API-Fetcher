package com.example.mainserver.service;

import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import com.example.mainserver.dto.FailureTransactionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

/**
 * Implementation of the {@link BackendServer} interface for handling failed transactions from Backend Server 2.
 *
 */
@Service
public class BackendServer2 implements BackendServer {

    /**
     * WebClient used for making HTTP requests to Backend Server 2.
     */
    private final WebClient webClient;

    /**
     * Constructs a new {@code BackendServer2} instance with the provided WebClient.
     *
     * @param webClient The WebClient used for making HTTP requests.
     */
    public BackendServer2(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Retrieves consolidated transaction data for the specified account number from Backend Server 2.
     *
     * @param accountNumber The account number for which consolidated transactions are requested.
     * @return The consolidated transaction data in the form of {@link ConsolidatedTransactionDTO}.
     */
    @Override
    public ConsolidatedTransactionDTO getTransactions(String accountNumber) {
        // Making an HTTP request to Backend Server 2 to fetch failed transactions
        FailureTransactionDTO failureTransactionDTO = webClient.get()
                .uri("http://localhost:8081/backendserver2/failure/" + accountNumber)
                .retrieve()
                .bodyToMono(FailureTransactionDTO.class)
                .block();

        // Creating a ConsolidatedTransactionDTO with the retrieved failed transactions
        return new ConsolidatedTransactionDTO<>(
                Collections.emptyList(),
                failureTransactionDTO.getFailure(),
                Collections.emptyList()
        );
    }
}
