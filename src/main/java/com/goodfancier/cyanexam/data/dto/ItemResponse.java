package com.goodfancier.cyanexam.data.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ItemResponse
{
		private String title;

		private String link;

		private String description;

		private String author;
}
