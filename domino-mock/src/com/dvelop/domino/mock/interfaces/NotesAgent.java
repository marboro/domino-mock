package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesAgent extends NotesBase {
	public static final int TRIGGER_NONE = 0;
	public static final int TRIGGER_SCHEDULED = 1;
	public static final int TRIGGER_AFTER_MAIL_DELIVERY = 2;
	public static final int TRIGGER_DOC_PASTED = 3;
	public static final int TRIGGER_MANUAL = 4;
	public static final int TRIGGER_DOC_UPDATE = 5;
	public static final int TRIGGER_BEFORE_MAIL_DELIVERY = 6;
	public static final int TRIGGER_SERVERSTART = 8;
	public static final int TARGET_NONE = 0;
	public static final int TARGET_ALL_DOCS = 1;
	public static final int TARGET_NEW_DOCS = 2;
	public static final int TARGET_NEW_OR_MODIFIED_DOCS = 3;
	public static final int TARGET_SELECTED_DOCS = 4;
	public static final int TARGET_ALL_DOCS_IN_VIEW = 5;
	public static final int TARGET_UNREAD_DOCS_IN_VIEW = 6;
	public static final int TARGET_RUN_ONCE = 8;

	public abstract void run() throws NotesApiException;

	public abstract void run(String noteID) throws NotesApiException;

	public abstract int runOnServer() throws NotesApiException;

	public abstract int runOnServer(String noteID) throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract void save() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract String getOwner() throws NotesApiException;

	public abstract NotesDateTime getLastRun() throws NotesApiException;

	public abstract boolean isEnabled() throws NotesApiException;

	public abstract void setEnabled(boolean value) throws NotesApiException;

	public abstract String getServerName() throws NotesApiException;

	public abstract void setServerName(String serverName)
			throws NotesApiException;

	public abstract String getQuery() throws NotesApiException;

	public abstract String getComment() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;

	public abstract boolean isPublic() throws NotesApiException;

	public abstract String getCommonOwner() throws NotesApiException;

	public abstract int getTrigger() throws NotesApiException;

	public abstract int getTarget() throws NotesApiException;

	public abstract boolean isNotesAgent() throws NotesApiException;

	public abstract boolean isWebAgent() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getNotesURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract String getParameterDocID() throws NotesApiException;

	public abstract boolean isActivatable() throws NotesApiException;

	public abstract String getOnBehalfOf() throws NotesApiException;

	public abstract Vector getLockHolders() throws NotesApiException;

	public abstract boolean lock() throws NotesApiException;

	public abstract boolean lock(boolean provisionalok)
			throws NotesApiException;

	public abstract boolean lock(String name) throws NotesApiException;

	public abstract boolean lock(String name, boolean provisionalok)
			throws NotesApiException;

	public abstract boolean lock(Vector names) throws NotesApiException;

	public abstract boolean lock(Vector names, boolean provisionalok)
			throws NotesApiException;

	public abstract boolean lockProvisional() throws NotesApiException;

	public abstract boolean lockProvisional(String name)
			throws NotesApiException;

	public abstract boolean lockProvisional(Vector names)
			throws NotesApiException;

	public abstract void unlock() throws NotesApiException;

	public abstract boolean isProhibitDesignUpdate() throws NotesApiException;

	public abstract void setProhibitDesignUpdate(boolean flag)
			throws NotesApiException;

}
