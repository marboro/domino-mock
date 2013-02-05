package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDirectory;
import com.dvelop.domino.mock.interfaces.NotesDirectoryNavigator;

public class NotesDirectoryMockImpl extends NotesBaseMockImpl implements
		NotesDirectory {

	@Override
	public String getServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
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
	public void setSearchAllDirectories(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isTrustedOnly() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTrustedOnly(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isGroupAuthorizationOnly() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGroupAuthorizationOnly(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isUseContextServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUseContextServer(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPartialMatches() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLimitMatches() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setLimitMatches(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDirectoryNavigator lookupNames(String arg0, String arg1,
			String arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupNames(String arg0, Vector arg1,
			Vector arg2, boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String arg0, Vector arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDirectoryNavigator createNavigator() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void freeLookupBuffer() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getMailInfo(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getMailInfo(String arg0, boolean arg1, boolean arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}