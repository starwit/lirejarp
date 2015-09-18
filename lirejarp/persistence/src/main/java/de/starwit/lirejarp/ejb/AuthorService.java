package de.starwit.lirejarp.ejb;

import java.io.Serializable;

import javax.ejb.Local;

import de.starwit.lirejarp.entity.AuthorEntity;

@Local
public interface AuthorService extends Serializable, AbstractService<AuthorEntity> {
	
	AuthorEntity findByEmail(String email);

}
