package de.starwit.lirejarp.api.rest.wrapper;

import java.util.Collection;

import de.starwit.lirejarp.api.rest.validation.ResultStateWrapper;
import de.starwit.lirejarp.api.rest.validation.ResultValidator;
import de.starwit.smartpsv.entity.AbstractEntity;

/**
 * This wrapper is used to get an entity with has a oneToMany relation. 
 * The resultList of that collection is saved as children.
 * 
 * @author Anett
 *
 * @param <E> parent entity
 * @param <T> children
 */
public class ResultChildrenWrapper<E extends AbstractEntity, T extends AbstractEntity> {

	private E result;
	
	private Collection<T> children;
	
	private ResultStateWrapper resultState;
	
	private int amountOfChildren = 0;
	
	public ResultChildrenWrapper() {
		//default constructor
	}
	
	public ResultChildrenWrapper(E result, Collection<T> children) {
		this.result = result;
		this.children = children;
		this.resultState = ResultValidator.isNotEmpty(result, children);
	}

	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}

	public Collection<T> getChildren() {
		return children;
	}

	public void setChildren(Collection<T> children) {
		this.children = children;
	}

	public ResultStateWrapper getResultState() {
		return resultState;
	}

	public void setResultState(ResultStateWrapper resultState) {
		this.resultState = resultState;
	}

	public int getAmountOfChildren() {
		return amountOfChildren;
	}

	public void setAmountOfChildren(int amountOfChildren) {
		this.amountOfChildren = amountOfChildren;
	}

}
