package de.starwit.lirejarp.ejb;

import javax.persistence.EntityManager;
/**
 * Entity Manager cannot be set in tests with @PersistenceContext. This class is a helper-class to
 * integrate another EntityManager-creation-process in junit-tests.
 * @author Anett
 *
 */
public interface PersistenceHelper {
	
	EntityManager getEntityManager();
	void setEntityManager(EntityManager entityManager);

}
