package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.NewsEntity;

@RunWith(Arquillian.class)
public class NewsServiceTest extends AbstractServiceTest<NewsService, NewsEntity> {
	
	@Override
	public void setService(NewsService service) {
		this.service = service;
	}

	@Test
	public void testCreate() {
		entity = new NewsEntity();
		entity.setTitle("Politics");
		entity.setPublishedBy("testtest");
		entity.setContent("Das ist ein Test");
		entity = getService().create(entity);
		ID = entity.getId();
		Assert.assertNotNull(ID);
	}

	@Override
	public void testUpdate() {
		testCreate();
		entity = getService().findById(ID);
		entity.setTitle("testtest");
		entity = getService().update(entity);
		Assert.assertEquals("testtest", entity.getTitle());
	}
}
