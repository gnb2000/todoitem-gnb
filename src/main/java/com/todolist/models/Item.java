package com.todolist.models;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.todolist.daos.FolderDAO;
import com.todolist.daos.ItemDAO;
import com.todolist.exceptions.FolderException;
import com.todolist.vo.ItemVO;

@Entity
@Table(name="items")
public class Item {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String description;
	private boolean status;

	@ManyToOne
	@JoinColumn(name="folder")
	private Folder folder;

	private boolean isEliminated;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	public Item() {}
	
	public Item(String description, Folder folder, User user) {
		this.description = description;
		this.status = false;
		this.folder = folder;
		this.isEliminated = false;
		this.user = user;
	}

	public Folder getFolder() {
		return folder;
	}

	public void setFolder(Folder folder) {
		this.folder = folder;
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


	
	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public void changeStatus() {
		if (this.status == true) {
			this.status = false;
		} else {
			this.status = true;
		}
	}

	public boolean getIsEliminated(){
		return this.isEliminated;
	}

	public void setEliminated(boolean status){
		this.isEliminated = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void save() {
		ItemDAO.getInstance().saveItem(this);
	}
	
	public void update() {
		ItemDAO.getInstance().updateItem(this);
	}
	
	public void delete() {
		
		ItemDAO.getInstance().deleteItem(this);
	}


	
	public ItemVO toVo() {
		return new ItemVO(this.id, this.description,this.status,this.folder.getId());
		
	}
	
	

}
