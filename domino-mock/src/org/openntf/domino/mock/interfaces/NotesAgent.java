package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * @author Sven Dreher
 * 
 */
public interface NotesAgent extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int TRIGGER_NONE = 0;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_SCHEDULED = 1;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_AFTER_MAIL_DELIVERY = 2;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_DOC_PASTED = 3;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_MANUAL = 4;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_DOC_UPDATE = 5;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_BEFORE_MAIL_DELIVERY = 6;
	/**
	 * {@value}
	 */
	public static final int TRIGGER_SERVERSTART = 8;
	/**
	 * {@value}
	 */
	public static final int TARGET_NONE = 0;
	/**
	 * {@value}
	 */
	public static final int TARGET_ALL_DOCS = 1;
	/**
	 * {@value}
	 */
	public static final int TARGET_NEW_DOCS = 2;
	/**
	 * {@value}
	 */
	public static final int TARGET_NEW_OR_MODIFIED_DOCS = 3;
	/**
	 * {@value}
	 */
	public static final int TARGET_SELECTED_DOCS = 4;
	/**
	 * {@value}
	 */
	public static final int TARGET_ALL_DOCS_IN_VIEW = 5;
	/**
	 * {@value}
	 */
	public static final int TARGET_UNREAD_DOCS_IN_VIEW = 6;
	/**
	 * {@value}
	 */
	public static final int TARGET_RUN_ONCE = 8;

	/**
	 * @throws NotesApiException
	 */
	public abstract void run() throws NotesApiException;

	/**
	 * @param noteID
	 * @throws NotesApiException
	 */
	public abstract void run(String noteID) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int runOnServer() throws NotesApiException;

	/**
	 * @param noteID
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int runOnServer(String noteID) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void remove() throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void save() throws NotesApiException;

	/**
	 * The name of an agent. Within a database, the name of an agent may not be unique
	 * 
	 * @return The name of an agent. Within a database, the name of an agent may not be unique
	 * @throws NotesApiException
	 * @example 1. This agent prints the name of the current agent.
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent prints the names of all agents in the current database
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
	public abstract String getName() throws NotesApiException;

	/**
	 * The name of the person who last modified and saved an agent.
	 * 
	 * @return The name of the person who last modified and saved an agent.
	 * @throws NotesApiException
	 * @usage If the owner's name is hierarchical, this property returns the fully distinguished name.
	 * 
	 *        Saving the agent changes the owner immediately. However, if you subsequently call Agent.owner within the same Session, the previous owner's name will be returned. The ownership change is
	 *        not reflected in properties until the next time a Session is obtained.
	 * @example This agent prints the name and common owner of all the agents in the current database
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 			System.out.println(&quot;Common owner: &quot; + agent.getOwner());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getOwner() throws NotesApiException;

	/**
	 * The date that an agent last ran.
	 * 
	 * @return The date that an agent last ran.
	 * @throws NotesApiException
	 * @usage If the script has never been run before, this property returns null
	 * @example For each agent in the current database, this agent prints its name and the last time it ran
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
	 * 			for (int i = 0; i &lt; agents.size(); i++) {
	 * 				Agent agent = (Agent) agents.elementAt(i);
	 * 				DateTime date = agent.getLastRun();
	 * 				if (date.getDateOnly() != null)
	 * 					System.out.println(&quot;Agent &quot; + agent.getName() + &quot; last ran on &quot; + date.getDateOnly() + &quot; at &quot; + date.getTimeOnly());
	 * 				else
	 * 					System.out.println(&quot;Agent &quot; + agent.getName() + &quot; hasn't run yet&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDateTime getLastRun() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isEnabled() throws NotesApiException;

	/**
	 * @param value
	 * @throws NotesApiException
	 */
	public abstract void setEnabled(boolean value) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getServerName() throws NotesApiException;

	/**
	 * @param serverName
	 * @throws NotesApiException
	 */
	public abstract void setServerName(String serverName) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getQuery() throws NotesApiException;

	/**
	 * The comment that describes an agent, as entered by the agent's designer
	 * 
	 * @return The comment that describes an agent, as entered by the agent's designer
	 * @throws NotesApiException
	 * @example This agent prints the name and comment of the current agent.
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 			System.out.println(&quot;Comment: &quot; + agent.getComment());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getComment() throws NotesApiException;

	/**
	 * The database that contains an agent.
	 * 
	 * @returnThe database that contains an agent.
	 * @throws NotesApiException
	 * @example This agent prints the name of the database on which the agent is running
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
	 * 			Database db = agent.getParent();
	 * 			System.out.println(&quot;Database on which this agent is running is '&quot; + db.getTitle() + &quot;'&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase getParent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isPublic() throws NotesApiException;

	/**
	 * The common name of the person who last modified and saved an agent.
	 * 
	 * @return The common name of the person who last modified and saved an agent.
	 * @throws NotesApiException
	 * @usage If the owner's name is flat (non-hierarchical), the CommonOwner name is the same as the Owner name.
	 * @example This agent prints the common owner name of the current agent.
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 			System.out.println(&quot;Common owner: &quot; + agent.getCommonOwner());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getCommonOwner() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getTrigger() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getTarget() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isNotesAgent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isWebAgent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getURL() throws NotesApiException;

	/**
	 * The Domino URL of an agent when Notes protocols are in effect
	 * 
	 * @return The Domino URL of an agent when Notes protocols are in effect
	 * @throws NotesApiException
	 * @usage If HTTP protocols are not available, this property returns an empty string. See {@link #getHttpURL()}.
	 * 
	 *        See {@link NotesSession#resolve(String)} in Session for additional information and examples.
	 * @example This agent gets the Notes and HTTP URLs for the current agent. The agent varies the display depending on whether access is through Notes (the HTTP URL is blank) or HTTP protocols
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 
	 * 			// Get URLs
	 * 			String notesURL = agent.getNotesURL();
	 * 			String httpURL = agent.getHttpURL();
	 * 
	 * 			// Assume local if http is blank and print info for notes
	 * 			if (httpURL.length() == 0) {
	 * 				System.out.println(&quot;NotesURL = &quot; + notesURL);
	 * 				System.out.println(&quot;Http URL = None&quot;);
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
	 * The Domino URL of an agent when HTTP protocols are in effect.
	 * 
	 * @return The Domino URL of an agent when HTTP protocols are in effect.
	 * @throws NotesApiException
	 * @usage If HTTP protocols are not available, this property returns an empty string. See {@link #getNotesURL()}.
	 * 
	 *        See {@link NotesSession#resolve(String)} in Session for additional information and examples.
	 * @example This agent gets the Notes and HTTP URLs for the current agent. The agent varies the display depending on whether access is through Notes (the HTTP URL is blank) or HTTP protocols
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 
	 * 			// Get URLs
	 * 			String notesURL = agent.getNotesURL();
	 * 			String httpURL = agent.getHttpURL();
	 * 
	 * 			// Assume local if http is blank and print info for notes
	 * 			if (httpURL.length() == 0) {
	 * 				System.out.println(&quot;NotesURL = &quot; + notesURL);
	 * 				System.out.println(&quot;Http URL = None&quot;);
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
	 * Returns the NoteID of a document passed in by {@link #run()} or {@link #runOnServer(String)}.
	 * 
	 * @return Returns the NoteID of a document passed in by {@link #run()} or {@link #runOnServer(String)}.
	 * @throws NotesApiException
	 * @usage Use {@link NotesDatabase#getDocumentByID(String)} in Database to get a document through its NoteID.
	 * @example 1. This agent runs the agent named "Agent to be run Java."
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
	 * 			Agent agent = db.getAgent(&quot;Agent to be run Java&quot;);
	 * 			agent.run();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          This is "Agent to be run Java."
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
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;, &quot;The agent is running as &quot; + session.getUserName());
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent runs the "Agent to be run parameter Java" agent passing it the NoteID of a newly created document
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
	 * 			// Create document containing data to be passed
	 * 			Document doc = db.createDocument();
	 * 			doc.appendItemValue(&quot;TriggerUserName&quot;, session.getUserName());
	 * 			doc.save(true, false);
	 * 			// Start agent and pass NoteID of document
	 * 			Agent agent = db.getAgent(&quot;Agent to be run parameter Java&quot;);
	 * 			agent.run(doc.getNoteID());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          Below is "Agent to be run parameter Java." It accesses the passed NoteID through getParameterDocID, accesses the referenced document, and removes it:
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			// Get document used for passing data
	 * 			Document doc = db.getDocumentByID(agent.getParameterDocID());
	 * 			// Send mail containing passed data
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;, &quot;The agent was started by &quot; + doc.getItemValueString(&quot;TriggerUserName&quot;));
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getParameterDocID() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isActivatable() throws NotesApiException;

	/**
	 * Name of the user under whose identity the agent runs
	 * 
	 * @return Name of the user under whose identity the agent runs
	 * @throws NotesApiException
	 * @usage This property reflects the value of "Run on behalf of" under the security tab of the agent builder.
	 * 
	 *        If this property is an empty string, the agent runs on behalf of the owner of the agent or the browser login user (if the agent is run from a browser and "Run as web user" is checked).
	 * @example This agent sends mail with ownership and user information, including on whose behalf the agent runs
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Document doc = db.createDocument();
	 * 			doc.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			doc.appendItemValue(&quot;SendTo&quot;, agentContext.getEffectiveUserName());
	 * 			doc.appendItemValue(&quot;Subject&quot;, &quot;Owner, user, effective user, on behalf of&quot;);
	 * 			RichTextItem body = doc.createRichTextItem(&quot;Body&quot;);
	 * 			body.appendText(&quot;Owner = &quot; + agent.getOwner());
	 * 			body.addNewLine(1);
	 * 			body.appendText(&quot;User= &quot; + session.getUserName());
	 * 			body.addNewLine(1);
	 * 			body.appendText(&quot;Effective user = &quot; + agentContext.getEffectiveUserName());
	 * 			body.addNewLine(1);
	 * 			String behalf = agent.getOnBehalfOf();
	 * 			if (behalf.length() == 0)
	 * 				behalf = &quot;-Self-&quot;;
	 * 			body.appendText(&quot;On behalf of = &quot; + behalf);
	 * 			body.addNewLine(1);
	 * 			doc.send(false);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getOnBehalfOf() throws NotesApiException;

	/**
	 * The names of the holders of a lock.
	 * 
	 * @return The names of the holders of a lock.
	 * @throws NotesApiException
	 * @usage If the agent is locked, the vector contains the names of the lock holders. The agent can be locked by one or more users or groups.
	 * 
	 *        If the agent is not locked, the vector contains one element whose value is an empty string ("").
	 * @example This view action displays the lock holders for the agent named "Main Agent".
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
	 * 			Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get and display lock holders
	 * 				Vector holders = agent.getLockHolders();
	 * 				if (holders.size() == 0)
	 * 					System.out.println(&quot;No lock holders&quot;);
	 * 				else
	 * 					for (int i = 0; i &lt; holders.size(); i++)
	 * 						System.out.println(holders.elementAt(i));
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract Vector<String> getLockHolders() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock() throws NotesApiException;

	/**
	 * @param provisionalok
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(boolean provisionalok) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(String name) throws NotesApiException;

	/**
	 * @param name
	 * @param provisionalok
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(String name, boolean provisionalok) throws NotesApiException;

	/**
	 * @param names
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(Vector names) throws NotesApiException;

	/**
	 * @param names
	 * @param provisionalok
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(Vector names, boolean provisionalok) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lockProvisional() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lockProvisional(String name) throws NotesApiException;

	/**
	 * @param names
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lockProvisional(Vector names) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void unlock() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isProhibitDesignUpdate() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setProhibitDesignUpdate(boolean flag) throws NotesApiException;

}
