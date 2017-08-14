package app.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Region {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name="region_name")
	private String regionName;

	public long getId() {
		return id;
	}

	public String getRegionName() {
		return regionName;
	}

}
