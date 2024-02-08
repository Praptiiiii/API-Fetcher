package com.example.backendServer1.service;

import com.example.backendServer1.repository.TransactionSuccessRepository;
import com.example.backendServer1.dto.TransactionSuccessDTO;
import com.example.backendServer1.entity.TransactionSuccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code TransactionSuccessService} class provides business logic for handling successful transactions.
 * It interacts with the {@link TransactionSuccessRepository} to retrieve information from the underlying
 * data store and converts entity data to DTOs for presentation to clients. Additionally, it includes a method
 * for validating account numbers and a conversion method to transform {@link TransactionSuccess} entities
 * into {@link TransactionSuccessDTO} objects.
 *
 * @author prapti
 */
@Service
public class TransactionSuccessService {

    /**
     * The repository used to perform CRUD operations on {@link TransactionSuccess} entities.
     */
    @Autowired
    private TransactionSuccessRepository repository;

    /**
     * Retrieves a list of {@link TransactionSuccessDTO} objects for the specified account number.
     *
     * @param accountNumber The account number for which successful transactions are to be retrieved.
     * @return A list of {@link TransactionSuccessDTO} objects representing successful transactions.
     */
    public List<TransactionSuccessDTO> getSuccessTransactionsDTO(String accountNumber) {
        validateAccountNumber(accountNumber);
        List<TransactionSuccess> successTransactions = repository.findByAccountNumber(accountNumber);
        return successTransactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Validates the provided account number, ensuring it is not null, empty, and exists in the database.
     *
     * @param accountNumber The account number to be validated.
     * @throws IllegalArgumentException if the account number is null, empty, or does not exist in the database.
     */
    void validateAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be null or empty");
        }

        if (!repository.existsByAccountNumber(accountNumber)) {
            throw new IllegalArgumentException("Account number does not exist in the database");
        }
    }

    /**
     * Converts a {@link TransactionSuccess} entity into a {@link TransactionSuccessDTO} object.
     *
     * @param success The {@link TransactionSuccess} entity to be converted.
     * @return A {@link TransactionSuccessDTO} object representing the successful transaction.
     */
    TransactionSuccessDTO convertToDTO(TransactionSuccess success) {
        TransactionSuccessDTO dto = new TransactionSuccessDTO();
        dto.setTransactionId(success.getTransactionId());
        dto.setStatus(success.getStatus());
        dto.setAmount(success.getAmount());
        dto.setDate(success.getDate());
        return dto;
    }
}
