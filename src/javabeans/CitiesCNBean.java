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

@ManagedBean(name = "citiesCNBean", eager = true)
@SessionScoped
public class CitiesCNBean implements Serializable {

	private static final long serialVersionUID = -4367592761385212391L;

	@Resource(mappedName = "jdbc/world")
	private DataSource dataSource;

	/**
	 * The function returns a list of cities from the database when user enters
	 * country name
	 * 
	 * @param countryName
	 *            name of the country
	 * @return list of strings
	 */
	public List<String> fetchCitiesByCountryName(String countryName) {

		try {
			final Connection conn = dataSource.getConnection();
			String request = "SELECT full_name FROM countries JOIN cities ON (countries.country_code = cities.country_code) WHERE country_name = ?";
			countryName.toLowerCase();
			countryName = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);
			List<String> cityList = new ArrayList<>();

			try {
				DatabaseExtraction dbextraction = new DatabaseExtraction(request,
						new Object[] { new String(countryName) }, new Class[] { String.class });
				dbextraction.setConnection(conn);
				try {
					cityList = dbextraction.populateList(dbextraction.execute());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} finally {
				conn.close();
			}
			return cityList;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return Collections.emptyList();
	}
}
