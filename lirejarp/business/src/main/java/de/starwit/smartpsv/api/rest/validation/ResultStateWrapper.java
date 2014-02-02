package de.starwit.smartpsv.api.rest.validation;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResultStateWrapper {

	private ResultState state;
	
	private String message = "Es sind keine Fehler aufgetreten.";

	public void setState(ResultState state) {
		this.state = state;
	}
	
	public ResultState getState() {
		return state;
	}
	
	public String getMsgCode() {
		return this.state.getMsgCode();
	}
	
	public void setMsgCode(String msgCode) {
		//should not happen, TODO
		this.state = ResultState.ERROR;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
