package com.example.backendServer3.repository;

import com.example.backendServer3.entity.TransactionPending;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The {@code TransactionPendingRepository} interface provides CRUD (Create, Read, Update, Delete) operations
 * for {@code TransactionPending} entities. It extends the {@code JpaRepository} interface, which is a part of
 * the Spring Data JPA framework and provides out-of-the-box implementation for common data access operations.
 * This repository is specifically designed for handling {@code TransactionPending} entities, which are used to
 * represent pending transactions in the backend server3 application.
 *
 * @author prapti
 */
public interface TransactionPendingRepository extends JpaRepository<TransactionPending, Long> {

    /**
     * Retrieves a list of {@code TransactionPending} entities associated with the given account number.
     *
     * @param accountNumber The account number for which pending transactions are to be retrieved.
     * @return A list of {@code TransactionPending} entities associated with the specified account number.
     */
    List<TransactionPending> findByAccountNumber(String accountNumber);

    /**
     * Checks whether any {@code TransactionPending} entity exists with the given account number.
     *
     * @param accountNumber The account number to check for existence.
     * @return {@code true} if a {@code TransactionPending} entity exists with the specified account number,
     *         otherwise {@code false}.
     */
    boolean existsByAccountNumber(String accountNumber);
}
