package de.starwit.lirejarp.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import de.starwit.lirejarp.ejb.CategoryService;
import de.starwit.lirejarp.entity.CategoryEntity;
import de.starwit.lirejarp.entity.NewsEntity;
import de.starwit.lirejarp.exception.EntityNotFoundException;

@Stateless(name = "CategoryService")
public class CategoryServiceImpl extends AbstractServiceImpl<CategoryEntity> implements CategoryService {
	
	private static final long serialVersionUID = 2426831807321817571L;
	
	@Override
	public void delete(Long id) throws EntityNotFoundException {
		CategoryEntity entity = getEntityManager().find(CategoryEntity.class, id);
		if (entity == null) {
			throw new EntityNotFoundException(id, CategoryEntity.class.getName());
		}
		
		List<NewsEntity> news = entity.getNews();
		if (news != null) {
			for (NewsEntity newsEntity : news) {
				getEntityManager().remove(newsEntity);
			}
		}
		getEntityManager().remove(entity);
	}
}
