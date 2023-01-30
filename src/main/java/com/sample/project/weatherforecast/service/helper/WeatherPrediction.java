package com.sample.project.weatherforecast.service.helper;

import com.sample.project.weatherforecast.model.DataList;
import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.model.Main;

public interface WeatherPrediction {
    public void getPrediction(DataList dataList, ForecastResponse forecastResponse);
}
