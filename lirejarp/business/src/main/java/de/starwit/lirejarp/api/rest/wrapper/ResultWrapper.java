package de.starwit.lirejarp.api.rest.wrapper;

import javax.xml.bind.annotation.XmlRootElement;

import de.starwit.lirejarp.api.rest.validation.ResultStateWrapper;
import de.starwit.lirejarp.api.rest.validation.ResultValidator;
import de.starwit.smartpsv.entity.AbstractEntity;

@XmlRootElement
public class ResultWrapper<E extends AbstractEntity> {
	
	private E result;
	
	private ResultStateWrapper resultState;
	
	public ResultWrapper() {
		//default constructor
	}
	
	public ResultWrapper(E result) {
		this.resultState = ResultValidator.found(result);
		this.result = result;
	}
	
//	@JsonIgnoreProperties({ "scanEvents", "packingPieces"})
	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}

	public ResultStateWrapper getResultState() {
		return resultState;
	}

	public void setResultState(ResultStateWrapper resultState) {
		this.resultState = resultState;
	}	
	
}
