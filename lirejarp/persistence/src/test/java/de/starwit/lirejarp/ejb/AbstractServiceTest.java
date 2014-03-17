package de.starwit.lirejarp.ejb;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;

import de.starwit.lirejarp.containerconfig.EntityManagerForTest;

@SuppressWarnings("rawtypes")
public abstract class AbstractServiceTest<E extends AbstractService> {
	
	@Inject @EntityManagerForTest  
	private EntityManager em;
	protected E service;

	@Before
    public void setup() {
    	getService().setEntityManager(em);
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
   
}
