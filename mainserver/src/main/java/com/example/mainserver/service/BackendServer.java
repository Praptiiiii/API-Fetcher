package com.example.mainserver.service;

import com.example.mainserver.dto.ConsolidatedTransactionDTO;

/**
 * Interface representing a backend server that provides consolidated transaction data for a given account number.
 *
 */
public interface BackendServer {

    /**
     * Retrieves consolidated transaction data for the specified account number.
     *
     * @param accountNumber The account number for which consolidated transactions are requested.
     * @return The consolidated transaction data in the form of {@link ConsolidatedTransactionDTO}.
     */
    ConsolidatedTransactionDTO getTransactions(String accountNumber);
}

