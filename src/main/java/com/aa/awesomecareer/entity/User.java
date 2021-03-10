package com.aa.awesomecareer.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "fullName",length = 256)
	private String fullName;
	
	@Column(name = "email",unique=true, length = 256)
	private String email;
	
	@Column(name = "password",length = 256)
	private String password;
	
	@Column(name = "company",length = 256)
	private String company;
	
	@Column(name = "occupationInterest",length = 256)
	private String occupationInterest;
	
	@Column(name = "country",length = 256)
	private String country;

	
	@Column(name = "userName",length = 256)
	private String userName;
	
	@Column(name = "seftIntroduction",length = 3000)
	private String seftIntroduction;
	
	@Column(name = "ambition",length = 3000)
	private String ambition;
	
	@Column(name = "links",length = 256)
	private String links;
	
	@Column(name = "goodAt",length = 3000)
	private String goodAt;
	
	@Column(name = "resume",length = 3000)
	private String resume;
	
	@Column(name = "interest",length = 3000)
	private String interest;
	
	@Column(name = "gender",length = 256)
	private String gender;
	
	@Column(name = "birthday")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date birthday;
	
	@Column(name = "relationshipStatus",length = 256)
	private String relationshipStatus;
	
	@Column(name = "amAParent")
	private boolean amAParent;
	
	@Column(name = "image")
	private String image;
	
	@OneToMany(mappedBy = "application")
	private List<Application> applications;
	
	@OneToMany(mappedBy = "bookmark")
	private List<Bookmark> bookmarks;
	
	@OneToMany(mappedBy = "favorite")
	private List<Favorite> favorites;
	
	@OneToMany(mappedBy = "voting")
	private List<Voting> votings;
	
	@OneToMany(mappedBy = "follow")
	private List<Follow> follows;
	
	@OneToMany(mappedBy = "interest")
	private List<Interest> interests;
	
	@OneToMany(mappedBy = "language")
	private List<Language> languages;
	
	@OneToMany(mappedBy = "certificate")
	private List<Certificate> certificates;
	
	@OneToMany(mappedBy = "education")
	private List<Education> educations;
	
	@OneToMany(mappedBy = "project")
	private List<Project> projects;
	
	@OneToMany(mappedBy = "projectinfo")
	private List<Profile> profileInfos;

}
