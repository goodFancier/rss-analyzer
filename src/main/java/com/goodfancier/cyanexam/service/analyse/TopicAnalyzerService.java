package com.goodfancier.cyanexam.service.analyse;

import com.goodfancier.cyanexam.data.dto.ItemResponse;
import com.goodfancier.cyanexam.entity.Topic;

import java.util.List;

public interface TopicAnalyzerService
{
		List<Topic> getTheHottestTopics(List<ItemResponse> itemResponses, int hottestItemsCount);
}
