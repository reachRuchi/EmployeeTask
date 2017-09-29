package com.cdlit.employeetask.model;

import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.*;

import javax.persistence.*;
import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;



@SuppressWarnings("serial")
@Entity
@Table(name = "task")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"creationDate"}, allowGetters = true)
public class Task implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "task_id")
	private Long taskId;
	
	@NotBlank
	@Column(name= "task_name")
	private String taskName;
	
	@NotBlank
	@Column(name= "task_description")
	private String taskDescription;
	
	@NotBlank
	@Column(name= "assigned_to")
	private String assignedTo;
	
	@NotBlank
	@Column(name= "assigned_by")
	private String assignedBy;
	
	@Column(nullable = false, updatable = false, name = "creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date creationDate;
	

	@Temporal(TemporalType.DATE)
	private Date completionDate;

	//Getters and Setters
	
	public Long getTaskId() {
		return taskId;
	}

	public void setTaskId(Long taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}

	public String getAssignedBy() {
		return assignedBy;
	}

	public void setAssignedBy(String assignedBy) {
		this.assignedBy = assignedBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	
}
