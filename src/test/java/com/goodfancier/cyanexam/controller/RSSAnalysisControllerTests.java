package com.goodfancier.cyanexam.controller;

import com.goodfancier.cyanexam.base.AbstractIntegrationTest;
import com.goodfancier.cyanexam.data.constant.UrlConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.goodfancier.cyanexam.utils.TestData.getClientHeaders;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

public class RSSAnalysisControllerTests extends AbstractIntegrationTest
{
		@MockBean
		private TestRestTemplate restTemplate;

		@Test
		void setAnalyzeRssFeeds()
		{
				List<String> rssUrls = new ArrayList<>()
				{{
						add("https://news.google.com/rss?cf=all&hl=en-US&pz=1&gl=US&ceid=US:en");
						add("https://news.google.com/rss?cf=all&hl=en-US&pz=1&gl=US&ceid=US:en");
				}};
				var responseEntity = new ResponseEntity<>("", HttpStatus.OK);
				var httpEntity = new HttpEntity<>(rssUrls, getClientHeaders());
				given(restTemplate.exchange(UrlConstants.ANALYSE_NEW, HttpMethod.POST, httpEntity, String.class)).willReturn(responseEntity);
				var response = restTemplate.exchange(UrlConstants.ANALYSE_NEW, HttpMethod.POST, httpEntity, String.class);
				assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
				assertThat(response.getBody()).isNotNull();
		}
}
