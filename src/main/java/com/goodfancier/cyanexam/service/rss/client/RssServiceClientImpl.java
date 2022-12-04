package com.goodfancier.cyanexam.service.rss.client;

import com.goodfancier.cyanexam.data.dto.FeedResponse;
import com.goodfancier.cyanexam.data.dto.RssResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.Optional;


@Slf4j
@Service
@RequiredArgsConstructor
public class RssServiceClientImpl implements RssServiceClient
{
		private final RestTemplate restTemplate;

		@Override
		public Optional<FeedResponse> fetchRssFeed(String rssUrls)
		{
				log.debug("Start - fetchRssFeed: request = {}", rssUrls);
				Optional<FeedResponse> result = Optional.empty();
				try
				{
						var response = restTemplate.getForObject(rssUrls, RssResponse.class);
						if(response != null)
								result = Optional.of(FeedResponse.builder().rss(response).build());
				}
				catch(RestClientException clientException)
				{
						log.error("Error - fetchRssFeed: error = {}", clientException.getMessage(), clientException);
				}
				log.debug("End - fetchRssFeed: result = {}", result);
				return result;
		}
}
