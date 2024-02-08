package com.example.backendServer2.repository;


import com.example.backendServer2.entity.TransactionFailure;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The {@code TransactionFailureRepository} interface extends {@code JpaRepository} and serves as a data access object (DAO)
 * for interacting with the underlying database to perform CRUD operations on {@code TransactionFailure} entities.
 * It provides methods for retrieving failed transactions based on the account number and checking the existence of
 * failed transactions associated with a specific account number.
 *
 * This interface is designed to work with the Spring Data JPA framework, and its methods are implemented automatically
 * based on naming conventions, reducing the need for explicit queries.
 *
 * @author prapti
 */
public interface TransactionFailureRepository extends JpaRepository<TransactionFailure, Long> {

    /**
     * Retrieves a list of failed transactions based on the specified account number.
     *
     * @param accountNumber The account number for which failed transactions are to be retrieved.
     * @return A list of failed transactions associated with the specified account number.
     */
    List<TransactionFailure> findByAccountNumber(String accountNumber);

    /**
     * Checks the existence of failed transactions associated with the specified account number.
     *
     * @param accountNumber The account number for which the existence of failed transactions is to be checked.
     * @return {@code true} if failed transactions exist for the specified account number, {@code false} otherwise.
     */
    boolean existsByAccountNumber(String accountNumber);
}
