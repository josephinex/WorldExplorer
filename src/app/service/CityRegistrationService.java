package app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import app.repositories.CityRepository;

@Service(value="CityRegistrationService")
public class CityRegistrationService {
	
	@Autowired
	private CityRepository cityRepository;

	public CityRepository getCityRepository() {
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	
}
