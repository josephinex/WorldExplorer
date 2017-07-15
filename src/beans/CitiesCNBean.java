package beans;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import utils.Utilities;

@ManagedBean(name = "citiesCNBean", eager = true)
@SessionScoped
public class CitiesCNBean extends Utilities{
	
	private static final long serialVersionUID = 1953950817183835702L;
	private final static String request = "SELECT full_name FROM countries JOIN cities ON (countries.country_code = cities.country_code) WHERE country_name = ?";

	public CitiesCNBean() {
		super(request, null, new Class[] { String.class });
	}

	/**
	 * The function returns a list of cities from the database when user enters
	 * country name
	 * 
	 * @param countryName
	 *            name of the country
	 * @return list of strings
	 */
	public List<String> fetchCitiesByCountryName(String countryName) {
		countryName.toLowerCase();
		countryName = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);

		this.setParams(new Object[] { new String(countryName) });

		try {
			return this.populateList(this.execute());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}
}
