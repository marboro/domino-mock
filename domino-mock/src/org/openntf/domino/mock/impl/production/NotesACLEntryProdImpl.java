package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesACL;
import org.openntf.domino.mock.interfaces.NotesACLEntry;
import org.openntf.domino.mock.interfaces.NotesName;

import lotus.domino.ACLEntry;
import lotus.domino.NotesException;


public class NotesACLEntryProdImpl extends NotesBaseProdImpl implements
		NotesACLEntry {

	private final ACLEntry aclEntry;

	public NotesACLEntryProdImpl(ACLEntry aclEntry) {
		this.aclEntry = aclEntry;
	}

	public ACLEntry get() {
		return aclEntry;
	}

	@Override
	public void enableRole(String arg0) throws NotesApiException {
		try {
			aclEntry.enableRole(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void disableRole(String arg0) throws NotesApiException {
		try {
			aclEntry.disableRole(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isRoleEnabled(String arg0) throws NotesApiException {
		try {
			return aclEntry.isRoleEnabled(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			aclEntry.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getRoles() throws NotesApiException { // Strings
		try {
			return aclEntry.getRoles();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getName() throws NotesApiException {
		try {
			return aclEntry.getName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setName(String arg0) throws NotesApiException {
		try {
			aclEntry.setName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesName getNameObject() throws NotesApiException {
		try {
			return new NotesNameProdImpl(aclEntry.getNameObject());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setName(NotesName arg0) throws NotesApiException {
		try {
			NotesNameProdImpl name = (NotesNameProdImpl) arg0;
			aclEntry.setName(name.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getLevel() throws NotesApiException {
		try {
			return aclEntry.getLevel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLevel(int arg0) throws NotesApiException {
		try {
			aclEntry.setLevel(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getUserType() throws NotesApiException {
		try {
			return aclEntry.getUserType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUserType(int arg0) throws NotesApiException {
		try {
			aclEntry.setUserType(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanCreatePersonalAgent() throws NotesApiException {
		try {
			return aclEntry.isCanCreatePersonalAgent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanCreatePersonalAgent(boolean arg0)
			throws NotesApiException {
		try {
			aclEntry.setCanCreatePersonalAgent(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanCreatePersonalFolder() throws NotesApiException {
		try {
			return aclEntry.isCanCreatePersonalFolder();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanCreatePersonalFolder(boolean arg0)
			throws NotesApiException {
		try {
			aclEntry.setCanCreatePersonalFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanCreateDocuments() throws NotesApiException {
		try {
			return aclEntry.isCanCreateDocuments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanCreateDocuments(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setCanCreateDocuments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanDeleteDocuments() throws NotesApiException {
		try {
			return aclEntry.isCanDeleteDocuments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanDeleteDocuments(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setCanDeleteDocuments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesACL getParent() throws NotesApiException {
		try {
			return new NotesACLProdImpl(aclEntry.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPublicReader() throws NotesApiException {
		try {
			return aclEntry.isPublicReader();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPublicReader(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setPublicReader(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isPublicWriter() throws NotesApiException {
		try {
			return aclEntry.isPublicWriter();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPublicWriter(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setPublicWriter(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanCreateLSOrJavaAgent() throws NotesApiException {
		try {
			return aclEntry.isCanCreateLSOrJavaAgent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanCreateLSOrJavaAgent(boolean arg0)
			throws NotesApiException {
		try {
			aclEntry.setCanCreateLSOrJavaAgent(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isServer() throws NotesApiException {
		try {
			return aclEntry.isServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setServer(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setServer(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isPerson() throws NotesApiException {
		try {
			return aclEntry.isPerson();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPerson(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setPerson(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isGroup() throws NotesApiException {
		try {
			return aclEntry.isGroup();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setGroup(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setGroup(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanCreateSharedFolder() throws NotesApiException {
		try {
			return aclEntry.isCanCreateSharedFolder();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanCreateSharedFolder(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setCanCreateSharedFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isAdminReaderAuthor() throws NotesApiException {
		try {
			return aclEntry.isAdminReaderAuthor();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAdminReaderAuthor(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setAdminReaderAuthor(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isAdminServer() throws NotesApiException {
		try {
			return aclEntry.isAdminServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setAdminServer(boolean arg0) throws NotesApiException {
		try {
			aclEntry.setAdminServer(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isCanReplicateOrCopyDocuments() throws NotesApiException {
		try {
			return aclEntry.isCanReplicateOrCopyDocuments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCanReplicateOrCopyDocuments(boolean arg0)
			throws NotesApiException {
		try {
			aclEntry.setCanReplicateOrCopyDocuments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}