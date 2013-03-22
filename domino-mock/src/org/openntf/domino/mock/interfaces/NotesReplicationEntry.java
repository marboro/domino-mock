package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesReplicationEntry extends NotesBase {
	public abstract int save() throws NotesApiException;

	public abstract int remove() throws NotesApiException;

	public abstract String getFormula() throws NotesApiException;

	public abstract void setFormula(String formula) throws NotesApiException;

	public abstract String getViews() throws NotesApiException;

	public abstract void setViews(String views) throws NotesApiException;

	public abstract String getSource() throws NotesApiException;

	public abstract String getDestination() throws NotesApiException;

	public abstract boolean isIncludeACL() throws NotesApiException;

	public abstract void setIncludeACL(boolean flag) throws NotesApiException;

	public abstract boolean isIncludeAgents() throws NotesApiException;

	public abstract void setIncludeAgents(boolean flag)
			throws NotesApiException;

	public abstract boolean isIncludeDocuments() throws NotesApiException;

	public abstract void setIncludeDocuments(boolean flag)
			throws NotesApiException;

	public abstract boolean isIncludeForms() throws NotesApiException;

	public abstract void setIncludeForms(boolean flag) throws NotesApiException;

	public abstract boolean isIncludeFormulas() throws NotesApiException;

	public abstract void setIncludeFormulas(boolean flag)
			throws NotesApiException;
}
