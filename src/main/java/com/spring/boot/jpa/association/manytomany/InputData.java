package com.spring.boot.jpa.association.manytomany;

import java.util.List;

public class InputData {
	private String programmerName;
	
	private int programmerSalary;
	
	private List<String> projectNames;

	public String getProgrammerName() {
		return programmerName;
	}

	public void setProgrammerName(String programmerName) {
		this.programmerName = programmerName;
	}

	public int getProgrammerSalary() {
		return programmerSalary;
	}

	public void setProgrammerSalary(int programmerSalary) {
		this.programmerSalary = programmerSalary;
	}

	public List<String> getProjectNames() {
		return projectNames;
	}

	public void setProjectNames(List<String> projectNames) {
		this.projectNames = projectNames;
	}
}
