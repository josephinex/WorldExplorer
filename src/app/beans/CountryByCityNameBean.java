package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import app.entities.Country;
import app.service.CountryRegistrationService;

@ManagedBean(name = "country_by_cityname", eager = true)
@RequestScoped
public class CountryByCityNameBean implements Serializable {

	private static final long serialVersionUID = 4191174360088849685L;

	@ManagedProperty(value = "#{CountryRegistrationService}")
	private CountryRegistrationService service;

	private String cityName;
	private List<String> countryCodes;

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

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryCodes(List<String> countryCodes) {
		this.countryCodes = countryCodes;
	}

	public void submit() {

		List<Country> countries = service.getCountryRepository().findByCityName(getCityName());

		List<String> countryCodes = new ArrayList<>();

		for (Country c : countries) {
			countryCodes.add(c.getCountryName());
		}

		setCountryCodes(countryCodes);
	}

}
