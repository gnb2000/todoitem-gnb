package com.todolist.test;

import com.todolist.controllers.FolderController;
import com.todolist.controllers.ItemController;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.ItemException;

public class Test {

	public static void main(String[] args) throws ItemException, FolderException {
		
		//Create folder

		//Delete folder
		//FolderController.getInstance().deleteFolder(1);
		
		//Create item
		//ItemController.getInstance().createItem("Lavar los platos",7);
		
		
		/*Edit item
		try {
			ItemController.getInstance().editItem(99,"Limpiar la mesa");
		} catch(ItemException e) {
			System.out.println(e.getMessage());
		}*/
		
		//Delete item
//		try {
//			ItemController.getInstance().deleteItem(19);
//		} catch(ItemException e) {
//			System.out.println(e.getMessage());
//		}
		
		/*Update item status
		try {
			ItemController.getInstance().updateStatus(2, true);
		} catch(ItemException e) {
			System.out.println(e.getMessage());
		}*/
		
		//FolderController.getInstance().getFolderByItemId(14);
		


	}

}
