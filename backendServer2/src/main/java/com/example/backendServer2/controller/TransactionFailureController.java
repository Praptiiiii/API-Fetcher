package com.example.backendServer2.controller;

import com.example.backendServer2.dto.TransactionFailureResponseDTO;
import com.example.backendServer2.dto.TransactionFailureDTO;
import com.example.backendServer2.service.TransactionFailureService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The {@code TransactionFailureController} class is a Spring MVC controller responsible for handling HTTP requests
 * related to retrieving information about failed transactions. It defines a RESTful endpoint "/backendserver2/failure/{accountNumber}"
 * for retrieving a list of failed transactions associated with a specific account number. This controller is annotated
 * with {@code @RestController} and {@code @RequestMapping} to specify the base mapping for all the endpoints within
 * this class.
 *
 * It also uses validation annotations, such as {@code @NotEmpty}, to ensure that the provided account number is not empty,
 * and {@code @Autowired} to inject the {@code TransactionFailureService} dependency. The actual handling of the request
 * is done in the {@code getFailureTransactions} method, which invokes the service to retrieve failure transactions and
 * constructs a response entity with the appropriate data.
 *
 * @author prapti
 */
@RestController
@RequestMapping("/backendserver2")
@Validated
public class TransactionFailureController {

    /**
     * The service responsible for business logic related to failed transactions.
     */
    @Autowired
    private TransactionFailureService service;

    /**
     * Handles the GET request to retrieve a list of failed transactions for the specified account number.
     *
     * @param accountNumber The account number for which failed transactions are to be retrieved.
     * @return A {@code ResponseEntity} containing a {@code TransactionFailureResponseDTO} with details about the
     *         failed transactions or a BAD_REQUEST response if the account number is empty.
     */
    @GetMapping("/failure/{accountNumber}")
    public ResponseEntity<TransactionFailureResponseDTO> getFailureTransactions(@PathVariable @NotEmpty(message = "Account number cannot be empty") String accountNumber) {
        if (accountNumber.isEmpty()) {
            return ResponseEntity.badRequest().body(null);
        }
        List<TransactionFailureDTO> failureTransactions = service.getFailureTransactionsDTO(accountNumber);

        TransactionFailureResponseDTO responseDTO = new TransactionFailureResponseDTO();
        responseDTO.setAccountNumber(accountNumber);
        responseDTO.setFailure(failureTransactions);

        return ResponseEntity.ok(responseDTO);
    }


}
