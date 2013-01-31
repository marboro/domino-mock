package com.dvelop.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesACL;
import com.dvelop.domino.mock.interfaces.NotesACLEntry;
import com.dvelop.domino.mock.interfaces.NotesDatabase;

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
		if (aclEntries.contains(aclEntries)) {
			int indexOf = aclEntries.indexOf(aclEntries);
			return aclEntries.get(indexOf);
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
		NotesACLEntryMockImpl aclEntry = new NotesACLEntryMockImpl(name, level,
				this);
		aclEntries.add(aclEntry);
		Collections.sort(aclEntries);
		return aclEntry;

	}

	@Override
	public Vector getRoles() throws NotesApiException {
		Vector<String> vector = new Vector<String>();
		for (String role : roles) {
			vector.add(role);
		}
		return vector;
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