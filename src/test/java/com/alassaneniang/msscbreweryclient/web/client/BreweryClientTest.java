package com.alassaneniang.msscbreweryclient.web.client;

import com.alassaneniang.msscbreweryclient.web.model.BeerDTO;
import com.alassaneniang.msscbreweryclient.web.model.CustomerDTO;
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

    // Beer
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

    @Test
    void testUpdateBeer () {
        // given
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName( "New Beer" )
                .build();
        client.updateBeer( UUID.randomUUID(), beerDTO );
    }

    @Test
    void testDeleteBeer () {
        client.deleteBeer( UUID.randomUUID() );
    }

    // Customer
    @Test
    void getCustomerById () {
        CustomerDTO customerDTO = client.getCustomerById( UUID.randomUUID() );
        log.info( "Customer: {}", customerDTO );
        assertNotNull( customerDTO );
    }

    @Test
    void testSaveNewCustomer () {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id( UUID.randomUUID() )
                .name( "Test Customer" )
                .build();
        URI uri = client.saveNewCustomer( customerDTO );
        assertNotNull( uri );
        log.info( "New Customer URI: {}", uri.toString() );
    }

    @Test
    void testUpdateCustomer () {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id( UUID.randomUUID() )
                .name( "Test Customer" )
                .build();
        client.updateCustomer( UUID.randomUUID(), customerDTO );
        log.info( "Update Customer: {}", customerDTO );
    }

    @Test
    void testDeleteCustomer () {
        UUID id = UUID.randomUUID();
        client.deleteCustomer( id );
        log.info( "Delete Customer with id {}", id );
    }
}