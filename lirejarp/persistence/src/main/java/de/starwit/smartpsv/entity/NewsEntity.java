package de.starwit.smartpsv.entity;

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

@XmlRootElement
@Entity
@Table(name="NEWS")
public class NewsEntity extends AbstractEntity {
	
	private static final long serialVersionUID = -3717230832637971328L;
	
	@NotNull
	@Size(max = 100)
	private String title;
	
	@NotNull
	private Date publishedAt;
	
	@NotNull
	@Size(max = 100)
	private Date publishedBy;
	
	@NotNull
	@Size(max = 1000)
	private Date content;
	
	private CategoryEntity category;
	
	@Column(name="TITLE", nullable = false, length=100)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="PUBLISHED_BY", nullable = false, length=100)
	public Date getPublishedBy() {
		return publishedBy;
	}

	public void setPublishedBy(Date publishedBy) {
		this.publishedBy = publishedBy;
	}

	@Column(name="CONTENT", nullable = false, length=1000)
	public Date getContent() {
		return content;
	}

	public void setContent(Date content) {
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
	@JoinColumn(name = "CATEGORY_ID", nullable = true)
	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
	
	
}
