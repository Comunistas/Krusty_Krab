/**
 * 
 */
package com.krustykrab.hibernate;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

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
	private static final String PROPS_FILENAME = "hibernate.properties";
	
	private static void initializeEmf()
	{
		Properties props = new Properties();
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROPS_FILENAME);
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		emf = Persistence.createEntityManagerFactory("PersistenceUnit", props);
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
