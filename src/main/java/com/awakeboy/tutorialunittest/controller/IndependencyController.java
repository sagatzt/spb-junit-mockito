package com.awakeboy.tutorialunittest.controller;

import com.awakeboy.tutorialunittest.models.Country;
import com.awakeboy.tutorialunittest.models.CountryResponse;
import com.awakeboy.tutorialunittest.repositories.CountryRepository;
import com.awakeboy.tutorialunittest.util.DiferenciaEntreFechas;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.Period;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Author: VIP
 */
@RestController()
public class IndependencyController {
    static Logger logger = Logger.getLogger(IndependencyController.class.getName());


    CountryResponse countryResponse;
    Optional<Country> country;
    CountryRepository countryRepository;
    DiferenciaEntreFechas diferenciaEntreFechas;

    public IndependencyController(CountryRepository countryRepository,DiferenciaEntreFechas diferenciaEntreFechas) {
        this.countryRepository = countryRepository;
        this.diferenciaEntreFechas = diferenciaEntreFechas;
        /*try {
            LogManager.getLogManager().readConfiguration(
                    new FileInputStream("logger.properties")
            );
        }catch(SecurityException | IOException e){
            e.printStackTrace();
        }*/
    }

    @GetMapping(path = "/country/{countryId}")
    public ResponseEntity<CountryResponse> getCountryDetails(@PathVariable("countryId") String countryId) {
        country = Optional.of(new Country());
        countryResponse = new CountryResponse();

        country = Optional.ofNullable(countryRepository.findCountryByIsoCode(countryId.toUpperCase()));

        if (country.isPresent()) {
            Period period = diferenciaEntreFechas.calculateYearsOfIndependency(country.get().getCountryIdependenceDate());
            countryResponse.setCountryName(country.get().getCountryName());
            countryResponse.setCapitalName(country.get().getCountryCapital());
            countryResponse.setIndependenceDate(country.get().getCountryIdependenceDate());
            countryResponse.setDayssOfIndependency(period.getDays());
            countryResponse.setMonthsOfIndependency(period.getMonths());
            countryResponse.setYearsOfIndependency(period.getYears());
            //logger.log(Level.INFO,countryResponse.toString());
        }

        return ResponseEntity.ok(countryResponse);
    }
}