package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dto.CityDto;
import utils.RowMapper;
import utils.Utilities;

@ManagedBean(name = "countryAndCityJoinDao", eager = true)
@SessionScoped
public class CountryAndCityJoinDao extends Utilities implements RowMapper{

	private static final long serialVersionUID = -7416028778449697929L;
	private final static String request = "SELECT full_name FROM countries JOIN cities ON (countries.country_code = cities.country_code) WHERE country_name = ?";
	
	public CountryAndCityJoinDao() {
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
	public CityDto fetchCitiesByCountryName(String countryName) {
		countryName.toLowerCase();
		countryName = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);
	
		this.setParams(new Object[] { new String(countryName) });
		ResultSet rs = this.execute();
		CityDto city = null;

		try {
			city = this.mapRow(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return city;
	}
	
	
	@Override
	public CityDto mapRow(ResultSet resultSet) throws SQLException {
		CityDto city = new CityDto();
		
		List<String> listOfCityNames = new ArrayList<>();
		
		while (resultSet.next()) {
			listOfCityNames.add(resultSet.getString(1));
		}
		city.setCityNames(listOfCityNames);
		
		return city;
	}
}
