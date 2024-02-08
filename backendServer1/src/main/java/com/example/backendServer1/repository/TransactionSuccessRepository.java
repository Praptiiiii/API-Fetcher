package com.example.backendServer1.repository;

import com.example.backendServer1.entity.TransactionSuccess;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * The {@code TransactionSuccessRepository} interface extends {@link JpaRepository} and serves as a data access
 * repository for managing {@link TransactionSuccess} entities. It provides methods to perform CRUD operations
 * on the underlying database table storing information about successful transactions. The interface includes
 * methods for retrieving a list of successful transactions based on the account number and checking the existence
 * of transactions for a given account number.
 *
 * @author prapti
 */
public interface TransactionSuccessRepository extends JpaRepository<TransactionSuccess, Long> {

    /**
     * Retrieves a list of successful transactions for the specified account number.
     *
     * @param accountNumber The account number for which successful transactions are to be retrieved.
     * @return A list of {@link TransactionSuccess} entities associated with the specified account number.
     */
    List<TransactionSuccess> findByAccountNumber(String accountNumber);

    /**
     * Checks the existence of successful transactions for the specified account number.
     *
     * @param accountNumber The account number for which the existence of transactions is to be checked.
     * @return {@code true} if successful transactions exist for the specified account number, {@code false} otherwise.
     */
    boolean existsByAccountNumber(String accountNumber);
}
