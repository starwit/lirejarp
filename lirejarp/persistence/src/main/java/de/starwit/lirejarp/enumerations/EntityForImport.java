package de.starwit.lirejarp.enumerations;

import de.starwit.lirejarp.entity.AbstractEntity;
import de.starwit.lirejarp.entity.AuthorEntity;
import de.starwit.lirejarp.entity.CategoryEntity;
import de.starwit.lirejarp.entity.NewsEntity;
import de.starwit.lirejarp.entity.PublicationEntity;

public enum EntityForImport {
	CategoryEntity(CategoryEntity.class),
	NewsEntity(NewsEntity.class),
	AuthorEntity(AuthorEntity.class),
	PublicationEntity(PublicationEntity.class);
	
	private Class<? extends AbstractEntity> entityClass;
	
	EntityForImport(Class<? extends AbstractEntity> entityClass) {
		this.entityClass = entityClass;
	}
	
	public String getClassString() {
		return entityClass.getName();
	}
	
	public Class<? extends AbstractEntity> getEntityClass() {
		return entityClass;
	}
}
