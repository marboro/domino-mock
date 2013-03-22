package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


/**
 * Represents the access control list (ACL) of a database.
 * 
 * @author Sven Dreher
 * @see lotus.domino.ACL
 * @example This agent prints the name of each entry in the ACL for the current
 *          database.
 * 
 *          <pre>
 * 
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
 * 			ACLEntry entry = acl.getFirstEntry();
 * 			do {
 * 				System.out.println(entry.getName());
 * 			} while ((entry = acl.getNextEntry(entry)) != null);
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * 
 * }
 * </pre>
 * 
 * @access Every Database object contains an ACL object representing the access
 *         control list of that database. To get it, use
 *         {@link NotesDatabase#getACL()} in Database.
 * 
 * @usage The Database class has three methods you can use to access and modify
 *        an ACL without getting an ACL object:
 *        {@link NotesDatabase#queryAccess(String)},
 *        {@link NotesDatabase#grantAccess(String, int)}, and
 *        {@link NotesDatabase#revokeAccess(String)}. However, using these
 *        methods at the same time that an ACL object is in use may produce
 *        inconsistent results.
 */
public interface NotesACL extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int LEVEL_NOACCESS = 0;
	/**
	 * {@value}
	 */
	public static final int LEVEL_DEPOSITOR = 1;
	/**
	 * {@value}
	 */
	public static final int LEVEL_READER = 2;
	/**
	 * {@value}
	 */
	public static final int LEVEL_AUTHOR = 3;
	/**
	 * {@value}
	 */
	public static final int LEVEL_EDITOR = 4;
	/**
	 * {@value}
	 */
	public static final int LEVEL_DESIGNER = 5;
	/**
	 * {@value}
	 */
	public static final int LEVEL_MANAGER = 6;
	/**
	 * {@value}
	 */
	public static final int ACL_MAX_ROLES = 80;

	/**
	 * Returns the first entry in an ACL.
	 * 
	 * @return The first entry in the ACL.
	 * @throws NotesApiException
	 * 
	 * @usage The first entry is typically the -Default- entry.
	 * 
	 * @example This agent looks for an ACL entry that matches the agent comment
	 *          disregarding case.
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
	 * 			if (agent.getComment().equals(&quot;&quot;)) {
	 * 				System.out.println(&quot;Comment not specified&quot;);
	 * 			} else {
	 * 				Database db = agentContext.getCurrentDatabase();
	 * 				ACL acl = db.getACL();
	 * 				boolean gotIt = false;
	 * 				ACLEntry entry = acl.getFirstEntry();
	 * 				do {
	 * 					if (entry.getNameObject().getCommon()
	 * 							.equalsIgnoreCase(agent.getComment())) {
	 * 						gotIt = true;
	 * 						break;
	 * 					}
	 * 				} while ((entry = acl.getNextEntry(entry)) != null);
	 * 				if (gotIt)
	 * 					System.out.println(agent.getComment() + &quot; is in the ACL&quot;);
	 * 				else
	 * 					System.out.println(agent.getComment()
	 * 							+ &quot; is not in the ACL&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesACLEntry getFirstEntry() throws NotesApiException;

	/**
	 * Returns the next ACL entry or the one following a specified entry.
	 * 
	 * @param entry
	 *            Any entry in the ACL. Cannot be null.
	 * @return The ACL entry following the entry specified as the parameter.
	 *         Returns null if there are no more entries.
	 * @throws NotesApiException
	 * 
	 * @usage With no parameter, this method returns the entry following the
	 *        last entry retrieved. The no-parameter method improves performance
	 *        for remote operations because ACL entries are cached locally.
	 * 
	 *        The order of the ACL entries is unspecified. The order is not
	 *        alphabetical and does not correspond to UI displays.
	 * 
	 * @example This agent gets the ACL entry whose name is the agent comment,
	 *          and prints whether the entry can delete documents.
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
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				if (entry.isCanDeleteDocuments())
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; can delete documents&quot;);
	 * 				else
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; cannot delete documents&quot;);
	 * 			} else
	 * 				System.out.println(&quot;No entry for &quot; + agent.getComment());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesACLEntry getNextEntry(NotesACLEntry entry)
			throws NotesApiException;

	/**
	 * Returns the next ACL entry or the one following a specified entry.
	 * 
	 * @return Any entry in the ACL. Cannot be null.
	 * @throws NotesApiException
	 * 
	 * @usage With no parameter, this method returns the entry following the
	 *        last entry retrieved. The no-parameter method improves performance
	 *        for remote operations because ACL entries are cached locally.
	 * 
	 *        The order of the ACL entries is unspecified. The order is not
	 *        alphabetical and does not correspond to UI displays.
	 * 
	 * @example This agent gets the ACL entry whose name is the agent comment,
	 *          and prints whether the entry can delete documents.
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
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				if (entry.isCanDeleteDocuments())
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; can delete documents&quot;);
	 * 				else
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; cannot delete documents&quot;);
	 * 			} else
	 * 				System.out.println(&quot;No entry for &quot; + agent.getComment());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesACLEntry getNextEntry() throws NotesApiException;

	/**
	 * Given a name, finds its entry in an ACL.
	 * 
	 * @param name
	 *            The name whose ACL entry you want to find. You must supply the
	 *            complete name, but hierarchical names can be in abbreviated
	 *            format. Case is not significant.
	 * @return The ACL entry following the entry specified as the parameter.
	 *         Returns null if there are no more entries.
	 * @throws NotesApiException
	 * 
	 * @usage This method can find people, groups, or servers in an ACL. If a
	 *        person is not listed explicitly in the ACL, but is a member of a
	 *        group listed in the ACL, getEntry does not find that person's name
	 * 
	 * @example This agent gets the ACL entry whose name is the agent comment,
	 *          and prints whether the entry can delete documents.
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
	 * 			ACL acl = db.getACL();
	 * 			ACLEntry entry = acl.getEntry(agent.getComment());
	 * 			if (entry != null) {
	 * 				if (entry.isCanDeleteDocuments())
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; can delete documents&quot;);
	 * 				else
	 * 					System.out.println(entry.getName()
	 * 							+ &quot; cannot delete documents&quot;);
	 * 			} else
	 * 				System.out.println(&quot;No entry for &quot; + agent.getComment());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesACLEntry getEntry(String name)
			throws NotesApiException;

	/**
	 * The maximum Internet access level for this database.
	 * 
	 * @return The maximum Internet access level for this database.
	 *         ACL.LEVEL_NOACCESS, ACL.LEVEL_DEPOSITOR, ACL.LEVEL_READER
	 *         ACL.LEVEL_AUTHOR, ACL.LEVEL_EDITOR, ACL.LEVEL_DESIGNER,
	 *         ACL.LEVEL_MANAGER
	 * 
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link #save()} on the ACL if you want the modified
	 *        ACL to be saved to disk
	 * 
	 * @example This agent prints the maximum Internet level for the current
	 *          database.
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
	 * 			String lev = null;
	 * 			int ilev = acl.getInternetLevel();
	 * 			if (ilev &lt; ACL.LEVEL_DESIGNER)
	 * 				acl.setInternetLevel(ilev + 1);
	 * 			acl.save();
	 * 			switch (acl.getInternetLevel()) {
	 * 			case ACL.LEVEL_NOACCESS:
	 * 				lev = &quot;no&quot;;
	 * 				break;
	 * 			case ACL.LEVEL_DEPOSITOR:
	 * 				lev = &quot;depositor&quot;;
	 * 				break;
	 * 			case ACL.LEVEL_READER:
	 * 				lev = &quot;reader&quot;;
	 * 				break;
	 * 			case ACL.LEVEL_AUTHOR:
	 * 				lev = &quot;author&quot;;
	 * 				break;
	 * 			case ACL.LEVEL_EDITOR:
	 * 				lev = &quot;editor&quot;;
	 * 				break;
	 * 			case ACL.LEVEL_DESIGNER:
	 * 				lev = &quot;designer&quot;;
	 * 				break;
	 * 			case ACL.LEVEL_MANAGER:
	 * 				lev = &quot;manager&quot;;
	 * 				break;
	 * 			}
	 * 			System.out.println(&quot;Maximum internet access is &quot; + lev + &quot; access&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getInternetLevel() throws NotesApiException;

	/**
	 * The maximum Internet access level for this database.
	 * 
	 * @param level
	 *            ACL.LEVEL_NOACCESS, ACL.LEVEL_DEPOSITOR, ACL.LEVEL_READER
	 *            ACL.LEVEL_AUTHOR, ACL.LEVEL_EDITOR, ACL.LEVEL_DESIGNER,
	 *            ACL.LEVEL_MANAGER
	 * @throws NotesApiException
	 */
	public abstract void setInternetLevel(int level) throws NotesApiException;

	/**
	 * Saves changes that you've made to the ACL. If you don't call save before
	 * closing a database, the changes you've made to its ACL are lost.
	 * 
	 * @throws NotesApiException
	 * 
	 * @example This agent creates a new entry for the ACL of the current
	 *          database. The user specifies the name of the entry in the agent
	 *          comment. The entry has manager access level.
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
	 * 			ACL acl = db.getACL();
	 * 			acl.createACLEntry(agent.getComment(), ACL.LEVEL_MANAGER);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void save() throws NotesApiException;

	/**
	 * Changes the name of a role.
	 * 
	 * @param oldName
	 *            The current name of the role. Do not put square brackets
	 *            around the name.
	 * @param newName
	 *            The new name you want to give to the role. Do not specify the
	 *            brackets
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link #save()} on the ACL if you want the modified
	 *        ACL to be saved to disk.
	 * 
	 *        When you rename a role, any entries in the ACL that had the old
	 *        role get the new role.
	 * 
	 * @example This agent appends "Role" to the name of each role. For example,
	 *          [Supervisor] becomes [SupervisorRole]. The code takes into
	 *          account the brackets returned by the Roles property.
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
	 * 			ACL acl = db.getACL();
	 * 			Vector roles = acl.getRoles();
	 * 			String role;
	 * 			for (int i = 0; i &lt; roles.size(); i++) {
	 * 				role = (String) roles.elementAt(i);
	 * 				role = role.substring(1, role.length() - 1);
	 * 				acl.renameRole((String) roles.elementAt(i), &quot;[&quot; + role
	 * 						+ &quot;Role]&quot;);
	 * 			}
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void renameRole(String oldName, String newName)
			throws NotesApiException;

	/**
	 * Adds a role to an ACL.
	 * 
	 * @param name
	 *            The name of the new role. Do not put square brackets around
	 *            the name.
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link #save()} on the ACL if you want the modified
	 *        ACL to be saved to disk.
	 * 
	 * @example This agent adds a role to the ACL of the current database. The
	 *          user specifies the role in the agent comment.
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
	 * 			ACL acl = db.getACL();
	 * 			acl.addRole(agent.getComment());
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void addRole(String name) throws NotesApiException;

	/**
	 * Deletes a role from an ACL and removes it from any ACL entries that have
	 * it.
	 * 
	 * @param name
	 *            The name of the role to remove. Do not put square brackets
	 *            around the name.
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link #save()} on the ACL if you want the modified
	 *        ACL to be saved to disk
	 * 
	 * @example This agent deletes a role from the ACL for the current database.
	 *          The user specifies the role in the agent comment.
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
	 * 			ACL acl = db.getACL();
	 * 			acl.deleteRole(agent.getComment());
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void deleteRole(String name) throws NotesApiException;

	/**
	 * Creates an entry in the ACL with the name and level that you specify.
	 * 
	 * @param name
	 *            The name of the person, group, or server for whom you want to
	 *            create an entry in the ACL. You must supply the complete name,
	 *            but hierarchical names can be in abbreviated format. Case is
	 *            not significant.
	 * @param level
	 *            The level that you want to assign to this person, group, or
	 *            server in the ACL. May be any of the following:
	 *            ACL.LEVEL_NOACCESS, ACL.LEVEL_DEPOSITOR, ACL.LEVEL_READER
	 *            ACL.LEVEL_AUTHOR, ACL.LEVEL_EDITOR, ACL.LEVEL_DESIGNER,
	 *            ACL.LEVEL_MANAGER
	 * 
	 * @return The newly-created entry.
	 * @throws NotesApiException
	 * 
	 * @usage You must call {@link #save()} on the ACL if you want the modified
	 *        ACL to be saved to disk
	 * 
	 * @example This agent creates a new entry for the ACL of the current
	 *          database. The user specifies the name of the entry in the agent
	 *          comment. The entry has manager access level.
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
	 * 			ACL acl = db.getACL();
	 * 			acl.createACLEntry(agent.getComment(), ACL.LEVEL_MANAGER);
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesACLEntry createACLEntry(String name, int level)
			throws NotesApiException;

	/**
	 * All the roles defined in an access control list.
	 * 
	 * @return All the roles defined in an access control list.
	 * @throws NotesApiException
	 * 
	 * @usage Each element in the vector is the name of a role. Each role name
	 *        is surrounded by square brackets, for example, "[Supervisor]."
	 * 
	 *        Notes Release 2 "privileges" are surrounded by parentheses.
	 *        Properties and methods affecting roles, such as disableRole and
	 *        enableRole, do not work on privileges.
	 * 
	 * @example This agent displays the name of every role in the current
	 *          database. For example, it might display [HR Contact],
	 *          [Supervisor], and [Project Leader].
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
	 * 			ACL acl = db.getACL();
	 * 			Vector roles = acl.getRoles();
	 * 			for (int i = 0; i &lt; roles.size(); i++)
	 * 				System.out.println(roles.elementAt(i));
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector<String> getRoles() throws NotesApiException;

	/**
	 * The database that owns an ACL.
	 * 
	 * @return The database that owns an ACL.
	 * @throws NotesApiException
	 * 
	 * @example This agent prints the title of the parent database for the
	 *          current ACL.
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
	 * 			Database parent = acl.getParent();
	 * 			System.out.println(&quot;Parent database is \&quot;&quot; + db.getTitle() + &quot;\&quot;&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase getParent() throws NotesApiException;

	/**
	 * Indicates whether a consistent access control list is enforced across all
	 * replicas of a database.
	 * 
	 * @return {@code true} indicates that uniform access is set {@code false}
	 *         indicates that uniform access is not set
	 * 
	 * @throws NotesApiException
	 * 
	 * @usage For setUniformAccess, you must call {@link #save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example The following agent toggles the IsUniformAccess property.
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
	 * 			System.out.println(&quot;Uniform access is &quot; + acl.isUniformAccess());
	 * 			if (acl.isUniformAccess())
	 * 				acl.setUniformAccess(false);
	 * 			else
	 * 				acl.setUniformAccess(true);
	 * 			acl.save();
	 * 			System.out.println(&quot;Uniform access is &quot; + acl.isUniformAccess());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isUniformAccess() throws NotesApiException;

	/**
	 * Indicates whether a consistent access control list is enforced across all
	 * replicas of a database.
	 * 
	 * @param flag
	 *            {@code true} indicates that uniform access is set
	 *            {@code false} indicates that uniform access is not set
	 * @throws NotesApiException
	 * 
	 * @usage For setUniformAccess, you must call {@link #save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example The following agent toggles the IsUniformAccess property.
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
	 * 			System.out.println(&quot;Uniform access is &quot; + acl.isUniformAccess());
	 * 			if (acl.isUniformAccess())
	 * 				acl.setUniformAccess(false);
	 * 			else
	 * 				acl.setUniformAccess(true);
	 * 			acl.save();
	 * 			System.out.println(&quot;Uniform access is &quot; + acl.isUniformAccess());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setUniformAccess(boolean flag)
			throws NotesApiException;

	/**
	 * Removes an entry from the ACL.
	 * 
	 * @param name
	 *            The name of the person, group, or server whose entry you want
	 *            to remove. You must supply the complete name, but hierarchical
	 *            names can be in abbreviated format. Case is not significant.
	 * @throws NotesApiException
	 * 
	 * @usage For setUniformAccess, you must call {@link #save()} on the ACL if
	 *        you want the modified ACL to be saved to disk.
	 * 
	 * @example This agent removes the ACL entry that matches the agent comment
	 *          disregarding case.
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
	 * 			ACL acl = db.getACL();
	 * 			acl.removeACLEntry(agent.getComment());
	 * 			acl.save();
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void removeACLEntry(String name) throws NotesApiException;

	/**
	 * Indicates whether extended access is enabled.
	 * 
	 * @return {@code true} if extended access is enabled {@code false} if
	 *         extended access is disabled
	 * @throws NotesApiException
	 * 
	 * @usage In the Notes UI, this property is in the advanced section of ACL
	 *        properties: "Enable Extended Access."
	 * 
	 *        This property applies only to Domino Directory, Extended Directory
	 *        Catalog, and Administration Requests databases.
	 * 
	 *        Setting this property true automatically sets
	 *        {@link #isUniformAccess()} true. Setting this property false does
	 *        not automatically set {@link #isUniformAccess()} false.
	 * 
	 *        After setting this property, you must call save for the changes to
	 *        take effect. If you do not call {@link #save()}, your changes to
	 *        the ACL are lost.
	 * 
	 * @example The following agent toggles IsExtendedAccess for the current
	 *          database, disabling IsUniformAccess as necessary.
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
	 * 			Database db = session.getDatabase(&quot;gvasington300gl&quot;, &quot;names&quot;);
	 * 			ACL acl = db.getACL();
	 * 			if (acl.isExtendedAccess()) {
	 * 				acl.setExtendedAccess(false);
	 * 				acl.setUniformAccess(false);
	 * 			} else
	 * 				acl.setExtendedAccess(true);
	 * 			acl.save();
	 * 			System.out.println(&quot;Extended access = &quot; + acl.isExtendedAccess());
	 * 			System.out.println(&quot;Uniform access = &quot; + acl.isUniformAccess());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isExtendedAccess() throws NotesApiException;

	/**
	 * Indicates whether extended access is enabled.
	 * 
	 * @param flag
	 *            {@code true} if extended access is enabled {@code false} if
	 *            extended access is disabled
	 * @throws NotesApiException
	 * 
	 * @usage In the Notes UI, this property is in the advanced section of ACL
	 *        properties: "Enable Extended Access."
	 * 
	 *        This property applies only to Domino Directory, Extended Directory
	 *        Catalog, and Administration Requests databases.
	 * 
	 *        Setting this property true automatically sets
	 *        {@link #isUniformAccess()} true. Setting this property false does
	 *        not automatically set {@link #isUniformAccess()} false.
	 * 
	 *        After setting this property, you must call save for the changes to
	 *        take effect. If you do not call {@link #save()}, your changes to
	 *        the ACL are lost.
	 * 
	 * @example The following agent toggles IsExtendedAccess for the current
	 *          database, disabling IsUniformAccess as necessary.
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
	 * 			Database db = session.getDatabase(&quot;gvasington300gl&quot;, &quot;names&quot;);
	 * 			ACL acl = db.getACL();
	 * 			if (acl.isExtendedAccess()) {
	 * 				acl.setExtendedAccess(false);
	 * 				acl.setUniformAccess(false);
	 * 			} else
	 * 				acl.setExtendedAccess(true);
	 * 			acl.save();
	 * 			System.out.println(&quot;Extended access = &quot; + acl.isExtendedAccess());
	 * 			System.out.println(&quot;Uniform access = &quot; + acl.isUniformAccess());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setExtendedAccess(boolean flag)
			throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * Readers and Authors fields in a database.
	 * 
	 * @return {@code true} if the administration server can modify Readers and
	 *         Authors fields {@code false} if the administration server cannot
	 *         modify Readers and Authors fields
	 * @throws NotesApiException
	 * 
	 * @usage The database must have an administration server. See
	 *        {@link #getAdministrationServer()} in {@link NotesACL} and
	 *        {@link NotesACLEntry#isAdminServer()} in {@link NotesACLEntry} to
	 *        check for and set the administration server.
	 * 
	 *        After setting this property (
	 *        {@link #setAdminReaderAuthor(boolean)}), you must call
	 *        {@link #save()} for the changes to take effect. If you do not call
	 *        save, your changes to the ACL are lost.
	 * 
	 * @example This agent toggles IsAdminReaderAuthor for the current database.
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
	 * 			ACL acl = db.getACL();
	 * 			if (acl.getAdministrationServer().equals(&quot;&quot;))
	 * 				System.out.println(&quot;No admin server - can't change&quot;);
	 * 			else {
	 * 				acl.setAdminReaderAuthor(!acl.isAdminReaderAuthor());
	 * 				acl.save();
	 * 				System.out.println(&quot;IsAdminReaderAuthor = &quot;
	 * 						+ acl.isAdminReaderAuthor());
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isAdminReaderAuthor() throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * Readers and Authors fields in a database.
	 * 
	 * @param flag
	 *            {@code true} if the administration server can modify Readers
	 *            and Authors fields {@code false} if the administration server
	 *            cannot modify Readers and Authors fields
	 * @throws NotesApiException
	 * 
	 * @usage The database must have an administration server. See
	 *        {@link #getAdministrationServer()} in {@link NotesACL} and
	 *        {@link NotesACLEntry#isAdminServer()} in {@link NotesACLEntry} to
	 *        check for and set the administration server.
	 * 
	 *        After setting this property, you must call {@link #save()} for the
	 *        changes to take effect. If you do not call save, your changes to
	 *        the ACL are lost.
	 * 
	 * @example This agent toggles IsAdminReaderAuthor for the current database.
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
	 * 			ACL acl = db.getACL();
	 * 			if (acl.getAdministrationServer().equals(&quot;&quot;))
	 * 				System.out.println(&quot;No admin server - can't change&quot;);
	 * 			else {
	 * 				acl.setAdminReaderAuthor(!acl.isAdminReaderAuthor());
	 * 				acl.save();
	 * 				System.out.println(&quot;IsAdminReaderAuthor = &quot;
	 * 						+ acl.isAdminReaderAuthor());
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setAdminReaderAuthor(boolean flag)
			throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * all Names fields in a database.
	 * 
	 * @return {@code true} if the administration server can modify Names fields
	 *         {@code false} if the administration server cannot modify Names
	 *         fields
	 * @throws NotesApiException
	 * 
	 * @usage The database must have an administration server. See
	 *        {@link #getAdministrationServer()} in {@link NotesACL} and
	 *        {@link NotesACLEntry#isAdminServer()} in {@link NotesACLEntry} to
	 *        check for and set the administration server.
	 * 
	 *        After setting this property ({@link #setAdminNames(boolean)}), you
	 *        must call {@link #save()} for the changes to take effect. If you
	 *        do not call save, your changes to the ACL are lost.
	 * 
	 * @example This agent toggles IsAdminNames for the current database.
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
	 * 			ACL acl = db.getACL();
	 * 			if (acl.getAdministrationServer().equals(&quot;&quot;))
	 * 				System.out.println(&quot;No admin server - can't change&quot;);
	 * 			else {
	 * 				acl.setAdminNames(!acl.isAdminNames());
	 * 				acl.save();
	 * 				System.out.println(&quot;IsAdminNames = &quot; + acl.isAdminNames());
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract boolean isAdminNames() throws NotesApiException;

	/**
	 * Indicates whether the administration server for the database can modify
	 * all Names fields in a database.
	 * 
	 * @param flag
	 *            {@code true} if the administration server can modify Names
	 *            fields {@code false} if the administration server cannot
	 *            modify Names fields
	 * @throws NotesApiException
	 * 
	 * @usage The database must have an administration server. See
	 *        {@link #getAdministrationServer()} in {@link NotesACL} and
	 *        {@link NotesACLEntry#isAdminServer()} in {@link NotesACLEntry} to
	 *        check for and set the administration server.
	 * 
	 *        After setting this property, you must call {@link #save()} for the
	 *        changes to take effect. If you do not call save, your changes to
	 *        the ACL are lost.
	 * 
	 * @example This agent toggles IsAdminNames for the current database.
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
	 * 			ACL acl = db.getACL();
	 * 			if (acl.getAdministrationServer().equals(&quot;&quot;))
	 * 				System.out.println(&quot;No admin server - can't change&quot;);
	 * 			else {
	 * 				acl.setAdminNames(!acl.isAdminNames());
	 * 				acl.save();
	 * 				System.out.println(&quot;IsAdminNames = &quot; + acl.isAdminNames());
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void setAdminNames(boolean flag) throws NotesApiException;

	/**
	 * The name of the administration server for a database.
	 * 
	 * @return The name of the administration server for a database.
	 * @throws NotesApiException
	 * 
	 * @usage The administration server is also the master lock server.
	 * 
	 *        This property is an empty string if the database does not have an
	 *        administration server.
	 * @example 1. This agent displays the administration server for the current
	 *          database.
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
	 * 			ACL acl = db.getACL();
	 * 			if (acl.getAdministrationServer().equals(&quot;&quot;))
	 * 				System.out.println(&quot;No administration server&quot;);
	 * 			else
	 * 				System.out.println(&quot;Administration server = &quot;
	 * 						+ acl.getAdministrationServer());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This view action toggles the administration server for the
	 *          current database.
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
	 * 			ACL acl = db.getACL();
	 * 			String server = &quot;server1/East/Acme&quot;;
	 * 			if (acl.getAdministrationServer().equals(&quot;&quot;))
	 * 				acl.setAdministrationServer(server);
	 * 			else
	 * 				acl.setAdministrationServer(&quot;&quot;);
	 * 			acl.save();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getAdministrationServer() throws NotesApiException;

	/**
	 * The name of the administration server for a database.
	 * 
	 * @param serverName
	 *            The name of the administration server for a database.
	 * 
	 * @throws NotesApiException
	 */
	public abstract void setAdministrationServer(String serverName)
			throws NotesApiException;
}
