package com.example.mainserver.dto;

import java.util.List;
import java.util.Objects;

/**
 * DTO (Data Transfer Object) class representing consolidated transactions.
 * Contains lists of transactions categorized as success, failure, and pending.
 *
 * @param <T> The type of transaction DTO.
 */
public class ConsolidatedTransactionDTO<T extends TransactionDTO> {

    /**
     * List of successful transactions.
     */
    private List<TransactionDTO> success;

    /**
     * List of failed transactions.
     */
    private List<TransactionDTO> failure;

    /**
     * List of pending transactions.
     */
    private List<TransactionDTO> pending;

    /**
     * Constructs a ConsolidatedTransactionDTO with specified lists of transactions.
     *
     * @param success List of successful transactions.
     * @param failure List of failed transactions.
     * @param pending List of pending transactions.
     */
    public ConsolidatedTransactionDTO(List<TransactionDTO> success, List<TransactionDTO> failure, List<TransactionDTO> pending) {
        this.success = success;
        this.failure = failure;
        this.pending = pending;
    }

    /**
     * Default constructor for ConsolidatedTransactionDTO.
     */
    public ConsolidatedTransactionDTO() {
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

    /**
     * Gets the list of failed transactions.
     *
     * @return List of failed transactions.
     */
    public List<TransactionDTO> getFailure() {
        return failure;
    }

    /**
     * Sets the list of failed transactions.
     *
     * @param failure List of failed transactions.
     */
    public void setFailure(List<TransactionDTO> failure) {
        this.failure = failure;
    }

    /**
     * Gets the list of pending transactions.
     *
     * @return List of pending transactions.
     */
    public List<TransactionDTO> getPending() {
        return pending;
    }

    /**
     * Sets the list of pending transactions.
     *
     * @param pending List of pending transactions.
     */
    public void setPending(List<TransactionDTO> pending) {
        this.pending = pending;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     *
     * @param obj The reference object with which to compare.
     * @return {@code true} if this object is the same as the obj argument; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ConsolidatedTransactionDTO that = (ConsolidatedTransactionDTO) obj;
        return Objects.equals(success, that.success) &&
                Objects.equals(failure, that.failure) &&
                Objects.equals(pending, that.pending);
    }

    /**
     * Returns a hash code value for the object.
     *
     * @return A hash code value for this object.
     */
    @Override
    public int hashCode() {
        return Objects.hash(success, failure, pending);
    }
}
