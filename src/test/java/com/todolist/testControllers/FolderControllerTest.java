package com.todolist.testControllers;

import com.todolist.controllers.FolderController;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.ItemException;
import com.todolist.exceptions.UserException;
import junit.framework.TestCase;

public class FolderControllerTest extends TestCase {

    public void testCreateFolder(){
        try {
            FolderController.getInstance().createFolder("Daily reminders",1);
            FolderController.getInstance().createFolder("Training",1);
            FolderController.getInstance().createFolder("Eventually",1);

        } catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }

    public void testDeleteFolder() throws FolderException {
        try {
            FolderController.getInstance().deleteFolder(1);
        } catch (FolderException | ItemException e){
            System.out.println(e.getMessage());
        }
    }





}
