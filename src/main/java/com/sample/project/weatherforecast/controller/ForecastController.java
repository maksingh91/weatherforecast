package com.sample.project.weatherforecast.controller;

import com.sample.project.weatherforecast.model.ForecastResponse;
import com.sample.project.weatherforecast.service.ForecastService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ForecastController {

    @Autowired
    ForecastService forecastService;

    @GetMapping(value = "/forecast/{city}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Lists three days weather forecast.",
            description = "Lists Upcoming three days weather forecast with predictions",
            responses = {
                    @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
                    @ApiResponse(responseCode = "500",description = "Internal Server Error", content = @Content),
                    @ApiResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType ="application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value =  "[{\"date\" : \"17 Feb 2023\", \"highTemp\" : 45, \"lowTemp\" :23, \"predictions\":[\"Carry Umbrella\",\"Use Sunscreen Lotion\"]}]"
                                            ),
                                    },
                                    array = @ArraySchema( schema = @Schema(implementation =  ForecastResponse.class))

                            )
                    )
            }
    )
    public ResponseEntity<List<ForecastResponse>> forecastTheWeather(@PathVariable("city") String city) throws ParseException {

        return new ResponseEntity<>(forecastService.getWeatherForecast(city), HttpStatus.OK);
    }
}
