package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.PublicationEntity;

@RunWith(Arquillian.class)
public class PublicationServiceTest extends AbstractServiceTest<PublicationService, PublicationEntity> {
	
	@Override
	public void setService(PublicationService service) {
		this.service = service;
	}

	@Override
	public void testCreate() {
		entity = new PublicationEntity();
		entity.setTitle("Politics");
		entity = getService().create(entity);
		ID = entity.getId();
		Assert.assertNotNull(entity.getId());
		
	}

	@Override
	public void testUpdate() {
		entity = getService().findById(ID);
		entity.setTitle("testtest");
		entity = getService().update(entity);
		Assert.assertEquals("testtest", entity.getTitle());
	}

}
