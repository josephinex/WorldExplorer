package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.CityDto;
import app.dto.CountryDto;
import app.entities.City;
import app.entities.Country;
import app.repositories.CountryRepository;

@Service(value = "CountryRegistrationService")
public class CountryRegistrationService {

	@Autowired
	private CountryRepository countryRepository;

	public List<CountryDto> findByCityName(String cityName) {
		List<Country> originalList = countryRepository.findByCityName(cityName);
		List<CountryDto> list = new ArrayList<>(originalList.size());

		// mapping from country to countrydto

		for (Country country : originalList) {
			CountryDto countryDto = new CountryDto();
			countryDto.setCountryName(country.getCountryName());
			countryDto.setCountryCodeIso(country.getCountryCodeIso());
			countryDto.setCountryCode(country.getCountryCode());
			countryDto.setTopLevelDomain(country.getTopLevelDomain());
			if (country.getCities() != null) {
				countryDto.setCities(new ArrayList<CityDto>(country.getCities().size()));
				for (City city : country.getCities()) {
					countryDto.getCities().add(Utils.mapCityToDto(city));
				}
			}
			list.add(countryDto);
		}

		return list;
	}

	public List<CountryDto> findByCountryCode(String countryCode) {
		List<Country> originalList = countryRepository.findByCountryCode(countryCode);
		List<CountryDto> list = new ArrayList<>(originalList.size());

		// mapping from country to countrydto

		for (Country country : originalList) {
			list.add(Utils.mapCountryToDto(country));
		}

		return list;
	}

	public void setCityRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}

}
