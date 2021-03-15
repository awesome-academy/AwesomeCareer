package com.aa.awesomecareer.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.aa.awesomecareer.entity.Activation;
import com.aa.awesomecareer.entity.Application;
import com.aa.awesomecareer.entity.AuthProvider;
import com.aa.awesomecareer.entity.Bookmark;
import com.aa.awesomecareer.entity.Certificate;
import com.aa.awesomecareer.entity.Education;
import com.aa.awesomecareer.entity.Favorite;
import com.aa.awesomecareer.entity.Follow;
import com.aa.awesomecareer.entity.Interest;
import com.aa.awesomecareer.entity.Language;
import com.aa.awesomecareer.entity.Profile;
import com.aa.awesomecareer.entity.Project;
import com.aa.awesomecareer.entity.Voting;
import com.aa.awesomecareer.util.validator.FieldMatch;
import com.aa.awesomecareer.util.validator.NullOrNotBlank;
import com.aa.awesomecareer.util.validator.UniqueEmail;

//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@UniqueEmail(name = "email", message = "{user.validation.email.exist}")
@FieldMatch(first = "password", second = "confirmation", message = "{user.validation.password.notmatch}")
public class UserModel extends BaseModel {
	
	private Integer id;
	@NotNull
	@NotEmpty
	private String fullName;
	@NotNull
	@NotEmpty
	private String email;
	@NotNull
	@NotEmpty
	private String password;
	@NotNull
	@NotEmpty
	private String company;
	@NotNull
	@NotEmpty
	private String occupationInterest;
	@NotNull
	@NotEmpty
	private String country;
	
	private String userName;
	private String seftIntroduction;
	private String ambition;
	private String links;
	private String goodAt;
	private String resume;
	private String interest;
	private String gender;
	private Date birthday;
	private String relationshipStatus;
	private boolean amAParent;
	private String image;
	
//	private List<ApplicationModel> applicationModels;
//	private List<BookmarkModel> bookmarkModels;
//	private List<FavoriteModel> favoriteModels;
//	private List<VotingModel> votingModels;
//	private List<FollowModel> followModels;
//	private List<InterestModel> interestModels;
//	private List<LanguageModel> languageModels;
//	private List<CertificateModel> certificateModels;
//	private List<EducationModel> educationModels;
//	private List<ProjectModel> projectModels;
//	private List<ProfileInfoModel> profileInfoModels;

}