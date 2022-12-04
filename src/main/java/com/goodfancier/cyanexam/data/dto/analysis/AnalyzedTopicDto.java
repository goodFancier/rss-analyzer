package com.goodfancier.cyanexam.data.dto.analysis;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyzedTopicDto
{
		private String word;

		private final Set<String> feedLinks = new HashSet<>();

		private final Set<AnalyzedItemDto> items = new HashSet<>();

		public int coincidencesCount() {
				return feedLinks.size();
		}
}
