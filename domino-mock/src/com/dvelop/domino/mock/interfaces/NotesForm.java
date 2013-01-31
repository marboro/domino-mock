package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesForm extends NotesBase {
	public abstract Vector getAliases() throws NotesApiException;

	public abstract Vector getFields() throws NotesApiException;

	public abstract Vector getFormUsers() throws NotesApiException;

	public abstract void setFormUsers(Vector arg0) throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;

	public abstract Vector getReaders() throws NotesApiException;

	public abstract void setReaders(Vector arg0) throws NotesApiException;

	public abstract boolean isSubForm() throws NotesApiException;

	public abstract boolean isProtectReaders() throws NotesApiException;

	public abstract void setProtectReaders(boolean arg0)
			throws NotesApiException;

	public abstract boolean isProtectUsers() throws NotesApiException;

	public abstract void setProtectUsers(boolean arg0) throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getNotesURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract int getFieldType(String arg0) throws NotesApiException;

	public abstract Vector getLockHolders() throws NotesApiException;

	public abstract boolean lock() throws NotesApiException;

	public abstract boolean lock(boolean arg0) throws NotesApiException;

	public abstract boolean lock(String arg0) throws NotesApiException;

	public abstract boolean lock(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract boolean lock(Vector arg0) throws NotesApiException;

	public abstract boolean lock(Vector arg0, boolean arg1)
			throws NotesApiException;

	public abstract boolean lockProvisional() throws NotesApiException;

	public abstract boolean lockProvisional(String arg0)
			throws NotesApiException;

	public abstract boolean lockProvisional(Vector arg0)
			throws NotesApiException;

	public abstract void unlock() throws NotesApiException;
}
