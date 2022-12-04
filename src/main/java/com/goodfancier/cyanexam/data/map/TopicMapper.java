package com.goodfancier.cyanexam.data.map;

import com.goodfancier.cyanexam.data.dto.analysis.TopicDto;
import com.goodfancier.cyanexam.entity.Topic;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper( componentModel = "spring",
	unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TopicMapper extends AbstractMapper<Topic, TopicDto> {

}
