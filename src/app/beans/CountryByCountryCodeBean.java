package app.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import app.entities.Country;

@ManagedBean(name = "country_by_countrycode", eager = true)
@SessionScoped
public class CountryByCountryCodeBean implements Serializable {

	private static final long serialVersionUID = 2132958178296290274L;

	@ManagedProperty(value = "#{countryDao}")
	//private CountryDao countryDao;

	private String countryCode;
	private List<String> countryNames;
	private String countryName;

	/*public CountryDao getCountryDao() {
		return countryDao;
	}

	public void setCountryDao(CountryDao countryDao) {
		this.countryDao = countryDao;
	}
*/
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
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

	/*public void submit() {
		Country country = countryDao.fetchCountryByCountryCode(countryCode);
		setCountryNames(country.getCountryNames());
	}*/

}
