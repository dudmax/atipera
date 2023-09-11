package com.task.atipera.exception;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class RequestExceptionCustomHandler{

	@ExceptionHandler(RepositoriesRequestException.class)
	public ResponseEntity handleException(
			RepositoriesRequestException e) {

		ErrorResponseDTO error = new ErrorResponseDTO(HttpStatus.NOT_FOUND, e.getLocalizedMessage());
		return new ResponseEntity<>(error, error.getStatus());
	}

//	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
//	public ResponseEntity handleException(
//			HttpMediaTypeNotAcceptableException e) {
//
//		ErrorResponseDTO error = new ErrorResponseDTO(HttpStatus.NOT_ACCEPTABLE, e + "Acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE);
//		return new ResponseEntity<>(error, error.getStatus());
//	}

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	public String handleHttpMediaTypeNotAcceptableException() {
		ErrorResponseDTO error = new ErrorResponseDTO(HttpStatus.NOT_ACCEPTABLE, "Acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE);
		JSONObject jsonObject = new JSONObject(error);
//		jsonObject.put("status", HttpStatus.NOT_ACCEPTABLE);
//		jsonObject.put("message", "Acceptable MIME type:" + MediaType.APPLICATION_JSON_VALUE);
		return jsonObject.toString();
	}

}
