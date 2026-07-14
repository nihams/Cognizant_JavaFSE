package com.cognizant.ormlearn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;

    public static void main(String[] args) {
        LOGGER.info("Inside main");

        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testFindCountriesByPartialName();
        testDeleteCountry();
    }

    // Hands on 1
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    // Hands on 6
    private static void testFindCountryByCode() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country not found", e);
        }
        LOGGER.info("End");
    }

    // Hands on 7
    private static void testAddCountry() {
        LOGGER.info("Start");
        Country newCountry = new Country("ZZ", "Testland");
        countryService.addCountry(newCountry);

        try {
            Country added = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Newly added country:{}", added);
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country not found", e);
        }
        LOGGER.info("End");
    }

    // Hands on 8
    private static void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("ZZ", "Testland Updated");
            Country updated = countryService.findCountryByCode("ZZ");
            LOGGER.debug("Updated country:{}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Country not found", e);
        }
        LOGGER.info("End");
    }

    // Hands on 5
    private static void testFindCountriesByPartialName() {
        LOGGER.info("Start");
        List<Country> matches = countryService.findCountriesByPartialName("stan");
        LOGGER.debug("Countries matching 'stan':{}", matches);
        LOGGER.info("End");
    }

    // Hands on 9
    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("ZZ");
        try {
            countryService.findCountryByCode("ZZ");
        } catch (CountryNotFoundException e) {
            LOGGER.debug("Confirmed deleted - country not found: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}
