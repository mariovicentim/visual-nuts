package com.visual.nuts.challenge;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.visual.nuts.challenge.configuration.WebConfig;
import com.visual.nuts.challenge.controller.CountryController;
import com.visual.nuts.challenge.model.CountryLanguages;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@WebMvcTest(CountryController.class)
class ChallengeApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@BeforeEach
	public void setup() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}

	@Test
	public void countCountriesFromList() throws Exception {
		
		this.mockMvc.perform(post("/country/number-of-countries")
						.contentType(MediaType.APPLICATION_JSON)
				.content(getDefaultJson()))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("5"))
				.andReturn();

	}

	@Test
	public void getCountryWithMostOficialLanguagesThatSpeakGerman() throws Exception {

		this.mockMvc.perform(post("/country/country-most-oficial-languages-speak-german")
						.contentType(MediaType.APPLICATION_JSON)
						.content(getDefaultJson()))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("BE"))
				.andReturn();

	}

	@Test
	public void countsAllTheOfficialLanguagesSpokenInTheListedCountries() throws Exception {

		this.mockMvc.perform(post("/country/counts-official-languages-spoken-in-list")
						.contentType(MediaType.APPLICATION_JSON)
						.content(getDefaultJson()))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("6"))
				.andReturn();
	}

	@Test
	public void getCountryWithHighestNumberOfOficialLanguages() throws Exception {

		this.mockMvc.perform(post("/country/get-country-with-highest-number-of-oficial-languages")
						.contentType(MediaType.APPLICATION_JSON)
						.content(getDefaultJson()))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("BE"))
				.andReturn();
	}

	@Test
	public void theMostCommonOfficialLanguagesOfAllCountries() throws Exception {

		this.mockMvc.perform(post("/country/the-most-common-official-languages-of-all-countries")
						.contentType(MediaType.APPLICATION_JSON)
						.content(getDefaultJson()))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().string("de, nl"))
				.andReturn();
	}

	private String getDefaultJson() throws JsonProcessingException {
		List<CountryLanguages> countryLanguages = Arrays.asList(
				new CountryLanguages("US", Arrays.asList("en")),
				new CountryLanguages("BE", Arrays.asList("nl","fr","de")),
				new CountryLanguages("NL", Arrays.asList("nl","fy")),
				new CountryLanguages("DE", Arrays.asList("de")),
				new CountryLanguages("ES", Arrays.asList("es")));

		return new ObjectMapper().writeValueAsString(countryLanguages);

	}

}
