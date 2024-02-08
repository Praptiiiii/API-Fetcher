package com.example.mainserver.dto;

import java.util.List;

/**
 * DTO (Data Transfer Object) class representing pending transactions for a specific account.
 * Extends the base TransactionDTO class.
 *
 */
public class PendingTransactionDTO extends TransactionDTO {

    /**
     * Account number associated with the pending transactions.
     */
    private String accountNumber;

    /**
     * List of pending transactions.
     */
    private List<TransactionDTO> pending;

    /**
     * Default constructor for PendingTransactionDTO.
     */
    public PendingTransactionDTO() {
        // Initialize fields
        this.accountNumber = null;
        this.pending = null;
    }

    /**
     * Gets the account number associated with the pending transactions.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the pending transactions.
     *
     * @param accountNumber The account number.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the list of pending transactions.
     *
     * @return List of pending transactions.
     */
    public List<TransactionDTO> getPending() {
        return pending;
    }

    /**
     * Sets the list of pending transactions.
     *
     * @param pending List of pending transactions.
     */
    public void setPending(List<TransactionDTO> pending) {
        this.pending = pending;
    }
}
