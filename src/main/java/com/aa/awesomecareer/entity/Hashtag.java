package com.aa.awesomecareer.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "hashtag")
public class Hashtag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "name",length = 256)
	private String name;
	
	@OneToMany(mappedBy = "storyhastag")
	private List<StoryHashtag> storyHashtags;
	

}
