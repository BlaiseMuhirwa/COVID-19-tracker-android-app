package com.blaisemuhirwa.covid_19trackerandroidapp;

public class ModelStatistics {
    String Country, CountryCode, Slug, NewConfirmed, TotalConfirmed, NewDeaths, TotalDeaths, NewRecovered,
    TotalRecovered, Data, Premium;

    public ModelStatistics() {

    }
    public ModelStatistics(String country, String countryCode, String slug, String newConfirmed,
                           String totalConfirmed, String newDeaths, String totalDeaths, String newRecovered,
                           String totalRecovered, String data, String premium) {
        this.Country = country;
        this.CountryCode = countryCode;
        this.Slug = slug;
        this.NewConfirmed = newConfirmed;
        this.TotalConfirmed = totalConfirmed;
        this.NewDeaths = newDeaths;
        this.TotalDeaths = totalDeaths;
        this.NewRecovered = newRecovered;
        this.TotalRecovered = totalRecovered;
        this.Data = data;
        this.Premium = premium;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public String getSlug() {
        return Slug;
    }

    public void setSlug(String slug) {
        Slug = slug;
    }

    public String getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(String newConfirmed) {
        NewConfirmed = newConfirmed;
    }

    public String getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(String totalConfirmed) {
        TotalConfirmed = totalConfirmed;
    }

    public String getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(String newDeaths) {
        NewDeaths = newDeaths;
    }

    public String getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(String totalDeaths) {
        TotalDeaths = totalDeaths;
    }

    public String getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(String newRecovered) {
        NewRecovered = newRecovered;
    }

    public String getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(String totalRecovered) {
        TotalRecovered = totalRecovered;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }

    public String getPremium() {
        return Premium;
    }

    public void setPremium(String premium) {
        Premium = premium;
    }
}
