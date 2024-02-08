package com.example.backendServer2.service;

import com.example.backendServer2.dto.TransactionFailureDTO;
import com.example.backendServer2.repository.TransactionFailureRepository;
import com.example.backendServer2.entity.TransactionFailure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * The {@code TransactionFailureService} class provides business logic for handling failed transactions in the backend server.
 * It encapsulates methods for retrieving failed transactions, validating account numbers, and converting
 * {@code TransactionFailure} entities to corresponding DTOs ({@code TransactionFailureDTO}).
 *
 * This service class is designed to interact with the {@code TransactionFailureRepository} for data access.
 *
 * @author prapti
 */
@Service
public class TransactionFailureService {

    /**
     * The repository responsible for data access operations on failed transactions.
     */
    private final TransactionFailureRepository repository;

    /**
     * Constructs a new instance of {@code TransactionFailureService} with the specified repository dependency.
     *
     * @param repository The {@code TransactionFailureRepository} used for data access operations.
     */
    @Autowired
    public TransactionFailureService(TransactionFailureRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of failed transactions in DTO format for the specified account number.
     *
     * @param accountNumber The account number for which failed transactions are to be retrieved.
     * @return A list of {@code TransactionFailureDTO} objects representing failed transactions.
     * @throws IllegalArgumentException If the account number is null, empty, or does not exist in the database.
     */
    public List<TransactionFailureDTO> getFailureTransactionsDTO(String accountNumber) {
        validateAccountNumber(accountNumber);
        List<TransactionFailure> failureTransactions = repository.findByAccountNumber(accountNumber);
        return failureTransactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Validates the specified account number by checking for null, empty, and existence in the database.
     *
     * @param accountNumber The account number to be validated.
     * @throws IllegalArgumentException If the account number is null, empty, or does not exist in the database.
     */
    private void validateAccountNumber(String accountNumber) {

        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }

        if (!repository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Account number does not exist in the database");
        }

    }

    /**
     * Converts a {@code TransactionFailure} entity to a corresponding {@code TransactionFailureDTO}.
     *
     * @param failure The {@code TransactionFailure} entity to be converted.
     * @return The {@code TransactionFailureDTO} representing the failed transaction.
     */
    private TransactionFailureDTO convertToDTO(TransactionFailure failure) {
        TransactionFailureDTO dto = new TransactionFailureDTO();
        dto.setTransactionId(failure.getTransactionId());
        dto.setStatus(failure.getStatus());
        dto.setAmount(failure.getAmount());
        dto.setDate(failure.getDate());
        return dto;
    }
}
