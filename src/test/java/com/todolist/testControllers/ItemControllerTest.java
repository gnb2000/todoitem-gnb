package com.todolist.testControllers;

import com.todolist.controllers.ItemController;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.ItemException;
import com.todolist.exceptions.UserException;
import com.todolist.models.Folder;
import junit.framework.TestCase;

public class ItemControllerTest extends TestCase {

    public void testCreateItem() {
        try {
            ItemController.getInstance().createItem("Lavar los platos",1,1);
        } catch (FolderException | UserException e){
            System.out.println(e.getMessage());
        }
    }

    public void testEditItem(){
        try {
            ItemController.getInstance().editItem(99,"Limpiar la mesa");
        } catch(ItemException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testDeleteItem(){
        try {
			ItemController.getInstance().deleteItem(19);
		} catch(FolderException | ItemException e) {
			System.out.println(e.getMessage());
		}
    }

    public void testUpdateItemStatus(){
        try {
            ItemController.getInstance().updateStatus(2, true);
        } catch(ItemException e) {
            System.out.println(e.getMessage());
        }
    }
}
