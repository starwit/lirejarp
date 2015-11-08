package de.starwit.lirejarp.api.rest;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.starwit.lirejarp.api.rest.response.EntityResponse;
import de.starwit.lirejarp.ejb.PersonService;
import de.starwit.lirejarp.entity.PersonEntity;

@Path("/person")
@Consumes("application/json")
@Produces("application/json")
public class PersonRest extends AbstractRest<PersonEntity> {
	
	@Inject
	protected PersonService service;
	
	@Override
	protected PersonService getService() {
		return service;
	}
	
	//Create
	@Path("/")
	@PUT
	@Override
	public EntityResponse<PersonEntity> create(PersonEntity entity) {
		return super.createGeneric(entity);
	}

	//Update
	@Path("/")
	@POST
	@Override
	public EntityResponse<PersonEntity> update(PersonEntity entity) {
		return super.updateGeneric(entity);
	}
}