package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.Database;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesACL;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;
import com.dvelop.domino.mock.interfaces.NotesForm;
import com.dvelop.domino.mock.interfaces.NotesNoteCollection;
import com.dvelop.domino.mock.interfaces.NotesOutline;
import com.dvelop.domino.mock.interfaces.NotesReplication;
import com.dvelop.domino.mock.interfaces.NotesSession;
import com.dvelop.domino.mock.interfaces.NotesView;

public class NotesDatabaseProdImpl extends NotesBaseProdImpl implements
		NotesDatabase {

	private final Database database;

	public NotesDatabaseProdImpl(Database database) {
		this.database = database;
	}

	public Database get() {
		return database;
	}

	@Override
	public boolean open() throws NotesApiException {
		try {
			return database.open();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean openByReplicaID(String arg0, String arg1)
			throws NotesApiException {
		try {
			return database.openByReplicaID(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean openIfModified(String arg0, String arg1, NotesDateTime arg2)
			throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg2;
			return database.openIfModified(arg0, arg1, dateTime.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean openWithFailover(String arg0, String arg1)
			throws NotesApiException {
		try {
			return database.openWithFailover(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int compact() throws NotesApiException {
		try {
			return database.compact();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int compactWithOptions(String arg0) throws NotesApiException {
		try {
			return database.compactWithOptions(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int compactWithOptions(int arg0) throws NotesApiException {
		try {
			return database.compactWithOptions(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int compactWithOptions(int arg0, String arg1)
			throws NotesApiException {
		try {
			return database.compactWithOptions(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase createCopy(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(database.createCopy(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase createCopy(String arg0, String arg1, int arg2)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(database.createCopy(arg0, arg1,
					arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument createDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.createDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase createFromTemplate(String arg0, String arg1,
			boolean arg2) throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(database.createFromTemplate(arg0,
					arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase createFromTemplate(String arg0, String arg1,
			boolean arg2, int arg3) throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(database.createFromTemplate(arg0,
					arg1, arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void createFTIndex(int arg0, boolean arg1) throws NotesApiException {
		try {
			database.createFTIndex(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase createReplica(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(database.createReplica(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection FTSearch(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(database.FTSearch(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection FTSearch(String arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(database.FTSearch(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection FTSearch(String arg0, int arg1, int arg2,
			int arg3) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(database.FTSearch(arg0,
					arg1, arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection FTSearchRange(String arg0, int arg1,
			int arg2, int arg3, int arg4) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(database.FTSearchRange(
					arg0, arg1, arg2, arg3, arg4));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesACL getACL() throws NotesApiException {
		try {
			return new NotesACLProdImpl(database.getACL());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getACLActivityLog() throws NotesApiException {
		try {
			return database.getACLActivityLog();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllDocuments() throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getAllDocuments());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesAgent getAgent(String arg0) throws NotesApiException {
		try {
			return new NotesAgentProdImpl(database.getAgent(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getAgents() throws NotesApiException {
		try {
			return database.getAgents();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCategories() throws NotesApiException {
		try {
			return database.getCategories();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setCategories(String arg0) throws NotesApiException {
		try {
			database.setCategories(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(database.getCreated());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getCurrentAccessLevel() throws NotesApiException {
		try {
			return database.getCurrentAccessLevel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDesignTemplateName() throws NotesApiException {
		try {
			return database.getDesignTemplateName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByID(String arg0) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.getDocumentByID(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByUNID(String arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.getDocumentByUNID(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByURL(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.getDocumentByURL(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentByURL(String arg0, boolean arg1,
			boolean arg2, boolean arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8, boolean arg9) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.getDocumentByURL(arg0,
					arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getProfileDocCollection(String arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getProfileDocCollection(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesNoteCollection createNoteCollection(boolean arg0)
			throws NotesApiException {
		try {
			return new NotesNoteCollectionProdImpl(
					database.createNoteCollection(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFileName() throws NotesApiException {
		try {
			return database.getFileName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFilePath() throws NotesApiException {
		try {
			return database.getFilePath();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getFolderReferencesEnabled() throws NotesApiException {
		try {
			return database.getFolderReferencesEnabled();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFolderReferencesEnabled(boolean arg0)
			throws NotesApiException {
		try {
			database.setFolderReferencesEnabled(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesForm getForm(String arg0) throws NotesApiException {
		try {
			return new NotesFormProdImpl(database.getForm(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getForms() throws NotesApiException {
		try {
			return database.getForms();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFTIndexFrequency() throws NotesApiException {
		try {
			return database.getFTIndexFrequency();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastFTIndexed() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(database.getLastFTIndexed());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(database.getLastModified());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getManagers() throws NotesApiException {
		try {
			return database.getManagers();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(database.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double getPercentUsed() throws NotesApiException {
		try {
			return database.getPercentUsed();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getProfileDocument(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.getProfileDocument(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getReplicaID() throws NotesApiException {
		try {
			return database.getReplicaID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getServer() throws NotesApiException {
		try {
			return database.getServer();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double getSize() throws NotesApiException {
		try {
			return database.getSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getSizeQuota() throws NotesApiException {
		try {
			return database.getSizeQuota();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSizeQuota(int arg0) throws NotesApiException {
		try {
			database.setSizeQuota(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public long getMaxSize() throws NotesApiException {
		try {
			return database.getMaxSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTemplateName() throws NotesApiException {
		try {
			return database.getTemplateName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTitle() throws NotesApiException {
		try {
			return database.getTitle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getType() throws NotesApiException {
		try {
			return database.getType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURLHeaderInfo(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5) throws NotesApiException {
		try {
			return database
					.getURLHeaderInfo(arg0, arg1, arg2, arg3, arg4, arg5);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView getView(String arg0) throws NotesApiException {
		try {
			return new NotesViewProdImpl(database.getView(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getViews() throws NotesApiException {
		try {
			return database.getViews();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void grantAccess(String arg0, int arg1) throws NotesApiException {
		try {
			database.grantAccess(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDelayUpdates() throws NotesApiException {
		try {
			return database.isDelayUpdates();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDelayUpdates(boolean arg0) throws NotesApiException {
		try {
			database.setDelayUpdates(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isFTIndexed() throws NotesApiException {
		try {
			return database.isFTIndexed();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isInMultiDbIndexing() throws NotesApiException {
		try {
			return database.isInMultiDbIndexing();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isLink() throws NotesApiException {
		try {
			return database.isLink();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isMultiDbSearch() throws NotesApiException {
		try {
			return database.isMultiDbSearch();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isOpen() throws NotesApiException {
		try {
			return database.isOpen();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPublicAddressBook() throws NotesApiException {
		try {
			return database.isPublicAddressBook();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPrivateAddressBook() throws NotesApiException {
		try {
			return database.isPrivateAddressBook();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int queryAccess(String arg0) throws NotesApiException {
		try {
			return database.queryAccess(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int queryAccessPrivileges(String arg0) throws NotesApiException {
		try {
			return database.queryAccessPrivileges(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			database.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean replicate(String arg0) throws NotesApiException {
		try {
			return database.replicate(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeFTIndex() throws NotesApiException {
		try {
			database.removeFTIndex();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void revokeAccess(String arg0) throws NotesApiException {
		try {
			database.revokeAccess(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection search(String arg0) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(database.search(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection search(String arg0, NotesDateTime arg1)
			throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg1;
			return new NotesDocumentCollectionProdImpl(database.search(arg0,
					dateTime.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection search(String arg0, NotesDateTime arg1,
			int arg2) throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg1;
			return new NotesDocumentCollectionProdImpl(database.search(arg0,
					dateTime.get(), arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFTIndexFrequency(int arg0) throws NotesApiException {
		try {
			database.setFTIndexFrequency(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setInMultiDbIndexing(boolean arg0) throws NotesApiException {
		try {
			database.setInMultiDbIndexing(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setTitle(String arg0) throws NotesApiException {
		try {
			database.setTitle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void updateFTIndex(boolean arg0) throws NotesApiException {
		try {
			database.updateFTIndex(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesReplication getReplicationInfo() throws NotesApiException {
		try {
			return new NotesReplicationProdImpl(database.getReplicationInfo());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument FTDomainSearch(String arg0, int arg1, int arg2,
			int arg3, int arg4, int arg5, String arg6) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(database.FTDomainSearch(arg0,
					arg1, arg2, arg3, arg4, arg5, arg6));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutline getOutline(String arg0) throws NotesApiException {
		try {
			return new NotesOutlineProdImpl(database.getOutline(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutline createOutline(String arg0) throws NotesApiException {
		try {
			return new NotesOutlineProdImpl(database.createOutline(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesOutline createOutline(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			return new NotesOutlineProdImpl(database.createOutline(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void enableFolder(String arg0) throws NotesApiException {
		try {
			database.enableFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return database.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		try {
			return database.getNotesURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		try {
			return database.getHttpURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector queryAccessRoles(String arg0) throws NotesApiException {
		try {
			return database.queryAccessRoles(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createView() throws NotesApiException {
		try {
			return new NotesViewProdImpl(database.createView());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createView(String arg0) throws NotesApiException {
		try {
			return new NotesViewProdImpl(database.createView(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createView(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesViewProdImpl(database.createView(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createView(String arg0, String arg1, NotesView arg2)
			throws NotesApiException {
		try {
			NotesViewProdImpl view = (NotesViewProdImpl) arg2;
			return new NotesViewProdImpl(database.createView(arg0, arg1,
					view.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createView(String arg0, String arg1, NotesView arg2,
			boolean arg3) throws NotesApiException {
		try {
			NotesViewProdImpl view = (NotesViewProdImpl) arg2;
			return new NotesViewProdImpl(database.createView(arg0, arg1,
					view.get(), arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void fixup() throws NotesApiException {
		try {
			database.fixup();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void fixup(int arg0) throws NotesApiException {
		try {
			database.fixup(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markForDelete() throws NotesApiException {
		try {
			database.markForDelete();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isInService() throws NotesApiException {
		try {
			return database.isInService();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setInService(boolean arg0) throws NotesApiException {
		try {
			database.setInService(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isPendingDelete() throws NotesApiException {
		try {
			return database.isPendingDelete();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDocumentLockingEnabled() throws NotesApiException {
		try {
			return database.isDocumentLockingEnabled();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDocumentLockingEnabled(boolean arg0)
			throws NotesApiException {
		try {
			database.setDocumentLockingEnabled(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDesignLockingEnabled() throws NotesApiException {
		try {
			return database.isDesignLockingEnabled();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDesignLockingEnabled(boolean arg0) throws NotesApiException {
		try {
			database.setDesignLockingEnabled(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void sign() throws NotesApiException {
		try {
			database.sign();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void sign(int arg0) throws NotesApiException {
		try {
			database.sign(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void sign(int arg0, boolean arg1) throws NotesApiException {
		try {
			database.sign(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void sign(int arg0, boolean arg1, String arg2)
			throws NotesApiException {
		try {
			database.sign(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void sign(int arg0, boolean arg1, String arg2, boolean arg3)
			throws NotesApiException {
		try {
			database.sign(arg0, arg1, arg2, arg3);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFileFormat() throws NotesApiException {
		try {
			return database.getFileFormat();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long getSizeWarning() throws NotesApiException {
		try {
			return database.getSizeWarning();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSizeWarning(int arg0) throws NotesApiException {
		try {
			database.setSizeWarning(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastFixup() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(database.getLastFixup());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDirectoryCatalog() throws NotesApiException {
		try {
			return database.isDirectoryCatalog();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isConfigurationDirectory() throws NotesApiException {
		try {
			return database.isConfigurationDirectory();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCurrentAccessPublicReader() throws NotesApiException {
		try {
			return database.isCurrentAccessPublicReader();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCurrentAccessPublicWriter() throws NotesApiException {
		try {
			return database.isCurrentAccessPublicWriter();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setOption(int arg0, boolean arg1) throws NotesApiException {
		try {
			database.setOption(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getOption(int arg0) throws NotesApiException {
		try {
			return database.getOption(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isClusterReplication() throws NotesApiException {
		try {
			return database.isClusterReplication();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double getLimitRevisions() throws NotesApiException {
		try {
			return database.getLimitRevisions();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLimitRevisions(double arg0) throws NotesApiException {
		try {
			database.setLimitRevisions(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double getLimitUpdatedBy() throws NotesApiException {
		try {
			return database.getLimitUpdatedBy();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setLimitUpdatedBy(double arg0) throws NotesApiException {
		try {
			database.setLimitUpdatedBy(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getListInDbCatalog() throws NotesApiException {
		try {
			return database.getListInDbCatalog();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setListInDbCatalog(boolean arg0) throws NotesApiException {
		try {
			database.setListInDbCatalog(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getUndeleteExpireTime() throws NotesApiException {
		try {
			return database.getUndeleteExpireTime();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUndeleteExpireTime(int arg0) throws NotesApiException {
		try {
			database.setUndeleteExpireTime(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime arg0,
			int arg1) throws NotesApiException {
		try {
			NotesDateTimeProdImpl dt = (NotesDateTimeProdImpl) arg0;
			return new NotesDocumentCollectionProdImpl(
					database.getModifiedDocuments(dt.get(), arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime arg0)
			throws NotesApiException {
		try {
			NotesDateTimeProdImpl dt = (NotesDateTimeProdImpl) arg0;
			return new NotesDocumentCollectionProdImpl(
					database.getModifiedDocuments(dt.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments()
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getModifiedDocuments());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDB2() throws NotesApiException {
		try {
			return database.isDB2();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDB2Schema() throws NotesApiException {
		try {
			return database.getDB2Schema();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllUnreadDocuments(String arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getAllUnreadDocuments(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments(String arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getAllReadDocuments(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllUnreadDocuments()
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getAllUnreadDocuments());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments()
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.getAllReadDocuments());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection createDocumentCollection()
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					database.createDocumentCollection());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createQueryView(String arg0, String arg1)
			throws NotesApiException {
		try {
			return new NotesViewProdImpl(database.createQueryView(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createQueryView(String arg0, String arg1, NotesView arg2)
			throws NotesApiException {
		try {
			NotesViewProdImpl view = (NotesViewProdImpl) arg2;
			return new NotesViewProdImpl(database.createQueryView(arg0, arg1,
					view.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView createQueryView(String arg0, String arg1, NotesView arg2,
			boolean arg3) throws NotesApiException {
		try {
			NotesViewProdImpl view = (NotesViewProdImpl) arg2;
			return new NotesViewProdImpl(database.createQueryView(arg0, arg1,
					view.get(), arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}