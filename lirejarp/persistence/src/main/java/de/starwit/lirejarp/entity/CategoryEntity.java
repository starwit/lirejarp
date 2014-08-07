package de.starwit.lirejarp.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "CATEGORY")
public class CategoryEntity extends AbstractEntity {
	
	private static final long serialVersionUID = -1458424080034108665L;

	@NotNull
	@Size(max = 30)
	private String name;
		
	private List<NewsEntity> news;

	private AuthorEntity author;
	
	private List<PublicationEntity> publications;

	@Column(name="NAME", nullable = false, length=100)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@XmlTransient
	@OneToMany(mappedBy="category")
	public List<NewsEntity> getNews() {
		return news;
	}
	
	public void setNews(List<NewsEntity> news) {
		this.news = news;
	}

	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	public AuthorEntity getAuthor() {
		return author;
	}

	
	public void setAuthor(AuthorEntity author) {
		this.author = author;
	}
	
	@XmlTransient
	@OneToMany(mappedBy="category")
	public List<PublicationEntity> getPublications() {
		return publications;
	}

	public void setPublications(List<PublicationEntity> publications) {
		this.publications = publications;
	}
}
