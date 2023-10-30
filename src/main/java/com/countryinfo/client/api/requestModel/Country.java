package com.countryinfo.client.api.requestModel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Country {

	@JsonProperty("countryName")
	private String countryName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
