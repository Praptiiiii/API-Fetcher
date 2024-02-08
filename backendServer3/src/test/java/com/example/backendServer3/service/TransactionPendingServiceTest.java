package com.example.backendServer3.service;

import com.example.backendServer3.entity.TransactionPending;
import com.example.backendServer3.repository.TransactionPendingRepository;
import com.example.backendServer3.dto.PendingDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The {@code TransactionPendingServiceTest} class contains unit tests for the {@code TransactionPendingService} class.
 * It validates the behavior of the service methods and ensures proper handling of exceptions and conversion to DTOs.
 *
 * @author prapti
 */
class TransactionPendingServiceTest {

    /**
     * The mock instance of {@code TransactionPendingRepository} used for testing.
     */
    @Mock
    private TransactionPendingRepository repository;

    /**
     * The instance of {@code TransactionPendingService} being tested.
     */
    @InjectMocks
    private TransactionPendingService service;

    /**
     * Initializes mockito annotations before each test method is executed.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the behavior of the {@code getPendingTransactionsDTO} method when an empty account number is provided.
     * Verifies that an {@code IllegalArgumentException} is thrown, and no repository method is invoked.
     */
    @Test
    void getPendingTransactionsDTO_EmptyAccountNumber_ThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> service.getPendingTransactionsDTO(""));
        verify(repository, never()).findByAccountNumber(any());
    }

    /**
     * Tests the behavior of the {@code getPendingTransactionsDTO} method when a null account number is provided.
     * Verifies that an {@code IllegalArgumentException} is thrown, and no repository method is invoked.
     */
    @Test
    void getPendingTransactionsDTO_NullAccountNumber_ThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> service.getPendingTransactionsDTO(null));
        verify(repository, never()).findByAccountNumber(any());
    }

    /**
     * Tests the behavior of the {@code convertToDTO} method when a valid transaction is provided.
     * Verifies that the conversion to {@code PendingDTO} is successful with matching attribute values.
     */
    @Test
    void convertToDTO_ValidTransaction_ReturnsPendingDTO() {

        TransactionPending transactionPending = createSamplePendingTransaction();

        PendingDTO result = service.convertToDTO(transactionPending);

        assertNotNull(result);
        assertEquals(transactionPending.getTransactionId(), result.getTransactionId());
        assertEquals(transactionPending.getStatus(), result.getStatus());
        assertEquals(transactionPending.getAmount(), result.getAmount());
        assertEquals(transactionPending.getDate(), result.getDate());
    }

    /**
     * Helper method to create a list of sample pending transactions for testing purposes.
     *
     * @param accountNumber The account number associated with the pending transactions.
     * @return A list of {@code TransactionPending} representing pending transactions.
     */
    private List<TransactionPending> createSamplePendingTransactions(String accountNumber) {

        List<TransactionPending> pendingTransactions = new ArrayList<>();
        TransactionPending transaction1 = createSamplePendingTransaction();
        TransactionPending transaction2 = createSamplePendingTransaction();

        pendingTransactions.add(transaction1);
        pendingTransactions.add(transaction2);

        return pendingTransactions;
    }

    /**
     * Helper method to create a sample pending transaction for testing purposes.
     *
     * @return A {@code TransactionPending} object representing a pending transaction.
     */
    private TransactionPending createSamplePendingTransaction() {
        TransactionPending transactionPending = new TransactionPending();
        transactionPending.setTransactionId("123");
        transactionPending.setStatus("pending");
        transactionPending.setAmount("500");
        transactionPending.setDate("30-05-2023");
        return transactionPending;
    }
}
