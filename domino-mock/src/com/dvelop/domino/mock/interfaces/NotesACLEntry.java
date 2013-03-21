package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

/**
 * Represents a single entry in an access control list. An entry may be for a
 * person, a group, or a server.
 * 
 * @author Sven Dreher
 * @see lotus.domino.ACLEntry
 */
public interface NotesACLEntry extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int TYPE_UNSPECIFIED = 0;
	/**
	 * {@value}
	 */
	public static final int TYPE_PERSON = 1;
	/**
	 * {@value}
	 */
	public static final int TYPE_SERVER = 2;
	/**
	 * {@value}
	 */
	public static final int TYPE_MIXED_GROUP = 3;
	/**
	 * {@value}
	 */
	public static final int TYPE_PERSON_GROUP = 4;
	/**
	 * {@value}
	 */
	public static final int TYPE_SERVER_GROUP = 5;

	/**
	 * Disables a role for an entry.
	 * 
	 * @param name
	 *            The name of the role to disable. Do not specify the brackets.
	 * @throws NotesApiException
	 */
	public abstract void enableRole(String name) throws NotesApiException;

	/**
	 * Enables a role for an entry.
	 * 
	 * @param name
	 *            The name of the role to enable. Do not specify the brackets.
	 * @throws NotesApiException
	 */
	public abstract void disableRole(String name) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isRoleEnabled(String name) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void remove() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getRoles() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getName() throws NotesApiException;

	/**
	 * @param name
	 * @throws NotesApiException
	 */
	public abstract void setName(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesName getNameObject() throws NotesApiException;

	/**
	 * @param name
	 * @throws NotesApiException
	 */
	public abstract void setName(NotesName name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getLevel() throws NotesApiException;

	/**
	 * @param level
	 * @throws NotesApiException
	 */
	public abstract void setLevel(int level) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getUserType() throws NotesApiException;

	/**
	 * @param userType
	 * @throws NotesApiException
	 */
	public abstract void setUserType(int userType) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanCreatePersonalAgent() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanCreatePersonalAgent(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanCreatePersonalFolder()
			throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanCreatePersonalFolder(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanCreateDocuments() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanCreateDocuments(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanDeleteDocuments() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanDeleteDocuments(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesACL getParent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPublicReader() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setPublicReader(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPublicWriter() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setPublicWriter(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanCreateLSOrJavaAgent() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanCreateLSOrJavaAgent(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isServer() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setServer(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPerson() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setPerson(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isGroup() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setGroup(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanCreateSharedFolder() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanCreateSharedFolder(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isAdminReaderAuthor() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setAdminReaderAuthor(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isAdminServer() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setAdminServer(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCanReplicateOrCopyDocuments()
			throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setCanReplicateOrCopyDocuments(boolean flag)
			throws NotesApiException;

}