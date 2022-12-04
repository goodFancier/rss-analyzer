package com.goodfancier.cyanexam.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Accessors(chain = true)
@Getter
@Setter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "topic_entry")
public class TopicEntry
{
		@Id
		@GeneratedValue(strategy= GenerationType.IDENTITY)
		private int id;

		@ManyToOne
		@JoinColumn(name = "topic")
		private Topic topic;

		@Column(name = "title", length = 1024)
		private String title;

		@Column(name = "link", length = 1024)
		private String link;
}
