package com.dvelop.domino.mock.impl.mock;

import java.util.Date;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;

public class NotesAgentMockImpl extends NotesBaseMockImpl implements NotesAgent {

	private NotesDateTimeMockImpl lastRun;
	private String noteID;
	private NotesDatabase parent;
	private String agentName;
	private String owner;
	private boolean enabled;
	private String serverName;
	private String query;
	private String comment;
	private boolean isPublic;
	private String commonOwner;
	private int trigger;
	private int target;
	private boolean isNotesAgent;
	private boolean isWebAgent;
	private String url;
	private String notesURL;
	private String httpURL;
	private boolean isActivateable;

	public NotesAgentMockImpl(String agentName, NotesDatabase parent) {
		this.agentName = agentName;
		this.parent = parent;
	}

	public NotesAgentMockImpl(String agentName) {
		this.agentName = agentName;

	}

	public void setParent(NotesDatabase parent) {
		this.parent = parent;

	}

	@Override
	public void run() throws NotesApiException {
		lastRun = new NotesDateTimeMockImpl(new Date());

	}

	@Override
	public void run(String noteID) throws NotesApiException {
		this.noteID = noteID;
		lastRun = new NotesDateTimeMockImpl(new Date());

	}

	@Override
	public int runOnServer() throws NotesApiException {
		lastRun = new NotesDateTimeMockImpl(new Date());
		return 0;
	}

	@Override
	public int runOnServer(String noteID) throws NotesApiException {
		this.noteID = noteID;
		lastRun = new NotesDateTimeMockImpl(new Date());
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
		return agentName;
	}

	@Override
	public String getOwner() throws NotesApiException {
		return owner;
	}

	@Override
	public NotesDateTime getLastRun() throws NotesApiException {
		return lastRun;

	}

	@Override
	public boolean isEnabled() throws NotesApiException {
		return enabled;
	}

	@Override
	public void setEnabled(boolean enabled) throws NotesApiException {
		this.enabled = enabled;
	}

	@Override
	public String getServerName() throws NotesApiException {
		return serverName;
	}

	@Override
	public void setServerName(String serverName) throws NotesApiException {
		this.serverName = serverName;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	@Override
	public String getQuery() throws NotesApiException {
		return query;
	}

	public void setComment(String comment) {
		this.comment = comment;

	}

	@Override
	public String getComment() throws NotesApiException {
		return comment;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		return parent;
	}

	public void setIsPublic(boolean isPublic) {
		this.isPublic = isPublic;
	}

	@Override
	public boolean isPublic() throws NotesApiException {
		return isPublic;
	}

	public void setCommonOwner(String commonOwner) {
		this.commonOwner = commonOwner;
	}

	@Override
	public String getCommonOwner() throws NotesApiException {
		return commonOwner;
	}

	public void setTrigger(int trigger) {
		this.trigger = trigger;

	}

	@Override
	public int getTrigger() throws NotesApiException {
		return trigger;

	}

	public void setTarget(int target) {
		this.target = target;

	}

	@Override
	public int getTarget() throws NotesApiException {
		return target;

	}

	public void setIsNotesAgent(boolean isNotesAgent) {
		this.isNotesAgent = isNotesAgent;

	}

	@Override
	public boolean isNotesAgent() throws NotesApiException {
		return isNotesAgent;

	}

	public void setIsWebAgent(boolean isWebAgent) {
		this.isWebAgent = isWebAgent;

	}

	@Override
	public boolean isWebAgent() throws NotesApiException {
		return isWebAgent;

	}

	public void setUrl(String url) {
		this.url = url;

	}

	@Override
	public String getURL() throws NotesApiException {
		return url;

	}

	public void setNotesURL(String notesURL) {
		this.notesURL = notesURL;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		return notesURL;

	}

	public void setHttpURL(String httpURL) {
		this.httpURL = httpURL;

	}

	@Override
	public String getHttpURL() throws NotesApiException {
		return httpURL;

	}

	@Override
	public String getParameterDocID() throws NotesApiException {
		return noteID;
	}

	public void setIsActivatable(boolean isActivateable) {
		this.isActivateable = isActivateable;

	}

	@Override
	public boolean isActivatable() throws NotesApiException {
		return isActivateable;

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
	public boolean lock(boolean provisionalok) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalok) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names, boolean provisionalok) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector names) throws NotesApiException {
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
	public void setProhibitDesignUpdate(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

}