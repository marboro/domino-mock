package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesNewsletter extends NotesBase {
	public abstract NotesDocument formatMsgWithDoclinks(NotesDatabase arg0)
			throws NotesApiException;

	public abstract NotesDocument formatDocument(NotesDatabase arg0, int arg1)
			throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getSubjectItemName() throws NotesApiException;

	public abstract void setSubjectItemName(String arg0)
			throws NotesApiException;

	public abstract boolean isDoScore() throws NotesApiException;

	public abstract void setDoScore(boolean arg0) throws NotesApiException;

	public abstract boolean isDoSubject() throws NotesApiException;

	public abstract void setDoSubject(boolean arg0) throws NotesApiException;
}
