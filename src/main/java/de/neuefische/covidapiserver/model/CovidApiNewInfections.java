package de.neuefische.covidapiserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CovidApiNewInfections {

    @JsonProperty("Date")
    private String date;
    @JsonProperty("Cases")
    private int cases;

}