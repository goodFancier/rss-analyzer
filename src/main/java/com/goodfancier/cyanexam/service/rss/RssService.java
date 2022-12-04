package com.goodfancier.cyanexam.service.rss;

import com.goodfancier.cyanexam.data.dto.analysis.TopicDto;
import com.goodfancier.cyanexam.data.exception.RssAnalysisException;

import java.util.List;

public interface RssService
{
		String analyseRssUrls(List<String> rssUrls) throws RssAnalysisException;

		List<TopicDto> getTopics(String rrsAnalysisId);
}
