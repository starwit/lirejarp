package de.starwit.lirejarp.api.rest;

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
import de.starwit.lirejarp.api.rest.response.EntityWithChildrenResponse;
import de.starwit.lirejarp.ejb.CategoryService;
import de.starwit.lirejarp.entity.CategoryEntity;
import de.starwit.lirejarp.entity.NewsEntity;

@Path("/category")
@Consumes("application/json")
@Produces("application/json")
public class CategoryRest extends AbstractRest<CategoryEntity> {
	
	@Inject
	private CategoryService service;
	
	@Override
	protected CategoryService getService() {
		return service;
	}

	//Create
	@PUT
	@Override
	public EntityResponse<CategoryEntity> create(CategoryEntity entity) {
		return super.createGeneric(entity);
	}

	//Update
	@POST
	@Override
	public EntityResponse<CategoryEntity> update(CategoryEntity entity) {
		return super.updateGeneric(entity);
	}
	
	@Path("/all")
	@GET
	public EntityListResponse<CategoryEntity> getAll() {
		return super.genericGetAll();
	}
	
 	/**
	 * returns a container entity with associated packing piece list.
	 * @param packingpieceID
	 * @return
	 */
	@Path("/ext/{categoryId}")
	@GET
	public EntityWithChildrenResponse<CategoryEntity, NewsEntity> getWithNewsById(@PathParam("categoryId") Long categoryId) {
		CategoryEntity entity = service.findByIdWithRelations(categoryId, "news");
		EntityWithChildrenResponse<CategoryEntity, NewsEntity> rw;
		rw = new EntityWithChildrenResponse<CategoryEntity, NewsEntity>(entity, entity.getNews());
		return rw;
	}
}
