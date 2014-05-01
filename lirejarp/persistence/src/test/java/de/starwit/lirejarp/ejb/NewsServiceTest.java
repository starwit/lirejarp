package de.starwit.lirejarp.ejb;

import java.util.Date;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.CategoryEntity;
import de.starwit.lirejarp.entity.NewsEntity;

@RunWith(Arquillian.class)
public class NewsServiceTest extends AbstractServiceTest<NewsService, NewsEntity> {
	
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar").addPackages(true, "de/starwit/lirejarp")
	                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
	                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}
	
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
		categoryService.create(category);
		
		
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
}
