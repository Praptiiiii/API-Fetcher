package com.example.mainserver.factory;

import com.example.mainserver.service.BackendServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Factory class responsible for providing the appropriate {@link BackendServer} based on the transaction status.
 *
 */
@Component
public class TransactionFactory {

    /**
     * Backend server for successful transactions.
     */
    private final BackendServer backendServer1;

    /**
     * Backend server for failed transactions.
     */
    private final BackendServer backendServer2;

    /**
     * Backend server for pending transactions.
     */
    private final BackendServer backendServer3;

    /**
     * Constructs a new {@code TransactionFactory} with the specified backend servers.
     *
     * @param backendServer1 Backend server for successful transactions.
     * @param backendServer2 Backend server for failed transactions.
     * @param backendServer3 Backend server for pending transactions.
     */
    @Autowired
    public TransactionFactory(
            BackendServer backendServer1,
            BackendServer backendServer2,
            BackendServer backendServer3) {
        this.backendServer1 = backendServer1;
        this.backendServer2 = backendServer2;
        this.backendServer3 = backendServer3;
    }

    /**
     * Gets the appropriate backend server based on the given transaction status.
     *
     * @param status The status of the transaction (e.g., SUCCESS, FAILURE, PENDING).
     * @return The corresponding backend server.
     * @throws IllegalArgumentException If an invalid transaction status is provided.
     */
    public BackendServer getBackendServer(String status) {
        return switch (status.toUpperCase()) {
            case "SUCCESS" -> backendServer1;
            case "FAILURE" -> backendServer2;
            case "PENDING" -> backendServer3;
            default -> throw new IllegalArgumentException("Invalid status");
        };
    }
}
