package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents an agent.
 * 
 * @author Sven Dreher
 * @access There are two ways to access an agent:
 * 
 *         To access the agent that's currently running, use getCurrentAgent in
 *         AgentContext. To access all the agents in a database, use getAgents
 *         in Database.
 * @usage System.out writes to an Events document ("Miscellaneous Events" view)
 *        in the log.nsf database where the code executes for:
 *        <ul>
 *        <li>Scheduled agents</li>
 *        <li>Agents started by run or runOnServer</li>
 *        </ul>
 * @example 1. This agent prints the name of the current agent
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
public interface NotesAgent extends NotesBase {
	/**
	 * {@value}
	 */
	static final int TRIGGER_NONE = 0;
	/**
	 * {@value}
	 */
	static final int TRIGGER_SCHEDULED = 1;
	/**
	 * {@value}
	 */
	static final int TRIGGER_AFTER_MAIL_DELIVERY = 2;
	/**
	 * {@value}
	 */
	static final int TRIGGER_DOC_PASTED = 3;
	/**
	 * {@value}
	 */
	static final int TRIGGER_MANUAL = 4;
	/**
	 * {@value}
	 */
	static final int TRIGGER_DOC_UPDATE = 5;
	/**
	 * {@value}
	 */
	static final int TRIGGER_BEFORE_MAIL_DELIVERY = 6;
	/**
	 * {@value}
	 */
	static final int TRIGGER_SERVERSTART = 8;
	/**
	 * {@value}
	 */
	static final int TARGET_NONE = 0;
	/**
	 * {@value}
	 */
	static final int TARGET_ALL_DOCS = 1;
	/**
	 * {@value}
	 */
	static final int TARGET_NEW_DOCS = 2;
	/**
	 * {@value}
	 */
	static final int TARGET_NEW_OR_MODIFIED_DOCS = 3;
	/**
	 * {@value}
	 */
	static final int TARGET_SELECTED_DOCS = 4;
	/**
	 * {@value}
	 */
	static final int TARGET_ALL_DOCS_IN_VIEW = 5;
	/**
	 * {@value}
	 */
	static final int TARGET_UNREAD_DOCS_IN_VIEW = 6;
	/**
	 * {@value}
	 */
	static final int TARGET_RUN_ONCE = 8;

