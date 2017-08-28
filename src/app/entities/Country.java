package app.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	/*@Column(name = "region_id")
	private Long regionId;*/
	
	/*@Column(name = "subregion_id")
	private String subregionId;*/

	@Column(name = "country_code_iso")
	private String countryCodeIso;

	@Column(name = "country_name")
	private String countryName;

	@Column(name = "tld")
	private String topLevelDomain;

	@Column(name = "country_code", nullable = false)
	private String countryCode;
	
	@OneToMany(mappedBy="country")
	private List<City> cities;
	

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void setCountryCodeIso(String countryCodeIso) {
		this.countryCodeIso = countryCodeIso;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public void setTopLevelDomain(String topLevelDomain) {
		this.topLevelDomain = topLevelDomain;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public long getId() {
		return id;
	}

	public String getCountryCodeIso() {
		return countryCodeIso;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getTopLevelDomain() {
		return topLevelDomain;
	}

	public String getCountryCode() {
		return countryCode;
	}

}
