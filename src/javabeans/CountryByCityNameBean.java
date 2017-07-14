package javabeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import world_map.DatabaseExtraction;


@ManagedBean(name="country_by_cityname", eager=true)
@RequestScoped
public class CountryByCityNameBean {

	@ManagedProperty(value="#{countryCNBean}")
	private CountryCNBean countryCNBean;
	
	public void setCountryCNBean(CountryCNBean countryCNBean) {
		this.countryCNBean = countryCNBean;
	}

	private String cityName = "";
	private List<String> countryNames = null; 
	
	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public List<String> getCountryNames() {
		return countryNames;
	}

	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}

	public void submit(){
		List<String> countryNames = countryCNBean.getCountryByCityName(cityName);
		setCountryNames(countryNames);
	}
	
}
