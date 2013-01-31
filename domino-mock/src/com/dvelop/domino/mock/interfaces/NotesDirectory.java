package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDirectory extends NotesBase {
	public abstract String getServer() throws NotesApiException;

	public abstract String getAvailableView() throws NotesApiException;

	public abstract Vector getAvailableNames() throws NotesApiException;

	public abstract Vector getAvailableItems() throws NotesApiException;

	public abstract boolean isSearchAllDirectories() throws NotesApiException;

	public abstract void setSearchAllDirectories(boolean flag)
			throws NotesApiException;

	public abstract boolean isTrustedOnly() throws NotesApiException;

	public abstract void setTrustedOnly(boolean flag) throws NotesApiException;

	public abstract boolean isGroupAuthorizationOnly() throws NotesApiException;

	public abstract void setGroupAuthorizationOnly(boolean flage)
			throws NotesApiException;

	public abstract boolean isUseContextServer() throws NotesApiException;

	public abstract void setUseContextServer(boolean flag)
			throws NotesApiException;

	public abstract boolean isPartialMatches() throws NotesApiException;

	public abstract boolean isLimitMatches() throws NotesApiException;

	public abstract void setLimitMatches(boolean arg0) throws NotesApiException;

	public abstract NotesDirectoryNavigator lookupNames(String view,
			String name, String item) throws NotesApiException;

	public abstract NotesDirectoryNavigator lookupNames(String view,
			Vector names, Vector items, boolean partialMatches)
			throws NotesApiException;

	public abstract NotesDirectoryNavigator lookupAllNames(String view,
			String item) throws NotesApiException;

	public abstract NotesDirectoryNavigator lookupAllNames(String view,
			Vector items) throws NotesApiException;

	public abstract NotesDirectoryNavigator createNavigator()
			throws NotesApiException;

	public abstract void freeLookupBuffer() throws NotesApiException;

	public abstract Vector getMailInfo(String userName)
			throws NotesApiException;

	public abstract Vector getMailInfo(String userName, boolean getVer,
			boolean errorOnMultipleMatches) throws NotesApiException;

}
