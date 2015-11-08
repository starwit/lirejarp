package de.starwit.lirejarp.ejb.impl;


import javax.ejb.Stateless;
import de.starwit.lirejarp.ejb.PersonService;
import de.starwit.lirejarp.entity.PersonEntity;

@Stateless(name = "PersonService")
public class PersonServiceImpl extends AbstractServiceImpl<PersonEntity> implements PersonService {
	
	private static final long serialVersionUID = 1L;

}



    
