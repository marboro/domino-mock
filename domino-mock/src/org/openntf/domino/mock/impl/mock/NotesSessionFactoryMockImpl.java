package org.openntf.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.List;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesSession;
import org.openntf.domino.mock.interfaces.NotesSessionFactory;

/**
 * Mock-Implementation for NotesSessionFactory
 * 
 * @author Sven Dreher
 * @see NotesSessionFactory
 * 
 */
public class NotesSessionFactoryMockImpl implements NotesSessionFactory {

	private List<NotesSession> sessionList;

	@Override
	public NotesSession getSession() throws NotesApiException {
		NotesSession session = new NotesSessionMockImpl();
		sessionList = new ArrayList<NotesSession>();
		sessionList.add(session);
		return session;
	}

	@Override
	public void closeSession(NotesSession session) throws NotesApiException {
		sessionList.remove(session);

	}

}
