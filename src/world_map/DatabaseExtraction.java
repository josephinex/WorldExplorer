package world_map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseExtraction extends DatabaseConnection{
	
	/**
	 * This constructor calls extended class' constructor on received parameters
	 * 
	 * @param sql query 
	 * @param params used in PreparedStatement
	 * @param types of the parameters
	 */
	public DatabaseExtraction(String query, Object[] params, Class<Object>[] types) {
		super(query, params, types);
	}
	

	/**
	 * This function takes as a parameter the city name entered by the user and
	 * returns an list of countries this city is found in as well as the country code. 
	 * 
	 * @param connection 
	 * @param cityName the name of the city user enters
	 */
	public static List<String> getCountryByCityName(String cityName) {
		cityName = cityName.toLowerCase();
		cityName = cityName.substring(0, 1).toUpperCase() + cityName.substring(1);
		String request = "SELECT country_code, full_name FROM cities WHERE full_name = ?";
		
		DatabaseExtraction dbextraction = new DatabaseExtraction(request, new Object[]{new String(cityName)}, new Class[]{String.class});
		
		List<String> countryDataList = new ArrayList<>();
		
		
			ResultSet rs = dbextraction.execute();
			try {
				while(rs.next()) {
					for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
						countryDataList.add(rs.getString(i));
					}	
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		return countryDataList;
	}
	
	
	/**
	 * This function returns a country name by country code;
	 * 		
	 * @param connection
	 * @param countryCode entered by the user, for e.g. au, md.
	 * @return
	 */
	public static List<String> getCountryByCountryCode(String countryCode) {
		String request = "SELECT country_name FROM countries WHERE country_code = ?";
		countryCode = countryCode.toUpperCase();
		List<String> countryList = new ArrayList<>();
		
		DatabaseExtraction dbextraction = new DatabaseExtraction(request, new Object[]{new String(countryCode)}, new Class[]{String.class});
		try {
			ResultSet resultSet = dbextraction.execute();
			
			while(resultSet.next()) {
				for(int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
					countryList.add(resultSet.getString(i));
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return countryList;
	}
	
	
	/**
	 * The function returns a list of cities from the database when user enters country name
	 * 
	 * @param countryName name of the country
	 * @return list of strings
	 */
	public static List<String> getCitiesByCountryName(String countryName) {
		String request = "SELECT full_name FROM countries JOIN cities "
				+ "ON (countries.country_code = cities.country_code) WHERE country_name = ?";
		countryName.toLowerCase();
		countryName = countryName.substring(0, 1).toUpperCase() + countryName.substring(1);
		
		List<String> cityList = new ArrayList<>();
		
		DatabaseExtraction dbextraction = new DatabaseExtraction(request, new Object[]{new String(countryName)}, new Class[]{String.class});
		try {
			ResultSet rs = dbextraction.execute();
			while(rs.next()) {
				for(int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					cityList.add(rs.getString(i));
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cityList;
	}	
}
