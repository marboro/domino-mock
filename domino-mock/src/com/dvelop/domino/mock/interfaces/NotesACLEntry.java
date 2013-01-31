package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesACLEntry extends NotesBase {
	public static final int TYPE_UNSPECIFIED = 0;
	public static final int TYPE_PERSON = 1;
	public static final int TYPE_SERVER = 2;
	public static final int TYPE_MIXED_GROUP = 3;
	public static final int TYPE_PERSON_GROUP = 4;
	public static final int TYPE_SERVER_GROUP = 5;

	public abstract void enableRole(String name) throws NotesApiException;

	public abstract void disableRole(String name) throws NotesApiException;

	public abstract boolean isRoleEnabled(String name) throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract Vector getRoles() throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract void setName(String name) throws NotesApiException;

	public abstract NotesName getNameObject() throws NotesApiException;

	public abstract void setName(NotesName name) throws NotesApiException;

	public abstract int getLevel() throws NotesApiException;

	public abstract void setLevel(int level) throws NotesApiException;

	public abstract int getUserType() throws NotesApiException;

	public abstract void setUserType(int userType) throws NotesApiException;

	public abstract boolean isCanCreatePersonalAgent() throws NotesApiException;

	public abstract void setCanCreatePersonalAgent(boolean flag)
			throws NotesApiException;

	public abstract boolean isCanCreatePersonalFolder()
			throws NotesApiException;

	public abstract void setCanCreatePersonalFolder(boolean flag)
			throws NotesApiException;

	public abstract boolean isCanCreateDocuments() throws NotesApiException;

	public abstract void setCanCreateDocuments(boolean flag)
			throws NotesApiException;

	public abstract boolean isCanDeleteDocuments() throws NotesApiException;

	public abstract void setCanDeleteDocuments(boolean flag)
			throws NotesApiException;

	public abstract NotesACL getParent() throws NotesApiException;

	public abstract boolean isPublicReader() throws NotesApiException;

	public abstract void setPublicReader(boolean flag) throws NotesApiException;

	public abstract boolean isPublicWriter() throws NotesApiException;

	public abstract void setPublicWriter(boolean flag) throws NotesApiException;

	public abstract boolean isCanCreateLSOrJavaAgent() throws NotesApiException;

	public abstract void setCanCreateLSOrJavaAgent(boolean flag)
			throws NotesApiException;

	public abstract boolean isServer() throws NotesApiException;

	public abstract void setServer(boolean flag) throws NotesApiException;

	public abstract boolean isPerson() throws NotesApiException;

	public abstract void setPerson(boolean flag) throws NotesApiException;

	public abstract boolean isGroup() throws NotesApiException;

	public abstract void setGroup(boolean flag) throws NotesApiException;

	public abstract boolean isCanCreateSharedFolder() throws NotesApiException;

	public abstract void setCanCreateSharedFolder(boolean flag)
			throws NotesApiException;

	public abstract boolean isAdminReaderAuthor() throws NotesApiException;

	public abstract void setAdminReaderAuthor(boolean flag)
			throws NotesApiException;

	public abstract boolean isAdminServer() throws NotesApiException;

	public abstract void setAdminServer(boolean flag) throws NotesApiException;

	public abstract boolean isCanReplicateOrCopyDocuments()
			throws NotesApiException;

	public abstract void setCanReplicateOrCopyDocuments(boolean flag)
			throws NotesApiException;

}