package com.example.backendServer2.controller;
import com.example.backendServer2.dto.TransactionFailureDTO;
import com.example.backendServer2.dto.TransactionFailureResponseDTO;
import com.example.backendServer2.service.TransactionFailureService;
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
 * The {@code TransactionFailureControllerTest} class contains unit tests for the {@code TransactionFailureController}.
 * It uses the Mockito framework to mock dependencies and test the behavior of the controller methods.
 *
 * This test class focuses on scenarios related to retrieving failure transactions and handling account number validation.
 * It ensures that the controller responds correctly with appropriate HTTP status codes and DTOs.
 *
 * @author prapti
 */
class TransactionFailureControllerTest {

    /**
     * Mocked instance of the {@code TransactionFailureService} to simulate behavior without accessing the actual service.
     */
    @Mock
    private TransactionFailureService service;

    /**
     * The instance of {@code TransactionFailureController} under test, with mocked dependencies injected.
     */
    @InjectMocks
    private TransactionFailureController controller;

    /**
     * Sets up the test environment before each test method execution by initializing mocks.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the scenario where valid account number is provided, and the controller successfully returns a list of failure transactions.
     */
    @Test
    void getFailureTransactions_ValidAccountNumber_ReturnsDTOList() {

        String validAccountNumber = "123456789";
        List<TransactionFailureDTO> failureTransactions = createSampleFailureTransactions(validAccountNumber);
        when(service.getFailureTransactionsDTO(validAccountNumber)).thenReturn(failureTransactions);

        ResponseEntity<TransactionFailureResponseDTO> responseEntity = controller.getFailureTransactions(validAccountNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(validAccountNumber, responseEntity.getBody().getAccountNumber());
        assertEquals(failureTransactions.size(), responseEntity.getBody().getFailure().size());
        verify(service, times(1)).getFailureTransactionsDTO(validAccountNumber);
    }

    /**
     * Tests the scenario where an empty account number is provided, and the controller returns a BAD_REQUEST status.
     */
    @Test
    void getFailureTransactions_EmptyAccountNumber_ReturnsBadRequest() {
        ResponseEntity<TransactionFailureResponseDTO> responseEntity = controller.getFailureTransactions("");

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        verify(service, never()).getFailureTransactionsDTO(any());
    }

    /**
     * Tests the scenario where a valid account number is provided, and the controller successfully returns a list of failure transactions.
     * This test is named incorrectly; it should be "getFailureTransactions_ValidAccountNumber_Success" instead of "getSuccessTransactions_ValidAccountNumber_Success".
     */
    @Test
    void getSuccessTransactions_ValidAccountNumber_Success() {
        String validAccountNumber = "123456789";
        List<TransactionFailureDTO> failureTransactions = createSampleFailureTransactions(validAccountNumber);
        when(service.getFailureTransactionsDTO(validAccountNumber)).thenReturn(failureTransactions);

        ResponseEntity<TransactionFailureResponseDTO> responseEntity = controller.getFailureTransactions(validAccountNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(validAccountNumber, responseEntity.getBody().getAccountNumber());
        assertEquals(failureTransactions.size(), responseEntity.getBody().getFailure().size());
        verify(service, times(1)).getFailureTransactionsDTO(validAccountNumber);
    }

    /**
     * Tests the scenario where a valid account number is provided, and the controller successfully returns a list of failure transactions.
     * This test is named incorrectly; it should be "getFailureTransactions_ValidAccountNumber_ValidTransactions_NoExceptionThrown" instead of "getSuccessTransactions_ValidAccountNumber_ValidTransactions_NoExceptionThrown".
     */
    @Test
    void getSuccessTransactions_ValidAccountNumber_ValidTransactions_NoExceptionThrown() {

        String validAccountNumber = "555555555";
        List<TransactionFailureDTO> successTransactions = createSampleFailureTransactions(validAccountNumber);
        when(service.getFailureTransactionsDTO(validAccountNumber)).thenReturn(successTransactions);

        assertDoesNotThrow(() -> controller.getFailureTransactions(validAccountNumber));
        verify(service, times(1)).getFailureTransactionsDTO(validAccountNumber);
    }

    /**
     * Creates a list of sample failure transactions for testing purposes.
     *
     * @param accountNumber The account number associated with the failure transactions.
     * @return A list of {@code TransactionFailureDTO} objects representing failure transactions.
     */
    private List<TransactionFailureDTO> createSampleFailureTransactions(String accountNumber) {

        List<TransactionFailureDTO> failureTransactions = new ArrayList<>();
        TransactionFailureDTO transaction1 = new TransactionFailureDTO();
        transaction1.setTransactionId("123");
        transaction1.setStatus("failure");
        transaction1.setAmount("500");
        transaction1.setDate("30-05-2023");

        TransactionFailureDTO transaction2 = new TransactionFailureDTO();
        transaction2.setTransactionId("456");
        transaction2.setStatus("failure");
        transaction2.setAmount("100");
        transaction2.setDate("31-05-2023");

        failureTransactions.add(transaction1);
        failureTransactions.add(transaction2);

        return failureTransactions;
    }
}

