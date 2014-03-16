package de.starwit.lirejarp.ejb;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

@SuppressWarnings("rawtypes")
public abstract class AbstractServiceTest<E extends AbstractService> {
	
	protected static EntityManager em;
	protected static EntityManagerFactory emf;
	protected E service;

    @BeforeClass
    public static void setupBeforeClass() {
        emf = Persistence.createEntityManagerFactory("MeineJpaPU");
        em = emf.createEntityManager();
    }

	@AfterClass
    public static void TearDownAfterClass() {
        emf.close();
    }
	
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
        em.getTransaction().begin();
    }
    
    public void closeTransaction() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }

        if (em.isOpen()) {
            em.close();
        }
    }

	@Inject
    public abstract void setService(E service);

    public E getService() {
		return service;
	}
   
}
