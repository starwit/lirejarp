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

import de.starwit.lirejarp.api.rest.validation.ResultStateWrapper;
import de.starwit.lirejarp.api.rest.validation.ResultValidator;
import de.starwit.lirejarp.api.rest.wrapper.ListResultWrapper;
import de.starwit.lirejarp.api.rest.wrapper.ResultWrapper;
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
	@PUT
	@Override
	public ResultWrapper<NewsEntity> create(NewsEntity entity) {
		System.out.println("Category Id: " + entity.getCategory().getId());
		System.out.println("Category name: " + entity.getCategory().getName());
		entity.setPublishedAt(new Date());
		return super.createGeneric(entity);
	}

	//Update
	@POST
	@Override
	public ResultStateWrapper update(NewsEntity entity) {
		System.out.println("Category Id: " + entity.getCategory().getId());
		System.out.println("Category name: " + entity.getCategory().getName());
		entity.setPublishedAt(new Date());
		return super.updateGeneric(entity);
	}
	
	@Path("/all")
	@GET
	public ListResultWrapper<NewsEntity> getAll() {
		return super.genericGetAll();
	}
	
	@Path("/ext/today")
	@GET
	public ListResultWrapper<NewsEntity> getToday() {
		List<NewsEntity> entities = service.findToday();
		ListResultWrapper<NewsEntity> resultWrapper = new ListResultWrapper<NewsEntity>(entities);
		ResultStateWrapper resultStateWrapper = ResultValidator.isNotEmpty(resultWrapper.getResult());
		resultWrapper.setResultState(resultStateWrapper);
		return resultWrapper;	
	}
	
	@Path("/ext/category/{catedoryId}")
	@GET
	public ListResultWrapper<NewsEntity> getByCategory(@PathParam("catedoryId") Long id) {
		List<NewsEntity> entities = service.findByCategory(id);
		ListResultWrapper<NewsEntity> resultWrapper = new ListResultWrapper<NewsEntity>(entities);
		ResultStateWrapper resultStateWrapper = ResultValidator.isNotEmpty(resultWrapper.getResult());
		resultWrapper.setResultState(resultStateWrapper);
		return resultWrapper;	
	}
	
}
