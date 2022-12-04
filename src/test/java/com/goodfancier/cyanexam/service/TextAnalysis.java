package com.goodfancier.cyanexam.service;

import com.goodfancier.cyanexam.base.AbstractIntegrationTest;
import com.goodfancier.cyanexam.utils.TextUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TextAnalysis extends AbstractIntegrationTest
{
		@Autowired
		private TextUtils textUtils;

		private static Stream<Arguments> testTextData() {
				return Stream.of(
					Arguments.of("North Carolina Power Outages May Stem From Criminal Act, Officials Say", List.of("North", "Carolina", "Power", "Outages", "May", "Stem", "From", "Criminal Act", "Officials",  "Say")),
					Arguments.of("Judge Weighs Legality of Arkansas Ban on Care for Transgender Youth - The New York Times", List.of("Judge", "Weighs", "Legality", "Care"))
					);
		}

		@ParameterizedTest
		@MethodSource("testTextData")
		public void testGetUniqueWordsFromText(String text, List<String> words) {
				assertThat(textUtils.getUniqueWordsFromText(text)).containsAnyElementsOf(words);
		}
}
