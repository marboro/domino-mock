package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesMIMEHeader extends NotesBase {
	public abstract boolean addValText(String valueText) throws NotesApiException;

	public abstract boolean addValText(String valueText, String charSet)
			throws NotesApiException;

	public abstract String getHeaderName() throws NotesApiException;

	public abstract String getHeaderVal() throws NotesApiException;

	public abstract String getHeaderVal(boolean folded) throws NotesApiException;

	public abstract String getHeaderVal(boolean folded, boolean decoded)
			throws NotesApiException;

	public abstract String getHeaderValAndParams() throws NotesApiException;

	public abstract String getHeaderValAndParams(boolean folded)
			throws NotesApiException;

	public abstract String getHeaderValAndParams(boolean folded, boolean decoded)
			throws NotesApiException;

	public abstract String getParamVal(String paramName) throws NotesApiException;

	public abstract String getParamVal(String paramName, boolean folded)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract boolean setHeaderVal(String headerValue) throws NotesApiException;

	public abstract boolean setHeaderValAndParams(String headerParamValue)
			throws NotesApiException;

	public abstract boolean setParamVal(String parameterName, String parameterValue)
			throws NotesApiException;
}
