package de.starwit.smartpsv.api.rest;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import de.starwit.smartpsv.api.rest.validation.ResultStateWrapper;
import de.starwit.smartpsv.api.rest.validation.ResultValidator;
import de.starwit.smartpsv.api.rest.wrapper.ListResultWrapper;
import de.starwit.smartpsv.api.rest.wrapper.ResultWrapper;
import de.starwit.smartpsv.ejb.NewsService;
import de.starwit.smartpsv.entity.NewsEntity;

@Path("/news")
@Consumes("application/json")
@Produces("application/json")
public class NewsRest extends AbstractCrud<NewsEntity> {
	
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
		return super.createGeneric(entity);
	}

	//Update
	@POST
	@Override
	public ResultStateWrapper update(NewsEntity entity) {
		return super.updateGeneric(entity);
	}
	
	@Path("/ext/today")
	@GET
	public ListResultWrapper<NewsEntity> getNewsToday() {
		List<NewsEntity> pps = service.findNewsByDay(new Date());
		ListResultWrapper<NewsEntity> resultWrapper = new ListResultWrapper<NewsEntity>(pps);
		ResultStateWrapper resultStateWrapper = ResultValidator.isNotEmpty(resultWrapper.getResult());
		resultWrapper.setResultState(resultStateWrapper);
		return resultWrapper;	
	}
	
}
