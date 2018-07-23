package com.zoya.EventsProject.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="messages")
public class Message {
	
	@Id 
	@GeneratedValue
	private Long id;
	
	@Size(min=2,max=25)
	private String comment;
	
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
	private User viewer;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="event_id")
	private MyEvent event;
	
	public Message() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getViewer() {
		return viewer;
	}

	public void setViewer(User viewer) {
		this.viewer = viewer;
	}

	public MyEvent getEvent() {
		return event;
	}

	public void setEvent(MyEvent event) {
		this.event = event;
	}
	
	@PrePersist
	protected void onCreate() {
		this.setCreatedAt(new Date());
		this.setUpdatedAt(new Date());
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.setUpdatedAt(new Date());
	}
	
	
}
