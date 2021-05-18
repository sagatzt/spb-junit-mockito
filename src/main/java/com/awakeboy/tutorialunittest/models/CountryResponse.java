package com.awakeboy.tutorialunittest.models;

public class CountryResponse {
    private String countryName;
    private String capitalName;
    private String independenceDate;
    private int yearsOfIndependency;
    private int monthsOfIndependency;
    private int dayssOfIndependency;

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


    public void setCapitalName(String capitalName) {
        this.capitalName = capitalName;
    }


    public void setIndependenceDate(String independenceDate) {
        this.independenceDate = independenceDate;
    }

    public void setYearsOfIndependency(int yearsOfIndependency) {
        this.yearsOfIndependency = yearsOfIndependency;
    }

    public void setMonthsOfIndependency(int monthsOfIndependency) {
        this.monthsOfIndependency = monthsOfIndependency;
    }

    public void setDayssOfIndependency(int dayssOfIndependency) {
        this.dayssOfIndependency = dayssOfIndependency;
    }

    public String getCapitalName() {
        return capitalName;
    }

    public String getIndependenceDate() {
        return independenceDate;
    }

    public int getYearsOfIndependency() {
        return yearsOfIndependency;
    }

    public int getMonthsOfIndependency() {
        return monthsOfIndependency;
    }

    public int getDayssOfIndependency() {
        return dayssOfIndependency;
    }

}