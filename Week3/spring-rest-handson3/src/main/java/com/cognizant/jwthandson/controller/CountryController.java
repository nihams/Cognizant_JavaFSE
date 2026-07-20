package com.cognizant.jwthandson.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.jwthandson.model.Country;

@RestController
public class CountryController {

    @GetMapping("/countries")
    public List<Country> getCountries() {
        return List.of(
            new Country("US", "United States"),
            new Country("DE", "Germany"),
            new Country("IN", "India"),
            new Country("JP", "Japan")
        );
    }
}
