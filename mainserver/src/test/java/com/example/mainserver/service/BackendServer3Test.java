package com.example.mainserver.service;

import com.example.mainserver.dto.PendingTransactionDTO;
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
 * JUnit test class for {@link BackendServer3}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BackendServer3Test {

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
     * Instance of {@link BackendServer3} to be tested.
     */
    @InjectMocks
    private BackendServer3 backendServer;

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
     * Test case for successful retrieval of pending transactions from BackendServer3.
     */
    @Test
    public void testGetTransactions_Pending() {

        PendingTransactionDTO pendingTransactionDTO = new PendingTransactionDTO();
        pendingTransactionDTO.setAccountNumber("123");
        pendingTransactionDTO.setPending(Collections.emptyList());
        when(responseSpec.bodyToMono(PendingTransactionDTO.class)).thenReturn(Mono.just(pendingTransactionDTO));

        ConsolidatedTransactionDTO result = backendServer.getTransactions("123");
        assertEquals(Collections.emptyList(), result.getSuccess());
        assertEquals(Collections.emptyList(), result.getFailure());
        assertEquals(Collections.emptyList(), result.getPending());
    }

}
