package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

/**
 * Represents the access control list (ACL) of a database.
 * 
 * @author Sven Dreher
 * @see lotus.domino.ACL
 */
public interface NotesACL extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int LEVEL_NOACCESS = 0;
	/**
	 * {@value}
	 */
	public static final int LEVEL_DEPOSITOR = 1;
	/**
	 * {@value}
	 */
	public static final int LEVEL_READER = 2;
	/**
	 * {@value}
	 */
	public static final int LEVEL_AUTHOR = 3;
	/**
	 * {@value}
	 */
	public static final int LEVEL_EDITOR = 4;
	/**
	 * {@value}
	 */
	public static final int LEVEL_DESIGNER = 5;
	/**
	 * {@value}
	 */
	public static final int LEVEL_MANAGER = 6;
	/**
	 * {@value}
	 */
	public static final int ACL_MAX_ROLES = 80;

	/**
	 * Returns the first entry in an ACL.
	 * 
	 * @return The first entry in the ACL.
	 * @throws NotesApiException
	 */
	public abstract NotesACLEntry getFirstEntry() throws NotesApiException;

	/**
	 * Returns the next ACL entry or the one following a specified entry.
	 * 
	 * @param entry
	 *            Any entry in the ACL. Cannot be null.
	 * @return The ACL entry following the entry specified as the parameter.
	 *         Returns null if there are no more entries.
	 * @throws NotesApiException
	 */
	public abstract NotesACLEntry getNextEntry(NotesACLEntry entry)
			throws NotesApiException;

	/**
	 * Returns the next ACL entry or the one following a specified entry.
	 * 
	 * @return Any entry in the ACL. Cannot be null.
	 * @throws NotesApiException
	 */
	public abstract NotesACLEntry getNextEntry() throws NotesApiException;

	/**
	 * Given a name, finds its entry in an ACL.
	 * 
	 * @param name
	 *            The name whose ACL entry you want to find. You must supply the
	 *            complete name, but hierarchical names can be in abbreviated
	 *            format. Case is not significant.
	 * @return The ACL entry following the entry specified as the parameter.
	 *         Returns null if there are no more entries.
	 * @throws NotesApiException
	 */
	public abstract NotesACLEntry getEntry(String name)
			throws NotesApiException;

	/**
	 * The maximum Internet access level for this database.
	 * 
	 * @return The maximum Internet access level for this database.
	 *         ACL.LEVEL_NOACCESS, ACL.LEVEL_DEPOSITOR, ACL.LEVEL_READER
	 *         ACL.LEVEL_AUTHOR, ACL.LEVEL_EDITOR, ACL.LEVEL_DESIGNER,
	 *         ACL.LEVEL_MANAGER
	 * 
	 * @throws NotesApiException
	 */
	public abstract int getInternetLevel() throws NotesApiException;

	/**
	 * The maximum Internet access level for this database.
	 * 
	 * @param level
	 *            ACL.LEVEL_NOACCESS, ACL.LEVEL_DEPOSITOR, ACL.LEVEL_READER
	 *            ACL.LEVEL_AUTHOR, ACL.LEVEL_EDITOR, ACL.LEVEL_DESIGNER,
	 *            ACL.LEVEL_MANAGER
	 * @throws NotesApiException
	 */
	public abstract void setInternetLevel(int level) throws NotesApiException;

	/**
	 * Saves changes that you've made to the ACL. If you don't call save before
	 * closing a database, the changes you've made to its ACL are lost.
	 * 
	 * @throws NotesApiException
	 */
	public abstract void save() throws NotesApiException;

	/**
	 * Changes the name of a role.
	 * 
	 * @param oldName
	 *            The current name of the role. Do not put square brackets
	 *            around the name.
	 * @param newName
	 *            The new name you want to give to the role. Do not specify the
	 *            brackets
	 * @throws NotesApiException
	 */
	public abstract void renameRole(String oldName, String newName)
			throws NotesApiException;

	/**
	 * Adds a role to an ACL.
	 * 
	 * @param name
	 *            The name of the new role. Do not put square brackets around
	 *            the name.
	 * @throws NotesApiException
	 */
	public abstract void addRole(String name) throws NotesApiException;

	/**
	 * Deletes a role from an ACL and removes it from any ACL entries that have
	 * it.
	 * 
	 * @param name
	 *            The name of the role to remove. Do not put square brackets
	 *            around the name.
	 * @throws NotesApiException
	 */
	public abstract void deleteRole(String name) throws NotesApiException;

	/**
	 * Creates an entry in the ACL with the name and level that you specify.
	 * 
	 * @param name
	 *            The name of the person, group, or server for whom you want to
	 *            create an entry in the ACL. You must supply the complete name,
	 *            but hierarchical names can be in abbreviated format. Case is
	 *            not significant.
	 * @param level
	 *            The level that you want to assign to this person, group, or
	 *            server in the ACL. May be any of the following:
	 *            ACL.LEVEL_NOACCESS, ACL.LEVEL_DEPOSITOR, ACL.LEVEL_READER
	 *            ACL.LEVEL_AUTHOR, ACL.LEVEL_EDITOR, ACL.LEVEL_DESIGNER,
	 *            ACL.LEVEL_MANAGER
	 * 
	 * @return The newly-created entry.
	 * @throws NotesApiException
	 */
	public abstract NotesACLEntry createACLEntry(String name, int level)
			throws NotesApiException;

	/**
	 * All the roles defined in an access control list.
	 * 
	 * @return All the roles defined in an access control list.
	 * @throws NotesApiException
	 */
	public abstract Vector getRoles() throws NotesApiException;

	/**
	 * The database that owns an ACL.
	 * 
	 * @return The database that owns an ACL.
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase getParent() throws NotesApiException;

	/**
	 * Indicates whether a consistent access control list is enforced across all
	 * replicas of a database.
	 * 
	 * @return {@code true} indicates that uniform access is set {@code false}
	 *         indicates that uniform access is not set
	 * 
	 * @throws NotesApiException
	 */
	public abstract boolean isUniformAccess() throws NotesApiException;

	/**
	 * Indicates whether a consistent access control list is enforced across all
	 * replicas of a database.
	 * 
	 * @param flag
	 *            {@code true} indicates that uniform access is set
	 *            {@code false} indicates that uniform access is not set
	 * @throws NotesApiException
	 */
	public abstract void setUniformAccess(boolean flag)
			throws NotesApiException;

	/**
	 * Removes an entry from the ACL.
	 * 
	 * @param name
	 *            The name of the person, group, or server whose entry you want
	 *            to remove. You must supply the complete name, but hierarchical
	 *            names can be in abbreviated format. Case is not significant.
	 * @throws NotesApiException
	 */
	public abstract void removeACLEntry(String name) throws NotesApiException;

	/**
	 * Indicates whether extended access is enabled.
	 * 
	 * @return {@code true} if extended access is enabled {@code false} if
	 *         extended access is disabled
	 * @throws NotesApiException
	 */
	public abstract boolean isExtendedAccess() throws NotesApiException;

	/**
	 * Indicates whether extended access is enabled.
	 * 
	 * @param flag
	 *            {@code true} if extended access is enabled {@code false} if
	 *            extended access is disabled
	 * @throws NotesApiException
	 */
	public abstract void setExtendedAccess(boolean flag)
			throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * Readers and Authors fields in a database.
	 * 
	 * @return {@code true} if the administration server can modify Readers and
	 *         Authors fields {@code false} if the administration server cannot
	 *         modify Readers and Authors fields
	 * @throws NotesApiException
	 */
	public abstract boolean isAdminReaderAuthor() throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * Readers and Authors fields in a database.
	 * 
	 * @param flag
	 *            {@code true} if the administration server can modify Readers
	 *            and Authors fields {@code false} if the administration server
	 *            cannot modify Readers and Authors fields
	 * @throws NotesApiException
	 */
	public abstract void setAdminReaderAuthor(boolean flag)
			throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * all Names fields in a database.
	 * 
	 * @return {@code true} if the administration server can modify Names fields
	 *         {@code false} if the administration server cannot modify Names
	 *         fields
	 * @throws NotesApiException
	 */
	public abstract boolean isAdminNames() throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * all Names fields in a database.
	 * 
	 * @param flag
	 *            {@code true} if the administration server can modify Names
	 *            fields {@code false} if the administration server cannot
	 *            modify Names fields
	 * @throws NotesApiException
	 */
	public abstract void setAdminNames(boolean flag) throws NotesApiException;

	/**
	 * The name of the administration server for a database.
	 * 
	 * @return The name of the administration server for a database.
	 * @throws NotesApiException
	 */
	public abstract String getAdministrationServer() throws NotesApiException;

	/**
	 * The name of the administration server for a database.
	 * 
	 * @param serverName
	 *            The name of the administration server for a database.
	 * 
	 * @throws NotesApiException
	 */
	public abstract void setAdministrationServer(String serverName)
			throws NotesApiException;
}
