package de.neuefische.covidapiserver.controller;

import de.neuefische.covidapiserver.api.CovidApiService;
import de.neuefische.covidapiserver.model.CovidApiNewInfections;
import de.neuefische.covidapiserver.service.CovidService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/covid")
public class CovidController {
    CovidApiService covidApiService = new CovidApiService();

    private CovidService covidService = new CovidService(covidApiService);

    @GetMapping
    public String getAllStatus(){
        return this.covidService.getAllStatus();
    }

    @GetMapping("/covidApi")
    public List<CovidApiNewInfections> getCovidCasesGermany() {
        List<CovidApiNewInfections> germanInfectiony = new ArrayList<>();
        Collections.addAll(germanInfectiony, covidApiService.getCovidApiNewInfections());
        //return germanInfectiony; //this has changed
        return covidService.GetLastSevenDays(); //this is new
    }

}
