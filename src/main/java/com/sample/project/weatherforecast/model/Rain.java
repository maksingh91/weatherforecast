package com.sample.project.weatherforecast.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Rain {
    @JsonProperty("3h")
    private double _3h;
}
