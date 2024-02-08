package com.example.backendServer2.service;

import com.example.backendServer2.dto.TransactionFailureDTO;
import com.example.backendServer2.entity.TransactionFailure;
import com.example.backendServer2.repository.TransactionFailureRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * The {@code TransactionFailureServiceTest} class contains unit tests for the {@code TransactionFailureService}.
 * It utilizes the Mockito framework to mock dependencies and test the behavior of the service methods.
 *
 * This test class focuses on scenarios related to retrieving failure transactions and handling account number validation.
 * It ensures that the service behaves correctly in various situations, including valid and invalid account numbers.
 *
 * @author prapti
 */
class TransactionFailureServiceTest {

    /**
     * Mocked instance of the {@code TransactionFailureRepository} to simulate behavior without accessing the actual repository.
     */
    @Mock
    private TransactionFailureRepository repository;

    /**
     * The instance of {@code TransactionFailureService} under test, with mocked dependencies injected.
     */
    @InjectMocks
    private TransactionFailureService service;

    /**
     * Sets up the test environment before each test method execution by initializing mocks.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Tests the scenario where a valid account number is provided, and the service successfully returns a list of failure transactions.
     */
    @Test
    void getFailureTransactionsDTO_ValidAccountNumber_ReturnsDTOList() {

        String validAccountNumber = "123456789";
        when(repository.existsByAccountNumber(validAccountNumber)).thenReturn(true);
        when(repository.findByAccountNumber(validAccountNumber)).thenReturn(Collections.singletonList(new TransactionFailure()));

        List<TransactionFailureDTO> result = service.getFailureTransactionsDTO(validAccountNumber);

        assertEquals(1, result.size());
        verify(repository, times(1)).findByAccountNumber(validAccountNumber);
    }

    /**
     * Tests the scenario where an invalid account number is provided, and the service throws an IllegalArgumentException.
     */
    @Test
    void getFailureTransactionsDTO_InvalidAccountNumber_ThrowsIllegalArgumentException() {

        String invalidAccountNumber = "invalidAccount";
        when(repository.existsByAccountNumber(invalidAccountNumber)).thenReturn(false);

        assertThrows(IllegalArgumentException.class, () -> service.getFailureTransactionsDTO(invalidAccountNumber));
        verify(repository, never()).findByAccountNumber(any());
    }

    /**
     * Tests the scenario where a null account number is provided, and the service throws an IllegalArgumentException.
     */
    @Test
    void getFailureTransactionsDTO_NullAccountNumber_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> service.getFailureTransactionsDTO(null));
        verify(repository, never()).findByAccountNumber(any());
    }


}

