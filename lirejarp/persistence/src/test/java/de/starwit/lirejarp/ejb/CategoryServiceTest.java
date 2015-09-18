package de.starwit.lirejarp.ejb;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.AuthorEntity;
import de.starwit.lirejarp.entity.CategoryEntity;

@RunWith(Arquillian.class)
public class CategoryServiceTest extends AbstractServiceTest<CategoryService, CategoryEntity> {
	
	@Inject
	public AuthorService authorService;

	@Override
	public void setService(CategoryService service) {
		this.service = service;
	}

	@Override
	public void testCreate() {
		AuthorEntity author = authorService.findByEmail("test@Huebner.com");
		entity = new CategoryEntity();
		entity.setName("Politics");
		entity.setAuthor(author);
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
	
	@Test
	public void testFindByIdWithRelations() {
		CategoryEntity caterory = getService().findByIdWithRelations(1L, "news", "publications");
		Assert.assertEquals(1, caterory.getNews().size());
		Assert.assertEquals(2, caterory.getPublications().size());
	}
	
	@Test
	public void testFindByIdWithRelation() {
		CategoryEntity caterory = getService().findByIdWithRelation(1L, "publications");
		Assert.assertEquals(2, caterory.getPublications().size());
	}
	
	@Test
	public void testFindByName() {
		try {
			getService().findByName("Microservices");
		} catch (Exception e) {
			Assert.fail();
		}
	}

}
