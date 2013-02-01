package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesACL extends NotesBase {
	public static final int LEVEL_NOACCESS = 0;
	public static final int LEVEL_DEPOSITOR = 1;
	public static final int LEVEL_READER = 2;
	public static final int LEVEL_AUTHOR = 3;
	public static final int LEVEL_EDITOR = 4;
	public static final int LEVEL_DESIGNER = 5;
	public static final int LEVEL_MANAGER = 6;
	public static final int ACL_MAX_ROLES = 80;

	public abstract NotesACLEntry getFirstEntry() throws NotesApiException;

	public abstract NotesACLEntry getNextEntry(NotesACLEntry entry)
			throws NotesApiException;

	public abstract NotesACLEntry getNextEntry() throws NotesApiException;

	public abstract NotesACLEntry getEntry(String name)
			throws NotesApiException;

	public abstract int getInternetLevel() throws NotesApiException;

	public abstract void setInternetLevel(int level) throws NotesApiException;

	public abstract void save() throws NotesApiException;

	public abstract void renameRole(String oldName, String newName)
			throws NotesApiException;

	public abstract void addRole(String name) throws NotesApiException;

	public abstract void deleteRole(String name) throws NotesApiException;

	public abstract NotesACLEntry createACLEntry(String name, int level)
			throws NotesApiException;

	public abstract Vector getRoles() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;

	public abstract boolean isUniformAccess() throws NotesApiException;

	public abstract void setUniformAccess(boolean flag)
			throws NotesApiException;

	public abstract void removeACLEntry(String name) throws NotesApiException;

	public abstract boolean isExtendedAccess() throws NotesApiException;

	public abstract void setExtendedAccess(boolean flag)
			throws NotesApiException;

	public abstract boolean isAdminReaderAuthor() throws NotesApiException;

	public abstract void setAdminReaderAuthor(boolean flag)
			throws NotesApiException;

	public abstract boolean isAdminNames() throws NotesApiException;

	public abstract void setAdminNames(boolean flag) throws NotesApiException;

	public abstract String getAdministrationServer() throws NotesApiException;

	public abstract void setAdministrationServer(String serverName)
			throws NotesApiException;
}
