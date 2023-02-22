package com.coding.springdemo.mvc;

import java.util.LinkedHashMap;
import java.util.Map;

public class Student {

	private String firstName;

	private String lastName;

	private String country;
	
	private Map<String, String> countryOptions;
	
	private String favoriteLanguage;

	private Map<String, String> operatingSystems;
	
	public Student() {
		this.countryOptions = new LinkedHashMap<String, String>();
		
		this.countryOptions.put("IN", "India");
		this.countryOptions.put("GE", "Germany");
		this.countryOptions.put("MA", "Malaysia");
		this.countryOptions.put("UK", "United Kingdom");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String iCountry) {
		this.country = iCountry;
	}

	public Map<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(Map<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}
	
	public Map<String, String> getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(Map<String, String> operatingSystems) {
		this.operatingSystems = operatingSystems;
	}
}
