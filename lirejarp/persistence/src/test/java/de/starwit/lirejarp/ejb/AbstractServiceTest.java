package de.starwit.lirejarp.ejb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import de.starwit.lirejarp.ejb.AbstractService;

@SuppressWarnings("rawtypes")
public class AbstractServiceTest<E extends AbstractService> {
	
	protected static EntityManager em;
	protected static EntityManagerFactory emf;
	protected E service;
	
    @BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("MeineJpaPU");
        em = emf.createEntityManager();
    }

    @AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }

    public void configureEntityManager() {
    	service.setEntityManager(em);
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

    @After
    public void tearDown() {   
    	closeTransaction();
    }
    
	@Deployment
	public static Archive<?> createTestArchive() {
        return ShrinkWrap.create(JavaArchive.class, "test.jar").addPackages(true, "de/starwit/smartpsv")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml");
	}
}
