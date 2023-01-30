package com.sample.project.weatherforecast.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Weather {
    private int id;
    private String main;
    private String description;
    private String icon;
}
