package com.example.backendServer2.dto;

import java.util.List;

/**
 * The {@code TransactionFailureResponseDTO} class represents a data transfer object (DTO) for the response containing
 * information about failed transactions. It encapsulates the account number and a list of {@code TransactionFailureDTO}
 * objects, providing a structured format for conveying this information between the backend server and clients.
 *
 * @author prapti
 */
public class TransactionFailureResponseDTO {

    /**
     * The account number associated with the failed transactions.
     */
    private String accountNumber;

    /**
     * The list of {@code TransactionFailureDTO} objects representing failed transactions.
     */
    private List<TransactionFailureDTO> failure;

    /**
     * Gets the account number associated with the failed transactions.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the failed transactions.
     *
     * @param accountNumber The account number to be set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the list of {@code TransactionFailureDTO} objects representing failed transactions.
     *
     * @return The list of failed transactions.
     */
    public List<TransactionFailureDTO> getFailure() {
        return failure;
    }

    /**
     * Sets the list of {@code TransactionFailureDTO} objects representing failed transactions.
     *
     * @param failure The list of failed transactions to be set.
     */
    public void setFailure(List<TransactionFailureDTO> failure) {
        this.failure = failure;
    }
}
