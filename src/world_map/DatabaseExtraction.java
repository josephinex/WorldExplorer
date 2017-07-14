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
	
	public List<String> populateList(ResultSet resultSet) throws SQLException {
		List<String> list = new ArrayList<>();
		while (resultSet.next()) {
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				list.add(resultSet.getString(i));
			}
		}
		return list;
	}
	
	
}
