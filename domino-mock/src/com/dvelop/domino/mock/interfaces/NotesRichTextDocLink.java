package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextDocLink extends NotesBase {
	public abstract void remove() throws NotesApiException;

	public abstract void setHotSpotTextStyle(NotesRichTextStyle style)
			throws NotesApiException;

	public abstract String getDBReplicaID() throws NotesApiException;

	public abstract void setDBReplicaID(String replicaid)
			throws NotesApiException;

	public abstract String getViewUnID() throws NotesApiException;

	public abstract void setViewUnID(String unid) throws NotesApiException;

	public abstract String getDocUnID() throws NotesApiException;

	public abstract void setDocUnID(String unid) throws NotesApiException;

	public abstract String getDisplayComment() throws NotesApiException;

	public abstract void setDisplayComment(String comment)
			throws NotesApiException;

	public abstract String getServerHint() throws NotesApiException;

	public abstract void setServerHint(String server) throws NotesApiException;

	public abstract String getHotSpotText() throws NotesApiException;

	public abstract void setHotSpotText(String text) throws NotesApiException;

	public abstract NotesRichTextStyle getHotSpotTextStyle()
			throws NotesApiException;

}
