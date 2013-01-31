package com.dvelop.domino.mock;

import com.dvelop.domino.mock.impl.production.NotesSessionFactoryProdImpl;
import com.dvelop.domino.mock.interfaces.NotesSessionFactory;

public class NotesStartupFactory {

	private static NotesSessionFactory sessionFactory = null;

	public static NotesSessionFactory getFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		return new NotesSessionFactoryProdImpl();
	}

	public void setSessionFactory(NotesSessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
