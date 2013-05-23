package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a single entry in an access control list. An entry may be for a
 * person, a group, or a server.
 * 
 * @author Sven Dreher
 * @see lotus.domino.ACLEntry
 * 
 * @access To create a new ACLEntry object, use
 *         {@link NotesACL#createACLEntry(String, int)} in ACL.
 * 
 *         The ACL class provides three ways to access an existing ACLEntry:
 * 
 *         <ul>
 *         <li>To access an entry in an ACL when you know its name, use
 *         getEntry.</li>
 *         <li>To access the first entry in the ACL, use getFirstEntry.</li>
 *         <li>To access entries after the first one, use getNextEntry.</li>
 *         </ul>
 * 
 *         After modifying an ACL entry, you must call the save method on the
 *         ACL if you want the modified ACL to be saved to disk.
 * 
 */
public interface NotesACLEntry extends NotesBase {
	/**
	 * {@value}
	 */
	static final int TYPE_UNSPECIFIED = 0;
	/**
	 * {@value}
	 */
	static final int TYPE_PERSON = 1;
	/**
	 * {@value}
	 */
	static final int TYPE_SERVER = 2;
	/**
	 * {@value}
	 */
	static final int TYPE_MIXED_GROUP = 3;
	/**
	 * {@value}
	 */
	static final int TYPE_PERSON_GROUP = 4;
	/**
	 * {@value}
	 */
	static final int TYPE_SERVER_GROUP = 5;

	/**
	 * Disables a role for an entry.
	 * 
	 * @param name
	 *            The name of the role to disable. Do not specify the brackets.
	 * @throws NotesApiException
	 */
	void enableRole(String name) throws NotesApiException;

	/**
	 * Enables a role for an entry.
	 * 
	 * @param name
	 *            The name of the role to enable. Do not specify the brackets.
	 * @throws NotesApiException
	 */
	void disableRole(String name) throws NotesApiException;

	/**
	 * Indicates whether a role is enabled for an entry.
	 * 
	 * @param name
	 *            The name of the role.
	 * @return Indicates whether a role is enabled for an entry.
	 *         <ul>
	 *         <li>true if the role is enabled for this entry</li>
	 *         <li>false if the role is not enabled for this entry</li>
	 *         </ul>
	 * @throws NotesApiException
	 * 
	 * @usage The role must exist in the ACL.
	 * 
	 * @example This agent prints a message for each ACL entry that states
	 *          whether the role specified as the agent comment is enabled.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			do {
	 * 				if (entry.isRoleEnabled(agent.getComment()))
	 * 					System.out.println(agent.getComment() + &quot; is enabled for &quot;
	 * 							+ entry.getName());
	 * 				else {
	 * 					System.out.println(agent.getComment() + &quot; is disabled for &quot;
	 * 							+ entry.getName());
	 * 				}
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isRoleEnabled(String name) throws NotesApiException;

	/**
	 * Removes an entry from an access control list.
	 * 
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link NotesACL#save()} on the ACL if you want the
	 *        modified ACL to be saved to disk.
	 * 
	 * @example This agent removes the ACL entry specified as the agent comment.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null)
	 * 				entry.remove();
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void remove() throws NotesApiException;

	/**
	 * The roles that are enabled for an entry.
	 * 
	 * @return The roles that are enabled for an entry.
	 * @throws NotesApiException
	 * 
	 * @usage Each element in the vector is the name of a role. Each role name
	 *        is surrounded by square brackets, for example, "[Supervisor]."
	 * 
	 *        Notes Release 2 "privileges" are surrounded by parentheses.
	 *        Properties and methods affecting roles, such as disableRole and
	 *        enableRole, do not work on privileges.
	 * @example This agent prints the roles for the ACL entry specified as the
	 *          agent comment.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				Vector roles = acl.getRoles();
	 * 				if (roles.size() == 0)
	 * 					System.out.println(entry.getName() + &quot; has no roles&quot;);
	 * 				else {
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; has the following role(s):&quot;);
	 * 					for (int i = 0; i &lt; roles.size(); i++)
	 * 						System.out.println(&quot;  &quot; + roles.elementAt(i));
	 * 				}
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	Vector<String> getRoles() throws NotesApiException;

	/**
	 * 
	 * The name of an ACL entry.
	 * 
	 * @return The name of an ACL entry.
	 * 
	 * @throws NotesApiException
	 * 
	 * @usage Hierarchical names are returned in canonical format. However, you
	 *        can enter a hierarchical name as a String in abbreviated format.
	 * 
	 *        For setName, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 *        If you change the name of an entry, the other properties of the
	 *        entry (such as Level) are preserved.
	 * 
	 *        The Name object for setName cannot be null.
	 * 
	 * @example This agent prints the name of every ACL entry with Manager
	 *          access.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			System.out.println(&quot;Managers for \&quot;&quot; + db.getTitle() + &quot;\&quot;&quot;);
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			do {
	 * 				if (entry.getLevel() == ACL.LEVEL_MANAGER)
	 * 					System.out.println(&quot;    &quot; + entry.getName());
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getName() throws NotesApiException;

	/**
	 * The name of an ACL entry.
	 * 
	 * @param name
	 *            The name of an ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage Hierarchical names are returned in canonical format. However, you
	 *        can enter a hierarchical name as a String in abbreviated format.
	 * 
	 *        For setName, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 *        If you change the name of an entry, the other properties of the
	 *        entry (such as Level) are preserved.
	 * 
	 *        The Name object for setName cannot be null.
	 * 
	 * @example This agent prints the name of every ACL entry with Manager
	 *          access.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			System.out.println(&quot;Managers for \&quot;&quot; + db.getTitle() + &quot;\&quot;&quot;);
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			do {
	 * 				if (entry.getLevel() == ACL.LEVEL_MANAGER)
	 * 					System.out.println(&quot;    &quot; + entry.getName());
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setName(String name) throws NotesApiException;

	/**
	 * The name of an entry.
	 * 
	 * @return The name of an entry.
	 * @throws NotesApiException
	 * 
	 * @example This agent prints the name of every ACL entry with Manager
	 *          access.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			System.out.println(&quot;Managers for \&quot;&quot; + db.getTitle() + &quot;\&quot;&quot;);
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			Name n;
	 * 			do {
	 * 				if (entry.getLevel() == ACL.LEVEL_MANAGER) {
	 * 					n = entry.getNameObject();
	 * 					System.out.println(&quot;    &quot; + n.getCommon());
	 * 				}
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesName getNameObject() throws NotesApiException;

	/**
	 * The name of an ACL entry.
	 * 
	 * @param name
	 *            The name of an ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage Hierarchical names are returned in canonical format. However, you
	 *        can enter a hierarchical name as a String in abbreviated format.
	 * 
	 *        For setName, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 *        If you change the name of an entry, the other properties of the
	 *        entry (such as Level) are preserved.
	 * 
	 *        The Name object for setName cannot be null.
	 * 
	 * @example This agent prints the name of every ACL entry with Manager
	 *          access.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			System.out.println(&quot;Managers for \&quot;&quot; + db.getTitle() + &quot;\&quot;&quot;);
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			do {
	 * 				if (entry.getLevel() == ACL.LEVEL_MANAGER)
	 * 					System.out.println(&quot;    &quot; + entry.getName());
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setName(NotesName name) throws NotesApiException;

	/**
	 * The access level this entry has for this database
	 * 
	 * @return The access level this entry has for this database
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>ACL.LEVEL_NOACCESS</li>
	 *              <li>ACL.LEVEL_DEPOSITOR</li>
	 *              <li>ACL.LEVEL_READER</li>
	 *              <li>ACL.LEVEL_AUTHOR</li>
	 *              <li>ACL.LEVEL_EDITOR</li>
	 *              <li>ACL.LEVEL_DESIGNER</li>
	 *              <li>ACL.LEVEL_MANAGER</li>
	 *              </ul>
	 * 
	 * @usage For setLevel, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the access level for each entry in the ACL of
	 *          the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			String lev = null;
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			do {
	 * 				switch (entry.getLevel()) {
	 * 				case ACL.LEVEL_NOACCESS:
	 * 					lev = &quot;no&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_DEPOSITOR:
	 * 					lev = &quot;depositor&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_READER:
	 * 					lev = &quot;reader&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_AUTHOR:
	 * 					lev = &quot;author&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_EDITOR:
	 * 					lev = &quot;editor&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_DESIGNER:
	 * 					lev = &quot;designer&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_MANAGER:
	 * 					lev = &quot;manager&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(entry.getName() + &quot; has &quot; + lev + &quot; access&quot;);
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int getLevel() throws NotesApiException;

	/**
	 * The access level this entry has for this database
	 * 
	 * @param level
	 *            The access level this entry has for this database
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>ACL.LEVEL_NOACCESS</li>
	 *              <li>ACL.LEVEL_DEPOSITOR</li>
	 *              <li>ACL.LEVEL_READER</li>
	 *              <li>ACL.LEVEL_AUTHOR</li>
	 *              <li>ACL.LEVEL_EDITOR</li>
	 *              <li>ACL.LEVEL_DESIGNER</li>
	 *              <li>ACL.LEVEL_MANAGER</li>
	 *              </ul>
	 * 
	 * @usage For setLevel, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the access level for each entry in the ACL of
	 *          the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			String lev = null;
	 * 			ACLEntry entry = acl.getFirstEntry();
	 * 			do {
	 * 				switch (entry.getLevel()) {
	 * 				case ACL.LEVEL_NOACCESS:
	 * 					lev = &quot;no&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_DEPOSITOR:
	 * 					lev = &quot;depositor&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_READER:
	 * 					lev = &quot;reader&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_AUTHOR:
	 * 					lev = &quot;author&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_EDITOR:
	 * 					lev = &quot;editor&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_DESIGNER:
	 * 					lev = &quot;designer&quot;;
	 * 					break;
	 * 				case ACL.LEVEL_MANAGER:
	 * 					lev = &quot;manager&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(entry.getName() + &quot; has &quot; + lev + &quot; access&quot;);
	 * 			} while ((entry = acl.getNextEntry(entry)) != null);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setLevel(int level) throws NotesApiException;

	/**
	 * The user type this entry has for this database.
	 * 
	 * @return The user type this entry has for this database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>ACLEntry.TYPE_MIXED_GROUP</li>
	 *              <li>ACLEntry.TYPE_PERSON</li>
	 *              <li>ACLEntry.TYPE_PERSON_GROUP</li>
	 *              <li>ACLEntry.TYPE_SERVER</li>
	 *              <li>ACLEntry.TYPE_SERVER_GROUP</li>
	 *              <li>ACLEntry.TYPE_UNSPECIFIED</li>
	 *              </ul>
	 * 
	 * @usage For setUserType, you must call {@link NotesACL#save()} on the ACL
	 *        if you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int getUserType() throws NotesApiException;

	/**
	 * * The user type this entry has for this database.
	 * 
	 * @param userType
	 *            The user type this entry has for this database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>ACLEntry.TYPE_MIXED_GROUP</li>
	 *              <li>ACLEntry.TYPE_PERSON</li>
	 *              <li>ACLEntry.TYPE_PERSON_GROUP</li>
	 *              <li>ACLEntry.TYPE_SERVER</li>
	 *              <li>ACLEntry.TYPE_SERVER_GROUP</li>
	 *              <li>ACLEntry.TYPE_UNSPECIFIED</li>
	 *              </ul>
	 * 
	 * @usage For setUserType, you must call {@link NotesACL#save()} on the ACL
	 *        if you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setUserType(int userType) throws NotesApiException;

	/**
	 * For an entry with Editor, Author, or Reader access, indicates whether the
	 * entry can create private agents in a database.
	 * 
	 * @return For an entry with Editor, Author, or Reader access, indicates
	 *         whether the entry can create private agents in a database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create private agents in the
	 *              database</li>
	 *              <li>false if the entry cannot create private agents in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Designer, Editor, Author, or Reader access to a
	 *        database. If an entry has Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Designer,
	 *        Editor, Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Author access and allows
	 *          it to create private, LotusScript, and Java agents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalAgent(true);
	 * 			entry.setCanCreateLSOrJavaAgent(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanCreatePersonalAgent() throws NotesApiException;

	/**
	 * For an entry with Editor, Author, or Reader access, indicates whether the
	 * entry can create private agents in a database.
	 * 
	 * 
	 * @param flag
	 *            For an entry with Editor, Author, or Reader access, indicates
	 *            whether the entry can create private agents in a database.
	 * 
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create private agents in the
	 *              database</li>
	 *              <li>false if the entry cannot create private agents in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Designer, Editor, Author, or Reader access to a
	 *        database. If an entry has Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Designer,
	 *        Editor, Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Author access and allows
	 *          it to create private, LotusScript, and Java agents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalAgent(true);
	 * 			entry.setCanCreateLSOrJavaAgent(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanCreatePersonalAgent(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Editor, Author, or Reader access, indicates whether the
	 * entry can create personal folders in a database.
	 * 
	 * @return For an entry with Editor, Author, or Reader access, indicates
	 *         whether the entry can create personal folders in a database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create personal folders in the
	 *              database</li>
	 *              <li>false if the entry cannot create personal folders in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Editor, Author, or Reader access to a database. If an
	 *        entry has Designer or Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Editor,
	 *        Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Editor access and allows
	 *          it to create personal folders.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalFolder(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanCreatePersonalFolder() throws NotesApiException;

	/**
	 * For an entry with Editor, Author, or Reader access, indicates whether the
	 * entry can create personal folders in a database.
	 * 
	 * @param flag
	 *            For an entry with Editor, Author, or Reader access, indicates
	 *            whether the entry can create personal folders in a database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create personal folders in the
	 *              database</li>
	 *              <li>false if the entry cannot create personal folders in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Editor, Author, or Reader access to a database. If an
	 *        entry has Designer or Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Editor,
	 *        Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Editor access and allows
	 *          it to create personal folders.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalFolder(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanCreatePersonalFolder(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Author access to a database, indicates whether the
	 * entry is allowed to create new documents.
	 * 
	 * @return For an entry with Author access to a database, indicates whether
	 *         the entry is allowed to create new documents.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create new documents in the
	 *              database</li>
	 *              <li>false if the entry cannot create new documents in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Author access to a database. If an entry has Depositor,
	 *        Editor, Designer, or Manager access, this property is always true.
	 *        If an entry has Reader or No access, this property is always
	 *        false.
	 * 
	 *        By default, this property is false for a new entry with Author
	 *        access.
	 * 
	 * 
	 * @example This agent creates a new ACL entry with Author access but does
	 *          not allow it to create documents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreateDocuments(false);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanCreateDocuments() throws NotesApiException;

	/**
	 * For an entry with Author access to a database, indicates whether the
	 * entry is allowed to create new documents.
	 * 
	 * @param flag
	 *            For an entry with Author access to a database, indicates
	 *            whether the entry is allowed to create new documents.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create new documents in the
	 *              database</li>
	 *              <li>false if the entry cannot create new documents in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Author access to a database. If an entry has Depositor,
	 *        Editor, Designer, or Manager access, this property is always true.
	 *        If an entry has Reader or No access, this property is always
	 *        false.
	 * 
	 *        By default, this property is false for a new entry with Author
	 *        access.
	 * 
	 * 
	 * @example This agent creates a new ACL entry with Author access but does
	 *          not allow it to create documents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreateDocuments(false);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanCreateDocuments(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Author access or above, indicates whether the entry can
	 * delete documents from a database.
	 * 
	 * @return For an entry with Author access or above, indicates whether the
	 *         entry can delete documents from a database.
	 * 
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can delete documents in the database</li>
	 *              <li>false if the entry cannot delete documents in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Manager, Designer, Editor, or Author access to a
	 *        database. If an entry has Reader, Depositor, or No access, this
	 *        property is always false.
	 * 
	 *        By default, this property is false for a new entry with Manager,
	 *        Designer, Editor, or Author access.
	 * 
	 * @example This agent creates a new ACL entry with Author access but does
	 *          not allow it to delete documents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanDeleteDocuments(false);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanDeleteDocuments() throws NotesApiException;

	/**
	 * For an entry with Author access or above, indicates whether the entry can
	 * delete documents from a database.
	 * 
	 * @param flag
	 *            For an entry with Author access or above, indicates whether
	 *            the entry can delete documents from a database.
	 * 
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can delete documents in the database</li>
	 *              <li>false if the entry cannot delete documents in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Manager, Designer, Editor, or Author access to a
	 *        database. If an entry has Reader, Depositor, or No access, this
	 *        property is always false.
	 * 
	 *        By default, this property is false for a new entry with Manager,
	 *        Designer, Editor, or Author access.
	 * 
	 * @example This agent creates a new ACL entry with Author access but does
	 *          not allow it to delete documents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanDeleteDocuments(false);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanDeleteDocuments(boolean flag) throws NotesApiException;

	/**
	 * The access control list that contains an entry.
	 * 
	 * @return The access control list that contains an entry.
	 * @throws NotesApiException
	 * 
	 * @example This agent prints the title of every database in the local Notes
	 *          directory that contains the ACL entry specified as the agent
	 *          comment.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			ACL acl;
	 * 			ACLEntry entry;
	 * 			String n;
	 * 			DbDirectory dir = session.getDbDirectory(null);
	 * 			Database db = dir.getFirstDatabase(DbDirectory.DATABASE);
	 * 			while (db != null) {
	 * 				db.open();
	 * 				acl = db.getACL();
	 * 				if (acl != null) {
	 * 					entry = acl.getFirstEntry();
	 * 					while (entry != null) {
	 * 						n = entry.getNameObject().getCommon();
	 * 						if (n.equals(agent.getComment()))
	 * 							System.out.println(n + &quot; is in the database \&quot;&quot;
	 * 									+ entry.getParent().getParent().getTitle()
	 * 									+ &quot;\&quot;&quot;);
	 * 						entry = acl.getNextEntry(entry);
	 * 					}
	 * 				}
	 * 				db = dir.getNextDatabase();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesACL getParent() throws NotesApiException;

	/**
	 * For an entry with Depositor or No access, indicates whether the entry is
	 * a reader of the database.
	 * 
	 * @return For an entry with Depositor or No access, indicates whether the
	 *         entry is a reader of the database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the current entry is a reader</li>
	 *              <li>false if the current entry is not a reader</li>
	 *              </ul>
	 * 
	 * @usage Setting this property has no effect on an ACL entry unless the
	 *        entry has Depositor or No access to a database. If an entry has
	 *        Manager, Designer, Editor, Author, or Reader access, this property
	 *        is always true.
	 * 
	 *        By default, this property is false for a new entry with Depositor
	 *        or No access.
	 * 
	 * @example This agent creates a new ACL entry with Depositor access and
	 *          makes it a reader.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_DEPOSITOR);
	 * 			entry.setReader(true);
	 * 			entry.setWriter(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isPublicReader() throws NotesApiException;

	/**
	 * For an entry with Depositor or No access, indicates whether the entry is
	 * a reader of the database.
	 * 
	 * @param flag
	 *            For an entry with Depositor or No access, indicates whether
	 *            the entry is a reader of the database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the current entry is a reader</li>
	 *              <li>false if the current entry is not a reader</li>
	 *              </ul>
	 * 
	 * @usage Setting this property has no effect on an ACL entry unless the
	 *        entry has Depositor or No access to a database. If an entry has
	 *        Manager, Designer, Editor, Author, or Reader access, this property
	 *        is always true.
	 * 
	 *        By default, this property is false for a new entry with Depositor
	 *        or No access.
	 * 
	 * @example This agent creates a new ACL entry with Depositor access and
	 *          makes it a reader.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_DEPOSITOR);
	 * 			entry.setReader(true);
	 * 			entry.setWriter(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setPublicReader(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Author, Reader, Depositor, or No access, indicates
	 * whether the entry is a writer of the database.
	 * 
	 * @return For an entry with Author, Reader, Depositor, or No access,
	 *         indicates whether the entry is a writer of the database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the current entry is a reader</li>
	 *              <li>false if the current entry is not a reader</li>
	 *              </ul>
	 * 
	 * @usage Setting this property has no effect on an ACL entry unless the
	 *        entry has Depositor or No access to a database. If an entry has
	 *        Manager, Designer, Editor, Author, or Reader access, this property
	 *        is always true.
	 * 
	 *        By default, this property is false for a new entry with Depositor
	 *        or No access.
	 * 
	 * @example This agent creates a new ACL entry with Depositor access and
	 *          makes it a reader.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_DEPOSITOR);
	 * 			entry.setReader(true);
	 * 			entry.setWriter(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isPublicWriter() throws NotesApiException;

	/**
	 * For an entry with Author, Reader, Depositor, or No access, indicates
	 * whether the entry is a writer of the database.
	 * 
	 * @param flag
	 *            For an entry with Author, Reader, Depositor, or No access,
	 *            indicates whether the entry is a writer of the database.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the current entry is a reader</li>
	 *              <li>false if the current entry is not a reader</li>
	 *              </ul>
	 * 
	 * @usage Setting this property has no effect on an ACL entry unless the
	 *        entry has Depositor or No access to a database. If an entry has
	 *        Manager, Designer, Editor, Author, or Reader access, this property
	 *        is always true.
	 * 
	 *        By default, this property is false for a new entry with Depositor
	 *        or No access.
	 * 
	 * @example This agent creates a new ACL entry with Depositor access and
	 *          makes it a reader.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_DEPOSITOR);
	 * 			entry.setReader(true);
	 * 			entry.setWriter(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setPublicWriter(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Reader access to a database, indicates whether the
	 * entry is allowed to create LotusScript or Java agents.
	 * 
	 * @return For an entry with Reader access to a database, indicates whether
	 *         the entry is allowed to create LotusScript or Java agents.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create LotusScript or Java agents
	 *              in the database</li>
	 *              <li>false if the entry cannot create new LotusScript or Java
	 *              agents in the database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Designer, Editor, Author, or Reader access to a
	 *        database. If an entry has Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Designer,
	 *        Editor, Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Author access and allows
	 *          it to create private, LotusScript, and Java agents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalAgent(true);
	 * 			entry.setCanCreateLSOrJavaAgent(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanCreateLSOrJavaAgent() throws NotesApiException;

	/**
	 * For an entry with Reader access to a database, indicates whether the
	 * entry is allowed to create LotusScript or Java agents.
	 * 
	 * @param flag
	 *            For an entry with Reader access to a database, indicates
	 *            whether the entry is allowed to create LotusScript or Java
	 *            agents.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create LotusScript or Java agents
	 *              in the database</li>
	 *              <li>false if the entry cannot create new LotusScript or Java
	 *              agents in the database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Designer, Editor, Author, or Reader access to a
	 *        database. If an entry has Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Designer,
	 *        Editor, Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Author access and allows
	 *          it to create private, LotusScript, and Java agents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalAgent(true);
	 * 			entry.setCanCreateLSOrJavaAgent(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanCreateLSOrJavaAgent(boolean flag) throws NotesApiException;

	/**
	 * Indicates whether this is a server ACL entry.
	 * 
	 * @return Indicates whether this is a server ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage IsGroup is true if {@link #getUserType()} is TYPE_MIXED_GROUP,
	 *        TYPE_PERSON_GROUP, or TYPE_SERVER_GROUP.
	 * 
	 *        For setGroup, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isServer() throws NotesApiException;

	/**
	 * Indicates whether this is a server ACL entry.
	 * 
	 * @param flag
	 *            Indicates whether this is a server ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage IsGroup is true if {@link #getUserType()} is TYPE_MIXED_GROUP,
	 *        TYPE_PERSON_GROUP, or TYPE_SERVER_GROUP.
	 * 
	 *        For setGroup, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setServer(boolean flag) throws NotesApiException;

	/**
	 * Indicates whether this is a person ACL entry.
	 * 
	 * @return Indicates whether this is a person ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage IsGroup is true if {@link #getUserType()} is TYPE_MIXED_GROUP,
	 *        TYPE_PERSON_GROUP, or TYPE_SERVER_GROUP.
	 * 
	 *        For setGroup, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isPerson() throws NotesApiException;

	/**
	 * Indicates whether this is a person ACL entry.
	 * 
	 * @param flag
	 *            Indicates whether this is a person ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage IsGroup is true if {@link #getUserType()} is TYPE_MIXED_GROUP,
	 *        TYPE_PERSON_GROUP, or TYPE_SERVER_GROUP.
	 * 
	 *        For setGroup, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setPerson(boolean flag) throws NotesApiException;

	/**
	 * Indicates whether this is a group ACL entry.
	 * 
	 * @return Indicates whether this is a group ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage IsGroup is true if {@link #getUserType()} is TYPE_MIXED_GROUP,
	 *        TYPE_PERSON_GROUP, or TYPE_SERVER_GROUP.
	 * 
	 *        For setGroup, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isGroup() throws NotesApiException;

	/**
	 * Indicates whether this is a group ACL entry.
	 * 
	 * @param flag
	 *            Indicates whether this is a group ACL entry.
	 * @throws NotesApiException
	 * 
	 * @usage IsGroup is true if {@link #getUserType()} is TYPE_MIXED_GROUP,
	 *        TYPE_PERSON_GROUP, or TYPE_SERVER_GROUP.
	 * 
	 *        For setGroup, you must call {@link NotesACL#save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent prints the user type of the ACL entry specified in
	 *          the agent comment, and prints whether the entry is for a person,
	 *          server, or group.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				String ut = null;
	 * 				switch (entry.getUserType()) {
	 * 				case ACLEntry.TYPE_MIXED_GROUP:
	 * 					ut = &quot;mixed group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON:
	 * 					ut = &quot;person&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_PERSON_GROUP:
	 * 					ut = &quot;person group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER:
	 * 					ut = &quot;server&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_SERVER_GROUP:
	 * 					ut = &quot;server group&quot;;
	 * 					break;
	 * 				case ACLEntry.TYPE_UNSPECIFIED:
	 * 					ut = &quot;unspecified&quot;;
	 * 					break;
	 * 				}
	 * 				System.out.println(&quot;User type is &quot; + ut);
	 * 				if (entry.isPerson())
	 * 					System.out.println(&quot;Is a person&quot;);
	 * 				if (entry.isServer())
	 * 					System.out.println(&quot;Is a server&quot;);
	 * 				if (entry.isGroup())
	 * 					System.out.println(&quot;Is a group&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setGroup(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Editor access to a database, indicates whether the
	 * entry can create shared folders in the database.
	 * 
	 * @return For an entry with Editor access to a database, indicates whether
	 *         the entry can create shared folders in the database.
	 * 
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create shared folders in the
	 *              database</li>
	 *              <li>false if the entry cannot create shared folders in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Editor, Author, or Reader access to a database. If an
	 *        entry has Designer or Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Editor,
	 *        Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Editor access and allows
	 *          it to create personal folders.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalFolder(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanCreateSharedFolder() throws NotesApiException;

	/**
	 * For an entry with Editor access to a database, indicates whether the
	 * entry can create shared folders in the database.
	 * 
	 * 
	 * @param flag
	 *            For an entry with Editor access to a database, indicates
	 *            whether the entry can create shared folders in the database.
	 * 
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can create shared folders in the
	 *              database</li>
	 *              <li>false if the entry cannot create shared folders in the
	 *              database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Editor, Author, or Reader access to a database. If an
	 *        entry has Designer or Manager access, this property is always
	 *        true. If an entry has Depositor or No access, this property is
	 *        always false.
	 * 
	 *        By default, this property is false for a new entry with Editor,
	 *        Author, or Reader access.
	 * 
	 * @example This agent creates a new ACL entry with Editor access and allows
	 *          it to create personal folders.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(agent.getComment(),
	 * 					ACL.LEVEL_AUTHOR);
	 * 			entry.setCanCreatePersonalFolder(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanCreateSharedFolder(boolean flag) throws NotesApiException;

	/**
	 * Indicates whether an entry that is an administration server can modify
	 * reader and author fields.
	 * 
	 * @return Indicates whether an entry that is an administration server can
	 *         modify reader and author fields.
	 * @throws NotesApiException
	 * 
	 * @usage If the ACL entry is not an administration server,
	 *        setAdminReaderAuthor(true) does nothing. No exception is thrown
	 *        and the property remains false. Use {@link #isAdminServer()} and
	 *        {@link #setAdminServer(boolean)} to check and change the entry.
	 * 
	 *        For setAdminReaderAuthor, you must call {@link NotesACL#save()} on
	 *        the ACL if you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent sets an ACL entry as an administration server that
	 *          can modify reader and author fields.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(&quot;tornado&quot;, ACL.LEVEL_MANAGER);
	 * 			entry.setAdminServer(true);
	 * 			entry.setAdminReaderAuthor(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isAdminReaderAuthor() throws NotesApiException;

	/**
	 * Indicates whether an entry that is an administration server can modify
	 * reader and author fields.
	 * 
	 * @param flag
	 *            Indicates whether an entry that is an administration server
	 *            can modify reader and author fields.
	 * @throws NotesApiException
	 * 
	 * @usage If the ACL entry is not an administration server,
	 *        setAdminReaderAuthor(true) does nothing. No exception is thrown
	 *        and the property remains false. Use {@link #isAdminServer()} and
	 *        {@link #setAdminServer(boolean)} to check and change the entry.
	 * 
	 *        For setAdminReaderAuthor, you must call {@link NotesACL#save()} on
	 *        the ACL if you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent sets an ACL entry as an administration server that
	 *          can modify reader and author fields.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(&quot;tornado&quot;, ACL.LEVEL_MANAGER);
	 * 			entry.setAdminServer(true);
	 * 			entry.setAdminReaderAuthor(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setAdminReaderAuthor(boolean flag) throws NotesApiException;

	/**
	 * Indicates whether this entry is an administration server.
	 * 
	 * @return Indicates whether this entry is an administration server.
	 * @throws NotesApiException
	 * 
	 * @usage This property has no effect on getUserType, isGroup, isPerson, and
	 *        isServer.
	 * 
	 *        For setAdminServer, you must call {@link NotesACL#save()} on the
	 *        ACL if you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent sets an ACL entry as an administration server that
	 *          can modify reader and author fields.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 *  class JavaAgent extends AgentBase {
	 * 	 void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(&quot;tornado&quot;, ACL.LEVEL_MANAGER);
	 * 			entry.setAdminServer(true);
	 * 			entry.setAdminReaderAuthor(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 */
	boolean isAdminServer() throws NotesApiException;

	/**
	 * Indicates whether this entry is an administration server.
	 * 
	 * @param flag
	 *            Indicates whether this entry is an administration server.
	 * @throws NotesApiException
	 * 
	 * @usage This property has no effect on getUserType, isGroup, isPerson, and
	 *        isServer.
	 * 
	 *        For setAdminServer, you must call {@link NotesACL#save()} on the
	 *        ACL if you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent sets an ACL entry as an administration server that
	 *          can modify reader and author fields.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 *  class JavaAgent extends AgentBase {
	 * 	 void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.createACLEntry(&quot;tornado&quot;, ACL.LEVEL_MANAGER);
	 * 			entry.setAdminServer(true);
	 * 			entry.setAdminReaderAuthor(true);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 */
	void setAdminServer(boolean flag) throws NotesApiException;

	/**
	 * For an entry with Reader access or above to a database, indicates whether
	 * an entry can replicate or copy documents.
	 * 
	 * @return For an entry with Reader access or above to a database, indicates
	 *         whether an entry can replicate or copy documents.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can replicate or copy documents from
	 *              the database</li>
	 *              <li>false if the entry cannot replicate or copy documents
	 *              from the database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Reader access or above to a database. If an entry has
	 *        Depositor or No access, this property is always false.
	 * 
	 * @example This agent creates an entry for Eben Klemm in the current
	 *          database and gives him Author access. It denies him the right to
	 *          replicate or copy documents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 
	 * 	void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry acle = acl.createACLEntry(&quot;Eben Klemm/East/ACME&quot;,
	 * 					ACL.LEVEL_AUTHOR);
	 * 			acle.setCanReplicateOrCopyDocuments(false);
	 * 			acl.save();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isCanReplicateOrCopyDocuments() throws NotesApiException;

	/**
	 * For an entry with Reader access or above to a database, indicates whether
	 * an entry can replicate or copy documents.
	 * 
	 * @param flag
	 *            For an entry with Reader access or above to a database,
	 *            indicates whether an entry can replicate or copy documents.
	 * @throws NotesApiException
	 * 
	 * @legalValues <ul>
	 *              <li>true if the entry can replicate or copy documents from
	 *              the database</li>
	 *              <li>false if the entry cannot replicate or copy documents
	 *              from the database</li>
	 *              </ul>
	 * 
	 * @usage After setting this property, you must call {@link NotesACL#save()}
	 *        on the parent ACL for the changes to take effect.
	 * 
	 *        Setting this property has no effect on an ACL entry unless the
	 *        entry has Reader access or above to a database. If an entry has
	 *        Depositor or No access, this property is always false.
	 * 
	 * @example This agent creates an entry for Eben Klemm in the current
	 *          database and gives him Author access. It denies him the right to
	 *          replicate or copy documents.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 
	 * 	void NotesMain() {
	 * 
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry acle = acl.createACLEntry(&quot;Eben Klemm/East/ACME&quot;,
	 * 					ACL.LEVEL_AUTHOR);
	 * 			acle.setCanReplicateOrCopyDocuments(false);
	 * 			acl.save();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setCanReplicateOrCopyDocuments(boolean flag) throws NotesApiException;

}