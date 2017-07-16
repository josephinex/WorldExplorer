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

@ManagedBean(name = "cityDao", eager = true)
@SessionScoped
public class CityDao extends Utilities implements RowMapper {

	private static final long serialVersionUID = 6502859756716955158L;
	private final static String request = "SELECT country_code, full_name FROM cities WHERE full_name = ?";

	public CityDao() {
		super(request, null, new Class[] { String.class });
	}

	/**
	 * This function takes as a parameter the city name entered by the user and
	 * returns an list of countries this city is found in as well as the country
	 * code.
	 * 
	 * @param connection
	 * @param cityName
	 *            the name of the city user enters
	 * 
	 */
	public CityDto getCountryByCityName(String cityName) {
		cityName = cityName.toLowerCase();
		cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1);

		this.setParams(new Object[] { new String(cityName) });

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
		List<String> listOfCountryCodes = new ArrayList<>();
		List<String> listOfCityNames = new ArrayList<>();
		
		while (resultSet.next()) {
			listOfCountryCodes.add(resultSet.getString(1));
			listOfCityNames.add(resultSet.getString(2));
		}
		city.setCityNames(listOfCityNames);
		city.setCountryCodes(listOfCountryCodes);
		return city;
	}
}
