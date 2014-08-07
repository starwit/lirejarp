package de.starwit.lirejarp.api.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import de.starwit.lirejarp.api.rest.response.EntityListResponse;
import de.starwit.lirejarp.api.rest.response.EntityResponse;
import de.starwit.lirejarp.api.rest.response.ResponseCode;
import de.starwit.lirejarp.api.rest.response.ResponseMetadata;
import de.starwit.lirejarp.api.rest.validation.EntityValidator;
import de.starwit.lirejarp.ejb.AbstractService;
import de.starwit.lirejarp.entity.AbstractEntity;
import de.starwit.lirejarp.exception.EntityNotFoundException;

public abstract class AbstractRest<E extends AbstractEntity> {
	
	private static final Logger LOG = Logger.getLogger("fileAppender");
	
	/**
	 * Deserialisation of JSON is not working. Implement abstract method instead:
	 **************************************************************************** 	
		@PUT
		@Override
		public ResultStateWrapper create(E entity) {
			return super.createGeneric(entity);
		}
	 ****************************************************************************
	 * @param entity
	 * @return
	 */
	public abstract EntityResponse<E> create(E entity);
	
	/**
	 * Deserialisation of JSON is not working. Implement abstract method instead:
	 **************************************************************************** 	
		@POST
		@Override
		public ResultStateWrapper update(E entity) {
			return super.updateGeneric(entity);
		}
	 ****************************************************************************
	 * @param entity
	 * @return
	 */
	public abstract EntityResponse<E> update(E entity);
	

	/**
	 * Typify persistence service
	 */
	protected abstract AbstractService<E> getService();
	
	public EntityResponse<E> createGeneric(E entity) {
		LOG.debug("************ FrontendService create for " + getService().getClass().getSimpleName());
	
		EntityResponse<E> response = new EntityResponse<E>();
		ResponseMetadata responseMetadata = EntityValidator.validate(entity);
		response.setMetadata(responseMetadata);
		
		if (!ResponseCode.NOT_VALID.equals(responseMetadata.getResponseCode())) {
			E interalEntity = getService().create(entity);
			response.setResult(interalEntity);
			response.setMetadata(EntityValidator.savedResultExists(interalEntity));
		}
		return response;
	}

	
	//Update
	@POST
	public EntityResponse<E> updateGeneric(E entity) {
		EntityResponse<E> response = new EntityResponse<E>();
		ResponseMetadata responseMetadata = EntityValidator.validate(entity);
		response.setMetadata(responseMetadata);
		
		if (!ResponseCode.NOT_VALID.equals(responseMetadata.getResponseCode())) {
			E interalEntity = getService().update(entity);
			response.setMetadata(EntityValidator.savedResultExists(interalEntity));
		}
		return response;
	}

	/**
	 * returns a flat entity with NO associated entities
	 * 
	 * @param id
	 * @return
	 */
	@Path("/query/{entityId}")
	@GET
	public EntityResponse<E> getById(@PathParam("entityId") Long id) {
		E entity = getService().findById(id);
		EntityResponse<E> rw = new EntityResponse<E>(entity);
		return rw;
	}
	

	
	//Delete
	@Path("/delete/{entityId}")
	@DELETE
	public EntityResponse<E> delete(@PathParam("entityId") Long id) {
		EntityResponse<E> response = new EntityResponse<E>();
		ResponseMetadata responseMetadata = new ResponseMetadata();
		
		try {
			getService().delete(id);
			responseMetadata.setResponseCode(ResponseCode.OK);
			responseMetadata.setMessage("Der Eintrag wurde gelöscht.");
		} catch (EntityNotFoundException e) {
			responseMetadata.setResponseCode(ResponseCode.NOT_DELETE);
			responseMetadata.setMessage("Der Eintrag konnte nicht gelöscht werden. " + e.getMessage());
		}

		response.setMetadata(responseMetadata);
		return response;
	}
	
	
	protected EntityListResponse<E> genericGetAll() {
		List<E> entities = getService().findAll();
		EntityListResponse<E> response = new EntityListResponse<E>(entities);
		ResponseMetadata responseMetadata = EntityValidator.isNotEmpty(response.getResult());
		response.setMetadata(responseMetadata);
		return response;
	}
}
