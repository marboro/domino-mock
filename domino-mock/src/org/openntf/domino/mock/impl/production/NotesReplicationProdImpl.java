package org.openntf.domino.mock.impl.production;

import java.util.Iterator;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesReplication;
import org.openntf.domino.mock.interfaces.NotesReplicationEntry;

import lotus.domino.NotesException;
import lotus.domino.Replication;
import lotus.domino.ReplicationEntry;


public class NotesReplicationProdImpl extends NotesBaseProdImpl implements
		NotesReplication {

	private final Replication replication;

	public NotesReplicationProdImpl(Replication replication) {
		this.replication = replication;
	}

	public Replication get() {
		return replication;
	}

	@Override
	public int save() throws NotesApiException {
		try {
			return replication.save();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int reset() throws NotesApiException {
		try {
			return replication.reset();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int clearHistory() throws NotesApiException {
		try {
			return replication.clearHistory();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesReplicationEntry getEntry(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesReplicationEntryProdImpl(replication.getEntry(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesReplicationEntry getEntry(String arg0, String arg1, boolean arg2)
			throws NotesApiException {
		try {
			return new NotesReplicationEntryProdImpl(replication.getEntry(arg0,
					arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long getCutoffInterval() throws NotesApiException {
		try {
			return replication.getCutoffInterval();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getCutoffDate() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(replication.getCutoffDate());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDisabled() throws NotesApiException {
		try {
			return replication.isDisabled();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIgnoreDeletes() throws NotesApiException {
		try {
			return replication.isIgnoreDeletes();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCutoffDelete() throws NotesApiException {
		try {
			return replication.isCutoffDelete();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isAbstract() throws NotesApiException {
		try {
			return replication.isAbstract();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIgnoreDestDeletes() throws NotesApiException {
		try {
			return replication.isIgnoreDestDeletes();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getPriority() throws NotesApiException {
		try {
			return replication.getPriority();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getDontSendLocalSecurityUpdates() throws NotesApiException {
		try {
			return replication.getDontSendLocalSecurityUpdates();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCutoffInterval(long arg0) throws NotesApiException {
		try {
			replication.setCutoffInterval(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDisabled(boolean arg0) throws NotesApiException {
		try {
			replication.setDisabled(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIgnoreDeletes(boolean arg0) throws NotesApiException {
		try {
			replication.setIgnoreDeletes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCutoffDelete(boolean arg0) throws NotesApiException {
		try {
			replication.setCutoffDelete(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAbstract(boolean arg0) throws NotesApiException {
		try {
			replication.setAbstract(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIgnoreDestDeletes(boolean arg0) throws NotesApiException {
		try {
			replication.setIgnoreDestDeletes(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPriority(int arg0) throws NotesApiException {
		try {
			replication.setPriority(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDontSendLocalSecurityUpdates(boolean arg0)
			throws NotesApiException {
		try {
			replication.setDontSendLocalSecurityUpdates(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getEntries() throws NotesApiException {
		try {
			Vector entries = replication.getEntries();
			Vector<NotesReplicationEntry> vector = new Vector<NotesReplicationEntry>();
			if (entries.size() > 0) {
				if (entries.get(0) instanceof ReplicationEntry) {
					Iterator iterator = entries.iterator();
					while (iterator.hasNext()) {
						vector.add(new NotesReplicationEntryProdImpl(
								(ReplicationEntry) iterator.next()));
					}
					return vector;
				}
			}
			return entries;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}