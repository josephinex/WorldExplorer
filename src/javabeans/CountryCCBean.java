package javabeans;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import world_map.Utilities;

@ManagedBean(name = "countryCCBean", eager = true)
@SessionScoped
public class CountryCCBean extends Utilities{

	private static final long serialVersionUID = 1899146210914795663L;
	private final static String request = "SELECT country_name FROM countries WHERE country_code = ?";
	
	public CountryCCBean() {
		super(request, null, new Class[] { String.class });
	}

	/**
	 * This function returns a country name by country code.
	 * 
	 * @param countryCode
	 *            entered by the user, for e.g. au, md.
	 * @return
	 */
	public List<String> fetchCountryByCountryCode(String countryCode) {
		countryCode = countryCode.toUpperCase();
		this.setParams(new Object[] { new String(countryCode) });
		try {
			return this.populateList(this.execute());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();

	}
}
