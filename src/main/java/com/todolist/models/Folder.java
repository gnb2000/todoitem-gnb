package com.todolist.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.todolist.daos.FolderDAO;
import com.todolist.daos.ItemDAO;
import com.todolist.vo.FolderVO;

@Entity
@Table(name="folders")
public class Folder {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy="folder", orphanRemoval=true, cascade = CascadeType.ALL)
	private List<Item> items;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	private boolean isEliminated;
	
	public Folder() {}
	
	public Folder(String name, User user) {
		this.name = name;
		this.user = user;
		this.isEliminated = false;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	public void save() {
		FolderDAO.getInstance().saveFolder(this);
	}

	public void update(){
		FolderDAO.getInstance().update(this);
	}
	
	public void delete() {
		FolderDAO.getInstance().deleteFolder(this);
	}
	
	public FolderVO toVo() {
		return new FolderVO(this.id,this.name);
	}

	public boolean isEliminated() {
		return isEliminated;
	}

	public void setEliminated(boolean eliminated) {
		this.isEliminated = eliminated;
	}
}
