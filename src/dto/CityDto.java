package dto;

import java.util.List;

public class CityDto {
	private long Id;
	private String countryCode;
	private String cityName;
	private List<String> countryCodes;
	private List<String> cityNames;

	public List<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(List<String> cityNames) {
		this.cityNames = cityNames;
	}

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<String> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
