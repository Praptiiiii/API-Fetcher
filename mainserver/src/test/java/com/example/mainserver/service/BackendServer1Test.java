package com.example.mainserver.service;

import com.example.mainserver.dto.ConsolidatedTransactionDTO;
import com.example.mainserver.dto.SuccessTransactionDTO;
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
 * JUnit test class for {@link BackendServer1}.
 */
@RunWith(MockitoJUnitRunner.class)
public class BackendServer1Test {

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
     * Instance of {@link BackendServer1} to be tested.
     */
    @InjectMocks
    private BackendServer1 backendServer;

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
     * Test case for successful retrieval of transactions from BackendServer1.
     */
    @Test
    public void testGetTransactions_Success() {

        SuccessTransactionDTO successTransactionDTO = new SuccessTransactionDTO();
        successTransactionDTO.setAccountNumber("123");
        successTransactionDTO.setSuccess(Collections.emptyList());
        when(responseSpec.bodyToMono(SuccessTransactionDTO.class)).thenReturn(Mono.just(successTransactionDTO));

        ConsolidatedTransactionDTO result = backendServer.getTransactions("123");

        assertEquals(Collections.emptyList(), result.getSuccess());
        assertEquals(Collections.emptyList(), result.getFailure());
        assertEquals(Collections.emptyList(), result.getPending());
    }

}
