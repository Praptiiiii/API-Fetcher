package com.example.mainserver.service;

import com.example.mainserver.dto.FailureTransactionDTO;
import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;

/**
 * JUnit test class for {@link BackendServer2}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BackendServer2Test {

    /**
     * Mocked {@link WebClient.RequestHeadersUriSpec} for testing.
     */
    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    /**
     * Mocked {@link WebClient.RequestHeadersSpec} for testing.
     */
    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    /**
     * Mocked {@link WebClient.ResponseSpec} for testing.
     */
    @Mock
    private WebClient.ResponseSpec responseSpec;

    /**
     * Mocked {@link WebClient} for testing.
     */
    @Mock
    private WebClient webClient;

    /**
     * Instance of {@link BackendServer2} to be tested.
     */
    @InjectMocks
    private BackendServer2 backendServer;

    /**
     * Setup method to configure mock interactions.
     */
    @Before
    public void setUp() {
        when(webClient.get()).thenReturn(requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(any(String.class))).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(responseSpec);
    }

    /**
     * Test case for failed retrieval of transactions from BackendServer2.
     */
    @Test
    public void testGetTransactions_Failure() {

        FailureTransactionDTO failureTransactionDTO = new FailureTransactionDTO();
        failureTransactionDTO.setAccountNumber("123");
        failureTransactionDTO.setFailure(Collections.emptyList());
        when(responseSpec.bodyToMono(FailureTransactionDTO.class)).thenReturn(Mono.just(failureTransactionDTO));

        ConsolidatedTransactionDTO result = backendServer.getTransactions("123");

        assertEquals(Collections.emptyList(), result.getSuccess());
        assertEquals(Collections.emptyList(), result.getFailure());
        assertEquals(Collections.emptyList(), result.getPending());
    }

}
