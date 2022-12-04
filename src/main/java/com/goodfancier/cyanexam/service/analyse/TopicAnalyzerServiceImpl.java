package com.goodfancier.cyanexam.service.analyse;

import com.goodfancier.cyanexam.data.dto.ItemResponse;
import com.goodfancier.cyanexam.data.dto.analysis.AnalyzedItemDto;
import com.goodfancier.cyanexam.data.dto.analysis.AnalyzedTopicDto;
import com.goodfancier.cyanexam.entity.Topic;
import com.goodfancier.cyanexam.entity.TopicEntry;
import com.goodfancier.cyanexam.utils.TextUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TopicAnalyzerServiceImpl implements TopicAnalyzerService
{
		private final TextUtils textUtils;

		@Override
		public List<Topic> getTheHottestTopics(List<ItemResponse> itemResponses, int hottestItemsCount)
		{
				List<AnalyzedItemDto> analyzedItems = new ArrayList<>();
				for(var item : itemResponses)
				{
						analyzedItems.add(AnalyzedItemDto.builder()
							.title(item.getTitle())
							.link(item.getLink())
							.words(textUtils.getUniqueWordsFromText(item.getTitle()))
							.build());
				}
				return findHottestTopics(analyzedItems, hottestItemsCount);
		}

		private List<Topic> findHottestTopics(List<AnalyzedItemDto> analyzedItems, int hottestItemsCount)
		{
				Map<String, AnalyzedTopicDto> topics = new HashMap<>();
				analyzedItems.forEach(item -> item.getWords().forEach(word -> {
						topics.putIfAbsent(word, AnalyzedTopicDto.builder().word(word).build());
						topics.get(word).getFeedLinks().add(item.getLink());
						topics.get(word).getItems().add(item);
				}));
				return topics.values().stream()
					.sorted((topic1, topic2) -> topic2.coincidencesCount() - topic1.coincidencesCount())
					.limit(hottestItemsCount)
					.map(hotTopic -> Topic.builder()
						.tag(hotTopic.getWord())
						.topicEntries(hotTopic.getItems()
							.stream()
							.map(item -> TopicEntry.builder()
								.title(item.getTitle())
								.link(item.getLink())
								.build())
							.collect(Collectors.toList()))
						.build())
					.collect(Collectors.toList());
		}
}
