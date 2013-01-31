package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

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

public class NotesDatabaseMockImpl extends NotesBaseMockImpl implements
		NotesDatabase {

	@Override
	public boolean open() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openByReplicaID(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openIfModified(String arg0, String arg1, NotesDateTime arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openWithFailover(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compact() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(int arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDatabase createCopy(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase createCopy(String arg0, String arg1, int arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument createDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase createFromTemplate(String arg0, String arg1,
			boolean arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase createFromTemplate(String arg0, String arg1,
			boolean arg2, int arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFTIndex(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDatabase createReplica(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String arg0, int arg1, int arg2,
			int arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearchRange(String arg0, int arg1,
			int arg2, int arg3, int arg4) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesACL getACL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getACLActivityLog() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesAgent getAgent(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getAgents() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCategories() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCategories(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getCurrentAccessLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getDesignTemplateName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByID(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByUNID(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String arg0, boolean arg1,
			boolean arg2, boolean arg3, String arg4, String arg5, String arg6,
			String arg7, String arg8, boolean arg9) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getProfileDocCollection(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesNoteCollection createNoteCollection(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFileName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFilePath() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getFolderReferencesEnabled() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFolderReferencesEnabled(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesForm getForm(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getForms() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFTIndexFrequency() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDateTime getLastFTIndexed() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getManagers() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getPercentUsed() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDocument getProfileDocument(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getReplicaID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServer() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSize() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getSizeQuota() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSizeQuota(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public long getMaxSize() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTemplateName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTitle() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getType() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getURLHeaderInfo(String arg0, String arg1, String arg2,
			String arg3, String arg4, String arg5) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView getView(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getViews() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void grantAccess(String arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDelayUpdates() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDelayUpdates(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isFTIndexed() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isInMultiDbIndexing() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isLink() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMultiDbSearch() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isOpen() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPublicAddressBook() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPrivateAddressBook() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int queryAccess(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryAccessPrivileges(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean replicate(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFTIndex() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void revokeAccess(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDocumentCollection search(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection search(String arg0, NotesDateTime arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection search(String arg0, NotesDateTime arg1,
			int arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFTIndexFrequency(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInMultiDbIndexing(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitle(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFTIndex(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesReplication getReplicationInfo() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument FTDomainSearch(String arg0, int arg1, int arg2,
			int arg3, int arg4, int arg5, String arg6) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline getOutline(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline createOutline(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline createOutline(String arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableFolder(String arg0) throws NotesApiException {
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
	public Vector queryAccessRoles(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String arg0, String arg1, NotesView arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String arg0, String arg1, NotesView arg2,
			boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fixup() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void fixup(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markForDelete() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isInService() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setInService(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isPendingDelete() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDocumentLockingEnabled() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDocumentLockingEnabled(boolean arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDesignLockingEnabled() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDesignLockingEnabled(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int arg0, boolean arg1, String arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int arg0, boolean arg1, String arg2, boolean arg3)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFileFormat() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getSizeWarning() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSizeWarning(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDateTime getLastFixup() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDirectoryCatalog() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isConfigurationDirectory() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrentAccessPublicReader() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCurrentAccessPublicWriter() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setOption(int arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOption(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isClusterReplication() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getLimitRevisions() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLimitRevisions(double arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public double getLimitUpdatedBy() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLimitUpdatedBy(double arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getListInDbCatalog() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setListInDbCatalog(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUndeleteExpireTime() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUndeleteExpireTime(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime arg0,
			int arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isDB2() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getDB2Schema() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllUnreadDocuments(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments(String arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllUnreadDocuments()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection createDocumentCollection()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createQueryView(String arg0, String arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createQueryView(String arg0, String arg1, NotesView arg2)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createQueryView(String arg0, String arg1, NotesView arg2,
			boolean arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}