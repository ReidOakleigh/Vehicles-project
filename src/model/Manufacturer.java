package model;

import javax.persistence.*;

/**
 * Rumbi Chinhamhora rchinhamhora
 * CIS 175 - Spring 2021
 * Mar 7, 2021
 */
@Entity
@Table(name="manufacturers")
public class Manufacturer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="MAN_ID")
	private int manId;
	@Column(name="MANUFACTURER_NAME")
	private String manufacturerName;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="COUNTRY_ID")
	private Country country;
	
	public Manufacturer() {
		super();
	}

	public Manufacturer(Country country, String manufacturerName) {
		super();
		this.country = country;
		this.manufacturerName = manufacturerName;
	}

	public int getManId() {
		return manId;
	}

	public Country getCountry() {
		return country;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	
	@Override
	public String toString() {
		return "Manufacturer [manId=" + manId + ", "
			+ "manufacturerName=" + manufacturerName + ", "
			+ "country=" + country.getCountryName() + "]";
	}

	
}
