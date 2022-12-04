package com.goodfancier.cyanexam.data.exception;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RssAnalysisException extends RuntimeException
{
		private int code;

		public RssAnalysisException(String messageText, int code) {
				super(messageText);
				this.code = code;
		}
}
