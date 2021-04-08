package com.aa.awesomecareer.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")

public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "fullName",length = 256)
	private String fullName;
	
	@Column(name = "email",unique=true, length = 256)
	private String email;
	
	@Column(name = "password",length = 128)
	private String password;
	
	@Column(name = "company",length = 128)
	private String company;
	
	@Column(name = "occupationInterest",length = 256)
	private String occupationInterest;
	
	@Column(name = "country",length = 256)
	private String country;

	@Column(name = "userName",length = 256)
	private String userName;
	
	@Column(name = "seftIntroduction",length = 3000)
	private String seftIntroduction;
	
	@Column(name = "ambition",length = 256)
	private String ambition;
	
	@Column(name = "link",length = 256)
	private String link;
	
	@Column(name = "goodAt",length = 256)
	private String goodAt;
	
	@Column(name = "resume",length = 256)
	private String resume;
	
	@Column(name = "interest",length = 256)
	private String interest;
	
	@Column(name = "gender",length = 3)
	private String gender;
	
	@Column(name = "birthday")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date birthday;
	
	@Column(name = "relationshipStatus",length = 256)
	private String relationshipStatus;
	
//	@Column(name = "imAParent")
//	private boolean imAParent;
	
//	@Column(name = "image", length = 256)
//	private String image;

	@OneToMany( mappedBy = "user")
	private List<Job> jobs;
	
	@OneToMany( mappedBy = "user")
	private List<Application> applications;
	
	@OneToMany(mappedBy = "user")
    private List<Experience> experiences;
	
	@OneToMany(mappedBy = "user")
    private List<SkillUser> skillUsers;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@JoinTable(
			name="skilluser",
			joinColumns = @JoinColumn(name="userId"),
			inverseJoinColumns = @JoinColumn(name="skillId")
			)
    private Set<Skill> skills = new HashSet<>();
	
	
	
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getOccupationInterest() {
		return occupationInterest;
	}

	public void setOccupationInterest(String occupationInterest) {
		this.occupationInterest = occupationInterest;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Experience> getExperiences() {
		return experiences;
	}

	public void setExperiences(List<Experience> experiences) {
		this.experiences = experiences;
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skill> skills) {
		this.skills = skills;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<SkillUser> getSkillUsers() {
		return skillUsers;
	}

	public void setSkillUsers(List<SkillUser> skillUsers) {
		this.skillUsers = skillUsers;
	}

	public String getSeftIntroduction() {
		return seftIntroduction;
	}

	public void setSeftIntroduction(String seftIntroduction) {
		this.seftIntroduction = seftIntroduction;
	}

	public String getAmbition() {
		return ambition;
	}

	public void setAmbition(String ambition) {
		this.ambition = ambition;
	}
	
//	@OneToMany(mappedBy = "application")
//	private List<Application> applications;
//	
//	@OneToMany(mappedBy = "bookmark")
//	private List<Bookmark> bookmarks;
//	
//	@OneToMany(mappedBy = "favorite")
//	private List<Favorite> favorites;
//	
//	@OneToMany(mappedBy = "voting")
//	private List<Voting> votings;
//	
//	@OneToMany(mappedBy = "follow")
//	private List<Follow> follows;
//	
//	@OneToMany(mappedBy = "interest")
//	private List<Interest> interests;
//	
//	@OneToMany(mappedBy = "language")
//	private List<Language> languages;
//	
//	@OneToMany(mappedBy = "certificate")
//	private List<Certificate> certificates;
//	
//	@OneToMany(mappedBy = "education")
//	private List<Education> educations;
//	
//	@OneToMany(mappedBy = "project")
//	private List<Project> projects;
//	
//	@OneToMany(mappedBy = "profile")
//	private List<Profile> profiles;
}
