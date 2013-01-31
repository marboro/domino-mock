package com.dvelop.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesACL;
import com.dvelop.domino.mock.interfaces.NotesACLEntry;
import com.dvelop.domino.mock.interfaces.NotesName;

public class NotesACLEntryMockImpl extends NotesBaseMockImpl implements
		NotesACLEntry, Comparable<NotesACLEntryMockImpl> {

	private final String entryName;
	private final int entryLevel;
	private final NotesACLMockImpl parent;
	private List<String> roles;

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
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getRoles() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesName getNameObject() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(NotesName name) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLevel(int level) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUserType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUserType(int userType) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreatePersonalAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreatePersonalAgent(boolean flag)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreatePersonalFolder() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreatePersonalFolder(boolean flag)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreateDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreateDocuments(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanDeleteDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanDeleteDocuments(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesACL getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public boolean isPublicReader() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPublicReader(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPublicWriter() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPublicWriter(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreateLSOrJavaAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreateLSOrJavaAgent(boolean flag)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setServer(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPerson() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPerson(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isGroup() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGroup(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreateSharedFolder() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreateSharedFolder(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAdminReaderAuthor() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAdminReaderAuthor(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAdminServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAdminServer(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanReplicateOrCopyDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanReplicateOrCopyDocuments(boolean flag)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int compareTo(NotesACLEntryMockImpl aclEntry) {
		return this.entryName.compareTo(aclEntry.entryName);
	}

}