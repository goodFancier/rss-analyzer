package com.goodfancier.cyanexam.repository;

import com.goodfancier.cyanexam.entity.TopicEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicEntryRepository extends CrudRepository<TopicEntry, String>
{
}
