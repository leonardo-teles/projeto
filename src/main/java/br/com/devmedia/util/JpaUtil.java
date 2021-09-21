package br.com.devmedia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory = null;
	private static EntityManager em = null;
	
	public static EntityManager getEntityManager() {
		
		if(factory == null) {
			factory = Persistence.createEntityManagerFactory("projeto");
		}
		
		if(em == null) {
			em = factory.createEntityManager();
		}
		
		return em;
	}
	
}
