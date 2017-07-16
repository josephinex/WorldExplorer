package dto;

import java.util.List;

public class CountryDto extends Mediator {

	private String countryCodeIso;
	private String countryName;
	private List<String> countryNames;
	private String topLevelDomain;

	public String getCountryCodeIso() {
		return countryCodeIso;
	}

	public void setCountryCodeIso(String countryCodeIso) {
		this.countryCodeIso = countryCodeIso;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public String getTopLevelDomain() {
		return topLevelDomain;
	}

	public void setTopLevelDomain(String topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

}
