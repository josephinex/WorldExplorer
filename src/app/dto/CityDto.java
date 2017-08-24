package app.dto;

import java.io.Serializable;

public class CityDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String cityName;

	public String countryCode;

	private CountryDto country;

	public long getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCityName() {
		return cityName;
	}

	public CountryDto getCountry() {
		return country;
	}

	public void setCountry(CountryDto country) {
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
