package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;

public class NotesAgentMockImpl extends NotesBaseMockImpl implements NotesAgent {

	@Override
	public void run() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void run(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int runOnServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int runOnServer(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getOwner() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getLastRun() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEnabled() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEnabled(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getServerName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setServerName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getQuery() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getComment() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPublic() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCommonOwner() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTrigger() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTarget() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isNotesAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWebAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParameterDocID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isActivatable() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getOnBehalfOf() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lock() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isProhibitDesignUpdate() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProhibitDesignUpdate(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}