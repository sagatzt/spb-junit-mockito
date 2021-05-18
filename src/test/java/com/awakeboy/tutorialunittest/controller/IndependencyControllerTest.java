package com.awakeboy.tutorialunittest.controller;

import com.awakeboy.tutorialunittest.models.Country;
import com.awakeboy.tutorialunittest.models.CountryResponse;
import com.awakeboy.tutorialunittest.repositories.CountryRepository;
import com.awakeboy.tutorialunittest.util.DiferenciaEntreFechas;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

class IndependencyControllerTest {
    @Autowired
    ResponseEntity<CountryResponse> countryResponse;

    CountryRepository countryRepositoryMock= Mockito.mock(CountryRepository.class);

    @Autowired
    DiferenciaEntreFechas diferenciaEntreFechas=new DiferenciaEntreFechas();

    @Autowired
    IndependencyController independencyController=new IndependencyController(countryRepositoryMock,diferenciaEntreFechas);


    @BeforeEach
    void setUp() {
        System.out.println("Antes");
        Country countryMock= new Country();
        countryMock.setIsoCode("DO");
        countryMock.setCountryId((long)1);
        countryMock.setCountryName("Dominicana");
        countryMock.setCountryCapital("laquesea");
        countryMock.setCountryIdependenceDate("10/10/1881");
        Mockito.when(countryRepositoryMock.findCountryByIsoCode("DO"))
            .thenReturn(countryMock);
    }

    @Test
    void getCountryDetails() {
        countryResponse=independencyController.getCountryDetails("DO");
        Assertions.assertEquals(countryResponse.getBody().getCountryName(),
                independencyController.getCountryDetails("DO").getBody().getCountryName());
    }

    @Test
    void getCountryDetailsInvalidNull() {
        countryResponse=independencyController.getCountryDetails("DO");
        Assertions.assertNull(independencyController.getCountryDetails("XX").getBody().getCountryName());
    }
}