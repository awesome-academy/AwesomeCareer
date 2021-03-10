package com.aa.awesomecareer.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoryModel {
	private Integer id;
	private Integer userId;
	private String content;
	private String image;
	
	private UserModel userModel;
	List<FavoriteModel> favoriteModels;
	List<StoryHashtagModel> storyHashtagModels;
}
