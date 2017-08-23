package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import app.dto.CountryDto;
import app.service.CountryRegistrationService;

@ManagedBean(name = "country_by_cityname", eager = true)
@RequestScoped
public class CountryByCityNameBean implements Serializable {

	private static final long serialVersionUID = 4191174360088849685L;

	@ManagedProperty(value = "#{CountryRegistrationService}")
	private CountryRegistrationService service;

	private String cityName;
	private List<String> countryNames;

	public CountryRegistrationService getService() {
		return service;
	}

	public void setService(CountryRegistrationService service) {
		this.service = service;
	}

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
		List<CountryDto> countries = service.findByCityName(cityName);

		List<String> countryNames = new ArrayList<>();

		for (CountryDto c : countries) {
			countryNames.add(c.getCountryName());
		}

		setCountryNames(countryNames);
	}

}
