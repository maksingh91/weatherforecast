package com.sample.project.weatherforecast.controller;

import com.sample.project.weatherforecast.model.ForecastResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ForecastController {

    @GetMapping
    public ResponseEntity<List<ForecastResponse>> forecastTheWeather(){

        List<ForecastResponse> lst = new ArrayList<ForecastResponse>();
        lst.add(new ForecastResponse());
        return new ResponseEntity<>(lst, HttpStatus.OK);
    }
}
