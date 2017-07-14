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

@ManagedBean(name = "countryCCBean", eager = true)
@SessionScoped
public class CountryCCBean implements Serializable {

	private static final long serialVersionUID = -5222661660560962106L;
	
	@Resource(mappedName = "jdbc/world")
	private DataSource dataSource;

	/**
	 * This function returns a country name by country code.
	 * 
	 * @param countryCode
	 *            entered by the user, for e.g. au, md.
	 * @return
	 */
	public List<String> fetchCountryByCountryCode(String countryCode) {
		try {
			final Connection conn = dataSource.getConnection();
			String request = "SELECT country_name FROM countries WHERE country_code = ?";
			countryCode = countryCode.toUpperCase();
			List<String> countryList = new ArrayList<>();

			try {
				DatabaseExtraction dbextraction = new DatabaseExtraction(request,
						new Object[] { new String(countryCode) }, new Class[] { String.class });
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
