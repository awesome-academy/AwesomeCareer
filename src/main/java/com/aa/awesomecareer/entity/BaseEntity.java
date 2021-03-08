package com.aa.awesomecareer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity {
	@Column(name = "updated_at")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date updatedAt;
	@Column(name = "created_at")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
//	@PrePersist
//    public void prePersist() {
//        DateTime now = DateTime.now();
//        this.creationTime = now;
//        this.modificationTime = now;
//    }
// 
//    @PreUpdate
//    public void preUpdate() {
//        this.modificationTime = DateTime.now();
//    }


}
