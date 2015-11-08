package de.starwit.lirejarp.api.rest;


import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.starwit.lirejarp.api.rest.response.EntityResponse;
import de.starwit.lirejarp.ejb.AddressService;
import de.starwit.lirejarp.entity.AddressEntity;

@Path("/address")
@Consumes("application/json")
@Produces("application/json")
public class AddressRest extends AbstractRest<AddressEntity> {
	
	@Inject
	protected AddressService service;
	
	@Override
	protected AddressService getService() {
		return service;
	}
	
	//Create
	@Path("/")
	@PUT
	@Override
	public EntityResponse<AddressEntity> create(AddressEntity entity) {
		return super.createGeneric(entity);
	}

	//Update
	@Path("/")
	@POST
	@Override
	public EntityResponse<AddressEntity> update(AddressEntity entity) {
		return super.updateGeneric(entity);
	}
}