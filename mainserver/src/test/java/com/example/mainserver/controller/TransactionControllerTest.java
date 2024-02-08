package com.example.mainserver.controller;

import com.example.mainserver.service.TransactionService;
import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

/**
 * JUnit test class for {@link TransactionController}.
 */
@ExtendWith(MockitoExtension.class)
public class TransactionControllerTest {

    /**
     * Mocked {@link TransactionService} for testing.
     */
    @Mock
    private TransactionService transactionService;

    /**
     * Instance of {@link TransactionController} to be tested.
     */
    @InjectMocks
    private TransactionController transactionController;

    /**
     * Test case for successful retrieval of consolidated transactions.
     *
     * @throws ExecutionException   If the computation threw an exception.
     * @throws InterruptedException If the current thread was interrupted.
     */
    @Test
    public void testGetConsolidatedTransactionsSuccess() throws ExecutionException, InterruptedException {

        String accountNumber = "123456";
        String status = "ALL";
        ConsolidatedTransactionDTO expectedResult = new ConsolidatedTransactionDTO();
        CompletableFuture<ConsolidatedTransactionDTO> futureResult = CompletableFuture.completedFuture(expectedResult);
        when(transactionService.fetchTransactions(anyString(), anyString())).thenReturn(futureResult);

        ResponseEntity<ConsolidatedTransactionDTO> responseEntity = transactionController.getConsolidatedTransactions(accountNumber, status).get();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedResult, responseEntity.getBody());
    }

    /**
     * Test case for handling errors during the retrieval of consolidated transactions.
     *
     * @throws ExecutionException   If the computation threw an exception.
     * @throws InterruptedException If the current thread was interrupted.
     */
    @Test
    public void testGetConsolidatedTransactionsError() throws ExecutionException, InterruptedException {
        String accountNumber = "123456";
        String status = "ALL";
        CompletableFuture<ConsolidatedTransactionDTO> futureResult = new CompletableFuture<>();
        futureResult.completeExceptionally(new RuntimeException("Test error"));

        when(transactionService.fetchTransactions(anyString(), anyString())).thenReturn(futureResult);

        ResponseEntity<ConsolidatedTransactionDTO> responseEntity = transactionController.getConsolidatedTransactions(accountNumber, status).get();
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals(null, responseEntity.getBody());
    }
}
