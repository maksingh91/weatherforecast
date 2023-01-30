package com.sample.project.weatherforecast.service.helper;

import com.sample.project.weatherforecast.model.DataList;
import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.model.Main;
import org.springframework.stereotype.Service;

@Service
public class HighWindPrediction implements WeatherPrediction{
    @Override
    public void getPrediction(DataList dataList, ForecastResponse forecastResponse) {
        if(dataList.getWind().getSpeed()>10){
            forecastResponse.getPredictions().add("It's too windy, watch out!");
        }
    }
}
