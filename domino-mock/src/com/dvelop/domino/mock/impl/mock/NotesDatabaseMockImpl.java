package com.dvelop.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
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

	private Map<String, NotesAgent> agents;
	private final String server;
	private final String dbFile;
	private final int maxSize;
	private List<NotesDocument> documents;
	private int indexOptions;
	private boolean indexRecreate;
	private List<NotesOutline> outlines;
	private final String replicaID;
	private List<NotesView> views;
	private List<NotesView> folders;
	private NotesACL acl;
	private Vector aclActivityLog;

	public NotesDatabaseMockImpl() {
		this("", "", 0, UUID.randomUUID().toString());
	}

	public NotesDatabaseMockImpl(String server, String dbFile) {
		this(server, dbFile, 0, UUID.randomUUID().toString());
	}

	public NotesDatabaseMockImpl(String server, String dbFile, int maxSize,
			String replicaID) {
		this.server = server;
		this.dbFile = dbFile;
		this.maxSize = maxSize;
		this.replicaID = replicaID;
		agents = new HashMap<String, NotesAgent>();
		documents = new ArrayList<NotesDocument>();
		outlines = new ArrayList<NotesOutline>();
		views = new ArrayList<NotesView>();
		folders = new ArrayList<NotesView>();
		aclActivityLog = new Vector();
	}

	public void addView(NotesView view) {
		views.add(view);
	}

	@Override
	public boolean open() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openByReplicaID(String server, String replicaID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openIfModified(String server, String dbFile,
			NotesDateTime modifiedSince) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean openWithFailover(String server, String dbFile)
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
	public int compactWithOptions(int options, String spaceThreshold)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDatabase createCopy(String server, String dbFile)
			throws NotesApiException {
		return new NotesDatabaseMockImpl(server, dbFile);
	}

	@Override
	public NotesDatabase createCopy(String server, String dbFile, int maxSize)
			throws NotesApiException {
		return new NotesDatabaseMockImpl(server, dbFile, maxSize, UUID
				.randomUUID().toString());
	}

	@Override
	public NotesDocument createDocument() throws NotesApiException {
		NotesDocumentMockImpl newDocument = new NotesDocumentMockImpl();
		documents.add(newDocument);
		return newDocument;

	}

	@Override
	public NotesDatabase createFromTemplate(String server, String dbFile,
			boolean inherit) throws NotesApiException {
		return createFromTemplate(server, dbFile, inherit, 0);
	}

	@Override
	public NotesDatabase createFromTemplate(String server, String dbFile,
			boolean inherit, int maxSize) throws NotesApiException {

		NotesDatabaseMockImpl newDatabase = new NotesDatabaseMockImpl(server,
				dbFile, maxSize, UUID.randomUUID().toString());
		if (inherit) {

		}
		return newDatabase;
	}

	@Override
	public void createFTIndex(int indexOptions, boolean indexRecreate)
			throws NotesApiException {
		this.indexOptions = indexOptions;
		this.indexRecreate = indexRecreate;

	}

	@Override
	public NotesDatabase createReplica(String server, String dbFile)
			throws NotesApiException {
		return new NotesDatabaseMockImpl(server, dbFile, maxSize, replicaID);
	}

	@Override
	public NotesDocumentCollection FTSearch(String query, int sortOpt)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String query)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearch(String query, int max, int sortOpt,
			int otherOpt) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection FTSearchRange(String query, int max,
			int sortOpt, int otherOpt, int start) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	public void setACL(NotesACL acl) {
		this.acl = acl;
	}

	@Override
	public NotesACL getACL() throws NotesApiException {
		return acl;
	}

	public void aclActivityLogAddEntry(String entry) {
		aclActivityLog.add(entry);
	}

	@Override
	public Vector getACLActivityLog() throws NotesApiException {
		return aclActivityLog;
	}

	@Override
	public NotesDocumentCollection getAllDocuments() throws NotesApiException {
		NotesDocumentCollectionMockImpl docCol = new NotesDocumentCollectionMockImpl();
		for (NotesDocument doc : documents) {
			docCol.addDocument((NotesDocumentMockImpl) doc);
		}
		return docCol;
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
	public NotesDocument getDocumentByID(String noteID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByUNID(String unid)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String url, boolean reload)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String url, boolean reload,
			boolean relIfMod, boolean urlList, String charset, String webUser,
			String webPasswd, String proxyUser, String proxyPasswd,
			boolean returnImmediately) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getProfileDocCollection(String profileName)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesNoteCollection createNoteCollection(boolean selectAllFlag)
			throws NotesApiException {
		NotesNoteCollectionMockImpl noteCollection = new NotesNoteCollectionMockImpl();
		noteCollection.selectAllAdminNotes(selectAllFlag);
		noteCollection.selectAllCodeElements(selectAllFlag);
		noteCollection.selectAllDataNotes(selectAllFlag);
		noteCollection.selectAllDesignElements(selectAllFlag);
		noteCollection.selectAllFormatElements(selectAllFlag);
		noteCollection.selectAllIndexElements(selectAllFlag);
		noteCollection.selectAllNotes(selectAllFlag);
		return noteCollection;
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
	public void setFolderReferencesEnabled(boolean bEnable)
			throws NotesApiException {
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
	public NotesDocument getProfileDocument(String profile, String profileKey)
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
	public String getURLHeaderInfo(String url, String header, String webUser,
			String webPasswd, String proxyUser, String proxyPasswd)
			throws NotesApiException {
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
	public NotesDocumentCollection search(String formula)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection search(String formula, NotesDateTime dt)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection search(String formula, NotesDateTime dt,
			int max) throws NotesApiException {
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
	public NotesDocument FTDomainSearch(String query, int max, int sortOpt,
			int otherOpt, int start, int count, String entryForm)
			throws NotesApiException {
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
		return createOutline(name, false);
	}

	@Override
	public NotesOutline createOutline(String name, boolean defaultOutline)
			throws NotesApiException {
		NotesOutlineMockImpl outline = new NotesOutlineMockImpl(name,
				defaultOutline);
		outlines.add(outline);
		return outline;
	}

	@Override
	public void enableFolder(String folder) throws NotesApiException {
		boolean folderExists = false;
		for (NotesView folderElement : folders) {
			if (folderElement.getName().compareTo(folder) == 0) {
				folderExists = true;
			}
		}
		if (!folderExists) {
			NotesViewMockImpl newFolder = new NotesViewMockImpl(folder, "",
					null, true, this);
			newFolder.setIsFolder(true);
			folders.add(newFolder);
		}

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
		return createQueryView("", "", null, true);
	}

	@Override
	public NotesView createView(String viewName) throws NotesApiException {
		return createView(viewName, "", null, true);
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula)
			throws NotesApiException {
		return createView(viewName, viewSelectionFormula, null, true);
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula,
			NotesView templateView) throws NotesApiException {
		return createView(viewName, viewSelectionFormula, templateView, true);
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula,
			NotesView templateView, boolean prohibitDesignRefreshModifications)
			throws NotesApiException {
		return new NotesViewMockImpl(viewName, viewSelectionFormula,
				templateView, prohibitDesignRefreshModifications, this);
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
	public void setDocumentLockingEnabled(boolean flag)
			throws NotesApiException {
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
	public void sign(int documentType, boolean existingSigsOnly)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String nameStr)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly,
			String nameStr, boolean nameStrIsNoteid) throws NotesApiException {
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
	public void setOption(int optionName, boolean flag)
			throws NotesApiException {
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
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime since,
			int noteClass) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getModifiedDocuments(NotesDateTime since)
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
	public NotesDocumentCollection getAllUnreadDocuments(String userID)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getAllReadDocuments(String userID)
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
		return new NotesDocumentCollectionMockImpl();
	}

	@Override
	public NotesView createQueryView(String viewName, String formula)
			throws NotesApiException {
		return createQueryView(viewName, formula, null, true);
	}

	@Override
	public NotesView createQueryView(String viewName, String formula,
			NotesView templateView) throws NotesApiException {
		return createQueryView(viewName, formula, templateView, true);
	}

	@Override
	public NotesView createQueryView(String viewName, String formula,
			NotesView templateView, boolean prohibitDesignRefreshModifications)
			throws NotesApiException {
		NotesViewMockImpl newQueryView = new NotesViewMockImpl(viewName,
				formula, templateView, prohibitDesignRefreshModifications, this);
		return newQueryView;
	}

}