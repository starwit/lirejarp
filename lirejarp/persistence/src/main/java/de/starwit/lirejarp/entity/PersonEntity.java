package de.starwit.lirejarp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement
@Entity
@Table(name="PERSON")
public class PersonEntity extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	//domain attributes
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String firstName;
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String lastName;
	
	@Size(min = 1, max = 10)
	private String title;
	
	@NotBlank
	@Size(min = 1, max = 2)
	private String age;
	
	

	@Column(name="FIRSTNAME", nullable = false, length=20)
	public String getFirstName() {
		return firstName;
	}
	
		public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LASTNAME", nullable = false, length=20)
	public String getLastName() {
		return lastName;
	}
	
		public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="TITLE", length=10)
	public String getTitle() {
		return title;
	}
	
		public void setTitle(String title) {
		this.title = title;
	}

	@Column(name="AGE", nullable = false, length=2)
	public String getAge() {
		return age;
	}
	
		public void setAge(String age) {
		this.age = age;
	}
}