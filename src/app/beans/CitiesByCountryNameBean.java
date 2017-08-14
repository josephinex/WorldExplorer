package app.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import app.entities.City;
import app.repositories.CityRepository;

@ManagedBean(name = "cities_by_countryname", eager = true)
@RequestScoped
public class CitiesByCountryNameBean implements Serializable {

	@ManagedProperty(value = "#{CityRepository}")
	CityRepository cityRepository;

	public CityRepository getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	private String countryName = "";
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
		List<City> cities = cityRepository.findByCountryName(getCountryName());

		List<String> cityNames = new ArrayList<>();

		for (City city : cities) {
			cityNames.add(city.getCityName());
		}

		setCityNames(cityNames);
	}

}
