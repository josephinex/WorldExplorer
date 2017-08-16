package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import app.entities.City;
import app.service.RegistrationService;

@ManagedBean(name = "cities_by_countryname", eager = true)
@ViewScoped
public class CitiesByCountryNameBean implements Serializable {

	/*@ManagedProperty(value = "#{CityRepository}")
	CityRepository cityRepository;*/
	
	private static final long serialVersionUID = 4272845871439410995L;

	@ManagedProperty(value="#{RegistrationService}")
	private RegistrationService service;

	/*public CityRepository getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}*/

	public RegistrationService getService() {
		return service;
	}

	public void setService(RegistrationService service) {
		this.service = service;
	}

	private String countryName;
	
	private List<String> cityNames = null;

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(List<String> cityNames) {
		this.cityNames = cityNames;
	}

	public void submit() {
		if(service == null) {
			System.out.println("Service is : " + service);
			//System.out.println("City repo : " + service.getCityRepository());
			return;
		}
		List<City> cities = service.getCityRepository().findByCountryName(getCountryName());

		List<String> cityNames = new ArrayList<>();

		for (City city : cities) {
			cityNames.add(city.getCityName());
		}

		setCityNames(cityNames);
	}

}
