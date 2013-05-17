package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a Notes database.
 * 
 * @author Sven Dreher
 * 
 * @access There are several ways you can use the Database class to access
 *         existing databases and to create new ones.
 *         <ul>
 *         <li>To access the current database if you are running as an agent,
 *         use {@link NotesAgentContext#getCurrentDatabase()} in AgentContext.</li>
 *         <li>To access an existing database when you know its server and file
 *         name, use {@link NotesSession#getDatabase(String, String, boolean)}
 *         in Session.</li>
 *         <li>To access an existing database when you know its server and
 *         replica ID, use
 *         {@link NotesDbDirectory#openDatabaseByReplicaID(String)} in
 *         DbDirectory.</li>
 *         <li>To locate an existing database when you know its server but not
 *         its file name, use the {@link NotesDbDirectory} class.</li>
 *         <li>To access the current user's mail database, use
 *         {@link NotesDbDirectory#openMailDatabase()} in DbDirectory.</li>
 *         <li>To open the default Web Navigator database, use
 *         {@link NotesSession#getURLDatabase()} in Session.</li>
 *         <li>To access the available Domino Directories and Personal Address
 *         Books, use {@link NotesSession#getAddressBooks()} in Session.</li>
 *         <li>To test for the existence of a database with a specific server
 *         and file name before accessing it, use
 *         {@link NotesDbDirectory#openDatabase(String, boolean)} or
 *         {@link NotesDbDirectory#openDatabaseIfModified(String, NotesDateTime)}
 *         in DbDirectory.</li>
 *         <li>To create a new database from an existing database, use
 *         {@link #createCopy(String, String, int)},
 *         {@link #createFromTemplate(String, String, boolean, int)}, or
 *         {@link #createReplica(String, String)}.</li>
 *         <li>To create a new database from scratch, use
 *         {@link NotesDbDirectory#createDatabase(String, boolean)} in
 *         DbDirectory.</li>
 *         <li>To access a database when you have a contained object such as
 *         View, Document, DocumentCollection, ACL, or Agent, use the
 *         appropriate Parent (or ParentDatabase) property.</li>
 *         </ul>
 * <br>
 *         <b>Access levels</b><br>
 *         Notes throws an exception when you attempt to perform an operation
 *         for which the user does not have appropriate access. The properties
 *         and methods that you can successfully use on a Database object are
 *         determined by these factors:
 *         <ul>
 *         <li>
 *         The user's access level to the database, as determined by the
 *         database access control list. The ACL determines if the user can open
 *         a database, add documents to it, remove documents from it, modify the
 *         ACL, and so on.</li>
 *         <li>The user's access level to the server on which the database
 *         resides, as determined by the Server document in the Domino
 *         Directory.</li>
 *         </ul>
 * 
 * @usage A database must be open before you can use all the properties and
 *        methods in the corresponding Database object. In most cases, the class
 *        library automatically opens a database for you. But see isOpen for the
 *        exceptions. <br>
 * <br>
 *        <b>Access levels</b><br>
 *        Notes throws an exception when you attempt to perform an operation for
 *        which the user does not have appropriate access. The properties and
 *        methods that you can successfully use on a Database object are
 *        determined by these factors:
 *        <ul>
 *        <li>The user's access level to the database, as determined by the
 *        database access control list. The ACL determines if the user can open
 *        a database, add documents to it, remove documents from it, modify the
 *        ACL, and so on.</li>
 *        <li>The user's access level to the server on which the database
 *        resides, as determined by the Server document in the Domino Directory.
 *        </li>
 *        </ul>
 * 
 * @example 1. This agent creates a Database object called db and assigns a
 *          database to it. The database is names.nsf, located at the top level
 *          of the data directory on server doc. If the database exists,
 *          getDatabase automatically opens it.
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
 *          2. This agent uses isOpen to test if the database quack.nsf exists
 *          locally. If not, the agent uses the create method to create a new
 *          database on disk.
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
 *          3. This agent is the same as the last except that the database is in
 *          a subdirectory of the data directory. Notice that two backslashes
 *          must be used because the backslash is an escape character in Java.
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
 * 					db = template
 * 							.createFromTemplate(null, &quot;birds\\quack&quot;, true);
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
 *          4. This agent gives Brian Flokka Editor access to the current
 *          database. Using the CurrentDatabase property avoids having to use
 *          file names in agents and makes agents easily portable from one
 *          database to another.
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
 *          5. This agent shows how you can use the openIfModified method to
 *          open a database only if it's been modified after a certain date. The
 *          agent checks if quack.nsf on the current server was modified since
 *          yesterday; if so, the agent opens the database and compacts it.
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
	public abstract boolean openByReplicaID(String server, String replicaID)
			throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @param modifiedSince
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean openIfModified(String server, String dbFile,
			NotesDateTime modifiedSince) throws NotesApiException;

	/**
	 * @param server
	 * @param dbFile
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean openWithFailover(String server, String dbFile)
			throws NotesApiException;

	/**
	 * Compacts a local database.
	 * 
	 * @return The difference in bytes between the size of the database before
	 *         and after compacting.
	 * @throws NotesApiException
	 * 
	 * @usage This method throws an exception if the database is not local.
	 * 
	 * @example This agent compacts a database if less than 75% of its disk
	 *          space is occupied by real data. The user supplies the database
	 *          name as the agent's comment.
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
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; is &quot;
	 * 					+ (int) percentUsed + &quot; percent used&quot;);
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
	 *            One or more command-line options supported by the Compact
	 *            server task without the minus signs. Spaces are insignificant
	 *            except that a space cannot be placed in the S option between
	 *            the number and the final K, k, M, or m. Options are processed
	 *            in their order of specification.
	 * @return The difference in bytes between the size of the database before
	 *         and after compacting.
	 * @throws NotesApiException
	 * @usage This method throws an exception if the database is not local.
	 * 
	 *        An agent cannot compact the current database (the database in
	 *        which the agent is running) or the desktop.dsk file.
	 * 
	 *        The options are those that you can use with the Compact server
	 *        task. For more information, see "Compact options" in
	 *        Administration Help.
	 * 
	 *        This method does not support the e or E option.
	 * @example 1. This agent compacts TooBig.nsf using the options b, L, and
	 *          S10.
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
	 * 				int options = Database.CMPC_RECOVER_REDUCE_INPLACE
	 * 						+ Database.CMPC_NO_LOCKOUT;
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
	public abstract int compactWithOptions(String options)
			throws NotesApiException;

	/**
	 * Compacts a local database allowing the submission of options.
	 * 
	 * @param options
	 *            One or more of the following constants. Combine constants by
	 *            adding.
	 *            <ul>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_COMPACT (1) a (archive and
	 *            delete, then compact)</li>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_ONLY (2) A (archive and
	 *            delete with no compact; supersedes a)</li>
	 *            <li>Database.CMPC_CHK_OVERLAP (32768) o and O (check overlap)</li>
	 *            <li>Database.CMPC_COPYSTYLE (16) c and C (copy style;
	 *            supersedes b and B)</li>
	 *            <li>Database.CMPC_DISABLE_DOCTBLBIT_OPTMZN (128) f (disable
	 *            document table bit map optimization)</li>
	 *            <li>Database.CMPC_DISABLE_LARGE_UNKTBL (4096) k (disable large
	 *            unknown table)</li>
	 *            <li>Database.CMPC_DISABLE_RESPONSE_INFO (512) H (disable
	 *            "Don't support specialized response hierarchy")</li>
	 *            <li>Database.CMPC_DISABLE_TRANSACTIONLOGGING (262144) t
	 *            (disable transaction logging)</li>
	 *            <li>Database.CMPC_DISABLE_UNREAD_MARKS (1048576) U (disable
	 *            "Don't maintain unread marks")</li>
	 *            <li>Database.CMPC_DISCARD_VIEW_INDICES (32) d and D (discard
	 *            view indexes)</li>
	 *            <li>Database.CMPC_ENABLE_DOCTBLBIT_OPTMZN (64) F (enable
	 *            document table bit map optimization; supersedes f)</li>
	 *            <li>Database.CMPC_ENABLE_LARGE_UNKTBL (2048) K (enable large
	 *            unknown table; supersedes k)</li>
	 *            <li>Database.CMPC_ENABLE_RESPONSE_INFO (256) h (enable
	 *            "Don't support specialized response hierarchy"; supersedes H)</li>
	 *            <li>Database.CMPC_ENABLE_TRANSACTIONLOGGING (131072) T (enable
	 *            transaction logging; supersedes t)</li>
	 *            <li>Database.CMPC_ENABLE_UNREAD_MARKS (524288) u (enable
	 *            "Don't maintain unread marks"; supersedes U)</li>
	 *            <li>Database.CMPC_IGNORE_COPYSTYLE_ERRORS (1024) i (ignore
	 *            copy-style errors)</li>
	 *            <li>Database.CMPC_MAX_4GB (16384) m and M (set maximum
	 *            database size at 4 gigabytes)</li>
	 *            <li>Database.CMPC_NO_LOCKOUT (8192) l and L (do not lock out
	 *            users)</li>
	 *            <li>Database.CMPC_RECOVER_INPLACE (8) B (recover unused space
	 *            in-place and reduce file size; supersedes b)</li>
	 *            <li>Database.CMPC_RECOVER_REDUCE_INPLACE (4) b (recover unused
	 *            space in-place without reducing file size)</li>
	 *            <li>Database.CMPC_REVERT_FILEFORMAT (65536) r and R (do not
	 *            convert old file format)</li>
	 *            </ul>
	 * 
	 * @return The difference in bytes between the size of the database before
	 *         and after compacting.
	 * @throws NotesApiException
	 * @usage This method throws an exception if the database is not local.
	 * 
	 *        An agent cannot compact the current database (the database in
	 *        which the agent is running) or the desktop.dsk file.
	 * 
	 *        The options are those that you can use with the Compact server
	 *        task. For more information, see "Compact options" in
	 *        Administration Help.
	 * 
	 *        This method does not support the e or E option.
	 * @example 1. This agent compacts TooBig.nsf using the options b, L, and
	 *          S10.
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
	 * 				int options = Database.CMPC_RECOVER_REDUCE_INPLACE
	 * 						+ Database.CMPC_NO_LOCKOUT;
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
	public abstract int compactWithOptions(int options)
			throws NotesApiException;

	/**
	 * Compacts a local database allowing the submission of options.
	 * 
	 * @param options
	 *            One or more of the following constants. Combine constants by
	 *            adding.
	 *            <ul>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_COMPACT (1) a (archive and
	 *            delete, then compact)</li>
	 *            <li>Database.CMPC_ARCHIVE_DELETE_ONLY (2) A (archive and
	 *            delete with no compact; supersedes a)</li>
	 *            <li>Database.CMPC_CHK_OVERLAP (32768) o and O (check overlap)</li>
	 *            <li>Database.CMPC_COPYSTYLE (16) c and C (copy style;
	 *            supersedes b and B)</li>
	 *            <li>Database.CMPC_DISABLE_DOCTBLBIT_OPTMZN (128) f (disable
	 *            document table bit map optimization)</li>
	 *            <li>Database.CMPC_DISABLE_LARGE_UNKTBL (4096) k (disable large
	 *            unknown table)</li>
	 *            <li>Database.CMPC_DISABLE_RESPONSE_INFO (512) H (disable
	 *            "Don't support specialized response hierarchy")</li>
	 *            <li>Database.CMPC_DISABLE_TRANSACTIONLOGGING (262144) t
	 *            (disable transaction logging)</li>
	 *            <li>Database.CMPC_DISABLE_UNREAD_MARKS (1048576) U (disable
	 *            "Don't maintain unread marks")</li>
	 *            <li>Database.CMPC_DISCARD_VIEW_INDICES (32) d and D (discard
	 *            view indexes)</li>
	 *            <li>Database.CMPC_ENABLE_DOCTBLBIT_OPTMZN (64) F (enable
	 *            document table bit map optimization; supersedes f)</li>
	 *            <li>Database.CMPC_ENABLE_LARGE_UNKTBL (2048) K (enable large
	 *            unknown table; supersedes k)</li>
	 *            <li>Database.CMPC_ENABLE_RESPONSE_INFO (256) h (enable
	 *            "Don't support specialized response hierarchy"; supersedes H)</li>
	 *            <li>Database.CMPC_ENABLE_TRANSACTIONLOGGING (131072) T (enable
	 *            transaction logging; supersedes t)</li>
	 *            <li>Database.CMPC_ENABLE_UNREAD_MARKS (524288) u (enable
	 *            "Don't maintain unread marks"; supersedes U)</li>
	 *            <li>Database.CMPC_IGNORE_COPYSTYLE_ERRORS (1024) i (ignore
	 *            copy-style errors)</li>
	 *            <li>Database.CMPC_MAX_4GB (16384) m and M (set maximum
	 *            database size at 4 gigabytes)</li>
	 *            <li>Database.CMPC_NO_LOCKOUT (8192) l and L (do not lock out
	 *            users)</li>
	 *            <li>Database.CMPC_RECOVER_INPLACE (8) B (recover unused space
	 *            in-place and reduce file size; supersedes b)</li>
	 *            <li>Database.CMPC_RECOVER_REDUCE_INPLACE (4) b (recover unused
	 *            space in-place without reducing file size)</li>
	 *            <li>Database.CMPC_REVERT_FILEFORMAT (65536) r and R (do not
	 *            convert old file format)</li>
	 *            </ul>
	 * @param spaceThreshold
	 *            The value of the S option (compact if specified percent or
	 *            amount of unused space) without the S, for example, "10" for
	 *            10 percent, "10K" for 10 kilobytes, or "10M" for 10 megabytes.
	 * @return The difference in bytes between the size of the database before
	 *         and after compacting.
	 * @throws NotesApiException
	 * @usage This method throws an exception if the database is not local.
	 * 
	 *        An agent cannot compact the current database (the database in
	 *        which the agent is running) or the desktop.dsk file.
	 * 
	 *        The options are those that you can use with the Compact server
	 *        task. For more information, see "Compact options" in
	 *        Administration Help.
	 * 
	 *        This method does not support the e or E option.
	 * @example 1. This agent compacts TooBig.nsf using the options b, L, and
	 *          S10.
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
	 * 				int options = Database.CMPC_RECOVER_REDUCE_INPLACE
	 * 						+ Database.CMPC_NO_LOCKOUT;
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
	public abstract int compactWithOptions(int options, String spaceThreshold)
			throws NotesApiException;

	/**
	 * Creates an empty copy of the current database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify
	 *            null or an empty string ("") to create a local copy.
	 * @param dbFile
	 *            The file name of the new copy.
	 * @return The new copy.
	 * @throws NotesApiException
	 * 
	 * @usage If a database with the specified file name already exists, an
	 *        exception is thrown.
	 * 
	 *        The copy contains the design elements of the current database, an
	 *        identical access control list, and an identical title. It does not
	 *        contain any documents.
	 * 
	 *        The copy is not a replica.
	 * 
	 *        Programs using remote (IIOP) calls to a server can't create or
	 *        access databases on other servers. In these cases, the server
	 *        parameter must correspond to the server the program is running on.
	 *        There are two ways to do this:
	 *        <ul>
	 *        <li>Use null or an empty string ("") to indicate the current
	 *        computer. This is the safer method.</li>
	 *        <li>Make sure the name of the server that the program runs on
	 *        matches the name of server.</li>
	 *        </ul>
	 *        Programs running on a workstation can access several different
	 *        servers in a single program.
	 * 
	 *        The ACL of the original database gets copied to the new database,
	 *        but you may want to modify the copy's ACL. For example, you may
	 *        want Manager access to the copy for yourself even if you're not a
	 *        manager of the original. Use the methods
	 *        {@link #grantAccess(String, int)} and
	 *        {@link #revokeAccess(String)} to modify the copy's ACL.
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
	 *          2. This agent makes a local copy of the local database names.nsf
	 *          and sets the maxsize to 2.
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
	public abstract NotesDatabase createCopy(String server, String dbFile)
			throws NotesApiException;

	/**
	 * Creates an empty copy of the current database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify
	 *            null or an empty string ("") to create a local copy.
	 * @param dbFile
	 *            The file name of the new copy.
	 * @param maxSize
	 *            The maximum size (in gigabytes) that you would like to assign
	 *            to the new database. This parameter applies only to Release 4
	 *            databases or those created on a server that has not been
	 *            upgraded to Release 5. Entering an integer greater than 4
	 *            generates a run-time error
	 * @return The new copy.
	 * @throws NotesApiException
	 * @usage If a database with the specified file name already exists, an
	 *        exception is thrown.
	 * 
	 *        The copy contains the design elements of the current database, an
	 *        identical access control list, and an identical title. It does not
	 *        contain any documents.
	 * 
	 *        The copy is not a replica.
	 * 
	 *        Programs using remote (IIOP) calls to a server can't create or
	 *        access databases on other servers. In these cases, the server
	 *        parameter must correspond to the server the program is running on.
	 *        There are two ways to do this:
	 *        <ul>
	 *        <li>Use null or an empty string ("") to indicate the current
	 *        computer. This is the safer method.</li>
	 *        <li>Make sure the name of the server that the program runs on
	 *        matches the name of server.</li>
	 *        </ul>
	 *        Programs running on a workstation can access several different
	 *        servers in a single program.
	 * 
	 *        The ACL of the original database gets copied to the new database,
	 *        but you may want to modify the copy's ACL. For example, you may
	 *        want Manager access to the copy for yourself even if you're not a
	 *        manager of the original. Use the methods
	 *        {@link #grantAccess(String, int)} and
	 *        {@link #revokeAccess(String)} to modify the copy's ACL.
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
	 *          2. This agent makes a local copy of the local database names.nsf
	 *          and sets the maxsize to 2.
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
	public abstract NotesDatabase createCopy(String server, String dbFile,
			int maxSize) throws NotesApiException;

	/**
	 * Creates a document in a database and returns a Document object that
	 * represents the new document.
	 * 
	 * @return The new document.
	 * @throws NotesApiException
	 * @usage You must call {@link NotesDocument#save()} if you want the new
	 *        document to be saved.
	 * @example This agent creates a new document in the current database, sets
	 *          values for its Form, Subject, Categories, and Body items, and
	 *          saves it.
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
	 *            The name of the server where the new database resides. Specify
	 *            null or an empty string ("") to create a database on the
	 *            current computer.
	 * @param dbFile
	 *            The file name of the new database.
	 * @param inherit
	 *            Specify true if you want the new database to inherit future
	 *            design changes from the template; otherwise, specify false.
	 * @return The new database, which contains the forms, subforms, fields,
	 *         views, folders, navigators, agents, and documents of the
	 *         template.
	 * @throws NotesApiException
	 * 
	 * @usage If a database with the specified file name already exists, an
	 *        exception is thrown.
	 * 
	 *        The new database has the design elements and documents of the
	 *        existing database.
	 * 
	 *        If "Database file is a master template" is set in the current
	 *        database, the ACL of the new database takes the following entries:
	 * 
	 *        <ul>
	 *        <li>The current user with Manager access.</li>
	 *        <li>The server containing the database with Manager access, if the
	 *        new database is on a server.</li>
	 *        <li>"-Default-" with indeterminate access. You should explicitly
	 *        set the access for -Default- after creating the database.</li>
	 *        <li>Any bracketed names in the ACL of the existing database with
	 *        the brackets removed; for example, "[Mary Brackets]" in the
	 *        existing ACL becomes "Mary Brackets" in the new ACL. No other
	 *        entries are copied from the existing ACL.</li>
	 *        </ul>
	 *        If "Database file is a master template" is not set in the current
	 *        database, the ACL of the current database is copied to the new
	 *        database.<br>
	 * 
	 *        If "Database file is a master template" is set in the current
	 *        database and the new database is on a server, that server is set
	 *        as the administration server for the new database.<br>
	 * 
	 *        Programs making remote (IIOP) calls to a server can't create or
	 *        access databases on other servers. In these cases, the server
	 *        parameter must correspond to the server the program is running on.
	 *        There are two ways to do this:
	 * 
	 *        Use null or an empty string ("") to indicate the current computer.
	 *        This is the safer method. Make sure the name of the server that
	 *        the program runs on matches the name of the server parameter.
	 *        Programs running on a workstation can access several different
	 *        servers in a single program.
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
	public abstract NotesDatabase createFromTemplate(String server,
			String dbFile, boolean inherit) throws NotesApiException;

	/**
	 * Creates a new database from an existing database.
	 * 
	 * @param server
	 *            The name of the server where the new database resides. Specify
	 *            null or an empty string ("") to create a database on the
	 *            current computer.
	 * @param dbFile
	 *            The file name of the new database.
	 * @param inherit
	 *            Specify true if you want the new database to inherit future
	 *            design changes from the template; otherwise, specify false.
	 * @param maxSize
	 *            The maximum size (in gigabytes) that you would like to assign
	 *            to the new database. This parameter applies only to Release 4
	 *            databases or those created on a server that has not been
	 *            upgraded to Release 5. Entering an integer greater than 4
	 *            generates a run-time error.
	 * @return The new database, which contains the forms, subforms, fields,
	 *         views, folders, navigators, agents, and documents of the
	 *         template.
	 * @throws NotesApiException
	 * @usage If a database with the specified file name already exists, an
	 *        exception is thrown.
	 * 
	 *        The new database has the design elements and documents of the
	 *        existing database.
	 * 
	 *        If "Database file is a master template" is set in the current
	 *        database, the ACL of the new database takes the following entries:
	 * 
	 *        <ul>
	 *        <li>The current user with Manager access.</li>
	 *        <li>The server containing the database with Manager access, if the
	 *        new database is on a server.</li>
	 *        <li>"-Default-" with indeterminate access. You should explicitly
	 *        set the access for -Default- after creating the database.</li>
	 *        <li>Any bracketed names in the ACL of the existing database with
	 *        the brackets removed; for example, "[Mary Brackets]" in the
	 *        existing ACL becomes "Mary Brackets" in the new ACL. No other
	 *        entries are copied from the existing ACL.</li>
	 *        </ul>
	 *        If "Database file is a master template" is not set in the current
	 *        database, the ACL of the current database is copied to the new
	 *        database.<br>
	 * 
	 *        If "Database file is a master template" is set in the current
	 *        database and the new database is on a server, that server is set
	 *        as the administration server for the new database.<br>
	 * 
	 *        Programs making remote (IIOP) calls to a server can't create or
	 *        access databases on other servers. In these cases, the server
	 *        parameter must correspond to the server the program is running on.
	 *        There are two ways to do this:
	 * 
	 *        Use null or an empty string ("") to indicate the current computer.
	 *        This is the safer method. Make sure the name of the server that
	 *        the program runs on matches the name of the server parameter.
	 *        Programs running on a workstation can access several different
	 *        servers in a single program.
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
	public abstract NotesDatabase createFromTemplate(String server,
			String dbFile, boolean inherit, int maxSize)
			throws NotesApiException;

	/**
	 * Creates a full-text index for a database.
	 * 
	 * @param options
	 *            Combine options with addition.
	 *            <ul>
	 *            <li>Database.FTINDEX_ALL_BREAKS (4) to index sentence and
	 *            paragraph breaks</li>
	 *            <li>Database.FTINDEX_ATTACHED_BIN_FILES (16) to index attached
	 *            files (binary)</li>
	 *            <li>Database.FTINDEX_ATTACHED_FILES (1) to index attached
	 *            files (raw text)</li>
	 *            <li>Database.FTINDEX_CASE_SENSITIVE (8) to enable
	 *            case-sensitive searches</li>
	 *            <li>Database.FTINDEX_ENCRYPTED_FIELDS (2) to index encrypted
	 *            fields</li>
	 *            </ul>
	 * @param recreate
	 *            A true removes any existing full-text index before creating
	 *            one. If this parameter is false and an index exists, no action
	 *            is taken.
	 * @throws NotesApiException
	 * @usage This method works only for local databases.
	 * @example This agent creates or recreates a full-text index in the current
	 *          database
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
	 * 			int options = Database.FTINDEX_ALL_BREAKS
	 * 					+ Database.FTINDEX_CASE_SENSITIVE;
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
	public abstract void createFTIndex(int options, boolean recreate)
			throws NotesApiException;

	/**
	 * Creates a replica of the current database at a new location
	 * 
	 * @param server
	 *            The name of the server where the replica will reside. Specify
	 *            null or an empty string ("") to create a replica on the
	 *            current computer
	 * @param dbFile
	 *            The file name of the replica
	 * @return The new replica
	 * @throws NotesApiException
	 * @usage If a database with the specified file name already exists, an
	 *        exception is thrown.
	 * 
	 *        The new replica has the same access control list as the current
	 *        database.
	 * 
	 *        Programs making remote (IIOP) calls to a server can't create or
	 *        access databases on other servers. In these cases, the server
	 *        parameter must correspond to the server the program is running on.
	 *        There are two ways to do this:
	 *        <ul>
	 *        <li>
	 *        Use null or an empty string ("") to indicate the current computer.
	 *        This is the safer method.</li>
	 *        <li>Make sure the name of the server that the program runs on
	 *        matches the name of the server parameter.</li>
	 *        </ul>
	 *        Programs running on a workstation can access several different
	 *        servers in a single program
	 * @example This agent creates a replica of the Domlog.nsf from notesua1 on
	 *          the current computer
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
	 * 			System.out.println(&quot;Database \&quot;&quot; + title
	 * 					+ &quot;\&quot; has a new local replica&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase createReplica(String server, String dbFile)
			throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database.
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that
	 *            follows.
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a
	 *            sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When
	 *            the collection is sorted by relevance, the highest relevance
	 *            appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.
	 *            </li>
	 *            <li>Database.FT_DATECREATED_DES sorts by document creation
	 *            date in descending order.</li>
	 *            <li>Database.FT_DATECREATED_ASC sorts by document creation
	 *            date in ascending order.</li>
	 *            <li>Database.FT_DATE_DES sorts by document date in descending
	 *            order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document date in ascending
	 *            order.</li>
	 *            </ul>
	 * @return A collection of documents that match the full-text query, sorted
	 *         by the selected option. If no matches are found, the collection
	 *         has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearchRange minus the start
	 *        parameter.<br>
	 * 
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use the IsFTIndexed
	 *        property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only
	 *        documents found in a particular view, use the FTSearch method in
	 *        View. To search only documents found in a particular document
	 *        collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents
	 *        sorted by relevance score. If you ask for a sort by date, you
	 *        don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the
	 *        relevance score, depending on the sort options you use in the
	 *        document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a
	 *        multi-database search. Navigation through the resulting document
	 *        collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is,
	 *        except that search keywords must be enclosed in quotes. Remember
	 *        to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the
	 *        complete syntax rules, see
	 *        "Refining a search query using operators" in Lotus Notes Help.
	 *        Search for "query syntax" in the Domino Designer Eclipse help
	 *        system or information center (for example, http://publib.boulder
	 *        .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include
	 *        Lotus Notes.
	 * @example 1. This agent searches the current database for the phrase
	 *          specified in the agent's comment if the database is full-text
	 *          indexed. Every document, up to a maximum of 100 documents
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
	 * 				System.out.println(&quot;FTSearch of \&quot;&quot; + title + &quot;\&quot; found &quot;
	 * 						+ matches + &quot; document(s) with &quot; + agent.getComment());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; is not full-text indexed&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This code fragment collects all documents containing both the
	 *          words "red" and "blue."
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red &amp; blue&quot;, 100);
	 * </pre>
	 * 
	 *          3. This code fragment collects all documents containing either
	 *          the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red | blue&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 * 
	 *          4. This code fragment collects all documents that do not contain
	 *          the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;not (red | blue)&quot;, 100,
	 * 		Database.FT_DATE_DES, 0);
	 * </pre>
	 */
	public abstract NotesDocumentCollection FTSearch(String query, int sortOpt)
			throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database.
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that
	 *            follows.
	 * @return A collection of documents that match the full-text query, sorted
	 *         by the selected option. If no matches are found, the collection
	 *         has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearchRange minus the start
	 *        parameter.<br>
	 * 
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use the IsFTIndexed
	 *        property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only
	 *        documents found in a particular view, use the FTSearch method in
	 *        View. To search only documents found in a particular document
	 *        collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents
	 *        sorted by relevance score. If you ask for a sort by date, you
	 *        don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the
	 *        relevance score, depending on the sort options you use in the
	 *        document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a
	 *        multi-database search. Navigation through the resulting document
	 *        collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is,
	 *        except that search keywords must be enclosed in quotes. Remember
	 *        to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the
	 *        complete syntax rules, see
	 *        "Refining a search query using operators" in Lotus Notes Help.
	 *        Search for "query syntax" in the Domino Designer Eclipse help
	 *        system or information center (for example, http://publib.boulder
	 *        .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include
	 *        Lotus Notes.
	 * @example 1. This agent searches the current database for the phrase
	 *          specified in the agent's comment if the database is full-text
	 *          indexed. Every document, up to a maximum of 100 documents
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
	 * 				System.out.println(&quot;FTSearch of \&quot;&quot; + title + &quot;\&quot; found &quot;
	 * 						+ matches + &quot; document(s) with &quot; + agent.getComment());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; is not full-text indexed&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This code fragment collects all documents containing both the
	 *          words "red" and "blue."
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red &amp; blue&quot;, 100);
	 * </pre>
	 * 
	 *          3. This code fragment collects all documents containing either
	 *          the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red | blue&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 * 
	 *          4. This code fragment collects all documents that do not contain
	 *          the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;not (red | blue)&quot;, 100,
	 * 		Database.FT_DATE_DES, 0);
	 * </pre>
	 */
	public abstract NotesDocumentCollection FTSearch(String query)
			throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database.
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that
	 *            follows.
	 * @param max
	 *            The maximum number of documents you want returned from the
	 *            query. Set this parameter to 0 to receive all matching
	 *            documents (up to 5,000. See Usage section below).
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a
	 *            sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When
	 *            the collection is sorted by relevance, the highest relevance
	 *            appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.
	 *            </li>
	 *            <li>Database.FT_DATECREATED_DES sorts by document creation
	 *            date in descending order.</li>
	 *            <li>Database.FT_DATECREATED_ASC sorts by document creation
	 *            date in ascending order.</li>
	 *            <li>Database.FT_DATE_DES sorts by document date in descending
	 *            order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document date in ascending
	 *            order.</li>
	 *            </ul>
	 * @param otherOpt
	 *            Integer. Use the following constants to specify additional
	 *            search options. To specify more than one option, use a logical
	 *            or operation.
	 *            <ul>
	 *            <li>
	 *            Database.FT_FUZZY specifies a fuzzy search.</li>
	 *            <li>
	 *            Database.FT_STEMS uses stem words as the basis of the search.</li>
	 *            </ul>
	 * @return A collection of documents that match the full-text query, sorted
	 *         by the selected option. If no matches are found, the collection
	 *         has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearchRange minus the start
	 *        parameter.<br>
	 * 
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use the IsFTIndexed
	 *        property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only
	 *        documents found in a particular view, use the FTSearch method in
	 *        View. To search only documents found in a particular document
	 *        collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents
	 *        sorted by relevance score. If you ask for a sort by date, you
	 *        don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the
	 *        relevance score, depending on the sort options you use in the
	 *        document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a
	 *        multi-database search. Navigation through the resulting document
	 *        collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is,
	 *        except that search keywords must be enclosed in quotes. Remember
	 *        to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the
	 *        complete syntax rules, see
	 *        "Refining a search query using operators" in Lotus Notes Help.
	 *        Search for "query syntax" in the Domino Designer Eclipse help
	 *        system or information center (for example, http://publib.boulder
	 *        .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include
	 *        Lotus Notes.
	 * @example 1. This agent searches the current database for the phrase
	 *          specified in the agent's comment if the database is full-text
	 *          indexed. Every document, up to a maximum of 100 documents
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
	 * 				System.out.println(&quot;FTSearch of \&quot;&quot; + title + &quot;\&quot; found &quot;
	 * 						+ matches + &quot; document(s) with &quot; + agent.getComment());
	 * 			} else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; is not full-text indexed&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This code fragment collects all documents containing both the
	 *          words "red" and "blue."
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red &amp; blue&quot;, 100);
	 * </pre>
	 * 
	 *          3. This code fragment collects all documents containing either
	 *          the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;red | blue&quot;, 100, Database.FT_DATE_DES, 0);
	 * </pre>
	 * 
	 *          4. This code fragment collects all documents that do not contain
	 *          the word "red" or "blue" in descending order by creation date
	 * 
	 *          <pre>
	 * DocumentCollection dc = db.FTSearch(&quot;not (red | blue)&quot;, 100,
	 * 		Database.FT_DATE_DES, 0);
	 * </pre>
	 */
	public abstract NotesDocumentCollection FTSearch(String query, int max,
			int sortOpt, int otherOpt) throws NotesApiException;

	/**
	 * Conducts a full-text search of all the documents in a database
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that
	 *            follows
	 * @param max
	 *            The maximum number of documents you want returned from the
	 *            query. Set this parameter to 0 to receive all matching
	 *            documents
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a
	 *            sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When
	 *            the collection is sorted by relevance, the highest relevance
	 *            appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.
	 *            </li>
	 *            <li>
	 *            Database.FT_DATECREATED_DES sorts by document creation date in
	 *            descending order</li>
	 *            <li>
	 *            Database.FT_DATECREATED_ASC sorts by document creation date in
	 *            ascending order</li>
	 *            <li>
	 *            Database.FT_DATE_DES sorts by document date in descending
	 *            order</li>
	 *            <li>
	 *            Database.FT_DATE_ASC sorts by document date in ascending order
	 *            </li>
	 *            <ul>
	 * @param otherOpt
	 *            Integer. Use the following constants to specify additional
	 *            search options. To specify more than one option, use a logical
	 *            or operation.
	 *            <ul>
	 *            <li>
	 *            Database.FT_FUZZY specifies a fuzzy search</li>
	 *            <li>
	 *            Database.FT_STEMS uses stem words as the basis of the search</li>
	 *            </ul>
	 * @param start
	 *            The starting document to return
	 * @return A collection of documents that match the full-text query, sorted
	 *         by the selected option. If no matches are found, the collection
	 *         has a count of 0
	 * @throws NotesApiException
	 * @usage This method is the same the same as FTSearch plus the start
	 *        parameter.<br>
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use the IsFTIndexed
	 *        property. To create an index on a local database, use the
	 *        updateFTIndex method.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        This method searches all documents in a database. To search only
	 *        documents found in a particular view, use the FTSearch method in
	 *        View. To search only documents found in a particular document
	 *        collection, use the FTSearch method in DocumentCollection.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents
	 *        sorted by relevance score. If you ask for a sort by date, you
	 *        don't get relevance scores. A Newsletter object formats its
	 *        doclink report with either the document creation date or the
	 *        relevance score, depending on the sort options you use in the
	 *        document collection.<br>
	 * 
	 *        If the database has a multi-database index, you get a
	 *        multi-database search. Navigation through the resulting document
	 *        collection may be slow, but you can create a newsletter from the
	 *        collection.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is,
	 *        except that search keywords must be enclosed in quotes. Remember
	 *        to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the
	 *        complete syntax rules, see
	 *        "Refining a search query using operators" in Lotus Notes Help.
	 *        Search for "query syntax" in the Domino Designer Eclipse help
	 *        system or information center (for example, http://publib.boulder
	 *        .ibm.com/infocenter/domhelp/v8r0/index.jsp), both of which include
	 *        Lotus Notes.
	 * @example This agent returns all the documents in the current database
	 *          that contain a user-specified string, in groups of eight
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
	 * 				DocumentCollection dc = db.FTSearchRange(query, 8,
	 * 						Database.FT_SCORES, Database.FT_STEMS, start);
	 * 				while (dc.getCount() &gt; 0) {
	 * 					// Display subject for documents matching query
	 * 					System.out.println(&quot;Search results &quot; + start + &quot; - &quot;
	 * 							+ (start - 1 + dc.getCount()));
	 * 					Document doc = dc.getFirstDocument();
	 * 					while (doc != null) {
	 * 						System.out.println(&quot;\t&quot;
	 * 								+ doc.getItemValueString(&quot;Subject&quot;));
	 * 						doc = dc.getNextDocument(doc);
	 * 					}
	 * 					// Get next 8 documents that match the query
	 * 					start = start + 8;
	 * 					dc = db.FTSearchRange(query, 8, Database.FT_SCORES,
	 * 							Database.FT_STEMS, start);
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
	public abstract NotesDocumentCollection FTSearchRange(String query,
			int max, int sortOpt, int otherOpt, int start)
			throws NotesApiException;

	/**
	 * The access control list for a database.
	 * 
	 * @return The access control list for a database.
	 * @throws NotesApiException
	 * @usage The database must be open to use this property.
	 * @example This agent prints the name of every entry in the ACL of the
	 *          current database.
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
	 * @usage Each vector element contains one entry from the log. The database
	 *        must be open to use this property.
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
	 * @return An unsorted collection containing all the documents in a
	 *         database.
	 * @throws NotesApiException
	 * @usage The {@link #FTSearch(String)} and {@link #search(String)} methods
	 *        return smaller collections of documents that meet specific
	 *        criteria. Using the AllDocuments property is more efficient than
	 *        using the search method with an "@All" formula. The database must
	 *        be open to use this property.
	 * 
	 * @example This agent gets the number of documents in the current database,
	 *          then gets the value of the Subject item for each document.
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
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; has &quot;
	 * 					+ dc.getCount() + &quot; documents&quot;);
	 * 			int n = 0;
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				n++;
	 * 				System.out.println(&quot;Document # &quot; + n + &quot;: &quot;
	 * 						+ doc.getItemValueString(&quot;Subject&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getAllDocuments()
			throws NotesApiException;

	/**
	 * Finds an agent in a database, given the agent name
	 * 
	 * @param name
	 *            The name of the agent
	 * @return The agent whose name matches the parameter
	 * @throws NotesApiException
	 * @usage The return value is null if the current user (as obtained by
	 *        Session.getUserName) is not the owner of the private agent
	 * @example This agent prints the owner, last run date, and query for the
	 *          agent named "Update Thread Maps."
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
	 * @usage If the program runs on a workstation or is remote (IIOP), the
	 *        return vector includes shared agents and private agents that
	 *        belong to the current user. If the program runs on a server, the
	 *        return vector includes only shared agents. The database must be
	 *        open to use this property.
	 * @example This agent prints the name of each agent in the current
	 *          database.
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
	 * The categories under which a database appears in the Database Library.
	 * Multiple categories are separated by a comma or semicolon
	 * 
	 * @return The categories under which a database appears in the Database
	 *         Library. Multiple categories are separated by a comma or
	 *         semicolon
	 * @throws NotesApiException
	 * @usage A database retrieved through getFirstDatabase or getNextDatabase
	 *        in DbDirectory does not have to be open for getCategories.
	 *        Otherwise, the database must be open
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
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; has the categories: &quot; + cat);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; has no categories&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the Categories property of the current
	 *          database to "Examples database."
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
	 * The categories under which a database appears in the Database Library.
	 * Multiple categories are separated by a comma or semicolon
	 * 
	 * @param categories
	 *            The categories under which a database appears in the Database
	 *            Library. Multiple categories are separated by a comma or
	 *            semicolon
	 * @throws NotesApiException
	 * @usage A database retrieved through getFirstDatabase or getNextDatabase
	 *        in DbDirectory does not have to be open for getCategories.
	 *        Otherwise, the database must be open
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
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; has the categories: &quot; + cat);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; has no categories&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the Categories property of the current
	 *          database to "Examples database."
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
	public abstract void setCategories(String categories)
			throws NotesApiException;

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
	 * 			System.out.println(&quot;Database \&quot;&quot; + title + &quot;\&quot; was created on &quot;
	 * 					+ created);
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
	 * @usage If a program runs on a workstation or is remote (IIOP),
	 *        CurrentAccessLevel is determined by the access level of the
	 *        current user.
	 * 
	 *        If a program runs on a server, CurrentAccessLevel is determined by
	 *        the access level of the person who last saved the program (the
	 *        owner).
	 * 
	 *        The database must be open to use this property.
	 * @example This example prints a message indicating the current user's
	 *          access level to the current database
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
	 * The name of the design template from which a database inherits its
	 * design. If the database does not inherit its design from a design
	 * template, returns an empty string
	 * 
	 * @return The name of the design template from which a database inherits
	 *         its design. If the database does not inherit its design from a
	 *         design template, returns an empty string
	 * @throws NotesApiException
	 * @usage If a database inherits a specific design element (such as a form)
	 *        but not its entire design from a template, this property returns
	 *        an empty string.
	 * 
	 *        A database does not need to be open to use this property
	 * @example This agent prints the design template name for the current
	 *          database if one exists
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
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; inherits its design from &quot; + template);
	 * 			else
	 * 				System.out.println(&quot;Database \&quot;&quot; + title
	 * 						+ &quot;\&quot; did not inherit its design from a template&quot;);
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
	 * @usage For an explanation of note IDs, see the NoteID property in
	 *        Document.
	 * 
	 *        If you get a note ID from @NoteID, delete the "NT" prefix
	 * @example This agent gets the document in the current database whose note
	 *          ID is the agent comment, if such a document exists, and prints
	 *          the value of the Subject item
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
	 * 			System.out.println(&quot;Document &quot; + agent.getComment()
	 * 					+ &quot; has the subject: &quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getDocumentByID(String noteID)
			throws NotesApiException;

	/**
	 * Finds a document in a database, given the document universal ID (UNID).
	 * 
	 * @param unid
	 *            The universal ID of a document
	 * @return The document whose universal ID matches the parameter
	 * @throws NotesApiException
	 * @usage For an explanation of universal IDs, see getUniversalID in
	 *        Document. You can obtain the universal ID from getUniversalID or
	 *        getParentDocumentUNID in Document.
	 * 
	 *        Not matching the UNID to a document in the database throws
	 *        NotesError.NOTES_ERR_BAD_UNID (4091).
	 * @example 1. This agent gets the parents of all the response documents in
	 *          the current database
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
	 * 					Document pdoc = db.getDocumentByUNID(doc
	 * 							.getParentDocumentUNID());
	 * 					String docSubj = doc.getItemValueString(&quot;Subject&quot;);
	 * 					String pdocSubj = pdoc.getItemValueString(&quot;Subject&quot;);
	 * 					System.out.println(&quot;\&quot;&quot; + pdocSubj
	 * 							+ &quot;\&quot; has the response \&quot;&quot; + docSubj + &quot;\&quot;&quot;);
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
	 *          2. This agent demonstrates catching
	 *          NotesError.NOTES_ERR_BAD_UNID. The UNID is deliberately altered
	 *          to cause the error
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
	 * 						String badUNID = &quot;Z&quot;
	 * 								+ doc.getParentDocumentUNID().substring(1);
	 * 						Document pdoc = db.getDocumentByUNID(badUNID);
	 * 						String pdocSubj = pdoc.getItemValueString(&quot;Subject&quot;);
	 * 						System.out.println(&quot;\&quot;&quot; + pdocSubj
	 * 								+ &quot;\&quot; has the response \&quot;&quot; + docSubj + &quot;\&quot;&quot;);
	 * 					} catch (NotesException ne) {
	 * 						if (ne.id == NotesError.NOTES_ERR_BAD_UNID)
	 * 							System.out.println(&quot;Bad UNID for \&quot;&quot; + docSubj
	 * 									+ &quot;\&quot;&quot;);
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
	public abstract NotesDocument getDocumentByUNID(String unid)
			throws NotesApiException;

	/**
	 * @param url
	 * @param reload
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument getDocumentByURL(String url, boolean reload)
			throws NotesApiException;

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
	public abstract NotesDocument getDocumentByURL(String url, boolean reload,
			boolean relIfMod, boolean urlList, String charset, String webUser,
			String webPasswd, String proxyUser, String proxyPasswd,
			boolean returnImmediately) throws NotesApiException;

	/**
	 * @param profileName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getProfileDocCollection(
			String profileName) throws NotesApiException;

	/**
	 * Creates a note collection based on the current database and returns a
	 * NoteCollection object that represents the note collection.
	 * 
	 * @param selectAllFlag
	 *            Sets all the "Select" note collection properties true or false
	 * @return The new note collection
	 * @throws NotesApiException
	 * @usage For more information, see the {@link NotesNoteCollection} class
	 * @example This agent builds a note collection consisting of the documents
	 *          in the database
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
	public abstract NotesNoteCollection createNoteCollection(
			boolean selectAllFlag) throws NotesApiException;

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
	public abstract boolean getFolderReferencesEnabled()
			throws NotesApiException;

	/**
	 * @param bEnable
	 * @throws NotesApiException
	 */
	public abstract void setFolderReferencesEnabled(boolean bEnable)
			throws NotesApiException;

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
	public abstract NotesDocument getProfileDocument(String profile,
			String profileKey) throws NotesApiException;

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
	public abstract String getURLHeaderInfo(String url, String header,
			String webUser, String webPasswd, String proxyUser,
			String proxyPasswd) throws NotesApiException;

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
	public abstract void grantAccess(String name, int level)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDelayUpdates() throws NotesApiException;

	/**
	 * @param delay
	 * @throws NotesApiException
	 */
	public abstract void setDelayUpdates(boolean delay)
			throws NotesApiException;

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
	public abstract int queryAccessPrivileges(String name)
			throws NotesApiException;

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
	public abstract NotesDocumentCollection search(String formula)
			throws NotesApiException;

	/**
	 * @param formula
	 * @param dt
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection search(String formula,
			NotesDateTime dt) throws NotesApiException;

	/**
	 * @param formula
	 * @param dt
	 * @param max
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection search(String formula,
			NotesDateTime dt, int max) throws NotesApiException;

	/**
	 * @param frequency
	 * @throws NotesApiException
	 */
	public abstract void setFTIndexFrequency(int frequency)
			throws NotesApiException;

	/**
	 * @param indexing
	 * @throws NotesApiException
	 */
	public abstract void setInMultiDbIndexing(boolean indexing)
			throws NotesApiException;

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
	public abstract NotesReplication getReplicationInfo()
			throws NotesApiException;

	/**
	 * Conducts a Domain Search, that is, a full-text search of all databases
	 * listed in a Domain Catalog and marked as included for multi-database
	 * indexing
	 * 
	 * @param query
	 *            The full-text query. See the section "Query Syntax" that
	 *            follows
	 * @param max
	 *            The maximum number of documents you want returned from the
	 *            query. Set this parameter to 0 to receive all matching
	 *            documents
	 * @param sortOpt
	 *            Integer. Use one of the following constants to specify a
	 *            sorting option:
	 *            <ul>
	 *            <li>
	 *            Database.FT_SCORES (default) sorts by relevance score. When
	 *            the collection is sorted by relevance, the highest relevance
	 *            appears first. To access the relevance score of each document
	 *            in the collection, use the FTSearchScore property in Document.
	 *            </li>
	 *            <li>Database.FT_DATE_DES sorts by document creation date in
	 *            descending order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document creation date in
	 *            ascending order</li>
	 *            </ul>
	 * @param otherOpt
	 *            Integer. Use the following constants to specify additional
	 *            search options. To specify more than one option, use a logical
	 *            or operation.
	 *            <ul>
	 *            <li>
	 *            Database.FT_DATABASE includes Domino databases in the search
	 *            scope.</li>
	 *            <li>Database.FT_FILESYSTEM includes files other than Domino
	 *            databases in the search scope.</li>
	 *            <li>Database.FT_FUZZY specifies a fuzzy search.</li>
	 *            <li>Database.FT_STEMS uses stem words as the basis of the
	 *            search.</li>
	 *            </ul>
	 * @param start
	 *            The starting page to return
	 * @param count
	 *            The number of pages to return
	 * @param entryForm
	 *            The name of the search form in the domain catalog, for
	 *            example, "Domain Search."
	 * @return A document that contains the results of the full-text query
	 * @throws NotesApiException
	 * @usage The current Database object must represent a Domain Catalog.<br>
	 * 
	 *        If you don't specify any sort options, you get the documents
	 *        sorted by relevance score. If you ask for a sort by date, you
	 *        don't get relevance scores.<br>
	 * 
	 *        <b>Query syntax</b><br>
	 *        To search for a word or phrase, enter the word or phrase as is,
	 *        except that search keywords must be enclosed in quotes. Remember
	 *        to escape quotes if you are inside a literal.<br>
	 * 
	 *        Wildcards, operators, and other syntax are permitted. For the
	 *        complete syntax rules, see
	 *        "Refining a search query using operators" in Lotus Notes Help.
	 *        Search for "query syntax" in the Domino Designer Eclipse help
	 *        system or information center (for example,
	 *        http://publib.boulder.ibm.com/infocenter/domhelp/v8r0/index.jsp),
	 *        both of which include Lotus Notes
	 */
	public abstract NotesDocument FTDomainSearch(String query, int max,
			int sortOpt, int otherOpt, int start, int count, String entryForm)
			throws NotesApiException;

	/**
	 * @param outlineName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesOutline getOutline(String outlineName)
			throws NotesApiException;

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
	public abstract NotesOutline createOutline(String name)
			throws NotesApiException;

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
	public abstract NotesOutline createOutline(String name,
			boolean defaultOutline) throws NotesApiException;

	/**
	 * Ensures that a folder exists, creating it if necessary
	 * 
	 * @param folder
	 *            The name of the folder
	 * @throws NotesApiException
	 * @usage If the folder exists, this method does nothing. If the folder does
	 *        not exist, this method creates it
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
	public abstract Vector queryAccessRoles(String name)
			throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with
	 *        "@DocNumber" as its value. The template view must be accessible to
	 *        the program, so can be a public view or a private view owned by
	 *        the effective id running the agent, but can not be a private view
	 *        stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying
	 *          them from another view
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
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot;
	 * 					+ col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot;
	 * 					+ col2.getTitle());
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
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with
	 *        "@DocNumber" as its value. The template view must be accessible to
	 *        the program, so can be a public view or a private view owned by
	 *        the effective id running the agent, but can not be a private view
	 *        stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying
	 *          them from another view
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
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot;
	 * 					+ col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot;
	 * 					+ col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView(String viewName)
			throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view
	 * @param viewSelectionFormula
	 *            A selection formula. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            selection formula of the template view</li>
	 *            <li>"SELECT @All" if no template view exists</li>
	 *            </ul>
	 *            If specified, this formula overrides the selection formula of
	 *            the template view
	 * 
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with
	 *        "@DocNumber" as its value. The template view must be accessible to
	 *        the program, so can be a public view or a private view owned by
	 *        the effective id running the agent, but can not be a private view
	 *        stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying
	 *          them from another view
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
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot;
	 * 					+ col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot;
	 * 					+ col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView(String viewName,
			String viewSelectionFormula) throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view
	 * @param viewSelectionFormula
	 *            A selection formula. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            selection formula of the template view</li>
	 *            <li>"SELECT @All" if no template view exists</li>
	 *            </ul>
	 *            If specified, this formula overrides the selection formula of
	 *            the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults
	 *            to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in
	 *            the database</li>
	 *            <li>
	 *            none if no view in the database is specified as the default
	 *            design</li>
	 *            </ul>
	 *            <b>Note</b> The template view can not be of type Shared,
	 *            desktop private on first use
	 * 
	 * @return The new view
	 * @throws NotesApiException
	 * @usage If no template view exists, the new view contains one column with
	 *        "@DocNumber" as its value. The template view must be accessible to
	 *        the program, so can be a public view or a private view owned by
	 *        the effective id running the agent, but can not be a private view
	 *        stored in the desktop
	 * @example This agent creates a new view and adds two columns by copying
	 *          them from another view
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
	 * 			System.out.println(&quot;Column &quot; + col1.getPosition() + &quot; = &quot;
	 * 					+ col1.getTitle());
	 * 			ViewColumn col2 = viewTopics.copyColumn(viewAll.getColumn(1), 2);
	 * 			System.out.println(&quot;Column &quot; + col2.getPosition() + &quot; = &quot;
	 * 					+ col2.getTitle());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesView createView(String viewName,
			String viewSelectionFormula, NotesView templateView)
			throws NotesApiException;

	/**
	 * Creates a view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view
	 * @param viewSelectionFormula
	 *            A selection formula. Defaults to either:
	 *            <ul>
	 *            <li>
	 *            selection formula of the template view</li>
	 *            <li>"SELECT @All" if no template view exists</li>
	 *            </ul>
	 *            If specified, this formula overrides the selection formula of
	 *            the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults
	 *            to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in
	 *            the database</li>
	 *            <li>
	 *            none if no view in the database is specified as the default
	 *            design</li>
	 *            </ul>
	 *            <b>Note</b> The template view can not be of type Shared,
	 *            desktop private on first use
	 * @param prohibitDesignRefreshModifications
	 *            <ul>
	 *            <li>true (default) to prohibit the view design from being
	 *            refreshed</li>
	 *            <li>false to allow the view design to be refreshed</li>
	 *            </ul>
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView createView(String viewName,
			String viewSelectionFormula, NotesView templateView,
			boolean prohibitDesignRefreshModifications)
			throws NotesApiException;

	/**
	 * Runs the Fixup task on a database
	 * 
	 * @throws NotesApiException
	 * @example This agent runs the Fixup task on all the databases in the local
	 *          directory
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
	 * 			int options = Database.FIXUP_QUICK + Database.FIXUP_INCREMENTAL
	 * 					+ Database.FIXUP_NOVIEWS;
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
	 *            <li>Database.FIXUP_INCREMENTAL (4) checks only documents since
	 *            last Fixup</li>
	 *            <li>Database.FIXUP_NODELETE (16) prevents Fixup from deleting
	 *            corrupted documents</li>
	 *            <li>Database.FIXUP_NOVIEWS (64) does not check views</li>
	 *            <li>Database.FIXUP_QUICK (2) checks documents more quickly but
	 *            less thoroughly</li>
	 *            <li>Database.FIXUP_REVERT (32) reverts ID tables to the
	 *            previous release format</li>
	 *            <li>Database.FIXUP_TXLOGGED (8) includes databases enabled for
	 *            transaction logging</li>
	 *            <li>Database.FIXUP_VERIFY (1) makes no modifications</li>
	 *            </ul>
	 * 
	 * @throws NotesApiException
	 * @example This agent runs the Fixup task on all the databases in the local
	 *          directory
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
	 * 			int options = Database.FIXUP_QUICK + Database.FIXUP_INCREMENTAL
	 * 					+ Database.FIXUP_NOVIEWS;
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
	public abstract void setInService(boolean inService)
			throws NotesApiException;

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
	public abstract void setDocumentLockingEnabled(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDesignLockingEnabled() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setDesignLockingEnabled(boolean flag)
			throws NotesApiException;

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
	public abstract void sign(int documentType, boolean existingSigsOnly)
			throws NotesApiException;

	/**
	 * @param documentType
	 * @param existingSigsOnly
	 * @param nameStr
	 * @throws NotesApiException
	 */
	public abstract void sign(int documentType, boolean existingSigsOnly,
			String nameStr) throws NotesApiException;

	/**
	 * @param documentType
	 * @param existingSigsOnly
	 * @param nameStr
	 * @param nameStrIsNoteid
	 * @throws NotesApiException
	 */
	public abstract void sign(int documentType, boolean existingSigsOnly,
			String nameStr, boolean nameStrIsNoteid) throws NotesApiException;

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
	public abstract boolean isCurrentAccessPublicReader()
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isCurrentAccessPublicWriter()
			throws NotesApiException;

	/**
	 * @param optionName
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setOption(int optionName, boolean flag)
			throws NotesApiException;

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
	public abstract void setLimitRevisions(double revisions)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double getLimitUpdatedBy() throws NotesApiException;

	/**
	 * @param updateBy
	 * @throws NotesApiException
	 */
	public abstract void setLimitUpdatedBy(double updateBy)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean getListInDbCatalog() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setListInDbCatalog(boolean flag)
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getUndeleteExpireTime() throws NotesApiException;

	/**
	 * @param hours
	 * @throws NotesApiException
	 */
	public abstract void setUndeleteExpireTime(int hours)
			throws NotesApiException;

	/**
	 * @param since
	 * @param noteClass
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getModifiedDocuments(
			NotesDateTime since, int noteClass) throws NotesApiException;

	/**
	 * @param since
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getModifiedDocuments(
			NotesDateTime since) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getModifiedDocuments()
			throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDB2() throws NotesApiException;

	/**
	 * Gets the DB2® Schema of the current database
	 * 
	 * @return The DB2 schema of the current database. The empty string ("") is
	 *         returned if the database is a non-DB2 database
	 * @throws NotesApiException
	 */
	public abstract String getDB2Schema() throws NotesApiException;

	/**
	 * Creates a document collection of all unread documents in the database
	 * 
	 * @param userID
	 *            Optional. If present, the method returns unread documents on
	 *            behalf of the given name. If omitted, the method returns
	 *            unread documents on behalf of the current user ID
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are
	 *        considered read, and this method returns an empty collection.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the
	 *          database have not yet been read
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
	public abstract NotesDocumentCollection getAllUnreadDocuments(String userID)
			throws NotesApiException;

	/**
	 * Creates a document collection of all read documents in the database
	 * 
	 * @param userID
	 *            Optional. If present, the method returns read documents on
	 *            behalf of the given name. If omitted, the method returns read
	 *            documents on behalf of the current user ID
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are
	 *        considered read.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the
	 *          database have been read.
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
	public abstract NotesDocumentCollection getAllReadDocuments(String userID)
			throws NotesApiException;

	/**
	 * Creates a document collection of all unread documents in the database
	 * 
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are
	 *        considered read, and this method returns an empty collection.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the
	 *          database have not yet been read
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
	public abstract NotesDocumentCollection getAllUnreadDocuments()
			throws NotesApiException;

	/**
	 * Creates a document collection of all read documents in the database
	 * 
	 * @return The new document collection
	 * @throws NotesApiException
	 * @usage If the database does not track unread marks, all documents are
	 *        considered read.
	 * 
	 *        For more information, see the DocumentCollection class
	 * @example This agent prints a message saying how many documents in the
	 *          database have been read.
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
	public abstract NotesDocumentCollection getAllReadDocuments()
			throws NotesApiException;

	/**
	 * Creates a document collection in a database and returns a
	 * NotesDocumentCollection object that represents the new collection
	 * 
	 * @return The new document collection.
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link NotesDocument#save()} if you want the new
	 *        document to be saved.
	 * @example The following button creates a document collection, adds
	 *          documents conditionally, then removes those documents.
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
	public abstract NotesDocumentCollection createDocumentCollection()
			throws NotesApiException;

	/**
	 * Creates a query view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view.
	 * @param formula
	 *            An SQL query selection formula. This formula overrides the
	 *            selection formula of the template view
	 * @return The new query view.
	 * @throws NotesApiException
	 * @usage The template view must be accessible to the program, so can be a
	 *        public view or a private view owned by the effective ID running
	 *        the agent, but cannot be a private view stored in the desktop
	 */
	public abstract NotesView createQueryView(String viewName, String formula)
			throws NotesApiException;

	/**
	 * Creates a query view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view.
	 * @param formula
	 *            An SQL query selection formula. This formula overrides the
	 *            selection formula of the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults
	 *            to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in
	 *            the database</li>
	 *            <li>none if no view in the database is specified as the
	 *            default design</li>
	 *            </ul>
	 *            <b>Note:</b> The template view cannot be of type
	 *            "Shared, desktop private on first use."
	 * @return The new query view.
	 * @throws NotesApiException
	 * @usage The template view must be accessible to the program, so can be a
	 *        public view or a private view owned by the effective ID running
	 *        the agent, but cannot be a private view stored in the desktop
	 */
	public abstract NotesView createQueryView(String viewName, String formula,
			NotesView templateView) throws NotesApiException;

	/**
	 * Creates a query view
	 * 
	 * @param viewName
	 *            A name for the view. Defaults to the "(untitled)" view. The
	 *            view is created even if this name duplicates an existing view.
	 * @param formula
	 *            An SQL query selection formula. This formula overrides the
	 *            selection formula of the template view
	 * @param templateView
	 *            An existing view from which the new view is copied. Defaults
	 *            to either:
	 *            <ul>
	 *            <li>
	 *            view checked as "Default design for new folders and views" in
	 *            the database</li>
	 *            <li>none if no view in the database is specified as the
	 *            default design</li>
	 *            </ul>
	 *            <b>Note:</b> The template view cannot be of type
	 *            "Shared, desktop private on first use."
	 * @param prohibitDesignRefreshModifications
	 *            <ul>
	 *            <li>true (default) to prohibit the view design from being
	 *            refreshed</li>
	 *            <li>false to allow the view design to be refreshed</li>
	 *            </ul>
	 * @return The new query view.
	 * @throws NotesApiException
	 * @usage The template view must be accessible to the program, so can be a
	 *        public view or a private view owned by the effective ID running
	 *        the agent, but cannot be a private view stored in the desktop
	 */
	public abstract NotesView createQueryView(String viewName, String formula,
			NotesView templateView, boolean prohibitDesignRefreshModifications)
			throws NotesApiException;

}
