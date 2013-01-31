package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesACL;
import com.dvelop.domino.mock.interfaces.NotesACLEntry;
import com.dvelop.domino.mock.interfaces.NotesDatabase;

public class NotesACLMockImpl extends NotesBaseMockImpl implements NotesACL {

	@Override
	public NotesACLEntry getFirstEntry() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesACLEntry getNextEntry(NotesACLEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesACLEntry getNextEntry() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesACLEntry getEntry(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getInternetLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setInternetLevel(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void save() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void renameRole(String arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addRole(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteRole(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesACLEntry createACLEntry(String arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getRoles() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUniformAccess() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setUniformAccess(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeACLEntry(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isExtendedAccess() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setExtendedAccess(boolean arg0) throws NotesApiException {
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
	public boolean isAdminNames() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setAdminNames(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getAdministrationServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setAdministrationServer(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}