	/**
	 * Runs the agent.
	 * 
	 * @throws NotesApiException
	 * @usage This method runs any agent regardless of source language (simple
	 *        action, formula, LotusScript, Java).
	 * 
	 *        You cannot run an agent recursively (cannot call it from itself).
	 * 
	 *        The user cannot interact directly with a called agent. User output
	 *        goes to the Domino log.
	 * 
	 *        You cannot debug a called agent.
	 * 
	 *        For local operations, the agent runs on the computer running the
	 *        current program. See {@link #runOnServer()} to do otherwise.
	 * 
	 *        For remote (IIOP) operations, the agent runs on the server
	 *        handling the remote calls.
	 * @example 1. This agent runs the agent named "Agent to be run Java."
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
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;,
	 * 					&quot;The agent is running as &quot; + session.getUserName());
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent runs the "Agent to be run parameter Java" agent
	 *          passing it the NoteID of a newly created document.
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
	 *          Below is "Agent to be run parameter Java." It accesses the
	 *          passed NoteID through getParameterDocID, accesses the referenced
	 *          document, and removes it:
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			// Get document used for passing data
	 * 			Document doc = db.getDocumentByID(agent.getParameterDocID());
	 * 			// Send mail containing passed data
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(
	 * 					&quot;Body&quot;,
	 * 					&quot;The agent was started by &quot;
	 * 							+ doc.getItemValueString(&quot;TriggerUserName&quot;));
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void run() throws NotesApiException;

	/**
	 * Runs the agent.
	 * 
	 * @param noteID
	 *            The NoteID of a document. The value is passed to the
	 *            ParameterDocID property of the called agent.
	 * @throws NotesApiException
	 * @usage This method runs any agent regardless of source language (simple
	 *        action, formula, LotusScript, Java).
	 * 
	 *        You cannot run an agent recursively (cannot call it from itself).
	 * 
	 *        The user cannot interact directly with a called agent. User output
	 *        goes to the Domino log.
	 * 
	 *        You cannot debug a called agent.
	 * 
	 *        For local operations, the agent runs on the computer running the
	 *        current program. See {@link #runOnServer()} to do otherwise.
	 * 
	 *        For remote (IIOP) operations, the agent runs on the server
	 *        handling the remote calls.
	 * @example 1. This agent runs the agent named "Agent to be run Java."
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
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;,
	 * 					&quot;The agent is running as &quot; + session.getUserName());
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent runs the "Agent to be run parameter Java" agent
	 *          passing it the NoteID of a newly created document.
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
	 *          Below is "Agent to be run parameter Java." It accesses the
	 *          passed NoteID through getParameterDocID, accesses the referenced
	 *          document, and removes it:
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			// Get document used for passing data
	 * 			Document doc = db.getDocumentByID(agent.getParameterDocID());
	 * 			// Send mail containing passed data
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(
	 * 					&quot;Body&quot;,
	 * 					&quot;The agent was started by &quot;
	 * 							+ doc.getItemValueString(&quot;TriggerUserName&quot;));
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void run(String noteID) throws NotesApiException;

	/**
	 * Runs the agent on the computer containing the database.
	 * 
	 * @return Status of the operation, where 0 indicates success.
	 * @throws NotesApiException
	 * @usage This method runs any agent regardless of source language (simple
	 *        action, formula, LotusScript, Java).
	 * 
	 *        You cannot run an agent recursively (cannot call it from itself).
	 * 
	 *        The rules governing the access level required to run an agent
	 *        using the runOnServer method are the same as for any other
	 *        server-based agent. For information regarding agent security, see
	 *        "Setting up agent security." in Designer Help
	 * 
	 *        The user cannot interact directly with a called agent. User output
	 *        goes to the Domino log.
	 * 
	 *        You cannot debug a called agent.
	 * 
	 *        On a local database, the runOnServer method works like the run
	 *        method; that is, it runs the agent on the local computer or the
	 *        server handling the remote (IIOP) calls.
	 * 
	 *        Hinweis This behavior is new with Release 5.0.2. The former
	 *        behavior was to issue the error message
	 *        "runOnServer must be used with a remote database."
	 * 
	 *        If a Notes client invokes runOnServer, security is through the
	 *        signer of the agent.
	 * @example 1. This agent runs the "Agent to be run Java" agent.
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
	 * 			Agent agent = db.getAgent(&quot;Agent to be run Java&quot;);
	 * 			if (agent.runOnServer() == 0)
	 * 				System.out.println(&quot;Agent ran&quot;);
	 * 			else
	 * 				System.out.println(&quot;Agent did not run&quot;);
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
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;,
	 * 					&quot;The agent is running as &quot; + session.getUserName());
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent runs the agent named
	 *          "Agent to be run parameter Java," passing it the NoteID of a
	 *          newly created document.
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
	 * 			// Create document containing data to be passed
	 * 			Document doc = db.createDocument();
	 * 			doc.appendItemValue(&quot;TriggerUserName&quot;, session.getUserName());
	 * 			doc.save(true, false);
	 * 			// Start agent and pass NoteID of document
	 * 			Agent agent = db.getAgent(&quot;Agent to be run parameter Java&quot;);
	 * 			if (agent.runOnServer(doc.getNoteID()) == 0)
	 * 				System.out.println(&quot;Agent ran&quot;);
	 * 			else
	 * 				System.out.println(&quot;Agent did not run&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          This is "Agent to be run parameter Java." It accesses the passed
	 *          NoteID through getParameterDocID, accesses the referenced
	 *          document, and removes it.
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			// Get document used for passing data
	 * 			Document doc = db.getDocumentByID(agent.getParameterDocID());
	 * 			// Send mail containing passed data
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(
	 * 					&quot;Body&quot;,
	 * 					&quot;The agent was started by &quot;
	 * 							+ doc.getItemValueString(&quot;TriggerUserName&quot;));
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int runOnServer() throws NotesApiException;

	/**
	 * Runs the agent on the computer containing the database.
	 * 
	 * @param noteID
	 *            The NoteID of a document. This value is passed to the
	 *            ParameterDocID property of the called agent.
	 * @return Status of the operation, where 0 indicates success.
	 * @throws NotesApiException
	 * @usage This method runs any agent regardless of source language (simple
	 *        action, formula, LotusScript, Java).
	 * 
	 *        You cannot run an agent recursively (cannot call it from itself).
	 * 
	 *        The rules governing the access level required to run an agent
	 *        using the runOnServer method are the same as for any other
	 *        server-based agent. For information regarding agent security, see
	 *        "Setting up agent security." in Designer Help
	 * 
	 *        The user cannot interact directly with a called agent. User output
	 *        goes to the Domino log.
	 * 
	 *        You cannot debug a called agent.
	 * 
	 *        On a local database, the runOnServer method works like the run
	 *        method; that is, it runs the agent on the local computer or the
	 *        server handling the remote (IIOP) calls.
	 * 
	 *        Hinweis This behavior is new with Release 5.0.2. The former
	 *        behavior was to issue the error message
	 *        "runOnServer must be used with a remote database."
	 * 
	 *        If a Notes client invokes runOnServer, security is through the
	 *        signer of the agent.
	 * @example 1. This agent runs the "Agent to be run Java" agent.
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
	 * 			Agent agent = db.getAgent(&quot;Agent to be run Java&quot;);
	 * 			if (agent.runOnServer() == 0)
	 * 				System.out.println(&quot;Agent ran&quot;);
	 * 			else
	 * 				System.out.println(&quot;Agent did not run&quot;);
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
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;,
	 * 					&quot;The agent is running as &quot; + session.getUserName());
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent runs the agent named
	 *          "Agent to be run parameter Java," passing it the NoteID of a
	 *          newly created document.
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
	 * 			// Create document containing data to be passed
	 * 			Document doc = db.createDocument();
	 * 			doc.appendItemValue(&quot;TriggerUserName&quot;, session.getUserName());
	 * 			doc.save(true, false);
	 * 			// Start agent and pass NoteID of document
	 * 			Agent agent = db.getAgent(&quot;Agent to be run parameter Java&quot;);
	 * 			if (agent.runOnServer(doc.getNoteID()) == 0)
	 * 				System.out.println(&quot;Agent ran&quot;);
	 * 			else
	 * 				System.out.println(&quot;Agent did not run&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          This is "Agent to be run parameter Java." It accesses the passed
	 *          NoteID through getParameterDocID, accesses the referenced
	 *          document, and removes it.
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			// Get document used for passing data
	 * 			Document doc = db.getDocumentByID(agent.getParameterDocID());
	 * 			// Send mail containing passed data
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(
	 * 					&quot;Body&quot;,
	 * 					&quot;The agent was started by &quot;
	 * 							+ doc.getItemValueString(&quot;TriggerUserName&quot;));
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int runOnServer(String noteID) throws NotesApiException;

	/**
	 * Permanently deletes an agent from a database.
	 * 
	 * @throws NotesApiException
	 * @usage Once you call this method, the Agent object is null and you can no
	 *        longer use its methods or properties.
	 * 
	 *        It is possible to use this method to delete the agent that's
	 *        currently running. Use this feature with care. You must refresh
	 *        the Agents view in the user interface to see that the agent has
	 *        been removed.
	 * @example This agent removes the agent in the current database named
	 *          "Agent To Delete."
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			Enumeration e = db.getAgents().elements();
	 * 			String msg = &quot;Agent not found&quot;;
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String name = agent.getName();
	 * 				if (name.compareTo(&quot;Agent To Delete&quot;) == 0) {
	 * 					agent.remove();
	 * 					msg = &quot;Agent found and deleted&quot;;
	 * 					break;
	 * 				}
	 * 			}
	 * 			System.out.println(msg);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void remove() throws NotesApiException;

	/**
	 * Saves changes made to the agent.
	 * 
	 * @throws NotesApiException
	 * @usage Saving the agent changes the owner immediately. However, if you
	 *        subsequently get the owner within the same Session, the previous
	 *        owner's name is returned. The ownership change is not reflected in
	 *        the properties until the next time a Session is obtained.
	 * 
	 *        You must call save after {@link #setServerName(String)} and
	 *        {@link #setEnabled(boolean)}, or the new value is lost.
	 * 
	 *        To save an agent from an agent that runs on a server, the
	 *        executing agent must either: be signed by someone listed under
	 *        "Run unrestricted methods and operations" in the saved agent's
	 *        Server document in the Domino Directory; be signed by someone
	 *        listed under "Sign agents to run on behalf of someone else"; or
	 *        must have the same effective user as the saved agent. The
	 *        effective user may be the signer of an agent, the user listed
	 *        under "Run on behalf of" in the agent properties, or the user
	 *        invoking the agent if the agent is run from the Web the
	 *        "Run as web user" agent property is in effect.
	 */
	void save() throws NotesApiException;

