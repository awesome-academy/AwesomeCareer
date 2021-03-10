package com.aa.awesomecareer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteModel {
	private Integer id;
	private Integer userId;
	private Integer storyId;
	private UserModel userModel;
	private StoryModel storyModel;

}
