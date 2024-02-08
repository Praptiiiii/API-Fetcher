package com.example.backendServer2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * The {@code TransactionFailure} class represents an entity in the backend server, mapping to a table in the
 * underlying database. It captures information about failed transactions, such as the unique identifier, transaction
 * details (transactionId, status, amount, date), and the associated account number. This entity is annotated with
 * {@code @Entity} to mark it as a JPA entity, and it includes {@code @Id} and {@code @GeneratedValue} annotations to
 * specify the primary key generation strategy.
 *
 * This class is used for persisting and retrieving information about failed transactions in the backend server.
 *
 * @author prapti
 */
@Entity
public class TransactionFailure {

    /**
     * The unique identifier for the failed transaction.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * The transaction identifier for the failed transaction.
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
     * The account number associated with the failed transaction.
     */
    private String accountNumber;

    /**
     * Gets the unique identifier for the failed transaction.
     *
     * @return The transaction identifier.
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the failed transaction.
     *
     * @param id The transaction identifier to be set.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the transaction identifier for the failed transaction.
     *
     * @return The transaction identifier.
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the transaction identifier for the failed transaction.
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

    /**
     * Gets the account number associated with the failed transaction.
     *
     * @return The account number.
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number associated with the failed transaction.
     *
     * @param accountNumber The account number to be set.
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
