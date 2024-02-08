package com.example.mainserver.service;

import com.example.mainserver.factory.TransactionFactory;
import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * JUnit test class for {@link TransactionService}.
 *
 */
public class TransactionServiceTest {

    /**
     * Mocked {@link TransactionFactory} for testing.
     */
    @Mock
    private TransactionFactory backendServerFactory;

    /**
     * Mocked {@link BackendServer} for testing.
     */
    @Mock
    private BackendServer backendServerMock;

    /**
     * Instance of {@link TransactionService} to be tested.
     */
    @InjectMocks
    private TransactionService transactionService;

    /**
     * Setup method to initialize mock objects.
     */
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test case for fetching transactions for all statuses.
     *
     * @throws ExecutionException   if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    @Test
    public void testFetchTransactionsForAllStatus() throws ExecutionException, InterruptedException {

        String accountNumber = "123456";
        String status = "ALL";

        ConsolidatedTransactionDTO pendingTransactions = new ConsolidatedTransactionDTO();
        ConsolidatedTransactionDTO successTransactions = new ConsolidatedTransactionDTO();
        ConsolidatedTransactionDTO failureTransactions = new ConsolidatedTransactionDTO();

        when(backendServerFactory.getBackendServer("PENDING")).thenReturn(backendServerMock);
        when(backendServerFactory.getBackendServer("SUCCESS")).thenReturn(backendServerMock);
        when(backendServerFactory.getBackendServer("FAILURE")).thenReturn(backendServerMock);

        when(backendServerMock.getTransactions(accountNumber)).thenReturn(pendingTransactions, successTransactions, failureTransactions);

        CompletableFuture<ConsolidatedTransactionDTO> result = transactionService.fetchTransactions(accountNumber, status);

        ConsolidatedTransactionDTO expectedResult = new ConsolidatedTransactionDTO(
                successTransactions.getSuccess(),
                failureTransactions.getFailure(),
                pendingTransactions.getPending()
        );

        assertEquals(expectedResult, result.get());

    }

    /**
     * Test case for fetching transactions for a specific status.
     *
     * @throws ExecutionException   if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    @Test
    public void testFetchTransactionsForSpecificStatus() throws ExecutionException, InterruptedException {

        String accountNumber = "123456";
        String status = "SOME_STATUS";

        ConsolidatedTransactionDTO pendingTransactions = new ConsolidatedTransactionDTO(/* provide pending data */);
        ConsolidatedTransactionDTO successTransactions = new ConsolidatedTransactionDTO(/* provide success data */);
        ConsolidatedTransactionDTO failureTransactions = new ConsolidatedTransactionDTO(/* provide failure data */);

        when(backendServerFactory.getBackendServer(status)).thenReturn(backendServerMock);

        when(backendServerMock.getTransactions(accountNumber)).thenReturn(pendingTransactions, successTransactions, failureTransactions);

        assertThrows(IllegalArgumentException.class, () -> transactionService.fetchTransactions(accountNumber,status));
    }
}
