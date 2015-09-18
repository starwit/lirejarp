package de.starwit.lirejarp.ejb.impl;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import de.starwit.lirejarp.ejb.CategoryService;
import de.starwit.lirejarp.entity.CategoryEntity;

@Stateless(name = "CategoryService")
public class CategoryServiceImpl extends AbstractServiceImpl<CategoryEntity> implements CategoryService {
	
	private static final long serialVersionUID = 1L;
	
	public CategoryEntity findByName(String name) {
		String sql = "select category from CategoryEntity category where category.name = :name";

		TypedQuery<CategoryEntity> query = getEntityManager().createQuery(
				sql, CategoryEntity.class);
		query.setParameter("name", name);
		return query.getSingleResult();
	}
}
