package com.sample.project.weatherforecast.service.helper;

import com.sample.project.weatherforecast.model.DataList;
import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.model.Main;
import com.sample.project.weatherforecast.model.Weather;
import org.springframework.stereotype.Service;

@Service
public class RainPrediction implements WeatherPrediction{

    @Override
    public void getPrediction(DataList dataList, ForecastResponse forecastResponse) {

        for(Weather weather : dataList.getWeather()) {
            if (weather.getMain().equals("Rain")) {
                forecastResponse.getPredictions().add("Carry Umbrella");
            }
        }
    }
}
