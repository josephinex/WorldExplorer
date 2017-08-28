package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import app.entities.Country;
import app.repositories.CountryRepository;

@Named("country_by_countrycode")
@RequestScoped
public class CountryByCountryCodeBean implements Serializable {

	@Inject
	private CountryRepository countryRepository;

	private String countryCode;
	private List<String> countryNames;
	private String countryName;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public void submit() {
		List<Country> countries = countryRepository.findByCountryCode(getCountryCode().toUpperCase());
		List<String> countryNames = new ArrayList<>();
		
		for(Country c : countries) {
			countryNames.add(c.getCountryName());
		}
		
		this.setCountryNames(countryNames);
	}

}
