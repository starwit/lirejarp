package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
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
		Assert.assertNotNull(entity.getId());
		
	}

	@Override
	public void testUpdate() {
		testCreate();
		entity = getService().findById(ID);
		entity.setName("testtest");
		entity = getService().update(entity);
		Assert.assertEquals("testtest", entity.getName());
	}
	
}
