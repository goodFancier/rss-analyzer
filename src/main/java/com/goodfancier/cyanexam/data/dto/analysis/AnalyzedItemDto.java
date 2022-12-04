package com.goodfancier.cyanexam.data.dto.analysis;

import lombok.*;

import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AnalyzedItemDto
{
		@EqualsAndHashCode.Include
		private String title;

		@EqualsAndHashCode.Include
		private String link;

		private Set<String> words;
}
