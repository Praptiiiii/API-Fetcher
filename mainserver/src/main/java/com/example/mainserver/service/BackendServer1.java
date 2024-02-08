package com.example.mainserver.service;

import com.example.mainserver.dto.SuccessTransactionDTO;
import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;

/**
 * Implementation of the {@link BackendServer} interface for handling successful transactions from Backend Server 1.
 *
 */
@Service
public class BackendServer1 implements BackendServer {

    /**
     * WebClient used for making HTTP requests to Backend Server 1.
     */
    public final WebClient webClient;

    /**
     * Constructs a new {@code BackendServer1} instance with the provided WebClient.
     *
     * @param webClient The WebClient used for making HTTP requests.
     */
    public BackendServer1(WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Retrieves consolidated transaction data for the specified account number from Backend Server 1.
     *
     * @param accountNumber The account number for which consolidated transactions are requested.
     * @return The consolidated transaction data in the form of {@link ConsolidatedTransactionDTO}.
     */
    @Override
    public ConsolidatedTransactionDTO getTransactions(String accountNumber) {

        SuccessTransactionDTO successTransactionDTO = webClient.get()
                .uri("http://localhost:8080/backendserver1/success/" + accountNumber)
                .retrieve()
                .bodyToMono(SuccessTransactionDTO.class)
                .block();

        return new ConsolidatedTransactionDTO<>(
                successTransactionDTO.getSuccess(),
                Collections.emptyList(),
                Collections.emptyList()
        );
    }
}
