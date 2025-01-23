package org.jsp.libraryManagement.Exception;

public class IdNotFoundException extends RuntimeException {

	@Override
	public String getMessage() {
		return "id not found";
	}
}
