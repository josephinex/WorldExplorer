package app.dto;

import java.io.Serializable;
import java.util.List;

public class CountryDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private String countryCodeIso;

	private String countryName;

	private String topLevelDomain;

	private String countryCode;

	private List<CityDto> cities;

	public List<CityDto> getCities() {
		return cities;
	}

	public void setCities(List<CityDto> cities) {
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
