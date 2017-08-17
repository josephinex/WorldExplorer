package app.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import app.beans.CitiesByCountryNameBean;
import app.entities.City;
import app.repositories.CityRepository;

public class CityRepositoryImpl {
	@Autowired
	private CityRepository cityRepository;

	public void findCities() {
		
		CitiesByCountryNameBean citiesBean = new CitiesByCountryNameBean();
		
		List<City> cities = cityRepository.findByCountryName(citiesBean.getCountryName());
		
		List<String> cityNames = new ArrayList<>();

		for (City city : cities) {
			cityNames.add(city.getCityName());
		}

		citiesBean.setCityNames(cityNames);
	}
}
