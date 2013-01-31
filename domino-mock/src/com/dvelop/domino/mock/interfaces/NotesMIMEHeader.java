package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesMIMEHeader extends NotesBase {
	public abstract boolean addValText(String arg0) throws NotesApiException;

	public abstract boolean addValText(String arg0, String arg1)
			throws NotesApiException;

	public abstract String getHeaderName() throws NotesApiException;

	public abstract String getHeaderVal() throws NotesApiException;

	public abstract String getHeaderVal(boolean arg0) throws NotesApiException;

	public abstract String getHeaderVal(boolean arg0, boolean arg1)
			throws NotesApiException;

	public abstract String getHeaderValAndParams() throws NotesApiException;

	public abstract String getHeaderValAndParams(boolean arg0)
			throws NotesApiException;

	public abstract String getHeaderValAndParams(boolean arg0, boolean arg1)
			throws NotesApiException;

	public abstract String getParamVal(String arg0) throws NotesApiException;

	public abstract String getParamVal(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract boolean setHeaderVal(String arg0) throws NotesApiException;

	public abstract boolean setHeaderValAndParams(String arg0)
			throws NotesApiException;

	public abstract boolean setParamVal(String arg0, String arg1)
			throws NotesApiException;
}
