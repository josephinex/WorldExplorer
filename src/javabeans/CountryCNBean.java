package javabeans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.sql.DataSource;

import world_map.DatabaseExtraction;

@ManagedBean(name = "countryCNBean", eager = true)
@SessionScoped
public class CountryCNBean implements Serializable {

	private static final long serialVersionUID = 6502859756716955158L;
	@Resource(mappedName = "jdbc/world")
	private DataSource dataSource;

	/**
	 * This function takes as a parameter the city name entered by the user and
	 * returns an list of countries this city is found in as well as the country code. 
	 * 
	 * @param connection 
	 * @param cityName the name of the city user enters
	 */
	public List<String> getCountryByCityName(String cityName) {
		try {
			final Connection conn = dataSource.getConnection();
			cityName = cityName.toLowerCase();
			cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1);
			String request = "SELECT country_code, full_name FROM cities WHERE full_name = ?";
			List<String> countryList = new ArrayList<>();

			try {
				DatabaseExtraction dbextraction = new DatabaseExtraction(request,
						new Object[] { new String(cityName) }, new Class[] { String.class });
				dbextraction.setConnection(conn);
				try {
					countryList = dbextraction.populateList(dbextraction.execute());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} finally {
				conn.close();
			}
			return countryList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

}
