package com.todolist.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import com.todolist.dbConnection.EManagerUtil;
import com.todolist.exceptions.FolderException;
import com.todolist.exceptions.ItemException;
import com.todolist.models.Folder;
import com.todolist.models.Item;

public class FolderDAO {
	
	private static FolderDAO instance;
	
	private FolderDAO() {}
	
	public static FolderDAO getInstance() {
		if (instance == null) {
			instance = new FolderDAO();
		}
		return instance;
	}
	
	public Folder getFolderById(Integer folderId) throws FolderException {
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			Folder folder = (Folder) em.createQuery("FROM Folder WHERE isEliminated = false AND id="+folderId).getSingleResult();
			em.close();
			return folder;
		} catch (NoResultException e) {
			throw new FolderException("Folder not found with id "+folderId);
		}
	}
	
	public void saveFolder(Folder folder) {
		EntityManager em = EManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(folder);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteFolder(Folder folder) {
		EntityManager em = EManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(folder));
		em.getTransaction().commit();
		em.close();
	}

	public void update(Folder folder){
		EntityManager em = EManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(folder);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Folder> getAllFolders() throws FolderException{
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			List<Folder> folders = (List<Folder>) em.createQuery("FROM Folder").getResultList();
			em.close();
			return folders;
		} catch (NoResultException e) {
			throw new FolderException("Folders not found");
		}
	}
	
	public Folder getFolderByItemId(Integer itemId) throws FolderException{
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			Folder folder = (Folder) em.createQuery("SELECT f FROM Folder f INNER JOIN f.items i WHERE f.isEliminated = false AND  i.id="+itemId).getSingleResult();
			System.out.println(folder.getItems().size());
			em.close();
			return folder;
		} catch (NoResultException e) {
			throw new FolderException("Folders not found");
		}
	}
	


	public List<Folder> getFoldersByUserId(Integer userId) throws FolderException {
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			List<Folder> folders = (List<Folder>) em.createQuery("FROM Folder WHERE isEliminated = false AND user_id="+userId).getResultList();
			em.close();
			return folders;
		} catch (NoResultException e) {
			throw new FolderException("Folders not found with user id "+userId);
		}
	}

}
