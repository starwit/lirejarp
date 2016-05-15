package de.starwit.lirejarp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement
@Entity
@Table(name="ADDRESS")
public class AddressEntity extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	//domain attributes
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String street;
	
	@NotBlank
	@Size(min = 1, max = 10)
	private String postcode;
	
	@NotNull
	@Min(value = 1)
	@Max(value = 4)
	private Integer streetNumber;
	
	

	@Column(name="STREET", nullable = false, length=20)
	public String getStreet() {
		return street;
	}
	
		public void setStreet(String street) {
		this.street = street;
	}

	@Column(name="POSTCODE", nullable = false, length=10)
	public String getPostcode() {
		return postcode;
	}
	
		public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	@Column(name="STREETNUMBER", nullable = false)
	public Integer getStreetNumber() {
		return streetNumber;
	}
	
		public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
}
