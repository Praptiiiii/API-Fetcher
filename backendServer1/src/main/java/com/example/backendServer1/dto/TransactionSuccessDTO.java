package com.example.backendServer1.dto;

/**
 * The {@code TransactionSuccessDTO} class represents a Data Transfer Object (DTO) for successful transactions.
 * It encapsulates information about a successful transaction, including its unique identifier, status, amount,
 * and date. Instances of this class are used to transfer data between the backend server and the frontend or
 * other components of the system.
 *
 * @author prapti
 */
public class TransactionSuccessDTO {

    /**
     * The unique identifier for the transaction.
     */
    private String transactionId;

    /**
     * The status of the transaction, indicating whether it was successful or not.
     */
    private String status;

    /**
     * The amount involved in the transaction.
     */
    private String amount;

    /**
     * The date when the transaction occurred.
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
     * @param transactionId The transaction identifier to be set.
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
     * @param status The transaction status to be set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the amount involved in the transaction.
     *
     * @return The transaction amount.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount involved in the transaction.
     *
     * @param amount The transaction amount to be set.
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
     * @param date The transaction date to be set.
     */
    public void setDate(String date) {
        this.date = date;
    }
}
