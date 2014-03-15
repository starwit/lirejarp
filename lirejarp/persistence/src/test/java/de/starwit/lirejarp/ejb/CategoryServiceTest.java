package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.CategoryEntity;

@RunWith(Arquillian.class)
public class CategoryServiceTest extends AbstractServiceTest<CategoryService> {


	@Override
	public void setService(CategoryService service) {
		this.service = service;
	}
	
	@Test
	public void addCategory() {
		CategoryEntity category = new CategoryEntity();
		getService().setEntityManager(em);
		category.setName("Politics");
		category = getService().create(category);
		Assert.assertNotNull(category.getId());
	}
	
}
