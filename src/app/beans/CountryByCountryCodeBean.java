package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import app.dto.CountryDto;
import app.entities.Country;
import app.service.CountryRegistrationService;

@ManagedBean(name = "country_by_countrycode", eager = true)
@SessionScoped
public class CountryByCountryCodeBean implements Serializable {

	private static final long serialVersionUID = 2132958178296290274L;

	@ManagedProperty(value = "#{CountryRegistrationService}")
	private CountryRegistrationService service;

	private String countryCode;
	private List<String> countryNames;
	private String countryName;

	public CountryRegistrationService getService() {
		return service;
	}

	public void setService(CountryRegistrationService service) {
		this.service = service;
	}

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
		List<CountryDto> countries = service.findByCountryCode(getCountryCode().toUpperCase());
		List<String> countryNames = new ArrayList<>();
		for(CountryDto c : countries) {
			countryNames.add(c.getCountryName());
		}
		this.setCountryNames(countryNames);
	}

}
