package com.sample.project.weatherforecast.service;

import com.sample.project.weatherforecast.model.Forecast;
import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.model.DataList;
import com.sample.project.weatherforecast.service.helper.HeatwavePrediction;
import com.sample.project.weatherforecast.service.helper.HighWindPrediction;
import com.sample.project.weatherforecast.service.helper.RainPrediction;
import com.sample.project.weatherforecast.service.helper.WeatherPrediction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ForecastService {

    @Autowired
    HeatwavePrediction heatwavePrediction;

    @Autowired
    HighWindPrediction highWindPrediction;

    @Autowired
    RainPrediction rainPrediction;

    @Value("${variables.openweathermapapibaseurl}")
    private String baseUrl;

    @Value("${variables.cityparam}")
    private String cityparam;

    @Value("${variables.appidparam}")
    private String appidparam;

    @Value("${variables.cntparam}")
    private String cntparam;

    @Value("${variables.appid}")
    private String appid;

    @Value("${variables.cnt}")
    private String cnt;

    public List<ForecastResponse> getWeatherForecast(String city) throws ParseException {

        List<ForecastResponse> forecastResponses = new ArrayList<ForecastResponse>();
        StringBuilder url = new StringBuilder();
        url.append(baseUrl).append("?").append(cityparam).append("=").append(city).append("&").append(appidparam).append("=").append(appid).append("&").append(cntparam).append("=").append(cnt);

        RestTemplate restTemplate = new RestTemplate();
        Forecast forecast = restTemplate.getForEntity(url.toString(), Forecast.class).getBody();

        for(DataList dataList : forecast.getList()){
            ForecastResponse forecastResponseObj = new ForecastResponse();
            forecastResponseObj.setDate(dataList.getDt_txt());
            forecastResponseObj.setHighTemp(String.valueOf(dataList.getMain().getTemp_max()));
            forecastResponseObj.setLowTemp(String.valueOf(dataList.getMain().getTemp_min()));

            highWindPrediction.getPrediction(dataList, forecastResponseObj);
            heatwavePrediction.getPrediction(dataList, forecastResponseObj);
            rainPrediction.getPrediction(dataList, forecastResponseObj);

            forecastResponses.add(forecastResponseObj);
        }

        return forecastResponses;
    }
}
