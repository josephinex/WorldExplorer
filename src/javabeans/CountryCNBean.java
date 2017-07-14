package javabeans;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import world_map.Utilities;

@ManagedBean(name = "countryCNBean", eager = true)
@SessionScoped
public class CountryCNBean extends Utilities{
	
	private static final long serialVersionUID = 6502859756716955158L;
	private final static String request = "SELECT country_code, full_name FROM cities WHERE full_name = ?";
	
	public CountryCNBean() {
		super(request, null, new Class[] { String.class });
	}
	
	
	/**
	 * This function takes as a parameter the city name entered by the user and
	 * returns an list of countries this city is found in as well as the country
	 * code.
	 * 
	 * @param connection
	 * @param cityName the name of the city user enters
	 * 
	 */
	public List<String> getCountryByCityName(String cityName) {
		cityName = cityName.toLowerCase();
		cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1);
		
		this.setParams(new Object[] { new String(cityName) });
		
		try {
			return this.populateList(this.execute());

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Collections.emptyList();
	}
}
