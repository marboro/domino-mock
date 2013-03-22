package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesSessionFactory {
	public NotesSession getSession() throws NotesApiException;

	public void returnSession(NotesSession session) throws NotesApiException;

}
