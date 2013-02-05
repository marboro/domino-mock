package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesReplication extends NotesBase {
	public static final int CNOTES_REPLCONST_PRIORITYLOW = 1547;
	public static final int CNOTES_REPLCONST_PRIORITYMED = 1548;
	public static final int CNOTES_REPLCONST_PRIORITYHIGH = 1549;
	public static final int CNOTES_REPLCONST_PRIORITYNOTSET = 1565;
	public static final int LEVEL_NOACCESS = 0;

	public abstract int save() throws NotesApiException;

	public abstract int reset() throws NotesApiException;

	public abstract int clearHistory() throws NotesApiException;

	public abstract NotesReplicationEntry getEntry(String source,
			String destination) throws NotesApiException;

	public abstract NotesReplicationEntry getEntry(String source,
			String destination, boolean createflag) throws NotesApiException;

	public abstract long getCutoffInterval() throws NotesApiException;

	public abstract NotesDateTime getCutoffDate() throws NotesApiException;

	public abstract boolean isDisabled() throws NotesApiException;

	public abstract boolean isIgnoreDeletes() throws NotesApiException;

	public abstract boolean isCutoffDelete() throws NotesApiException;

	public abstract boolean isAbstract() throws NotesApiException;

	public abstract boolean isIgnoreDestDeletes() throws NotesApiException;

	public abstract int getPriority() throws NotesApiException;

	public abstract boolean getDontSendLocalSecurityUpdates()
			throws NotesApiException;

	public abstract void setCutoffInterval(long interval)
			throws NotesApiException;

	public abstract void setDisabled(boolean flag) throws NotesApiException;

	public abstract void setIgnoreDeletes(boolean flag)
			throws NotesApiException;

	public abstract void setCutoffDelete(boolean flag) throws NotesApiException;

	public abstract void setAbstract(boolean flag) throws NotesApiException;

	public abstract void setIgnoreDestDeletes(boolean flag)
			throws NotesApiException;

	public abstract void setPriority(int priority) throws NotesApiException;

	public abstract void setDontSendLocalSecurityUpdates(boolean flag)
			throws NotesApiException;

	public abstract Vector getEntries() throws NotesApiException;
}
