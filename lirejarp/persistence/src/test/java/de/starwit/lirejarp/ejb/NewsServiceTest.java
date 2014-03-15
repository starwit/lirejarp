package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.NewsEntity;

@RunWith(Arquillian.class)
public class NewsServiceTest extends AbstractServiceTest<NewsService> {
	
	@Override
	public void setService(NewsService service) {
		this.service = service;
	}

	@Test
	public void addNews() {
		beginTransaction();
		NewsEntity news = new NewsEntity();
		news.setTitle("Politics");
		news.setPublishedBy("testtest");
		news.setContent("Das ist ein Test");
		news = getService().create(news);
		closeTransaction();
		Assert.assertNotNull(news.getId());
	}
}
