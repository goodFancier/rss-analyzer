package com.goodfancier.cyanexam.service.rss.client;

import com.goodfancier.cyanexam.data.dto.FeedResponse;
import java.util.Optional;

public interface RssServiceClient
{
		Optional<FeedResponse> fetchRssFeed(String rssUrls);
}
