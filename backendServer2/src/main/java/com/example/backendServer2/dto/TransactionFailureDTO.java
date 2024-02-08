package com.example.backendServer2.dto;

/**
 * The {@code TransactionFailureDTO} class represents a data transfer object (DTO) for failed transactions.
 * It encapsulates the necessary attributes, such as transactionId, status, amount, and date, to convey information
 * about a failed transaction between different layers of the application. This class is used to facilitate the
 * exchange of data between the backend server and clients.
 *
 * @author prapti
 */
public class TransactionFailureDTO {

    /**
     * The unique identifier for the failed transaction.
     */
    private String transactionId;

    /**
     * The status of the failed transaction, indicating the reason for failure.
     */
    private String status;

    /**
     * The amount involved in the failed transaction.
     */
    private String amount;

    /**
     * The date when the failed transaction occurred.
     */
    private String date;

    /**
     * Gets the unique identifier for the failed transaction.
     *
     * @return The transaction identifier.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the unique identifier for the failed transaction.
     *
     * @param transactionId The transaction identifier to be set.
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * Gets the status of the failed transaction.
     *
     * @return The transaction status.
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status of the failed transaction.
     *
     * @param status The transaction status to be set.
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Gets the amount involved in the failed transaction.
     *
     * @return The transaction amount.
     */
    public String getAmount() {
        return amount;
    }

    /**
     * Sets the amount involved in the failed transaction.
     *
     * @param amount The transaction amount to be set.
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

    /**
     * Gets the date when the failed transaction occurred.
     *
     * @return The transaction date.
     */
    public String getDate() {
        return date;
    }

    /**
     * Sets the date when the failed transaction occurred.
     *
     * @param date The transaction date to be set.
     */
    public void setDate(String date) {
        this.date = date;
    }
}
