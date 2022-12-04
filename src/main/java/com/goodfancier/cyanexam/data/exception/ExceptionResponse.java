package com.goodfancier.cyanexam.data.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse implements Serializable
{
		private static final long serialVersionUID = -8091879095524046847L;

		private int status;
		private String message;
		private LocalDateTime dateTime;
}
