package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoryHashtagModel {
	
	private Integer id;
	private Integer storyId;
	private Integer hashtagId;
	
	private StoryModel storyModel;
	private HashtagModel hashtagModel;

}
