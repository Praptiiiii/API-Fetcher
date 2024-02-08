package com.example.backendServer1.service;

import com.example.backendServer1.entity.TransactionSuccess;
import com.example.backendServer1.repository.TransactionSuccessRepository;
import com.example.backendServer1.dto.TransactionSuccessDTO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
/**
 * The {@code TransactionSuccessServiceTest} class contains unit tests for the {@code TransactionSuccessService}.
 * It utilizes the Mockito framework for mocking dependencies and JUnit for test assertions. The test cases cover
 * scenarios such as retrieving successful transactions, handling null or empty account numbers, and validating
 * the behavior of the service under different conditions.
 *
 * @author prapti
 */
class TransactionSuccessServiceTest {

    /**
     * The mocked {@code TransactionSuccessRepository} used to simulate repository behavior.
     */
    @Mock
    private TransactionSuccessRepository repository;

    /**
     * The instance of {@code TransactionSuccessService} with injected mock dependencies.
     */
    @InjectMocks
    private TransactionSuccessService service;

    /**
     * Initializes the mocks before each test method execution.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the successful retrieval of {@code TransactionSuccessDTO} objects for a valid account number.
     * It should return a list of DTOs and invoke the repository methods accordingly.
     */
    @Test
    void getSuccessTransactionsDTO_ValidAccountNumber_ReturnsDTOList() {

        String validAccountNumber = "123456789";
        List<TransactionSuccess> successTransactions = createSampleSuccessTransactions(validAccountNumber);
        when(repository.existsByAccountNumber(validAccountNumber)).thenReturn(true);
        when(repository.findByAccountNumber(validAccountNumber)).thenReturn(successTransactions);

        List<TransactionSuccessDTO> result = service.getSuccessTransactionsDTO(validAccountNumber);
        assertEquals(successTransactions.size(), result.size());
        verify(repository, times(1)).existsByAccountNumber(validAccountNumber);
        verify(repository, times(1)).findByAccountNumber(validAccountNumber);
    }

    /**
     * Tests the behavior of the service when a null account number is provided.
     * It should throw an {@code IllegalArgumentException} and not invoke any repository methods.
     */
    @Test
    void getSuccessTransactionsDTO_NullAccountNumber_ThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> service.getSuccessTransactionsDTO(null));
        verify(repository, never()).existsByAccountNumber(any());
        verify(repository, never()).findByAccountNumber(any());
    }

    /**
     * Tests the behavior of the service when an empty account number is provided.
     * It should throw an {@code IllegalArgumentException} and not invoke any repository methods.
     */
    @Test
    void getSuccessTransactionsDTO_EmptyAccountNumber_ThrowsIllegalArgumentException() {

        assertThrows(IllegalArgumentException.class, () -> service.getSuccessTransactionsDTO(""));
        verify(repository, never()).existsByAccountNumber(any());
        verify(repository, never()).findByAccountNumber(any());
    }

    /**
     * Tests the behavior of the service when a non-existent account number is provided.
     * It should throw an {@code IllegalArgumentException} and invoke the repository method to check account existence.
     */
    @Test
    void getSuccessTransactionsDTO_NonExistentAccountNumber_ThrowsIllegalArgumentException() {

        String nonExistentAccountNumber = "999999999";
        when(repository.existsByAccountNumber(nonExistentAccountNumber)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.getSuccessTransactionsDTO(nonExistentAccountNumber));
        verify(repository, times(1)).existsByAccountNumber(nonExistentAccountNumber);
        verify(repository, never()).findByAccountNumber(any());
    }

    /**
     * Helper method to create a sample list of {@code TransactionSuccess} entities for testing purposes.
     *
     * @param accountNumber The account number associated with the transactions.
     * @return A list of sample {@code TransactionSuccess} entities.
     */
    private List<TransactionSuccess> createSampleSuccessTransactions(String accountNumber) {

        TransactionSuccess transaction1 = new TransactionSuccess();
        transaction1.setTransactionId("123");
        transaction1.setStatus("success");
        transaction1.setAmount("500");
        transaction1.setDate("30-05-2023");

        TransactionSuccess transaction2 = new TransactionSuccess();
        transaction2.setTransactionId("456");
        transaction2.setStatus("success");
        transaction2.setAmount("100");
        transaction2.setDate("31-05-2023");

        return Arrays.asList(transaction1, transaction2);
    }
}
