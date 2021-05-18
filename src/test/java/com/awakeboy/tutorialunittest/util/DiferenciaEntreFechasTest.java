package com.awakeboy.tutorialunittest.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Period;

class DiferenciaEntreFechasTest {

    @Autowired
    DiferenciaEntreFechas difech;

    @Test
    void calculateYearsOfIndependency() {
        difech=new DiferenciaEntreFechas();
        String testDate = "15/01/1980";
        Period res = difech.calculateYearsOfIndependency(testDate);
        int days=res.getDays();//3
        int months=res.getMonths();//4
        int years=res.getYears();//41
        Assertions.assertEquals(days,difech.calculateYearsOfIndependency(testDate).getDays());
        Assertions.assertEquals(months,difech.calculateYearsOfIndependency(testDate).getMonths());
        Assertions.assertEquals(years,difech.calculateYearsOfIndependency(testDate).getYears());
    }
}