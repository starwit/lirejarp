package de.starwit.lirejarp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotBlank;

@XmlRootElement
@Entity
@Table(name="NEWS")
public class NewsEntity extends AbstractEntity {
	
	private static final long serialVersionUID = -3717230832637971328L;
	
	@NotBlank
	@Size(max = 100)
	private String title;

	@NotNull
	private Date publishedAt;
	
	@NotBlank
	@Size(max = 100)
	private String publishedBy;
	
	@NotBlank
	@Size(max = 1000)
	private String content;
	
	@NotNull
	private CategoryEntity category;
	
	@Column(name="TITLE", nullable = false, length=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="PUBLISHED_BY", nullable = false, length=100)
	public String getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(String publishedBy) {
		this.publishedBy = publishedBy;
	}

	@Column(name="CONTENT", nullable = false, length=1000)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "PUBLISHED_AT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}
	
	@ManyToOne
	@JoinColumn(name = "CATEGORY_ID", nullable = false)
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	
}
