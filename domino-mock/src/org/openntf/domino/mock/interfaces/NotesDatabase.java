package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesDatabase extends NotesBase {
	public static final int FT_SCORES = 8;
	public static final int FT_DATE_DES = 32;
	public static final int FT_DATE_ASC = 64;
	public static final int FT_DATECREATED_DES = 1542;
	public static final int FT_DATECREATED_ASC = 1543;
	public static final int FT_STEMS = 512;
	public static final int FT_THESAURUS = 1024;
	public static final int FT_FILESYSTEM = 4096;
	public static final int FT_DATABASE = 8192;
	public static final int FT_FUZZY = 16384;
	public static final int DBOPT_NOUNREAD = 37;
	public static final int DBOPT_OPTIMIZATION = 41;
	public static final int DBOPT_NOOVERWRITE = 36;
	public static final int DBOPT_MAINTAINLASTACCESSED = 44;
	public static final int DBOPT_NOTRANSACTIONLOGGING = 45;
	public static final int DBOPT_SOFTDELETE = 49;
	public static final int DBOPT_NORESPONSEINFO = 38;
	public static final int DBOPT_NOHEADLINEMONITORS = 46;
	public static final int DBOPT_MOREFIELDS = 54;
	public static final int DBOPT_LZCOMPRESSION = 65;
	public static final int DBOPT_LZ1 = 65;
	public static final int DBOPT_REPLICATEUNREADMARKSTOCLUSTER = 70;
	public static final int DBOPT_REPLICATEUNREADMARKSTOANY = 71;
	public static final int FIXUP_VERIFY = 1;
	public static final int FIXUP_QUICK = 2;
	public static final int FIXUP_INCREMENTAL = 4;
	public static final int FIXUP_TXLOGGED = 8;
	public static final int FIXUP_NODELETE = 16;
	public static final int FIXUP_REVERT = 32;
	public static final int FIXUP_NOVIEWS = 64;
	public static final int DBSIGN_DOC_FORM = 4;
	public static final int DBSIGN_DOC_VIEW = 8;
	public static final int DBSIGN_DOC_ICON = 16;
	public static final int DBSIGN_DOC_ACL = 64;
	public static final int DBSIGN_DOC_DATA = 1;
	public static final int DBSIGN_DOC_HELP = 256;
	public static final int DBSIGN_DOC_AGENT = 512;
	public static final int DBSIGN_DOC_SHAREDFIELD = 1024;
	public static final int DBSIGN_DOC_REPLFORMULA = 2048;
	public static final int DBSIGN_DOC_ALL = 32767;
	public static final int DBMOD_DOC_FORM = 4;
	public static final int DBMOD_DOC_VIEW = 8;
	public static final int DBMOD_DOC_ICON = 16;
	public static final int DBMOD_DOC_ACL = 64;
	public static final int DBMOD_DOC_DATA = 1;
	public static final int DBMOD_DOC_HELP = 256;
	public static final int DBMOD_DOC_AGENT = 512;
	public static final int DBMOD_DOC_SHAREDFIELD = 1024;
	public static final int DBMOD_DOC_REPLFORMULA = 2048;
	public static final int DBMOD_DOC_ALL = 32767;
	public static final int DBTYPE_WEB_APP = 1;
	public static final int DBTYPE_MAILFILE = 2;
	public static final int DBTYPE_MAILBOX = 3;
	public static final int DBTYPE_SUBSCRIPTIONS = 4;
	public static final int DBTYPE_NEWS_SVR_PROXY = 5;
	public static final int DBTYPE_IMAP_SVR_PROXY = 6;
	public static final int DBTYPE_PORTFOLIO = 7;
	public static final int DBTYPE_MULTIDB_SRCH = 8;
	public static final int DBTYPE_LIGHT_ADDR_BOOK = 9;
	public static final int DBTYPE_ADDR_BOOK = 10;
	public static final int DBTYPE_PERS_JOURNAL = 11;
	public static final int DBTYPE_LIBRARY = 12;
	public static final int DBTYPE_STANDARD = 13;
	public static final int FTINDEX_DAILY = 1;
	public static final int FTINDEX_HOURLY = 3;
	public static final int FTINDEX_IMMEDIATE = 4;
	public static final int FTINDEX_SCHEDULED = 2;
	public static final int FTINDEX_ATTACHED_FILES = 1;
	public static final int FTINDEX_ENCRYPTED_FIELDS = 2;
	public static final int FTINDEX_ALL_BREAKS = 4;
	public static final int FTINDEX_CASE_SENSITIVE = 8;
	public static final int FTINDEX_ATTACHED_BIN_FILES = 16;
	public static final int CMPC_ARCHIVE_DELETE_COMPACT = 1;
	public static final int CMPC_ARCHIVE_DELETE_ONLY = 2;
	public static final int CMPC_RECOVER_REDUCE_INPLACE = 4;
	public static final int CMPC_RECOVER_INPLACE = 8;
	public static final int CMPC_COPYSTYLE = 16;
	public static final int CMPC_DISCARD_VIEW_INDICES = 32;
	public static final int CMPC_ENABLE_DOCTBLBIT_OPTMZN = 64;
	public static final int CMPC_DISABLE_DOCTBLBIT_OPTMZN = 128;
	public static final int CMPC_ENABLE_RESPONSE_INFO = 256;
	public static final int CMPC_DISABLE_RESPONSE_INFO = 512;
	public static final int CMPC_IGNORE_COPYSTYLE_ERRORS = 1024;
	public static final int CMPC_ENABLE_LARGE_UNKTBL = 2048;
	public static final int CMPC_DISABLE_LARGE_UNKTBL = 4096;
	public static final int CMPC_NO_LOCKOUT = 8192;
	public static final int CMPC_MAX_4GB = 16384;
	public static final int CMPC_CHK_OVERLAP = 32768;
	public static final int CMPC_REVERT_FILEFORMAT = 65536;
	public static final int CMPC_ENABLE_TRANSACTIONLOGGING = 131072;
	public static final int CMPC_DISABLE_TRANSACTIONLOGGING = 262144;
	public static final int CMPC_ENABLE_UNREAD_MARKS = 524288;
	public static final int CMPC_DISABLE_UNREAD_MARKS = 1048576;
	public static final int DBACL_CREATE_DOCS = 1;
	public static final int DBACL_DELETE_DOCS = 2;
	public static final int DBACL_CREATE_PRIV_AGENTS = 4;
	public static final int DBACL_CREATE_PRIV_FOLDERS_VIEWS = 8;
	public static final int DBACL_CREATE_SHARED_FOLDERS_VIEWS = 16;
	public static final int DBACL_CREATE_SCRIPT_AGENTS = 32;
	public static final int DBACL_READ_PUBLIC_DOCS = 64;
	public static final int DBACL_WRITE_PUBLIC_DOCS = 128;
	public static final int DBACL_REPLICATE_COPY_DOCS = 256;
	public static final int DBOPT_OUTOFOFFICEENABLED = 74;
	public static final int DBOPT_USEDAOS = 81;
	public static final int DBOPT_COMPRESSDOCUMENTS = 82;
	public static final int DBOPT_COMPRESSDESIGN = 32002;
	public static final int DBOPT_REPLICATEUNREADMARKSNEVER = 32001;
	public static final int DBOPT_RESPONSETHREADHISTORY = 75;
	public static final int DBOPT_NOSIMPLESEARCH = 76;

	public abstract boolean open() throws NotesApiException;

	public abstract boolean openByReplicaID(String server, String replicaID)
			throws NotesApiException;

	public abstract boolean openIfModified(String server, String dbFile,
			NotesDateTime modifiedSince) throws NotesApiException;

	public abstract boolean openWithFailover(String server, String dbFile)
			throws NotesApiException;

	public abstract int compact() throws NotesApiException;

	public abstract int compactWithOptions(String options)
			throws NotesApiException;

	public abstract int compactWithOptions(int options)
			throws NotesApiException;

	public abstract int compactWithOptions(int options, String spaceThreshold)
			throws NotesApiException;

	public abstract NotesDatabase createCopy(String server, String dbFile)
			throws NotesApiException;

	public abstract NotesDatabase createCopy(String server, String dbFile,
			int maxSize) throws NotesApiException;

	public abstract NotesDocument createDocument() throws NotesApiException;

	public abstract NotesDatabase createFromTemplate(String server,
			String dbFile, boolean inherit) throws NotesApiException;

	public abstract NotesDatabase createFromTemplate(String server,
			String dbFile, boolean inherit, int maxSize)
			throws NotesApiException;

	public abstract void createFTIndex(int options, boolean recreate)
			throws NotesApiException;

	public abstract NotesDatabase createReplica(String server, String dbFile)
			throws NotesApiException;

	public abstract NotesDocumentCollection FTSearch(String query, int sortOpt)
			throws NotesApiException;

	public abstract NotesDocumentCollection FTSearch(String query)
			throws NotesApiException;

	public abstract NotesDocumentCollection FTSearch(String query, int max,
			int sortOpt, int otherOpt) throws NotesApiException;

	public abstract NotesDocumentCollection FTSearchRange(String query,
			int max, int sortOpt, int otherOpt, int start)
			throws NotesApiException;

	public abstract NotesACL getACL() throws NotesApiException;

	public abstract Vector getACLActivityLog() throws NotesApiException;

	public abstract NotesDocumentCollection getAllDocuments()
			throws NotesApiException;

	public abstract NotesAgent getAgent(String name) throws NotesApiException;

	public abstract Vector getAgents() throws NotesApiException;

	public abstract String getCategories() throws NotesApiException;

	public abstract void setCategories(String categories)
			throws NotesApiException;

	public abstract NotesDateTime getCreated() throws NotesApiException;

	public abstract int getCurrentAccessLevel() throws NotesApiException;

	public abstract String getDesignTemplateName() throws NotesApiException;

	public abstract NotesDocument getDocumentByID(String noteID)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByUNID(String unid)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByURL(String url, boolean reload)
			throws NotesApiException;

	public abstract NotesDocument getDocumentByURL(String url, boolean reload,
			boolean relIfMod, boolean urlList, String charset, String webUser,
			String webPasswd, String proxyUser, String proxyPasswd,
			boolean returnImmediately) throws NotesApiException;

	public abstract NotesDocumentCollection getProfileDocCollection(
			String profileName) throws NotesApiException;

	public abstract NotesNoteCollection createNoteCollection(
			boolean selectAllFlag) throws NotesApiException;

	public abstract String getFileName() throws NotesApiException;

	public abstract String getFilePath() throws NotesApiException;

	public abstract boolean getFolderReferencesEnabled()
			throws NotesApiException;

	public abstract void setFolderReferencesEnabled(boolean bEnable)
			throws NotesApiException;

	public abstract NotesForm getForm(String name) throws NotesApiException;

	public abstract Vector getForms() throws NotesApiException;

	public abstract int getFTIndexFrequency() throws NotesApiException;

	public abstract NotesDateTime getLastFTIndexed() throws NotesApiException;

	public abstract NotesDateTime getLastModified() throws NotesApiException;

	public abstract Vector getManagers() throws NotesApiException;

	public abstract NotesSession getParent() throws NotesApiException;

	public abstract double getPercentUsed() throws NotesApiException;

	public abstract NotesDocument getProfileDocument(String profile,
			String profileKey) throws NotesApiException;

	public abstract String getReplicaID() throws NotesApiException;

	public abstract String getServer() throws NotesApiException;

	public abstract double getSize() throws NotesApiException;

	public abstract int getSizeQuota() throws NotesApiException;

	public abstract void setSizeQuota(int quota) throws NotesApiException;

	public abstract long getMaxSize() throws NotesApiException;

	public abstract String getTemplateName() throws NotesApiException;

	public abstract String getTitle() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

	public abstract String getURLHeaderInfo(String url, String header,
			String webUser, String webPasswd, String proxyUser,
			String proxyPasswd) throws NotesApiException;

	public abstract NotesView getView(String name) throws NotesApiException;

	public abstract Vector getViews() throws NotesApiException;

	public abstract void grantAccess(String name, int level)
			throws NotesApiException;

	public abstract boolean isDelayUpdates() throws NotesApiException;

	public abstract void setDelayUpdates(boolean delay)
			throws NotesApiException;

	public abstract boolean isFTIndexed() throws NotesApiException;

	public abstract boolean isInMultiDbIndexing() throws NotesApiException;

	public abstract boolean isLink() throws NotesApiException;

	public abstract boolean isMultiDbSearch() throws NotesApiException;

	public abstract boolean isOpen() throws NotesApiException;

	public abstract boolean isPublicAddressBook() throws NotesApiException;

	public abstract boolean isPrivateAddressBook() throws NotesApiException;

	public abstract int queryAccess(String name) throws NotesApiException;

	public abstract int queryAccessPrivileges(String name)
			throws NotesApiException;

	public abstract void remove() throws NotesApiException;

	public abstract boolean replicate(String server) throws NotesApiException;

	public abstract void removeFTIndex() throws NotesApiException;

	public abstract void revokeAccess(String name) throws NotesApiException;

	public abstract NotesDocumentCollection search(String formula)
			throws NotesApiException;

	public abstract NotesDocumentCollection search(String formula,
			NotesDateTime dt) throws NotesApiException;

	public abstract NotesDocumentCollection search(String formula,
			NotesDateTime dt, int max) throws NotesApiException;

	public abstract void setFTIndexFrequency(int frequency)
			throws NotesApiException;

	public abstract void setInMultiDbIndexing(boolean indexing)
			throws NotesApiException;

	public abstract void setTitle(String title) throws NotesApiException;

	public abstract void updateFTIndex(boolean create) throws NotesApiException;

	public abstract NotesReplication getReplicationInfo()
			throws NotesApiException;

	public abstract NotesDocument FTDomainSearch(String query, int max,
			int sortOpt, int otherOpt, int start, int count, String entryForm)
			throws NotesApiException;

	public abstract NotesOutline getOutline(String outlineName)
			throws NotesApiException;

	public abstract NotesOutline createOutline(String name)
			throws NotesApiException;

	public abstract NotesOutline createOutline(String name,
			boolean defaultOutline) throws NotesApiException;

	public abstract void enableFolder(String folder) throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getNotesURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract Vector queryAccessRoles(String name)
			throws NotesApiException;

	public abstract NotesView createView() throws NotesApiException;

	public abstract NotesView createView(String viewName)
			throws NotesApiException;

	public abstract NotesView createView(String viewName,
			String viewSelectionFormula) throws NotesApiException;

	public abstract NotesView createView(String viewName,
			String viewSelectionFormula, NotesView templateView)
			throws NotesApiException;

	public abstract NotesView createView(String viewName,
			String viewSelectionFormula, NotesView templateView,
			boolean prohibitDesignRefreshModifications)
			throws NotesApiException;

	public abstract void fixup() throws NotesApiException;

	public abstract void fixup(int options) throws NotesApiException;

	public abstract void markForDelete() throws NotesApiException;

	public abstract boolean isInService() throws NotesApiException;

	public abstract void setInService(boolean inService)
			throws NotesApiException;

	public abstract boolean isPendingDelete() throws NotesApiException;

	public abstract boolean isDocumentLockingEnabled() throws NotesApiException;

	public abstract void setDocumentLockingEnabled(boolean flag)
			throws NotesApiException;

	public abstract boolean isDesignLockingEnabled() throws NotesApiException;

	public abstract void setDesignLockingEnabled(boolean flag)
			throws NotesApiException;

	public abstract void sign() throws NotesApiException;

	public abstract void sign(int documentType) throws NotesApiException;

	public abstract void sign(int documentType, boolean existingSigsOnly)
			throws NotesApiException;

	public abstract void sign(int documentType, boolean existingSigsOnly,
			String nameStr) throws NotesApiException;

	public abstract void sign(int documentType, boolean existingSigsOnly,
			String nameStr, boolean nameStrIsNoteid) throws NotesApiException;

	public abstract int getFileFormat() throws NotesApiException;

	public abstract long getSizeWarning() throws NotesApiException;

	public abstract void setSizeWarning(int warning) throws NotesApiException;

	public abstract NotesDateTime getLastFixup() throws NotesApiException;

	public abstract boolean isDirectoryCatalog() throws NotesApiException;

	public abstract boolean isConfigurationDirectory() throws NotesApiException;

	public abstract boolean isCurrentAccessPublicReader()
			throws NotesApiException;

	public abstract boolean isCurrentAccessPublicWriter()
			throws NotesApiException;

	public abstract void setOption(int optionName, boolean flag)
			throws NotesApiException;

	public abstract boolean getOption(int optionName) throws NotesApiException;

	public abstract boolean isClusterReplication() throws NotesApiException;

	public abstract double getLimitRevisions() throws NotesApiException;

	public abstract void setLimitRevisions(double revisions)
			throws NotesApiException;

	public abstract double getLimitUpdatedBy() throws NotesApiException;

	public abstract void setLimitUpdatedBy(double updateBy)
			throws NotesApiException;

	public abstract boolean getListInDbCatalog() throws NotesApiException;

	public abstract void setListInDbCatalog(boolean flag)
			throws NotesApiException;

	public abstract int getUndeleteExpireTime() throws NotesApiException;

	public abstract void setUndeleteExpireTime(int hours)
			throws NotesApiException;

	public abstract NotesDocumentCollection getModifiedDocuments(
			NotesDateTime since, int noteClass) throws NotesApiException;

	public abstract NotesDocumentCollection getModifiedDocuments(
			NotesDateTime since) throws NotesApiException;

	public abstract NotesDocumentCollection getModifiedDocuments()
			throws NotesApiException;

	public abstract boolean isDB2() throws NotesApiException;

	public abstract String getDB2Schema() throws NotesApiException;

	public abstract NotesDocumentCollection getAllUnreadDocuments(String userID)
			throws NotesApiException;

	public abstract NotesDocumentCollection getAllReadDocuments(String userID)
			throws NotesApiException;

	public abstract NotesDocumentCollection getAllUnreadDocuments()
			throws NotesApiException;

	public abstract NotesDocumentCollection getAllReadDocuments()
			throws NotesApiException;

	public abstract NotesDocumentCollection createDocumentCollection()
			throws NotesApiException;

	public abstract NotesView createQueryView(String viewName, String formula)
			throws NotesApiException;

	public abstract NotesView createQueryView(String viewName, String formula,
			NotesView templateView) throws NotesApiException;

	public abstract NotesView createQueryView(String viewName, String formula,
			NotesView templateView, boolean prohibitDesignRefreshModifications)
			throws NotesApiException;

}
