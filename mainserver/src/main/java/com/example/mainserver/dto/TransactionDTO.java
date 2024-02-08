package com.example.mainserver.dto;

/**
 * DTO (Data Transfer Object) class representing a generic transaction.
 * This serves as the base class for more specialized transaction DTOs.
 *
 */
public class TransactionDTO {

    /**
     * Unique identifier for the transaction.
     */
    private String transactionId;

    /**
     * Status of the transaction (e.g., success, failure, pending).
     */
    private String status;

    /**
     * Amount associated with the transaction.
     */
    private String amount;

    /**
     * Date when the transaction occurred.
     */
    private String date;

    /**
     * Gets the unique identifier for the transaction.
     *
     * @return The transaction identifier.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the unique identifier for the transaction.
     *
     * @param transactionId The transaction identifier.
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the status of the transaction.
     *
     * @return The transaction status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the transaction.
     *
     * @param status The transaction status.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the amount associated with the transaction.
     *
     * @return The transaction amount.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount associated with the transaction.
     *
     * @param amount The transaction amount.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the date when the transaction occurred.
     *
     * @return The transaction date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date when the transaction occurred.
     *
     * @param date The transaction date.
     */
    public void setDate(String date) {
        this.date = date;
    }
}
