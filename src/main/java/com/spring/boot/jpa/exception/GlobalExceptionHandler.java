package com.spring.boot.jpa.exception;

import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.boot.jpa.util.ExceptionUtils;
import com.spring.boot.jpa.util.StringUtils;


@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler({ InvalidInputException.class, BadApiRequestException.class })
	public ExceptionResponse handleInvalidInputException(HttpServletRequest req, Exception ex) {
		return getExceptionResponse(HttpStatus.BAD_REQUEST.getReasonPhrase(), "", ex, req);
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ExceptionHandler({ UserNotFoundException.class, ResourceNotFoundException.class })
	public ExceptionResponse handleResultNotFoundException(HttpServletRequest req, Exception ex) {
		return getExceptionResponse(HttpStatus.NOT_FOUND.getReasonPhrase(), "", ex, req);
	}

	@ResponseBody
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
			HttpStatus status, WebRequest req) {
		String errorMsg = ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()).toString();
		return new ResponseEntity<Object>(errorMsg, status);
	}

	public ExceptionResponse getExceptionResponse(String statusCode, String msg, Exception ex, HttpServletRequest req) {
		return new ExceptionResponse(statusCode, msg + StringUtils.defaultString(ex.getMessage()),
				req.getRequestURL().toString(), ExceptionUtils.getStackTrace(ex));
	}
}