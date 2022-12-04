package com.goodfancier.cyanexam.repository;

import com.goodfancier.cyanexam.entity.RssAnalysis;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RssRepository extends CrudRepository<RssAnalysis, String>
{
}
