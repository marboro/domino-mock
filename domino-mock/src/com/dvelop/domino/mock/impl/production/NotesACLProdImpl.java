package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.ACL;
import lotus.domino.Base;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesACL;
import com.dvelop.domino.mock.interfaces.NotesACLEntry;
import com.dvelop.domino.mock.interfaces.NotesDatabase;

public class NotesACLProdImpl extends NotesBaseProdImpl implements NotesACL {

	private final ACL acl;

	public NotesACLProdImpl(ACL acl) {
		this.acl = acl;
	}

	public Base get() {
		return acl;
	}

	@Override
	public NotesACLEntry getFirstEntry() throws NotesApiException {
		try {
			return new NotesACLEntryProdImpl(acl.getFirstEntry());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesACLEntry getNextEntry(NotesACLEntry arg0)
			throws NotesApiException {
		try {
			NotesACLEntryProdImpl aclEntry = (NotesACLEntryProdImpl) arg0;
			return new NotesACLEntryProdImpl(acl.getNextEntry(aclEntry.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesACLEntry getNextEntry() throws NotesApiException {
		try {
			return new NotesACLEntryProdImpl(acl.getNextEntry());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesACLEntry getEntry(String arg0) throws NotesApiException {
		try {
			return new NotesACLEntryProdImpl(acl.getEntry(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getInternetLevel() throws NotesApiException {
		try {
			return acl.getInternetLevel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setInternetLevel(int arg0) throws NotesApiException {
		try {
			acl.setInternetLevel(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void save() throws NotesApiException {
		try {
			acl.save();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void renameRole(String arg0, String arg1) throws NotesApiException {
		try {
			acl.renameRole(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addRole(String arg0) throws NotesApiException {
		try {
			acl.addRole(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void deleteRole(String arg0) throws NotesApiException {
		try {
			acl.deleteRole(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesACLEntry createACLEntry(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesACLEntryProdImpl(acl.createACLEntry(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getRoles() throws NotesApiException { // Strings
		try {
			return acl.getRoles();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(acl.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isUniformAccess() throws NotesApiException {
		try {
			return acl.isUniformAccess();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUniformAccess(boolean arg0) throws NotesApiException {
		try {
			acl.setUniformAccess(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeACLEntry(String arg0) throws NotesApiException {
		try {
			acl.removeACLEntry(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isExtendedAccess() throws NotesApiException {
		try {
			return acl.isExtendedAccess();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setExtendedAccess(boolean arg0) throws NotesApiException {
		try {
			acl.setExtendedAccess(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isAdminReaderAuthor() throws NotesApiException {
		try {
			return acl.isAdminReaderAuthor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAdminReaderAuthor(boolean arg0) throws NotesApiException {
		try {
			acl.setAdminReaderAuthor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isAdminNames() throws NotesApiException {
		try {
			return acl.isAdminNames();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAdminNames(boolean arg0) throws NotesApiException {
		try {
			acl.setAdminNames(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getAdministrationServer() throws NotesApiException {
		try {
			return acl.getAdministrationServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAdministrationServer(String arg0) throws NotesApiException {
		try {
			acl.setAdministrationServer(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}