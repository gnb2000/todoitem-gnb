package com.todolist.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.todolist.dbConnection.EManagerUtil;
import com.todolist.exceptions.ItemException;
import com.todolist.models.Item;

public class ItemDAO {
	
	private static ItemDAO instance;
	
	private ItemDAO() {}
	
	public static ItemDAO getInstance() {
		if (instance == null) {
			instance = new ItemDAO();
		}
		return instance;
	}
	
	public void saveItem(Item item) {
		EntityManager em = EManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateItem(Item item) {
		EntityManager em = EManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.merge(item);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteItem(Item item) {
		EntityManager em = EManagerUtil.getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(item));
		em.getTransaction().commit();
		em.close();
	}
	
	public Item getItemById(Integer itemId) throws ItemException {
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			Item item = (Item) em.createQuery("FROM Item WHERE id ="+itemId).getSingleResult();
			em.close();
			return item;
		} catch(NoResultException e) {
			throw new ItemException("Item not found with id "+itemId);
		}
	}
	
	public List<Item> getAllItems() throws ItemException{
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			List<Item> items = em.createQuery("FROM Item").getResultList();
			em.close();
			return items;
		} catch(NoResultException e) {
			throw new ItemException("Items not found");
		}
	}
	
	public List<Item> getItemsByFolderId(Integer folder_id) throws ItemException {
		try {
			EntityManager em = EManagerUtil.getEntityManager();
			List<Item> items = em.createQuery("FROM Item WHERE folder="+folder_id).getResultList();
			em.close();
			return items;
		} catch(NoResultException e) {
			throw new ItemException("Items not found with folder id "+folder_id);
		}
	}
	
	

}
