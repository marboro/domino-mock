package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesSession;
import com.dvelop.domino.mock.interfaces.NotesSessionFactory;

public class NotesSessionFactoryProdImpl implements NotesSessionFactory {

	@Override
	public NotesSession getSession() throws NotesApiException {
		NotesThread.sinitThread();
		Session session;
		try {
			session = NotesFactory.createSession();
			return new NotesSessionProdImpl(session);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}
