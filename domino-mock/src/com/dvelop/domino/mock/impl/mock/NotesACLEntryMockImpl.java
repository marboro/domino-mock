package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesACL;
import com.dvelop.domino.mock.interfaces.NotesACLEntry;
import com.dvelop.domino.mock.interfaces.NotesName;

public class NotesACLEntryMockImpl extends NotesBaseMockImpl implements
		NotesACLEntry {

	@Override
	public void enableRole(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void disableRole(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isRoleEnabled(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
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
	public void setName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesName getNameObject() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(NotesName arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLevel(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUserType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUserType(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreatePersonalAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreatePersonalAgent(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreatePersonalFolder() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreatePersonalFolder(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreateDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreateDocuments(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanDeleteDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanDeleteDocuments(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesACL getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPublicReader() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPublicReader(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPublicWriter() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPublicWriter(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreateLSOrJavaAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreateLSOrJavaAgent(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setServer(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPerson() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPerson(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isGroup() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setGroup(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanCreateSharedFolder() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanCreateSharedFolder(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAdminReaderAuthor() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAdminReaderAuthor(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isAdminServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAdminServer(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isCanReplicateOrCopyDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setCanReplicateOrCopyDocuments(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}
}