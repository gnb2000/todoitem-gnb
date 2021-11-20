package com.todolist.restControllers;
import java.util.List;

import com.todolist.exceptions.UserException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.todolist.controllers.FolderController;
import com.todolist.exceptions.FolderException;
import com.todolist.vo.FolderVO;


@RestController
public class FolderRestController {
	
	@PostMapping("/createFolder")
	@CrossOrigin(origins="http://localhost:3000/")
	public void createFolder(@RequestParam(name="name") String name, @RequestParam(name="user_id") Integer user_id) {
		try {
			FolderController.getInstance().createFolder(name,user_id);
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@DeleteMapping("/deleteFolder")
	@CrossOrigin(origins="http://localhost:3000/")
	public void deleteFolder(@RequestParam(name="folder_id") Integer folder_id) throws FolderException {
		FolderController.getInstance().deleteFolder(folder_id);
	}
	
	@RequestMapping("/getFolderById")
	@CrossOrigin(origins="http://localhost:3000/")
	public FolderVO getFolderById(@RequestParam(name="folder_id") Integer folder_id) throws FolderException {
		return FolderController.getInstance().getFolderById(folder_id);
	}
	
	@RequestMapping("/getAllFolders")
	@CrossOrigin(origins="http://localhost:3000/")
	public List<FolderVO> getAllFolders() throws FolderException {
		return FolderController.getInstance().getAllFolders();
	}


}
