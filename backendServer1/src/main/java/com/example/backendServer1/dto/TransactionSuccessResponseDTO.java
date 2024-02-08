package com.example.backendServer1.dto;

import java.util.List;

/**
 * The {@code TransactionSuccessResponseDTO} class represents a Data Transfer Object (DTO) for the response
 * containing successful transactions. It encapsulates information about the account number and a list of
 * {@link TransactionSuccessDTO} instances representing successful transactions for that account. Instances
 * of this class are used to transfer data between the backend server and the frontend or other components
 * of the system.
 *
 * @author prapti
 */
public class TransactionSuccessResponseDTO {

    /**
     * The account number for which successful transactions are being retrieved.
     */
    private String accountNumber;

    /**
     * The list of {@link TransactionSuccessDTO} instances representing successful transactions for the account.
     */
    private List<TransactionSuccessDTO> success;

    /**
     * Gets the account number for which successful transactions are being retrieved.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number for which successful transactions are being retrieved.
     *
     * @param accountNumber The account number to be set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the list of {@link TransactionSuccessDTO} instances representing successful transactions for the account.
     *
     * @return The list of successful transactions.
     */
    public List<TransactionSuccessDTO> getSuccess() {
        return success;
    }

    /**
     * Sets the list of {@link TransactionSuccessDTO} instances representing successful transactions for the account.
     *
     * @param success The list of successful transactions to be set.
     */
    public void setSuccess(List<TransactionSuccessDTO> success) {
        this.success = success;
    }
}
