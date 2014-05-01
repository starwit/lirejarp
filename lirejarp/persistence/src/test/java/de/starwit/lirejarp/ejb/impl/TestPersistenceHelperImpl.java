package de.starwit.lirejarp.ejb.impl;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import de.starwit.lirejarp.containerconfig.EntityManagerForTest;
import de.starwit.lirejarp.ejb.PersistenceHelper;

@Alternative
public class TestPersistenceHelperImpl implements PersistenceHelper {

	@Inject @EntityManagerForTest
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

    public EntityManager getEntityManager() {    
        return entityManager;    
    }   
	
}
