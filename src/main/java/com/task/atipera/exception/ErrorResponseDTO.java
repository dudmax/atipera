package com.task.atipera.exception;

import org.springframework.http.HttpStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class ErrorResponseDTO {
	private final HttpStatus status;

	private final String message;
}
