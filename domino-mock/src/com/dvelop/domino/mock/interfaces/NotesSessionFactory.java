package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesSessionFactory {
	public NotesSession getSession() throws NotesApiException;

	public void returnSession(NotesSession session) throws NotesApiException;

}
