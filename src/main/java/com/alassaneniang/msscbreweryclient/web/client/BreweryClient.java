package com.alassaneniang.msscbreweryclient.web.client;

import com.alassaneniang.msscbreweryclient.web.model.BeerDTO;
import com.alassaneniang.msscbreweryclient.web.model.CustomerDTO;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties( prefix = "brewery.client", ignoreUnknownFields = false )
public class BreweryClient {

    public final String BEER_PATH_V1 = "/api/v1/beer/";
    private final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
    private final RestTemplate restTemplate;
    private String apihost;

    public BreweryClient ( RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // Beer
    public BeerDTO getBeerById ( UUID beerId ) {
        return restTemplate.getForObject( apihost + BEER_PATH_V1 + beerId.toString(), BeerDTO.class );
    }

    public URI saveNewBeer ( BeerDTO beerDTO ) {
        return restTemplate.postForLocation( apihost + BEER_PATH_V1, beerDTO );
    }

    public void updateBeer ( UUID id, BeerDTO beerDTO ) {
        restTemplate.put( apihost + BEER_PATH_V1 + id.toString(), beerDTO );
    }

    public void deleteBeer ( UUID id ) {
        restTemplate.delete( apihost + BEER_PATH_V1 + id.toString() );
    }

    public void setApihost ( String apihost ) {
        this.apihost = apihost;
    }

    // Customer
    public CustomerDTO getCustomerById ( UUID id ) {
        return restTemplate.getForObject( apihost + CUSTOMER_PATH_V1 + id, CustomerDTO.class );
    }

    public URI saveNewCustomer ( CustomerDTO customerDTO ) {
        return restTemplate.postForLocation( apihost + CUSTOMER_PATH_V1, customerDTO );
    }

    public void updateCustomer ( UUID id, CustomerDTO customerDTO ) {
        restTemplate.put( apihost + CUSTOMER_PATH_V1 + id.toString(), customerDTO );
    }

    public void deleteCustomer ( UUID id ) {
        restTemplate.delete( apihost + CUSTOMER_PATH_V1 + id.toString() );
    }

}
