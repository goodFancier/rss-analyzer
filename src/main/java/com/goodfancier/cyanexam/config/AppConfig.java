package com.goodfancier.cyanexam.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource(value = "file:configuration.properties", ignoreResourceNotFound = true)
@RequiredArgsConstructor
public class AppConfig {
		private final Environment env;

		public String getProperty(String propertyKey) {
				return env.getProperty(propertyKey);
		}
}
