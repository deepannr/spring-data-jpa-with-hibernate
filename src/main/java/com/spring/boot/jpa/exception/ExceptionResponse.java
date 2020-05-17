package com.spring.boot.jpa.exception;

public class ExceptionResponse {

	private String httpStatusCode;
	private String errorMessage;
	private String url;
	private String trace;

	public ExceptionResponse(String code, String ex, String url, String trace) {
		this.setHttpStatusCode(code);
		this.setErrorMessage(ex);
		this.setUrl(url);
		this.setTrace(trace);
	}

	public String getHttpStatusCode() {
		return httpStatusCode;
	}

	public void setHttpStatusCode(String httpStatusCode) {
		this.httpStatusCode = httpStatusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTrace() {
		return trace;
	}

	public void setTrace(String trace) {
		this.trace = trace;
	}
}