package org.openntf.domino.mock.impl.mock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopScoreDocCollector;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesACL;
import org.openntf.domino.mock.interfaces.NotesACLEntry;
import org.openntf.domino.mock.interfaces.NotesAgent;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesDbDirectory;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;
import org.openntf.domino.mock.interfaces.NotesForm;
import org.openntf.domino.mock.interfaces.NotesItem;
import org.openntf.domino.mock.interfaces.NotesNoteCollection;
import org.openntf.domino.mock.interfaces.NotesOutline;
import org.openntf.domino.mock.interfaces.NotesReplication;
import org.openntf.domino.mock.interfaces.NotesSession;
import org.openntf.domino.mock.interfaces.NotesView;

public class NotesDatabaseMockImpl extends NotesBaseMockImpl implements NotesDatabase {

	private static final int ODS_VERSION = 43;
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
	private Vector<String> aclActivityLog;
	private String categories;
	private NotesDateTime created;
	private String designTemplateName;
	private boolean isFolderReferencesEnabled;
	private NotesSession parent;
	private int quota;
	private String templateName;
	private String title;
	private boolean delayUpdates;
	private boolean inService;
	private boolean documentLockingEnabled;
	private boolean designLockingEnabled;
	private boolean notExistent;
	private boolean isOpen;
	private boolean notOpen;
	private NotesDocumentCollection profileDocuments;
	private Map<String, NotesForm> forms;
	private int fTINdexFrequency;
	private NotesDateTime lastFTIndex;
	private NotesDateTime lastModified;
	private int type;
	private boolean isFTIndexed;
	private boolean isInMultiDbIndexing;
	private boolean isLink;
	private boolean isMultiDbSearch;
	private boolean isPublicAddressBook;
	private boolean isPendingDelete;
	private double size;
	private Directory index;
	private StandardAnalyzer analyzer;
	private NotesReplication replicationObject;
	private int sizeWarning;
	private NotesDateTime lastFixup;
	private Map<Integer, Boolean> options;
	private boolean isDirectoryCatalog;
	private boolean isConfigurationDirectory;
	private boolean isClusterReplication;
	private double limitRevisions;
	private double limitUpdateBy;
	private boolean listInDbCatalog;
	private int undeleteExpireTime;

	public NotesDatabaseMockImpl() {
		this("", "", 0, UUID.randomUUID().toString(), null);

	}

	public NotesDatabaseMockImpl(String server, String dbFile) {
		this(server, dbFile, 0, UUID.randomUUID().toString(), null);
	}

	public NotesDatabaseMockImpl(String server, String dbFile, int maxSize, String replicaID, NotesSession parent) {
		this.server = server;
		this.dbFile = dbFile;
		this.maxSize = maxSize;
		this.replicaID = replicaID;
		this.parent = parent;
		agents = new HashMap<String, NotesAgent>();
		documents = new ArrayList<NotesDocument>();
		outlines = new ArrayList<NotesOutline>();
		views = new ArrayList<NotesView>();
		folders = new ArrayList<NotesView>();
		aclActivityLog = new Vector<String>();
		created = new NotesDateTimeMockImpl(new Date());
		profileDocuments = new NotesDocumentCollectionMockImpl();
		forms = new HashMap<String, NotesForm>();
		analyzer = new StandardAnalyzer(Version.LUCENE_43);
		options = new HashMap<Integer, Boolean>();
	}

	public void addView(NotesView view) {
		views.add(view);
	}

	public void setNotExistent(boolean notExistent) {
		this.notExistent = notExistent;
	}

	@Override
	public boolean open() throws NotesApiException {
		String userName = parent.getUserName();
		NotesACL notesACL = getACL();
		NotesACLEntry aclEntry = notesACL.getEntry(userName);
		if (aclEntry.getLevel() == NotesACL.LEVEL_NOACCESS) {
			isOpen = false;
			return false;
		}
		if (notExistent) {
			isOpen = false;
			return false;
		}
		if (notOpen) {
			isOpen = false;
		} else
			isOpen = true;
		return true;

	}

