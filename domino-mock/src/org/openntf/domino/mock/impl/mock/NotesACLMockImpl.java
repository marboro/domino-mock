package org.openntf.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesACL;
import org.openntf.domino.mock.interfaces.NotesACLEntry;
import org.openntf.domino.mock.interfaces.NotesDatabase;

/**
 * Mock-Implementation of NotesACL
 * 
 * @author Sven Dreher
 * @see NotesACL
 */
public class NotesACLMockImpl extends NotesBaseMockImpl implements NotesACL {

	private List<NotesACLEntryMockImpl> aclEntries;
	private int currentEntry;
	private int internLevel;
	private List<String> roles;
	private final NotesDatabaseMockImpl parent;
	private boolean uniformAccess;
	private boolean extendedAccess;
	private boolean adminReaderAuthor;
	private boolean adminNames;
	private String administrationServerName;

	/**
	 * @param parent
	 *            The parent database for this ACL
	 */
	public NotesACLMockImpl(NotesDatabaseMockImpl parent) {
		this.parent = parent;
		aclEntries = new ArrayList<NotesACLEntryMockImpl>();
		roles = new ArrayList<String>();
	}

	@Override
	public NotesACLEntry getFirstEntry() throws NotesApiException {
		if (aclEntries.size() > 0) {
			currentEntry = 0;
			return aclEntries.get(0);
		}
		return null;
	}

	@Override
	public NotesACLEntry getNextEntry(NotesACLEntry entry)
			throws NotesApiException {
		if (aclEntries.contains(entry)) {
			int indexOf = aclEntries.indexOf(entry);
			currentEntry = indexOf;
			return aclEntries.get(indexOf + 1);
		}
		return null;
	}

	@Override
	public NotesACLEntry getNextEntry() throws NotesApiException {
		if (aclEntries.size() > currentEntry + 1) {
			currentEntry++;
			return aclEntries.get(currentEntry);
		}
		return null;
	}

	@Override
	public NotesACLEntry getEntry(String name) throws NotesApiException {
		if ("".equals(name)) {
			throw new NotesApiException(new IllegalArgumentException(
					"No Name given"));
		}
		for (NotesACLEntryMockImpl aclEntry : aclEntries) {
			if (aclEntry.getName().compareTo(name) == 0) {
				return aclEntry;
			}
		}
		return null;
	}

	@Override
	public int getInternetLevel() throws NotesApiException {
		return internLevel;
	}

	@Override
	public void setInternetLevel(int internLevel) throws NotesApiException {
		this.internLevel = internLevel;

	}

	@Override
	public void save() throws NotesApiException {

	}

	@Override
	public void renameRole(String oldName, String newName)
			throws NotesApiException {
		roles.remove(oldName);
		roles.add(newName);
		Collections.sort(roles);
		for (NotesACLEntryMockImpl aclEntry : aclEntries) {
			if (aclEntry.isRoleEnabled(oldName)) {
				aclEntry.disableRole(oldName);
				aclEntry.enableRole(newName);
			}
		}

	}

	@Override
	public void addRole(String name) throws NotesApiException {
		roles.add(name);
		Collections.sort(roles);
	}

	@Override
	public void deleteRole(String name) throws NotesApiException {
		roles.remove(name);
		Collections.sort(roles);
		for (NotesACLEntryMockImpl aclEntry : aclEntries) {
			if (aclEntry.isRoleEnabled(name)) {
				aclEntry.disableRole(name);
			}
		}
	}

	@Override
	public NotesACLEntry createACLEntry(String name, int level)
			throws NotesApiException {
		NotesACLEntryMockImpl aclEntry = null;
		for (NotesACLEntry entry : aclEntries) {
			NotesACLEntryMockImpl current = (NotesACLEntryMockImpl) entry;
			if (current.getName().compareTo(name) == 0) {
				aclEntry = current;
			}
		}
		if (aclEntry != null) {
			aclEntries.remove(aclEntry);
			aclEntry.setLevel(level);
		} else {
			aclEntry = new NotesACLEntryMockImpl(name, level, this);
		}
		aclEntries.add(aclEntry);
		Collections.sort(aclEntries);
		return aclEntry;

	}

	@Override
	public Vector<String> getRoles() throws NotesApiException {
		return new Vector<String>(roles);
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		return parent;

	}

	@Override
	public boolean isUniformAccess() throws NotesApiException {
		return uniformAccess;

	}

	@Override
	public void setUniformAccess(boolean uniformAccess)
			throws NotesApiException {
		this.uniformAccess = uniformAccess;
	}

	@Override
	public void removeACLEntry(String name) throws NotesApiException {
		if ("".equals(name)) {
			throw new NotesApiException(new IllegalArgumentException(
					"No Name given"));
		}
		for (NotesACLEntryMockImpl aclEntry : aclEntries) {
			if (aclEntry.getName().compareTo(name) == 0) {
				aclEntries.remove(aclEntry);
				break;
			}
		}

	}

	@Override
	public boolean isExtendedAccess() throws NotesApiException {
		return extendedAccess;

	}

	@Override
	public void setExtendedAccess(boolean extendedAccess)
			throws NotesApiException {
		this.extendedAccess = extendedAccess;

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
	public boolean isAdminNames() throws NotesApiException {
		return adminNames;
	}

	@Override
	public void setAdminNames(boolean adminNames) throws NotesApiException {
		this.adminNames = adminNames;

	}

	@Override
	public String getAdministrationServer() throws NotesApiException {
		return administrationServerName;
	}

	@Override
	public void setAdministrationServer(String administrationServerName)
			throws NotesApiException {
		this.administrationServerName = administrationServerName;
	}

}