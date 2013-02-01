package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesForm;

public class NotesFormMockImpl extends NotesBaseMockImpl implements NotesForm {

	@Override
	public Vector getAliases() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getFields() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getFormUsers() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFormUsers(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getReaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReaders(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSubForm() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProtectReaders() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProtectReaders(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isProtectUsers() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProtectUsers(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFieldType(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lock() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() throws NotesApiException {
		// TODO Auto-generated method stub

	}
}