package world_map;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="country_by_countrycode", eager=true)
@RequestScoped
public class CountryByCountryCodeBean {

	private String countryCode = "";
	private List<String> countryNames = null; 
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	public List<String> getCountryNames() {
		return countryNames;
	}
	
	public void setCountryNames(List<String> countryNames) {
		this.countryNames = countryNames;
	}
	
	public void submit(){
		List<String> countryNames = DatabaseExtraction.getCountryByCountryCode(countryCode);
		setCountryNames(countryNames);
	}

}
