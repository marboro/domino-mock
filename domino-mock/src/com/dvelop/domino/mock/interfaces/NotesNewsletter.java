package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesNewsletter extends NotesBase {
	public abstract NotesDocument formatMsgWithDoclinks(NotesDatabase db)
			throws NotesApiException;

	public abstract NotesDocument formatDocument(NotesDatabase db, int index)
			throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getSubjectItemName() throws NotesApiException;

	public abstract void setSubjectItemName(String name)
			throws NotesApiException;

	public abstract boolean isDoScore() throws NotesApiException;

	public abstract void setDoScore(boolean flag) throws NotesApiException;

	public abstract boolean isDoSubject() throws NotesApiException;

	public abstract void setDoSubject(boolean flag) throws NotesApiException;
}
