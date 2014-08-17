package de.starwit.lirejarp.api.rest;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import de.starwit.lirejarp.api.rest.response.EntityListResponse;
import de.starwit.lirejarp.api.rest.response.EntityResponse;
import de.starwit.lirejarp.api.rest.response.ResponseMetadata;
import de.starwit.lirejarp.api.rest.validation.EntityValidator;
import de.starwit.lirejarp.ejb.NewsService;
import de.starwit.lirejarp.entity.NewsEntity;

@Path("/${domainLower}")
@Consumes("application/json")
@Produces("application/json")
public class ${domain}Rest extends AbstractRest<${domain}Entity> {
	
	@Inject
	protected ${domain}Service service;
	
	@Override
	protected ${domain}Service getService() {
		return service;
	}
	
	//Create
	@Path("/create")
	@PUT
	@Override
	public EntityResponse<${domain}Entity> create(${domain}Entity entity) {
		return super.createGeneric(entity);
	}

	//Update
	@Path("/update")
	@POST
	@Override
	public EntityResponse<${domain}Entity> update(${domain}Entity entity) {
		return super.updateGeneric(entity);
	}