	/**
	 * The name of an agent. Within a database, the name of an agent may not be
	 * unique
	 * 
	 * @return The name of an agent. Within a database, the name of an agent may
	 *         not be unique
	 * @throws NotesApiException
	 * @example 1. This agent prints the name of the current agent.
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent prints the names of all agents in the current
	 *          database
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
	String getName() throws NotesApiException;

	/**
	 * The name of the person who last modified and saved an agent.
	 * 
	 * @return The name of the person who last modified and saved an agent.
	 * @throws NotesApiException
	 * @usage If the owner's name is hierarchical, this property returns the
	 *        fully distinguished name.
	 * 
	 *        Saving the agent changes the owner immediately. However, if you
	 *        subsequently call Agent.owner within the same Session, the
	 *        previous owner's name will be returned. The ownership change is
	 *        not reflected in properties until the next time a Session is
	 *        obtained.
	 * @example This agent prints the name and common owner of all the agents in
	 *          the current database
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 			System.out.println(&quot;Common owner: &quot; + agent.getOwner());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getOwner() throws NotesApiException;

	/**
	 * The date that an agent last ran.
	 * 
	 * @return The date that an agent last ran.
	 * @throws NotesApiException
	 * @usage If the script has never been run before, this property returns
	 *        null
	 * @example For each agent in the current database, this agent prints its
	 *          name and the last time it ran
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
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			for (int i = 0; i &lt; agents.size(); i++) {
	 * 				Agent agent = (Agent) agents.elementAt(i);
	 * 				DateTime date = agent.getLastRun();
	 * 				if (date.getDateOnly() != null)
	 * 					System.out.println(&quot;Agent &quot; + agent.getName()
	 * 							+ &quot; last ran on &quot; + date.getDateOnly() + &quot; at &quot;
	 * 							+ date.getTimeOnly());
	 * 				else
	 * 					System.out.println(&quot;Agent &quot; + agent.getName()
	 * 							+ &quot; hasn't run yet&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDateTime getLastRun() throws NotesApiException;

	/**
	 * Indicates whether an agent is able to run.
	 * 
	 * @return Indicates whether an agent is able to run.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the agent can be run</li>
	 *              <li>false if the agent is disabled</li>
	 *              </ul>
	 * @usage This property is intended for use with scheduled agents, which can
	 *        be enabled and disabled. This property always returns true for
	 *        hidden agents and agents that are run from a menu.
	 * 
	 *        You must call {@link #save()} to make any change effective.
	 * 
	 *        If the agent is open in the UI, a change is not immediately
	 *        reflected. The agent must be closed and reopened.
	 * 
	 *        Access privileges and agent signing depend on whether user or
	 *        designer activation is in effect. See {@link #isActivatable()}.
	 * @example 1. This agent prints the status for each agent in the current
	 *          database: enabled or disabled.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			System.out.println(&quot;Agents in database:&quot;);
	 * 			Enumeration e = db.getAgents().elements();
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String an = agent.getName();
	 * 				if (agent.isEnabled())
	 * 					System.out.println(an + &quot; is enabled&quot;);
	 * 				else
	 * 					System.out.println(an + &quot; is disabled&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent enables the agent named "Agent To Enable" if it
	 *          exists in the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			Enumeration e = db.getAgents().elements();
	 * 			String msg = &quot;Agent not found&quot;;
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String name = agent.getName();
	 * 				if (name.compareTo(&quot;Agent To Enable&quot;) == 0) {
	 * 					agent.setEnabled(true);
	 * 					agent.save();
	 * 					msg = &quot;Agent found and enabled&quot;;
	 * 					break;
	 * 				}
	 * 			}
	 * 			System.out.println(msg);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isEnabled() throws NotesApiException;

	/**
	 * Indicates whether an agent is able to run.
	 * 
	 * @param value
	 *            Indicates whether an agent is able to run.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the agent can be run</li>
	 *              <li>false if the agent is disabled</li>
	 *              </ul>
	 * @usage This property is intended for use with scheduled agents, which can
	 *        be enabled and disabled. This property always returns true for
	 *        hidden agents and agents that are run from a menu.
	 * 
	 *        You must call {@link #save()} to make any change effective.
	 * 
	 *        If the agent is open in the UI, a change is not immediately
	 *        reflected. The agent must be closed and reopened.
	 * 
	 *        Access privileges and agent signing depend on whether user or
	 *        designer activation is in effect. See {@link #isActivatable()}.
	 * @example 1. This agent prints the status for each agent in the current
	 *          database: enabled or disabled.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			System.out.println(&quot;Agents in database:&quot;);
	 * 			Enumeration e = db.getAgents().elements();
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String an = agent.getName();
	 * 				if (agent.isEnabled())
	 * 					System.out.println(an + &quot; is enabled&quot;);
	 * 				else
	 * 					System.out.println(an + &quot; is disabled&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent enables the agent named "Agent To Enable" if it
	 *          exists in the current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			Enumeration e = db.getAgents().elements();
	 * 			String msg = &quot;Agent not found&quot;;
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String name = agent.getName();
	 * 				if (name.compareTo(&quot;Agent To Enable&quot;) == 0) {
	 * 					agent.setEnabled(true);
	 * 					agent.save();
	 * 					msg = &quot;Agent found and enabled&quot;;
	 * 					break;
	 * 				}
	 * 			}
	 * 			System.out.println(msg);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setEnabled(boolean value) throws NotesApiException;

	/**
	 * The name of the server on which an agent runs.
	 * 
	 * @return The name of the server on which an agent runs.
	 * @throws NotesApiException
	 * @usage The value returned by getServerName depends upon whether the agent
	 *        is scheduled:
	 * 
	 *        If the agent is scheduled, the property returns the name of the
	 *        server on which the scheduled agent runs. Since scheduled agents
	 *        can only run on a single replica of a database, you designate a
	 *        server name for the agent under Schedule in the Agent Properties
	 *        box. Therefore, the ServerName property may represent the parent
	 *        database's server, or it may represent a replica's server. If the
	 *        agent is not scheduled, this property returns an empty string. You
	 *        can set ServerName to the asterisk (*) to indicate that the agent
	 *        can run on any server. A null ServerName means the local
	 *        workstation. You must call {@link #save()} to make any change
	 *        effective.
	 * 
	 * @example 1. This agent prints the name and server name of the current
	 *          agent.
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
	 * 			String u = session.getServerName();
	 * 			System.out.println(&quot;Server name = &quot; + u);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the server name of the agent named
	 *          "Agent To Run" to the asterisk (*), indicating that the agent
	 *          can run on any server.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			Enumeration e = db.getAgents().elements();
	 * 			String msg = &quot;Agent not found&quot;;
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String name = agent.getName();
	 * 				if (name.compareTo(&quot;Agent To Run&quot;) == 0) {
	 * 					agent.setServerName(&quot;*&quot;);
	 * 					agent.save();
	 * 					msg = &quot;Agent server name set to *&quot;;
	 * 					break;
	 * 				}
	 * 			}
	 * 			System.out.println(msg);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getServerName() throws NotesApiException;

	/**
	 * The name of the server on which an agent runs.
	 * 
	 * @param serverName
	 *            The name of the server on which an agent runs.
	 * @throws NotesApiException
	 * @usage The value returned by getServerName depends upon whether the agent
	 *        is scheduled:
	 * 
	 *        If the agent is scheduled, the property returns the name of the
	 *        server on which the scheduled agent runs. Since scheduled agents
	 *        can only run on a single replica of a database, you designate a
	 *        server name for the agent under Schedule in the Agent Properties
	 *        box. Therefore, the ServerName property may represent the parent
	 *        database's server, or it may represent a replica's server. If the
	 *        agent is not scheduled, this property returns an empty string. You
	 *        can set ServerName to the asterisk (*) to indicate that the agent
	 *        can run on any server. A null ServerName means the local
	 *        workstation. You must call {@link #save()} to make any change
	 *        effective.
	 * @example 1. This agent prints the name and server name of the current
	 *          agent.
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
	 * 			String u = session.getServerName();
	 * 			System.out.println(&quot;Server name = &quot; + u);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent sets the server name of the agent named
	 *          "Agent To Run" to the asterisk (*), indicating that the agent
	 *          can run on any server.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			Enumeration e = db.getAgents().elements();
	 * 			String msg = &quot;Agent not found&quot;;
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String name = agent.getName();
	 * 				if (name.compareTo(&quot;Agent To Run&quot;) == 0) {
	 * 					agent.setServerName(&quot;*&quot;);
	 * 					agent.save();
	 * 					msg = &quot;Agent server name set to *&quot;;
	 * 					break;
	 * 				}
	 * 			}
	 * 			System.out.println(msg);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void setServerName(String serverName) throws NotesApiException;

	/**
	 * The text of the query used by an agent to select documents. In the Agent
	 * Properties box, a query is defined by the searches added to the agent
	 * using the Add Search button.
	 * 
	 * If no query is defined with the Add Search button, the Query property
	 * returns an empty string, even if the agent runs a formula that has its
	 * own SELECT statement or a script that selects specific documents.
	 * 
	 * @return The text of the query used by an agent to select documents
	 * @throws NotesApiException
	 * @usage Some sample results:
	 *        <ul>
	 *        <li>If an agent searches for documents that contain the word
	 *        "tulip," Query returns:
	 * 
	 *        <pre>
	 * (&quot;tulip&quot;)
	 * </pre>
	 * 
	 *        </li>
	 *        <li>If an agent searches for documents that contain the word tulip
	 *        and were created on September 19, 1996, Query returns:
	 * 
	 *        <pre>
	 * ("tulip") AND ([_CreationDate] = 09/19/96)
	 * </pre>
	 * 
	 *        </li>
	 *        <li>If an agent searches for documents that use the Response form,
	 *        Query returns:
	 * 
	 *        <pre>
	 * (([Form]="Response"))
	 * </pre>
	 * 
	 *        </li>
	 *        <li>If an agent searches for documents that use the Response form
	 *        and contain the phrase "mustard greens" in the Subject field,
	 *        Query returns:
	 * 
	 *        <pre>
	 * (([Form]="Response")) AND ([Subject] CONTAINS (mustard greens))
	 * </pre>
	 * 
	 *        </li>
	 *        </ul>
	 * @example This agent prints the name and query of every agent in the
	 *          current database
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			Enumeration e = db.getAgents().elements();
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				String an = agent.getName();
	 * 				String aq = agent.getQuery();
	 * 				if (aq.equals(&quot;&quot;))
	 * 					aq = &quot;None&quot;;
	 * 				System.out.println(an + &quot; - &quot; + aq);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getQuery() throws NotesApiException;

	/**
	 * The comment that describes an agent, as entered by the agent's designer
	 * 
	 * @return The comment that describes an agent, as entered by the agent's
	 *         designer
	 * @throws NotesApiException
	 * @example This agent prints the name and comment of the current agent.
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 			System.out.println(&quot;Comment: &quot; + agent.getComment());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getComment() throws NotesApiException;

	/**
	 * The database that contains an agent.
	 * 
	 * @return The database that contains an agent.
	 * @throws NotesApiException
	 * @example This agent prints the name of the database on which the agent is
	 *          running
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
	 * 			Database db = agent.getParent();
	 * 			System.out.println(&quot;Database on which this agent is running is '&quot;
	 * 					+ db.getTitle() + &quot;'&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	NotesDatabase getParent() throws NotesApiException;

	/**
	 * Indicates whether an agent is shared or private.
	 * 
	 * 
	 * 
	 * @return Indicates whether an agent is shared or private.
	 *         <ul>
	 *         <li>A shared agent is accessible to all users of a database and
	 *         is stored in the database.</li>
	 *         <li>A private agent is accessible only to its owner and is stored
	 *         in the owner's desktop file.</li>
	 *         </ul>
	 * 
	 *         Shared agents are sometimes called agents.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the agent is shared</li>
	 *              <li>false if the agent is private</li>
	 *              </ul>
	 */
	boolean isPublic() throws NotesApiException;

