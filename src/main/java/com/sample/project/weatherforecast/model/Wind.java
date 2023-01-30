package com.sample.project.weatherforecast.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Wind {
    private double speed;
    private int deg;
    private double gust;
}
