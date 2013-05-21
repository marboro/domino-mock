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
	 * Compacts a local database.
	 * 
	 * @return The difference in bytes between the size of the database before and after compacting.
	 * @throws NotesApiException
	 * 
	 * @usage This method throws an exception if the database is not local.
	 * 
	 * @example This agent compacts a database if less than 75% of its disk space is occupied by real data. The user supplies the database name as the agent's comment.
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			String dbName = agent.getComment();
	 * 			Database db = session.getDatabase(null, dbName);
	 * 			String title = db.getTitle();
	 * 			double percentUsed = db.getPercentUsed();
	 * 			if (percentUsed &lt; 75) {
	 * 				int saved = db.compact();
	 * 				System.out.println(&quot;Compacting database \&quot;&quot; + title + &quot;\&quot;&quot;);
	 * 			}
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is &quot; + (int) percentUsed + &quot; percent used&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int compact() throws NotesApiException;

	/**
	 * Compacts a local database allowing the submission of options.
	 * 
	 * @param options
	 *            One or more command-line options supported by the Compact server task without the minus signs. Spaces are insignificant except that a space cannot be placed in the S option between
	 *            the number and the final K, k, M, or m. Options are processed in their order of specification.
	 * @return The difference in bytes between the size of the database before and after compacting.
	 * @throws NotesApiException
	 * @usage This method throws an exception if the database is not local.
	 * 
	 *        An agent cannot compact the current database (the database in which the agent is running) or the desktop.dsk file.
	 * 
	 *        The options are those that you can use with the Compact server task. For more information, see "Compact options" in Administration Help.
	 * 
	 *        This method does not support the e or E option.
	 * @example 1. This agent compacts TooBig.nsf using the options b, L, and S10.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(null, &quot;TooBig&quot;);
	 * 			if (db.isOpen()) {
	 * 				int delta = db.compactWithOptions(&quot;bLS10&quot;);
	 * 				System.out.println(&quot;Size difference in bytes = &quot; + delta);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent compacts TooBig.nsf using the same options.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(null, &quot;TooBig&quot;);
	 * 			if (db.isOpen()) {
	 * 				int options = Database.CMPC_RECOVER_REDUCE_INPLACE + Database.CMPC_NO_LOCKOUT;
	 * 				int delta = db.compactWithOptions(options, &quot;10&quot;);
	 * 				System.out.println(&quot;Size difference in bytes = &quot; + delta);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int compactWithOptions(String options) throws NotesApiException;

	/**
	 * Compacts a local database allowing the submission of options.
	 * 
	 * @param options
	 *            One or more of the following constants. Combine constants by adding.
	 *            <ul>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_COMPACT (1) a (archive and delete, then compact)</li>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_ONLY (2) A (archive and delete with no compact; supersedes a)</li>
	 *            <li>Database.CMPC_CHK_OVERLAP (32768) o and O (check overlap)</li>
	 *            <li>Database.CMPC_COPYSTYLE (16) c and C (copy style; supersedes b and B)</li>
	 *            <li>Database.CMPC_DISABLE_DOCTBLBIT_OPTMZN (128) f (disable document table bit map optimization)</li>
	 *            <li>Database.CMPC_DISABLE_LARGE_UNKTBL (4096) k (disable large unknown table)</li>
	 *            <li>Database.CMPC_DISABLE_RESPONSE_INFO (512) H (disable "Don't support specialized response hierarchy")</li>
	 *            <li>Database.CMPC_DISABLE_TRANSACTIONLOGGING (262144) t (disable transaction logging)</li>
	 *            <li>Database.CMPC_DISABLE_UNREAD_MARKS (1048576) U (disable "Don't maintain unread marks")</li>
	 *            <li>Database.CMPC_DISCARD_VIEW_INDICES (32) d and D (discard view indexes)</li>
	 *            <li>Database.CMPC_ENABLE_DOCTBLBIT_OPTMZN (64) F (enable document table bit map optimization; supersedes f)</li>
	 *            <li>Database.CMPC_ENABLE_LARGE_UNKTBL (2048) K (enable large unknown table; supersedes k)</li>
	 *            <li>Database.CMPC_ENABLE_RESPONSE_INFO (256) h (enable "Don't support specialized response hierarchy"; supersedes H)</li>
	 *            <li>Database.CMPC_ENABLE_TRANSACTIONLOGGING (131072) T (enable transaction logging; supersedes t)</li>
	 *            <li>Database.CMPC_ENABLE_UNREAD_MARKS (524288) u (enable "Don't maintain unread marks"; supersedes U)</li>
	 *            <li>Database.CMPC_IGNORE_COPYSTYLE_ERRORS (1024) i (ignore copy-style errors)</li>
	 *            <li>Database.CMPC_MAX_4GB (16384) m and M (set maximum database size at 4 gigabytes)</li>
	 *            <li>Database.CMPC_NO_LOCKOUT (8192) l and L (do not lock out users)</li>
	 *            <li>Database.CMPC_RECOVER_INPLACE (8) B (recover unused space in-place and reduce file size; supersedes b)</li>
	 *            <li>Database.CMPC_RECOVER_REDUCE_INPLACE (4) b (recover unused space in-place without reducing file size)</li>
	 *            <li>Database.CMPC_REVERT_FILEFORMAT (65536) r and R (do not convert old file format)</li>
	 *            </ul>
	 * 
	 * @return The difference in bytes between the size of the database before and after compacting.
	 * @throws NotesApiException
	 * @usage This method throws an exception if the database is not local.
	 * 
	 *        An agent cannot compact the current database (the database in which the agent is running) or the desktop.dsk file.
	 * 
	 *        The options are those that you can use with the Compact server task. For more information, see "Compact options" in Administration Help.
	 * 
	 *        This method does not support the e or E option.
	 * @example 1. This agent compacts TooBig.nsf using the options b, L, and S10.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(null, &quot;TooBig&quot;);
	 * 			if (db.isOpen()) {
	 * 				int delta = db.compactWithOptions(&quot;bLS10&quot;);
	 * 				System.out.println(&quot;Size difference in bytes = &quot; + delta);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent compacts TooBig.nsf using the same options.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(null, &quot;TooBig&quot;);
	 * 			if (db.isOpen()) {
	 * 				int options = Database.CMPC_RECOVER_REDUCE_INPLACE + Database.CMPC_NO_LOCKOUT;
	 * 				int delta = db.compactWithOptions(options, &quot;10&quot;);
	 * 				System.out.println(&quot;Size difference in bytes = &quot; + delta);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int compactWithOptions(int options) throws NotesApiException;

	/**
	 * Compacts a local database allowing the submission of options.
	 * 
	 * @param options
	 *            One or more of the following constants. Combine constants by adding.
	 *            <ul>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_COMPACT (1) a (archive and delete, then compact)</li>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_ONLY (2) A (archive and delete with no compact; supersedes a)</li>
	 *            <li>Database.CMPC_CHK_OVERLAP (32768) o and O (check overlap)</li>
	 *            <li>Database.CMPC_COPYSTYLE (16) c and C (copy style; supersedes b and B)</li>
	 *            <li>Database.CMPC_DISABLE_DOCTBLBIT_OPTMZN (128) f (disable document table bit map optimization)</li>
	 *            <li>Database.CMPC_DISABLE_LARGE_UNKTBL (4096) k (disable large unknown table)</li>
	 *            <li>Database.CMPC_DISABLE_RESPONSE_INFO (512) H (disable "Don't support specialized response hierarchy")</li>
	 *            <li>Database.CMPC_DISABLE_TRANSACTIONLOGGING (262144) t (disable transaction logging)</li>
	 *            <li>Database.CMPC_DISABLE_UNREAD_MARKS (1048576) U (disable "Don't maintain unread marks")</li>
	 *            <li>Database.CMPC_DISCARD_VIEW_INDICES (32) d and D (discard view indexes)</li>
	 *            <li>Database.CMPC_ENABLE_DOCTBLBIT_OPTMZN (64) F (enable document table bit map optimization; supersedes f)</li>
	 *            <li>Database.CMPC_ENABLE_LARGE_UNKTBL (2048) K (enable large unknown table; supersedes k)</li>
	 *            <li>Database.CMPC_ENABLE_RESPONSE_INFO (256) h (enable "Don't support specialized response hierarchy"; supersedes H)</li>
	 *            <li>Database.CMPC_ENABLE_TRANSACTIONLOGGING (131072) T (enable transaction logging; supersedes t)</li>
	 *            <li>Database.CMPC_ENABLE_UNREAD_MARKS (524288) u (enable "Don't maintain unread marks"; supersedes U)</li>
	 *            <li>Database.CMPC_IGNORE_COPYSTYLE_ERRORS (1024) i (ignore copy-style errors)</li>
	 *            <li>Database.CMPC_MAX_4GB (16384) m and M (set maximum database size at 4 gigabytes)</li>
	 *            <li>Database.CMPC_NO_LOCKOUT (8192) l and L (do not lock out users)</li>
	 *            <li>Database.CMPC_RECOVER_INPLACE (8) B (recover unused space in-place and reduce file size; supersedes b)</li>
	 *            <li>Database.CMPC_RECOVER_REDUCE_INPLACE (4) b (recover unused space in-place without reducing file size)</li>
	 *            <li>Database.CMPC_REVERT_FILEFORMAT (65536) r and R (do not convert old file format)</li>
	 *            </ul>
	 * @param spaceThreshold
	 *            The value of the S option (compact if specified percent or amount of unused space) without the S, for example, "10" for 10 percent, "10K" for 10 kilobytes, or "10M" for 10 megabytes.
	 * @return The difference in bytes between the size of the database before and after compacting.
	 * @throws NotesApiException
	 * @usage This method throws an exception if the database is not local.
	 * 
	 *        An agent cannot compact the current database (the database in which the agent is running) or the desktop.dsk file.
	 * 
	 *        The options are those that you can use with the Compact server task. For more information, see "Compact options" in Administration Help.
	 * 
	 *        This method does not support the e or E option.
	 * @example 1. This agent compacts TooBig.nsf using the options b, L, and S10.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(null, &quot;TooBig&quot;);
	 * 			if (db.isOpen()) {
	 * 				int delta = db.compactWithOptions(&quot;bLS10&quot;);
	 * 				System.out.println(&quot;Size difference in bytes = &quot; + delta);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent compacts TooBig.nsf using the same options.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(null, &quot;TooBig&quot;);
	 * 			if (db.isOpen()) {
	 * 				int options = Database.CMPC_RECOVER_REDUCE_INPLACE + Database.CMPC_NO_LOCKOUT;
	 * 				int delta = db.compactWithOptions(options, &quot;10&quot;);
	 * 				System.out.println(&quot;Size difference in bytes = &quot; + delta);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int compactWithOptions(int options, String spaceThreshold) throws NotesApiException;

	/**
	 * Creates an empty copy of the current database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify null or an empty string ("") to create a local copy.
	 * @param dbFile
	 *            The file name of the new copy.
	 * @return The new copy.
	 * @throws NotesApiException
	 * 
	 * @usage If a database with the specified file name already exists, an exception is thrown.
	 * 
	 *        The copy contains the design elements of the current database, an identical access control list, and an identical title. It does not contain any documents.
	 * 
	 *        The copy is not a replica.
	 * 
	 *        Programs using remote (IIOP) calls to a server can't create or access databases on other servers. In these cases, the server parameter must correspond to the server the program is
	 *        running on. There are two ways to do this:
	 *        <ul>
	 *        <li>Use null or an empty string ("") to indicate the current computer. This is the safer method.</li>
	 *        <li>Make sure the name of the server that the program runs on matches the name of server.</li>
	 *        </ul>
	 *        Programs running on a workstation can access several different servers in a single program.
	 * 
	 *        The ACL of the original database gets copied to the new database, but you may want to modify the copy's ACL. For example, you may want Manager access to the copy for yourself even if
	 *        you're not a manager of the original. Use the methods {@link #grantAccess(String, int)} and {@link #revokeAccess(String)} to modify the copy's ACL.
	 * 
	 * @example 1. This agent makes a local copy of the local database names.nsf
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
	 *       Database db = session.getDatabase(null, "names");
	 *       String title = db.getTitle();
	 *       Database db2 = db.createCopy(null, "names2");
	 *       db2.setTitle("Copy of names");
	 *       System.out.println
	 *       ("Database \"" + title + "\" copied locally");
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * </pre>
	 * 
	 *          2. This agent makes a local copy of the local database names.nsf and sets the maxsize to 2.
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
	 * 			Database db = session.getDatabase(null, &quot;names&quot;);
	 * 			String title = db.getTitle();
	 * 			Database db2 = db.createCopy(null, &quot;names2&quot;, 2);
	 * 			db2.setTitle(&quot;Copy of names&quot;);
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; copied locally&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase createCopy(String server, String dbFile) throws NotesApiException;

	/**
	 * Creates an empty copy of the current database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify null or an empty string ("") to create a local copy.
	 * @param dbFile
	 *            The file name of the new copy.
	 * @param maxSize
	 *            The maximum size (in gigabytes) that you would like to assign to the new database. This parameter applies only to Release 4 databases or those created on a server that has not been
	 *            upgraded to Release 5. Entering an integer greater than 4 generates a run-time error
	 * @return The new copy.
	 * @throws NotesApiException
	 * @usage If a database with the specified file name already exists, an exception is thrown.
	 * 
	 *        The copy contains the design elements of the current database, an identical access control list, and an identical title. It does not contain any documents.
	 * 
	 *        The copy is not a replica.
	 * 
	 *        Programs using remote (IIOP) calls to a server can't create or access databases on other servers. In these cases, the server parameter must correspond to the server the program is
	 *        running on. There are two ways to do this:
	 *        <ul>
	 *        <li>Use null or an empty string ("") to indicate the current computer. This is the safer method.</li>
	 *        <li>Make sure the name of the server that the program runs on matches the name of server.</li>
	 *        </ul>
	 *        Programs running on a workstation can access several different servers in a single program.
	 * 
	 *        The ACL of the original database gets copied to the new database, but you may want to modify the copy's ACL. For example, you may want Manager access to the copy for yourself even if
	 *        you're not a manager of the original. Use the methods {@link #grantAccess(String, int)} and {@link #revokeAccess(String)} to modify the copy's ACL.
	 * 
	 * @example 1. This agent makes a local copy of the local database names.nsf
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
	 *       Database db = session.getDatabase(null, "names");
	 *       String title = db.getTitle();
	 *       Database db2 = db.createCopy(null, "names2");
	 *       db2.setTitle("Copy of names");
	 *       System.out.println
	 *       ("Database \"" + title + "\" copied locally");
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * </pre>
	 * 
	 *          2. This agent makes a local copy of the local database names.nsf and sets the maxsize to 2.
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
	 * 			Database db = session.getDatabase(null, &quot;names&quot;);
	 * 			String title = db.getTitle();
	 * 			Database db2 = db.createCopy(null, &quot;names2&quot;, 2);
	 * 			db2.setTitle(&quot;Copy of names&quot;);
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; copied locally&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase createCopy(String server, String dbFile, int maxSize) throws NotesApiException;

	/**
	 * Creates a document in a database and returns a Document object that represents the new document.
	 * 
	 * @return The new document.
	 * @throws NotesApiException
	 * @usage You must call {@link NotesDocument#save()} if you want the new document to be saved.
	 * @example This agent creates a new document in the current database, sets values for its Form, Subject, Categories, and Body items, and saves it.
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
	 * 			Document doc = db.createDocument();
	 * 			doc.appendItemValue(&quot;Form&quot;, &quot;Main Topic&quot;);
	 * 			doc.appendItemValue(&quot;Subject&quot;, &quot;Test Document&quot;);
	 * 			doc.appendItemValue(&quot;Categories&quot;, &quot;Test Documents&quot;);
	 * 			RichTextItem rti = doc.createRichTextItem(&quot;Body&quot;);
	 * 			rti.appendText(&quot;This  is the first sentence of text.&quot;);
	 * 			rti.appendText(&quot; This is the second sentence of text.&quot;);
	 * 			if (doc.save())
	 * 				System.out.println(&quot;Document has been saved&quot;);
	 * 			else
	 * 				System.out.println(&quot;Unable to save document&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument createDocument() throws NotesApiException;

	/**
	 * Creates a new database from an existing database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify null or an empty string ("") to create a database on the current computer.
	 * @param dbFile
	 *            The file name of the new database.
	 * @param inherit
	 *            Specify true if you want the new database to inherit future design changes from the template; otherwise, specify false.
	 * @return The new database, which contains the forms, subforms, fields, views, folders, navigators, agents, and documents of the template.
	 * @throws NotesApiException
	 * 
	 * @usage If a database with the specified file name already exists, an exception is thrown.
	 * 
	 *        The new database has the design elements and documents of the existing database.
	 * 
	 *        If "Database file is a master template" is set in the current database, the ACL of the new database takes the following entries:
	 * 
	 *        <ul>
	 *        <li>The current user with Manager access.</li>
	 *        <li>The server containing the database with Manager access, if the new database is on a server.</li>
	 *        <li>"-Default-" with indeterminate access. You should explicitly set the access for -Default- after creating the database.</li>
	 *        <li>Any bracketed names in the ACL of the existing database with the brackets removed; for example, "[Mary Brackets]" in the existing ACL becomes "Mary Brackets" in the new ACL. No other
	 *        entries are copied from the existing ACL.</li>
	 *        </ul>
	 *        If "Database file is a master template" is not set in the current database, the ACL of the current database is copied to the new database.<br>
	 * 
	 *        If "Database file is a master template" is set in the current database and the new database is on a server, that server is set as the administration server for the new database.<br>
	 * 
	 *        Programs making remote (IIOP) calls to a server can't create or access databases on other servers. In these cases, the server parameter must correspond to the server the program is
	 *        running on. There are two ways to do this:
	 * 
	 *        Use null or an empty string ("") to indicate the current computer. This is the safer method. Make sure the name of the server that the program runs on matches the name of the server
	 *        parameter. Programs running on a workstation can access several different servers in a single program.
	 * @example This agent creates a new database from the discussion template
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = 
	 *           session.getAgentContext();
	 *       // (Your code goes here) 
	 *       Database template = session.getDatabase(null,
	 *       &quot;discsw50.ntf&quot;);
	 *       Database newdb = template.createFromTemplate
	 *       (null, &quot;suggest&quot;, true);
	 *       newdb.setTitle(&quot;Suggestions for Giving Campaign&quot;);
	 *       newdb.grantAccess(&quot;-Default-&quot;, ACL.LEVEL_READER);
	 *       System.out.println(&quot;\&quot;Suggestions for Giving 
	 *       Campagn\&quot; created&quot;);
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit) throws NotesApiException;

	/**
	 * Creates a new database from an existing database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify null or an empty string ("") to create a database on the current computer.
	 * @param dbFile
	 *            The file name of the new database.
	 * @param inherit
	 *            Specify true if you want the new database to inherit future design changes from the template; otherwise, specify false.
	 * @param maxSize
	 *            The maximum size (in gigabytes) that you would like to assign to the new database. This parameter applies only to Release 4 databases or those created on a server that has not been
	 *            upgraded to Release 5. Entering an integer greater than 4 generates a run-time error.
	 * @return The new database, which contains the forms, subforms, fields, views, folders, navigators, agents, and documents of the template.
	 * @throws NotesApiException
	 * @usage If a database with the specified file name already exists, an exception is thrown.
	 * 
	 *        The new database has the design elements and documents of the existing database.
	 * 
	 *        If "Database file is a master template" is set in the current database, the ACL of the new database takes the following entries:
	 * 
	 *        <ul>
	 *        <li>The current user with Manager access.</li>
	 *        <li>The server containing the database with Manager access, if the new database is on a server.</li>
	 *        <li>"-Default-" with indeterminate access. You should explicitly set the access for -Default- after creating the database.</li>
	 *        <li>Any bracketed names in the ACL of the existing database with the brackets removed; for example, "[Mary Brackets]" in the existing ACL becomes "Mary Brackets" in the new ACL. No other
	 *        entries are copied from the existing ACL.</li>
	 *        </ul>
	 *        If "Database file is a master template" is not set in the current database, the ACL of the current database is copied to the new database.<br>
	 * 
	 *        If "Database file is a master template" is set in the current database and the new database is on a server, that server is set as the administration server for the new database.<br>
	 * 
	 *        Programs making remote (IIOP) calls to a server can't create or access databases on other servers. In these cases, the server parameter must correspond to the server the program is
	 *        running on. There are two ways to do this:
	 * 
	 *        Use null or an empty string ("") to indicate the current computer. This is the safer method. Make sure the name of the server that the program runs on matches the name of the server
	 *        parameter. Programs running on a workstation can access several different servers in a single program.
	 * @example This agent creates a new database from the discussion template
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = 
	 *           session.getAgentContext();
	 *       // (Your code goes here) 
	 *       Database template = session.getDatabase(null,
	 *       &quot;discsw50.ntf&quot;);
	 *       Database newdb = template.createFromTemplate
	 *       (null, &quot;suggest&quot;, true);
	 *       newdb.setTitle(&quot;Suggestions for Giving Campaign&quot;);
	 *       newdb.grantAccess(&quot;-Default-&quot;, ACL.LEVEL_READER);
	 *       System.out.println(&quot;\&quot;Suggestions for Giving 
	 *       Campagn\&quot; created&quot;);
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase createFromTemplate(String server, String dbFile, boolean inherit, int maxSize) throws NotesApiException;

	/**
	 * Creates a full-text index for a database.
	 * 
	 * @param options
	 *            Combine options with addition.
	 *            <ul>
	 *            <li>Database.FTINDEX_ALL_BREAKS (4) to index sentence and paragraph breaks</li>
	 *            <li>Database.FTINDEX_ATTACHED_BIN_FILES (16) to index attached files (binary)</li>
	 *            <li>Database.FTINDEX_ATTACHED_FILES (1) to index attached files (raw text)</li>
	 *            <li>Database.FTINDEX_CASE_SENSITIVE (8) to enable case-sensitive searches</li>
	 *            <li>Database.FTINDEX_ENCRYPTED_FIELDS (2) to index encrypted fields</li>
	 *            </ul>
	 * @param recreate
	 *            A true removes any existing full-text index before creating one. If this parameter is false and an index exists, no action is taken.
	 * @throws NotesApiException
	 * @usage This method works only for local databases.
	 * @example This agent creates or recreates a full-text index in the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			int options = Database.FTINDEX_ALL_BREAKS + Database.FTINDEX_CASE_SENSITIVE;
	 * 			if (db.isFTIndexed()) {
	 * 				db.createFTIndex(options, true);
	 * 				System.out.println(&quot;Database index recreated&quot;);
	 * 			} else {
	 * 				db.createFTIndex(options, false);
	 * 				System.out.println(&quot;New database index created&quot;);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void createFTIndex(int options, boolean recreate) throws NotesApiException;

	/**
	 * Creates a replica of the current database at a new location
	 * 
	 * @param server
	 *            The name of the server where the replica will reside. Specify null or an empty string ("") to create a replica on the current computer
	 * @param dbFile
	 *            The file name of the replica
	 * @return The new replica
	 * @throws NotesApiException
	 * @usage If a database with the specified file name already exists, an exception is thrown.
	 * 
	 *        The new replica has the same access control list as the current database.
	 * 
	 *        Programs making remote (IIOP) calls to a server can't create or access databases on other servers. In these cases, the server parameter must correspond to the server the program is
	 *        running on. There are two ways to do this:
	 *        <ul>
	 *        <li>
	 *        Use null or an empty string ("") to indicate the current computer. This is the safer method.</li>
	 *        <li>Make sure the name of the server that the program runs on matches the name of the server parameter.</li>
	 *        </ul>
	 *        Programs running on a workstation can access several different servers in a single program
	 * @example This agent creates a replica of the Domlog.nsf from notesua1 on the current computer
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
	 * 			Database db = session.getDatabase(&quot;notesua1&quot;, &quot;Domlog&quot;);
	 * 			String title = db.getTitle();
	 * 			Database replica = db.createReplica(null, &quot;Domlog&quot;);
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has a new local replica&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase createReplica(String server, String dbFile) throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database.
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that follows.
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When the collection is sorted by relevance, the highest relevance appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.</li>
	 *            <li>Database.FT_DATECREATED_DES sorts by document creation date in descending order.</li>
	 *            <li>Database.FT_DATECREATED_ASC sorts by document creation date in ascending order.</li>
	 *            <li>Database.FT_DATE_DES sorts by document date in descending order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document date in ascending order.</li>
	 *            </ul>
	 * @return A collection of documents that match the full-text query, sorted by the selected option. If no matches are found, the collection has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearchRange minus the start parameter.<br>
	 * 
	 *        If the database is not full-text indexed, this method works, but less efficiently. To test for an index, use the IsFTIndexed property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for indexed databases or databases that are not indexed but
	 *        that are running in an agent on the client. For a database that is not indexed and is running in an agent on the server, you must set the TEMP_INDEX_MAX_DOC Notes.ini variable as well.
	 *        The absolute maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only documents found in a particular view, use the FTSearch method in View. To search only documents found in a particular
	 *        document collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents sorted by relevance score. If you ask for a sort by date, you don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the relevance score, depending on the sort options you use in the document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a multi-database search. Navigation through the resulting document collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is, except that search keywords must be enclosed in quotes. Remember to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the complete syntax rules, see "Refining a search query using operators" in Lotus Notes Help. Search for "query syntax" in the
	 *        Domino Designer Eclipse help system or information center (for example, http://publib.boulder .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include Lotus Notes.
	 * @example 1. This agent searches the current database for the phrase specified in the agent's comment if the database is full-text indexed. Every document, up to a maximum of 100 documents
	 *          containing the phrase is placed into a document collection
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			String title = db.getTitle();
	 * 			if (db.isFTIndexed()) {
	 * 				DocumentCollection dc = db.FTSearch(agent.getComment(), 100);
	 * 				int matches = dc.getCount();
	 * 				System.out.println(&quot;FTSearch of \&quot;&quot; + title + &quot;\&quot; found &quot; + matches + &quot; document(s) with &quot; + agent.getComment());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is not full-text indexed&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This code fragment collects all documents containing both the words "red" and "blue."
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red &amp; blue&quot;, 100);
	 * </pre>
	 * 
	 *          3. This code fragment collects all documents containing either the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red | blue&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 * 
	 *          4. This code fragment collects all documents that do not contain the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;not (red | blue)&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 */
	public abstract NotesDocumentCollection FTSearch(String query, int sortOpt) throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database.
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that follows.
	 * @return A collection of documents that match the full-text query, sorted by the selected option. If no matches are found, the collection has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearchRange minus the start parameter.<br>
	 * 
	 *        If the database is not full-text indexed, this method works, but less efficiently. To test for an index, use the IsFTIndexed property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for indexed databases or databases that are not indexed but
	 *        that are running in an agent on the client. For a database that is not indexed and is running in an agent on the server, you must set the TEMP_INDEX_MAX_DOC Notes.ini variable as well.
	 *        The absolute maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only documents found in a particular view, use the FTSearch method in View. To search only documents found in a particular
	 *        document collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents sorted by relevance score. If you ask for a sort by date, you don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the relevance score, depending on the sort options you use in the document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a multi-database search. Navigation through the resulting document collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is, except that search keywords must be enclosed in quotes. Remember to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the complete syntax rules, see "Refining a search query using operators" in Lotus Notes Help. Search for "query syntax" in the
	 *        Domino Designer Eclipse help system or information center (for example, http://publib.boulder .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include Lotus Notes.
	 * @example 1. This agent searches the current database for the phrase specified in the agent's comment if the database is full-text indexed. Every document, up to a maximum of 100 documents
	 *          containing the phrase is placed into a document collection
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			String title = db.getTitle();
	 * 			if (db.isFTIndexed()) {
	 * 				DocumentCollection dc = db.FTSearch(agent.getComment(), 100);
	 * 				int matches = dc.getCount();
	 * 				System.out.println(&quot;FTSearch of \&quot;&quot; + title + &quot;\&quot; found &quot; + matches + &quot; document(s) with &quot; + agent.getComment());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is not full-text indexed&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This code fragment collects all documents containing both the words "red" and "blue."
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red &amp; blue&quot;, 100);
	 * </pre>
	 * 
	 *          3. This code fragment collects all documents containing either the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red | blue&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 * 
	 *          4. This code fragment collects all documents that do not contain the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;not (red | blue)&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 */
	public abstract NotesDocumentCollection FTSearch(String query) throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database.
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that follows.
	 * @param max
	 *            The maximum number of documents you want returned from the query. Set this parameter to 0 to receive all matching documents (up to 5,000. See Usage section below).
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When the collection is sorted by relevance, the highest relevance appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.</li>
	 *            <li>Database.FT_DATECREATED_DES sorts by document creation date in descending order.</li>
	 *            <li>Database.FT_DATECREATED_ASC sorts by document creation date in ascending order.</li>
	 *            <li>Database.FT_DATE_DES sorts by document date in descending order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document date in ascending order.</li>
	 *            </ul>
	 * @param otherOpt
	 *            Integer. Use the following constants to specify additional search options. To specify more than one option, use a logical or operation.
	 *            <ul>
	 *            <li>
	 *            Database.FT_FUZZY specifies a fuzzy search.</li>
	 *            <li>
	 *            Database.FT_STEMS uses stem words as the basis of the search.</li>
	 *            </ul>
	 * @return A collection of documents that match the full-text query, sorted by the selected option. If no matches are found, the collection has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearchRange minus the start parameter.<br>
	 * 
	 *        If the database is not full-text indexed, this method works, but less efficiently. To test for an index, use the IsFTIndexed property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for indexed databases or databases that are not indexed but
	 *        that are running in an agent on the client. For a database that is not indexed and is running in an agent on the server, you must set the TEMP_INDEX_MAX_DOC Notes.ini variable as well.
	 *        The absolute maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only documents found in a particular view, use the FTSearch method in View. To search only documents found in a particular
	 *        document collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents sorted by relevance score. If you ask for a sort by date, you don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the relevance score, depending on the sort options you use in the document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a multi-database search. Navigation through the resulting document collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is, except that search keywords must be enclosed in quotes. Remember to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the complete syntax rules, see "Refining a search query using operators" in Lotus Notes Help. Search for "query syntax" in the
	 *        Domino Designer Eclipse help system or information center (for example, http://publib.boulder .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include Lotus Notes.
	 * @example 1. This agent searches the current database for the phrase specified in the agent's comment if the database is full-text indexed. Every document, up to a maximum of 100 documents
	 *          containing the phrase is placed into a document collection
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			String title = db.getTitle();
	 * 			if (db.isFTIndexed()) {
	 * 				DocumentCollection dc = db.FTSearch(agent.getComment(), 100);
	 * 				int matches = dc.getCount();
	 * 				System.out.println(&quot;FTSearch of \&quot;&quot; + title + &quot;\&quot; found &quot; + matches + &quot; document(s) with &quot; + agent.getComment());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is not full-text indexed&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This code fragment collects all documents containing both the words "red" and "blue."
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red &amp; blue&quot;, 100);
	 * </pre>
	 * 
	 *          3. This code fragment collects all documents containing either the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red | blue&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 * 
	 *          4. This code fragment collects all documents that do not contain the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;not (red | blue)&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 */
	public abstract NotesDocumentCollection FTSearch(String query, int max, int sortOpt, int otherOpt) throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that follows
	 * @param max
	 *            The maximum number of documents you want returned from the query. Set this parameter to 0 to receive all matching documents
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When the collection is sorted by relevance, the highest relevance appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.</li>
	 *            <li>
	 *            Database.FT_DATECREATED_DES sorts by document creation date in descending order</li>
	 *            <li>
	 *            Database.FT_DATECREATED_ASC sorts by document creation date in ascending order</li>
	 *            <li>
	 *            Database.FT_DATE_DES sorts by document date in descending order</li>
	 *            <li>
	 *            Database.FT_DATE_ASC sorts by document date in ascending order</li>
	 *            <ul>
	 * @param otherOpt
	 *            Integer. Use the following constants to specify additional search options. To specify more than one option, use a logical or operation.
	 *            <ul>
	 *            <li>
	 *            Database.FT_FUZZY specifies a fuzzy search</li>
	 *            <li>
	 *            Database.FT_STEMS uses stem words as the basis of the search</li>
	 *            </ul>
	 * @param start
	 *            The starting document to return
	 * @return A collection of documents that match the full-text query, sorted by the selected option. If no matches are found, the collection has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearch plus the start parameter.<br>
	 *        If the database is not full-text indexed, this method works, but less efficiently. To test for an index, use the IsFTIndexed property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for indexed databases or databases that are not indexed but
	 *        that are running in an agent on the client. For a database that is not indexed and is running in an agent on the server, you must set the TEMP_INDEX_MAX_DOC Notes.ini variable as well.
	 *        The absolute maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only documents found in a particular view, use the FTSearch method in View. To search only documents found in a particular
	 *        document collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents sorted by relevance score. If you ask for a sort by date, you don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the relevance score, depending on the sort options you use in the document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a multi-database search. Navigation through the resulting document collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is, except that search keywords must be enclosed in quotes. Remember to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the complete syntax rules, see "Refining a search query using operators" in Lotus Notes Help. Search for "query syntax" in the
	 *        Domino Designer Eclipse help system or information center (for example, http://publib.boulder .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include Lotus Notes.
	 * @example This agent returns all the documents in the current database that contain a user-specified string, in groups of eight
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			// Update full-text index
	 * 			db.updateFTIndex(true);
	 * 			// Get query and put in quotes
	 * 			String query = agentContext.getCurrentAgent().getComment();
	 * 			if (query.length() != 0) {
	 * 				query = &quot;\&quot;&quot; + query + &quot;\&quot;&quot;;
	 * 				// Get the first 8 documents that match the query
	 * 				int start = 1;
	 * 				DocumentCollection dc = db.FTSearchRange(query, 8, Database.FT_SCORES, Database.FT_STEMS, start);
	 * 				while (dc.getCount() &gt; 0) {
	 * 					// Display subject for documents matching query
	 * 					System.out.println(&quot;Search results &quot; + start + &quot; - &quot; + (start - 1 + dc.getCount()));
	 * 					Document doc = dc.getFirstDocument();
	 * 					while (doc != null) {
	 * 						System.out.println(&quot;\t&quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 						doc = dc.getNextDocument(doc);
	 * 					}
	 * 					// Get next 8 documents that match the query
	 * 					start = start + 8;
	 * 					dc = db.FTSearchRange(query, 8, Database.FT_SCORES, Database.FT_STEMS, start);
	 * 				}
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
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
	 * Finds an agent in a database, given the agent name
	 * 
	 * @param name
	 *            The name of the agent
	 * @return The agent whose name matches the parameter
	 * @throws NotesApiException
	 * @usage The return value is null if the current user (as obtained by Session.getUserName) is not the owner of the private agent
	 * @example This agent prints the owner, last run date, and query for the agent named "Update Thread Maps."
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
	 * 			Agent agent = db.getAgent(&quot;My Agent&quot;);
	 * 			System.out.println(&quot;Agent:\t&quot; + agent.getName());
	 * 			System.out.println(&quot;Owner:\t&quot; + agent.getOwner());
	 * 			System.out.println(&quot;Last run:\t&quot; + agent.getLastRun());
	 * 			System.out.println(&quot;Query:\t&quot; + agent.getQuery());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
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
	 * The categories under which a database appears in the Database Library. Multiple categories are separated by a comma or semicolon
	 * 
	 * @return The categories under which a database appears in the Database Library. Multiple categories are separated by a comma or semicolon
	 * @throws NotesApiException
	 * @usage A database retrieved through getFirstDatabase or getNextDatabase in DbDirectory does not have to be open for getCategories. Otherwise, the database must be open
	 * @example 1. This agent prints the categories of the current database
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
	 * 			String cat = db.getCategories();
	 * 			if (cat != &quot;&quot;)
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has the categories: &quot; + cat);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has no categories&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the Categories property of the current database to "Examples database."
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
	 * 			db.setCategories(&quot;Examples database&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getCategories() throws NotesApiException;

	/**
	 * The categories under which a database appears in the Database Library. Multiple categories are separated by a comma or semicolon
	 * 
	 * @param categories
	 *            The categories under which a database appears in the Database Library. Multiple categories are separated by a comma or semicolon
	 * @throws NotesApiException
	 * @usage A database retrieved through getFirstDatabase or getNextDatabase in DbDirectory does not have to be open for getCategories. Otherwise, the database must be open
	 * @example 1. This agent prints the categories of the current database
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
	 * 			String cat = db.getCategories();
	 * 			if (cat != &quot;&quot;)
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has the categories: &quot; + cat);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has no categories&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the Categories property of the current database to "Examples database."
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
	 * 			db.setCategories(&quot;Examples database&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setCategories(String categories) throws NotesApiException;

	/**
	 * The date a database was created
	 * 
	 * @return The date a database was created
	 * @throws NotesApiException
	 * @usage The database must be open to use this property
	 * @example This agent prints the creation date of the current database
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
	 * 			String created = db.getCreated().getLocalTime();
	 * 			String title = db.getTitle();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; was created on &quot; + created);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDateTime getCreated() throws NotesApiException;

	/**
	 * The current user's access level to a database
	 * 
	 * @return The current user's access level to a database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>ACL.LEVEL_AUTHOR</li>
	 *              <li>ACL.LEVEL_DEPOSITOR</li>
	 *              <li>ACL.LEVEL_DESIGNER</li>
	 *              <li>ACL.LEVEL_EDITOR</li>
	 *              <li>ACL.LEVEL_MANAGER</li>
	 *              <li>ACL.LEVEL_NOACCESS</li>
	 *              <li>ACL.LEVEL_READER</li>
	 *              </ul>
	 * @usage If a program runs on a workstation or is remote (IIOP), CurrentAccessLevel is determined by the access level of the current user.
	 * 
	 *        If a program runs on a server, CurrentAccessLevel is determined by the access level of the person who last saved the program (the owner).
	 * 
	 *        The database must be open to use this property.
	 * @example This example prints a message indicating the current user's access level to the current database
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
	 * 			int level = db.getCurrentAccessLevel();
	 * 			System.out.print(&quot;For database \&quot;&quot; + title + &quot;\&quot; you have &quot;);
	 * 			switch (level) {
	 * 			case (ACL.LEVEL_NOACCESS):
	 * 				System.out.print(&quot;No access&quot;);
	 * 				break;
	 * 			case (ACL.LEVEL_DEPOSITOR):
	 * 				System.out.print(&quot;Depositor access&quot;);
	 * 				break;
	 * 			case (ACL.LEVEL_READER):
	 * 				System.out.print(&quot;Reader access&quot;);
	 * 				break;
	 * 			case (ACL.LEVEL_AUTHOR):
	 * 				System.out.print(&quot;Author access&quot;);
	 * 				break;
	 * 			case (ACL.LEVEL_EDITOR):
	 * 				System.out.print(&quot;Editor access&quot;);
	 * 				break;
	 * 			case (ACL.LEVEL_DESIGNER):
	 * 				System.out.print(&quot;Designer access&quot;);
	 * 				break;
	 * 			case (ACL.LEVEL_MANAGER):
	 * 				System.out.print(&quot;Manager access&quot;);
	 * 				break;
	 * 			default:
	 * 				System.out.print(&quot;Unknown access&quot;);
	 * 				break;
	 * 			}
	 * 			System.out.print(&quot;\n&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getCurrentAccessLevel() throws NotesApiException;

	/**
	 * The name of the design template from which a database inherits its design. If the database does not inherit its design from a design template, returns an empty string
	 * 
	 * @return The name of the design template from which a database inherits its design. If the database does not inherit its design from a design template, returns an empty string
	 * @throws NotesApiException
	 * @usage If a database inherits a specific design element (such as a form) but not its entire design from a template, this property returns an empty string.
	 * 
	 *        A database does not need to be open to use this property
	 * @example This agent prints the design template name for the current database if one exists
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
	 * 			String template = db.getDesignTemplateName();
	 * 			if (template != &quot;&quot;)
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; inherits its design from &quot; + template);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; did not inherit its design from a template&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getDesignTemplateName() throws NotesApiException;

	/**
	 * Finds a document in a database, given the document note ID
	 * 
	 * @param noteID
	 *            The note ID of a document
	 * @return The document whose note ID matches the parameter
	 * @throws NotesApiException
	 * @usage For an explanation of note IDs, see the NoteID property in Document.
	 * 
	 *        If you get a note ID from @NoteID, delete the "NT" prefix
	 * @example This agent gets the document in the current database whose note ID is the agent comment, if such a document exists, and prints the value of the Subject item
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Document doc = db.getDocumentByID(agent.getComment());
	 * 			System.out.println(&quot;Document &quot; + agent.getComment() + &quot; has the subject: &quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getDocumentByID(String noteID) throws NotesApiException;

	/**
	 * Finds a document in a database, given the document universal ID (UNID).
	 * 
	 * @param unid
	 *            The universal ID of a document
	 * @return The document whose universal ID matches the parameter
	 * @throws NotesApiException
	 * @usage For an explanation of universal IDs, see getUniversalID in Document. You can obtain the universal ID from getUniversalID or getParentDocumentUNID in Document.
	 * 
	 *        Not matching the UNID to a document in the database throws NotesError.NOTES_ERR_BAD_UNID (4091).
	 * @example 1. This agent gets the parents of all the response documents in the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DocumentCollection dc = db.getAllDocuments();
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				if (doc.isResponse()) {
	 * 					Document pdoc = db.getDocumentByUNID(doc.getParentDocumentUNID());
	 * 					String docSubj = doc.getItemValueString(&quot;Subject&quot;);
	 * 					String pdocSubj = pdoc.getItemValueString(&quot;Subject&quot;);
	 * 					System.out.println(&quot;\&quot;&quot; + pdocSubj + &quot;\&quot; has the response \&quot;&quot; + docSubj + &quot;\&quot;&quot;);
	 * 				}
	 * 				doc = dc.getNextDocument(doc);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent demonstrates catching NotesError.NOTES_ERR_BAD_UNID. The UNID is deliberately altered to cause the error
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DocumentCollection dc = db.getAllDocuments();
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				if (doc.isResponse()) {
	 * 					String docSubj = &quot;&quot;;
	 * 					try {
	 * 						docSubj = doc.getItemValueString(&quot;Subject&quot;);
	 * 						// Deliberately munge UNID
	 * 						String badUNID = &quot;Z&quot; + doc.getParentDocumentUNID().substring(1);
	 * 						Document pdoc = db.getDocumentByUNID(badUNID);
	 * 						String pdocSubj = pdoc.getItemValueString(&quot;Subject&quot;);
	 * 						System.out.println(&quot;\&quot;&quot; + pdocSubj + &quot;\&quot; has the response \&quot;&quot; + docSubj + &quot;\&quot;&quot;);
	 * 					} catch (NotesException ne) {
	 * 						if (ne.id == NotesError.NOTES_ERR_BAD_UNID)
	 * 							System.out.println(&quot;Bad UNID for \&quot;&quot; + docSubj + &quot;\&quot;&quot;);
	 * 						else
	 * 							throw ne;
	 * 					}
	 * 				}
	 * 				doc = dc.getNextDocument(doc);
	 * 			}
	 * 
	 * 		} catch (NotesException ne) {
	 * 			System.out.println(ne.id + &quot; &quot; + ne.text);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getDocumentByUNID(String unid) throws NotesApiException;

	/**
	 * Instantiates a document in the database on which it is called and returns a Document object for it. This method is typically used for either the Server Web Navigator or Personal Web Navigator
	 * database, but can be called on any Database object
	 * 
	 * @param url
	 *            The desired uniform resource locator (URL), for example, http://www.acme.com. Specify the entire URL starting with http. You can enter a maximum string length of 15K
	 * @param reload
	 *            Specify true to reload the page from its Internet server. Specify false to load the page from the Internet only if it is not already in the Web Navigator database
	 * @return The Notes document that represents the URL document you specified
	 * @throws NotesApiException
	 * @example This agent prints the value of the Subject item for the Lotus home page
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
	 * 			Document doc = db.getDocumentByURL(&quot;http://www.lotus.com&quot;, false);
	 * 			System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getDocumentByURL(String url, boolean reload) throws NotesApiException;

	/**
	 * Instantiates a document in the database on which it is called and returns a Document object for it. This method is typically used for either the Server Web Navigator or Personal Web Navigator
	 * database, but can be called on any Database object
	 * 
	 * @param url
	 *            The desired uniform resource locator (URL), for example, http://www.acme.com. Specify the entire URL starting with http. You can enter a maximum string length of 15K
	 * @param reload
	 *            Specify true to reload the page from its Internet server. Specify false to load the page from the Internet only if it is not already in the Web Navigator database
	 * @param relIfMod
	 *            (Defaults to the specification for the second parameter) Specify true to reload the page only if it has been modified on its Internet server, false to load the page from the Internet
	 *            only if it is not already in the Web Navigator database
	 * @param urlList
	 *            (Defaults to false) Web pages can contain URL links to other Web pages. You can specify whether to save the URLs in a field called URLLinksn in the Notes document. (The Web Navigator
	 *            creates a new URLLinksn field each time the field size reaches 64K. For example, the first URLLinks field is URLLinks1, the second is URLLinks2, and so on.)<br>
	 * 
	 *            Specify true if you want to save the URLs in the URLLinksn field(s). Specify false if you do not want to save the URLs in the URLLinksn field(s). If you save the URLs, you can use
	 *            them in agents. For example, you can create an agent that opens Web pages in the Web Navigator database and then loads all the Web pages saved in each of the URLLinksn field(s). <br>
	 * 
	 *            <b>Note</b> Saving URLs in the URLLinksn field(s) may affect performance
	 * 
	 * @param charset
	 *            (Defaults to null) Enter the MIME character set (for example, ISO-2022-JP for Japanese or ISO-8859-1 for United States) that you want the Web Navigator to use when processing the Web
	 *            page
	 * @param webUser
	 *            (Defaults to null.) Some Internet servers require you to obtain a username before you can access their pages. This parameter allows you to enter the username that you previously
	 *            obtained from the Full-text server
	 * @param webPasswd
	 *            (Defaults to null) Some full-text servers require you to obtain a password before you can access their pages. This parameter allows you to enter the password that you previously
	 *            obtained from the Internet server
	 * @param proxyUser
	 *            (Defaults to null) Some proxy servers require that you specify a username in order to connect through them. This parameter allows you to enter the username for the proxy server. See
	 *            your administrator for the username required by the proxy
	 * @param proxyPasswd
	 *            (Defaults to null) Some proxy servers require that you specify a password in order to connect through them. This parameter allows you to enter the password for the proxy server. See
	 *            your administrator for the password required by the proxy
	 * @param returnImmediately
	 *            (Defaults to false) Specify true to return immediately and not wait for completion of the retrieval. If you specify true, getDocumentByURL does not return the Document object
	 *            representing the URL document. This parameter is useful for offline storage purposes; in this case, you do not need the Document object and do not have to wait for completion of the
	 *            operation. This parameter is ignored and false is forced if the database being opened is not local to the execution context
	 * @return The Notes document that represents the URL document you specified
	 * @throws NotesApiException
	 * @example This agent prints the value of the Subject item for the Lotus home page
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
	 * 			Document doc = db.getDocumentByURL(&quot;http://www.lotus.com&quot;, false);
	 * 			System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getDocumentByURL(String url, boolean reload, boolean relIfMod, boolean urlList, String charset, String webUser, String webPasswd, String proxyUser,
			String proxyPasswd, boolean returnImmediately) throws NotesApiException;

	/**
	 * Retrieves the profile documents associated with a profile form
	 * 
	 * @param profileName
	 *            The name or an alias of the profile form
	 * @return The profile documents. No profile documents results in an empty collection
	 * @throws NotesApiException
	 * @example This agent gets all the profile documents for the form "Author Profile."
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
	 * 			DocumentCollection dc = db.getProfileDocCollection(&quot;Author Profile&quot;);
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				System.out.println(doc.getItemValueString(&quot;Who&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getProfileDocCollection(String profileName) throws NotesApiException;

	/**
	 * Creates a note collection based on the current database and returns a NoteCollection object that represents the note collection.
	 * 
	 * @param selectAllFlag
	 *            Sets all the "Select" note collection properties true or false
	 * @return The new note collection
	 * @throws NotesApiException
	 * @usage For more information, see the {@link NotesNoteCollection} class
	 * @example This agent builds a note collection consisting of the documents in the database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			// Open DXL file named after current database
	 * 			Stream stream = session.createStream();
	 * 			String filename = &quot;c:\\dxl\\&quot;;
	 * 			filename = filename + db.getFileName();
	 * 			filename = filename.substring(0, filename.length() - 3) + &quot;dxl&quot;;
	 * 			if (stream.open(filename)) {
	 * 				System.out.println(&quot;Opened &quot; + filename);
	 * 				stream.truncate();
	 * 
	 * 				// Create note collection
	 * 				NoteCollection nc = db.createNoteCollection(false);
	 * 				nc.setSelectDocuments(true);
	 * 				nc.buildCollection();
	 * 
	 * 				// Export note collection as DXL
	 * 				DxlExporter exporter = session.createDxlExporter();
	 * 				String output = exporter.exportDxl(nc);
	 * 				stream.writeText(output);
	 * 				stream.close();
	 * 			} else {
	 * 				System.out.println(&quot;Cannot open &quot; + filename);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesNoteCollection createNoteCollection(boolean selectAllFlag) throws NotesApiException;

	/**
	 * The file name of a database, excluding the path
	 * 
	 * @return The file name of a database, excluding the path
	 * @throws NotesApiException
	 * @usage A database does not need to be open to use this property
	 * @example This agent prints the title and name of the current database
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
	 * 			String name = db.getFileName();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has the file name &quot; + name);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getFileName() throws NotesApiException;

	/**
	 * The path and file name of a database
	 * 
	 * @return The path and file name of a database
	 * @throws NotesApiException
	 * @usage If the database is open and on the Notes workstation, FilePath returns the complete path (for example, C:\Notes\data\sub\db.nsf).
	 * 
	 *        If the database is on a Domino server, or closed on the Notes workstation, FilePath returns the path relative to the data directory (for example, sub\db.nsf).
	 * 
	 *        If the database is accessed through a directory or database link, FilePath returns the link location if the code is running locally (even if the database is on a server) so that the
	 *        database appears to be where the link is. FilePath returns the actual database location if the code is running on a server (for example, a scheduled agent).
	 * 
	 *        A database does not need to be open to use this property
	 * @example This agent prints the title and path of the current database
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
	 * 			String path = db.getFilePath();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has the file path &quot; + path);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getFilePath() throws NotesApiException;

	/**
	 * Indicates whether this database maintains folder references for documents
	 * 
	 * @return Indicates whether this database maintains folder references for documents
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true maintains folder references</li>
	 *              <li>false (default) does not maintain folder references</li>
	 *              </ul>
	 * @usage The database must have the $FolderInfo and $FolderRefInfo hidden views to support folder references. These views can be copied from the mail template. This property does not return view
	 *        references.
	 * 
	 *        The database must be at the Release 5 file format level or greater.
	 * 
	 *        Maintaining folder references impacts performance.
	 * 
	 *        The database must be open to use this property.
	 * 
	 *        For more information, see the FolderReferences property in Document.
	 * @example This agent toggles the FolderReferencesEnabled property
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
	 * 			String msg;
	 * 			if (db.getFolderReferencesEnabled()) {
	 * 				db.setFolderReferencesEnabled(false);
	 * 				msg = &quot;Folder references disabled&quot;;
	 * 			} else {
	 * 				db.setFolderReferencesEnabled(true);
	 * 				msg = &quot;Folder references enabled&quot;;
	 * 			}
	 * 			System.out.println(msg);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean getFolderReferencesEnabled() throws NotesApiException;

	/**
	 * @param bEnable
	 * @throws NotesApiException
	 */
	public abstract void setFolderReferencesEnabled(boolean bEnable) throws NotesApiException;

	/**
	 * Finds a form in a database, given the form name
	 * 
	 * @param name
	 *            The name or an alias of the form
	 * @return The form whose name or alias matches the parameter
	 * @throws NotesApiException
	 * @example This agent prints the names and aliases of the form named "Author Profile."
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
	 * 			Form form = db.getForm(&quot;Author Profile&quot;);
	 * 			System.out.println(form.getName());
	 * 			Vector aliases = form.getAliases();
	 * 			for (int i = 0; i &lt; aliases.size(); i++) {
	 * 				String alias = (String) aliases.elementAt(i);
	 * 				System.out.println(&quot;Alias  #&quot; + (i + 1) + &quot;: &quot; + alias);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesForm getForm(String name) throws NotesApiException;

	/**
	 * All the forms in a database
	 * 
	 * @return All the forms in a database
	 * @throws NotesApiException
	 * @usage The database must be open to use this property
	 * @example This example displays the names of all the forms in the current database
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
	 * 			String title = db.getTitle();
	 * 			Vector forms = db.getForms();
	 * 			System.out.println(&quot;Agents in database:&quot;);
	 * 			for (int i = 0; i &lt; forms.size(); i++) {
	 * 				String name = ((Form) forms.elementAt(i)).getName();
	 * 				System.out.println(&quot;Form #&quot; + (i + 1) + &quot;: &quot; + name);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector getForms() throws NotesApiException;

	/**
	 * Update frequency of a database's full-text index
	 * 
	 * @return Update frequency of a database's full-text index
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>Database.FTINDEX_DAILY (1)</li>
	 *              <li>Database.FTINDEX_HOURLY (3)</li>
	 *              <li>Database.FTINDEX_IMMEDIATE (4)</li>
	 *              <li>Database.FTINDEX_SCHEDULED (2)</li>
	 *              </ul>
	 * @usage This property applies only to databases on servers.
	 * 
	 *        The database must have a full-text index.
	 * 
	 *        The database must be open to use this property.
	 * @example This agent cycles the update frequency for a database with a full-text index
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			if (db.isFTIndexed()) {
	 * 				if (db.getFTIndexFrequency() == Database.FTINDEX_DAILY) {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_HOURLY);
	 * 					System.out.println(&quot;Index frequency set to hourly&quot;);
	 * 				} else if (db.getFTIndexFrequency() == Database.FTINDEX_HOURLY) {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_IMMEDIATE);
	 * 					System.out.println(&quot;Index frequency set to immediate&quot;);
	 * 				} else if (db.getFTIndexFrequency() == Database.FTINDEX_IMMEDIATE) {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_SCHEDULED);
	 * 					System.out.println(&quot;Index frequency set to scheduled&quot;);
	 * 				} else {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_DAILY);
	 * 					System.out.println(&quot;Index frequency set to daily&quot;);
	 * 				}
	 * 			} else {
	 * 				System.out.println(&quot;Database not full-text indexed&quot;);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getFTIndexFrequency() throws NotesApiException;

	/**
	 * The date that a database's full-text index was last updated
	 * 
	 * @return The date that a database's full-text index was last updated
	 * @throws NotesApiException
	 * @usage If the database does not have a full-text index:
	 *        <ul>
	 *        <li>
	 *        A local program returns null.</li>
	 *        <li>
	 *        A remote (IIOP) program returns an empty string for the following properties: GMTTime, LocalTime, and ZoneTime.</li>
	 *        </ul>
	 *        In either case, {@link #isFTIndexed()} is false.
	 * 
	 *        The database must be open to use this property
	 * @example 1. This agent prints the last update date of the full-text index for the current database if it has an index
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
	 * 			if (db.isFTIndexed()) {
	 * 				DateTime dt = db.getLastFTIndexed();
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; last full-text indexed on &quot; + dt.getDateOnly());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is not full-text indexed&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent is the same as above but checks the return value of getLastFTIndexed for existence of the index, allowing for both local and remote implementations
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * public class JavaAgent extends AgentBase {
	 *   public void NotesMain() {
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = session.getAgentContext();
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       String title = db.getTitle();
	 *       DateTime dt = db.getLastFTIndexed();
	 *       if (dt != null && dt.getLocalTime().length() > 0)
	 *         System.out.println("Database \"" + title + 
	 *               "\" last full-text indexed on " + 
	 *               dt.getDateOnly()); }
	 *       else
	 *         System.out.println("Database \"" + title +
	 *         "\" is not full-text indexed");
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDateTime getLastFTIndexed() throws NotesApiException;

	/**
	 * The date that a database was last modified
	 * 
	 * @return The date that a database was last modified
	 * @throws NotesApiException
	 * @usage The database must be open to use this property
	 * @example This agent prints the date and time that the current database was last modified
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
	 * 			String lastMod = db.getLastModified().getLocalTime();
	 * 			String title = db.getTitle();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; was last modified on &quot; + lastMod);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDateTime getLastModified() throws NotesApiException;

	/**
	 * People, servers, and groups that have Manager access to a database
	 * 
	 * @return People, servers, and groups that have Manager access to a database
	 * @throws NotesApiException
	 * @usage Each element in the vector is the name of a person, server, or group with Manager access to the database.
	 * 
	 *        The database must be open to use this property
	 * @example This agent displays the number of managers in the current database and the name of each
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
	 * 			String title = db.getTitle();
	 * 			Vector managers = db.getManagers();
	 * 			int size = managers.size();
	 * 			if (size == 1) {
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has 1 manager&quot;);
	 * 			} else {
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has &quot; + size + &quot; managers&quot;);
	 * 			}
	 * 			for (int i = 0; i &lt; size; i++) {
	 * 				String name = (String) managers.elementAt(i);
	 * 				System.out.println(&quot;Manager # &quot; + (i + 1) + &quot;: &quot; + name);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector getManagers() throws NotesApiException;

	/**
	 * The Notes session that contains a database
	 * 
	 * @return The Notes session that contains a database
	 * @throws NotesApiException
	 * @usage A database does not need to be open to use this property
	 * @example This agent prints the user name of the parent session for the current database
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
	 * 			session = db.getParent();
	 * 			System.out.println(session.getUserName());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesSession getParent() throws NotesApiException;

	/**
	 * The percent of a database's total size that is occupied by real data (and not empty space).
	 * 
	 * @return The percent of a database's total size that is occupied by real data (and not empty space).
	 * @throws NotesApiException
	 * @usage Compacting a database removes empty space in the database file.
	 * 
	 *        The database must be open to use this property
	 * @example This agent prints the percentage of the current database that contains data
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
	 * 			double percent = db.getPercentUsed();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is &quot; + percent + &quot; percent used.&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract double getPercentUsed() throws NotesApiException;

	/**
	 * Retrieves or creates a profile document
	 * 
	 * @param profile
	 *            The name or an alias of the profile form
	 * @param profileKey
	 *            The unique key associated with the profile document
	 * @return The profile document for the specified key, or a new profile document if the document with the key does not exist
	 * @throws NotesApiException
	 * @example This agent gets the profile document for the current user based on the "Author Profile" form
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
	 * 			Document doc = db.getProfileDocument(&quot;Author Profile&quot;, session.getUserName());
	 * 			String who = doc.getItemValueString(&quot;Who&quot;);
	 * 			String email = doc.getItemValueString(&quot;Email&quot;);
	 * 			String phone = doc.getItemValueString(&quot;Phone&quot;);
	 * 			System.out.println(&quot;Who: &quot; + who);
	 * 			System.out.println(&quot;Email: &quot; + email);
	 * 			System.out.println(&quot;Phone: &quot; + phone);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getProfileDocument(String profile, String profileKey) throws NotesApiException;

	/**
	 * A 16-digit hexadecimal number that represents the replica ID of a Notes database. Databases with the same replica ID are replicas of one another
	 * 
	 * @return A 16-digit hexadecimal number that represents the replica ID of a Notes database. Databases with the same replica ID are replicas of one another
	 * @throws NotesApiException
	 * @usage A database does not need to be open to use this property
	 * @example This agent prints the replica ID of the current database
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
	 * 			String repid = db.getReplicaID();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has the replica ID &quot; + repid);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getReplicaID() throws NotesApiException;

	/**
	 * The name of the server where a database resides
	 * 
	 * @return The name of the server where a database resides
	 * @throws NotesApiException
	 * @usage If the database is on a workstation, the property returns an empty string.
	 * 
	 *        A database does not need to be open to use this property
	 * @example This agent prints the name of the server for the current database
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
	 * 			String server = db.getServer();
	 * 			if (server != &quot;&quot;)
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; resides on server &quot; + server);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is local&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getServer() throws NotesApiException;

	/**
	 * The size of a database, in bytes
	 * 
	 * @return The size of a database, in bytes
	 * @throws NotesApiException
	 * @usage The database does not need to be open to use this property
	 * @example This agent prints the size of the current database
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
	 * 			double size = db.getSize();
	 * 			System.out.println(&quot;The size of database \&quot;&quot; + title + &quot;\&quot; is&quot; + (int) size + &quot; bytes&quot;);
	 * 			long maxsize = db.getMaxSize();
	 * 			System.out.println(&quot;The maximum size of database \&quot;&quot; + title + &quot;\&quot; is&quot; + maxsize + &quot; kilobytes&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract double getSize() throws NotesApiException;

	/**
	 * The size quota of a database, in kilobytes
	 * 
	 * @return The size quota of a database, in kilobytes
	 * @throws NotesApiException
	 * @usage The size quota for a database specifies the amount of disk space that the server administrator is willing to provide for the database. Therefore, the SizeQuota property can only be set
	 *        by a program that has administrator access to the server on which the database resides. The size quota is not the same as the size limit that a user specifies when creating a new
	 *        database.
	 * 
	 *        If the database has no size quota, this property returns 0.
	 * 
	 *        The database does not need to be open to use this property.
	 * @example This agent changes the size quota of the current database, and prints the old and new size quotas
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
	 * 			int oldq = db.getSizeQuota();
	 * 			db.setSizeQuota(5000);
	 * 			System.out.println(&quot;The size quota of database \&quot;&quot; + title + &quot;\&quot; is changed from &quot; + oldq + &quot; to 5000KB&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getSizeQuota() throws NotesApiException;

	/**
	 * The size quota of a database, in kilobytes
	 * 
	 * @param The
	 *            size quota of a database, in kilobytes
	 * @throws NotesApiException
	 * @usage The size quota for a database specifies the amount of disk space that the server administrator is willing to provide for the database. Therefore, the SizeQuota property can only be set
	 *        by a program that has administrator access to the server on which the database resides. The size quota is not the same as the size limit that a user specifies when creating a new
	 *        database.
	 * 
	 *        If the database has no size quota, this property returns 0.
	 * 
	 *        The database does not need to be open to use this property.
	 * @example This agent changes the size quota of the current database, and prints the old and new size quotas
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
	 * 			int oldq = db.getSizeQuota();
	 * 			db.setSizeQuota(5000);
	 * 			System.out.println(&quot;The size quota of database \&quot;&quot; + title + &quot;\&quot; is changed from &quot; + oldq + &quot; to 5000KB&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setSizeQuota(int quota) throws NotesApiException;

	/**
	 * The maximum size of a database in kilobytes
	 * 
	 * @return The maximum size of a database in kilobytes
	 * @throws NotesApiException
	 * @usage The database must be open to use this property
	 * @example This agent prints the size of the current database
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
	 * 			double size = db.getSize();
	 * 			System.out.println(&quot;The size of database \&quot;&quot; + title + &quot;\&quot; is&quot; + (int) size + &quot; bytes&quot;);
	 * 			long maxsize = db.getMaxSize();
	 * 			System.out.println(&quot;The maximum size of database \&quot;&quot; + title + &quot;\&quot; is&quot; + maxsize + &quot; kilobytes&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract long getMaxSize() throws NotesApiException;

	/**
	 * The template name of a database, if the database is a template. If the database is not a template, returns an empty string
	 * 
	 * @return The template name of a database, if the database is a template. If the database is not a template, returns an empty string
	 * @throws NotesApiException
	 * @usage A database does not need to be open to use this property
	 * @example This agent gets the template name of discuss4.ntf in the local Notes directory
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
	 * 			String template = db.getTemplateName();
	 * 			if (template != &quot;&quot;)
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has the template name &quot; + template);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is not a template&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getTemplateName() throws NotesApiException;

	/**
	 * The title of a database
	 * 
	 * @return The title of a database
	 * @throws NotesApiException
	 * @usage The database does not need to be open to use this property
	 * @example This agent appends "(Marketing)" to the title of the current database
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
	 * 			if (title.endsWith(&quot;(Marketing)&quot;))
	 * 				;
	 * 			else {
	 * 				title = title + &quot; (Marketing)&quot;;
	 * 				db.setTitle(title);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getTitle() throws NotesApiException;

	/**
	 * Database type
	 * 
	 * @return Database type
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>Database.DBTYPE_ADDR_BOOK (10) - Domino Directory or Personal Address Book</li>
	 *              <li>Database.DBTYPE_IMAP_SVR_PROXY (6) - IMAP server proxy</li>
	 *              <li>Database.DBTYPE_LIBRARY (12) - database library</li>
	 *              <li>Database.DBTYPE_LIGHT_ADDR_BOOK (9) - Directory Catalog</li>
	 *              <li>Database.DBTYPE_MAILBOX (3) - mailbox</li>
	 *              <li>Database.DBTYPE_MAILFILE (2) - mail file</li>
	 *              <li>Database.DBTYPE_MULTIDB_SRCH (8) - Domain Catalog</li>
	 *              <li>Database.DBTYPE_NEWS_SVR_PROXY (5) - news server proxy</li>
	 *              <li>Database.DBTYPE_PERS_JOURNAL (11) - Personal Journal</li>
	 *              <li>Database.DBTYPE_PORTFOLIO (7) - portfolio</li>
	 *              <li>Database.DBTYPE_STANDARD (13) - standard</li>
	 *              <li>Database.DBTYPE_SUBSCRIPTIONS (4) - subscriptions</li>
	 *              <li>Database.DBTYPE_WEB_APP (1) - Web application</li>
	 *              </ul>
	 * @usage The database must be open to use this property
	 * @example This agent gets the type of every database in the local directory
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DbDirectory dbdir = session.getDbDirectory(null);
	 * 			Database db = dbdir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			System.out.println(&quot;Local databases and types:&quot;);
	 * 			while (db != null) {
	 * 				db.open();
	 * 				System.out.println(&quot;\t&quot; + db.getTitle() + &quot; (&quot; + db.getFileName() + &quot;) &quot; + getTypeString(db.getType()));
	 * 				db = dbdir.getNextDatabase();
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * 
	 * 	String getTypeString(int type) {
	 * 		String typeString = null;
	 * 		switch (type) {
	 * 		case Database.DBTYPE_ADDR_BOOK:
	 * 			typeString = &quot;Address book&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_IMAP_SVR_PROXY:
	 * 			typeString = &quot;IMAP server proxy&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_LIBRARY:
	 * 			typeString = &quot;Library&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_LIGHT_ADDR_BOOK:
	 * 			typeString = &quot;Directory catalog (light address book)&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_MAILBOX:
	 * 			typeString = &quot;Mailbox&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_MAILFILE:
	 * 			typeString = &quot;Mail file&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_MULTIDB_SRCH:
	 * 			typeString = &quot;Multi-database search&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_NEWS_SVR_PROXY:
	 * 			typeString = &quot;News server proxy&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_PERS_JOURNAL:
	 * 			typeString = &quot;Personal journal&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_PORTFOLIO:
	 * 			typeString = &quot;Portfolio&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_STANDARD:
	 * 			typeString = &quot;Standard&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_SUBSCRIPTIONS:
	 * 			typeString = &quot;Subscriptions&quot;;
	 * 			break;
	 * 		case Database.DBTYPE_WEB_APP:
	 * 			typeString = &quot;Web application&quot;;
	 * 		}
	 * 		return typeString;
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getType() throws NotesApiException;

	/**
	 * Gets the specific Hypertext Transfer Protocol (HTTP) header information from the Uniform Resource Locator (URL). A URL is a text string used for identifying and addressing a Web resource
	 * 
	 * @param url
	 *            The URL for the Web page you want information on, for example, http://www.acme.com/. Specify the entire URL starting with http. You can enter a maximum string length of 15K
	 * @param header
	 *            Enter a header string of the URL header value you want returned. The acceptable header strings are documented in the HTTP specification (available at various locations on the
	 *            Internet, such as http://www.w3.org/) and are subject to change based on updated versions of the specification
	 * @param webUser
	 *            String. Some Internet servers require you to obtain a username before you can access their pages. This parameter allows you to enter the username that you previously obtained from
	 *            the Internet server. Specify null if you don't need this parameter
	 * @param webPasswd
	 *            String. Some Internet servers require you to obtain a password before you can access their pages. This parameter allows you to enter the password that you previously obtained from
	 *            the Internet server. Specify null if you don't need this parameter
	 * @param proxyUser
	 *            String. Some proxy servers require that you specify a username in order to connect through them. This parameter allows you to enter the username for the proxy server. See your
	 *            administrator for the username required by the proxy. Specify null if you don't need this parameter
	 * @param proxyPasswd
	 *            String. Some proxy servers require that you specify a password in order to connect through them. This parameter allows you to enter the password for the proxy server. See your
	 *            administrator for the password required by the proxy. Specify null if you don't need this parameter
	 * @return The requested header, or null if the URL or the requested header value is not found. Any dashes are converted to underscores
	 * @throws NotesApiException
	 * @example This agent gets the "Last-modified" header string for the URL specified in the agent comment.
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
	 * 			String hinfo = db.getURLHeaderInfo(&quot;http://www.lotus.com&quot;, &quot;Last-modified&quot;, null, null, null, null);
	 * 			System.out.println(&quot;www.lotus.com was last modified on &quot; + hinfo);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getURLHeaderInfo(String url, String header, String webUser, String webPasswd, String proxyUser, String proxyPasswd) throws NotesApiException;

	/**
	 * Finds a view or folder in a database, given the name or alias of the view or folder
	 * 
	 * @param name
	 *            The case-insensitive name of a view or folder in a database. Use either the entire name of the view or folder (including backslashes for cascading views and folders), or an alias
	 * @return The view or folder whose name or alias matches the parameter
	 * @throws NotesApiException
	 * @usage Using getView returns public views and folders and private views and folders that are owned by the effective id running the agent. Private views stored in the desktop are not returned.
	 * 
	 *        When specifying the parameter, do not combine the view name and an alias. For example, specifying "By Author|AuthorView" does not work. Use either the view name ("By Author") or its
	 *        alias ("AuthorView").
	 * 
	 *        When the view or folder name contains underscores to indicate menu accelerators, you have the option of including or excluding the underscores. The method works more efficiently,
	 *        however, if you include the underscores
	 * @example This agent gets the view named "(Default View)" in the current database and prints the number of columns in the view
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
	 * 			View view = db.getView(&quot;($All)&quot;);
	 * 			System.out.println(&quot;($All) has &quot; + view.getColumns().size() + &quot; columns&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView getView(String name) throws NotesApiException;

	/**
	 * The views and folders in a database
	 * 
	 * @return The views and folders in a database
	 * @throws NotesApiException
	 * @usage Each element of the vector represents a public view or folder in the database, or a private view or folder owned by the effective id running the agent and stored in the database. Private
	 *        views or folders stored in the desktop are not included.
	 * 
	 *        The database must be open to use this property
	 * @example This agent displays the names of all the views and folders in the current database
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
	 * 			String title = db.getTitle();
	 * 			Vector views = db.getViews();
	 * 			int size = views.size();
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has &quot; + size + &quot; views&quot;);
	 * 			for (int i = 0; i &lt; size; i++) {
	 * 				String name = ((View) views.elementAt(i)).getName();
	 * 				System.out.println(&quot;View #&quot; + (i + 1) + &quot;: &quot; + name);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector getViews() throws NotesApiException;

	/**
	 * Modifies a database access control list to provide a specified level of access to a person, group, or server
	 * 
	 * @param name
	 *            The name of the person, group, or server whose access level you want to provide or change. For a hierarchical name, the full name must be specified but can be in abbreviated format
	 * @param level
	 *            The level of access you're granting. Specify one of the following constants:
	 *            <ul>
	 *            <li>
	 *            ACL.LEVEL_AUTHOR</li>
	 *            <li>
	 *            ACL.LEVEL_DEPOSITOR</li>
	 *            <li>
	 *            ACL.LEVEL_DESIGNER</li>
	 *            <li>
	 *            ACL.LEVEL_EDITOR</li>
	 *            <li>
	 *            ACL.LEVEL_MANAGER</li>
	 *            <li>
	 *            ACL.LEVEL_NOACCESS</li>
	 *            <li>
	 *            ACL.LEVEL_READER</li>
	 *            </ul>
	 * @throws NotesApiException
	 * @usage If the name already exists in the ACL, this method updates it with the access. Otherwise, the name is added to the ACL with the level.
	 * 
	 *        You can also use this method to deny access to a person, group, or server by assigning LEVEL_NOACCESS.
	 * 
	 *        This method sets ACL roles to their default values
	 * @example This agent grants manager access to the user specified in the agent comment
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			db.grantAccess(agent.getComment(), ACL.LEVEL_MANAGER);
	 * 			System.out.println(agent.getComment() + &quot; has been granted manager access&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void grantAccess(String name, int level) throws NotesApiException;

	/**
	 * Indicates whether updates to a server are delayed (batched) for better performance
	 * 
	 * @return Indicates whether updates to a server are delayed (batched) for better performance
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true delays server updates; this is the default</li>
	 *              <li>false posts server updates immediately</li>
	 *              </ul>
	 * @usage If DelayUpdates is false, the program waits for updates to the server to be posted. If you set DelayUpdates to true, server updates are cached and the program proceeds immediately. At a
	 *        convenient time, the cached updates are posted. This makes for better performance but risks losing the cached updates in the event of a crash. This method applies to save and remove
	 *        operations on documents.
	 * 
	 *        Set this property each time you open a database. The property is not saved.
	 * 
	 *        The database must be open to use this property
	 * @example This agent enables delayed updates for the current database if the comment for the current agent is "DelayUpdates"
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			if (agent.getComment().equals(&quot;DelayUpdates&quot;))
	 * 				db.setDelayUpdates(true);
	 * 			else
	 * 				db.setDelayUpdates(false);
	 * 			System.out.println(&quot;Delay updates is &quot; + db.isDelayUpdates());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isDelayUpdates() throws NotesApiException;

	/**
	 * Indicates whether updates to a server are delayed (batched) for better performance
	 * 
	 * @param delay
	 *            Indicates whether updates to a server are delayed (batched) for better performance
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true delays server updates; this is the default</li>
	 *              <li>false posts server updates immediately</li>
	 *              </ul>
	 * @usage If DelayUpdates is false, the program waits for updates to the server to be posted. If you set DelayUpdates to true, server updates are cached and the program proceeds immediately. At a
	 *        convenient time, the cached updates are posted. This makes for better performance but risks losing the cached updates in the event of a crash. This method applies to save and remove
	 *        operations on documents.
	 * 
	 *        Set this property each time you open a database. The property is not saved.
	 * 
	 *        The database must be open to use this property
	 * @example This agent enables delayed updates for the current database if the comment for the current agent is "DelayUpdates"
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			if (agent.getComment().equals(&quot;DelayUpdates&quot;))
	 * 				db.setDelayUpdates(true);
	 * 			else
	 * 				db.setDelayUpdates(false);
	 * 			System.out.println(&quot;Delay updates is &quot; + db.isDelayUpdates());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
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
	 * Update frequency of a database's full-text index
	 * 
	 * @param frequency
	 *            Update frequency of a database's full-text index
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>Database.FTINDEX_DAILY (1)</li>
	 *              <li>Database.FTINDEX_HOURLY (3)</li>
	 *              <li>Database.FTINDEX_IMMEDIATE (4)</li>
	 *              <li>Database.FTINDEX_SCHEDULED (2)</li>
	 *              </ul>
	 * @usage This property applies only to databases on servers.
	 * 
	 *        The database must have a full-text index.
	 * 
	 *        The database must be open to use this property.
	 * @example This agent cycles the update frequency for a database with a full-text index
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			if (db.isFTIndexed()) {
	 * 				if (db.getFTIndexFrequency() == Database.FTINDEX_DAILY) {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_HOURLY);
	 * 					System.out.println(&quot;Index frequency set to hourly&quot;);
	 * 				} else if (db.getFTIndexFrequency() == Database.FTINDEX_HOURLY) {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_IMMEDIATE);
	 * 					System.out.println(&quot;Index frequency set to immediate&quot;);
	 * 				} else if (db.getFTIndexFrequency() == Database.FTINDEX_IMMEDIATE) {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_SCHEDULED);
	 * 					System.out.println(&quot;Index frequency set to scheduled&quot;);
	 * 				} else {
	 * 					db.setFTIndexFrequency(Database.FTINDEX_DAILY);
	 * 					System.out.println(&quot;Index frequency set to daily&quot;);
	 * 				}
	 * 			} else {
	 * 				System.out.println(&quot;Database not full-text indexed&quot;);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setFTIndexFrequency(int frequency) throws NotesApiException;

	/**
	 * @param indexing
	 * @throws NotesApiException
	 */
	public abstract void setInMultiDbIndexing(boolean indexing) throws NotesApiException;

	/**
	 * The title of a database
	 * 
	 * @param title
	 *            The title of a database
	 * @throws NotesApiException
	 * @usage The database does not need to be open to use this property
	 * @example This agent appends "(Marketing)" to the title of the current database
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
	 * 			if (title.endsWith(&quot;(Marketing)&quot;))
	 * 				;
	 * 			else {
	 * 				title = title + &quot; (Marketing)&quot;;
	 * 				db.setTitle(title);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setTitle(String title) throws NotesApiException;

	/**
	 * @param create
	 * @throws NotesApiException
	 */
	public abstract void updateFTIndex(boolean create) throws NotesApiException;

	/**
	 * The replication object associated with this database. Each Database instance contains one NotesReplication object
	 * 
	 * @return The replication object associated with this database. Each Database instance contains one NotesReplication object
	 * @throws NotesApiException
	 * @usage See the Replication class for information and examples.
	 * 
	 *        The database must be open to use this property
	 */
	public abstract NotesReplication getReplicationInfo() throws NotesApiException;

	/**
	 * Conducts a Domain Search, that is, a full-text search of all databases listed in a Domain Catalog and marked as included for multi-database indexing
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that follows
	 * @param max
	 *            The maximum number of documents you want returned from the query. Set this parameter to 0 to receive all matching documents
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When the collection is sorted by relevance, the highest relevance appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.</li>
	 *            <li>Database.FT_DATE_DES sorts by document creation date in descending order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document creation date in ascending order</li>
	 *            </ul>
	 * @param otherOpt
	 *            Integer. Use the following constants to specify additional search options. To specify more than one option, use a logical or operation.
	 *            <ul>
	 *            <li>
	 *            Database.FT_DATABASE includes Domino databases in the search scope.</li>
	 *            <li>Database.FT_FILESYSTEM includes files other than Domino databases in the search scope.</li>
	 *            <li>Database.FT_FUZZY specifies a fuzzy search.</li>
	 *            <li>Database.FT_STEMS uses stem words as the basis of the search.</li>
	 *            </ul>
	 * @param start
	 *            The starting page to return
	 * @param count
	 *            The number of pages to return
	 * @param entryForm
	 *            The name of the search form in the domain catalog, for example, "Domain Search."
	 * @return A document that contains the results of the full-text query
	 * @throws NotesApiException
	 * @usage The current Database object must represent a Domain Catalog.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents sorted by relevance score. If you ask for a sort by date, you don't get relevance scores.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is, except that search keywords must be enclosed in quotes. Remember to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the complete syntax rules, see "Refining a search query using operators" in Lotus Notes Help. Search for "query syntax" in the
	 *        Domino Designer Eclipse help system or information center (for example, http://publib.boulder.ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include Lotus Notes
	 */
	public abstract NotesDocument FTDomainSearch(String query, int max, int sortOpt, int otherOpt, int start, int count, String entryForm) throws NotesApiException;

	/**
	 * Gets an outline in the current database
	 * 
	 * @param outlineName
	 *            The name of the outline
	 * @return The outline.
	 * @throws NotesApiException
	 */
	public abstract NotesOutline getOutline(String outlineName) throws NotesApiException;

	/**
	 * Creates an outline in the current database.
	 * 
	 * @param name
	 *            A name for the outline.
	 * @return The new outline
	 * @throws NotesApiException
	 * @example This agent creates an outline
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = 
	 *       session.getAgentContext();
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       Outline outline = db.createOutline(&quot;Some 
	 *         Documents&quot;);
	 *       outline.setAlias(&quot;SomeDocuments&quot;);
	 *       outline.setComment(&quot;Gives partial view of 
	 *         database&quot;);
	 *       outline.save();
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesOutline createOutline(String name) throws NotesApiException;

	/**
	 * Creates an outline in the current database.
	 * 
	 * @param name
	 *            A name for the outline.
	 * @param defaultOutline
	 *            Optional. Default (false) is to create an empty outline
	 * @return The new outline
	 * @throws NotesApiException
	 * @example This agent creates an outline
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = 
	 *       session.getAgentContext();
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       Outline outline = db.createOutline(&quot;Some 
	 *         Documents&quot;);
	 *       outline.setAlias(&quot;SomeDocuments&quot;);
	 *       outline.setComment(&quot;Gives partial view of 
	 *         database&quot;);
	 *       outline.save();
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesOutline createOutline(String name, boolean defaultOutline) throws NotesApiException;

	/**
	 * Ensures that a folder exists, creating it if necessary
	 * 
	 * @param folder
	 *            The name of the folder
	 * @throws NotesApiException
	 * @usage If the folder exists, this method does nothing. If the folder does not exist, this method creates it
	 */
	public abstract void enableFolder(String folder) throws NotesApiException;

	/**
	 * Returns the Domino URL of the parent object
	 * 
	 * @return The Domino URL for the parent object
	 * @throws NotesApiException
	 */
	public abstract String getURL() throws NotesApiException;

	/**
	 * The Domino URL of a database when Notes protocols are in effect
	 * 
	 * @return The Domino URL of a database when Notes protocols are in effect
	 * @throws NotesApiException
	 * @usage If Notes protocols are not available, this property returns an empty string. See HttpURL.
	 * 
	 *        See resolve in Session for additional information and examples
	 * @example This agent gets the Notes and HTTP URLs for the current database. The agent varies the display depending on whether access is through Notes (the HTTP URL is blank) or HTTP protocols
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.io.PrintWriter;
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
	 * 
	 * 			// Get URLs
	 * 			String notesURL = db.getNotesURL();
	 * 			String httpURL = db.getHttpURL();
	 * 
	 * 			// Assume local if http is blank and print info for notes
	 * 			if (httpURL.length() == 0) {
	 * 				System.out.println(&quot;NotesURL = &quot; + notesURL);
	 * 				System.out.println(&quot;HttpURL = None&quot;);
	 * 			}
	 * 
	 * 			// If http exists print info for both assuming output to browser
	 * 			else {
	 * 				PrintWriter pw = getAgentOutput();
	 * 				pw.println(&quot;NotesURL = &quot; + notesURL);
	 * 				pw.println(&quot;&lt;BR&gt;HttpURL = &quot; + httpURL);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getNotesURL() throws NotesApiException;

	/**
	 * The Domino URL of a database when HTTP protocols are in effect.
	 * 
	 * @return The Domino URL of a database when HTTP protocols are in effect.
	 * @throws NotesApiException
	 * @usage If HTTP protocols are not available, this property returns an empty string. See {@link #getNotesURL()}.
	 * 
	 *        See {@link NotesSession#resolve(String)} in Session for additional information and examples
	 * @example This agent gets the Notes and HTTP URLs for the current database. The agent varies the display depending on whether access is through Notes (the HTTP URL is blank) or HTTP protocols
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.io.PrintWriter;
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
	 * 
	 * 			// Get URLs
	 * 			String notesURL = db.getNotesURL();
	 * 			String httpURL = db.getHttpURL();
	 * 
	 * 			// Assume local if http is blank and print info for notes
	 * 			if (httpURL.length() == 0) {
	 * 				System.out.println(&quot;NotesURL = &quot; + notesURL);
	 * 				System.out.println(&quot;HttpURL = None&quot;);
	 * 			}
	 * 
	 * 			// If http exists print info for both assuming output to browser
	 * 			else {
	 * 				PrintWriter pw = getAgentOutput();
	 * 				pw.println(&quot;NotesURL = &quot; + notesURL);
	 * 				pw.println(&quot;&lt;BR&gt;HttpURL = &quot; + httpURL);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getHttpURL() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector queryAccessRoles(String name) throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with "@DocNumber" as its value. The template view must be accessible to the program, so can be a public view or a private
	 *        view owned by the effective id running the agent, but can not be a private view stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying them from another view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			View viewAll = db.getView(&quot;All Documents&quot;);
	 * 			View viewTopics = db.createView(&quot;Topics&quot;, &quot;SELECT @All&quot;);
	 * 			ViewColumn col1 = viewTopics.copyColumn(viewAll.getColumn(5), 1);
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot; + col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot; + col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView() throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with "@DocNumber" as its value. The template view must be accessible to the program, so can be a public view or a private
	 *        view owned by the effective id running the agent, but can not be a private view stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying them from another view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			View viewAll = db.getView(&quot;All Documents&quot;);
	 * 			View viewTopics = db.createView(&quot;Topics&quot;, &quot;SELECT @All&quot;);
	 * 			ViewColumn col1 = viewTopics.copyColumn(viewAll.getColumn(5), 1);
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot; + col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot; + col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView(String viewName) throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view
	 * @param viewSelectionFormula
	 *            A selection formula. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            selection formula of the template view</li>
	 *            <li>"SELECT @All" if no template view exists</li>
	 *            </ul>
	 *            If specified, this formula overrides the selection formula of the template view
	 * 
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with "@DocNumber" as its value. The template view must be accessible to the program, so can be a public view or a private
	 *        view owned by the effective id running the agent, but can not be a private view stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying them from another view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			View viewAll = db.getView(&quot;All Documents&quot;);
	 * 			View viewTopics = db.createView(&quot;Topics&quot;, &quot;SELECT @All&quot;);
	 * 			ViewColumn col1 = viewTopics.copyColumn(viewAll.getColumn(5), 1);
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot; + col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot; + col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView(String viewName, String viewSelectionFormula) throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view
	 * @param viewSelectionFormula
	 *            A selection formula. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            selection formula of the template view</li>
	 *            <li>"SELECT @All" if no template view exists</li>
	 *            </ul>
	 *            If specified, this formula overrides the selection formula of the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in the database</li>
	 *            <li>
	 *            none if no view in the database is specified as the default design</li>
	 *            </ul>
	 *            <b>Note</b> The template view can not be of type Shared, desktop private on first use
	 * 
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with "@DocNumber" as its value. The template view must be accessible to the program, so can be a public view or a private
	 *        view owned by the effective id running the agent, but can not be a private view stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying them from another view
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			View viewAll = db.getView(&quot;All Documents&quot;);
	 * 			View viewTopics = db.createView(&quot;Topics&quot;, &quot;SELECT @All&quot;);
	 * 			ViewColumn col1 = viewTopics.copyColumn(viewAll.getColumn(5), 1);
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot; + col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot; + col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView) throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view
	 * @param viewSelectionFormula
	 *            A selection formula. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            selection formula of the template view</li>
	 *            <li>"SELECT @All" if no template view exists</li>
	 *            </ul>
	 *            If specified, this formula overrides the selection formula of the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in the database</li>
	 *            <li>
	 *            none if no view in the database is specified as the default design</li>
	 *            </ul>
	 *            <b>Note</b> The template view can not be of type Shared, desktop private on first use
	 * @param prohibitDesignRefreshModifications
	 *            <ul>
	 *            <li>true (default) to prohibit the view design from being refreshed</li>
	 *            <li>false to allow the view design to be refreshed</li>
	 *            </ul>
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView(String viewName, String viewSelectionFormula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException;

	/**
	 * Runs the Fixup task on a database
	 * 
	 * @throws NotesApiException
	 * @example This agent runs the Fixup task on all the databases in the local directory
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DbDirectory dbdir = session.getDbDirectory(null);
	 * 			int options = Database.FIXUP_QUICK + Database.FIXUP_INCREMENTAL + Database.FIXUP_NOVIEWS;
	 * 			Database db = dbdir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				db.open();
	 * 				db.fixup(options);
	 * 				db = dbdir.getNextDatabase();
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void fixup() throws NotesApiException;

	/**
	 * Runs the Fixup task on a database
	 * 
	 * @param options
	 *            One or more of the following. Add options to combine them.
	 *            <ul>
	 *            <li>Database.FIXUP_INCREMENTAL (4) checks only documents since last Fixup</li>
	 *            <li>Database.FIXUP_NODELETE (16) prevents Fixup from deleting corrupted documents</li>
	 *            <li>Database.FIXUP_NOVIEWS (64) does not check views</li>
	 *            <li>Database.FIXUP_QUICK (2) checks documents more quickly but less thoroughly</li>
	 *            <li>Database.FIXUP_REVERT (32) reverts ID tables to the previous release format</li>
	 *            <li>Database.FIXUP_TXLOGGED (8) includes databases enabled for transaction logging</li>
	 *            <li>Database.FIXUP_VERIFY (1) makes no modifications</li>
	 *            </ul>
	 * 
	 * @throws NotesApiException
	 * @example This agent runs the Fixup task on all the databases in the local directory
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DbDirectory dbdir = session.getDbDirectory(null);
	 * 			int options = Database.FIXUP_QUICK + Database.FIXUP_INCREMENTAL + Database.FIXUP_NOVIEWS;
	 * 			Database db = dbdir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				db.open();
	 * 				db.fixup(options);
	 * 				db = dbdir.getNextDatabase();
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
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
	 * Indicates whether document locking is enabled for a database
	 * 
	 * @return Indicates whether document locking is enabled for a database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if document locking is enabled</li>
	 *              <li>false if document locking is not enabled</li>
	 *              </ul>
	 * @usage The database must be open to use this property
	 * @example 1. This agent displays whether document locking is enabled for the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			if (db.isDocumentLockingEnabled())
	 * 				System.out.println(&quot;Document locking is enabled&quot;);
	 * 			else
	 * 				System.out.println(&quot;Document locking is not enabled&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent toggles document locking for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			db.setDocumentLockingEnabled(!db.isDocumentLockingEnabled());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isDocumentLockingEnabled() throws NotesApiException;

	/**
	 * Indicates whether document locking is enabled for a database
	 * 
	 * @param flag
	 *            Indicates whether document locking is enabled for a database
	 * @throws NotesApiException
	 */
	public abstract void setDocumentLockingEnabled(boolean flag) throws NotesApiException;

	/**
	 * Indicates whether design locking is enabled for a database
	 * 
	 * @return Indicates whether design locking is enabled for a database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if design locking is enabled</li>
	 *              <li>false if design locking is not enabled</li>
	 *              </ul>
	 * @usage The design elements that can be locked are agents, forms, and views.
	 * 
	 *        The database must be open to use this property
	 * @example 1. This agent displays whether design locking is enabled for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			if (db.isDesignLockingEnabled())
	 * 				System.out.println(&quot;Design locking is enabled&quot;);
	 * 			else
	 * 				System.out.println(&quot;Design locking is not enabled&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent toggles design locking for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			db.setDesignLockingEnabled(!db.isDesignLockingEnabled());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isDesignLockingEnabled() throws NotesApiException;

	/**
	 * Indicates whether design locking is enabled for a database
	 * 
	 * @param flag
	 *            Indicates whether design locking is enabled for a database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if design locking is enabled</li>
	 *              <li>false if design locking is not enabled</li>
	 *              </ul>
	 * @usage The design elements that can be locked are agents, forms, and views.
	 * 
	 *        The database must be open to use this property
	 * @example 1. This agent displays whether design locking is enabled for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			if (db.isDesignLockingEnabled())
	 * 				System.out.println(&quot;Design locking is enabled&quot;);
	 * 			else
	 * 				System.out.println(&quot;Design locking is not enabled&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent toggles design locking for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 
	 * 			db.setDesignLockingEnabled(!db.isDesignLockingEnabled());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
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
	 * The ODS (on-disk structure) version of a database
	 * 
	 * @return The ODS (on-disk structure) version of a database
	 * @throws NotesApiException
	 * @usage The ODS version increments with newer versions of Domino:
	 *        <ul>
	 *        <li>
	 *        Lotus/Notes Domino 6 is 43</li>
	 *        <li>
	 *        Lotus Notes/Domino 5 is 41</li>
	 *        </ul>
	 *        The database must be open to use this property.
	 * @example This agent gets the ODS version of the databases in the local directory.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				db.open(); // Must open database
	 * 				System.out.println(&quot;Database title = &quot; + db.getTitle());
	 * 				System.out.println(&quot;ODS version = &quot; + db.getFileFormat());
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getFileFormat() throws NotesApiException;

	/**
	 * The size warning threshold of a database, in kilobytes
	 * 
	 * @return The size warning threshold of a database, in kilobytes
	 * @throws NotesApiException
	 * @usage The size warning threshold for a database specifies the amount of disk space that the server administrator is willing to provide for that database before displaying a warning; therefore,
	 *        the SizeWarning property can only be set by a script that has administrator access to the server on which the database resides.
	 * 
	 *        If there is no size warning threshold for the database, this property returns 0.
	 * 
	 *        In the Administration Client, use the "Set Quotas" tool to set the size warning.
	 * 
	 *        The database does not need to be open to use this property
	 * @example 1. This agent displays the size quota and warning for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			System.out.println(&quot;Size quota = &quot; + db.getSizeQuota());
	 * 			System.out.println(&quot;Size warning = &quot; + db.getSizeWarning());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent removes the size quota and warning for the current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			db.setSizeQuota(0);
	 * 			db.setSizeWarning(0);
	 * 			System.out.println(&quot;Size quota = &quot; + db.getSizeQuota());
	 * 			System.out.println(&quot;Size warning = &quot; + db.getSizeWarning());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract long getSizeWarning() throws NotesApiException;

	/**
	 * The size warning threshold of a database, in kilobytes
	 * 
	 * @param warning
	 *            The size warning threshold of a database, in kilobytes
	 * @throws NotesApiException
	 */
	public abstract void setSizeWarning(int warning) throws NotesApiException;

	/**
	 * The date that a database was last checked by the Fixup task.
	 * 
	 * @return The date that a database was last checked by the Fixup task.
	 * 
	 * @throws NotesApiException
	 * @usage The database must be open to use this property.
	 * @example This agent displays the last fixup date for the local databases
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				// Database must be open
	 * 				try {
	 * 					db.open();
	 * 				} catch (NotesException ne) {
	 * 					System.out.println(db.getFilePath() + &quot; - could not open&quot;);
	 * 					continue;
	 * 				}
	 * 				DateTime fix = db.getLastFixup();
	 * 				System.out.println(db.getFilePath() + &quot; - last fixup &quot; + fix.getLocalTime());
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDateTime getLastFixup() throws NotesApiException;

	/**
	 * Indicates whether a database is a Directory Catalog database, also known as the Light Weight NAB, or the Enterprise Address Book
	 * 
	 * @return Indicates whether a database is a Directory Catalog database, also known as the Light Weight NAB, or the Enterprise Address Book
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the database is a Directory Catalog</li>
	 *              <li>false if the database is not a Directory Catalog</li>
	 *              </ul>
	 * @usage This property is valid only for a database retrieved through the AddressBooks property of Session, and when the database is explicitly opened. For all other Database objects, this
	 *        property returns false.
	 * 
	 *        The database must be open to use this property
	 * @example The following agent determines if databases are Directory Catalogs
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
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
	 * 			Database db;
	 * 			String server;
	 * 			String iscatalog;
	 * 			Vector books = session.getAddressBooks();
	 * 			Enumeration e = books.elements();
	 * 			while (e.hasMoreElements()) {
	 * 				db = (Database) e.nextElement();
	 * 				String fn = db.getFileName();
	 * 				if (db.getServer() != null)
	 * 					server = db.getServer();
	 * 				else
	 * 					server = &quot;Local&quot;;
	 * 				System.out.println(server + &quot; &quot; + fn);
	 * 				// Must have access to database
	 * 				try {
	 * 					if (db.open()) {
	 * 						if (db.isDirectoryCatalog())
	 * 							iscatalog = &quot;Is directory catalog&quot;;
	 * 						else
	 * 							iscatalog = &quot;Is not directory catalog&quot;;
	 * 						System.out.println(&quot;\t&quot; + iscatalog);
	 * 					} else
	 * 						System.out.println(&quot;\tCannot open database&quot;);
	 * 				} catch (NotesException ne) {
	 * 					System.out.println(&quot;\t&quot; + ne.id + &quot; &quot; + ne.text);
	 * 				}
	 * 			} // end while
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isDirectoryCatalog() throws NotesApiException;

	/**
	 * Indicates whether a database is a Configuration Directory database
	 * 
	 * @return Indicates whether a database is a Configuration Directory database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the database is a Configuration Directory</li>
	 *              <li>false if the database is not a Configuration Directory</li>
	 *              </ul>
	 * @usage This property is available for Database objects retrieved from the AddressBooks property in Session. For other Database objects, this property has no value, and therefore evaluates to
	 *        false when used in conditional statements.
	 * 
	 *        The database must be open to use this property
	 * @example This agent displays the Configuration Directory databases known to the current session
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
	 * 			Vector books = session.getAddressBooks();
	 * 			for (int i = 0; i &lt; books.size(); i++) {
	 * 				Database db = (Database) books.elementAt(i);
	 * 				// Database must be open
	 * 				try {
	 * 					db.open();
	 * 				} catch (NotesException ne) {
	 * 					System.out.println(&quot;Could not open &quot; + db.getFilePath());
	 * 					continue;
	 * 				}
	 * 				if (db.isConfigurationDirectory())
	 * 					System.out.println(db.getTitle() + &quot; is a Configuration Directory&quot;);
	 * 				else
	 * 					System.out.println(db.getTitle() + &quot; is not a Configuration Directory&quot;);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isConfigurationDirectory() throws NotesApiException;

	/**
	 * Indicates whether the current user has public reader access in a database
	 * 
	 * @return Indicates whether the current user has public reader access in a database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the user has public reader access</li>
	 *              <li>false if the user does not have public reader access</li>
	 *              </ul>
	 * @usage The database must be open to use this property
	 * @example This agent sees if the user has public reader access to a database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			String server = &quot;Server1/East/Acme&quot;;
	 * 			String path = &quot;bob\\DatabaseJava&quot;;
	 * 			Database db = session.getDatabase(server, path);
	 * 			if (db.isOpen()) { // Database must be open
	 * 				if (db.isCurrentAccessPublicReader())
	 * 					System.out.println(&quot;You are a public reader&quot;);
	 * 				else
	 * 					System.out.println(&quot;You are not a public reader&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isCurrentAccessPublicReader() throws NotesApiException;

	/**
	 * Indicates whether the current user has public writer access in a database
	 * 
	 * @return Indicates whether the current user has public writer access in a database
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the user has public writer access</li>
	 *              <li>
	 *              false if the user does not have public writer access</li>
	 *              </ul>
	 * @usage The database must be open to use this property
	 * @example This agent sees if the user has public writer access to a database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			String server = &quot;Server1/East/Acme&quot;;
	 * 			String path = &quot;bob\\DatabaseJava&quot;;
	 * 			Database db = session.getDatabase(server, path);
	 * 			if (db.isOpen()) { // Database must be open
	 * 				if (db.isCurrentAccessPublicWriter())
	 * 					System.out.println(&quot;You are a public writer&quot;);
	 * 				else
	 * 					System.out.println(&quot;You are not a public writer&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isCurrentAccessPublicWriter() throws NotesApiException;

	/**
	 * @param optionName
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setOption(int optionName, boolean flag) throws NotesApiException;

	/**
	 * Gets the value of a database option
	 * 
	 * @param optionName
	 *            One of the following:
	 *            <ul>
	 *            <li>Database.DBOPT_LZ1 uses LZ1 compression for attachments</li>
	 *            <li>Database.DBOPT_LZCOMPRESSION uses LZ1 compression for attachments</li>
	 *            <li>Database.DBOPT_MAINTAINLASTACCESSED maintains LastAcessed property</li>
	 *            <li>Database.DBOPT_MOREFIELDS allows more fields in database</li>
	 *            <li>Database.DBOPT_NOHEADLINEMONITORS doesn't allow headline monitoring</li>
	 *            <li>Database.DBOPT_NOOVERWRITE doesn't overwrite free space</li>
	 *            <li>Database.DBOPT_NORESPONSEINFO doesn't support specialized response hierarchy</li>
	 *            <li>Database.DBOPT_NOTRANSACTIONLOGGING disables transaction logging</li>
	 *            <li>Database.DBOPT_NOUNREAD doesn't maintain unread marks</li>
	 *            <li>Database.DBOPT_OPTIMIZATION enables document table bitmap optimization</li>
	 *            <li>Database.DBOPT_REPLICATEUNREADMARKSTOANY replicates unread marks to all servers</li>
	 *            <li>Database.DBOPT_REPLICATEUNREADMARKSTOCLUSTER replicates unread marks to clustered servers only</li>
	 *            <li>Database.DBOPT_SOFTDELETE allows soft deletions</li>
	 *            </ul>
	 * @return <ul>
	 *         <li>true if the option is enabled</li>
	 *         <li>false if the option is disabled</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage See setOption for setting a database option
	 * @example This agent gets the value of a database option.
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
	 * 			if (db.getOption(Database.DBOPT_SOFTDELETE))
	 * 				System.out.println(&quot;Soft deletes enabled&quot;);
	 * 			else
	 * 				System.out.println(&quot;Soft deletes not enabled&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean getOption(int optionName) throws NotesApiException;

	/**
	 * Indicates whether cluster replication is in effect for a database on a server in a cluster
	 * 
	 * @return Indicates whether cluster replication is in effect for a database on a server in a cluster
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if cluster replication is in effect</li>
	 *              <li>false if cluster replication is not in effect</li>
	 *              </ul>
	 * @usage The database must be open to use this property
	 * @example This agent interrogates cluster replication for a database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			Database db = session.getDatabase(&quot;Server1/East/Acme&quot;, &quot;bob\\DatabaseJava&quot;);
	 * 			if (db.isOpen()) {
	 * 				if (db.isClusterReplication())
	 * 					System.out.println(&quot;Cluster replication set&quot;);
	 * 				else
	 * 					System.out.println(&quot;Cluster replication not set&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Could not open database&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isClusterReplication() throws NotesApiException;

	/**
	 * The maximum number of entries allowed in the $Revisions field
	 * 
	 * @return The maximum number of entries allowed in the $Revisions field
	 * @throws NotesApiException
	 * @usage This property corresponds to "Limit entries in $Revisions fields" in the database advanced properties of the UI.
	 * 
	 *        This property must be an integer in the range 0 - 2147483647. When setting it:
	 *        <ul>
	 *        <li>
	 *        Any fraction is truncated.</li>
	 *        <li>
	 *        A value less than 0 raises NotesError.NOTES_ERR_NEGATIVE_VALUE (4631) "Value can not be negative."</li>
	 *        <li>
	 *        A value greater than 2147483647 throws NotesError.NOTES_ERR_LONG_OVERFLOW (4673) "Value must be positive and less than 2147483648."</li>
	 *        </ul>
	 *        A value of 0 means no limit.
	 * 
	 *        When $Revisions reaches the limit, a new entry results in deletion of the oldest entry.
	 * 
	 *        The database must be open to use this property
	 * @example This agent cycles the revision limit from 0 to 1000 in increments of 100
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			double lr = db.getLimitRevisions();
	 * 			if (lr &gt;= 1000)
	 * 				db.setLimitRevisions(0);
	 * 			else
	 * 				db.setLimitRevisions(lr + 100);
	 * 			System.out.println(&quot;Limit for $Revisions is &quot; + db.getLimitRevisions());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract double getLimitRevisions() throws NotesApiException;

	/**
	 * The maximum number of entries allowed in the $Revisions field
	 * 
	 * @param revisions
	 *            The maximum number of entries allowed in the $Revisions field
	 * @throws NotesApiException
	 * @usage This property corresponds to "Limit entries in $Revisions fields" in the database advanced properties of the UI.
	 * 
	 *        This property must be an integer in the range 0 - 2147483647. When setting it:
	 *        <ul>
	 *        <li>
	 *        Any fraction is truncated.</li>
	 *        <li>
	 *        A value less than 0 raises NotesError.NOTES_ERR_NEGATIVE_VALUE (4631) "Value can not be negative."</li>
	 *        <li>
	 *        A value greater than 2147483647 throws NotesError.NOTES_ERR_LONG_OVERFLOW (4673) "Value must be positive and less than 2147483648."</li>
	 *        </ul>
	 *        A value of 0 means no limit.
	 * 
	 *        When $Revisions reaches the limit, a new entry results in deletion of the oldest entry.
	 * 
	 *        The database must be open to use this property
	 * @example This agent cycles the revision limit from 0 to 1000 in increments of 100
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			double lr = db.getLimitRevisions();
	 * 			if (lr &gt;= 1000)
	 * 				db.setLimitRevisions(0);
	 * 			else
	 * 				db.setLimitRevisions(lr + 100);
	 * 			System.out.println(&quot;Limit for $Revisions is &quot; + db.getLimitRevisions());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setLimitRevisions(double revisions) throws NotesApiException;

	/**
	 * The maximum number of entries allowed in the $UpdatedBy field
	 * 
	 * @return The maximum number of entries allowed in the $UpdatedBy field
	 * @throws NotesApiException
	 * @usage This property corresponds to "Limit entries in $UpdatedBy fields" in the database advanced properties of the UI.
	 * 
	 *        This property must be an integer in the range 0 - 2147483647. When setting it:
	 *        <ul>
	 *        <li>
	 *        Any fraction is truncated.</li>
	 *        <li>
	 *        A value less than 0 throws NotesError.NOTES_ERR_NEGATIVE_VALUE (4631) "Value can not be negative."</li>
	 *        <li>
	 *        A value greater than 2147483647 throws NotesError.NOTES_ERR_LONG_OVERFLOW (4673) "Value must be positive and less than 2147483648."</li>
	 *        </ul>
	 *        A value of 0 means no limit.
	 * 
	 *        When $UpdatedBy reaches the limit, a new entry results in deletion of the oldest entry.
	 * 
	 *        The database must be open to use this property.
	 * @example This agent cycles the updated-by limit from 0 to 1000 in increments of 100
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			double lu = db.getLimitUpdatedBy();
	 * 			if (lu &gt; 1000)
	 * 				db.setLimitUpdatedBy(0);
	 * 			else
	 * 				db.setLimitUpdatedBy(lu + 100);
	 * 			System.out.println(&quot;LimitUpdatedBy = &quot; + db.getLimitUpdatedBy());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract double getLimitUpdatedBy() throws NotesApiException;

	/**
	 * The maximum number of entries allowed in the $UpdatedBy field
	 * 
	 * @param updateBy
	 *            The maximum number of entries allowed in the $UpdatedBy field
	 * @throws NotesApiException
	 * @usage This property corresponds to "Limit entries in $UpdatedBy fields" in the database advanced properties of the UI.
	 * 
	 *        This property must be an integer in the range 0 - 2147483647. When setting it:
	 *        <ul>
	 *        <li>
	 *        Any fraction is truncated.</li>
	 *        <li>
	 *        A value less than 0 throws NotesError.NOTES_ERR_NEGATIVE_VALUE (4631) "Value can not be negative."</li>
	 *        <li>
	 *        A value greater than 2147483647 throws NotesError.NOTES_ERR_LONG_OVERFLOW (4673) "Value must be positive and less than 2147483648."</li>
	 *        </ul>
	 *        A value of 0 means no limit.
	 * 
	 *        When $UpdatedBy reaches the limit, a new entry results in deletion of the oldest entry.
	 * 
	 *        The database must be open to use this property.
	 * @example This agent cycles the updated-by limit from 0 to 1000 in increments of 100
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			double lu = db.getLimitUpdatedBy();
	 * 			if (lu &gt; 1000)
	 * 				db.setLimitUpdatedBy(0);
	 * 			else
	 * 				db.setLimitUpdatedBy(lu + 100);
	 * 			System.out.println(&quot;LimitUpdatedBy = &quot; + db.getLimitUpdatedBy());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setLimitUpdatedBy(double updateBy) throws NotesApiException;

	/**
	 * Indicates whether a database appears in database catalogs
	 * 
	 * @return Indicates whether a database appears in database catalogs
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the database appears in database catalogs</li>
	 *              <li>false if the database does not appear in database catalogs</li>
	 *              </ul>
	 * @usage This property corresponds to "List in Database Catalog" in the database design properties of the UI.
	 * 
	 *        Categories determines the categories under which the database is listed.
	 * 
	 *        The database must be open to use this property
	 * @example This agent toggles whether the current database is listed in a database catalog
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			db.setListInDbCatalog(!db.getListInDbCatalog());
	 * 			System.out.println(&quot;ListInDbCatalog = &quot; + db.getListInDbCatalog());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean getListInDbCatalog() throws NotesApiException;

	/**
	 * Indicates whether a database appears in database catalogs
	 * 
	 * @param flag
	 *            Indicates whether a database appears in database catalogs
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the database appears in database catalogs</li>
	 *              <li>false if the database does not appear in database catalogs</li>
	 *              </ul>
	 * @usage This property corresponds to "List in Database Catalog" in the database design properties of the UI.
	 * 
	 *        Categories determines the categories under which the database is listed.
	 * 
	 *        The database must be open to use this property
	 * @example This agent toggles whether the current database is listed in a database catalog
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			db.setListInDbCatalog(!db.getListInDbCatalog());
	 * 			System.out.println(&quot;ListInDbCatalog = &quot; + db.getListInDbCatalog());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setListInDbCatalog(boolean flag) throws NotesApiException;

	/**
	 * The number of hours before soft deletions become hard deletions
	 * 
	 * @return The number of hours before soft deletions become hard deletions
	 * @throws NotesApiException
	 * @usage This property corresponds to "Soft delete expire time in hours" in the database advanced properties of the UI.
	 * 
	 *        The database must be open to use this property
	 * @example This agent cycles the expiration time for soft deletions from 24 to 48 to 72 hours
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			int uet = db.getUndeleteExpireTime();
	 * 			if (uet &gt; 71)
	 * 				db.setUndeleteExpireTime(24);
	 * 			else
	 * 				db.setUndeleteExpireTime(uet + 24);
	 * 			System.out.println(&quot;UndeleteExpireTime = &quot; + db.getUndeleteExpireTime());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getUndeleteExpireTime() throws NotesApiException;

	/**
	 * The number of hours before soft deletions become hard deletions
	 * 
	 * @param hours
	 *            The number of hours before soft deletions become hard deletions
	 * @throws NotesApiException
	 * @usage This property corresponds to "Soft delete expire time in hours" in the database advanced properties of the UI.
	 * 
	 *        The database must be open to use this property
	 * @example This agent cycles the expiration time for soft deletions from 24 to 48 to 72 hours
	 * 
	 *          <pre>
	 * import lotus.domino.*;
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
	 * 			int uet = db.getUndeleteExpireTime();
	 * 			if (uet &gt; 71)
	 * 				db.setUndeleteExpireTime(24);
	 * 			else
	 * 				db.setUndeleteExpireTime(uet + 24);
	 * 			System.out.println(&quot;UndeleteExpireTime = &quot; + db.getUndeleteExpireTime());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setUndeleteExpireTime(int hours) throws NotesApiException;

	/**
	 * Gets the documents in a database that are modified since a specified time
	 * 
	 * @param since
	 *            The start time for collecting the modified documents. Defaults to the creation time of the database effectively returning all documents
	 * @param noteClass
	 *            One of the following to specify the type or types of document collected. You can combine types with a logical or. Defaults to Database.DBMOD_DOC_DATA which collects only data
	 *            documents.
	 *            <ul>
	 *            <li>Database.DBMOD_DOC_ACL (64)</li>
	 *            <li>Database.DBMOD_DOC_AGENT (512)</li>
	 *            <li>Database.DBMOD_DOC_ALL (32767)</li>
	 *            <li>Database.DBMOD_DOC_DATA (1)</li>
	 *            <li>Database.DBMOD_DOC_FORM (4)</li>
	 *            <li>Database.DBMOD_DOC_HELP (256)</li>
	 *            <li>Database.DBMOD_DOC_ICON (16)</li>
	 *            <li>Database.DBMOD_DOC_REPLFORMULA (2048)</li>
	 *            <li>Database.DBMOD_DOC_SHAREDFIELD (1024)</li>
	 *            <li>Database.DBMOD_DOC_VIEW (8)</li>
	 *            </ul>
	 * @return A collection containing the modified documents
	 * @throws NotesApiException
	 * @usage The end time for the collection is the current database time, which is posted to the UntilTime property of the returned DocumentCollection object. This time should be specified as the
	 *        "since" time in a subsequent call to getModifiedDocuments where you want to get all modified documents since the most recent call. Do not rely on the system time, which may differ from
	 *        the database time.
	 * 
	 *        This method throws NotesError.NOTES_NOSUCH_DBGETMODDOCS (4698) "Not a valid GetModifiedDocuments constant" if the noteClass parameter is invalid
	 * @example This agent gets all modified data documents in the current database since the last time the agent ran. A profile document saves the database end time for each getModifiedDocuments
	 *          operation
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
	 * 
	 * 			// Check UntilTime in profile document
	 * 			Document profile = db.getProfileDocument(&quot;Profile&quot;, null);
	 * 			DateTime untilTime = null;
	 * 			DocumentCollection dc = null;
	 * 			if (profile.hasItem(&quot;UntilTime&quot;)) {
	 * 				// Start processing from UntilTime
	 * 				Vector untilTimeVector = profile.getItemValueDateTimeArray(&quot;UntilTime&quot;);
	 * 				untilTime = (DateTime) untilTimeVector.firstElement();
	 * 				dc = db.getModifiedDocuments(untilTime, Database.DBMOD_DOC_DATA);
	 * 			} else {
	 * 				// First time through get all documents
	 * 				dc = db.getModifiedDocuments(null, Database.DBMOD_DOC_DATA);
	 * 			}
	 * 
	 * 			if (dc.getCount() &gt; 0) {
	 * 				// Display LastModified and Subject from each document
	 * 				Document doc = dc.getFirstDocument();
	 * 				while (doc != null) {
	 * 					System.out.println(doc.getLastModified() + &quot; &quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 					doc = dc.getNextDocument(doc);
	 * 				}
	 * 			} else {
	 * 				// If nothing modified since last time
	 * 				if (profile.hasItem(&quot;UntilTime&quot;))
	 * 					System.out.println(&quot;No documents modified since &quot; + untilTime.getLocalTime());
	 * 				else
	 * 					System.out.println(&quot;No documents modified since beginning&quot;);
	 * 			}
	 * 
	 * 			// Write UntilTime back to profile document
	 * 			profile.replaceItemValue(&quot;UntilTime&quot;, dc.getUntilTime());
	 * 			profile.save(true, true, true);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getModifiedDocuments(NotesDateTime since, int noteClass) throws NotesApiException;

	/**
	 * Gets the documents in a database that are modified since a specified time
	 * 
	 * @param since
	 *            The start time for collecting the modified documents. Defaults to the creation time of the database effectively returning all documents
	 * @return A collection containing the modified documents
	 * @throws NotesApiException
	 * @usage The end time for the collection is the current database time, which is posted to the UntilTime property of the returned DocumentCollection object. This time should be specified as the
	 *        "since" time in a subsequent call to getModifiedDocuments where you want to get all modified documents since the most recent call. Do not rely on the system time, which may differ from
	 *        the database time.
	 * 
	 *        This method throws NotesError.NOTES_NOSUCH_DBGETMODDOCS (4698) "Not a valid GetModifiedDocuments constant" if the noteClass parameter is invalid
	 * @example This agent gets all modified data documents in the current database since the last time the agent ran. A profile document saves the database end time for each getModifiedDocuments
	 *          operation
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
	 * 
	 * 			// Check UntilTime in profile document
	 * 			Document profile = db.getProfileDocument(&quot;Profile&quot;, null);
	 * 			DateTime untilTime = null;
	 * 			DocumentCollection dc = null;
	 * 			if (profile.hasItem(&quot;UntilTime&quot;)) {
	 * 				// Start processing from UntilTime
	 * 				Vector untilTimeVector = profile.getItemValueDateTimeArray(&quot;UntilTime&quot;);
	 * 				untilTime = (DateTime) untilTimeVector.firstElement();
	 * 				dc = db.getModifiedDocuments(untilTime, Database.DBMOD_DOC_DATA);
	 * 			} else {
	 * 				// First time through get all documents
	 * 				dc = db.getModifiedDocuments(null, Database.DBMOD_DOC_DATA);
	 * 			}
	 * 
	 * 			if (dc.getCount() &gt; 0) {
	 * 				// Display LastModified and Subject from each document
	 * 				Document doc = dc.getFirstDocument();
	 * 				while (doc != null) {
	 * 					System.out.println(doc.getLastModified() + &quot; &quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 					doc = dc.getNextDocument(doc);
	 * 				}
	 * 			} else {
	 * 				// If nothing modified since last time
	 * 				if (profile.hasItem(&quot;UntilTime&quot;))
	 * 					System.out.println(&quot;No documents modified since &quot; + untilTime.getLocalTime());
	 * 				else
	 * 					System.out.println(&quot;No documents modified since beginning&quot;);
	 * 			}
	 * 
	 * 			// Write UntilTime back to profile document
	 * 			profile.replaceItemValue(&quot;UntilTime&quot;, dc.getUntilTime());
	 * 			profile.save(true, true, true);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getModifiedDocuments(NotesDateTime since) throws NotesApiException;

	/**
	 * Gets the documents in a database that are modified since a specified time
	 * 
	 * @return A collection containing the modified documents
	 * @throws NotesApiException
	 * @usage The end time for the collection is the current database time, which is posted to the UntilTime property of the returned DocumentCollection object. This time should be specified as the
	 *        "since" time in a subsequent call to getModifiedDocuments where you want to get all modified documents since the most recent call. Do not rely on the system time, which may differ from
	 *        the database time.
	 * 
	 *        This method throws NotesError.NOTES_NOSUCH_DBGETMODDOCS (4698) "Not a valid GetModifiedDocuments constant" if the noteClass parameter is invalid
	 * @example This agent gets all modified data documents in the current database since the last time the agent ran. A profile document saves the database end time for each getModifiedDocuments
	 *          operation
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
	 * 
	 * 			// Check UntilTime in profile document
	 * 			Document profile = db.getProfileDocument(&quot;Profile&quot;, null);
	 * 			DateTime untilTime = null;
	 * 			DocumentCollection dc = null;
	 * 			if (profile.hasItem(&quot;UntilTime&quot;)) {
	 * 				// Start processing from UntilTime
	 * 				Vector untilTimeVector = profile.getItemValueDateTimeArray(&quot;UntilTime&quot;);
	 * 				untilTime = (DateTime) untilTimeVector.firstElement();
	 * 				dc = db.getModifiedDocuments(untilTime, Database.DBMOD_DOC_DATA);
	 * 			} else {
	 * 				// First time through get all documents
	 * 				dc = db.getModifiedDocuments(null, Database.DBMOD_DOC_DATA);
	 * 			}
	 * 
	 * 			if (dc.getCount() &gt; 0) {
	 * 				// Display LastModified and Subject from each document
	 * 				Document doc = dc.getFirstDocument();
	 * 				while (doc != null) {
	 * 					System.out.println(doc.getLastModified() + &quot; &quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 					doc = dc.getNextDocument(doc);
	 * 				}
	 * 			} else {
	 * 				// If nothing modified since last time
	 * 				if (profile.hasItem(&quot;UntilTime&quot;))
	 * 					System.out.println(&quot;No documents modified since &quot; + untilTime.getLocalTime());
	 * 				else
	 * 					System.out.println(&quot;No documents modified since beginning&quot;);
	 * 			}
	 * 
	 * 			// Write UntilTime back to profile document
	 * 			profile.replaceItemValue(&quot;UntilTime&quot;, dc.getUntilTime());
	 * 			profile.save(true, true, true);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getModifiedDocuments() throws NotesApiException;

	/**
	 * Indicates whether the current database is backed by DB2
	 * 
	 * @return Indicates whether the current database is backed by DB2
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the current database is backed by DB2</li>
	 *              <li>false if the current database is not backed by DB2</li>
	 *              </ul>
	 * @example This computed field indicates whether the current database is DB2
	 * 
	 *          <pre>
	 * if (database.isCurrentAccessPublicWriter()) {
	 * 	return "You have public writer access"
	 * } else {
	 * 	return "You do not have public writer access"
	 * }
	 * </pre>
	 */
	public abstract boolean isDB2() throws NotesApiException;

	/**
	 * Gets the DB2 Schema of the current database
	 * 
	 * @return The DB2 schema of the current database. The empty string ("") is returned if the database is a non-DB2 database
	 * @throws NotesApiException
	 */
	public abstract String getDB2Schema() throws NotesApiException;

	/**
	 * Creates a document collection of all unread documents in the database
	 * 
	 * @param userID
	 *            Optional. If present, the method returns unread documents on behalf of the given name. If omitted, the method returns unread documents on behalf of the current user ID
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are considered read, and this method returns an empty collection.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the database have not yet been read
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 *   public void NotesMain() {
	 * 
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = session.getAgentContext();
	 * 
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       
	 *       DocumentCollection dc = db.getAllUnreadDocuments();
	 *       System.out.println("This database contains "
	 *             + dc.getCount() + " unread documents.");
	 *       }
	 * 
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getAllUnreadDocuments(String userID) throws NotesApiException;

	/**
	 * Creates a document collection of all read documents in the database
	 * 
	 * @param userID
	 *            Optional. If present, the method returns read documents on behalf of the given name. If omitted, the method returns read documents on behalf of the current user ID
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are considered read.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the database have been read.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 *   public void NotesMain() {
	 * 
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = session.getAgentContext();
	 * 
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       
	 *       DocumentCollection dc = db.getAllReadDocuments();
	 *       System.out.println("This database contains "
	 *             + dc.getCount() + " read documents.");
	 *       }
	 * 
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getAllReadDocuments(String userID) throws NotesApiException;

	/**
	 * Creates a document collection of all unread documents in the database
	 * 
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are considered read, and this method returns an empty collection.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the database have not yet been read
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 *   public void NotesMain() {
	 * 
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = session.getAgentContext();
	 * 
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       
	 *       DocumentCollection dc = db.getAllUnreadDocuments();
	 *       System.out.println("This database contains "
	 *             + dc.getCount() + " unread documents.");
	 *       }
	 * 
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getAllUnreadDocuments() throws NotesApiException;

	/**
	 * Creates a document collection of all read documents in the database
	 * 
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are considered read.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the database have been read.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 *   public void NotesMain() {
	 * 
	 *     try {
	 *       Session session = getSession();
	 *       AgentContext agentContext = session.getAgentContext();
	 * 
	 *       // (Your code goes here) 
	 *       Database db = agentContext.getCurrentDatabase();
	 *       
	 *       DocumentCollection dc = db.getAllReadDocuments();
	 *       System.out.println("This database contains "
	 *             + dc.getCount() + " read documents.");
	 *       }
	 * 
	 *     } catch(Exception e) {
	 *       e.printStackTrace();
	 *     }
	 *   }
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getAllReadDocuments() throws NotesApiException;

	/**
	 * Creates a document collection in a database and returns a NotesDocumentCollection object that represents the new collection
	 * 
	 * @return The new document collection.
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link NotesDocument#save()} if you want the new document to be saved.
	 * @example The following button creates a document collection, adds documents conditionally, then removes those documents.
	 * 
	 *          <pre>
	 * var dc:NotesDocumentCollection = database.createDocumentCollection();
	 * var view:NotesView = database.getView("main");
	 * var doc:NotesDocument = view.getFirstDocument();
	 * while (doc != null) {
	 * 	if (doc.getItemValueString("subject").endsWithIgnoreCase("obsolete")) {
	 * 		dc.addDocument(doc);
	 * 	}
	 * 	var tmpdoc = view.getNextDocument(doc);
	 * 	doc.recycle();
	 * 	doc = tmpdoc;
	 * }
	 * requestScope.status = "Number of documents removed: " + dc.getCount();
	 * dc.removeAll(true);
	 * </pre>
	 */
	public abstract NotesDocumentCollection createDocumentCollection() throws NotesApiException;

	/**
	 * Creates a query view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view.
	 * @param formula
	 *            An SQL query selection formula. This formula overrides the selection formula of the template view
	 * @return The new query view.
	 * @throws NotesApiException
	 * @usage The template view must be accessible to the program, so can be a public view or a private view owned by the effective ID running the agent, but cannot be a private view stored in the
	 *        desktop
	 */
	public abstract NotesView createQueryView(String viewName, String formula) throws NotesApiException;

	/**
	 * Creates a query view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view.
	 * @param formula
	 *            An SQL query selection formula. This formula overrides the selection formula of the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in the database</li>
	 *            <li>none if no view in the database is specified as the default design</li>
	 *            </ul>
	 *            <b>Note:</b> The template view cannot be of type "Shared, desktop private on first use."
	 * @return The new query view.
	 * @throws NotesApiException
	 * @usage The template view must be accessible to the program, so can be a public view or a private view owned by the effective ID running the agent, but cannot be a private view stored in the
	 *        desktop
	 */
	public abstract NotesView createQueryView(String viewName, String formula, NotesView templateView) throws NotesApiException;

	/**
	 * Creates a query view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The view is created even if this name duplicates an existing view.
	 * @param formula
	 *            An SQL query selection formula. This formula overrides the selection formula of the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in the database</li>
	 *            <li>none if no view in the database is specified as the default design</li>
	 *            </ul>
	 *            <b>Note:</b> The template view cannot be of type "Shared, desktop private on first use."
	 * @param prohibitDesignRefreshModifications
	 *            <ul>
	 *            <li>true (default) to prohibit the view design from being refreshed</li>
	 *            <li>false to allow the view design to be refreshed</li>
	 *            </ul>
	 * @return The new query view.
	 * @throws NotesApiException
	 * @usage The template view must be accessible to the program, so can be a public view or a private view owned by the effective ID running the agent, but cannot be a private view stored in the
	 *        desktop
	 */
	public abstract NotesView createQueryView(String viewName, String formula, NotesView templateView, boolean prohibitDesignRefreshModifications) throws NotesApiException;

}
