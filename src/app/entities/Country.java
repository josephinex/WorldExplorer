package app.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "countries")
public class Country {

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

	@Column(name = "country_code")
	private String countryCode;
	
	@OneToMany
	@JoinColumn(name="country_code")
	List<City> cities;
	

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
