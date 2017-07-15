package beans;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;


public abstract class DataSourceConnection implements Serializable{
	private static final long serialVersionUID = -7616350789926321898L;

	@Resource(mappedName = "jdbc/world")
	private DataSource dataSource;
	
	private String query = "";
	private Object[] params;
	private Class<Object>[] types;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public DataSourceConnection(String query, Object[] params, Class<Object>[] types) {
		if (params!=null && types.length != params.length) {
			throw new RuntimeException("Parameter count and types lengths did not match");
		}
		this.query = query;
		this.types = types;
		this.params = params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public ResultSet execute() {
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection;
		try {
			connection = this.connect();
			statement = connection.prepareStatement(query);
			for (int i = 0; i < types.length; i++) {
				if (String.class.isAssignableFrom(types[i])) {
					statement.setString(i + 1, String.class.cast(params[i]));
				} else if (Integer.class.isAssignableFrom(types[i])) {
					statement.setInt(i + 1, Integer.class.cast(params[i]));
				} else if (Double.class.isAssignableFrom(types[i])) {
					statement.setDouble(i + 1, Double.class.cast(params[i]));
				} else if (Date.class.isAssignableFrom(types[i])) {
					statement.setDate(i + 1, Date.class.cast(params[i]));
				}
			}
			resultSet = statement.executeQuery();
			this.close(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public Connection connect() throws SQLException {
		return dataSource.getConnection();
	}
	
	public void close(Connection connection) throws SQLException{
		connection.close(); 
	}

}
