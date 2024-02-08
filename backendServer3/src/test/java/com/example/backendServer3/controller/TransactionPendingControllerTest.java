package com.example.backendServer3.controller;

import com.example.backendServer3.dto.PendingDTO;
import com.example.backendServer3.dto.TransactionPendingDTO;
import com.example.backendServer3.service.TransactionPendingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The {@code TransactionPendingController} class handles HTTP requests related to pending transactions in the backend server3 application.
 * It is responsible for processing requests to retrieve pending transactions for a specific account number and returning the results in a
 * standardized format. This controller interacts with the {@code TransactionPendingService} to perform the necessary business logic operations.
 *
 * @author prapti
 */
class TransactionPendingControllerTest {

    /**
     * The mock instance of {@code TransactionPendingService} used for testing.
     */
    @Mock
    private TransactionPendingService service;

    /**
     * The instance of {@code TransactionPendingController} being tested.
     */
    @InjectMocks
    private TransactionPendingController controller;

    /**
     * Initializes mockito annotations before each test method is executed.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the behavior of the {@code getPendingTransactions} method when a valid account number is provided.
     * Verifies that the response contains the expected status code, account number, and pending transactions.
     */
    @Test
    void getPendingTransactions_ValidAccountNumber_ReturnsDTOList() {
        String validAccountNumber = "123456789";
        List<PendingDTO> pendingTransactions = createSamplePendingTransactions(validAccountNumber);
        when(service.getPendingTransactionsDTO(validAccountNumber)).thenReturn(pendingTransactions);

        ResponseEntity<TransactionPendingDTO> responseEntity = controller.getPendingTransactions(validAccountNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(validAccountNumber, responseEntity.getBody().getAccountNumber());
        assertEquals(pendingTransactions.size(), responseEntity.getBody().getPending().size());
        verify(service, times(1)).getPendingTransactionsDTO(validAccountNumber);
    }

    /**
     * Tests the behavior of the {@code getPendingTransactions} method when an empty account number is provided.
     * Verifies that the response contains the expected status code and no pending transactions are retrieved.
     */
    @Test
    void getPendingTransactions_EmptyAccountNumber_ReturnsBadRequest() {

        ResponseEntity<TransactionPendingDTO> responseEntity = controller.getPendingTransactions("");

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        verify(service, never()).getPendingTransactionsDTO(any());
    }

    /**
     * Tests the behavior of the {@code getPendingTransactions} method when a valid account number is provided, and valid transactions are retrieved.
     * Verifies that no exceptions are thrown during the process.
     */
    @Test
    void getPendingTransactions_ValidAccountNumber_ValidTransactions_NoExceptionThrown() {
        String validAccountNumber = "555555555";
        List<PendingDTO> pendingTransactions = createSamplePendingTransactions(validAccountNumber);
        when(service.getPendingTransactionsDTO(validAccountNumber)).thenReturn(pendingTransactions);

        Assertions.assertDoesNotThrow(() -> controller.getPendingTransactions(validAccountNumber));
        verify(service, times(1)).getPendingTransactionsDTO(validAccountNumber);
    }

    /**
     * Helper method to create a list of sample pending transactions for testing purposes.
     *
     * @param accountNumber The account number associated with the pending transactions.
     * @return A list of {@code PendingDTO} representing pending transactions.
     */
    private List<PendingDTO> createSamplePendingTransactions(String accountNumber) {

        List<PendingDTO> pendingTransactions = new ArrayList<>();
        PendingDTO transaction1 = new PendingDTO();
        transaction1.setTransactionId("123");
        transaction1.setStatus("pending");
        transaction1.setAmount("500");
        transaction1.setDate("30-05-2023");

        PendingDTO transaction2 = new PendingDTO();
        transaction2.setTransactionId("456");
        transaction2.setStatus("pending");
        transaction2.setAmount("100");
        transaction2.setDate("31-05-2023");

        pendingTransactions.add(transaction1);
        pendingTransactions.add(transaction2);

        return pendingTransactions;
    }
}
