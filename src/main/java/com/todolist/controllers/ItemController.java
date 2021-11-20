package com.todolist.controllers;

import java.util.ArrayList;
import java.util.List;

import com.todolist.daos.FolderDAO;
import com.todolist.daos.ItemDAO;
import com.todolist.daos.UserDAO;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.ItemException;
import com.todolist.exceptions.UserException;
import com.todolist.models.Folder;
import com.todolist.models.Item;
import com.todolist.models.User;
import com.todolist.vo.ItemVO;

public class ItemController {
	
	private static ItemController instance;
	
	private ItemController() {}
	
	public static ItemController getInstance() {
		if (instance == null) {
			instance = new ItemController();
		}
		return instance;
	}
	
	public void createItem(String description, Integer folderId) throws FolderException, UserException {
		Folder folder = FolderDAO.getInstance().getFolderById(folderId);
		Item newItem = new Item(description,folder);
		newItem.save();
	}
	
	public void editItem(Integer itemId, String description) throws ItemException {
		Item item = ItemDAO.getInstance().getItemById(itemId);
		item.setDescription(description);
		item.update();
		
	}
	
	public void deleteItem(Integer itemId) throws ItemException, FolderException {
		Item item = ItemDAO.getInstance().getItemById(itemId);
		//item.delete();
		item.setEliminated(true);
		item.update();
	}
	
	public void updateStatus(Integer itemId, boolean status) throws ItemException {
		Item item = ItemDAO.getInstance().getItemById(itemId);
		item.setStatus(status);
		item.update();
	}
	
	public List<ItemVO> getAllItems() throws ItemException{
		List<Item> items = ItemDAO.getInstance().getAllItems();
		List<ItemVO> itemsVO = new ArrayList<ItemVO>();
		for (Item item : items) {
			itemsVO.add(item.toVo());
		}
		return itemsVO;
		
	}
	
	public ItemVO getItemById(Integer itemId) throws ItemException {
		return ItemDAO.getInstance().getItemById(itemId).toVo();
	}
	
	public void changeItemStatus(Integer itemId) throws ItemException {
		Item item = ItemDAO.getInstance().getItemById(itemId);
		item.changeStatus();
		item.update();
	}
	
	public List<ItemVO> getItemsByFolderId(Integer folder_id) throws ItemException{
		List<Item> items = ItemDAO.getInstance().getItemsByFolderId(folder_id);
		List<ItemVO> itemsVO = new ArrayList<ItemVO>();
		for (Item item : items) {
			itemsVO.add(item.toVo());
		}
		return itemsVO;
	}
	

}
