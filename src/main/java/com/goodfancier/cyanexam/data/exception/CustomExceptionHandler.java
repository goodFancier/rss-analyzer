package com.goodfancier.cyanexam.data.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler
{
		@ExceptionHandler({RssAnalysisException.class})
		public final ResponseEntity<Object> handleRestServerException(Exception ex) {
				ExceptionResponse error = new ExceptionResponse(
					((RssAnalysisException) ex).getCode(),
					ex.getMessage(),
					LocalDateTime.now());
				return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
}
