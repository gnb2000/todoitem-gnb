package com.todolist.restControllers;

import java.util.List;

import com.todolist.exceptions.UserException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.controllers.ItemController;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.ItemException;
import com.todolist.vo.ItemVO;

@RestController
public class ItemRestController {
	
	@PostMapping("/createItem")
	@CrossOrigin(origins="http://localhost:3000/")
	public void createItem(@RequestParam(name="description") String description, @RequestParam(name="folder_id") Integer folder_id) throws FolderException, UserException {
		ItemController.getInstance().createItem(description,folder_id);
	}
	
	@PutMapping("/editItem")
	@CrossOrigin(origins="http://localhost:3000/")
	public void editItem(@RequestParam(name="itemId") Integer itemId, @RequestParam(name="description") String description) throws ItemException {
		ItemController.getInstance().editItem(itemId,description);
	}
	
	@DeleteMapping("/deleteItem")
	@CrossOrigin(origins="http://localhost:3000/")
	public void deleteItem(@RequestParam(name="itemId") Integer itemId) throws ItemException, FolderException {
		ItemController.getInstance().deleteItem(itemId);
	}
	
	@PutMapping("/updateStatus")
	@CrossOrigin(origins="http://localhost:3000/")
	public void updateStatus(@RequestParam(name="itemId") Integer itemId, @RequestParam(name="status") boolean status) throws ItemException {
		ItemController.getInstance().updateStatus(itemId, status);
	}
	
	@RequestMapping("/getAllItems")
	@CrossOrigin(origins="http://localhost:3000/")
	public List<ItemVO> getAllItems() throws ItemException {
		return ItemController.getInstance().getAllItems();
	}
	
	@RequestMapping("/getItemById")
	@CrossOrigin(origins="http://localhost:3000/")
	public ItemVO getItemById(@RequestParam(name="itemId") Integer itemId) throws ItemException {
		return ItemController.getInstance().getItemById(itemId);
	}
	
	@PutMapping("/changeItemStatus")
	@CrossOrigin(origins="http://localhost:3000/")
	public void changeItemStatus(@RequestParam(name="itemId") Integer itemId) throws ItemException {
		ItemController.getInstance().changeItemStatus(itemId);
	}
	
	@RequestMapping("/getItemsByFolderId")
	@CrossOrigin(origins="http://localhost:3000/")
	public List<ItemVO> getItemsByFolderId(@RequestParam(name="folder_id") Integer folder_id) throws ItemException{
		return ItemController.getInstance().getItemsByFolderId(folder_id);
	}


 

	

}
