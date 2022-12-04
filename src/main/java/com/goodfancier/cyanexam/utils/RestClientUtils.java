package com.goodfancier.cyanexam.utils;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.util.List;

public class RestClientUtils {
		public static HttpHeaders createContentTypeHeaders() {
				var headers = createHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
		}

		public static HttpHeaders createHeaders() {
				var headers = new HttpHeaders();
				headers.setAccept(List.of(MediaType.APPLICATION_JSON));
				return headers;
		}
}
