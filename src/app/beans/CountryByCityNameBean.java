package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import app.entities.Country;
import app.repositories.CountryRepository;

@Named("country_by_cityname")
@RequestScoped
public class CountryByCityNameBean implements Serializable {

	private static final long serialVersionUID = 4191174360088849685L;

	@Inject
	private CountryRepository countryRepository;

	private String cityName;
	private List<String> countryNames;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public void submit() {
		String cityName = getCityName().substring(0,1).toUpperCase() + getCityName().substring(1);
		List<Country> countries = countryRepository.findByCityName(cityName);

		List<String> countryNames = new ArrayList<>();

		for (Country c : countries) {
			countryNames.add(c.getCountryName());
		}

		this.setCityName(cityName);
		this.setCountryNames(countryNames);
	}

}
