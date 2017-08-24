package app.entities;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cities")
public class City  implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "full_name")
	private String cityName;

	@Column(name = "country_code",insertable=false, updatable=false, nullable = false)
	public String countryCode;
	
	@ManyToOne
	@JoinColumn(name="country_code", referencedColumnName = "country_code")
	private Country country;

	public long getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCityName() {
		return cityName;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
