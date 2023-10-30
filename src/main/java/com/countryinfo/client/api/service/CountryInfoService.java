package com.countryinfo.client.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.countryinfo.client.api.client.CountryInfoClient;
import com.countryinfo.client.api.requestModel.Country;

@Service
public class CountryInfoService {

	@Autowired
	private CountryInfoClient countryInfoClient;
	public String getCountryCapital(Country country) {
		return countryInfoClient.getCountryCapital(country);
	}
	public List<String> getAllCountries() {
		// TODO Auto-generated method stub
		return countryInfoClient.getListOfCountries();
	}
}
