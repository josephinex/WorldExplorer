package app.dto;

import app.entities.Country;

public class CityDto {
	private Long id;

	private String cityName;

	public String countryCode;

	private Country country;

	public long getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCityName() {
		return cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
}
