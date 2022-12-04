package com.goodfancier.cyanexam.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Builder
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "topic")
public class Topic
{
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private int id;

		private String tag;

		@ManyToOne
		@JoinColumn(name = "rss")
		private RssAnalysis rss;

		@OneToMany(mappedBy = "topic", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
		private List<TopicEntry> topicEntries;
}
