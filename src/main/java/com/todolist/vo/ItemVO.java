package com.todolist.vo;

public class ItemVO {
	
	private Integer id;
	private String description;
	private boolean status;
	private Integer folder_id;
	
	public ItemVO() {}
	
	public ItemVO(Integer id, String description, boolean status,Integer folder_id) {
		this.id = id;
		this.description = description;
		this.status = status;
		this.folder_id = folder_id;
	}

	public Integer getFolder_id() {
		return folder_id;
	}

	public void setFolder_id(Integer folder_id) {
		this.folder_id = folder_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	

}
