package com.task.atipera.exception;

import org.springframework.http.HttpStatusCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class RepositoriesRequestException extends RuntimeException {

	private HttpStatusCode statusCode;
	private String message;

	public RepositoriesRequestException(HttpStatusCode statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
		this.message = message;
	}
}
