package de.starwit.lirejarp.ejb;

import java.util.Date;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.CategoryEntity;
import de.starwit.lirejarp.entity.NewsEntity;
import de.starwit.lirejarp.exception.EntityNotFoundException;

@RunWith(Arquillian.class)
public class NewsServiceTest extends AbstractServiceTest<NewsService, NewsEntity> {
	
	private static Long CATEGORY_ID;
	
	@Inject 
	private CategoryService categoryService;
	
	@Override
	public void setService(NewsService service) {
		this.service = service;
	}
	
	@Override
	public void testCreate() {
		CategoryEntity category = new CategoryEntity();
		category.setName("testtest");
		category = categoryService.create(category);
		CATEGORY_ID = category.getId();
		
		entity = new NewsEntity();
		entity.setTitle("Politics");
		entity.setCategory(category);
		entity.setPublishedBy("testtest");
		entity.setPublishedAt(new Date());
		entity.setContent("Das ist ein Test");
		entity = getService().create(entity);
		ID = entity.getId();
		Assert.assertNotNull(ID);
	}

	@Override
	public void testUpdate() {
		entity = getService().findById(ID);
		entity.setTitle("testtest");
		entity = getService().update(entity);
		Assert.assertEquals("testtest", entity.getTitle());
	}
	
	@Override
	public void testDelete() throws EntityNotFoundException {
		super.testDelete();
		categoryService.delete(CATEGORY_ID);
	}
}
