package world_map;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="country_by_cityname", eager=true)
@RequestScoped
public class CountryByCityNameBean {

	private String cityName = "";
	private String countryName = "";
	private List<String> countryNames = null; 
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public void submit(){
		List<String> countryNames = DatabaseExtraction.getCountryByCityName(cityName);
		setCountryNames(countryNames);
	}
	
}
