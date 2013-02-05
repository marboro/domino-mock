package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesReplication;
import com.dvelop.domino.mock.interfaces.NotesReplicationEntry;

public class NotesReplicationMockImpl extends NotesBaseMockImpl implements
		NotesReplication {

	@Override
	public int save() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int reset() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int clearHistory() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesReplicationEntry getEntry(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesReplicationEntry getEntry(String arg0, String arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCutoffInterval() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDateTime getCutoffDate() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDisabled() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIgnoreDeletes() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCutoffDelete() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAbstract() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isIgnoreDestDeletes() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getPriority() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getDontSendLocalSecurityUpdates() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCutoffInterval(long arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDisabled(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIgnoreDeletes(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setCutoffDelete(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setAbstract(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setIgnoreDestDeletes(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPriority(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setDontSendLocalSecurityUpdates(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getEntries() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}