package de.starwit.lirejarp.ejb;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Assert;
import org.junit.runner.RunWith;

import de.starwit.lirejarp.entity.AddressEntity;

@RunWith(Arquillian.class)
public class AddressServiceTest extends AbstractServiceTest<AddressService, AddressEntity> {
	
	@Override
	public void setService(AddressService service) {
		this.service = service;
	}

	@Override
	public void testCreate() {
		entity = new AddressEntity();
		entity = getService().create(entity);
		ID = entity.getId();
		Assert.assertNotNull(entity.getId());
		Assert.fail("Not yet implemented");
		
	}

	@Override
	public void testUpdate() {
		entity = getService().findById(ID);
		entity = getService().update(entity);
		Assert.fail("Not yet implemented");
	}

}
