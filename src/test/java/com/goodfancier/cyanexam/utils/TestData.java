package com.goodfancier.cyanexam.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

public class TestData
{
		public static HttpHeaders getClientHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
		}
}

