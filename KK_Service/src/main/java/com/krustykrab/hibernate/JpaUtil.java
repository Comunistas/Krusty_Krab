/**
 * 
 */
package com.krustykrab.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Vladislav Zedano
 *
 */
public class JpaUtil
{
	private static EntityManagerFactory emf;
	private static final ThreadLocal<EntityManager> manager = new ThreadLocal<EntityManager>();

	
	private static void initializeEmf()
	{
		emf = Persistence.createEntityManagerFactory("PersistenceUnit");
	}
	
	public static EntityManagerFactory getEmf()
	{
		if (emf == null) {
			initializeEmf();
		}
		return emf;
	}

	public EntityManager getEntityManager()
	{
		EntityManager em = manager.get();

		if (em == null) {
			em = emf.createEntityManager();
			manager.set(em);
		}

		return em;
	}

	public void closeEntityManager()
	{
		EntityManager em = manager.get();
		if(em != null){
			if(em.isOpen())
				em.close();
			manager.set(null);
		}
	}

}
