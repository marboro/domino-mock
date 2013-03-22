package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesProperty extends NotesBase {
	public abstract String getName() throws NotesApiException;

	public abstract String getNamespace() throws NotesApiException;

	public abstract Vector getValues() throws NotesApiException;

	public abstract String getValueString() throws NotesApiException;

	public abstract String getTypeName() throws NotesApiException;

	public abstract boolean isInput() throws NotesApiException;

	public abstract String getTitle() throws NotesApiException;

	public abstract String getDescription() throws NotesApiException;

	public abstract void publish() throws NotesApiException;

	public abstract void clear() throws NotesApiException;
}
