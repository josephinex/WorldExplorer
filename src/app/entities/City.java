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
@Table(name = "cities")
public class City {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "full_name")
	private String cityName;

	@Column(name = "country_code")
	public String countryCode;
	
	@OneToMany
	@JoinColumn(name="country_code")
	List<Country> countries;

	public long getId() {
		return id;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getCityName() {
		return cityName;
	}

}