	/**
	 * The common name of the person who last modified and saved an agent.
	 * 
	 * @return The common name of the person who last modified and saved an
	 *         agent.
	 * @throws NotesApiException
	 * @usage If the owner's name is flat (non-hierarchical), the CommonOwner
	 *        name is the same as the Owner name.
	 * @example This agent prints the common owner name of the current agent.
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
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + agent.getName() + &quot;\&quot;&quot;);
	 * 			System.out.println(&quot;Common owner: &quot; + agent.getCommonOwner());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getCommonOwner() throws NotesApiException;

	/**
	 * Indicates when this agent runs.
	 * 
	 * @return Indicates when this agent runs.
	 * @throws NotesApiException
	 * @usage This property corresponds to the Trigger options in the Runtime
	 *        section of the Agent Properties box.
	 * 
	 *        This property determines the target possibilities. The
	 *        TRIGGER_AFTER_MAIL_DELIVERY, TRIGGER_BEFORE_MAIL_DELIVERY,
	 *        TRIGGER_DOC_PASTED, and TRIGGER_DOC_UPDATE triggers have only one
	 *        target, which returns TARGET_NONE.
	 * @legalValues For the "On event" Trigger option:
	 *              <ul>
	 *              <li>Agent.TRIGGER_AFTER_MAIL_DELIVERY
	 *              ("After new mail has arrived")</li>
	 *              <li>Agent.TRIGGER_BEFORE_MAIL_DELIVERY
	 *              ("Before new mail arrives")</li>
	 *              <li>Agent.TRIGGER_DOC_PASTED ("When documents are pasted")</li>
	 *              <li>Agent.TRIGGER_DOC_UPDATE
	 *              ("After documents are created or modified")</li>
	 *              <li>Agent.TRIGGER_MANUAL ("Action menu selection,"
	 *              "Agent list selection")</li>
	 *              <li>Agent.TRIGGER_NONE (Not used)</li>
	 *              <li>Agent.TRIGGER_SERVERSTART
	 *              ("When the Domino server starts")</li>
	 *              </ul>
	 *              For the "On schedule" Trigger option:
	 *              <ul>
	 *              <li>Agent.TRIGGER_SCHEDULED ("More than once a day,"
	 *              "Daily," "Weekly," "Monthly," or "Never")</li>
	 *              </ul>
	 * 
	 * @example This agent prints the target and trigger of each agent in the
	 *          current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Enumeration agents = db.getAgents().elements();
	 * 			while (agents.hasMoreElements()) {
	 * 				Agent agent = (Agent) agents.nextElement();
	 * 				String target = &quot;&quot;, trigger = &quot;&quot;;
	 * 				switch (agent.getTarget()) {
	 * 				case Agent.TARGET_ALL_DOCS:
	 * 					target = &quot;all documents&quot;;
	 * 				case Agent.TARGET_ALL_DOCS_IN_VIEW:
	 * 					target = &quot;all documents in view&quot;;
	 * 				case Agent.TARGET_NEW_DOCS:
	 * 					target = &quot;all new documents&quot;;
	 * 				case Agent.TARGET_NEW_OR_MODIFIED_DOCS:
	 * 					target = &quot;all new or modified documents&quot;;
	 * 				case Agent.TARGET_NONE:
	 * 					target = &quot;none&quot;;
	 * 				case Agent.TARGET_SELECTED_DOCS:
	 * 					target = &quot;selected documents&quot;;
	 * 				case Agent.TARGET_UNREAD_DOCS_IN_VIEW:
	 * 					target = &quot;unread documents in view&quot;;
	 * 				}
	 * 				switch (agent.getTrigger()) {
	 * 				case Agent.TRIGGER_AFTER_MAIL_DELIVERY:
	 * 					trigger = &quot;after mail delivery&quot;;
	 * 				case Agent.TRIGGER_BEFORE_MAIL_DELIVERY:
	 * 					trigger = &quot;before new mail&quot;;
	 * 				case Agent.TRIGGER_DOC_PASTED:
	 * 					trigger = &quot;document pasted&quot;;
	 * 				case Agent.TRIGGER_DOC_UPDATE:
	 * 					trigger = &quot;document updated&quot;;
	 * 				case Agent.TRIGGER_SERVERSTART:
	 * 					trigger = &quot;when server starts&quot;;
	 * 				case Agent.TRIGGER_MANUAL:
	 * 					trigger = &quot;manual&quot;;
	 * 				case Agent.TRIGGER_NONE:
	 * 					trigger = &quot;none&quot;;
	 * 				case Agent.TRIGGER_SCHEDULED:
	 * 					trigger = &quot;scheduled&quot;;
	 * 				}
	 * 				System.out.println(agent.getName() + &quot;: target is &quot; + target
	 * 						+ &quot;; trigger is &quot; + trigger);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int getTrigger() throws NotesApiException;

	/**
	 * Indicates on which documents this agent acts.
	 * 
	 * @return Indicates on which documents this agent acts.
	 * @throws NotesApiException
	 * @usage This property corresponds to the Target option in the Runtime
	 *        section of the Agent Properties box. The trigger limits the target
	 *        possibilities. The TARGET_NONE targets are the only possibilities
	 *        for their corresponding triggers.
	 * @legalValues <ul>
	 *              <li>Agent.TARGET_ALL_DOCS ("All documents in database")</li>
	 *              <li>Agent.TARGET_ALL_DOCS_IN_VIEW ("All documents in view")</li>
	 *              <li>Agent.TARGET_NEW_DOCS (Not used)</li>
	 *              <li>Agent.TARGET_NEW_OR_MODIFIED_DOCS
	 *              ("All new & modified documents")</li>
	 *              <li>Agent.TARGET_NONE ("Each incoming mail document,"
	 *              "Newly received mail documents," or "Pasted documents")</li>
	 *              <li>Agent.TARGET_SELECTED_DOCS ("All selected documents")</li>
	 *              <li>Agent.TARGET_UNREAD_DOCS_IN_VIEW
	 *              ("All unread documents in view")</li>
	 *              <li>Agent.TARGET_RUN_ONCE ("None")</li>
	 *              </ul>
	 * 
	 * @example This agent prints the target and trigger of each agent in the
	 *          current database.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Enumeration agents = db.getAgents().elements();
	 * 			while (agents.hasMoreElements()) {
	 * 				Agent agent = (Agent) agents.nextElement();
	 * 				String target = &quot;&quot;, trigger = &quot;&quot;;
	 * 				switch (agent.getTarget()) {
	 * 				case Agent.TARGET_ALL_DOCS:
	 * 					target = &quot;all documents&quot;;
	 * 				case Agent.TARGET_ALL_DOCS_IN_VIEW:
	 * 					target = &quot;all documents in view&quot;;
	 * 				case Agent.TARGET_NEW_DOCS:
	 * 					target = &quot;all new documents&quot;;
	 * 				case Agent.TARGET_NEW_OR_MODIFIED_DOCS:
	 * 					target = &quot;all new or modified documents&quot;;
	 * 				case Agent.TARGET_NONE:
	 * 					target = &quot;none&quot;;
	 * 				case Agent.TARGET_SELECTED_DOCS:
	 * 					target = &quot;selected documents&quot;;
	 * 				case Agent.TARGET_UNREAD_DOCS_IN_VIEW:
	 * 					target = &quot;unread documents in view&quot;;
	 * 				}
	 * 				switch (agent.getTrigger()) {
	 * 				case Agent.TRIGGER_AFTER_MAIL_DELIVERY:
	 * 					trigger = &quot;after mail delivery&quot;;
	 * 				case Agent.TRIGGER_BEFORE_MAIL_DELIVERY:
	 * 					trigger = &quot;before new mail&quot;;
	 * 				case Agent.TRIGGER_DOC_PASTED:
	 * 					trigger = &quot;document pasted&quot;;
	 * 				case Agent.TRIGGER_DOC_UPDATE:
	 * 					trigger = &quot;document updated&quot;;
	 * 				case Agent.TRIGGER_SERVERSTART:
	 * 					trigger = &quot;when server starts&quot;;
	 * 				case Agent.TRIGGER_MANUAL:
	 * 					trigger = &quot;manual&quot;;
	 * 				case Agent.TRIGGER_NONE:
	 * 					trigger = &quot;none&quot;;
	 * 				case Agent.TRIGGER_SCHEDULED:
	 * 					trigger = &quot;scheduled&quot;;
	 * 				}
	 * 				System.out.println(agent.getName() + &quot;: target is &quot; + target
	 * 						+ &quot;; trigger is &quot; + trigger);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	int getTarget() throws NotesApiException;

	/**
	 * Indicates whether an agent can run in the Notes client environment.
	 * 
	 * @return Indicates whether an agent can run in the Notes client
	 *         environment.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the agent can run in the Notes client
	 *              environment</li>
	 *              <li>false if the agent cannot run in the Notes client
	 *              environment</li>
	 *              </ul>
	 * @example This agent prints whether each agent in a database is a Notes
	 *          agent and/or a Web agent.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			System.out.println(&quot;Agents in database:&quot;);
	 * 			Enumeration e = db.getAgents().elements();
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				System.out.println(agent.getName());
	 * 				if (agent.isNotesAgent())
	 * 					System.out.println(&quot; is a Notes agent&quot;);
	 * 				else
	 * 					System.out.println(&quot; is not a Notes agent&quot;);
	 * 				if (agent.isWebAgent())
	 * 					System.out.println(&quot; is a Web agent&quot;);
	 * 				else
	 * 					System.out.println(&quot; is not a Web agent&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isNotesAgent() throws NotesApiException;

	/**
	 * Indicates whether an agent can run in a Web browser environment.
	 * 
	 * @return Indicates whether an agent can run in a Web browser environment.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true if the agent can run in a Web browser environment</li>
	 *              <li>false if the agent cannot run in a Web browser
	 *              environment</li>
	 *              </ul>
	 * @example This agent prints whether each agent in a database is a Notes
	 *          agent and/or a Web agent.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.*;
	 * 
	 * class JavaAgent extends AgentBase {
	 * 	void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Vector agents = db.getAgents();
	 * 			System.out.println(&quot;Agents in database:&quot;);
	 * 			Enumeration e = db.getAgents().elements();
	 * 			while (e.hasMoreElements()) {
	 * 				Agent agent = (Agent) e.nextElement();
	 * 				System.out.println(agent.getName());
	 * 				if (agent.isNotesAgent())
	 * 					System.out.println(&quot; is a Notes agent&quot;);
	 * 				else
	 * 					System.out.println(&quot; is not a Notes agent&quot;);
	 * 				if (agent.isWebAgent())
	 * 					System.out.println(&quot; is a Web agent&quot;);
	 * 				else
	 * 					System.out.println(&quot; is not a Web agent&quot;);
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean isWebAgent() throws NotesApiException;

	/**
	 * Returns the Domino URL for its parent object when called in the following
	 * classes:
	 * 
	 * Agent, Database, Document, Form, Session (returns an empty string if
	 * called locally), View
	 * 
	 * @return Returns the Domino URL for its parent object
	 * @throws NotesApiException
	 */
	String getURL() throws NotesApiException;

