package org.openntf.domino.mock.impl.mock;

import java.util.ArrayList;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesDbDirectory;
import org.openntf.domino.mock.interfaces.NotesSession;


public class NotesDbDirectoryMockImpl extends NotesBaseMockImpl implements NotesDbDirectory {

	private final String server;
	private ArrayList<NotesDatabase> databases;
	private int currentIndex;
	private NotesSession parent;
	private String clusterName;

	public NotesDbDirectoryMockImpl(String server, NotesSession parent) {
		this.server = server;
		this.parent = parent;
		databases = new ArrayList<NotesDatabase>();
	}

	@Override
	public NotesDatabase createDatabase(String dbFile) throws NotesApiException {
		return createDatabase(dbFile, false);
	}

	@Override
	public NotesDatabase createDatabase(String dbFile, boolean open) throws NotesApiException {
		NotesDatabaseMockImpl database = new NotesDatabaseMockImpl(server, dbFile);
		if (open)
			database.open();
		databases.add(database);
		return database;
	}

	@Override
	public NotesDatabase getFirstDatabase(int type) throws NotesApiException {
		if (databases.size() > 0) {
			currentIndex = 0;
			return databases.get(0);
		}
		return null;
	}

	@Override
	public NotesDatabase getNextDatabase() throws NotesApiException {
		currentIndex++;
		if (databases.size() >= currentIndex) {
			return databases.get(currentIndex);
		}
		return null;
	}

	@Override
	public String getName() throws NotesApiException {
		return server;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public NotesDatabase openDatabase(String dbFile) throws NotesApiException {
		return openDatabase(dbFile, false);
	}

	@Override
	public NotesDatabase openDatabase(String dbFile, boolean failover) throws NotesApiException {
		NotesDatabaseMockImpl database = new NotesDatabaseMockImpl(server, dbFile);
		database.open();
		return database;
	}

	@Override
	public NotesDatabase openDatabaseIfModified(String dbFile, NotesDateTime date) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase openMailDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase openDatabaseByReplicaID(String rID) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	@Override
	public String getClusterName() throws NotesApiException {
		return getClusterName(server);
	}

	@Override
	public String getClusterName(String serverName) throws NotesApiException {
		return clusterName;
	}

}