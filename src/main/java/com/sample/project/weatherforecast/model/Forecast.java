package com.sample.project.weatherforecast.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter
@Setter
public class Forecast {

    private String cod;
    private int message;
    private int cnt;
    private ArrayList<DataList> list;
}
