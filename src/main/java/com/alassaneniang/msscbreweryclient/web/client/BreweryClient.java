package com.alassaneniang.msscbreweryclient.web.client;

import com.alassaneniang.msscbreweryclient.web.model.BeerDTO;
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
    private final RestTemplate restTemplate;
    private String apihost;

    public BreweryClient ( RestTemplateBuilder restTemplateBuilder ) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public BeerDTO getBeerById ( UUID beerId ) {
        return restTemplate.getForObject( apihost + BEER_PATH_V1 + beerId.toString(), BeerDTO.class );
    }

    public URI saveNewBeer ( BeerDTO beerDTO ) {
        return restTemplate.postForLocation( apihost + BEER_PATH_V1, beerDTO );
    }

    public void setApihost ( String apihost ) {
        this.apihost = apihost;
    }
}
