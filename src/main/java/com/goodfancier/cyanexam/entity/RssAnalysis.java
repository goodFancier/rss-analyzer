package com.goodfancier.cyanexam.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Accessors(chain = true)
@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "rss_analysis")
public class RssAnalysis
{
		@Id
		private String id;

		@OneToMany(mappedBy = "rss", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
		private List<Topic> topics;
}
