package app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subregion implements Serializable{
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
