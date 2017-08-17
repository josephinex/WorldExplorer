package app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.repositories.CountryRepository;

@Service(value = "CountryRegistrationService")
public class CountryRegistrationService {

	@Autowired
	private CountryRepository countryRepository;

	public CountryRepository getCountryRepository() {
		return countryRepository;
	}

	public void setCityRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

}
