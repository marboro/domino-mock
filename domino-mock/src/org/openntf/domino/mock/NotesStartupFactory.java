package org.openntf.domino.mock;

import org.openntf.domino.mock.impl.production.NotesSessionFactoryProdImpl;
import org.openntf.domino.mock.interfaces.NotesSessionFactory;

/**
 * @author Sven Dreher
 * 
 */
public class NotesStartupFactory {

	private static NotesSessionFactory sessionFactory = null;

	public static NotesSessionFactory getFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		return new NotesSessionFactoryProdImpl();
	}

	public void setSessionFactory(NotesSessionFactory sessionFactory) {
		NotesStartupFactory.sessionFactory = sessionFactory;
	}
}
