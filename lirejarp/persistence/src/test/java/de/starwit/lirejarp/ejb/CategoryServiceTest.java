package de.starwit.lirejarp.ejb;

import java.util.List;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.CategoryEntity;

@RunWith(Arquillian.class)
public class CategoryServiceTest extends AbstractServiceTest<CategoryService, CategoryEntity> {
	


	@Override
	public void setService(CategoryService service) {
		this.service = service;
	}

	@Override
	public void testCreate() {
		entity = new CategoryEntity();
		entity.setName("Politics");
		entity = getService().create(entity);
		ID = entity.getId();
		Assert.assertNotNull(ID);
		
	}

	@Override
	public void testUpdate() {
		entity = getService().findById(ID);
		entity.setName("testtest");
		entity = getService().update(entity);
		entity = getService().findById(ID);
		Assert.assertEquals("testtest", entity.getName());
	}
	
	@Test
	public void testFindAll() {
		List<CategoryEntity> categories = getService().findAll();
		Assert.assertEquals(3, categories.size());
	}

}
