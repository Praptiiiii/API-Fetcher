package com.example.mainserver.dto;

import java.util.List;

/**
 * DTO (Data Transfer Object) class representing successful transactions for a specific account.
 * Extends the base TransactionDTO class.
 *
 */
public class SuccessTransactionDTO extends TransactionDTO {

    /**
     * Account number associated with the successful transactions.
     */
    private String accountNumber;

    /**
     * List of successful transactions.
     */
    private List<TransactionDTO> success;

    /**
     * Constructor for SuccessTransactionDTO with account number and a list of successful transactions.
     *
     * @param accountNumber The account number.
     * @param success       List of successful transactions.
     */
    public SuccessTransactionDTO(String accountNumber, List<TransactionDTO> success) {
        this.accountNumber = accountNumber;
        this.success = success;
    }

    /**
     * Default constructor for SuccessTransactionDTO.
     */
    public SuccessTransactionDTO() {
        // Initialize fields
        this.accountNumber = null;
        this.success = null;
    }

    /**
     * Gets the account number associated with the successful transactions.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the successful transactions.
     *
     * @param accountNumber The account number.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the list of successful transactions.
     *
     * @return List of successful transactions.
     */
    public List<TransactionDTO> getSuccess() {
        return success;
    }

    /**
     * Sets the list of successful transactions.
     *
     * @param success List of successful transactions.
     */
    public void setSuccess(List<TransactionDTO> success) {
        this.success = success;
    }
}
