package com.aa.awesomecareer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "storyhashtag")
public class StoryHashtag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "storyId")
	private Integer storyId;
	@Column(name = "hashtagId")
	private Integer hashtagId;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Story story;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Hashtag hashtag;


}
