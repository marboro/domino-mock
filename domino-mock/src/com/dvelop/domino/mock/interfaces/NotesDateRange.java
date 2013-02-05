package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDateRange extends NotesBase {
	public abstract NotesDateTime getStartDateTime() throws NotesApiException;

	public abstract void setStartDateTime(NotesDateTime start)
			throws NotesApiException;

	public abstract NotesDateTime getEndDateTime() throws NotesApiException;

	public abstract void setEndDateTime(NotesDateTime end)
			throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract String getText() throws NotesApiException;

	public abstract void setText(String arg0) throws NotesApiException;
}
