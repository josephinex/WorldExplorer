package app.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import app.entities.City;

@ManagedBean(name = "country_by_cityname", eager = true)
@RequestScoped
public class CountryByCityNameBean implements Serializable {

	private static final long serialVersionUID = 4191174360088849685L;

	//@ManagedProperty(value = "#{cityDao}")
	//private CityDao cityDao;

	private String cityName;
	private List<String> cityNames;

	private List<String> countryCodes;
	private String countryName;

/*	public CityDao getCityDao() {
		return cityDao;
	}

	public void setCityDao(CityDao cityDao) {
		this.cityDao = cityDao;
	}*/

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<String> getCityNames() {
		return cityNames;
	}

	public void setCityNames(List<String> cityNames) {
		this.cityNames = cityNames;
	}

	public List<String> getCountryCodes() {
		return countryCodes;
	}

	public void setCountryNames(List<String> countryCodes) {
		this.countryCodes = countryCodes;
	}

	/*public void submit() {
		City city = cityDao.getCountryByCityName(cityName);
		setCountryNames(city.getCountryCodes());
		setCityNames(city.getCityNames());
	}*/

}
