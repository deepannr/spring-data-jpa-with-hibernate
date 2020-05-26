package com.spring.boot.jpa.association.manytomany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mm_project")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@ManyToMany(mappedBy = "projects")
	private Set<Programmer> programmers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Programmer> getProgrammers() {
		return programmers;
	}

	public void setProgrammers(Set<Programmer> programmers) {
		this.programmers = programmers;
	}
}