	/**
	 * The Domino URL of an agent when Notes protocols are in effect
	 * 
	 * @return The Domino URL of an agent when Notes protocols are in effect
	 * @throws NotesApiException
	 * @usage If HTTP protocols are not available, this property returns an
	 *        empty string. See {@link #getHttpURL()}.
	 * 
	 *        See {@link NotesSession#resolve(String)} in Session for additional
	 *        information and examples.
	 * @example This agent gets the Notes and HTTP URLs for the current agent.
	 *          The agent varies the display depending on whether access is
	 *          through Notes (the HTTP URL is blank) or HTTP protocols
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.io.PrintWriter;
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
	String getNotesURL() throws NotesApiException;

	/**
	 * The Domino URL of an agent when HTTP protocols are in effect.
	 * 
	 * @return The Domino URL of an agent when HTTP protocols are in effect.
	 * @throws NotesApiException
	 * @usage If HTTP protocols are not available, this property returns an
	 *        empty string. See {@link #getNotesURL()}.
	 * 
	 *        See {@link NotesSession#resolve(String)} in Session for additional
	 *        information and examples.
	 * @example This agent gets the Notes and HTTP URLs for the current agent.
	 *          The agent varies the display depending on whether access is
	 *          through Notes (the HTTP URL is blank) or HTTP protocols
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.io.PrintWriter;
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
	String getHttpURL() throws NotesApiException;

	/**
	 * Returns the NoteID of a document passed in by {@link #run()} or
	 * {@link #runOnServer(String)}.
	 * 
	 * @return Returns the NoteID of a document passed in by {@link #run()} or
	 *         {@link #runOnServer(String)}.
	 * @throws NotesApiException
	 * @usage Use {@link NotesDatabase#getDocumentByID(String)} in Database to
	 *        get a document through its NoteID.
	 * @example 1. This agent runs the agent named "Agent to be run Java."
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
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(&quot;Body&quot;,
	 * 					&quot;The agent is running as &quot; + session.getUserName());
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          2. This agent runs the "Agent to be run parameter Java" agent
	 *          passing it the NoteID of a newly created document
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
	 *          Below is "Agent to be run parameter Java." It accesses the
	 *          passed NoteID through getParameterDocID, accesses the referenced
	 *          document, and removes it:
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			// Get document used for passing data
	 * 			Document doc = db.getDocumentByID(agent.getParameterDocID());
	 * 			// Send mail containing passed data
	 * 			Document memo = db.createDocument();
	 * 			memo.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			memo.appendItemValue(&quot;Subject&quot;, &quot;Message from Java agent&quot;);
	 * 			memo.appendItemValue(
	 * 					&quot;Body&quot;,
	 * 					&quot;The agent was started by &quot;
	 * 							+ doc.getItemValueString(&quot;TriggerUserName&quot;));
	 * 			memo.send(session.getUserName());
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	String getParameterDocID() throws NotesApiException;

	/**
	 * Indicates whether user activation is in effect when enabling or disabling
	 * a scheduled agent.
	 * 
	 * @return Indicates whether user activation is in effect when enabling or
	 *         disabling a scheduled agent.
	 * @throws NotesApiException
	 * @legalValues <ul>
	 *              <li>true to indicate that user activation is in effect</li>
	 *              <li>false to indicate that user activation is not in effect</li>
	 *              </ul>
	 * @usage This property, intended for use with scheduled agents, always
	 *        returns true for hidden agents and agents run from a menu.
	 * 
	 *        "Allow editor level user activation" on the Security tab regulates
	 *        this property:
	 * 
	 *        If checked, user activation is in effect. Editor access is
	 *        required to enable or disable an agent, and the agent signature
	 *        does not change. If not checked, Designer access is required to
	 *        enable or disable the agent, and the signature changes to that of
	 *        the user enabling or disabling the agent. User activation is new
	 *        with Release 6. R5.0.7 and earlier releases do not recognize
	 *        changes made with "Allow editor level user activation" checked.
	 * 
	 *        You can enable and disable agents with
	 *        {@link #setEnabled(boolean)}.
	 * @example This agent enables those scheduled agents in the current
	 *          database that are activatable and disables those that are not.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
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
	 * 			Vector agents = db.getAgents();
	 * 			for (int i = 0; i &lt; agents.size(); i++) {
	 * 				Agent agent = (Agent) agents.elementAt(i);
	 * 				if (agent.getTrigger() == Agent.TRIGGER_SCHEDULED) {
	 * 					if (agent.isActivatable())
	 * 						agent.setEnabled(true);
	 * 					else
	 * 						agent.setEnabled(false);
	 * 					agent.save();
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
	boolean isActivatable() throws NotesApiException;

	/**
	 * Name of the user under whose identity the agent runs
	 * 
	 * @return Name of the user under whose identity the agent runs
	 * @throws NotesApiException
	 * @usage This property reflects the value of "Run on behalf of" under the
	 *        security tab of the agent builder.
	 * 
	 *        If this property is an empty string, the agent runs on behalf of
	 *        the owner of the agent or the browser login user (if the agent is
	 *        run from a browser and "Run as web user" is checked).
	 * @example This agent sends mail with ownership and user information,
	 *          including on whose behalf the agent runs
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
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
	 * 			Agent agent = agentContext.getCurrentAgent();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Document doc = db.createDocument();
	 * 			doc.appendItemValue(&quot;Form&quot;, &quot;Memo&quot;);
	 * 			doc.appendItemValue(&quot;SendTo&quot;, agentContext.getEffectiveUserName());
	 * 			doc.appendItemValue(&quot;Subject&quot;,
	 * 					&quot;Owner, user, effective user, on behalf of&quot;);
	 * 			RichTextItem body = doc.createRichTextItem(&quot;Body&quot;);
	 * 			body.appendText(&quot;Owner = &quot; + agent.getOwner());
	 * 			body.addNewLine(1);
	 * 			body.appendText(&quot;User= &quot; + session.getUserName());
	 * 			body.addNewLine(1);
	 * 			body.appendText(&quot;Effective user = &quot;
	 * 					+ agentContext.getEffectiveUserName());
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
	String getOnBehalfOf() throws NotesApiException;

	/**
	 * The names of the holders of a lock.
	 * 
	 * @return The names of the holders of a lock.
	 * @throws NotesApiException
	 * @usage If the agent is locked, the vector contains the names of the lock
	 *        holders. The agent can be locked by one or more users or groups.
	 * 
	 *        If the agent is not locked, the vector contains one element whose
	 *        value is an empty string ("").
	 * @example This view action displays the lock holders for the agent named
	 *          "Main Agent".
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
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
	Vector<String> getLockHolders() throws NotesApiException;

	/**
	 * Locks an agent.
	 * 
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method:</ul> <li>Places a persistent lock if the
	 *        administration (master lock) server is available.</li> <li>Places
	 *        a provisional lock if the administration server is not available
	 *        and the second parameter is true.</li> <li>Throws an exception if
	 *        the administration server is not available and the second
	 *        parameter is false.</li></ul> The following actions occur
	 *        depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          allowed if the administration server is not available.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lock(&quot;Guys&quot;, true))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lock() throws NotesApiException;

	/**
	 * Locks an agent.
	 * 
	 * @param provisionalok
	 *            <ul>
	 *            <li>true to permit the placement of a provisional lock</li>
	 *            <li>false (default) to not permit a provisional lock</li>
	 *            </ul>
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method:</ul> <li>Places a persistent lock if the
	 *        administration (master lock) server is available.</li> <li>Places
	 *        a provisional lock if the administration server is not available
	 *        and the second parameter is true.</li> <li>Throws an exception if
	 *        the administration server is not available and the second
	 *        parameter is false.</li></ul> The following actions occur
	 *        depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          allowed if the administration server is not available.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lock(&quot;Guys&quot;, true))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lock(boolean provisionalok) throws NotesApiException;

	/**
	 * Locks an agent.
	 * 
	 * @param name
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method:</ul> <li>Places a persistent lock if the
	 *        administration (master lock) server is available.</li> <li>Places
	 *        a provisional lock if the administration server is not available
	 *        and the second parameter is true.</li> <li>Throws an exception if
	 *        the administration server is not available and the second
	 *        parameter is false.</li></ul> The following actions occur
	 *        depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          allowed if the administration server is not available.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lock(&quot;Guys&quot;, true))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lock(String name) throws NotesApiException;

	/**
	 * Locks an agent.
	 * 
	 * @param name
	 *            The user name
	 * @param provisionalok
	 *            <ul>
	 *            <li>true to permit the placement of a provisional lock</li>
	 *            <li>false (default) to not permit a provisional lock</li>
	 *            </ul>
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method:</ul> <li>Places a persistent lock if the
	 *        administration (master lock) server is available.</li> <li>Places
	 *        a provisional lock if the administration server is not available
	 *        and the second parameter is true.</li> <li>Throws an exception if
	 *        the administration server is not available and the second
	 *        parameter is false.</li></ul> The following actions occur
	 *        depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          allowed if the administration server is not available.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lock(&quot;Guys&quot;, true))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lock(String name, boolean provisionalok) throws NotesApiException;

	/**
	 * Locks an agent.
	 * 
	 * @param names
	 *            The names of the lock holders. Each lock holder must be a user
	 *            or group. Defaults to one lock holder: the effective user. The
	 *            empty string ("") is not permitted.
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method:</ul> <li>Places a persistent lock if the
	 *        administration (master lock) server is available.</li> <li>Places
	 *        a provisional lock if the administration server is not available
	 *        and the second parameter is true.</li> <li>Throws an exception if
	 *        the administration server is not available and the second
	 *        parameter is false.</li></ul> The following actions occur
	 *        depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          allowed if the administration server is not available.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lock(&quot;Guys&quot;, true))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lock(Vector<String> names) throws NotesApiException;

	/**
	 * Locks an agent.
	 * 
	 * @param names
	 *            The names of the lock holders. Each lock holder must be a user
	 *            or group. Defaults to one lock holder: the effective user. The
	 *            empty string ("") is not permitted.
	 * @param provisionalok
	 *            <ul>
	 *            <li>true to permit the placement of a provisional lock</li>
	 *            <li>false (default) to not permit a provisional lock</li>
	 *            </ul>
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method:</ul> <li>Places a persistent lock if the
	 *        administration (master lock) server is available.</li> <li>Places
	 *        a provisional lock if the administration server is not available
	 *        and the second parameter is true.</li> <li>Throws an exception if
	 *        the administration server is not available and the second
	 *        parameter is false.</li></ul> The following actions occur
	 *        depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          allowed if the administration server is not available.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lock(&quot;Guys&quot;, true))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lock(Vector<String> names, boolean provisionalok)
			throws NotesApiException;

	/**
	 * Locks an agent provisionally.
	 * 
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage IsDesignLockingEnabled in Database must be true or this method
	 *        throws an exception.
	 * 
	 *        The following actions occur depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * 
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          placed.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lockProvisional(&quot;Guys&quot;))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lockProvisional() throws NotesApiException;

	/**
	 * Locks an agent provisionally.
	 * 
	 * @param name
	 *            The user name
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage IsDesignLockingEnabled in Database must be true or this method
	 *        throws an exception.
	 * 
	 *        The following actions occur depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * 
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          placed.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lockProvisional(&quot;Guys&quot;))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lockProvisional(String name) throws NotesApiException;

	/**
	 * Locks an agent provisionally.
	 * 
	 * @param names
	 *            The names of the lock holders. Each lock holder must be a user
	 *            or group. Defaults to one lock holder: the effective user. The
	 *            empty string ("") is not permitted
	 * @return <ul>
	 *         <li>true if the lock is placed</li>
	 *         <li>false if the lock is not placed</li>
	 *         </ul>
	 * @throws NotesApiException
	 * @usage IsDesignLockingEnabled in Database must be true or this method
	 *        throws an exception.
	 * 
	 *        The following actions occur depending on the current lock status:
	 *        <ul>
	 *        <li>If the agent is not locked, this method places the lock and
	 *        returns true.</li>
	 *        <li>If the agent is locked and the current user is one of the lock
	 *        holders, this method returns true.</li>
	 *        <li>If the agent is locked and the current user is not one of the
	 *        lock holders, this method returns false.</li>
	 *        </ul>
	 *        If the agent is modified by another user before the lock can be
	 *        placed, this method throws an exception.
	 * 
	 * @example This view action attempts to lock the agent named "Main Agent"
	 *          for all members of the "Guys" group. Locking is successful if
	 *          the agent is not yet locked, or the agent is locked but the
	 *          effective user is a member of Guys. A provisional lock is
	 *          placed.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and lock
	 * 				// Not locked if return is false or exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				if (agent.lockProvisional(&quot;Guys&quot;))
	 * 					System.out.println(&quot;Agent locked&quot;);
	 * 				else
	 * 					System.out.println(&quot;Agent not locked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			if (e.id == NotesError.NOTES_ERR_LOCKED)
	 * 				System.out.println(&quot;Agent not locked (exception)&quot;);
	 * 			else
	 * 				e.printStackTrace();
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	boolean lockProvisional(Vector<String> names) throws NotesApiException;

	/**
	 * Unlocks an agent.
	 * 
	 * @throws NotesApiException
	 * @usage {@link NotesDatabase#isDesignLockingEnabled()} in Database must be
	 *        true or this method throws an exception.
	 * 
	 *        This method throws an exception if the current user is not one of
	 *        the lock holders and does not have lock breaking authority.
	 * 
	 * @example This example attempts to unlock the agent named "Main Agent."
	 *          Unlocking is successful if the effective user is one of the lock
	 *          holders.
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
	 * 
	 * 			// Design locking must be enabled
	 * 			if (db.isDesignLockingEnabled()) {
	 * 				// Get agent and unlock
	 * 				// Not unlocked if exception thrown
	 * 				Agent agent = db.getAgent(&quot;Main Agent&quot;);
	 * 				agent.unlock();
	 * 				System.out.println(&quot;Agent unlocked&quot;);
	 * 			} else
	 * 				System.out.println(&quot;Design locking not enabled&quot;);
	 * 
	 * 		} catch (NotesException e) {
	 * 			System.out.println(e.id + &quot;Agent not unlocked&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	void unlock() throws NotesApiException;

	/**
	 * Indicates whether a design refresh or replace can overwrite an agent.
	 * 
	 * @return Indicates whether a design refresh or replace can overwrite an
	 *         agent.
	 *         <ul>
	 *         <li>true to indicate that the agent cannot be refreshed</li>
	 *         <li>false (default) to indicate that the agent can be refreshed</li>
	 *         </ul>
	 * @throws NotesApiException
	 */
	boolean isProhibitDesignUpdate() throws NotesApiException;

	/**
	 * Indicates whether a design refresh or replace can overwrite an agent.
	 * 
	 * @param flag
	 *            Indicates whether a design refresh or replace can overwrite an
	 *            agent.
	 *            <ul>
	 *            <li>true to indicate that the agent cannot be refreshed</li>
	 *            <li>false (default) to indicate that the agent can be
	 *            refreshed</li>
	 *            </ul>
	 * @throws NotesApiException
	 */
	void setProhibitDesignUpdate(boolean flag) throws NotesApiException;

}
