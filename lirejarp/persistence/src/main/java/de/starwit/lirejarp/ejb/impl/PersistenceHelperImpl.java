package de.starwit.lirejarp.ejb.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import de.starwit.lirejarp.ejb.PersistenceHelper;

public class PersistenceHelperImpl implements PersistenceHelper {

	@PersistenceContext
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


}
