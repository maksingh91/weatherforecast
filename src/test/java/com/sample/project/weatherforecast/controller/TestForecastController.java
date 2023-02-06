package com.sample.project.weatherforecast.controller;

import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.service.ForecastService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.text.ParseException;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@WebMvcTest
public class TestForecastController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ForecastService forecastService;


    @Test
    public void testForecastTheWeather() throws Exception {
        when(forecastService.getWeatherForecast(anyString())).thenReturn(new ArrayList<ForecastResponse>());

        mockMvc.perform(MockMvcRequestBuilders.get("/forecast/{city}", "london")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
