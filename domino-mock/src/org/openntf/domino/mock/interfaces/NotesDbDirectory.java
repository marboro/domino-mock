package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents the Domino databases on a server or the local computer
 * 
 * @author Sven Dreher
 * @access You create a new DbDirectory object with
 *         {@link NotesSession#getDbDirectory(String)} in Session
 * @example This agent prints the file name and title of every database in the
 *          local directory
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
 * 			DbDirectory dir = session.getDbDirectory(null);
 * 			String server = dir.getName();
 * 			if (server.equals(&quot;&quot;))
 * 				server = &quot;Local&quot;;
 * 			System.out.println(&quot;Database directory list on server &quot; + server
 * 					+ &quot;\n&quot;);
 * 			Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
 * 			while (db != null) {
 * 				String fn = db.getFileName();
 * 				String title = db.getTitle();
 * 				System.out.println(fn.toUpperCase() + &quot; - &quot; + title);
 * 				db = dir.getNextDatabase();
 * 			}
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 */
public interface NotesDbDirectory extends NotesBase {
	/**
	 * {@value}
	 */
	static final int REPLICA_CANDIDATE = 1245;
	/**
	 * {@value}
	 */
	static final int TEMPLATE_CANDIDATE = 1246;
	/**
	 * {@value}
	 */
	static final int DATABASE = 1247;
	/**
	 * {@value}
	 */
	static final int TEMPLATE = 1248;

	/**
	 * Creates a new database, using the server and file name that you specify.
	 * Because the new database is not based on a template, it is blank and does
	 * not contain any forms or views
	 * 
	 * @param dbFile
	 *            The file name of the new database
	 * @return The newly created Database
	 * @throws NotesApiException
	 * @usage If you do not open the database, only a subset of its methods are
	 *        available. See isOpen in Database.
	 * 
	 *        Because the new database is not based on a template, it's blank
	 *        and does not contain any forms or views
	 * @example This agent creates a local database named newdb.nsf unless a
	 *          database by that name already exists.
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			boolean found = false;
	 * 			Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				String fn = db.getFileName();
	 * 				if (fn.equalsIgnoreCase(&quot;newdb.nsf&quot;))
	 * 					found = true;
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 			if (!found) {
	 * 				System.out.println(&quot;Not found, creating newdb.nsf&quot;);
	 * 				dir.createDatabase(&quot;newdb.nsf&quot;);
	 * 			} else
	 * 				System.out.println(&quot;found, not creating newdb.nsf&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase createDatabase(String dbFile) throws NotesApiException;

	/**
	 * Creates a new database, using the server and file name that you specify.
	 * Because the new database is not based on a template, it is blank and does
	 * not contain any forms or views
	 * 
	 * @param dbFile
	 *            The file name of the new database
	 * @param open
	 *            Indicates whether you want to open the database. Specify true
	 *            if you want to open the database and false if you do not
	 * @return The newly created Database
	 * @throws NotesApiException
	 * @usage If you do not open the database, only a subset of its methods are
	 *        available. See isOpen in Database.
	 * 
	 *        Because the new database is not based on a template, it's blank
	 *        and does not contain any forms or views
	 * @example This agent creates a local database named newdb.nsf unless a
	 *          database by that name already exists.
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			boolean found = false;
	 * 			Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				String fn = db.getFileName();
	 * 				if (fn.equalsIgnoreCase(&quot;newdb.nsf&quot;))
	 * 					found = true;
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 			if (!found) {
	 * 				System.out.println(&quot;Not found, creating newdb.nsf&quot;);
	 * 				dir.createDatabase(&quot;newdb.nsf&quot;);
	 * 			} else
	 * 				System.out.println(&quot;found, not creating newdb.nsf&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase createDatabase(String dbFile, boolean open)
			throws NotesApiException;

	/**
	 * Returns the first database from a server or the local directory, using
	 * the file type you specify
	 * 
	 * @param type
	 *            Indicates the kind of database file you want to retrieve:
	 *            <ul>
	 *            <li>DbDirectory.DATABASE means any database (NSF, NSG, or NSH
	 *            file).</li>
	 *            <li>DbDirectory.TEMPLATE means any template (NTF file).</li>
	 *            <li>DbDirectory.REPLICA_CANDIDATE means any database or
	 *            template not disabled for replication.</li>
	 *            <li>DbDirectory.TEMPLATE_CANDIDATE means any database or
	 *            template</li>
	 *            </ul>
	 * @return The first database of the specified file type located in the
	 *         directory, or null if the directory contains no databases of the
	 *         specified type
	 * @throws NotesApiException
	 * @usage The returned database is closed. If you do not open the database,
	 *        only a subset of its methods are available. See isOpen in
	 *        Database.
	 * 
	 *        Each time you call this method, the database directory is reset
	 *        and a new search is conducted. If you are searching for template
	 *        files, for example, a new call to getFirstDatabase with the
	 *        parameter DATABASE starts searching the directory from the
	 *        beginning, this time for database files
	 * @example This agent prints the last modified date for each template in
	 *          the local directory
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			System.out.println(&quot;Local templates\n&quot;);
	 * 			Database db = dir.getFirstDatabase(DbDirectory.TEMPLATE);
	 * 			while (db != null) {
	 * 				System.out.println(db.getTemplateName());
	 * 				db.open();
	 * 				System.out.println(&quot;Last modified: &quot;
	 * 						+ db.getLastModified().getLocalTime());
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase getFirstDatabase(int type) throws NotesApiException;

	/**
	 * Returns the next database from a server or the local directory, using the
	 * file type specified in the preceding getFirstDatabase method
	 * 
	 * @return The next database located in the directory, or null if there are
	 *         no more
	 * @throws NotesApiException
	 * @usage The returned database is closed. If you do not open the database,
	 *        only a subset of its methods are available. See isOpen in
	 *        Database.
	 * 
	 *        This method must be preceded in the code by
	 *        {@link #getFirstDatabase(int)}.
	 * 
	 * @example This agent prints the last modified date for each template in
	 *          the local directory
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			System.out.println(&quot;Local templates\n&quot;);
	 * 			Database db = dir.getFirstDatabase(DbDirectory.TEMPLATE);
	 * 			while (db != null) {
	 * 				System.out.println(db.getTemplateName());
	 * 				db.open();
	 * 				System.out.println(&quot;Last modified: &quot;
	 * 						+ db.getLastModified().getLocalTime());
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase getNextDatabase() throws NotesApiException;

	/**
	 * The name of the server whose database directory you are searching
	 * 
	 * @return The name of the server whose database directory you are searching
	 * @throws NotesApiException
	 * @usage This property returns an empty string for DbDirectory objects that
	 *        represent the local directory
	 * @example This agent prints the file name and title of every template
	 *          (.nsf file) on the server specified in the agent comment
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
	 * 			DbDirectory dir = session.getDbDirectory(agent.getComment());
	 * 			String server = dir.getName();
	 * 			if (server.equals(&quot;&quot;))
	 * 				server = &quot;Local&quot;;
	 * 			System.out.println(&quot;Templates on &quot; + server + &quot;\n&quot;);
	 * 			Database db = dir.getFirstDatabase(DbDirectory.TEMPLATE);
	 * 			while (db != null) {
	 * 				System.out.println(db.getTemplateName());
	 * 				db.open();
	 * 				System.out.println(&quot;Last modified: &quot;
	 * 						+ db.getLastModified().getLocalTime());
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getName() throws NotesApiException;

	/**
	 * The Domino session that contains a DbDirectory object
	 * 
	 * @return The Domino session that contains a DbDirectory object
	 * @throws NotesApiException
	 */
	NotesSession getParent() throws NotesApiException;

	/**
	 * Opens a database
	 * 
	 * @param dbFile
	 *            The file name of the database to open
	 * @return The opened database, or null if the database is not opened
	 * @throws NotesApiException
	 * @example This agent opens names.nsf in the local directory and prints its
	 *          title
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			Database db = dir.openDatabase(&quot;names&quot;);
	 * 			System.out.println(db.getTitle());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase openDatabase(String dbFile) throws NotesApiException;

	/**
	 * Opens a database
	 * 
	 * @param dbFile
	 *            The file name of the database to open
	 * @param failover
	 *            If true and the database cannot be opened on the current
	 *            server, an attempt is made to open it on another server in the
	 *            cluster (if there is a cluster). The object Server and
	 *            FilePath properties reflect the server on which the database
	 *            is opened. For remote (IIOP) access, failover is always false
	 * @return The opened database, or null if the database is not opened
	 * @throws NotesApiException
	 * @example This agent opens names.nsf in the local directory and prints its
	 *          title
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			Database db = dir.openDatabase(&quot;names&quot;);
	 * 			System.out.println(db.getTitle());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase openDatabase(String dbFile, boolean failover)
			throws NotesApiException;

	/**
	 * Opens a database if it has been modified since a specified date
	 * 
	 * @param dbFile
	 *            The file name of the database
	 * @param date
	 *            A cutoff date. If one or more documents in the database were
	 *            modified since this date, the database is opened; if not, it
	 *            is not opened. Cannot be null
	 * @return The opened database, or null if the database is not opened
	 * @throws NotesApiException
	 * @example This agent opens name.nsf in the local directory if the database
	 *          was modified in the past three hours
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			DateTime dt = session.createDateTime(&quot;Today&quot;);
	 * 			dt.setNow();
	 * 			dt.adjustHour(-3);
	 * 			Database db = dir.openDatabaseIfModified(&quot;names&quot;, dt);
	 * 			if (db != null)
	 * 				System.out.println(&quot;Database opened&quot;);
	 * 			else
	 * 				System.out.println(&quot;Database not modified in past 3 hours&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase openDatabaseIfModified(String dbFile, NotesDateTime date)
			throws NotesApiException;

	/**
	 * Opens the current user's mail database
	 * 
	 * @return The opened database, or null if the database is not opened
	 * @throws NotesApiException
	 * @usage If the program runs on a workstation, openMailDatabase finds the
	 *        current user's mail server and database in the notes.ini file.
	 * 
	 *        If the program runs on a server, the current user is considered to
	 *        be the last person who modified the agent (the agent's owner), and
	 *        openMailDatabase finds the user's mail server and database in the
	 *        Domino Directory on the server.
	 * 
	 *        If the program is making remote (IIOP) calls to a server, the
	 *        current user is the user who created the session, and
	 *        openMailDatabase finds the user's mail server and database in the
	 *        Domino Directory on the server
	 * @example This agent opens the current user's mail database and prints its
	 *          title, size, and number of documents
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			Database db = dir.openMailDatabase();
	 * 			DocumentCollection dc = db.getAllDocuments();
	 * 			System.out.println(&quot;Mail database : &quot; + db.getTitle() + &quot; is &quot;
	 * 					+ ((int) (db.getSize() / 1024)) + &quot;KB long and has &quot;
	 * 					+ dc.getCount() + &quot; documents&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase openMailDatabase() throws NotesApiException;

	/**
	 * Opens the database with a specified replica ID
	 * 
	 * @param rID
	 *            The replica ID of the database that you want to open
	 * @return The opened database, or null if the database is not opened
	 * @throws NotesApiException
	 * @example This agent attempts to open the help database, which is known to
	 *          have the specified replica ID
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
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			String rid = &quot;852565D2000B5144&quot;;
	 * 			Database db = dir.openDatabaseByReplicaID(rid);
	 * 			if (db != null)
	 * 				System.out.println(&quot;help located and opened&quot;);
	 * 			else
	 * 				System.out.println(&quot;help not found&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase openDatabaseByReplicaID(String rID) throws NotesApiException;

	/**
	 * Returns the name of the cluster containing a database directory
	 * 
	 * @return The name of the cluster
	 * @throws NotesApiException
	 * @example This computed field displays the cluster name for a database
	 *          directory set elsewhere on the page
	 * 
	 *          <pre>
	 * if (sessionScope.dbdir != null) {
	 * 	var dbdir:NotesDbDirectory = sessionScope.dbdir;
	 * 	var cluster:string = dbdir.getClusterName("Sales/Acme"); // specifies a server
	 * //	var cluster:string = dbdir.getClusterName(); // uses the current server
	 * 	if (cluster.isEmpty()) {
	 * 		cluster = "No cluster";
	 * 	}
	 * 	return "Cluster name: " + cluster;
	 * }
	 * </pre>
	 */
	String getClusterName() throws NotesApiException;

	/**
	 * Returns the name of the cluster containing a database directory
	 * 
	 * @param serverName
	 *            The full hierarchical name (can be abbreviated) of the server.
	 *            Defaults to the current server
	 * @return The name of the cluster
	 * @throws NotesApiException
	 * @example This computed field displays the cluster name for a database
	 *          directory set elsewhere on the page
	 * 
	 *          <pre>
	 * if (sessionScope.dbdir != null) {
	 * 	var dbdir:NotesDbDirectory = sessionScope.dbdir;
	 * 	var cluster:string = dbdir.getClusterName("Sales/Acme"); // specifies a server
	 * //	var cluster:string = dbdir.getClusterName(); // uses the current server
	 * 	if (cluster.isEmpty()) {
	 * 		cluster = "No cluster";
	 * 	}
	 * 	return "Cluster name: " + cluster;
	 * }
	 * </pre>
	 */
	String getClusterName(String serverName) throws NotesApiException;
}
