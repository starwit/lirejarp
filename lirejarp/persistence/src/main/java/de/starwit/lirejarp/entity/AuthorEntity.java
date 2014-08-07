package de.starwit.lirejarp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement
@Entity
@Table(name="AUTHOR")
public class AuthorEntity extends AbstractEntity {
	
	private static final long serialVersionUID = -3717230832637971328L;
	
	@NotBlank
	@Size(max = 100)
	private String firstname;

	@NotBlank
	@Size(max = 100)
	private String lastname;
	
	@Size(max = 100)
	private String email;
	
	@Column(name="FIRSTNAME", nullable = false, length=100)
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	@Column(name="LASTNAME", nullable = false, length=100)
	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name="EMAIL", length=100)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
