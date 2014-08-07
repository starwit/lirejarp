package de.starwit.lirejarp.ejb.impl;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import de.starwit.lirejarp.ejb.AuthorService;
import de.starwit.lirejarp.entity.AuthorEntity;

@Stateless(name="AuthorService")
public class AuthorServiceImpl extends AbstractServiceImpl<AuthorEntity> implements AuthorService {

	private static final long serialVersionUID = 1L;
	
	public AuthorEntity findByEmail(String email) {
		String sql = "select author from AuthorEntity author where author.email = :email";

		TypedQuery<AuthorEntity> query = getEntityManager().createQuery(
				sql, AuthorEntity.class);
		query.setParameter("email", email);
		return query.getSingleResult();
	}

}
