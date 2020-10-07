package de.neuefische.covidapiserver.api;

import de.neuefische.covidapiserver.model.CovidApiNewInfections;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CovidApiService {

    private final String baseurl="https://api.covid19api.com/country/germany";
    private final RestTemplate restTemplate = new RestTemplate();

    public CovidApiNewInfections[] getCovidApiNewInfections() {
        ResponseEntity<CovidApiNewInfections[]> response = restTemplate.getForEntity(baseurl, CovidApiNewInfections[].class);
        return response.getBody();
    }

    public String getAllStatus(){
        String response = restTemplate.getForObject(baseurl, String.class);
        return response;
    }

    /*
    private final RestTemplate restTemplate = new RestTemplate();

    public CovidApiCountryPerDay[] getCovidApiCountryPerDays() {
        ResponseEntity<CovidApiCountryPerDay[]> response = restTemplate.getForEntity(apiUrl, CovidApiCountryPerDay[].class);
        return response.getBody();
    }
     */

}
