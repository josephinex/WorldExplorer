package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.CountryDto;
import utils.RowMapper;
import utils.Utilities;

@ManagedBean(name = "countryDao", eager = true)
@SessionScoped
public class CountryDao extends Utilities implements RowMapper{
	
	private static final long serialVersionUID = 1953950817183835702L;
	private final static String request = "SELECT country_name FROM countries WHERE country_code = ?";
	
	public CountryDao() {
		super(request, null, new Class[] { String.class });
	}

	
	/**
	 * This function returns a country name by country code.
	 * 
	 * @param countryCode entered by the user, for e.g. au, md.
	 * @return
	 */
	public CountryDto fetchCountryByCountryCode(String countryCode) {
		countryCode = countryCode.toUpperCase();
		this.setParams(new Object[] { new String(countryCode) });
		ResultSet rs = this.execute();
		CountryDto country = null;

		try {
			country = this.mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return country;
	}


	@Override
	public CountryDto mapRow(ResultSet resultSet) throws SQLException {
		CountryDto country = new CountryDto();
		List<String> listOfCountryNames = new ArrayList<>();
		
		while (resultSet.next()) {
			listOfCountryNames.add(resultSet.getString(1));
		}
		country.setCountryNames(listOfCountryNames);
		return country;
	}
}
