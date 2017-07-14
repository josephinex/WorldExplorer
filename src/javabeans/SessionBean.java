package javabeans;

import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.sql.DataSource;

@ManagedBean(name = "sessionBean", eager = true)
@ViewScoped
public class SessionBean {

	//@Resource(name = "jdbc/world")
	//private DataSource dataSource;

	/*public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
*/
}
