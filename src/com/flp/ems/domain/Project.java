package com.flp.ems.domain;

public class Project {

	int project_id;
	String name;

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDesc_id() {
		return desc_id;
	}

	public void setDesc_id(int desc_id) {
		this.desc_id = desc_id;
	}

	String description;
	int desc_id;

}
