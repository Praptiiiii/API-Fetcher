package com.example.backendServer1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The {@code TransactionSuccess} class represents an entity for storing information about successful transactions
 * in a persistent data store. It is annotated with JPA (Java Persistence API) annotations to specify the mapping
 * between the entity and the database table. Instances of this class are used to store and retrieve data related
 * to successful transactions in the backend server.
 *
 * @author prapti
 */
@Entity
public class TransactionSuccess {

    /**
     * The unique identifier for the transaction success entity.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
     * The account number associated with the transaction.
     */
    private String accountNumber;

    /**
     * Gets the unique identifier for the transaction success entity.
     *
     * @return The transaction success entity identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the transaction success entity.
     *
     * @param id The transaction success entity identifier to be set.
     */
    public void setId(Long id) {
        this.id = id;
    }

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

    /**
     * Gets the account number associated with the transaction.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the transaction.
     *
     * @param accountNumber The account number to be set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
