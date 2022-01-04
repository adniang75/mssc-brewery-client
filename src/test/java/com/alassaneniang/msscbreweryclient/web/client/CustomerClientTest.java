package com.alassaneniang.msscbreweryclient.web.client;

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
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;

    @Test
    void getCustomerById () {
        CustomerDTO customerDTO = customerClient.getCustomerById( UUID.randomUUID() );
        log.info( "Customer: {}", customerDTO );
        assertNotNull( customerDTO );
    }

    @Test
    void testSaveNewCustomer () {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id( UUID.randomUUID() )
                .name( "Test Customer" )
                .build();
        URI uri = customerClient.saveNewCustomer( customerDTO );
        assertNotNull( uri );
        log.info( "New Customer URI: {}", uri.toString() );
    }

    @Test
    void testUpdateCustomer () {
        CustomerDTO customerDTO = CustomerDTO.builder()
                .id( UUID.randomUUID() )
                .name( "Test Customer" )
                .build();
        customerClient.updateCustomer( UUID.randomUUID(), customerDTO );
        log.info( "Update Customer: {}", customerDTO );
    }

    @Test
    void testDeleteCustomer () {
        UUID id = UUID.randomUUID();
        customerClient.deleteCustomer( id );
        log.info( "Delete Customer with id {}", id );
    }
}