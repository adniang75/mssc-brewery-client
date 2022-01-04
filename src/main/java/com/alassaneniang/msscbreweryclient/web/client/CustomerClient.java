package com.alassaneniang.msscbreweryclient.web.client;

import com.alassaneniang.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties( prefix = "customer.client", ignoreUnknownFields = false )
public class CustomerClient {

    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String apihost;

    public CustomerClient ( RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost ( String apihost ) {
        this.apihost = apihost;
    }

    // HTTP GET
    public CustomerDTO getCustomerById ( UUID id ) {
        return restTemplate.getForObject( apihost + CUSTOMER_PATH_V1 + id, CustomerDTO.class );
    }

    // HTTP POST
    public URI saveNewCustomer ( CustomerDTO customerDTO ) {
        return restTemplate.postForLocation( apihost + CUSTOMER_PATH_V1, customerDTO );
    }

    // HTTP PUT
    public void updateCustomer ( UUID id, CustomerDTO customerDTO ) {
        restTemplate.put( apihost + CUSTOMER_PATH_V1 + id.toString(), customerDTO );
    }

    // HTTP DELETE
    public void deleteCustomer ( UUID id ) {
        restTemplate.delete( apihost + CUSTOMER_PATH_V1 + id.toString() );
    }

}
