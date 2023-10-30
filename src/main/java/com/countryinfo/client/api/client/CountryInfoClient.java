package com.countryinfo.client.api.client;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.countryinfo.client.api.requestModel.Country;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class CountryInfoClient {

	private static Logger logger = LoggerFactory.getLogger(CountryInfoClient.class);
	
	private RestTemplate restTemplate;
	
	@Autowired
	public CountryInfoClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	public String getCountryCapital(Country country) {
		String url = "http://localhost:8081/country-info/get-capital";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String requestBody = null;
		try {
			requestBody = mapper.writeValueAsString(country);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("RequestBody: " + requestBody);
		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
		String response = restTemplate.postForObject(url, request, String.class);

		return response;
	}

	public List<String> getListOfCountries() {
		// TODO Auto-generated method stub
		String url = "http://localhost:8081/country-info/getAllCountries";
		ResponseEntity<List<String>> countriesListResponse = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});
		
		return countriesListResponse.getBody();
	}
	
	
}
