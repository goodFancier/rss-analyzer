package com.goodfancier.cyanexam.controller;

import com.goodfancier.cyanexam.data.dto.analysis.TopicDto;
import com.goodfancier.cyanexam.service.rss.RssService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.goodfancier.cyanexam.data.constant.UrlConstants.ANALYSE_NEW;
import static com.goodfancier.cyanexam.data.constant.UrlConstants.FREQUENCY_BY_ID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class RSSAnalysisController
{
		private final RssService rssService;

		@PostMapping(path = ANALYSE_NEW, consumes = MediaType.APPLICATION_JSON_VALUE)
		@Operation(summary = "Get the hot topics from rss urls",
			requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(schema = @Schema(implementation = List.class))))
		@ApiResponses({@ApiResponse(responseCode = "200",
			description = "Analysis of the rss url has been started",
			content = {@Content(mediaType = "text/plain")}),
			@ApiResponse(responseCode = "800", description = "The list of RSS URLs less than 2")})
		public ResponseEntity<?> analyzeRssFeeds(@RequestBody List<String> rssUrls)
		{
				return new ResponseEntity<>(rssService.analyseRssUrls(rssUrls), HttpStatus.OK);
		}

		@GetMapping(value = FREQUENCY_BY_ID,
			produces = MediaType.APPLICATION_JSON_VALUE)
		@Operation(summary = "Get analysis result by analysis id")
		@ApiResponses({
			@ApiResponse(responseCode = "200",
				description = "get the hottest topics from news",
				content = {@Content(mediaType = "application/json", schema = @Schema(implementation = List.class))}),
			@ApiResponse(responseCode = "801", description = "RSS Analysis not found")
		})
		public ResponseEntity<List<TopicDto>> getFrequency(@PathVariable("id") String analysisId) {
				return new ResponseEntity<>(rssService.getTopics(analysisId), HttpStatus.OK);
		}
}
