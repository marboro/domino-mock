package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.Agent;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;

public class NotesAgentProdImpl extends NotesBaseProdImpl implements NotesAgent {

	private final Agent agent;

	public NotesAgentProdImpl(Agent agent) {
		this.agent = agent;
	}

	public Agent get() {
		return agent;
	}

	@Override
	public void run() throws NotesApiException {
		try {
			agent.run();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void run(String arg0) throws NotesApiException {
		try {
			agent.run(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int runOnServer() throws NotesApiException {
		try {
			return agent.runOnServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int runOnServer(String arg0) throws NotesApiException {
		try {
			return agent.runOnServer(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			agent.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void save() throws NotesApiException {
		try {
			agent.save();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return agent.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOwner() throws NotesApiException {
		try {
			return agent.getOwner();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastRun() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(agent.getLastRun());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isEnabled() throws NotesApiException {
		try {
			return agent.isEnabled();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEnabled(boolean arg0) throws NotesApiException {
		try {
			agent.setEnabled(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getServerName() throws NotesApiException {
		try {
			return agent.getServerName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setServerName(String arg0) throws NotesApiException {
		try {
			agent.setServerName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getQuery() throws NotesApiException {
		try {
			return agent.getQuery();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getComment() throws NotesApiException {
		try {
			return agent.getComment();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(agent.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPublic() throws NotesApiException {
		try {
			return agent.isPublic();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCommonOwner() throws NotesApiException {
		try {
			return agent.getCommonOwner();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTrigger() throws NotesApiException {
		try {
			return agent.getTrigger();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getTarget() throws NotesApiException {
		try {
			return agent.getTarget();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isNotesAgent() throws NotesApiException {
		try {
			return agent.isNotesAgent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isWebAgent() throws NotesApiException {
		try {
			return agent.isWebAgent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return agent.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		try {
			return agent.getNotesURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		try {
			return agent.getHttpURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getParameterDocID() throws NotesApiException {
		try {
			return agent.getParameterDocID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isActivatable() throws NotesApiException {
		try {
			return agent.isActivatable();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getOnBehalfOf() throws NotesApiException {
		try {
			return agent.getOnBehalfOf();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		try {
			return agent.getLockHolders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock() throws NotesApiException {
		try {
			return agent.lock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		try {
			return agent.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		try {
			return agent.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		try {
			return agent.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		try {
			return agent.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		try {
			return agent.lock(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		try {
			return agent.lockProvisional();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		try {
			return agent.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		try {
			return agent.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void unlock() throws NotesApiException {
		try {
			agent.unlock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProhibitDesignUpdate() throws NotesApiException {
		try {
			return agent.isProhibitDesignUpdate();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setProhibitDesignUpdate(boolean arg0) throws NotesApiException {
		try {
			agent.setProhibitDesignUpdate(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}