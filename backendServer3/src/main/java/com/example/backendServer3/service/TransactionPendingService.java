package com.example.backendServer3.service;

import com.example.backendServer3.entity.TransactionPending;
import com.example.backendServer3.repository.TransactionPendingRepository;
import com.example.backendServer3.dto.PendingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The {@code TransactionPendingService} class provides business logic operations related to
 * {@code TransactionPending} entities in the backend server3 application. It serves as an intermediary
 * between the controller layer and the data access layer, handling the processing of pending transactions.
 * The service includes methods to retrieve pending transactions and validate account numbers.
 *
 * @author prapti
 */
@Service
public class TransactionPendingService {

    /**
     * The {@code TransactionPendingRepository} instance used for data access operations.
     */
    private final TransactionPendingRepository repository;

    /**
     * Constructs a new instance of the {@code TransactionPendingService} class with the provided repository.
     *
     * @param repository The {@code TransactionPendingRepository} instance for data access.
     */
    @Autowired
    public TransactionPendingService(TransactionPendingRepository repository) {
        this.repository = repository;
    }

    /**
     * Retrieves a list of pending transactions in DTO format associated with the given account number.
     *
     * @param accountNumber The account number for which pending transactions are to be retrieved.
     * @return A list of {@code PendingDTO} representing pending transactions.
     * @throws IllegalArgumentException If the provided account number is null, empty, or does not exist in the database.
     */
    public List<PendingDTO> getPendingTransactionsDTO(String accountNumber) {
        validateAccountNumber(accountNumber);
        List<TransactionPending> pendingTransactions = repository.findByAccountNumber(accountNumber);
        return pendingTransactions.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    /**
     * Validates the provided account number.
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
     * Converts a {@code TransactionPending} entity to a {@code PendingDTO}.
     *
     * @param transactionPending The {@code TransactionPending} entity to be converted.
     * @return A {@code PendingDTO} representing the pending transaction.
     */
    PendingDTO convertToDTO(TransactionPending transactionPending) {
        PendingDTO pendingDTO = new PendingDTO();
        pendingDTO.setTransactionId(transactionPending.getTransactionId());
        pendingDTO.setStatus(transactionPending.getStatus());
        pendingDTO.setAmount(transactionPending.getAmount());
        pendingDTO.setDate(transactionPending.getDate());

        return pendingDTO;
    }
}
