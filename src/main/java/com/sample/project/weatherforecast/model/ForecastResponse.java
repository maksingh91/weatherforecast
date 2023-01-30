package com.sample.project.weatherforecast.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Data
public class ForecastResponse {
    private String date;
    private String highTemp;
    private String lowTemp;
    private List<String> predictions=new ArrayList<String>();
}
