package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.Directory;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDirectory;
import com.dvelop.domino.mock.interfaces.NotesDirectoryNavigator;

public class NotesDirectoryProdImpl extends NotesBaseProdImpl implements
		NotesDirectory {

	private final Directory directory;

	public NotesDirectoryProdImpl(Directory directory) {
		this.directory = directory;
	}

	public Directory get() {
		return directory;
	}

	@Override
	public String getServer() throws NotesApiException {
		try {
			return directory.getServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAvailableView() throws NotesApiException {
		try {
			return directory.getAvailableView();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getAvailableNames() throws NotesApiException {
		try {
			return directory.getAvailableNames();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getAvailableItems() throws NotesApiException {
		try {
			return directory.getAvailableItems();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSearchAllDirectories() throws NotesApiException {
		try {
			return directory.isSearchAllDirectories();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSearchAllDirectories(boolean arg0) throws NotesApiException {
		try {
			directory.setSearchAllDirectories(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isTrustedOnly() throws NotesApiException {
		try {
			return directory.isTrustedOnly();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTrustedOnly(boolean arg0) throws NotesApiException {
		try {
			directory.setTrustedOnly(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isGroupAuthorizationOnly() throws NotesApiException {
		try {
			return directory.isGroupAuthorizationOnly();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setGroupAuthorizationOnly(boolean arg0)
			throws NotesApiException {
		try {
			directory.setGroupAuthorizationOnly(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isUseContextServer() throws NotesApiException {
		try {
			return directory.isUseContextServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUseContextServer(boolean arg0) throws NotesApiException {
		try {
			directory.setUseContextServer(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPartialMatches() throws NotesApiException {
		try {
			return directory.isPartialMatches();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isLimitMatches() throws NotesApiException {
		try {
			return directory.isLimitMatches();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLimitMatches(boolean arg0) throws NotesApiException {
		try {
			directory.setLimitMatches(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectoryNavigator lookupNames(String arg0, String arg1,
			String arg2) throws NotesApiException {
		try {
			return new NotesDirectoryNavigatorProdImpl(directory.lookupNames(
					arg0, arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectoryNavigator lookupNames(String arg0, Vector arg1,
			Vector arg2, boolean arg3) throws NotesApiException {
		try {
			return new NotesDirectoryNavigatorProdImpl(directory.lookupNames(
					arg0, arg1, arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesDirectoryNavigatorProdImpl(
					directory.lookupAllNames(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String arg0, Vector arg1)
			throws NotesApiException {
		try {
			return new NotesDirectoryNavigatorProdImpl(
					directory.lookupAllNames(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDirectoryNavigator createNavigator() throws NotesApiException {
		try {
			return new NotesDirectoryNavigatorProdImpl(
					directory.createNavigator());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void freeLookupBuffer() throws NotesApiException {
		try {
			directory.freeLookupBuffer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getMailInfo(String arg0) throws NotesApiException {
		try {
			return directory.getMailInfo(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getMailInfo(String arg0, boolean arg1, boolean arg2)
			throws NotesApiException {
		try {
			return directory.getMailInfo(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}