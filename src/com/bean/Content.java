package com.bean;

public class Content {
	private Integer id;
	private String content;
	private Integer commandId;
	private Command command;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getCommandId() {
		return commandId;
	}
	public void setCommandId(Integer commandId) {
		this.commandId = commandId;
	}
	
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	@Override
	public String toString() {
		return "Content [id=" + id + ", content=" + content + ", commandId=" + commandId + "]";
	}
	
	
}
