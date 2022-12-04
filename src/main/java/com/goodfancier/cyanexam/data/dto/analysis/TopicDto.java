package com.goodfancier.cyanexam.data.dto.analysis;

import com.goodfancier.cyanexam.entity.TopicEntry;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TopicDto
{
		private String tag;

		private List<TopicEntryDto> topicEntries;
}
