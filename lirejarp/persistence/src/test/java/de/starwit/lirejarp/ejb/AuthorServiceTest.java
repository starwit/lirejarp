package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.AuthorEntity;

@RunWith(Arquillian.class)
public class AuthorServiceTest extends AbstractServiceTest<AuthorService, AuthorEntity> {
	
	@Override
	public void setService(AuthorService service) {
		this.service = service;
	}

	@Override
	public void testCreate() {
		entity = new AuthorEntity();
		entity.setFirstname("test");
		entity.setLastname("test");
		entity = getService().create(entity);
		ID = entity.getId();
		Assert.assertNotNull(entity.getId());
		
	}

	@Override
	public void testUpdate() {
		entity = getService().findById(ID);
		entity.setFirstname("testtest");
		entity = getService().update(entity);
		Assert.assertEquals("testtest", entity.getFirstname());
	}

}
