package de.starwit.lirejarp.api.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.apache.log4j.Logger;

import de.starwit.lirejarp.api.rest.validation.ResultState;
import de.starwit.lirejarp.api.rest.validation.ResultStateWrapper;
import de.starwit.lirejarp.api.rest.validation.ResultValidator;
import de.starwit.lirejarp.api.rest.wrapper.ListResultWrapper;
import de.starwit.lirejarp.api.rest.wrapper.ResultWrapper;
import de.starwit.smartpsv.ejb.AbstractService;
import de.starwit.smartpsv.entity.AbstractEntity;
import de.starwit.smartpsv.exception.EntityNotFoundException;

public abstract class AbstractCrud<E extends AbstractEntity> {
	
	private static final Logger LOG = Logger.getLogger("fileAppender");//getLogger("SMARTPSV");

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
	public abstract ResultWrapper<E> create(E entity);
	
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
	public abstract ResultStateWrapper update(E entity);
	
	/**
	 * Typify persistence service
	 */
	protected abstract AbstractService<E> getService();
	
	public ResultWrapper<E> createGeneric(E entity) {
		LOG.debug("************ FrontendService create for " + getService().getClass().getSimpleName());
		
		E interalEntity = getService().create(entity);
		
		ResultWrapper<E> result = new ResultWrapper<E>();
		result.setResult(interalEntity);
		result.setResultState(ResultValidator.savedResultExists(interalEntity));
		return result;
	}
	
	//Update
	@POST
	public ResultStateWrapper updateGeneric(E entity) {
		E interalEntity = getService().update(entity);
		return ResultValidator.savedResultExists(interalEntity);
	}

	/**
	 * returns a flat entity with NO associated entities
	 * 
	 * @param id
	 * @return
	 */
	@Path("/{entityId}")
	@GET
	public ResultWrapper<E> getById(@PathParam("entityId") Long id) {
		E entity = getService().findById(id);
		ResultWrapper<E> rw = new ResultWrapper<E>(entity);
		return rw;
	}
	

	
	//Delete
	@Path("/{entityId}")
	@DELETE
	public ResultStateWrapper delete(@PathParam("entityId") Long id) {
		
		ResultStateWrapper resultState = new ResultStateWrapper();
		
		try {
			getService().delete(id);
			resultState.setState(ResultState.OK);
			resultState.setMessage("Der Eintrag wurde gelöscht.");
		} catch (EntityNotFoundException e) {
			resultState.setState(ResultState.NOT_DELETE);
			resultState.setMessage("Der Eintrag konnte nicht gelöscht werden. " + e.getMessage());
		}

		
		return resultState;
	}
	
	@Path("/all")
	@GET
	public ListResultWrapper<E> getAllNews() {
		List<E> packingPieces = getService().findAll();
		ListResultWrapper<E> resultWrapper = new ListResultWrapper<E>(packingPieces);
		ResultStateWrapper resultStateWrapper = ResultValidator.isNotEmpty(resultWrapper.getResult());
		resultWrapper.setResultState(resultStateWrapper);
		return resultWrapper;
	}
}
