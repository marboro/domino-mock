package org.openntf.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDirectory;
import org.openntf.domino.mock.interfaces.NotesDirectoryNavigator;

public class NotesDirectoryMockImpl extends NotesBaseMockImpl implements NotesDirectory {

	private final String server;
	private boolean searchAllDirectories;
	private boolean trustedOnly;
	private boolean groupAuthorizationOnly;
	private boolean useContextServer;
	private boolean limitMatches;
	private boolean partialMatches;
	private String availableView = null;
	private Vector<String> availableNames = null;
	private Vector<String> items = null;
	private List<NotesDirectoryNavigator> dirNavs;

	public NotesDirectoryMockImpl() {
		this("");
	}

	public NotesDirectoryMockImpl(String server) {
		this.server = server;
		dirNavs = new ArrayList<NotesDirectoryNavigator>();
	}

	@Override
	public String getServer() throws NotesApiException {
		return server;
	}

	@Override
	public String getAvailableView() throws NotesApiException {
		return availableView;
	}

	@Override
	public Vector<String> getAvailableNames() throws NotesApiException {
		return availableNames;
	}

	@Override
	public Vector<String> getAvailableItems() throws NotesApiException {
		return items;
	}

	@Override
	public boolean isSearchAllDirectories() throws NotesApiException {
		return searchAllDirectories;
	}

	@Override
	public boolean isTrustedOnly() throws NotesApiException {
		return trustedOnly;
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
		NotesDirectoryNavigatorMockImpl directoryNavigator = new NotesDirectoryNavigatorMockImpl();
		dirNavs.add(directoryNavigator);
		return directoryNavigator;
	}

	@Override
	public void freeLookupBuffer() throws NotesApiException {
		for (NotesDirectoryNavigator dirNav : dirNavs) {
			NotesDirectoryNavigatorMockImpl nav = (NotesDirectoryNavigatorMockImpl) dirNav;
			nav.recycle();
		}
		dirNavs.clear();
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
		Vector<String> names = new Vector<String>();
		names.add(name);
		Vector<String> items = new Vector<String>();
		items.add(item);
		return lookupNames(view, names, items, false);
	}

	@Override
	public NotesDirectoryNavigator lookupNames(String view, Vector<String> names, Vector<String> items, boolean partialMatches) throws NotesApiException {
		availableView = view;
		this.items = items;
		this.partialMatches = partialMatches;
		// TODO Auto-generated method stub
		Vector<String> vector = new Vector<String>();
		availableNames = vector;
		return null;
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String view, String item) throws NotesApiException {
		Vector<String> vector = new Vector<String>();
		vector.add(item);
		return lookupAllNames(view, vector);
	}

	@Override
	public NotesDirectoryNavigator lookupAllNames(String view, Vector<String> items) throws NotesApiException {
		availableView = view;
		this.items = items;
		// TODO Auto-generated method stub
		Vector<String> vector = new Vector<String>();
		availableNames = vector;
		return null;
	}

	@Override
	public Vector getMailInfo(String userName) throws NotesApiException {
		return getMailInfo(userName, false, true);
	}

	@Override
	public Vector getMailInfo(String userName, boolean getVer, boolean errorOnMultipleMatches) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}