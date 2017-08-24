package app.service;

import java.util.ArrayList;

import app.dto.CityDto;
import app.dto.CountryDto;
import app.entities.City;
import app.entities.Country;

public class Utils {

	public static CityDto mapCityToDto(City city) {
		CityDto cityDto = new CityDto();
		cityDto.setCityName(city.getCityName());
		cityDto.setCountry(mapCountryToDto(city.getCountry()));
		cityDto.setCountryCode(city.getCountryCode());
		return cityDto;
	}

	public static CountryDto mapCountryToDto(Country country) {
		CountryDto countryDto = new CountryDto();
		countryDto.setCountryName(country.getCountryName());
		countryDto.setCountryCodeIso(country.getCountryCodeIso());
		countryDto.setCountryCode(country.getCountryCode());
		countryDto.setTopLevelDomain(country.getTopLevelDomain());
		if (country.getCities() != null && org.hibernate.Hibernate.isInitialized(country.getCities())) {
			countryDto.setCities(new ArrayList<CityDto>(country.getCities().size()));
			for (City city : country.getCities()) {
				countryDto.getCities().add(Utils.mapCityToDto(city));
			}
		}
		return countryDto;
	}
}
