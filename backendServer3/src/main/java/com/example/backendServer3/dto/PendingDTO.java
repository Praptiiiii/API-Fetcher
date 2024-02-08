package com.example.backendServer3.dto;

/**
 * The {@code PendingDTO} class represents a Data Transfer Object (DTO) for pending transactions.
 * It encapsulates information related to a pending transaction, such as transaction ID, status, amount, and date.
 *
 * This class follows the JavaBean convention by providing getter and setter methods for its fields.
 *
 * @author prapti
 */
public class PendingDTO {

    /**
     * The unique identifier of the pending transaction.
     */
    private String transactionId;

    /**
     * The status of the pending transaction .
     */
    private String status;

    /**
     * The amount associated with the pending transaction.
     */
    private String amount;

    /**
     * The date on which the pending transaction occurred.
     */
    private String date;

    /**
     * Retrieves the transaction ID of the pending transaction.
     *
     * @return The transaction ID.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transaction ID for the pending transaction.
     *
     * @param transactionId The transaction ID to be set.
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Retrieves the status of the pending transaction.
     *
     * @return The status of the pending transaction.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status for the pending transaction.
     *
     * @param status The status to be set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Retrieves the amount associated with the pending transaction.
     *
     * @return The amount of the pending transaction.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount for the pending transaction.
     *
     * @param amount The amount to be set.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the date on which the pending transaction occurred.
     *
     * @return The date of the pending transaction.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date for the pending transaction.
     *
     * @param date The date to be set.
     */
    public void setDate(String date) {
        this.date = date;
    }
}
