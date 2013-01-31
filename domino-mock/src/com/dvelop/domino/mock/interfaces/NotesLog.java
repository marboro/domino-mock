package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesLog extends NotesBase {
	public static final int EV_UNKNOWN = 0;
	public static final int EV_COMM = 1;
	public static final int EV_SECURITY = 2;
	public static final int EV_MAIL = 3;
	public static final int EV_REPLICA = 4;
	public static final int EV_RESOURCE = 5;
	public static final int EV_MISC = 6;
	public static final int EV_SERVER = 7;
	public static final int EV_ALARM = 8;
	public static final int EV_UPDATE = 9;
	public static final int SEV_UNKNOWN = 0;
	public static final int SEV_FATAL = 1;
	public static final int SEV_FAILURE = 2;
	public static final int SEV_WARNING1 = 3;
	public static final int SEV_WARNING2 = 4;
	public static final int SEV_NORMAL = 5;

	public abstract void close() throws NotesApiException;

	public abstract String getProgramName() throws NotesApiException;

	public abstract void setProgramName(String arg0) throws NotesApiException;

	public abstract int getNumActions() throws NotesApiException;

	public abstract int getNumErrors() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract boolean isLogActions() throws NotesApiException;

	public abstract void setLogActions(boolean arg0) throws NotesApiException;

	public abstract boolean isLogErrors() throws NotesApiException;

	public abstract void setLogErrors(boolean arg0) throws NotesApiException;

	public abstract boolean isOverwriteFile() throws NotesApiException;

	public abstract void setOverwriteFile(boolean arg0)
			throws NotesApiException;

	public abstract void logAction(String arg0) throws NotesApiException;

	public abstract void logError(int arg0, String arg1)
			throws NotesApiException;

	public abstract void logEvent(String arg0, String arg1, int arg2, int arg3)
			throws NotesApiException;

	public abstract void openAgentLog() throws NotesApiException;

	public abstract void openFileLog(String arg0) throws NotesApiException;

	public abstract void openMailLog(Vector arg0, String arg1)
			throws NotesApiException;

	public abstract void openNotesLog(String arg0, String arg1)
			throws NotesApiException;
}
