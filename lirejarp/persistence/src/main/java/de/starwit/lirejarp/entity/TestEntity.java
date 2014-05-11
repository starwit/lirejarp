package de.starwit.lirejarp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement
@Entity
@Table(name="TEST")
public class TestEntity extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@NotBlank
	@Size(max = 100)
	private String title;

	@Column(name="TITLE", nullable = false, length=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
