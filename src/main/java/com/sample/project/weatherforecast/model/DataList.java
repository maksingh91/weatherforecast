package com.sample.project.weatherforecast.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@Getter
@Setter
public class DataList {
    private int dt;
    private Main main;
    private ArrayList<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private int visibility;
    private int pop;
    private Rain rain;
    private Sys sys;
    private String dt_txt;
}
