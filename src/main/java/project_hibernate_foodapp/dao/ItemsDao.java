package project_hibernate_foodapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import project_hibernate_foodapp.dto.Items;

public class ItemsDao {
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("akash").createEntityManager();

	}

	public Items saveItems(Items items) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(items);
		entityTransaction.commit();
		return items;
	}

	public Items getById(int id) {
		return getEntityManager().find(Items.class, id);

	}

	public List<Items> getAllItems() {
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("select i from items i");
		List<Items> items = query.getResultList();
		return items;

	}

	public Items updateItems(Items items) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.merge(items);
		entityTransaction.commit();
		return items;

	}

	public boolean deleteItems( int id) {
		EntityManager entityManager=getEntityManager();
		Items items=entityManager.find(Items.class, id);
		if (items!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(items);
			entityTransaction.commit();
			return true;
		}
		return false;
	}
}
			
