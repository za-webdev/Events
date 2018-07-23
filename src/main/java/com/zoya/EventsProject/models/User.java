package com.zoya.EventsProject.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;



@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=3)
	private String firstName;
	
	@Size(min=3)
	private String lastName;
	
	@Size(min=3)
	private String location;
	
	
	private String email;
	
	@Size(min=8)
	private String password;
	
	@Transient
	private String confirm;
	
	private  Date createdAt;
	private  Date updatedAt;
	
	private String adminLevel;
	
	@OneToMany(mappedBy="uploader", fetch = FetchType.LAZY)
    private List<MyEvent> my_events;
	
	@OneToMany(mappedBy="viewer", fetch = FetchType.LAZY)
    private List<Message> messages;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "user_joining_events", 
        joinColumns = @JoinColumn(name = "user_id"), 
        inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<MyEvent> joinedEvents ;

	public User() {
		
	}
	
	public User(String firstName,String lastName,String email,String location,String adminLevel, String password) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.location=location;
		this.email=email;
		this.password=password;
		this.adminLevel=adminLevel;
		this.createdAt=new Date();
		this.updatedAt=new Date();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
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

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
	
	
	
	public String getAdminLevel() {
		return adminLevel;
	}

	public void setAdminLevel(String adminLevel) {
		this.adminLevel = adminLevel;
	}

	public List<MyEvent> getMy_events() {
		return my_events;
	}

	public void setMy_events(List<MyEvent> my_events) {
		this.my_events = my_events;
	}
	

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}
	
	
	
	public List<MyEvent> getJoinedEvents() {
		return joinedEvents;
	}

	public void setJoinedEvents(List<MyEvent> joinedEvents) {
		this.joinedEvents = joinedEvents;
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

