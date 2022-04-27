package com.visual.nuts.challenge.service;

import com.visual.nuts.challenge.model.CountryLanguages;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CountryService {

    public static final int NUMBER_OF_COUNTRIES_IN_THE_WORLD = 195; // from google ;)
    public static final String GERMAN_SHORT = "de";

    /**
     *
     * @param countryLanguages
     * @return - returns the number of countries in the world (or in the listed countries?)
     */
    public long countCountriesFromList(List<CountryLanguages> countryLanguages) {
        //return NUMBER_OF_COUNTRIES_IN_THE_WORLD;
        return countryLanguages.stream().map(countryLanguage -> countryLanguage.getCountry().toUpperCase()).distinct().count();
    }

    /**
     * @param countryLanguages
     * @return the country with the most official languages, where they officially speak German (de)
     */

    public String getCountryWithMostOficialLanguagesThatSpeakGerman(List<CountryLanguages> countryLanguages){
        return getCountryWithMostOficialLanguagesWithAGivenLanguage(countryLanguages, GERMAN_SHORT);
    }

    /**
     *
     * @param countryLanguages
     * @param language
     * @return the country with the most official languages, where they officially speak a given language
     */
    public String getCountryWithMostOficialLanguagesWithAGivenLanguage(List<CountryLanguages> countryLanguages, String language) {
        return countryLanguages.stream().filter(countryLanguage ->
                countryLanguage.getLanguages().contains(GERMAN_SHORT)).max(
                        Comparator.comparing(countryLanguage -> countryLanguage.getLanguages().size())).
                orElse(new CountryLanguages("None", new ArrayList<>())).getCountry();
    }

    /**
     * @param countryLanguages
     * @return - counts all the official languages spoken in the listed countries.
     */
    public long countsAllTheOfficialLanguagesSpokenInTheListedCountries(List<CountryLanguages> countryLanguages) {
        return countryLanguages.stream().flatMap(countryLanguage -> countryLanguage.getLanguages().stream()).distinct().count();
    }

    /**
     * @param countryLanguages
     * @return the country with the highest number of official languages.
     */
    public String getCountryWithHighestNumberOfOficialLanguages(List<CountryLanguages> countryLanguages) {
        return countryLanguages.stream().max(
                        Comparator.comparing(countryLanguage -> countryLanguage.getLanguages().size())).
                orElse(new CountryLanguages("None", new ArrayList<>())).getCountry();
    }

    /**
     * @param countryLanguages
     * @return the most common official language(s), of all countries.
     */
    public String theMostCommonOfficialLanguagesOfAllCountries(List<CountryLanguages> countryLanguages) {
        final Map<String, Long> languagesCount = countryLanguages.stream().flatMap(countryLanguage ->
                countryLanguage.getLanguages().stream()).collect(Collectors.groupingBy(k -> k, Collectors.counting()));
        return languagesCount.entrySet().stream().filter(entry ->
                entry.getValue().equals(
                        languagesCount.values().stream().max(
                                Comparator.comparingLong(value -> value)).orElse(0L)))
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "));


    }



}
