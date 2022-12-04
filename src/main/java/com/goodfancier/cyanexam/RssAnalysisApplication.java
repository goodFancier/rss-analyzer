package com.goodfancier.cyanexam;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RssAnalysisApplication
{
		public static void main(String[] args)
		{
				SpringApplication.run(RssAnalysisApplication.class, args);
		}

		@Bean
		public RestTemplate restTemplate() {
				return new RestTemplate();
		}
}
