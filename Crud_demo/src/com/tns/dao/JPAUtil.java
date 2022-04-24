package com.tns.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory factory;
	private static EntityManager entityManager;
	static {
		// persistence unit name in persistence.xml need to specify here
		// it will define all the meta data which is required for
		// createEntityManagerFactory to generated the persistence context
		// persistence context is a buffer space where we have memory associated with
		// every entity, and we can perform all the intermediate operations
		factory = Persistence.createEntityManagerFactory("JPA-PU");
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null || !entityManager.isOpen()) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}
}
