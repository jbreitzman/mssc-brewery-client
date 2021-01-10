package io.breitek.msscbreweryclient.client;

import io.breitek.msscbreweryclient.web.model.BeerDto;
import io.breitek.msscbreweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BreweryClientTest {

    @Autowired
    BreweryClient breweryClient;

    /****************************************/
    /**                                    **/
    /**       Beer DTO TEST Methods        **/
    /**                                    **/
    /****************************************/
    @Test
    void testGetBeerById() {
        BeerDto dto = breweryClient.getBeerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewBeer() {
        // Given
        BeerDto beerDto = BeerDto.builder().beerName("Test Beer").build();
        URI uri = breweryClient.saveNewBeer(beerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateBeer() {
        //Given
        BeerDto beerDto = BeerDto.builder().beerName("Test Beer").build();

        breweryClient.updateBeer(UUID.randomUUID(), beerDto);
    }

    @Test
    void testDeleteBeer() {
        breweryClient.deleteBeer(UUID.randomUUID());
    }

    /****************************************/
    /**                                    **/
    /**     Customer DTO TEST Methods      **/
    /**                                    **/
    /****************************************/

    @Test
    void testGetCustomerById() {
        CustomerDto dto = breweryClient.getCustomerById(UUID.randomUUID());

        assertNotNull(dto);
    }

    @Test
    void testSaveNewCustomer() {
        // Given
        CustomerDto customerDto = CustomerDto.builder().name("Test Customer").build();
        URI uri = breweryClient.saveNewCustomer(customerDto);

        assertNotNull(uri);

        System.out.println(uri.toString());
    }

    @Test
    void testUpdateCustomer() {
        //Given
        CustomerDto customerDto = CustomerDto.builder().name("Test Customer").build();

        breweryClient.updateCustomer(UUID.randomUUID(), customerDto);
    }

    @Test
    void testDeleteCustomer() {
        breweryClient.deleteCustomer(UUID.randomUUID());
    }
}