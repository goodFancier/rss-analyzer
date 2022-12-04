package com.goodfancier.cyanexam.service.analyse;

import com.goodfancier.cyanexam.config.AppConfig;
import com.goodfancier.cyanexam.data.dto.ItemResponse;
import com.goodfancier.cyanexam.entity.RssAnalysis;
import com.goodfancier.cyanexam.repository.TopicRepository;
import com.goodfancier.cyanexam.repository.TopicEntryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AnalysisServiceImpl implements AnalysisService
{
		private final TopicRepository topicRepository;

		private final TopicEntryRepository topicEntryRepository;

		private final TopicAnalyzerService topicAnalyzerService;

		private final AppConfig appConfig;

		@Override
		public void analyseFeed(RssAnalysis rss, List<ItemResponse> items)
		{
				var theHottestTopics = topicAnalyzerService.getTheHottestTopics(items, Integer.parseInt(appConfig.getProperty("app.hottest-items-count")));
				for(var hottestTopic : theHottestTopics)
				{
						hottestTopic.setRss(rss);
						topicRepository.save(hottestTopic);
						for (var topicEntry : hottestTopic.getTopicEntries())
						{
								topicEntry.setTopic(hottestTopic);
								topicEntryRepository.save(topicEntry);
						}
				}
		}
}
