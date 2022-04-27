package com.visual.nuts.challenge.controller;

import com.visual.nuts.challenge.model.CountryLanguages;
import com.visual.nuts.challenge.service.CountryService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/country")
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @PostMapping("/number-of-countries")
    public Long countCountriesFromList(@RequestBody
                                          List<CountryLanguages> countryLanguages) {
        return countryService.countCountriesFromList(countryLanguages);
    }

    @PostMapping("/country-most-oficial-languages-speak-german")
    public String getCountryWithMostOficialLanguagesThatSpeakGerman(@RequestBody List<CountryLanguages> countryLanguages){
        return countryService.getCountryWithMostOficialLanguagesThatSpeakGerman(countryLanguages);
    }

    @PostMapping("/counts-official-languages-spoken-in-list")
    public Long countsAllTheOfficialLanguagesSpokenInTheListedCountries(@RequestBody List<CountryLanguages> countryLanguages){
        return countryService.countsAllTheOfficialLanguagesSpokenInTheListedCountries(countryLanguages);
    }

    @PostMapping("/get-country-with-highest-number-of-oficial-languages")
    public String getCountryWithHighestNumberOfOficialLanguages(@RequestBody List<CountryLanguages> countryLanguages){
        return countryService.getCountryWithHighestNumberOfOficialLanguages(countryLanguages);
    }

    @PostMapping("/the-most-common-official-languages-of-all-countries")
    public String theMostCommonOfficialLanguagesOfAllCountries(@RequestBody List<CountryLanguages> countryLanguages){
        return countryService.theMostCommonOfficialLanguagesOfAllCountries(countryLanguages);
    }



}
