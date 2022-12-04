package com.goodfancier.cyanexam.repository;

import com.goodfancier.cyanexam.entity.Topic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends CrudRepository<Topic, String>
{
}
