package com.goodfancier.cyanexam.service.rss;

import com.goodfancier.cyanexam.data.dto.ItemResponse;
import com.goodfancier.cyanexam.data.dto.analysis.TopicDto;
import com.goodfancier.cyanexam.data.exception.RssAnalysisException;
import com.goodfancier.cyanexam.data.map.TopicMapper;
import com.goodfancier.cyanexam.entity.RssAnalysis;
import com.goodfancier.cyanexam.entity.Topic;
import com.goodfancier.cyanexam.repository.RssRepository;
import com.goodfancier.cyanexam.service.analyse.AnalysisService;
import com.goodfancier.cyanexam.service.rss.client.RssServiceClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.goodfancier.cyanexam.data.exception.CustomHttpResponseCodes.RSS_ANALYSIS_NOT_FOUND;
import static com.goodfancier.cyanexam.data.exception.CustomHttpResponseCodes.RSS_URLs_SIZE_IS_LESS_THAN_TWO;

@Service
@Slf4j
@RequiredArgsConstructor
public class RssServiceImpl implements RssService
{
		private final RssServiceClient rssServiceClient;

		private final AnalysisService analysisService;

		private final RssRepository rssRepository;

		private final TopicMapper topicMapper;

		@Override
		public String analyseRssUrls(List<String> rssUrls)
		{
				if(rssUrls.size() < 2)
						throw new RssAnalysisException("The list of RSS URLs less than 2", RSS_URLs_SIZE_IS_LESS_THAN_TWO);
				else
				{
						final String uniqueId = UUID.randomUUID().toString();
						var rss = rssRepository.save(RssAnalysis.builder().id(uniqueId).build());
						List<ItemResponse> items = new ArrayList<>();
						for (String url : rssUrls)
						{
								var feed = rssServiceClient.fetchRssFeed(url);
								feed.ifPresent(feedResponse -> items.addAll(feed.get().getRss().getChannel().getItems()));
						}
						analysisService.analyseFeed(rss, items);
						return uniqueId;
				}
		}

		@Override
		public List<TopicDto> getTopics(String rssAnalysisId)
		{
				Optional<RssAnalysis> rssAnalysis = rssRepository.findById(rssAnalysisId);
				if (rssAnalysis.isPresent())
				{
						List<TopicDto> topics = new ArrayList<>();
						for (Topic topic: rssAnalysis.get().getTopics())
								topics.add(topicMapper.toDto(topic));
						return topics;
				}
				else
						throw new RssAnalysisException(String.format("Rss analysis not found by id: %s", rssAnalysisId), RSS_ANALYSIS_NOT_FOUND);
		}
}
