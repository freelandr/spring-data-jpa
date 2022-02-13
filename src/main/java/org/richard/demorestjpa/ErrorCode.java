package org.richard.demorestjpa;

public enum ErrorCode {
	
	CUSTOMER_NOT_FOUND(1001),
	CUSTOMER_ALREADY_EXISTS(1002),
	INTERNAL_ERROR(1099);

	private int code;	
	
	private ErrorCode(int code) {
		this.code = code;
	}
	
	public String toString() {
		return Integer.toString(this.code);
	}
	
}
