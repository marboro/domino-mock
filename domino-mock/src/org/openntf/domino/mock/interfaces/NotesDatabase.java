package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a Notes database.
 * 
 * @author Sven Dreher
 * 
 * @access There are several ways you can use the Database class to access existing databases and to create new ones.
 *         <ul>
 *         <li>To access the current database if you are running as an agent, use {@link NotesAgentContext#getCurrentDatabase()} in AgentContext.</li>
 *         <li>To access an existing database when you know its server and file name, use {@link NotesSession#getDatabase(String, String, boolean)} in Session.</li>
 *         <li>To access an existing database when you know its server and replica ID, use {@link NotesDbDirectory#openDatabaseByReplicaID(String)} in DbDirectory.</li>
 *         <li>To locate an existing database when you know its server but not its file name, use the {@link NotesDbDirectory} class.</li>
 *         <li>To access the current user's mail database, use {@link NotesDbDirectory#openMailDatabase()} in DbDirectory.</li>
 *         <li>To open the default Web Navigator database, use {@link NotesSession#getURLDatabase()} in Session.</li>
 *         <li>To access the available Domino Directories and Personal Address Books, use {@link NotesSession#getAddressBooks()} in Session.</li>
 *         <li>To test for the existence of a database with a specific server and file name before accessing it, use {@link NotesDbDirectory#openDatabase(String, boolean)} or
 *         {@link NotesDbDirectory#openDatabaseIfModified(String, NotesDateTime)} in DbDirectory.</li>
 *         <li>To create a new database from an existing database, use {@link #createCopy(String, String, int)}, {@link #createFromTemplate(String, String, boolean, int)}, or
 *         {@link #createReplica(String, String)}.</li>
 *         <li>To create a new database from scratch, use {@link NotesDbDirectory#createDatabase(String, boolean)} in DbDirectory.</li>
 *         <li>To access a database when you have a contained object such as View, Document, DocumentCollection, ACL, or Agent, use the appropriate Parent (or ParentDatabase) property.</li>
 *         </ul>
 * <br>
 *         <b>Access levels</b><br>
 *         Notes throws an exception when you attempt to perform an operation for which the user does not have appropriate access. The properties and methods that you can successfully use on a
 *         Database object are determined by these factors:
 *         <ul>
 *         <li>
 *         The user's access level to the database, as determined by the database access control list. The ACL determines if the user can open a database, add documents to it, remove documents from
 *         it, modify the ACL, and so on.</li>
 *         <li>The user's access level to the server on which the database resides, as determined by the Server document in the Domino Directory.</li>
 *         </ul>
 * 
 * @usage A database must be open before you can use all the properties and methods in the corresponding Database object. In most cases, the class library automatically opens a database for you. But
 *        see isOpen for the exceptions. <br>
 * <br>
 *        <b>Access levels</b><br>
 *        Notes throws an exception when you attempt to perform an operation for which the user does not have appropriate access. The properties and methods that you can successfully use on a Database
 *        object are determined by these factors:
 *        <ul>
 *        <li>The user's access level to the database, as determined by the database access control list. The ACL determines if the user can open a database, add documents to it, remove documents from
 *        it, modify the ACL, and so on.</li>
 *        <li>The user's access level to the server on which the database resides, as determined by the Server document in the Domino Directory.</li>
 *        </ul>
 * 
 * @example 1. This agent creates a Database object called db and assigns a database to it. The database is names.nsf, located at the top level of the data directory on server doc. If the database
 *          exists, getDatabase automatically opens it.
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			Database db = session.getDatabase(&quot;doc&quot;, &quot;names&quot;);
 * 			System.out.println(db.getTitle());
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          2. This agent uses isOpen to test if the database quack.nsf exists locally. If not, the agent uses the create method to create a new database on disk.
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			Database db, template;
 * 			db = session.getDatabase(null, &quot;quack&quot;);
 * 			if (db.isOpen())
 * 				System.out.println(db.getTitle());
 * 			else {
 * 				System.out.println(&quot;Database does not exist&quot;);
 * 				System.out.println(&quot;Creating new database ...&quot;);
 * 				template = session.getDatabase(null, &quot;discsw50.ntf&quot;);
 * 				if (template.isOpen()) {
 * 					db = template.createFromTemplate(null, &quot;quack&quot;, true);
 * 					db.setTitle(&quot;Ducks of North America&quot;);
 * 					System.out.println(db.getTitle());
 * 				} else
 * 					System.out.println(&quot;Template discsw50.ntf does not exist&quot;);
 * 			}
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          3. This agent is the same as the last except that the database is in a subdirectory of the data directory. Notice that two backslashes must be used because the backslash is an escape
 *          character in Java.
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			Database db, template;
 * 			db = session.getDatabase(null, &quot;quack&quot;);
 * 			if (db.isOpen())
 * 				System.out.println(db.getTitle());
 * 			else {
 * 				System.out.println(&quot;Database does not exist&quot;);
 * 				System.out.println(&quot;Creating new database ...&quot;);
 * 				template = session.getDatabase(null, &quot;discsw50.ntf&quot;);
 * 				if (template.isOpen()) {
 * 					db = template.createFromTemplate(null, &quot;birds\\quack&quot;, true);
 * 					db.setTitle(&quot;Ducks of North America&quot;);
 * 					System.out.println(db.getTitle());
 * 				} else
 * 					System.out.println(&quot;Template discsw50.ntf does not exist&quot;);
 * 			}
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          4. This agent gives Brian Flokka Editor access to the current database. Using the CurrentDatabase property avoids having to use file names in agents and makes agents easily portable from
 *          one database to another.
 * 
 *          <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 			Database db = agentContext.getCurrentDatabase();
 * 			db.grantAccess(&quot;Brian Flokka&quot;, ACL.LEVEL_EDITOR);
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          5. This agent shows how you can use the openIfModified method to open a database only if it's been modified after a certain date. The agent checks if quack.nsf on the current server was
 *          modified since yesterday; if so, the agent opens the database and compacts it.
 * 
 *          <pre>
 * import lotus.domino.*;
 * public class JavaAgent extends AgentBase {
 *   public void NotesMain() {
 *     try {
 *       Session session = getSession();
 *       AgentContext agentContext = 
 *           session.getAgentContext();
 *       // (Your code goes here) 
 *       DbDirectory dir = session.getDbDirectory(null);
 *       DateTime dt = session.createDateTime("Today");
 *       dt.setNow();
 *       dt.adjustDay(-1);
 *       Database db = dir.openDatabaseIfModified
 *       ("quack", dt);
 *       if (db != null) {
 *         System.out.println("Compacting database");
 *         db.compact(); }
 *       else
 *         System.out.println(
 *           "Database not modified in past 
 *            day");
 *     } catch(Exception e) {
 *       e.printStackTrace();
 *     }
 *   }
 * </pre>
 */
public interface NotesDatabase extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int FT_SCORES = 8;
	/**
	 * {@value}
	 */
	public static final int FT_DATE_DES = 32;
	/**
	 * {@value}
	 */
	public static final int FT_DATE_ASC = 64;
	/**
	 * {@value}
	 */
	public static final int FT_DATECREATED_DES = 1542;
	/**
	 * {@value}
	 */
	public static final int FT_DATECREATED_ASC = 1543;
	/**
	 * {@value}
	 */
	public static final int FT_STEMS = 512;
	/**
	 * {@value}
	 */
	public static final int FT_THESAURUS = 1024;
	/**
	 * {@value}
	 */
	public static final int FT_FILESYSTEM = 4096;
	/**
	 * {@value}
	 */
	public static final int FT_DATABASE = 8192;
	/**
	 * {@value}
	 */
	public static final int FT_FUZZY = 16384;
	/**
	 * {@value}
	 */
	public static final int DBOPT_NOUNREAD = 37;
	/**
	 * {@value}
	 */
	public static final int DBOPT_OPTIMIZATION = 41;
	/**
	 * {@value}
	 */
	public static final int DBOPT_NOOVERWRITE = 36;
	/**
	 * {@value}
	 */
	public static final int DBOPT_MAINTAINLASTACCESSED = 44;
	/**
	 * {@value}
	 */
	public static final int DBOPT_NOTRANSACTIONLOGGING = 45;
	/**
	 * {@value}
	 */
	public static final int DBOPT_SOFTDELETE = 49;
	/**
	 * {@value}
	 */
	public static final int DBOPT_NORESPONSEINFO = 38;
	/**
	 * {@value}
	 */
	public static final int DBOPT_NOHEADLINEMONITORS = 46;
	/**
	 * {@value}
	 */
	public static final int DBOPT_MOREFIELDS = 54;
	/**
	 * {@value}
	 */
	public static final int DBOPT_LZCOMPRESSION = 65;
	/**
	 * {@value}
	 */
	public static final int DBOPT_LZ1 = 65;
	/**
	 * {@value}
	 */
	public static final int DBOPT_REPLICATEUNREADMARKSTOCLUSTER = 70;
	/**
	 * {@value}
	 */
	public static final int DBOPT_REPLICATEUNREADMARKSTOANY = 71;
	/**
	 * {@value}
	 */
	public static final int FIXUP_VERIFY = 1;
	/**
	 * {@value}
	 */
	public static final int FIXUP_QUICK = 2;
	/**
	 * {@value}
	 */
	public static final int FIXUP_INCREMENTAL = 4;
	/**
	 * {@value}
	 */
	public static final int FIXUP_TXLOGGED = 8;
	/**
	 * {@value}
	 */
	public static final int FIXUP_NODELETE = 16;
	/**
	 * {@value}
	 */
	public static final int FIXUP_REVERT = 32;
	/**
	 * {@value}
	 */
	public static final int FIXUP_NOVIEWS = 64;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_FORM = 4;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_VIEW = 8;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_ICON = 16;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_ACL = 64;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_DATA = 1;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_HELP = 256;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_AGENT = 512;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_SHAREDFIELD = 1024;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_REPLFORMULA = 2048;
	/**
	 * {@value}
	 */
	public static final int DBSIGN_DOC_ALL = 32767;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_FORM = 4;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_VIEW = 8;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_ICON = 16;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_ACL = 64;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_DATA = 1;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_HELP = 256;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_AGENT = 512;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_SHAREDFIELD = 1024;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_REPLFORMULA = 2048;
	/**
	 * {@value}
	 */
	public static final int DBMOD_DOC_ALL = 32767;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_WEB_APP = 1;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_MAILFILE = 2;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_MAILBOX = 3;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_SUBSCRIPTIONS = 4;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_NEWS_SVR_PROXY = 5;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_IMAP_SVR_PROXY = 6;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_PORTFOLIO = 7;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_MULTIDB_SRCH = 8;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_LIGHT_ADDR_BOOK = 9;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_ADDR_BOOK = 10;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_PERS_JOURNAL = 11;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_LIBRARY = 12;
	/**
	 * {@value}
	 */
	public static final int DBTYPE_STANDARD = 13;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_DAILY = 1;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_HOURLY = 3;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_IMMEDIATE = 4;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_SCHEDULED = 2;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_ATTACHED_FILES = 1;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_ENCRYPTED_FIELDS = 2;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_ALL_BREAKS = 4;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_CASE_SENSITIVE = 8;
	/**
	 * {@value}
	 */
	public static final int FTINDEX_ATTACHED_BIN_FILES = 16;
	/**
	 * {@value}
	 */
	public static final int CMPC_ARCHIVE_DELETE_COMPACT = 1;
	/**
	 * {@value}
	 */
	public static final int CMPC_ARCHIVE_DELETE_ONLY = 2;
	/**
	 * {@value}
	 */
	public static final int CMPC_RECOVER_REDUCE_INPLACE = 4;
	/**
	 * {@value}
	 */
	public static final int CMPC_RECOVER_INPLACE = 8;
	/**
	 * {@value}
	 */
	public static final int CMPC_COPYSTYLE = 16;
	/**
	 * {@value}
	 */
	public static final int CMPC_DISCARD_VIEW_INDICES = 32;
	/**
	 * {@value}
	 */
	public static final int CMPC_ENABLE_DOCTBLBIT_OPTMZN = 64;
	/**
	 * {@value}
	 */
	public static final int CMPC_DISABLE_DOCTBLBIT_OPTMZN = 128;
	/**
	 * {@value}
	 */
	public static final int CMPC_ENABLE_RESPONSE_INFO = 256;
	/**
	 * {@value}
	 */
	public static final int CMPC_DISABLE_RESPONSE_INFO = 512;
	/**
	 * {@value}
	 */
	public static final int CMPC_IGNORE_COPYSTYLE_ERRORS = 1024;
	/**
	 * {@value}
	 */
	public static final int CMPC_ENABLE_LARGE_UNKTBL = 2048;
	/**
	 * {@value}
	 */
	public static final int CMPC_DISABLE_LARGE_UNKTBL = 4096;
	/**
	 * {@value}
	 */
	public static final int CMPC_NO_LOCKOUT = 8192;
	/**
	 * {@value}
	 */
	public static final int CMPC_MAX_4GB = 16384;
	/**
	 * {@value}
	 */
	public static final int CMPC_CHK_OVERLAP = 32768;
	/**
	 * {@value}
	 */
	public static final int CMPC_REVERT_FILEFORMAT = 65536;
	/**
	 * {@value}
	 */
	public static final int CMPC_ENABLE_TRANSACTIONLOGGING = 131072;
	/**
	 * {@value}
	 */
	public static final int CMPC_DISABLE_TRANSACTIONLOGGING = 262144;
	/**
	 * {@value}
	 */
	public static final int CMPC_ENABLE_UNREAD_MARKS = 524288;
	/**
	 * {@value}
	 */
	public static final int CMPC_DISABLE_UNREAD_MARKS = 1048576;
	/**
	 * {@value}
	 */
	public static final int DBACL_CREATE_DOCS = 1;
	/**
	 * {@value}
	 */
	public static final int DBACL_DELETE_DOCS = 2;
	/**
	 * {@value}
	 */
	public static final int DBACL_CREATE_PRIV_AGENTS = 4;
	/**
	 * {@value}
	 */
	public static final int DBACL_CREATE_PRIV_FOLDERS_VIEWS = 8;
	/**
	 * {@value}
	 */
	public static final int DBACL_CREATE_SHARED_FOLDERS_VIEWS = 16;
	/**
	 * {@value}
	 */
	public static final int DBACL_CREATE_SCRIPT_AGENTS = 32;
	/**
	 * {@value}
	 */
	public static final int DBACL_READ_PUBLIC_DOCS = 64;
	/**
	 * {@value}
	 */
	public static final int DBACL_WRITE_PUBLIC_DOCS = 128;
	/**
	 * {@value}
	 */
	public static final int DBACL_REPLICATE_COPY_DOCS = 256;
	/**
	 * {@value}
	 */
	public static final int DBOPT_OUTOFOFFICEENABLED = 74;
	/**
	 * {@value}
	 */
	public static final int DBOPT_USEDAOS = 81;
	/**
	 * {@value}
	 */
	public static final int DBOPT_COMPRESSDOCUMENTS = 82;
	/**
	 * {@value}
	 */
	public static final int DBOPT_COMPRESSDESIGN = 32002;
	/**
	 * {@value}
	 */
	public static final int DBOPT_REPLICATEUNREADMARKSNEVER = 32001;
	/**
	 * {@value}
	 */
	public static final int DBOPT_RESPONSETHREADHISTORY = 75;
	/**
	 * {@value}
	 */
	public static final int DBOPT_NOSIMPLESEARCH = 76;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean open() throws NotesApiException;

	/**
	 * @param server
	 * @param replicaID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean openByReplicaID(String server, String replicaID) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @param modifiedSince
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean openIfModified(String server, String dbFile, NotesDateTime modifiedSince) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean openWithFailover(String server, String dbFile) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int compact() throws NotesApiException;

	/**
	 * @param options
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int compactWithOptions(String options) throws NotesApiException;

	/**
	 * @param options
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int compactWithOptions(int options) throws NotesApiException;

	/**
	 * @param options
	 * @param spaceThreshold
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int compactWithOptions(int options, String spaceThreshold) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase createCopy(String server, String dbFile) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @param maxSize
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase createCopy(String server, String dbFile, int maxSize) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument createDocument() throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @param inherit
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @param inherit
	 * @param maxSize
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) throws NotesApiException;

	/**
	 * @param options
	 * @param recreate
	 * @throws NotesApiException
	 */
	public abstract void createFTIndex(int options, boolean recreate) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase createReplica(String server, String dbFile) throws NotesApiException;

	/**
	 * @param query
	 * @param sortOpt
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection FTSearch(String query, int sortOpt) throws NotesApiException;

	/**
	 * @param query
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection FTSearch(String query) throws NotesApiException;

	/**
	 * @param query
	 * @param max
	 * @param sortOpt
	 * @param otherOpt
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection FTSearch(String query, int max, int sortOpt, int otherOpt) throws NotesApiException;

	/**
	 * @param query
	 * @param max
	 * @param sortOpt
	 * @param otherOpt
	 * @param start
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection FTSearchRange(String query, int max, int sortOpt, int otherOpt, int start) throws NotesApiException;

	/**
	 * The access control list for a database.
	 * 
	 * @return The access control list for a database.
	 * @throws NotesApiException
	 * @usage The database must be open to use this property.
	 * @example This agent prints the name of every entry in the ACL of the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry acle = acl.getFirstEntry();
	 * 			do {
	 * 				System.out.println(acle.getName());
	 * 			} while ((acle = acl.getNextEntry(acle)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesACL getACL() throws NotesApiException;

	/**
	 * The log from the access control list for a database.
	 * 
	 * @return The log from the access control list for a database.
	 * @throws NotesApiException
	 * @usage Each vector element contains one entry from the log. The database must be open to use this property.
	 * @example This agent displays the ACL log for the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector log = db.getACLActivityLog();
	 * 			System.out.println(&quot;Activity log&quot;);
	 * 			for (int i = 0; i &lt; log.size(); i++) {
	 * 				String entry = (String) log.elementAt(0);
	 * 				System.out.println(&quot;\t&quot; + entry);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector getACLActivityLog() throws NotesApiException;

	/**
	 * An unsorted collection containing all the documents in a database.
	 * 
	 * @return An unsorted collection containing all the documents in a database.
	 * @throws NotesApiException
	 * @usage The {@link #FTSearch(String)} and {@link #search(String)} methods return smaller collections of documents that meet specific criteria. Using the AllDocuments property is more efficient
	 *        than using the search method with an "@All" formula. The database must be open to use this property.
	 * 
	 * @example This agent gets the number of documents in the current database, then gets the value of the Subject item for each document.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			String title = db.getTitle();
	 * 			DocumentCollection dc = db.getAllDocuments();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has &quot; + dc.getCount() + &quot; documents&quot;);
	 * 			int n = 0;
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				n++;
	 * 				System.out.println(&quot;Document # &quot; + n + &quot;: &quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getAllDocuments() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesAgent getAgent(String name) throws NotesApiException;

	/**
	 * All of the agents in a database.
	 * 
	 * @return All of the agents in a database.
	 * @throws NotesApiException
	 * @usage If the program runs on a workstation or is remote (IIOP), the return vector includes shared agents and private agents that belong to the current user. If the program runs on a server,
	 *        the return vector includes only shared agents. The database must be open to use this property.
	 * @example This agent prints the name of each agent in the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			System.out.println(&quot;Agents in database:&quot;);
	 * 			for (int i = 0; i &lt; agents.size(); i++) {
	 * 				Agent agent = (Agent) agents.elementAt(i);
	 * 				System.out.println(&quot;  &quot; + agent.getName());
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector getAgents() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getCategories() throws NotesApiException;

	/**
	 * @param categories
	 * @throws NotesApiException
	 */
	public abstract void setCategories(String categories) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getCreated() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getCurrentAccessLevel() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getDesignTemplateName() throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument getDocumentByID(String noteID) throws NotesApiException;

	/**
	 * @param unid
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument getDocumentByUNID(String unid) throws NotesApiException;

	/**
	 * @param url
	 * @param reload
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument getDocumentByURL(String url, boolean reload) throws NotesApiException;

	/**
	 * @param url
	 * @param reload
	 * @param relIfMod
	 * @param urlList
	 * @param charset
	 * @param webUser
	 * @param webPasswd
	 * @param proxyUser
	 * @param proxyPasswd
	 * @param returnImmediately
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument getDocumentByURL(String url, boolean reload, boolean relIfMod, boolean urlList, String charset, String webUser, String webPasswd, String proxyUser,
			String proxyPasswd, boolean returnImmediately) throws NotesApiException;

	/**
	 * @param profileName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getProfileDocCollection(String profileName) throws NotesApiException;

	/**
	 * @param selectAllFlag
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesNoteCollection createNoteCollection(boolean selectAllFlag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getFileName() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getFilePath() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean getFolderReferencesEnabled() throws NotesApiException;

	/**
	 * @param bEnable
	 * @throws NotesApiException
	 */
	public abstract void setFolderReferencesEnabled(boolean bEnable) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesForm getForm(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getForms() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getFTIndexFrequency() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getLastFTIndexed() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getLastModified() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getManagers() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesSession getParent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double getPercentUsed() throws NotesApiException;

	/**
	 * @param profile
	 * @param profileKey
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument getProfileDocument(String profile, String profileKey) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getReplicaID() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getServer() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double getSize() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getSizeQuota() throws NotesApiException;

	/**
	 * @param quota
	 * @throws NotesApiException
	 */
	public abstract void setSizeQuota(int quota) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract long getMaxSize() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getTemplateName() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getTitle() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getType() throws NotesApiException;

	/**
	 * @param url
	 * @param header
	 * @param webUser
	 * @param webPasswd
	 * @param proxyUser
	 * @param proxyPasswd
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getURLHeaderInfo(String url, String header, String webUser, String webPasswd, String proxyUser, String proxyPasswd) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView getView(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getViews() throws NotesApiException;

	/**
	 * @param name
	 * @param level
	 * @throws NotesApiException
	 */
	public abstract void grantAccess(String name, int level) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDelayUpdates() throws NotesApiException;

	/**
	 * @param delay
	 * @throws NotesApiException
	 */
	public abstract void setDelayUpdates(boolean delay) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isFTIndexed() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isInMultiDbIndexing() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isLink() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isMultiDbSearch() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isOpen() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPublicAddressBook() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPrivateAddressBook() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int queryAccess(String name) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int queryAccessPrivileges(String name) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void remove() throws NotesApiException;

	/**
	 * @param server
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean replicate(String server) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void removeFTIndex() throws NotesApiException;

	/**
	 * @param name
	 * @throws NotesApiException
	 */
	public abstract void revokeAccess(String name) throws NotesApiException;

	/**
	 * @param formula
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection search(String formula) throws NotesApiException;

	/**
	 * @param formula
	 * @param dt
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection search(String formula, NotesDateTime dt) throws NotesApiException;

	/**
	 * @param formula
	 * @param dt
	 * @param max
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection search(String formula, NotesDateTime dt, int max) throws NotesApiException;

	/**
	 * @param frequency
	 * @throws NotesApiException
	 */
	public abstract void setFTIndexFrequency(int frequency) throws NotesApiException;

	/**
	 * @param indexing
	 * @throws NotesApiException
	 */
	public abstract void setInMultiDbIndexing(boolean indexing) throws NotesApiException;

	/**
	 * @param title
	 * @throws NotesApiException
	 */
	public abstract void setTitle(String title) throws NotesApiException;

	/**
	 * @param create
	 * @throws NotesApiException
	 */
	public abstract void updateFTIndex(boolean create) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesReplication getReplicationInfo() throws NotesApiException;

	/**
	 * @param query
	 * @param max
	 * @param sortOpt
	 * @param otherOpt
	 * @param start
	 * @param count
	 * @param entryForm
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument FTDomainSearch(String query, int max, int sortOpt, int otherOpt, int start, int count, String entryForm) throws NotesApiException;

	/**
	 * @param outlineName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesOutline getOutline(String outlineName) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesOutline createOutline(String name) throws NotesApiException;

	/**
	 * @param name
	 * @param defaultOutline
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesOutline createOutline(String name, boolean defaultOutline) throws NotesApiException;

	/**
	 * @param folder
	 * @throws NotesApiException
	 */
	public abstract void enableFolder(String folder) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getURL() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getNotesURL() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getHttpURL() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector queryAccessRoles(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView() throws NotesApiException;

	/**
	 * @param viewName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView(String viewName) throws NotesApiException;

	/**
	 * @param viewName
	 * @param viewSelectionFormula
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView(String viewName, String viewSelectionFormula) throws NotesApiException;

	/**
	 * @param viewName
	 * @param viewSelectionFormula
	 * @param templateView
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView) throws NotesApiException;

	/**
	 * @param viewName
	 * @param viewSelectionFormula
	 * @param templateView
	 * @param prohibitDesignRefreshModifications
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void fixup() throws NotesApiException;

	/**
	 * @param options
	 * @throws NotesApiException
	 */
	public abstract void fixup(int options) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void markForDelete() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isInService() throws NotesApiException;

	/**
	 * @param inService
	 * @throws NotesApiException
	 */
	public abstract void setInService(boolean inService) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPendingDelete() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDocumentLockingEnabled() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setDocumentLockingEnabled(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDesignLockingEnabled() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setDesignLockingEnabled(boolean flag) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void sign() throws NotesApiException;

	/**
	 * @param documentType
	 * @throws NotesApiException
	 */
	public abstract void sign(int documentType) throws NotesApiException;

	/**
	 * @param documentType
	 * @param existingSigsOnly
	 * @throws NotesApiException
	 */
	public abstract void sign(int documentType, boolean existingSigsOnly) throws NotesApiException;

	/**
	 * @param documentType
	 * @param existingSigsOnly
	 * @param nameStr
	 * @throws NotesApiException
	 */
	public abstract void sign(int documentType, boolean existingSigsOnly, String nameStr) throws NotesApiException;

	/**
	 * @param documentType
	 * @param existingSigsOnly
	 * @param nameStr
	 * @param nameStrIsNoteid
	 * @throws NotesApiException
	 */
	public abstract void sign(int documentType, boolean existingSigsOnly, String nameStr, boolean nameStrIsNoteid) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getFileFormat() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract long getSizeWarning() throws NotesApiException;

	/**
	 * @param warning
	 * @throws NotesApiException
	 */
	public abstract void setSizeWarning(int warning) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getLastFixup() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDirectoryCatalog() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isConfigurationDirectory() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCurrentAccessPublicReader() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCurrentAccessPublicWriter() throws NotesApiException;

	/**
	 * @param optionName
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setOption(int optionName, boolean flag) throws NotesApiException;

	/**
	 * @param optionName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean getOption(int optionName) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isClusterReplication() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double getLimitRevisions() throws NotesApiException;

	/**
	 * @param revisions
	 * @throws NotesApiException
	 */
	public abstract void setLimitRevisions(double revisions) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double getLimitUpdatedBy() throws NotesApiException;

	/**
	 * @param updateBy
	 * @throws NotesApiException
	 */
	public abstract void setLimitUpdatedBy(double updateBy) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean getListInDbCatalog() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setListInDbCatalog(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getUndeleteExpireTime() throws NotesApiException;

	/**
	 * @param hours
	 * @throws NotesApiException
	 */
	public abstract void setUndeleteExpireTime(int hours) throws NotesApiException;

	/**
	 * @param since
	 * @param noteClass
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getModifiedDocuments(NotesDateTime since, int noteClass) throws NotesApiException;

	/**
	 * @param since
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getModifiedDocuments(NotesDateTime since) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getModifiedDocuments() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDB2() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getDB2Schema() throws NotesApiException;

	/**
	 * @param userID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getAllUnreadDocuments(String userID) throws NotesApiException;

	/**
	 * @param userID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getAllReadDocuments(String userID) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getAllUnreadDocuments() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getAllReadDocuments() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection createDocumentCollection() throws NotesApiException;

	/**
	 * @param viewName
	 * @param formula
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createQueryView(String viewName, String formula) throws NotesApiException;

	/**
	 * @param viewName
	 * @param formula
	 * @param templateView
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createQueryView(String viewName, String formula, NotesView templateView) throws NotesApiException;

	/**
	 * @param viewName
	 * @param formula
	 * @param templateView
	 * @param prohibitDesignRefreshModifications
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createQueryView(String viewName, String formula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException;

}
