package app.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import app.dao.CityRepositoryImpl;

@ManagedBean(name = "cities_by_countryname", eager = true)
@RequestScoped
public class CitiesByCountryNameBean implements Serializable {

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

		CityRepositoryImpl cityRepo = new CityRepositoryImpl();
		cityRepo.findCities();

	}

}
