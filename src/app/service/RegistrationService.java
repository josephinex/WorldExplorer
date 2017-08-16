package app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import app.repositories.CityRepository;

@Service(value="RegistrationService")
public class RegistrationService {
	
	@Autowired
	private CityRepository cityRepository;

	public CityRepository getCityRepository() {
		System.out.println("City repo " + cityRepository);
		return cityRepository;
	}

	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	
}
