package beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import dao.CountryAndCityJoinDao;
import dto.CityDto;

@ManagedBean(name = "cities_by_countryname", eager = true)
@RequestScoped
public class CitiesByCountryNameBean implements Serializable {

	private static final long serialVersionUID = -5968364876481791011L;

	@ManagedProperty(value = "#{countryAndCityJoinDao}")
	private CountryAndCityJoinDao countryAndCityJoinDao;

	private String countryName = "";
	private List<String> cityNames = null;

	public CountryAndCityJoinDao getCountryAndCityJoinDao() {
		return countryAndCityJoinDao;
	}

	public void setCountryAndCityJoinDao(CountryAndCityJoinDao countryAndCityJoinDao) {
		this.countryAndCityJoinDao = countryAndCityJoinDao;
	}

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
		CityDto cityDto = countryAndCityJoinDao.fetchCitiesByCountryName(countryName);
		setCityNames(cityDto.getCityNames());
	}

}
