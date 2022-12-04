package com.goodfancier.cyanexam.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedListResponse
{
		List<FeedResponse> feedResponseList;
}
