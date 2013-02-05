package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDirectory;
import com.dvelop.domino.mock.interfaces.NotesDirectoryNavigator;

public class NotesDirectoryMockImpl extends NotesBaseMockImpl implements NotesDirectory {

	private final String server;
	private boolean searchAllDirectories;
	private boolean trustedOnly;
	private boolean groupAuthorizationOnly;
	private boolean useContextServer;
	private boolean limitMatches;
	private boolean partialMatches;
	private boolean errorOnMultipleMatches;

	public NotesDirectoryMockImpl() {
		this("");
	}

	public NotesDirectoryMockImpl(String server) {
		this.server = server;
	}

	@Override
	public String getServer() throws NotesApiException {
		return server;
	}

	@Override
	public String getAvailableView() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getAvailableNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getAvailableItems() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isSearchAllDirectories() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTrustedOnly() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isGroupAuthorizationOnly() throws NotesApiException {
		return groupAuthorizationOnly;
	}

	@Override
	public boolean isUseContextServer() throws NotesApiException {
		return useContextServer;
	}

	public void setPartialMatches(boolean partialMatches) {
		this.partialMatches = partialMatches;
	}

	@Override
	public boolean isPartialMatches() throws NotesApiException {
		return partialMatches;
	}

	@Override
	public boolean isLimitMatches() throws NotesApiException {
		return limitMatches;
	}

	@Override
	public NotesDirectoryNavigator createNavigator() throws NotesApiException {
		return new NotesDirectoryNavigatorMockImpl();
	}

	@Override
	public void freeLookupBuffer() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setSearchAllDirectories(boolean searchAllDirectories) throws NotesApiException {
		this.searchAllDirectories = searchAllDirectories;
	}

	@Override
	public void setTrustedOnly(boolean trustedOnly) throws NotesApiException {
		this.trustedOnly = trustedOnly;
	}

	@Override
	public void setGroupAuthorizationOnly(boolean groupAuthorizationOnly) throws NotesApiException {
		this.groupAuthorizationOnly = groupAuthorizationOnly;
	}

	@Override
	public void setUseContextServer(boolean useContextServer) throws NotesApiException {
		this.useContextServer = useContextServer;
	}

	@Override
	public void setLimitMatches(boolean limitMatches) throws NotesApiException {
		this.limitMatches = limitMatches;
	}

	@Override
	public NotesDirectoryNavigator lookupNames(String view, String name, String item) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupNames(String view, Vector names, Vector items, boolean partialMatches) throws NotesApiException {
		this.partialMatches = partialMatches;
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String view, String item) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String view, Vector items) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getMailInfo(String userName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getMailInfo(String userName, boolean getVer, boolean errorOnMultipleMatches) throws NotesApiException {
		this.errorOnMultipleMatches = errorOnMultipleMatches;
		// TODO Auto-generated method stub
		return null;
	}
}