package com.goodfancier.cyanexam.utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
@Slf4j
public class TextUtils
{
		//TODO: Use the Apache OpenNLP (https://www.baeldung.com/apache-open-nlp) instead of own algorithm (Nikitin_AA 04.12.2022)
		// Also analysis need to support different languages
		private final List<String> exceptionWords = new ArrayList<>()
		{{
				addAll(List.of(".", ",", "for", "the", "a", "an", "if", "be", "he", "she", "it", "we", "I", "me", "-", "_", "in", "of", "at", "on", "to", "is", "What", "as", "with", "and"));
		}};

		public Set<String> getUniqueWordsFromText(String text)
		{
				Set<String> uniqueWords = new HashSet<>();
				for (var word : text.split(" "))
				{
						if (exceptionWords.stream().noneMatch(word::equalsIgnoreCase))
								uniqueWords.add(word);
				}
				return uniqueWords;
		}
}
