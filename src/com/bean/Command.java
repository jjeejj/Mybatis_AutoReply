package com.bean;

import java.util.List;

public class Command {
	private Integer id;
	private String name;
	private String description;
	
	private List<Content> contents;
	
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public List<Content> getContents() {
		return contents;
	}
	public void setContents(List<Content> contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "Command [id=" + id + ", name=" + name + ", description=" + description + ", contents=" + contents
				+ "]";
	}

	
	
	
}
