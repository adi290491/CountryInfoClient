package com.countryinfo.client.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.countryinfo.client.api.requestModel.Country;
import com.countryinfo.client.api.service.CountryInfoService;

@RestController
@RequestMapping("/country")
public class CountryClientController {

	@Autowired
	private CountryInfoService countryInfoService;
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> getCountryCapital(@RequestBody Country country ) {
		String capital = countryInfoService.getCountryCapital(country);
		return new ResponseEntity<>(capital, HttpStatusCode.valueOf(200));
	}
	
	@GetMapping
	public ResponseEntity<List<String>> getAllCountries(){
		List<String> countryList = countryInfoService.getAllCountries();
		return new ResponseEntity<>(countryList, HttpStatusCode.valueOf(200));
	}
	
}
