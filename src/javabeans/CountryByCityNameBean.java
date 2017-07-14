package javabeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;


@ManagedBean(name="country_by_cityname", eager=true)
@RequestScoped
public class CountryByCityNameBean implements Serializable{

	private static final long serialVersionUID = 4191174360088849685L;

	@ManagedProperty(value="#{countryCNBean}")
	private CountryCNBean countryCNBean;
	
	private String cityName = "";
	private List<String> countryNames = null; 
	
	public void setCountryCNBean(CountryCNBean countryCNBean) {
		this.countryCNBean = countryCNBean;
	}
	
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
