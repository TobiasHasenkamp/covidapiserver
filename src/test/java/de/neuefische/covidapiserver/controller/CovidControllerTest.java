package de.neuefische.covidapiserver.controller;

import de.neuefische.covidapiserver.api.CovidApiService;
import de.neuefische.covidapiserver.model.CovidApiNewInfections;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import java.net.URL;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CovidControllerTest {

    @LocalServerPort
    String port;

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    CovidApiService repository;


    @Test
    public void averageTest(){
        //Given
        String baseUrl = "http://localhost:" + port + "/covid/average";
        CovidApiNewInfections[] newCovidApiNewInfections = {
                new CovidApiNewInfections("2020-10-06T00:00:00Z", 307127),
                new CovidApiNewInfections("2020-09-30T00:00:00Z", 292913)};

        //When
        ResponseEntity<Integer> response = restTemplate.getForEntity(
                baseUrl,
                Integer.class);

        Mockito.when(repository.getCovidApiNewInfections())
                .thenReturn(newCovidApiNewInfections);

        //Then
        assertThat(response.getBody(), is(2030));
    }
}