package com.example.backendServer3.dto;


import java.util.List;

/**
 * The {@code TransactionPendingDTO} class represents a Data Transfer Object (DTO) for pending transactions.
 * It encapsulates information related to a set of pending transactions for a specific account, including the account number and a list of pending transactions.
 *
 * This class follows the JavaBean convention by providing getter and setter methods for its fields.
 *
 * @author prapti
 */
public class TransactionPendingDTO {

    /**
     * The account number associated with the pending transactions.
     */
    private String accountNumber;

    /**
     * The list of pending transactions for the specified account.
     */
    private List<PendingDTO> pending;

    /**
     * Retrieves the account number associated with the pending transactions.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number for the pending transactions.
     *
     * @param accountNumber The account number to be set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Retrieves the list of pending transactions for the specified account.
     *
     * @return The list of pending transactions.
     */
    public List<PendingDTO> getPending() {
        return pending;
    }

    /**
     * Sets the list of pending transactions for the specified account.
     *
     * @param pending The list of pending transactions to be set.
     */
    public void setPending(List<PendingDTO> pending) {
        this.pending = pending;
    }
}
