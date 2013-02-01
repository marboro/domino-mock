package com.dvelop.domino.mock.impl.mock;

import java.util.HashMap;
import java.util.Map;
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

public class NotesDatabaseMockImpl extends NotesBaseMockImpl implements NotesDatabase {

	private Map<String, NotesAgent> agents;

	public NotesDatabaseMockImpl() {
		agents = new HashMap<String, NotesAgent>();
	}

	@Override
	public boolean open() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openByReplicaID(String server, String replicaID) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openIfModified(String server, String dbFile, NotesDateTime modifiedSince) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openWithFailover(String server, String dbFile) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int compact() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(String options) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(int options) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compactWithOptions(int options, String spaceThreshold) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDatabase createCopy(String server, String dbFile) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase createCopy(String server, String dbFile, int maxSize) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument createDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createFTIndex(int options, boolean recreate) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDatabase createReplica(String server, String dbFile) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String query, int sortOpt) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String query) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String query, int max, int sortOpt, int otherOpt) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearchRange(String query, int max, int sortOpt, int otherOpt, int start) throws NotesApiException {
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

	public void addAgent(NotesAgent agent) {
		try {
			agents.put(agent.getName(), agent);
		} catch (NotesApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public NotesAgent getAgent(String name) throws NotesApiException {
		return agents.get(name);
	}

	@Override
	public Vector getAgents() throws NotesApiException {
		return new Vector<NotesAgent>(agents.values());
	}

	@Override
	public String getCategories() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCategories(String categories) throws NotesApiException {
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
	public NotesDocument getDocumentByID(String noteID) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByUNID(String unid) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String url, boolean reload) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String url, boolean reload, boolean relIfMod, boolean urlList, String charset, String webUser, String webPasswd, String proxyUser, String proxyPasswd,
			boolean returnImmediately) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getProfileDocCollection(String profileName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesNoteCollection createNoteCollection(boolean selectAllFlag) throws NotesApiException {
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
	public void setFolderReferencesEnabled(boolean bEnable) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesForm getForm(String name) throws NotesApiException {
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
	public NotesDocument getProfileDocument(String profile, String profileKey) throws NotesApiException {
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
	public void setSizeQuota(int quota) throws NotesApiException {
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
	public String getURLHeaderInfo(String url, String header, String webUser, String webPasswd, String proxyUser, String proxyPasswd) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView getView(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getViews() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void grantAccess(String name, int level) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDelayUpdates() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDelayUpdates(boolean delay) throws NotesApiException {
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
	public int queryAccess(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int queryAccessPrivileges(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void remove() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean replicate(String server) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFTIndex() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void revokeAccess(String name) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDocumentCollection search(String formula) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection search(String formula, NotesDateTime dt) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection search(String formula, NotesDateTime dt, int max) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFTIndexFrequency(int frequency) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setInMultiDbIndexing(boolean indexing) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTitle(String title) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateFTIndex(boolean create) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesReplication getReplicationInfo() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument FTDomainSearch(String query, int max, int sortOpt, int otherOpt, int start, int count, String entryForm) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline getOutline(String outlineName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline createOutline(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline createOutline(String name, boolean defaultOutline) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void enableFolder(String folder) throws NotesApiException {
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
	public Vector queryAccessRoles(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String viewName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void fixup() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void fixup(int options) throws NotesApiException {
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
	public void setInService(boolean inService) throws NotesApiException {
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
	public void setDocumentLockingEnabled(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDesignLockingEnabled() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDesignLockingEnabled(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String nameStr) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String nameStr, boolean nameStrIsNoteid) throws NotesApiException {
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
	public void setSizeWarning(int warning) throws NotesApiException {
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
	public void setOption(int optionName, boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getOption(int optionName) throws NotesApiException {
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
	public void setLimitRevisions(double revisions) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public double getLimitUpdatedBy() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLimitUpdatedBy(double updateBy) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getListInDbCatalog() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setListInDbCatalog(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getUndeleteExpireTime() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setUndeleteExpireTime(int hours) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime since, int noteClass) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime since) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments() throws NotesApiException {
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
	public NotesDocumentCollection getAllUnreadDocuments(String userID) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments(String userID) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllUnreadDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection createDocumentCollection() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createQueryView(String viewName, String formula) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createQueryView(String viewName, String formula, NotesView templateView) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView createQueryView(String viewName, String formula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

}