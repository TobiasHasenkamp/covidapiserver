package de.neuefische.covidapiserver.service;

import de.neuefische.covidapiserver.api.CovidApiService;
import de.neuefische.covidapiserver.model.CovidApiNewInfections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CovidService {

    private CovidApiService covidApiService;

    @Autowired
    public CovidService(CovidApiService covidApiService) {
        this.covidApiService = covidApiService;
    }

    public List<CovidApiNewInfections> GetLastSevenDays(){

        int i = covidApiService.getCovidApiNewInfections().length -1;
        CovidApiNewInfections[] oldList = covidApiService.getCovidApiNewInfections();
        List<CovidApiNewInfections> filteredList = new ArrayList<CovidApiNewInfections>();

        filteredList.add(oldList[i]);
        filteredList.add(oldList[i-6]);

        return filteredList;
    }

    public String getAllStatus(){
        return this.covidApiService.getAllStatus();
    }

    public int getAverageCasesInLast7Days(){

        int difference;
        int average;

        difference = GetLastSevenDays().get(0).getCases() - GetLastSevenDays().get(1).getCases();
        average = difference / 7;

        return average;
    }
}
