package de.starwit.lirejarp.ejb;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import de.starwit.lirejarp.containerconfig.EntityManagerForTest;
import de.starwit.lirejarp.entity.AbstractEntity;
import de.starwit.lirejarp.exception.EntityNotFoundException;



public abstract class AbstractServiceTest<E extends AbstractService<T>, T extends AbstractEntity> {
	
	protected static Long ID;
	
	@Inject @EntityManagerForTest  
	private EntityManager em;
	protected E service;
	protected T entity;

	@Before
    public void setup() {
		if (getService().getEntityManager() == null) {
			getService().setEntityManager(em);
		}
    	beginTransaction();
    }
    
    @After
    public void tearDown() {   
    	closeTransaction();
    }

    public void beginTransaction() {
    	getService().getEntityManager().getTransaction().begin();
    }
    
    public void closeTransaction() {
        if (getService().getEntityManager().getTransaction().isActive()) {
        	getService().getEntityManager().getTransaction().rollback();
        }
    }

	@Inject
    public abstract void setService(E service);

    public E getService() {
		return service;
	}
    
    protected EntityManager getEntityManager() {
    	return em;
    }
    
    @Test
    public abstract void testCreate();
    
    @Test
    public abstract void testUpdate();
    
	@Test
	public void testFindById() {
		testCreate();
		entity = getService().findById(ID);
		Assert.assertNotNull(entity);
	}
	
	@Test
	public void testDelete() throws EntityNotFoundException {
		testCreate();
		entity = getService().findById(ID);
		Assert.assertNotNull(entity);
		getService().delete(ID);
		entity = getService().findById(ID);
		Assert.assertNull(entity);
	}
	
   
}
