package org.openntf.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesACL;
import org.openntf.domino.mock.interfaces.NotesACLEntry;
import org.openntf.domino.mock.interfaces.NotesName;

/**
 * Mock-Implementation of NotesACLEntry
 * 
 * @author Sven Dreher
 * @see NotesACLEntry
 */
public class NotesACLEntryMockImpl extends NotesBaseMockImpl implements
		NotesACLEntry, Comparable<NotesACLEntryMockImpl> {

	private String entryName;
	private int entryLevel;
	private final NotesACLMockImpl parent;
	private List<String> roles;
	private NotesName nameObject;
	private int userType;
	private boolean canCreatePersonalAgent;
	private boolean canCreatePersonalFolder;
	private boolean canCreateDocuments;
	private boolean canDeleteDocuments;
	private boolean publicReader;
	private boolean publicWriter;
	private boolean canCreateLSOrJavaAgent;
	private boolean isServer;
	private boolean isPerson;
	private boolean isGroup;
	private boolean canCreateSharedFolder;
	private boolean adminReaderAuthor;
	private boolean adminServer;
	private boolean canReplicateOrCopyDocuments;

	/**
	 * @param entryName
	 *            The name of the ACLEntry
	 * @param entryLevel
	 *            The accesslevel of the ACLEntry
	 * @param parent
	 *            The acl for this Entry
	 */
	public NotesACLEntryMockImpl(String entryName, int entryLevel,
			NotesACLMockImpl parent) {
		this.entryName = entryName;
		this.entryLevel = entryLevel;
		this.parent = parent;
		roles = new ArrayList<String>();
	}

	@Override
	public void enableRole(String name) throws NotesApiException {
		roles.add(name);

	}

	@Override
	public void disableRole(String name) throws NotesApiException {
		roles.remove(name);

	}

	@Override
	public boolean isRoleEnabled(String name) throws NotesApiException {
		return roles.contains(name);
	}

	@Override
	public void remove() throws NotesApiException {
		parent.removeACLEntry(entryName);

	}

	@Override
	public Vector<String> getRoles() throws NotesApiException {
		return new Vector<String>(roles);
	}

	@Override
	public String getName() throws NotesApiException {
		return entryName;
	}

	@Override
	public void setName(String name) throws NotesApiException {
		this.entryName = name;

	}

	@Override
	public NotesName getNameObject() throws NotesApiException {
		return nameObject;
	}

	@Override
	public void setName(NotesName nameObject) throws NotesApiException {
		this.nameObject = nameObject;
	}

	@Override
	public int getLevel() throws NotesApiException {
		return entryLevel;
	}

	@Override
	public void setLevel(int level) throws NotesApiException {
		this.entryLevel = level;

	}

	@Override
	public int getUserType() throws NotesApiException {
		return userType;

	}

	@Override
	public void setUserType(int userType) throws NotesApiException {
		this.userType = userType;

	}

	@Override
	public boolean isCanCreatePersonalAgent() throws NotesApiException {
		return canCreatePersonalAgent;
	}

	@Override
	public void setCanCreatePersonalAgent(boolean canCreatePersonalAgent)
			throws NotesApiException {
		this.canCreatePersonalAgent = canCreatePersonalAgent;
	}

	@Override
	public boolean isCanCreatePersonalFolder() throws NotesApiException {
		return canCreatePersonalFolder;
	}

	@Override
	public void setCanCreatePersonalFolder(boolean canCreatePersonalFolder)
			throws NotesApiException {
		this.canCreatePersonalFolder = canCreatePersonalFolder;
	}

	@Override
	public boolean isCanCreateDocuments() throws NotesApiException {
		return canCreateDocuments;
	}

	@Override
	public void setCanCreateDocuments(boolean canCreateDocuments)
			throws NotesApiException {
		this.canCreateDocuments = canCreateDocuments;
	}

	@Override
	public boolean isCanDeleteDocuments() throws NotesApiException {
		return canDeleteDocuments;
	}

	@Override
	public void setCanDeleteDocuments(boolean canDeleteDocuments)
			throws NotesApiException {
		this.canDeleteDocuments = canDeleteDocuments;
	}

	@Override
	public NotesACL getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public boolean isPublicReader() throws NotesApiException {
		return publicReader;
	}

	@Override
	public void setPublicReader(boolean publicReader) throws NotesApiException {
		this.publicReader = publicReader;
	}

	@Override
	public boolean isPublicWriter() throws NotesApiException {
		return publicWriter;
	}

	@Override
	public void setPublicWriter(boolean publicWriter) throws NotesApiException {
		this.publicWriter = publicWriter;
	}

	@Override
	public boolean isCanCreateLSOrJavaAgent() throws NotesApiException {
		return canCreateLSOrJavaAgent;
	}

	@Override
	public void setCanCreateLSOrJavaAgent(boolean canCreateLSOrJavaAgent)
			throws NotesApiException {
		this.canCreateLSOrJavaAgent = canCreateLSOrJavaAgent;
	}

	@Override
	public boolean isServer() throws NotesApiException {
		return isServer;
	}

	@Override
	public void setServer(boolean isServer) throws NotesApiException {
		this.isServer = isServer;
	}

	@Override
	public boolean isPerson() throws NotesApiException {
		return isPerson;
	}

	@Override
	public void setPerson(boolean isPerson) throws NotesApiException {
		this.isPerson = isPerson;
	}

	@Override
	public boolean isGroup() throws NotesApiException {
		return isGroup;
	}

	@Override
	public void setGroup(boolean isGroup) throws NotesApiException {
		this.isGroup = isGroup;
	}

	@Override
	public boolean isCanCreateSharedFolder() throws NotesApiException {
		return canCreateSharedFolder;
	}

	@Override
	public void setCanCreateSharedFolder(boolean canCreateSharedFolder)
			throws NotesApiException {
		this.canCreateSharedFolder = canCreateSharedFolder;
	}

	@Override
	public boolean isAdminReaderAuthor() throws NotesApiException {
		return adminReaderAuthor;
	}

	@Override
	public void setAdminReaderAuthor(boolean adminReaderAuthor)
			throws NotesApiException {
		this.adminReaderAuthor = adminReaderAuthor;
	}

	@Override
	public boolean isAdminServer() throws NotesApiException {
		return adminServer;
	}

	@Override
	public void setAdminServer(boolean adminServer) throws NotesApiException {
		this.adminServer = adminServer;
	}

	@Override
	public boolean isCanReplicateOrCopyDocuments() throws NotesApiException {
		return canReplicateOrCopyDocuments;
	}

	@Override
	public void setCanReplicateOrCopyDocuments(
			boolean canReplicateOrCopyDocuments) throws NotesApiException {
		this.canReplicateOrCopyDocuments = canReplicateOrCopyDocuments;
	}

	@Override
	public int compareTo(NotesACLEntryMockImpl aclEntry) {
		return this.entryName.compareTo(aclEntry.entryName);
	}

	@Override
	public String toString() {
		return entryName;
	}

}