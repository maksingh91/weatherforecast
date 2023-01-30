package com.sample.project.weatherforecast.service.helper;

import com.sample.project.weatherforecast.model.DataList;
import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.model.Main;
import org.springframework.stereotype.Service;

@Service
public class HeatwavePrediction implements WeatherPrediction{
    @Override
    public void getPrediction(DataList dataList, ForecastResponse forecastResponse) {
        if(dataList.getMain().getTemp_max()>313.15){
            forecastResponse.getPredictions().add("Use Sunscreen Lotion");
        }
    }
}
