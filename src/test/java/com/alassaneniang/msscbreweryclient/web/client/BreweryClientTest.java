package com.alassaneniang.msscbreweryclient.web.client;

import com.alassaneniang.msscbreweryclient.web.model.BeerDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@Slf4j
@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient client;

    @Test
    void getBeerById () {
        BeerDTO beerDTO = client.getBeerById( UUID.randomUUID() );
        assertNotNull( beerDTO );
    }

    @Test
    void testSaveNewBeer () {
        // given
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName( "New Beer" )
                .build();
        URI uri = client.saveNewBeer( beerDTO );
        assertNotNull( uri );
        log.info(
                "New Beer URI: " + uri.toString() );
    }
}