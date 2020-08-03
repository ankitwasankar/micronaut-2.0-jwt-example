package com.webencyclop.app.restcontrollers;

import io.micronaut.http.client.RxHttpClient;
import io.micronaut.test.annotation.MicronautTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.Base64;

@MicronautTest
class HomeRestControllerTest {

    @Inject
    RxHttpClient client;

    @Test
    public void testAuthenticatedCanFetchUsername() {
        String credsEncoded = Base64.getEncoder().encodeToString("sherlock:password".getBytes());
        System.out.println(credsEncoded);
    }
}