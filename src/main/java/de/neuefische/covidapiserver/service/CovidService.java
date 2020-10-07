package de.neuefische.covidapiserver.service;

import de.neuefische.covidapiserver.api.CovidApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CovidService {

    private CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    public String getAllStatus(){

        return this.covidApiService.getAllStatus();

    }
}
