package com.todolist.testControllers;

import com.todolist.controllers.FolderController;
import com.todolist.exceptions.FolderException;
import junit.framework.TestCase;

public class FolderControllerTest extends TestCase {

    public void testCreateFolder(){
        FolderController.getInstance().createFolder("Daily reminders");
    }

    public void testDeleteFolder() throws FolderException {
        try {
            FolderController.getInstance().deleteFolder(1);
        } catch (FolderException e){
            System.out.println(e.getMessage());
        }
    }





}
