package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import app.entities.City;
import app.repositories.CityRepository;

@Named("cities_by_countryname")
@RequestScoped
public class CitiesByCountryNameBean implements Serializable{
	
	private static final long serialVersionUID = 4272845871439410995L;

	@Inject
	private CityRepository cityRepository;

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

		String countryName = getCountryName().substring(0,1).toUpperCase() + getCountryName().substring(1);
		List<City> cities = cityRepository.findByCountryName(countryName);
		

		List<String> cityNames = new ArrayList<>();

		for (City city : cities) {
			cityNames.add(city.getCityName());
		}

		setCityNames(cityNames);
	}

}
