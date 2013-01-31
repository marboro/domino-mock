package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesReplicationEntry extends NotesBase {
	public abstract int save() throws NotesApiException;

	public abstract int remove() throws NotesApiException;

	public abstract String getFormula() throws NotesApiException;

	public abstract void setFormula(String arg0) throws NotesApiException;

	public abstract String getViews() throws NotesApiException;

	public abstract void setViews(String arg0) throws NotesApiException;

	public abstract String getSource() throws NotesApiException;

	public abstract String getDestination() throws NotesApiException;

	public abstract boolean isIncludeACL() throws NotesApiException;

	public abstract void setIncludeACL(boolean arg0) throws NotesApiException;

	public abstract boolean isIncludeAgents() throws NotesApiException;

	public abstract void setIncludeAgents(boolean arg0)
			throws NotesApiException;

	public abstract boolean isIncludeDocuments() throws NotesApiException;

	public abstract void setIncludeDocuments(boolean arg0)
			throws NotesApiException;

	public abstract boolean isIncludeForms() throws NotesApiException;

	public abstract void setIncludeForms(boolean arg0) throws NotesApiException;

	public abstract boolean isIncludeFormulas() throws NotesApiException;

	public abstract void setIncludeFormulas(boolean arg0)
			throws NotesApiException;
}
