package com.aa.awesomecareer.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "user")
public class User extends BaseEntity implements Serializable {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Integer id;
	@Column(name = "name", length = 256)
	private String name;
	@Column(name = "email", unique = true, length = 256)
	private String email;
	@Column(name = "password", length = 256)
	private String password;
	@Column(name = "series", length = 256)
	private String series;
	@Column(name = "token", length = 256)
	private String token;
	@Column(name = "last_used")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date lastUsed;
	@Column(name = "role")
	private Integer role;
	@Column(name = "activation_digest", length = 256)
	private String activationDigest;
	@Column(name = "activated")
	private Integer activated;
	@Column(name = "activated_at")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date activatedAt;
	@Column(name = "provider")
	@Enumerated(EnumType.STRING)
	private AuthProvider provider;
	@Column(name = "provider_id", length = 256)
	private String providerId;
	@Column(name = "reset_digest", length = 256)
	private String resetDigest;
	@Column(name = "reset_sent_at")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date resetSentAt;

	public User() {

	}

	public User(Integer id) {
		this.id = id;
	}

	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLastUsed() {
		return lastUsed;
	}

	public void setLastUsed(Date lastUsed) {
		this.lastUsed = lastUsed;
	}

	public Integer getRole() {
		return role;
	}

	public List<Role> getRoles() {
		return Role.toList(role);
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public void setRoles(List<Role> roles) {
		this.role = Role.toValue(roles);
	}

	public String getActivationDigest() {
		return activationDigest;
	}

	public void setActivationDigest(String activationDigest) {
		this.activationDigest = activationDigest;
	}

	public Integer getActivated() {
		return activated;
	}

	public boolean activated() {
		return activated == Activation.ACTIVATED.value;
	}

	public void setActivated(Integer activated) {
		this.activated = activated;
	}

	public void activate() {
		this.activated = Activation.ACTIVATED.value;
	}

	public void unactivate() {
		this.activated = Activation.UNACTIVATED.value;
	}

	public Date getActivatedAt() {
		return activatedAt;
	}

	public void setActivatedAt(Date activatedAt) {
		this.activatedAt = activatedAt;
	}

	public String getResetDigest() {
		return resetDigest;
	}

	public void setResetDigest(String resetDigest) {
		this.resetDigest = resetDigest;
	}

	public Date getResetSentAt() {
		return resetSentAt;
	}

	public void setResetSentAt(Date resetSentAt) {
		this.resetSentAt = resetSentAt;
	}

	public AuthProvider getProvider() {
		return provider;
	}

	public void setProvider(AuthProvider provider) {
		this.provider = provider;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

}
