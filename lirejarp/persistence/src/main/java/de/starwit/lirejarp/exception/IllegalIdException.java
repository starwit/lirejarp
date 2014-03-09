package de.starwit.lirejarp.exception;

public class IllegalIdException extends Exception {

	private static final long serialVersionUID = -9172551625808158421L;
	
	private String className;

	public IllegalIdException(String className) {
		this.className = className;
	}
	
	@Override
	public String getMessage() {
		String notFound = "Illegal ID for Entity " + className + ". ";
		return notFound;
	}

}