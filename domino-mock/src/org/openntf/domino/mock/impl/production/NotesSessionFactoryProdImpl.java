package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesSession;
import org.openntf.domino.mock.interfaces.NotesSessionFactory;

import lotus.domino.NotesException;
import lotus.domino.NotesFactory;
import lotus.domino.NotesThread;
import lotus.domino.Session;


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

	@Override
	public void returnSession(NotesSession session) throws NotesApiException {
		try {
			if (session instanceof NotesSessionProdImpl) {

				((NotesSessionProdImpl) session).get().recycle();

				NotesThread.stermThread();
			}
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}
