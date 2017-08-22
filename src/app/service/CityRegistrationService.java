package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import app.dto.CityDto;
import app.entities.City;
import app.repositories.CityRepository;

@Service(value = "CityRegistrationService")
public class CityRegistrationService {

	@Autowired
	private CityRepository cityRepository;

	public List<CityDto> findByCountryName(String countryName) {
		List<City> originalList = cityRepository.findByCountryName(countryName);
		List<CityDto> list = new ArrayList<>(originalList.size());

		// mapping from city to citydto

		for (City city : originalList) {
			CityDto cityDto = new CityDto();
			cityDto.setCityName(city.getCityName());
			cityDto.setCountry(city.getCountry());
			cityDto.setCountryCode(city.getCountryCode());
			list.add(cityDto);
		}

		return list;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

}