	@Override
	public boolean openByReplicaID(String server, String replicaID) throws NotesApiException {
		NotesDbDirectory dbDirectory = parent.getDbDirectory(server);
		NotesDatabase database = dbDirectory.getFirstDatabase(DBTYPE_STANDARD);
		while (database != null) {
			if (replicaID.equalsIgnoreCase(database.getReplicaID())) {
				break;
			}
			database = dbDirectory.getNextDatabase();
		}
		if (database != null) {
			return database.open();
		}
		return false;
	}

	@Override
	public boolean openIfModified(String server, String dbFile, NotesDateTime modifiedSince) throws NotesApiException {
		NotesDatabase database = parent.getDatabase(server, dbFile);
		NotesDateTime lastModified = database.getLastModified();
		if (lastModified.timeDifference(modifiedSince) >= 0) {
			return database.open();
		}
		return false;
	}

	@Override
	public boolean openWithFailover(String server, String dbFile) throws NotesApiException {
		NotesDatabaseMockImpl database = new NotesDatabaseMockImpl(server, dbFile, maxSize, replicaID, parent);
		return database.open();
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
		return new NotesDatabaseMockImpl(server, dbFile);
	}

	@Override
	public NotesDatabase createCopy(String server, String dbFile, int maxSize) throws NotesApiException {
		return new NotesDatabaseMockImpl(server, dbFile, maxSize, UUID.randomUUID().toString(), parent);
	}

	@Override
	public NotesDocument createDocument() throws NotesApiException {
		NotesDocumentMockImpl newDocument = new NotesDocumentMockImpl();
		documents.add(newDocument);
		return newDocument;

	}

