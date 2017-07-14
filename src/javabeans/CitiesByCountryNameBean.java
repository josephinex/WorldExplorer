package javabeans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="cities_by_countryname", eager=true)
@RequestScoped
public class CitiesByCountryNameBean {
	
	@ManagedProperty(value="#{citiesCNBean}")
	private CitiesCNBean citiesCNBean;
	
	private String countryName = "";
	private List<String> cityNames = null;
	
	
	public void setCitiesCNBean(CitiesCNBean citiesCNBean) {
		this.citiesCNBean = citiesCNBean;
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
	
	public void submit(){
		List<String> cityNames = citiesCNBean.fetchCitiesByCountryName(countryName);
		setCityNames(cityNames);
	}

}
