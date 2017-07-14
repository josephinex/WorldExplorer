package world_map;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DatabaseConnection {	
	private Connection connection;
	
	private String query = "";
	private Object[] params;
	private Class<Object>[] types;

	public DatabaseConnection(String query, Object[] params, Class<Object>[] types) {

		if (types.length != params.length) {
			throw new RuntimeException("Parameter count and types lengths did not match");
		}

		this.query = query;
		this.types = types;
		this.params = params;
	}

	/**
	 * 
	 */
	public ResultSet execute() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			statement = connection.prepareStatement(query);
			for (int i = 0; i < types.length; i++) {
				if (String.class.isAssignableFrom(types[i])) {
					statement.setString(i+1, String.class.cast(params[i]));
				} else if (Integer.class.isAssignableFrom(types[i])) {
					statement.setInt(i+1, Integer.class.cast(params[i]));
				} else if (Double.class.isAssignableFrom(types[i])) {
					statement.setDouble(i+1, Double.class.cast(params[i]));
				} else if (Date.class.isAssignableFrom(types[i])) {
					statement.setDate(i+1, Date.class.cast(params[i]));
				}
			}
			resultSet = statement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
