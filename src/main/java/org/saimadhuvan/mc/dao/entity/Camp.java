package org.saimadhuvan.mc.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author madhu.b
 *
 */
@Entity
@Table(name = "camp")
public class Camp {

	/**
	 * 
	 */
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="idCamp")
	private int id;
	
	@Column(name="campName")
	private String campName;
	
	@Column(name="campAddress")
	private String Address;
	
	/*@Column(name="campCordinatorId")
	private Long cordinatorId;*/
	
	public Camp() {
		// TODO Auto-generated constructor stub
	}

	public Camp(String cmpName, String cmpAddress/*, Long crdId*/) {
		this.campName = cmpName;
		this.Address = cmpAddress;
		//this.cordinatorId = crdId;	
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

/*	public Long getCordinatorId() {
		return cordinatorId;
	}

	public void setCordinatorId(Long cordinatorId) {
		this.cordinatorId = cordinatorId;
	}*/

	public int getId() {
		return id;
	}
}
