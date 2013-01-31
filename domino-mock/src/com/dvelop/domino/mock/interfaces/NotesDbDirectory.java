package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDbDirectory extends NotesBase {
	public static final int REPLICA_CANDIDATE = 1245;
	public static final int TEMPLATE_CANDIDATE = 1246;
	public static final int DATABASE = 1247;
	public static final int TEMPLATE = 1248;

	public abstract NotesDatabase createDatabase(String dbFile)
			throws NotesApiException;

	public abstract NotesDatabase createDatabase(String dbFile, boolean open)
			throws NotesApiException;

	public abstract NotesDatabase getFirstDatabase(int type)
			throws NotesApiException;

	public abstract NotesDatabase getNextDatabase() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract NotesDatabase openDatabase(String dbFile)
			throws NotesApiException;

	public abstract NotesDatabase openDatabase(String dbFile, boolean failover)
			throws NotesApiException;

	public abstract NotesDatabase openDatabaseIfModified(String dbFile,
			NotesDateTime date) throws NotesApiException;

	public abstract NotesDatabase openMailDatabase() throws NotesApiException;

	public abstract NotesDatabase openDatabaseByReplicaID(String rID)
			throws NotesApiException;

	public abstract String getClusterName() throws NotesApiException;

	public abstract String getClusterName(String serverName)
			throws NotesApiException;
}
