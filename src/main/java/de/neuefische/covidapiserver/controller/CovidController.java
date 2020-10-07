package de.neuefische.covidapiserver.controller;

import de.neuefische.covidapiserver.api.CovidApiService;
import de.neuefische.covidapiserver.service.CovidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/covid")
public class CovidController {
    CovidApiService covidApiService = new CovidApiService();

    private CovidService covidService = new CovidService(covidApiService);

    @GetMapping
    public String getAllStatus(){
        return this.covidService.getAllStatus();
    }

}
