package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subregion {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private String id;

	/*@Column(name = "region_id")
	private Long regionId;*/
	
	@Column(name = "subregion_name")
	private String subregionName;

	public String getid() {
		return id;
	}

	public String getSubregionName() {
		return subregionName;
	}

}
