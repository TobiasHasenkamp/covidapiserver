package de.neuefische.covidapiserver.service;

import de.neuefische.covidapiserver.api.CovidApiService;
import de.neuefische.covidapiserver.model.CovidApiNewInfections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CovidService {

    private CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    public List<CovidApiNewInfections> getLastSevenDays(){

        CovidApiNewInfections[] covidApiNewInfections = covidApiService.getCovidApiNewInfections();
        List<CovidApiNewInfections> filteredList = new ArrayList<CovidApiNewInfections>();
        filteredList.add(covidApiNewInfections[covidApiNewInfections.length -1]);
        filteredList.add(covidApiNewInfections[covidApiNewInfections.length -7]);

        return filteredList;
    }

    public String getAllStatus(){
        return this.covidApiService.getAllStatus();
    }

    public int getAverageCasesInLast7Days(){

        List<CovidApiNewInfections> lastSevenDays = getLastSevenDays();

        int difference = lastSevenDays.get(0).getCases() - lastSevenDays.get(1).getCases();
        int average = difference / 7;

        return average;
    }
}
