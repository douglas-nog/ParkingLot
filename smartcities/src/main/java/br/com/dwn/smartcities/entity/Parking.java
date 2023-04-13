package br.com.dwn.smartcities.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_parking")
public class Parking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parking")
	@SequenceGenerator(sequenceName = "sq_parking", name = "parking", allocationSize = 1, initialValue = 1)
	@Column(name = "cd_parking")
	private int code;
	
	@Column(name = "nm_parking", nullable = false, length = 100)
	private String parkingName;
	
	@Column(name = "ds_address", nullable = false, length = 255)
	private String address;
	
	@Column(name = "nr_parking_spaces", nullable = false, precision = 10)
	private int parkingSpaces;
	
	@Column(name = "vl_parking", nullable = false, precision = 10, scale = 2)
	private float price;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getParkingName() {
		return parkingName;
	}

	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getParkingSpaces() {
		return parkingSpaces;
	}

	public void setParkingSpaces(int parkingSpaces) {
		this.parkingSpaces = parkingSpaces;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
}