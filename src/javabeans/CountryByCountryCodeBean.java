package javabeans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "country_by_countrycode", eager = true)
@SessionScoped
public class CountryByCountryCodeBean implements Serializable{

	private static final long serialVersionUID = 2132958178296290274L;

	@ManagedProperty(value="#{countryCCBean}")
	private CountryCCBean countryCCBean;

	private String countryCode = "";
	private List<String> countryNames = null;

	public void setCountryCCBean(CountryCCBean countryCCBean) {
		this.countryCCBean = countryCCBean;
	}
	
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

	public void submit() {
		List<String> countryNames = countryCCBean.fetchCountryByCountryCode(countryCode);
		setCountryNames(countryNames);
	}

}
