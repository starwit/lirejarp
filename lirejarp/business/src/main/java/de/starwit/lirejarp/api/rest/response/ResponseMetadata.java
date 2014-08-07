package de.starwit.lirejarp.api.rest.response;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ResponseMetadata {

	private ResponseCode responseCode;
	
	private String message = "Es sind keine Fehler aufgetreten.";
	
	private Map<String, String> violations;
	
	public Map<String, String> getViolations() {
		return violations;
	}

	public void setViolations(Map<String, String> violations) {
		this.violations = violations;
	}

	public ResponseMetadata() {
	}

	public ResponseMetadata(ResponseCode responseCode, String message) {
		this.responseCode = responseCode;
		this.message = message;
	}
	
	public ResponseMetadata(ResponseCode responseCode, String message, Map<String, String> violations) {
		this(responseCode, message);
		this.violations = violations;
	}
	
	public void setResponseCode(ResponseCode responseCode) {
		this.responseCode = responseCode;
	}
	
	public ResponseCode getResponseCode() {
		return responseCode;
	}
	
	public String getMsgCode() {
		return this.responseCode.getMsgCode();
	}
	
	public void setMsgCode(String msgCode) {
		this.responseCode = ResponseCode.ERROR;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
