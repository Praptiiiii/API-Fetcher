package com.example.mainserver.dto;

import java.util.List;

/**
 * DTO (Data Transfer Object) class representing failure transactions for a specific account.
 * Extends the base TransactionDTO class.
 *
 */
public class FailureTransactionDTO extends TransactionDTO {

    /**
     * Account number associated with the failure transactions.
     */
    private String accountNumber;

    /**
     * List of failure transactions.
     */
    private List<TransactionDTO> failure;

    /**
     * Default constructor for FailureTransactionDTO.
     */
    public FailureTransactionDTO() {
        // Initialize fields
        this.accountNumber = null;
        this.failure = null;
    }

    /**
     * Gets the account number associated with the failure transactions.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the failure transactions.
     *
     * @param accountNumber The account number.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the list of failure transactions.
     *
     * @return List of failure transactions.
     */
    public List<TransactionDTO> getFailure() {
        return failure;
    }

    /**
     * Sets the list of failure transactions.
     *
     * @param failure List of failure transactions.
     */
    public void setFailure(List<TransactionDTO> failure) {
        this.failure = failure;
    }
}
