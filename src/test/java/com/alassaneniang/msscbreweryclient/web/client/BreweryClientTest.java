package com.alassaneniang.msscbreweryclient.web.client;

import com.alassaneniang.msscbreweryclient.web.model.BeerDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById () {

        BeerDTO beerDTO = client.getBeerById( UUID.randomUUID() );
        assertNotNull( beerDTO );

    }
}