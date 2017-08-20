package app.dto;

import java.util.List;
import app.entities.City;

public class CountryDto {
	private Long id;

	private String countryCodeIso;

	private String countryName;

	private String topLevelDomain;

	private String countryCode;

	private List<City> cities;

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCountryCodeIso(String countryCodeIso) {
		this.countryCodeIso = countryCodeIso;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setTopLevelDomain(String topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getId() {
		return id;
	}

	public String getCountryCodeIso() {
		return countryCodeIso;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getTopLevelDomain() {
		return topLevelDomain;
	}

	public String getCountryCode() {
		return countryCode;
	}

}
