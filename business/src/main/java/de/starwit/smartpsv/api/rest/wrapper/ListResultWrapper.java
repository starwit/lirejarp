package de.starwit.smartpsv.api.rest.wrapper;

import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import de.starwit.smartpsv.api.rest.validation.ResultStateWrapper;
import de.starwit.smartpsv.entity.AbstractEntity;

@XmlRootElement
public class ListResultWrapper<E extends AbstractEntity> {
	
	private Collection<E> result;
	
	private ResultStateWrapper resultState;
	
	private int amount = 0;
	
	public ListResultWrapper() {
		//default constructor
	}
	
	public ListResultWrapper(Collection<E> result) {
		this.resultState = new ResultStateWrapper();
		this.result = result;
		if (result != null) {
			this.amount = result.size();
		}
	}

//	@JsonIgnoreProperties({ "shipment","container"})
	public Collection<E> getResult() {
		return result;
	}

	public void setResult(Collection<E> result) {
		this.result = result;
	}

	public ResultStateWrapper getResultState() {
		return resultState;
	}

	public void setResultState(ResultStateWrapper resultState) {
		this.resultState = resultState;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
