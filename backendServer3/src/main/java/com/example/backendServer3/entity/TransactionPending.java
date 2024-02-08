package com.example.backendServer3.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The {@code TransactionPending} class represents an entity for pending transactions in the backend system.
 * It is annotated with {@code @Entity} to indicate that instances of this class are entities that can be stored in the database.
 * Each instance corresponds to a row in the database table for pending transactions.
 *
 * This class contains fields representing various attributes of a pending transaction, such as transaction ID, status, amount, date, and the associated account number.
 * It also includes getter and setter methods for accessing and modifying these attributes.
 *
 * The class is designed to be used in conjunction with Java Persistence API (JPA) for database interaction.
 *
 * @author prapti
 */
@Entity
public class TransactionPending {

    /**
     * The unique identifier for a pending transaction.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The transaction ID associated with the pending transaction.
     */
    private String transactionId;

    /**
     * The status of the pending transaction .
     */
    private String status;

    /**
     * The amount involved in the pending transaction.
     */
    private String amount;

    /**
     * The date of the pending transaction.
     */
    private String date;

    /**
     * The account number associated with the pending transaction.
     */
    private String accountNumber;

    /**
     * Retrieves the unique identifier for the pending transaction.
     *
     * @return The unique identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the pending transaction.
     *
     * @param id The unique identifier to be set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Retrieves the transaction ID associated with the pending transaction.
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
     * Retrieves the amount involved in the pending transaction.
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
     * Retrieves the date of the pending transaction.
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

    /**
     * Retrieves the account number associated with the pending transaction.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number for the pending transaction.
     *
     * @param accountNumber The account number to be set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
