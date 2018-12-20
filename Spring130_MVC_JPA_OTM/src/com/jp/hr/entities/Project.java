package com.jp.hr.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="project")
@Table(name="PROJECT")
public class Project {
	private int projectId;
	private String title;
	
	//field for association 
	private Set<Emp> emps;
	
	
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@ManyToMany
	@JoinTable(name="EMP_PROJECT", joinColumns=@JoinColumn(name="projectId"))
	public Set<Emp> getEmps() {
		return emps;
	}

	public void setEmps(Set<Emp> emps) {
		this.emps = emps;
	}

	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", title=" + title + ", emps=" + emps + "]";
	}
	
	
}
