package com.dvelop.domino.mock.impl.production;

import lotus.domino.DbDirectory;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDbDirectory;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesDbDirectoryProdImpl extends NotesBaseProdImpl implements
		NotesDbDirectory {

	private final DbDirectory dbDirectory;

	public NotesDbDirectoryProdImpl(DbDirectory dbDirectory) {
		this.dbDirectory = dbDirectory;
	}

	public DbDirectory get() {
		return dbDirectory;
	}

	@Override
	public NotesDatabase createDatabase(String arg0) throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.createDatabase(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase createDatabase(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.createDatabase(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getFirstDatabase(int arg0) throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.getFirstDatabase(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getNextDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.getNextDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return dbDirectory.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(dbDirectory.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase openDatabase(String arg0) throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.openDatabase(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase openDatabase(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.openDatabase(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase openDatabaseIfModified(String arg0, NotesDateTime arg1)
			throws NotesApiException {
		try {
			NotesDateTimeProdImpl dt = (NotesDateTimeProdImpl) arg1;
			return new NotesDatabaseProdImpl(
					dbDirectory.openDatabaseIfModified(arg0, dt.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase openMailDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(dbDirectory.openMailDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase openDatabaseByReplicaID(String arg0)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(
					dbDirectory.openDatabaseByReplicaID(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getClusterName() throws NotesApiException {
		try {
			return dbDirectory.getClusterName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getClusterName(String arg0) throws NotesApiException {
		try {
			return dbDirectory.getClusterName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}