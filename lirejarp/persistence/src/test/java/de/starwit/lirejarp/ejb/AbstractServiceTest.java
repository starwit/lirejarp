package de.starwit.lirejarp.ejb;

import javax.inject.Inject;

import org.jboss.arquillian.junit.InSequence;
import org.junit.Assert;
import org.junit.Test;

import de.starwit.lirejarp.entity.AbstractEntity;
import de.starwit.lirejarp.exception.EntityNotFoundException;



public abstract class AbstractServiceTest<E extends AbstractService<T>, T extends AbstractEntity> {
	
	protected static Long ID;
	
	protected E service;
	protected T entity;
	
	@Inject
    public abstract void setService(E service);

    public E getService() {
		return service;
	}
    
    @Test
    @InSequence(1)
    public abstract void testCreate();
    
	@Test
	@InSequence(2)
	public void testFindById() {
		entity = getService().findById(ID);
		Assert.assertNotNull(entity);
	}
    
    @Test
    @InSequence(3)
    public abstract void testUpdate();
    
	@Test
	@InSequence(4)
	public void testDelete() throws EntityNotFoundException {
		entity = getService().findById(ID);
		Assert.assertNotNull(entity);
		getService().delete(ID);
		entity = getService().findById(ID);
		Assert.assertNull(entity);
	}
	
   
}
