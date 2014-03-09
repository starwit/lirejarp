package de.starwit.lirejarp.ejb;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.ejb.CategoryService;
import de.starwit.lirejarp.entity.CategoryEntity;

@RunWith(Arquillian.class)
public class CategoryServiceTest extends AbstractServiceTest<CategoryService> {
		
	@Inject
	private CategoryService categoryService;
	

    @Before
    public void setup() {
    	service = categoryService;
    	configureEntityManager();
    	beginTransaction();
    }
	
	@Test
	public void addCategory() {
		CategoryEntity category = new CategoryEntity();
		categoryService.setEntityManager(em);
		category.setName("Politics");
		category = categoryService.create(category);
		Assert.assertNotNull(category.getId());
	}
}