	@Override
	public NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit) throws NotesApiException {
		return createFromTemplate(server, dbFile, inherit, 0);
	}

	@Override
	public NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) throws NotesApiException {

		NotesDatabaseMockImpl newDatabase = new NotesDatabaseMockImpl(server, dbFile, maxSize, UUID.randomUUID().toString(), parent);
		newDatabase.setDesignTemplateName(designTemplateName);
		newDatabase.setTemplateName(templateName);
		// TODO inherit
		// if (inherit) {
		//
		// }
		return newDatabase;
	}

	@Override
	public void createFTIndex(int indexOptions, boolean indexRecreate) throws NotesApiException {
		this.indexOptions = indexOptions;
		this.indexRecreate = indexRecreate;
		buildFTIndex(indexRecreate);
	}

	private void buildFTIndex(boolean recreate) throws NotesApiException {
		if (index != null) {
			if (!recreate) {
				return;
			}
			removeFTIndex();
		}
		try {
			index = new RAMDirectory();

			IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_43, analyzer);

			IndexWriter indexWriter = new IndexWriter(index, config);
			addDocs(indexWriter, documents);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void addDocs(IndexWriter w, List<NotesDocument> docs) throws IOException {
		for (NotesDocument document : docs) {
			addDoc(w, document);
		}
	}

	private void addDoc(IndexWriter w, NotesDocument document) throws IOException {
		Document doc = new Document();
		try {
			Vector<NotesItem> items = document.getItems();

			Iterator<NotesItem> iterator = items.iterator();
			while (iterator.hasNext()) {
				NotesItemMockImpl item = (NotesItemMockImpl) iterator.next();
				doc.add(new TextField(item.getName(), item.getText(), Field.Store.YES));
			}

			doc.add(new StringField("UNID", document.getUniversalID(), Field.Store.YES));
		} catch (NotesApiException e) {
			e.printStackTrace();
		}
		w.addDocument(doc);
	}

	@Override
	public NotesDatabase createReplica(String server, String dbFile) throws NotesApiException {
		return new NotesDatabaseMockImpl(server, dbFile, maxSize, replicaID, parent);
	}

	@Override
	public NotesDocumentCollection FTSearch(String query, int sortOpt) throws NotesApiException {
		return FTSearch(query, 0, sortOpt, 0);
	}

	@Override
	public NotesDocumentCollection FTSearch(String query) throws NotesApiException {
		return FTSearch(query, 0, NotesDatabase.FT_SCORES, 0);
	}

	@Override
	public NotesDocumentCollection FTSearch(String query, int max, int sortOpt, int otherOpt) throws NotesApiException {
		return FTSearchRange(query, max, sortOpt, otherOpt, 0);
	}

	@Override
	public NotesDocumentCollection FTSearchRange(String query, int max, int sortOpt, int otherOpt, int start) throws NotesApiException {
		try {
			NotesDocumentCollection collection = searchIndex(query, max);
			return collection;
		} catch (ParseException e) {
			e.printStackTrace();
			throw new NotesApiException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new NotesApiException(e);
		}
	}

	private NotesDocumentCollection searchIndex(String query, int max) throws ParseException, IOException, NotesApiException {
		Query q = new QueryParser(Version.LUCENE_43, "title", analyzer).parse(query);
		IndexReader reader = DirectoryReader.open(index);
		IndexSearcher searcher = new IndexSearcher(reader);
		TopScoreDocCollector collector = TopScoreDocCollector.create(max, true);
		searcher.search(q, collector);
		ScoreDoc[] hits = collector.topDocs().scoreDocs;
		NotesDocumentCollectionMockImpl col = new NotesDocumentCollectionMockImpl();
		for (ScoreDoc scoreDoc : hits) {
			int docId = scoreDoc.doc;
			Document d = searcher.doc(docId);
			NotesDocument document = getDocumentByUNID(d.get("UNID"));
			col.addDocument(document);
		}
		return col;
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
	public Vector<String> getACLActivityLog() throws NotesApiException {
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
	public Vector<NotesAgent> getAgents() throws NotesApiException {
		return new Vector<NotesAgent>(agents.values());
	}

	@Override
	public String getCategories() throws NotesApiException {
		return categories;
	}

	@Override
	public void setCategories(String categories) throws NotesApiException {
		this.categories = categories;
	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		return created;
	}

	@Override
	public int getCurrentAccessLevel() throws NotesApiException {
		NotesACLEntryMockImpl entry = (NotesACLEntryMockImpl) acl.getEntry(parent.getEffectiveUserName());
		return entry.getLevel();
	}

	public void setDesignTemplateName(String designTemplateName) throws NotesApiException {
		this.designTemplateName = designTemplateName;
	}

	@Override
	public String getDesignTemplateName() throws NotesApiException {
		return designTemplateName;
	}

	@Override
	public NotesDocument getDocumentByID(String noteID) throws NotesApiException {
		for (NotesDocument doc : documents) {
			NotesDocumentMockImpl currentDoc = (NotesDocumentMockImpl) doc;
			if (currentDoc.getNoteID().compareTo(noteID) == 0) {
				return currentDoc;
			}
		}
		return null;
	}

	@Override
	public NotesDocument getDocumentByUNID(String unid) throws NotesApiException {
		for (NotesDocument doc : documents) {
			NotesDocumentMockImpl currentDoc = (NotesDocumentMockImpl) doc;
			if (currentDoc.getUniversalID().compareTo(unid) == 0) {
				return currentDoc;
			}
		}
		return null;
	}

	@Override
	public NotesDocument getDocumentByURL(String url, boolean reload) throws NotesApiException {
		return getDocumentByURL(url, reload, reload, false, null, null, null, null, null, false);
	}

	@Override
	public NotesDocument getDocumentByURL(String url, boolean reload, boolean relIfMod, boolean urlList, String charset, String webUser, String webPasswd, String proxyUser, String proxyPasswd,
			boolean returnImmediately) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getProfileDocCollection(String profileName) throws NotesApiException {
		NotesDocumentCollectionMockImpl returnCollection = new NotesDocumentCollectionMockImpl();
		if (profileDocuments.getCount() > 0) {

			NotesDocument doc = profileDocuments.getFirstDocument();
			while (doc != null) {
				if (doc.getFirstItem("profile").getValueString().compareTo(profileName) == 0) {
					returnCollection.addDocument(doc);
				}
				doc = profileDocuments.getNextDocument(doc);
			}
		}
		return returnCollection;
	}

	@Override
	public NotesNoteCollection createNoteCollection(boolean selectAllFlag) throws NotesApiException {
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
		String dbFileName;
		if (dbFile.contains("/"))
			dbFileName = dbFile.substring(dbFile.lastIndexOf("/"));
		else if (dbFile.contains("\\")) {
			dbFileName = dbFile.substring(dbFile.lastIndexOf("\\"));
		} else
			dbFileName = dbFile;

		return dbFileName;

	}

	@Override
	public String getFilePath() throws NotesApiException {
		return dbFile;
	}

	@Override
	public boolean getFolderReferencesEnabled() throws NotesApiException {
		return isFolderReferencesEnabled;
	}

	@Override
	public void setFolderReferencesEnabled(boolean isFolderReferencesEnabled) throws NotesApiException {
		this.isFolderReferencesEnabled = isFolderReferencesEnabled;
	}

	@Override
	public NotesForm getForm(String name) throws NotesApiException {
		return forms.get(name);
	}

	@Override
	public Vector<NotesForm> getForms() throws NotesApiException {
		return new Vector<NotesForm>(forms.values());
	}

	@Override
	public int getFTIndexFrequency() throws NotesApiException {
		return fTINdexFrequency;
	}

	@Override
	public NotesDateTime getLastFTIndexed() throws NotesApiException {
		return lastFTIndex;
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		return lastModified;
	}

	@Override
	public Vector<String> getManagers() throws NotesApiException {
		List<String> managers = new ArrayList<String>();
		NotesACLEntry entry = acl.getFirstEntry();
		while (entry != null) {
			if (entry.getLevel() == NotesACL.LEVEL_MANAGER) {
				managers.add(entry.getName());
			}
			entry = acl.getNextEntry();
		}
		return new Vector<String>(managers);
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public double getPercentUsed() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDocument getProfileDocument(String profile, String profileKey) throws NotesApiException {
		if (profileDocuments.getCount() > 0) {

			NotesDocument doc = profileDocuments.getFirstDocument();
			while (doc != null) {
				if (((doc.getFirstItem("profile").getValueString().compareTo(profile) == 0) && (doc.getFirstItem("profileKey").getValueString().compareTo(profile) == 0))) {
					return doc;
				}
			}
		}
		return null;
	}

	@Override
	public String getReplicaID() throws NotesApiException {
		return replicaID;
	}

	@Override
	public String getServer() throws NotesApiException {
		return server;
	}

	@Override
	public double getSize() throws NotesApiException {
		return size;
	}

	@Override
	public int getSizeQuota() throws NotesApiException {
		return quota;
	}

	@Override
	public void setSizeQuota(int quota) throws NotesApiException {
		this.quota = quota;
	}

	@Override
	public long getMaxSize() throws NotesApiException {
		return maxSize;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Override
	public String getTemplateName() throws NotesApiException {
		return templateName;
	}

	@Override
	public String getTitle() throws NotesApiException {
		return title;
	}

	@Override
	public int getType() throws NotesApiException {
		return type;
	}

	@Override
	public String getURLHeaderInfo(String url, String header, String webUser, String webPasswd, String proxyUser, String proxyPasswd) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView getView(String name) throws NotesApiException {
		for (NotesView view : views) {
			NotesViewMockImpl currentView = (NotesViewMockImpl) view;
			if ((currentView.getName().compareTo(name) == 0) || (currentView.getAliases().contains(name))) {
				return currentView;
			}
		}
		return null;
	}

	@Override
	public Vector<NotesView> getViews() throws NotesApiException {
		return new Vector<NotesView>(views);
	}

	@Override
	public void grantAccess(String name, int level) throws NotesApiException {
		acl.createACLEntry(name, level);
	}

	@Override
	public boolean isDelayUpdates() throws NotesApiException {
		return delayUpdates;
	}

	@Override
	public void setDelayUpdates(boolean delayUpdates) throws NotesApiException {
		this.delayUpdates = delayUpdates;
	}

	@Override
	public boolean isFTIndexed() throws NotesApiException {
		return isFTIndexed;
	}

	@Override
	public boolean isInMultiDbIndexing() throws NotesApiException {
		return isInMultiDbIndexing;
	}

	@Override
	public boolean isLink() throws NotesApiException {
		return isLink;
	}

	@Override
	public boolean isMultiDbSearch() throws NotesApiException {
		return isMultiDbSearch;
	}

	@Override
	public boolean isOpen() throws NotesApiException {
		return isOpen;
	}

	@Override
	public boolean isPublicAddressBook() throws NotesApiException {
		return isPublicAddressBook;
	}

	@Override
	public boolean isPrivateAddressBook() throws NotesApiException {
		return !isPublicAddressBook;
	}

	@Override
	public int queryAccess(String name) throws NotesApiException {
		// TODO wenn name mitglied einer gruppe ist
		NotesACLEntryMockImpl entry = (NotesACLEntryMockImpl) acl.getEntry(name);
		if (entry != null) {
			return entry.getLevel();
		} else {
			entry = (NotesACLEntryMockImpl) acl.getEntry("Default");
			if (entry != null) {
				return entry.getLevel();
			}
		}
		return NotesACL.LEVEL_NOACCESS;
	}

	@Override
	public int queryAccessPrivileges(String name) throws NotesApiException {
		// TODO wenn name mitglied einer gruppe ist
		NotesACLEntryMockImpl entry = (NotesACLEntryMockImpl) acl.getEntry(name);
		if (entry == null) {
			entry = (NotesACLEntryMockImpl) acl.getEntry("Default");
			if (entry != null) {
				return calcAccessPrivileges(entry);
			}
		}
		return 0;
	}

	private int calcAccessPrivileges(NotesACLEntry entry) throws NotesApiException {
		int accessPrivilieges = 0;
		if (entry.isCanCreateDocuments()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_CREATE_DOCS;
		}
		if (entry.isCanDeleteDocuments()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_DELETE_DOCS;
		}
		if (entry.isCanCreatePersonalAgent()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_CREATE_PRIV_AGENTS;
		}
		if (entry.isCanCreatePersonalFolder()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_CREATE_PRIV_FOLDERS_VIEWS;
		}
		if (entry.isCanCreateSharedFolder()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_CREATE_SHARED_FOLDERS_VIEWS;
		}
		if (entry.isCanCreateLSOrJavaAgent()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_CREATE_SCRIPT_AGENTS;
		}
		if (entry.isPublicReader()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_READ_PUBLIC_DOCS;
		}
		if (entry.isPublicWriter()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_WRITE_PUBLIC_DOCS;
		}
		if (entry.isCanReplicateOrCopyDocuments()) {
			accessPrivilieges = accessPrivilieges + NotesDatabase.DBACL_REPLICATE_COPY_DOCS;
		}
		return accessPrivilieges;
	}

	@Override
	public void remove() throws NotesApiException {
		NotesDbDirectoryMockImpl dbDirectory = (NotesDbDirectoryMockImpl) parent.getDbDirectory(server);
		dbDirectory.removeDatabase(this);
	}

	@Override
	public boolean replicate(String server) throws NotesApiException {
		NotesDatabaseMockImpl database = new NotesDatabaseMockImpl(server, dbFile, maxSize, replicaID, parent);
		if (database.isInService()) {
			return true;
		}
		return false;
	}

	@Override
	public void removeFTIndex() throws NotesApiException {
		try {
			index.close();
			index = null;
		} catch (IOException e) {
			e.printStackTrace();
			throw new NotesApiException(e);
		}

	}

	@Override
	public void revokeAccess(String name) throws NotesApiException {
		acl.removeACLEntry(name);
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
		fTINdexFrequency = frequency;
	}

	@Override
	public void setInMultiDbIndexing(boolean indexing) throws NotesApiException {
		this.isInMultiDbIndexing = indexing;
	}

	@Override
	public void setTitle(String title) throws NotesApiException {
		this.title = title;
	}

	@Override
	public void updateFTIndex(boolean create) throws NotesApiException {
		buildFTIndex(create);
	}

	@Override
	public NotesReplication getReplicationInfo() throws NotesApiException {
		return replicationObject;
	}

	@Override
	public NotesDocument FTDomainSearch(String query, int max, int sortOpt, int otherOpt, int start, int count, String entryForm) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesOutline getOutline(String outlineName) throws NotesApiException {
		for (NotesOutline outline : outlines) {
			NotesOutlineMockImpl current = (NotesOutlineMockImpl) outline;
			if (current.getName().compareTo(outlineName) == 0) {
				return current;
			}
		}
		return null;
	}

	@Override
	public NotesOutline createOutline(String name) throws NotesApiException {
		return createOutline(name, false);
	}

	@Override
	public NotesOutline createOutline(String name, boolean defaultOutline) throws NotesApiException {
		NotesOutlineMockImpl outline = new NotesOutlineMockImpl(name, defaultOutline);
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
			NotesViewMockImpl newFolder = new NotesViewMockImpl(folder, "", null, true, this);
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
		// TODO wenn name mitglied einer gruppe ist
		Vector<String> result = new Vector<String>();
		NotesACLEntryMockImpl entry = (NotesACLEntryMockImpl) acl.getEntry(name);
		if (entry == null) {
			entry = (NotesACLEntryMockImpl) acl.getEntry("Default");
		}
		if (entry != null) {
			result.addAll(entry.getRoles());
		}
		return result;
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
	public NotesView createView(String viewName, String viewSelectionFormula) throws NotesApiException {
		return createView(viewName, viewSelectionFormula, null, true);
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView) throws NotesApiException {
		return createView(viewName, viewSelectionFormula, templateView, true);
	}

	@Override
	public NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException {
		return new NotesViewMockImpl(viewName, viewSelectionFormula, templateView, prohibitDesignRefreshModifications, this);
	}

	@Override
	public void fixup() throws NotesApiException {
		fixup(0);

	}

	@Override
	public void fixup(int options) throws NotesApiException {
		// TODO Auto-generated method stub
		lastFixup = new NotesDateTimeMockImpl(new Date());

	}

	@Override
	public void markForDelete() throws NotesApiException {
		this.isPendingDelete = true;
	}

	@Override
	public boolean isInService() throws NotesApiException {
		return inService;

	}

	@Override
	public void setInService(boolean inService) throws NotesApiException {
		this.inService = inService;
	}

	@Override
	public boolean isPendingDelete() throws NotesApiException {
		return isPendingDelete;
	}

	@Override
	public boolean isDocumentLockingEnabled() throws NotesApiException {
		return documentLockingEnabled;
	}

	@Override
	public void setDocumentLockingEnabled(boolean documentLockingEnabled) throws NotesApiException {
		this.documentLockingEnabled = documentLockingEnabled;
	}

	@Override
	public boolean isDesignLockingEnabled() throws NotesApiException {
		return designLockingEnabled;
	}

	@Override
	public void setDesignLockingEnabled(boolean designLockingEnabled) throws NotesApiException {
		this.designLockingEnabled = designLockingEnabled;
	}

	@Override
	public void sign() throws NotesApiException {
		sign(NotesDatabase.DBSIGN_DOC_ALL);

	}

	@Override
	public void sign(int documentType) throws NotesApiException {
		sign(documentType, false);

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly) throws NotesApiException {
		sign(documentType, existingSigsOnly, "");

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String nameStr) throws NotesApiException {
		sign(documentType, existingSigsOnly, nameStr, false);

	}

	@Override
	public void sign(int documentType, boolean existingSigsOnly, String nameStr, boolean nameStrIsNoteid) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public int getFileFormat() throws NotesApiException {
		return ODS_VERSION;
	}

	@Override
	public long getSizeWarning() throws NotesApiException {
		return sizeWarning;
	}

	@Override
	public void setSizeWarning(int warning) throws NotesApiException {
		this.sizeWarning = warning;
	}

	@Override
	public NotesDateTime getLastFixup() throws NotesApiException {
		return lastFixup;
	}

	@Override
	public boolean isDirectoryCatalog() throws NotesApiException {
		return isDirectoryCatalog;
	}

	@Override
	public boolean isConfigurationDirectory() throws NotesApiException {
		return isConfigurationDirectory;
	}

	@Override
	public boolean isCurrentAccessPublicReader() throws NotesApiException {
		//TODO gruppenauflösung
		NotesACLEntry entry = acl.getEntry(parent.getUserName());
		if (entry != null){
			return entry.isPublicReader();
		}
		return false;
	}

	@Override
	public boolean isCurrentAccessPublicWriter() throws NotesApiException {
		//TODO gruppenauflösung
		NotesACLEntry entry = acl.getEntry(parent.getUserName());
		if (entry != null){
			return entry.isPublicReader();
		}
		return false;
	}

	@Override
	public void setOption(int optionName, boolean flag) throws NotesApiException {
		if (options.containsKey(optionName)){
			options.remove(optionName);
		}
		options.put(optionName, flag);
	}

	@Override
	public boolean getOption(int optionName) throws NotesApiException {
		if (options.containsKey(optionName)){
			return options.get(optionName);
		}
		return false;
	}

	@Override
	public boolean isClusterReplication() throws NotesApiException {
		return isClusterReplication;
	}

	@Override
	public double getLimitRevisions() throws NotesApiException {
		return limitRevisions;
	}

	@Override
	public void setLimitRevisions(double revisions) throws NotesApiException {
		this.limitRevisions = revisions;

	}

	@Override
	public double getLimitUpdatedBy() throws NotesApiException {
		return limitUpdateBy;
	}

	@Override
	public void setLimitUpdatedBy(double updateBy) throws NotesApiException {
		this.limitUpdateBy = updateBy;
		

	}

	@Override
	public boolean getListInDbCatalog() throws NotesApiException {
		return listInDbCatalog;
	}

	@Override
	public void setListInDbCatalog(boolean flag) throws NotesApiException {
		this.listInDbCatalog = flag;

	}

	@Override
	public int getUndeleteExpireTime() throws NotesApiException {
		return undeleteExpireTime;
	}

	@Override
	public void setUndeleteExpireTime(int hours) throws NotesApiException {
		this.undeleteExpireTime = hours;

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
		return new NotesDocumentCollectionMockImpl();
	}

	@Override
	public NotesView createQueryView(String viewName, String formula) throws NotesApiException {
		return createQueryView(viewName, formula, null, true);
	}

	@Override
	public NotesView createQueryView(String viewName, String formula, NotesView templateView) throws NotesApiException {
		return createQueryView(viewName, formula, templateView, true);
	}

	@Override
	public NotesView createQueryView(String viewName, String formula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException {
		NotesViewMockImpl newQueryView = new NotesViewMockImpl(viewName, formula, templateView, prohibitDesignRefreshModifications, this);
		return newQueryView;
	}

	@Override
	public String toString() {
		return dbFile;
	}

	public NotesDocument addDocument(NotesDocument doc) {
		NotesDocumentMockImpl newDoc = null;
		try {
			newDoc = new NotesDocumentMockImpl(doc);
			this.documents.add(newDoc);

		} catch (NotesApiException e) {
			e.printStackTrace();
		}
		return newDoc;
	}

	public void removeAgent(String agentName) {
		agents.remove(agentName);
	}

	public void removeForm(String formName) {
		forms.remove(formName);
	}

}