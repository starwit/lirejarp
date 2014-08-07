package de.starwit.lirejarp.api.rest.response;

import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response<E> {
	
	private E result;
	
	private ResponseMetadata metadata;
	
	public Response() {
		//default constructor
	}
	
	public Response(E result) {
		this.result = result;
	}
	
//	@JsonIgnoreProperties({ "scanEvents", "packingPieces"})
	public E getResult() {
		return result;
	}

	public void setResult(E result) {
		this.result = result;
	}

	public ResponseMetadata getMetadata() {
		return metadata;
	}

	public void setMetadata(ResponseMetadata metadata) {
		this.metadata = metadata;
	}	
	
	public void setMetadata(ResponseCode responseCode, String message) {
		if (this.metadata == null) {
			this.metadata = new ResponseMetadata(responseCode, message);
		} else {
			this.metadata.setResponseCode(responseCode);
			this.metadata.setMessage(message);
		}
	}	
	
	public void setMetadata(ResponseCode responseCode, String message, Map<String, String> violations) {
		if (this.metadata == null) {
			this.metadata = new ResponseMetadata(responseCode, message, violations);
		} else {
			this.metadata.setResponseCode(responseCode);
			this.metadata.setMessage(message);
			this.metadata.setViolations(violations);
		}
	}	
	
}
