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

@Path("/news")
@Consumes("application/json")
@Produces("application/json")
public class NewsRest extends AbstractRest<NewsEntity> {
	
	@Inject
	protected NewsService service;
	
	@Override
	protected NewsService getService() {
		return service;
	}
	
	//Create
	@Path("/create")
	@PUT
	@Override
	public EntityResponse<NewsEntity> create(NewsEntity entity) {
		entity.setPublishedAt(new Date());
		return super.createGeneric(entity);
	}

	//Update
	@Path("/update")
	@POST
	@Override
	public EntityResponse<NewsEntity> update(NewsEntity entity) {
		entity.setPublishedAt(new Date());
		return super.updateGeneric(entity);
	}
	
	@Path("/ext/today")
	@GET
	public EntityListResponse<NewsEntity> getToday() {
		List<NewsEntity> entities = service.findToday();
		EntityListResponse<NewsEntity> response = new EntityListResponse<NewsEntity>(entities);
		ResponseMetadata responseMetadata = EntityValidator.isNotEmpty(response.getResult());
		response.setMetadata(responseMetadata);
		return response;	
	}
	
	@Path("/ext/category/{catedoryId}")
	@GET
	public EntityListResponse<NewsEntity> getByCategory(@PathParam("catedoryId") Long id) {
		List<NewsEntity> entities = service.findByCategory(id);
		EntityListResponse<NewsEntity> response = new EntityListResponse<NewsEntity>(entities);
		ResponseMetadata responseMetadata = EntityValidator.isNotEmpty(response.getResult());
		response.setMetadata(responseMetadata);
		return response;	
	}
	
}
