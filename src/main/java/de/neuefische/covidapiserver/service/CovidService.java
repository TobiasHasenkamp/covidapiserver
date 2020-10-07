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

        //This is new
        int i = covidApiService.getCovidApiNewInfections().length -1;
        CovidApiNewInfections[] oldList = covidApiService.getCovidApiNewInfections();
        List<CovidApiNewInfections> filteredList = new ArrayList<CovidApiNewInfections>();

        while (i > oldList.length - 7){
            filteredList.add(oldList[i]);
            i--;
        }
        return filteredList;
        //until here
    }

    public String getAllStatus(){

        return this.covidApiService.getAllStatus();

    }
}
