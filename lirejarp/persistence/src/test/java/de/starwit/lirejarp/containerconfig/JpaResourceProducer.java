package de.starwit.lirejarp.containerconfig;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Singleton
public class JpaResourceProducer {
	
    @Produces @ApplicationScoped @EntityManagerForTest
    public EntityManager getEntityManager() {
        Map<String, Object> config = new HashMap<String, Object>();
        config.put("hibernate.hbm2ddl.auto", "create");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MeineJpaPU", config);
        EntityManager em = emf.createEntityManager();
	    return em;
    }
    
    void close(@Disposes @EntityManagerForTest EntityManager em) {
    	if (em.getEntityManagerFactory().isOpen()) {
    		em.getEntityManagerFactory().close();
    	}
    	if(em.isOpen()) {
    		em.close();
    	}
    }
}
