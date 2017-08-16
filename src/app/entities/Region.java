package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
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
