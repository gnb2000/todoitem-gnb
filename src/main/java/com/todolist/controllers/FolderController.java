package com.todolist.controllers;

import java.util.ArrayList;
import java.util.List;

import com.todolist.daos.FolderDAO;
import com.todolist.daos.UserDAO;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.UserException;
import com.todolist.models.Folder;
import com.todolist.models.User;
import com.todolist.vo.FolderVO;

public class FolderController {
	
	private static FolderController instance;
	
	private FolderController() {}
	
	public static FolderController getInstance() {
		if (instance == null) {
			instance = new FolderController();
		}
		return instance;
	}
	
	public void createFolder(String name, Integer userId) throws UserException {
		User user = UserDAO.getInstance().getUserById(userId);
		Folder folder = new Folder(name,user);
		folder.save();
	}
	
	public void deleteFolder(Integer id) throws FolderException {
		Folder folder = FolderDAO.getInstance().getFolderById(id);
		folder.delete();
	}
	
	public FolderVO getFolderById(Integer folder_id) throws FolderException {
		return FolderDAO.getInstance().getFolderById(folder_id).toVo();
	}
	
	public List<FolderVO> getAllFolders() throws FolderException{
		List<Folder> folders = FolderDAO.getInstance().getAllFolders();
		List<FolderVO> foldersVO = new ArrayList<FolderVO>();
		for (Folder folder : folders) {
			foldersVO.add(folder.toVo());
		}
		return foldersVO;
	}
	
	public FolderVO getFolderByItemId(Integer itemId) throws FolderException {
		return FolderDAO.getInstance().getFolderByItemId(itemId).toVo();
	}
	
	

}
