package com.example.backendServer1.controller;

import com.example.backendServer1.dto.TransactionSuccessResponseDTO;
import com.example.backendServer1.dto.TransactionSuccessDTO;
import com.example.backendServer1.service.TransactionSuccessService;
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
 * The {@code TransactionSuccessControllerTest} class contains unit tests for the {@code TransactionSuccessController}.
 * It utilizes the Mockito framework for mocking dependencies and JUnit for test assertions. The test cases cover
 * scenarios such as handling null or empty account numbers, successful retrieval of transactions, and validating
 * the behavior of the controller under different conditions.
 *
 * @author prapti
 */
class TransactionSuccessControllerTest {

    /**
     * The mocked {@code TransactionSuccessService} used to simulate service behavior.
     */
    @Mock
    private TransactionSuccessService service;

    /**
     * The instance of {@code TransactionSuccessController} with injected mock dependencies.
     */
    @InjectMocks
    private TransactionSuccessController controller;

    /**
     * Initializes the mocks before each test method execution.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the behavior of the controller when a null account number is provided.
     * It should return a BAD_REQUEST response and not invoke the service.
     */
    @Test
    void getSuccessTransactions_NullAccountNumber_ReturnsBadRequest() {

        ResponseEntity<TransactionSuccessResponseDTO> responseEntity = controller.getSuccessTransactions(null);

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        verify(service, times(0)).getSuccessTransactionsDTO(any());
    }

    /**
     * Tests the behavior of the controller when an empty account number is provided.
     * It should return a BAD_REQUEST response and not invoke the service.
     */
    @Test
    void getSuccessTransactions_EmptyAccountNumber_ReturnsBadRequest() {

        ResponseEntity<TransactionSuccessResponseDTO> responseEntity = controller.getSuccessTransactions("");

        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
        assertNull(responseEntity.getBody());
        verify(service, times(0)).getSuccessTransactionsDTO(any());
    }

    /**
     * Tests the successful retrieval of transactions for a valid account number.
     * It should return an OK response with the correct account number and transaction details.
     */
    @Test
    void getSuccessTransactions_ValidAccountNumber_Success() {

        String validAccountNumber = "123456789";
        List<TransactionSuccessDTO> successTransactions = createSampleSuccessTransactions(validAccountNumber);
        when(service.getSuccessTransactionsDTO(validAccountNumber)).thenReturn(successTransactions);

        ResponseEntity<TransactionSuccessResponseDTO> responseEntity = controller.getSuccessTransactions(validAccountNumber);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(validAccountNumber, responseEntity.getBody().getAccountNumber());
        assertEquals(successTransactions.size(), responseEntity.getBody().getSuccess().size());
        verify(service, times(1)).getSuccessTransactionsDTO(validAccountNumber);
    }

    /**
     * Tests the controller's behavior when a valid account number is provided, and no exception is thrown during execution.
     * It should not throw any exceptions during the test.
     */
    @Test
    void getSuccessTransactions_ValidAccountNumber_ValidTransactions_NoExceptionThrown() {

        String validAccountNumber = "555555555";
        List<TransactionSuccessDTO> successTransactions = createSampleSuccessTransactions(validAccountNumber);
        when(service.getSuccessTransactionsDTO(validAccountNumber)).thenReturn(successTransactions);

        Assertions.assertDoesNotThrow(() -> controller.getSuccessTransactions(validAccountNumber));
        verify(service, times(1)).getSuccessTransactionsDTO(validAccountNumber);
    }

    /**
     * Helper method to create a sample list of {@code TransactionSuccessDTO} objects for testing purposes.
     *
     * @param accountNumber The account number associated with the transactions.
     * @return A list of sample {@code TransactionSuccessDTO} objects.
     */
    private List<TransactionSuccessDTO> createSampleSuccessTransactions(String accountNumber) {

        List<TransactionSuccessDTO> successTransactions = new ArrayList<>();
        TransactionSuccessDTO transaction1 = new TransactionSuccessDTO();
        transaction1.setTransactionId("123");
        transaction1.setStatus("success");
        transaction1.setAmount("500");
        transaction1.setDate("30-05-2023");

        TransactionSuccessDTO transaction2 = new TransactionSuccessDTO();
        transaction2.setTransactionId("456");
        transaction2.setStatus("success");
        transaction2.setAmount("100");
        transaction2.setDate("31-05-2023");

        successTransactions.add(transaction1);
        successTransactions.add(transaction2);

        return successTransactions;
    }
}
