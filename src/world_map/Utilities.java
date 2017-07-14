package world_map;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabeans.DataSourceConnection;

public class Utilities extends DataSourceConnection {
	
	private static final long serialVersionUID = 6278777605627325963L;

	public Utilities(String query, Object[] params, Class<Object>[] types) {
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
