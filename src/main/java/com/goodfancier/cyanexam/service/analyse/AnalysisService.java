package com.goodfancier.cyanexam.service.analyse;

import com.goodfancier.cyanexam.data.dto.ItemResponse;
import com.goodfancier.cyanexam.entity.RssAnalysis;

import java.util.List;

public interface AnalysisService
{
		void analyseFeed(RssAnalysis id, List<ItemResponse> items);
}
