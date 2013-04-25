package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents the agent environment of the current program, if an agent is
 * running it.
 * 
 * @author Sven Dreher
 * @access Use {@link NotesSession#getAgentContext()} in Session to get the
 *         AgentContext object for the current agent.
 * @usage You can create a Java agent by importing files or by writing and
 *        compiling the code in Lotus Domino Designer. In the latter case, Lotus
 *        Domino Designer provides template code that creates a Session object
 *        named session and an AgentContext object named agentContext. The
 *        complete template code appears as follows:
 * 
 *        <pre>
 * import lotus.domino.*;
 * 
 * public class JavaAgent extends AgentBase {
 * 	public void NotesMain() {
 * 		try {
 * 			Session session = getSession();
 * 			AgentContext agentContext = session.getAgentContext();
 * 			// (Your code goes here)
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * @example This agent gets the context for the current agent, then gets the
 *          agent itself and prints the agent name and comment.
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
 * 			String name = agent.getName();
 * 			String comment = agent.getComment();
 * 			if (comment.equals(&quot;&quot;))
 * 				comment = &quot;No comment&quot;;
 * 			System.out.println(&quot;Current agent: \&quot;&quot; + name + &quot;\&quot;&quot;);
 * 			System.out.println(&quot;Comment: \&quot;&quot; + comment + &quot;\&quot;&quot;);
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 */
public interface NotesAgentContext extends NotesBase {

	/**
	 * Marks a document as processed by an agent.
	 * 
	 * @param doc
	 *            The document to be marked as processed. Cannot be null.
	 * @throws NotesApiException
	 * 
	 * @usage Use this method in conjunction with
	 *        {@link #getUnprocessedDocuments()},
	 *        {@link #unprocessedFTSearch(String, int)}, and
	 *        {@link #unprocessedSearch(String, NotesDateTime, int)} in an agent
	 *        that runs on all new and modified documents.
	 * 
	 *        This method marks a document so subsequent invocations of the same
	 *        agent recognize the document as processed. You must explicitly
	 *        mark a document with this method. No implicit marking occurs in a
	 *        Java agent.
	 * 
	 *        If a marked document is modified, it is unmarked and will be
	 *        processed by the next invocation of the agent.
	 * 
	 *        This method marks a document as processed only for the particular
	 *        agent from which it is called. Using this method in one agent has
	 *        no effect on the documents that another agent processes.
	 * 
	 * @example This program is for an agent that runs on newly created and
	 *          modified documents since the last run. The program gets the
	 *          unprocessed documents, prints each Subject item, and marks each
	 *          document as processed. The first time the agent runs,
	 *          getUnprocessedDocuments returns all of the documents in the
	 *          database. Thereafter, getUnprocessedDocuments returns those
	 *          documents that updateProcessedDoc has not touched.
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
	 * 			DocumentCollection dc = agentContext.getUnprocessedDocuments();
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 				agentContext.updateProcessedDoc(doc);
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract void updateProcessedDoc(NotesDocument doc)
			throws NotesApiException;

	/**
	 * Given a full-text query, returns documents in a database:
	 * <ul>
	 * <li>That the current agent considers to be unprocessed</li>
	 * <li>And that match the query</li>
	 * </ul>
	 * 
	 * @param query
	 *            The full-text query.
	 * @param maxDocs
	 *            The maximum number of documents you want returned; 0 means all
	 *            matching documents.
	 * @return A sorted collection of documents that are not yet processed and
	 *         match the query.
	 * @throws NotesApiException
	 * 
	 * @usage This method is valid only for agents.<br>
	 * 
	 *        <b>How does it work?</b><br>
	 *        This method works in two parts:<br>
	 * 
	 *        <ul>
	 *        <li>First, it finds a collection of documents that the agent
	 *        considers to be "unprocessed." The type of agent determines which
	 *        documents are considered to be unprocessed. This document
	 *        collection is identical to that returned by
	 *        getUnprocessedDocuments.</li>
	 *        <li>Second, it conducts a full-text search on the unprocessed
	 *        documents and returns a collection of those documents that match
	 *        the query.</li>
	 *        </ul>
	 *        For example, in an agent that runs on all selected documents in a
	 *        view, getUnprocessedFTSearch searches only the selected documents
	 *        and returns those that match the query. In an agent that runs on
	 *        all new and modified documents since the last run,
	 *        getUnprocessedFTSearch searches only the documents that were not
	 *        marked by updateProcessedDoc, and returns those that match the
	 *        query.<br>
	 * <br>
	 *        <b>What documents are returned?</b><br>
	 *        The following table describes the documents that are returned by
	 *        unprocessedFTSearch. Document selection occurs once, before the
	 *        agent runs.
	 * 
	 *        <table border="1">
	 *        <tr>
	 *        <th>Agent runs on:</th>
	 *        <th>UnprocessedDocuments returns documents that meet all of these
	 *        requirements:</th>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in database</td>
	 *        <td>Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All new & modified documents</td>
	 *        <td>Not processed by this agent with updateProcessedDoc<br>
	 * 
	 *        Created or modified since the agent last ran<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All unread documents in view</td>
	 *        <td>Are unread and in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in view</td>
	 *        <td>Are in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All selected documents</td>
	 *        <td>Are selected in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>None</td>
	 *        <td>Is the current document only</td>
	 *        </tr>
	 *        </table>
	 * 
	 *        <b>Using updateProcessedDoc</b><br>
	 *        For agents that run on new and modified documents, you must use
	 *        updateProcessedDoc to mark each document as "processed," which
	 *        ensures that a document gets processed by the agent only once
	 *        (unless it's modified again). If you do not call this method for
	 *        each document, the agent processes the same documents the next
	 *        time it runs.<br>
	 * 
	 *        The updateProcessedDoc method marks a document as processed only
	 *        for the particular agent from which it is called. Using
	 *        updateProcessedDoc in one agent has no effect on the documents
	 *        that another agent processes.<br>
	 * 
	 *        In all other agents and view actions, updateProcessedDoc has no
	 *        effect.<br>
	 * 
	 *        <b>View actions</b><br>
	 *        When used in a view action, unprocessedFTSearch returns the same
	 *        documents as an agent that runs on selected documents.<br>
	 * 
	 *        <b>Full-text indexes</b><br>
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use isFTIndexed. To create
	 *        an index on a local database, use updateFTIndex.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        <b>Options</b><br>
	 *        If you don't specify any sort options, the documents are sorted by
	 *        relevance score. When the collection is sorted by relevance the
	 *        highest relevance appears first. To access the relevance score of
	 *        each document in the collection, use FTSearchScore in Document.<br>
	 * 
	 *        If you ask for a sort by date, you don't get relevance scores. If
	 *        you pass the resulting DocumentCollection to a Newsletter object,
	 *        it formats its doclink report with either the document creation
	 *        date or the relevance score, depending on the sort options.<br>
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
	 *        both of which include Lotus Notes.<br>
	 * 
	 * @example This agent runs on all or selected documents. It puts all
	 *          documents that contain the word "botany" in the folder
	 *          "Botanist's Delight."
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
	 * 			DocumentCollection dc = agentContext.unprocessedFTSearch(&quot;botany&quot;,
	 * 					0, Database.FT_SCORES, Database.FT_STEMS);
	 * 			System.out.println(&quot;Count = &quot; + dc.getCount());
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				doc.putInFolder(&quot;Botanist's Delight&quot;);
	 * 				System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 * 
	 */
	public abstract NotesDocumentCollection unprocessedFTSearch(String query,
			int maxDocs) throws NotesApiException;

	/**
	 * Given a full-text query, returns documents in a database:
	 * <ul>
	 * <li>That the current agent considers to be unprocessed</li>
	 * <li>And that match the query</li>
	 * </ul>
	 * 
	 * @param query
	 *            The full-text query.
	 * @param maxDocs
	 *            The maximum number of documents you want returned; 0 means all
	 *            matching documents.
	 * @param sortOpt
	 *            Use one of these to specify a sorting option:
	 * 
	 *            <ul>
	 *            <li>Database.FT_SCORES (default) sorts by relevance score with
	 *            highest relevance first.</li>
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
	 *            OR operation
	 *            <ul>
	 *            <li>Database.FT_DATABASE includes Lotus Domino databases in
	 *            the search scope.</li>
	 *            <li>Database.FT_FILESYSTEM includes files other than Lotus
	 *            Domino databases in the search scope.</li>
	 *            <li>Database.FT_FUZZY specifies a fuzzy search.</li>
	 *            <li>Database.FT_STEMS uses stem words as the basis of the
	 *            search.</li>
	 *            </ul>
	 * @return A sorted collection of documents that are not yet processed and
	 *         match the query.
	 * @throws NotesApiException
	 * 
	 * @usage This method is valid only for agents.<br>
	 * 
	 *        <b>How does it work?</b><br>
	 *        This method works in two parts:<br>
	 * 
	 *        <ul>
	 *        <li>First, it finds a collection of documents that the agent
	 *        considers to be "unprocessed." The type of agent determines which
	 *        documents are considered to be unprocessed. This document
	 *        collection is identical to that returned by
	 *        getUnprocessedDocuments.</li>
	 *        <li>Second, it conducts a full-text search on the unprocessed
	 *        documents and returns a collection of those documents that match
	 *        the query.</li>
	 *        </ul>
	 *        For example, in an agent that runs on all selected documents in a
	 *        view, getUnprocessedFTSearch searches only the selected documents
	 *        and returns those that match the query. In an agent that runs on
	 *        all new and modified documents since the last run,
	 *        getUnprocessedFTSearch searches only the documents that were not
	 *        marked by updateProcessedDoc, and returns those that match the
	 *        query.<br>
	 * <br>
	 *        <b>What documents are returned?</b><br>
	 *        The following table describes the documents that are returned by
	 *        unprocessedFTSearch. Document selection occurs once, before the
	 *        agent runs.
	 * 
	 *        <table border="1">
	 *        <tr>
	 *        <th>Agent runs on:</th>
	 *        <th>UnprocessedDocuments returns documents that meet all of these
	 *        requirements:</th>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in database</td>
	 *        <td>Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All new & modified documents</td>
	 *        <td>Not processed by this agent with updateProcessedDoc<br>
	 * 
	 *        Created or modified since the agent last ran<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All unread documents in view</td>
	 *        <td>Are unread and in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in view</td>
	 *        <td>Are in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All selected documents</td>
	 *        <td>Are selected in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>None</td>
	 *        <td>Is the current document only</td>
	 *        </tr>
	 *        </table>
	 * 
	 *        <b>Using updateProcessedDoc</b><br>
	 *        For agents that run on new and modified documents, you must use
	 *        updateProcessedDoc to mark each document as "processed," which
	 *        ensures that a document gets processed by the agent only once
	 *        (unless it's modified again). If you do not call this method for
	 *        each document, the agent processes the same documents the next
	 *        time it runs.<br>
	 * 
	 *        The updateProcessedDoc method marks a document as processed only
	 *        for the particular agent from which it is called. Using
	 *        updateProcessedDoc in one agent has no effect on the documents
	 *        that another agent processes.<br>
	 * 
	 *        In all other agents and view actions, updateProcessedDoc has no
	 *        effect.<br>
	 * 
	 *        <b>View actions</b><br>
	 *        When used in a view action, unprocessedFTSearch returns the same
	 *        documents as an agent that runs on selected documents.<br>
	 * 
	 *        <b>Full-text indexes</b><br>
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use isFTIndexed. To create
	 *        an index on a local database, use updateFTIndex.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        <b>Options</b><br>
	 *        If you don't specify any sort options, the documents are sorted by
	 *        relevance score. When the collection is sorted by relevance the
	 *        highest relevance appears first. To access the relevance score of
	 *        each document in the collection, use FTSearchScore in Document.<br>
	 * 
	 *        If you ask for a sort by date, you don't get relevance scores. If
	 *        you pass the resulting DocumentCollection to a Newsletter object,
	 *        it formats its doclink report with either the document creation
	 *        date or the relevance score, depending on the sort options.<br>
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
	 *        both of which include Lotus Notes.<br>
	 * 
	 * @example This agent runs on all or selected documents. It puts all
	 *          documents that contain the word "botany" in the folder
	 *          "Botanist's Delight."
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
	 * 			DocumentCollection dc = agentContext.unprocessedFTSearch(&quot;botany&quot;,
	 * 					0, Database.FT_SCORES, Database.FT_STEMS);
	 * 			System.out.println(&quot;Count = &quot; + dc.getCount());
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				doc.putInFolder(&quot;Botanist's Delight&quot;);
	 * 				System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 * 
	 */
	public abstract NotesDocumentCollection unprocessedFTSearch(String query,
			int maxDocs, int sortOpt, int otherOpt) throws NotesApiException;

	/**
	 * Given a full-text query, returns documents in a database:
	 * 
	 * <ul>
	 * <li>That the current agent considers to be unprocessed</li>
	 * <li>And that match the query</li>
	 * </ul>
	 * 
	 * @param query
	 *            The full-text query.
	 * @param maxDocs
	 *            The maximum number of documents you want returned; 0 means all
	 *            matching documents.
	 * @param start
	 *            The starting document to return.
	 * @return A sorted collection of documents that are not yet processed and
	 *         match the query.
	 * 
	 * @throws NotesApiException
	 * 
	 * @usage This method is valid only for agents.<br>
	 * 
	 *        <b>How does it work?</b><br>
	 *        This method works in two parts:<br>
	 * 
	 *        <ul>
	 *        <li>First, it finds a collection of documents that the agent
	 *        considers to be "unprocessed." The type of agent determines which
	 *        documents are considered to be unprocessed. This document
	 *        collection is identical to that returned by
	 *        getUnprocessedDocuments.</li>
	 *        <li>Second, it conducts a full-text search on the unprocessed
	 *        documents and returns a collection of those documents that match
	 *        the query.</li>
	 *        </ul>
	 *        For example, in an agent that runs on all selected documents in a
	 *        view, getUnprocessedFTSearch searches only the selected documents
	 *        and returns those that match the query. In an agent that runs on
	 *        all new and modified documents since the last run,
	 *        getUnprocessedFTSearch searches only the documents that were not
	 *        marked by updateProcessedDoc, and returns those that match the
	 *        query.<br>
	 * <br>
	 *        <b>What documents are returned?</b><br>
	 *        The following table describes the documents that are returned by
	 *        unprocessedFTSearch. Document selection occurs once, before the
	 *        agent runs.
	 * 
	 *        <table border="1">
	 *        <tr>
	 *        <th>Agent runs on:</th>
	 *        <th>UnprocessedDocuments returns documents that meet all of these
	 *        requirements:</th>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in database</td>
	 *        <td>Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All new & modified documents</td>
	 *        <td>Not processed by this agent with updateProcessedDoc<br>
	 * 
	 *        Created or modified since the agent last ran<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All unread documents in view</td>
	 *        <td>Are unread and in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in view</td>
	 *        <td>Are in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All selected documents</td>
	 *        <td>Are selected in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>None</td>
	 *        <td>Is the current document only</td>
	 *        </tr>
	 *        </table>
	 * 
	 *        <b>Using updateProcessedDoc</b><br>
	 *        For agents that run on new and modified documents, you must use
	 *        updateProcessedDoc to mark each document as "processed," which
	 *        ensures that a document gets processed by the agent only once
	 *        (unless it's modified again). If you do not call this method for
	 *        each document, the agent processes the same documents the next
	 *        time it runs.<br>
	 * 
	 *        The updateProcessedDoc method marks a document as processed only
	 *        for the particular agent from which it is called. Using
	 *        updateProcessedDoc in one agent has no effect on the documents
	 *        that another agent processes.<br>
	 * 
	 *        In all other agents and view actions, updateProcessedDoc has no
	 *        effect.<br>
	 * 
	 *        <b>View actions</b><br>
	 *        When used in a view action, unprocessedFTSearch returns the same
	 *        documents as an agent that runs on selected documents.<br>
	 * 
	 *        <b>Full-text indexes</b><br>
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use isFTIndexed. To create
	 *        an index on a local database, use updateFTIndex.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        <b>Options</b><br>
	 *        If you don't specify any sort options, the documents are sorted by
	 *        relevance score. When the collection is sorted by relevance the
	 *        highest relevance appears first. To access the relevance score of
	 *        each document in the collection, use FTSearchScore in Document.<br>
	 * 
	 *        If you ask for a sort by date, you don't get relevance scores. If
	 *        you pass the resulting DocumentCollection to a Newsletter object,
	 *        it formats its doclink report with either the document creation
	 *        date or the relevance score, depending on the sort options.<br>
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
	 *        both of which include Lotus Notes.<br>
	 * 
	 * @example This agent, which runs on selected documents, returns the
	 *          selected documents that contain a specified string, in groups of
	 *          eight.
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
	 * 			// Get query string and put in quotes
	 * 			String query = &quot;foo&quot;;
	 * 			query = &quot;\&quot;&quot; + query + &quot;\&quot;&quot;;
	 * 			// Get first 8 documents that match the query
	 * 			int start = 1;
	 * 			DocumentCollection dc = agentContext.unprocessedFTSearchRange(
	 * 					query, 8, Database.FT_SCORES, Database.FT_STEMS, start);
	 * 			while (dc.getCount() &gt; 0) {
	 * 				System.out.println(&quot;Documents &quot; + start + &quot; though &quot;
	 * 						+ (start + dc.getCount() - 1));
	 * 				Document doc = dc.getFirstDocument();
	 * 				while (doc != null) {
	 * 					System.out
	 * 							.println(&quot;\t&quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 					doc = dc.getNextDocument(doc);
	 * 				}
	 * 				// Get next 8 documents that match query
	 * 				start = start + 8;
	 * 				dc = agentContext.unprocessedFTSearchRange(query, 8,
	 * 						Database.FT_SCORES, Database.FT_FUZZY, start);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection unprocessedFTSearchRange(
			String query, int maxDocs, int start) throws NotesApiException;

	/**
	 * Given a full-text query, returns documents in a database:
	 * 
	 * <ul>
	 * <li>That the current agent considers to be unprocessed</li>
	 * <li>And that match the query</li>
	 * </ul>
	 * 
	 * @param query
	 *            The full-text query.
	 * @param maxdocs
	 *            The maximum number of documents you want returned; 0 means all
	 *            matching documents.
	 * @param sortopt
	 *            Use one of these to specify a sorting option:
	 * 
	 *            <ul>
	 *            <li>Database.FT_SCORES (default) sorts by relevance score with
	 *            highest relevance first.</li>
	 *            <li>Database.FT_DATECREATED_DES sorts by document creation
	 *            date in descending order.</li>
	 *            <li>Database.FT_DATECREATED_ASC sorts by document creation
	 *            date in ascending order.</li>
	 *            <li>Database.FT_DATE_DES sorts by document date in descending
	 *            order.</li>
	 *            <li>Database.FT_DATE_ASC sorts by document date in ascending
	 *            order.</li>
	 *            </ul>
	 * @param otheropt
	 *            Integer. Use the following constants to specify additional
	 *            search options. To specify more than one option, use a logical
	 *            OR operation
	 *            <ul>
	 *            <li>Database.FT_DATABASE includes Lotus Domino databases in
	 *            the search scope.</li>
	 *            <li>Database.FT_FILESYSTEM includes files other than Lotus
	 *            Domino databases in the search scope.</li>
	 *            <li>Database.FT_FUZZY specifies a fuzzy search.</li>
	 *            <li>Database.FT_STEMS uses stem words as the basis of the
	 *            search.</li>
	 *            </ul>
	 * @param start
	 *            The starting document to return.
	 * @return A sorted collection of documents that are not yet processed and
	 *         match the query.
	 * 
	 * @throws NotesApiException
	 * 
	 * @usage This method is valid only for agents.<br>
	 * 
	 *        <b>How does it work?</b><br>
	 *        This method works in two parts:<br>
	 * 
	 *        <ul>
	 *        <li>First, it finds a collection of documents that the agent
	 *        considers to be "unprocessed." The type of agent determines which
	 *        documents are considered to be unprocessed. This document
	 *        collection is identical to that returned by
	 *        getUnprocessedDocuments.</li>
	 *        <li>Second, it conducts a full-text search on the unprocessed
	 *        documents and returns a collection of those documents that match
	 *        the query.</li>
	 *        </ul>
	 *        For example, in an agent that runs on all selected documents in a
	 *        view, getUnprocessedFTSearch searches only the selected documents
	 *        and returns those that match the query. In an agent that runs on
	 *        all new and modified documents since the last run,
	 *        getUnprocessedFTSearch searches only the documents that were not
	 *        marked by updateProcessedDoc, and returns those that match the
	 *        query.<br>
	 * <br>
	 *        <b>What documents are returned?</b><br>
	 *        The following table describes the documents that are returned by
	 *        unprocessedFTSearch. Document selection occurs once, before the
	 *        agent runs.
	 * 
	 *        <table border="1">
	 *        <tr>
	 *        <th>Agent runs on:</th>
	 *        <th>UnprocessedDocuments returns documents that meet all of these
	 *        requirements:</th>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in database</td>
	 *        <td>Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All new & modified documents</td>
	 *        <td>Not processed by this agent with updateProcessedDoc<br>
	 * 
	 *        Created or modified since the agent last ran<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search critieria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All unread documents in view</td>
	 *        <td>Are unread and in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in view</td>
	 *        <td>Are in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>All selected documents</td>
	 *        <td>Are selected in the view<br>
	 * 
	 *        Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *        Meet the full-text search criteria specified in this method</td>
	 *        </tr>
	 *        <tr>
	 *        <td>None</td>
	 *        <td>Is the current document only</td>
	 *        </tr>
	 *        </table>
	 * 
	 *        <b>Using updateProcessedDoc</b><br>
	 *        For agents that run on new and modified documents, you must use
	 *        updateProcessedDoc to mark each document as "processed," which
	 *        ensures that a document gets processed by the agent only once
	 *        (unless it's modified again). If you do not call this method for
	 *        each document, the agent processes the same documents the next
	 *        time it runs.<br>
	 * 
	 *        The updateProcessedDoc method marks a document as processed only
	 *        for the particular agent from which it is called. Using
	 *        updateProcessedDoc in one agent has no effect on the documents
	 *        that another agent processes.<br>
	 * 
	 *        In all other agents and view actions, updateProcessedDoc has no
	 *        effect.<br>
	 * 
	 *        <b>View actions</b><br>
	 *        When used in a view action, unprocessedFTSearch returns the same
	 *        documents as an agent that runs on selected documents.<br>
	 * 
	 *        <b>Full-text indexes</b><br>
	 *        If the database is not full-text indexed, this method works, but
	 *        less efficiently. To test for an index, use isFTIndexed. To create
	 *        an index on a local database, use updateFTIndex.<br>
	 * 
	 *        This method returns a maximum of 5,000 documents by default. The
	 *        Notes.ini variable FT_MAX_SEARCH_RESULTS overrides this limit for
	 *        indexed databases or databases that are not indexed but that are
	 *        running in an agent on the client. For a database that is not
	 *        indexed and is running in an agent on the server, you must set the
	 *        TEMP_INDEX_MAX_DOC Notes.ini variable as well. The absolute
	 *        maximum is 2,147,483,647.<br>
	 * 
	 *        <b>Options</b><br>
	 *        If you don't specify any sort options, the documents are sorted by
	 *        relevance score. When the collection is sorted by relevance the
	 *        highest relevance appears first. To access the relevance score of
	 *        each document in the collection, use FTSearchScore in Document.<br>
	 * 
	 *        If you ask for a sort by date, you don't get relevance scores. If
	 *        you pass the resulting DocumentCollection to a Newsletter object,
	 *        it formats its doclink report with either the document creation
	 *        date or the relevance score, depending on the sort options.<br>
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
	 *        both of which include Lotus Notes.<br>
	 * 
	 * @example This agent, which runs on selected documents, returns the
	 *          selected documents that contain a specified string, in groups of
	 *          eight.
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
	 * 			// Get query string and put in quotes
	 * 			String query = &quot;foo&quot;;
	 * 			query = &quot;\&quot;&quot; + query + &quot;\&quot;&quot;;
	 * 			// Get first 8 documents that match the query
	 * 			int start = 1;
	 * 			DocumentCollection dc = agentContext.unprocessedFTSearchRange(
	 * 					query, 8, Database.FT_SCORES, Database.FT_STEMS, start);
	 * 			while (dc.getCount() &gt; 0) {
	 * 				System.out.println(&quot;Documents &quot; + start + &quot; though &quot;
	 * 						+ (start + dc.getCount() - 1));
	 * 				Document doc = dc.getFirstDocument();
	 * 				while (doc != null) {
	 * 					System.out
	 * 							.println(&quot;\t&quot; + doc.getItemValueString(&quot;Subject&quot;));
	 * 					doc = dc.getNextDocument(doc);
	 * 				}
	 * 				// Get next 8 documents that match query
	 * 				start = start + 8;
	 * 				dc = agentContext.unprocessedFTSearchRange(query, 8,
	 * 						Database.FT_SCORES, Database.FT_FUZZY, start);
	 * 			}
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection unprocessedFTSearchRange(
			String query, int maxdocs, int sortopt, int otheropt, int start)
			throws NotesApiException;

	/**
	 * Given selection criteria, returns documents in a database that:
	 * <ul>
	 * <li>The current agent considers to be unprocessed</li>
	 * <li>Meet the selection criteria</li>
	 * <li>Were created or modified since the cutoff date</li>
	 * </ul>
	 * 
	 * @param formula
	 *            A Lotus Domino formula that defines the selection criteria
	 * @param limit
	 *            A cutoff date
	 * @param maxDocs
	 *            The maximum number of documents you want returned; 0 means all
	 *            matching documents.
	 * @return A collection of documents that are not yet processed, match the
	 *         selection criteria, and were created or modified after the cutoff
	 *         date. The collection is sorted by relevance with highest
	 *         relevance first
	 * @throws NotesApiException
	 * 
	 *             * @usage This method is valid only for agents.<br>
	 * 
	 *             <b>How does it work?</b><br>
	 *             This method works in two parts:<br>
	 * 
	 *             <ul>
	 *             <li>First, it finds a collection of documents that the agent
	 *             considers to be "unprocessed." The type of agent determines
	 *             which documents are considered to be unprocessed. This
	 *             document collection is identical to that returned by
	 *             getUnprocessedDocuments.</li>
	 *             <li>Second, it conducts a full-text search on the unprocessed
	 *             documents and returns a collection of those documents that
	 *             match the query.</li>
	 *             </ul>
	 *             For example, in an agent that runs on all selected documents
	 *             in a view, getUnprocessedFTSearch searches only the selected
	 *             documents and returns those that match the query. In an agent
	 *             that runs on all new and modified documents since the last
	 *             run, getUnprocessedFTSearch searches only the documents that
	 *             were not marked by updateProcessedDoc, and returns those that
	 *             match the query.<br>
	 * <br>
	 *             <b>What documents are returned?</b><br>
	 *             The following table describes the documents that are returned
	 *             by unprocessedFTSearch. Document selection occurs once,
	 *             before the agent runs.
	 * 
	 *             <table border="1">
	 *             <tr>
	 *             <th>Agent runs on:</th>
	 *             <th>UnprocessedDocuments returns documents that meet all of
	 *             these requirements:</th>
	 *             </tr>
	 *             <tr>
	 *             <td>All documents in database</td>
	 *             <td>Meet the search criteria specified in Agent Properties
	 *             box<br>
	 * 
	 *             Meet the full-text search critieria specified in this method</td>
	 *             </tr>
	 *             <tr>
	 *             <td>All new & modified documents</td>
	 *             <td>Not processed by this agent with updateProcessedDoc<br>
	 * 
	 *             Created or modified since the agent last ran<br>
	 * 
	 *             Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *             Meet the full-text search critieria specified in this method</td>
	 *             </tr>
	 *             <tr>
	 *             <td>All unread documents in view</td>
	 *             <td>Are unread and in the view<br>
	 * 
	 *             Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *             Meet the full-text search criteria specified in this method</td>
	 *             </tr>
	 *             <tr>
	 *             <td>All documents in view</td>
	 *             <td>Are in the view<br>
	 * 
	 *             Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *             Meet the full-text search criteria specified in this method</td>
	 *             </tr>
	 *             <tr>
	 *             <td>All selected documents</td>
	 *             <td>Are selected in the view<br>
	 * 
	 *             Meet the search criteria specified in Agent Properties box<br>
	 * 
	 *             Meet the full-text search criteria specified in this method</td>
	 *             </tr>
	 *             <tr>
	 *             <td>None</td>
	 *             <td>Is the current document only</td>
	 *             </tr>
	 *             </table>
	 * 
	 *             <b>Using updateProcessedDoc</b><br>
	 *             For agents that run on new and modified documents, you must
	 *             use updateProcessedDoc to mark each document as "processed,"
	 *             which ensures that a document gets processed by the agent
	 *             only once (unless it's modified again). If you do not call
	 *             this method for each document, the agent processes the same
	 *             documents the next time it runs.<br>
	 * 
	 *             The updateProcessedDoc method marks a document as processed
	 *             only for the particular agent from which it is called. Using
	 *             updateProcessedDoc in one agent has no effect on the
	 *             documents that another agent processes.<br>
	 * 
	 *             In all other agents and view actions, updateProcessedDoc has
	 *             no effect.<br>
	 * 
	 * @example This agent searches all or selected documents for documents
	 *          created after January 1, 1999 that contain "botany" in the
	 *          Subject field, and places them in the "Botanist's Delight"
	 *          folder.
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
	 * 			DateTime date = session.createDateTime(&quot;01/01/99&quot;);
	 * 			DocumentCollection dc = agentContext.unprocessedSearch(
	 * 					&quot;@Contains(Subject; \&quot;botany\&quot;)&quot;, date, 0);
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				doc.putInFolder(&quot;Botanist's Delight&quot;);
	 * 				agentContext.updateProcessedDoc(doc);
	 * 				System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection unprocessedSearch(String formula,
			NotesDateTime limit, int maxDocs) throws NotesApiException;

	/**
	 * The user name that is in effect for the current program.
	 * 
	 * @return The user name that is in effect for the current program. For a
	 *         program running on:
	 *         <ul>
	 *         <li>A workstation, this is the name of the current user.</li>
	 *         <li>A server, the identity of the person under whose identity the
	 *         program is running.</li>
	 *         </ul>
	 * 
	 * @throws NotesApiException
	 * @usage The identity of the person under whose identity the program is
	 *        running depends on whether you are running an agent, an XPage, a
	 *        servlet, or a stand alone program.
	 * 
	 *        For an agent, selecting 'run as web user' will make this property
	 *        use the identity of the logged in web user. If 'run as web user'
	 *        is not selected, this property will use the identity of the agent
	 *        signer.
	 * 
	 *        For everything else the identity is the identity established by
	 *        the Session or automatically assigned by the environment.
	 * 
	 *        This property returns the fully distinguished name.
	 * 
	 *        For Java agents, this property will return the same value as the
	 *        EffectiveUserName property in the Java Session class.
	 * @example This example prints the current effective user name.
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
	 * 			String name = agentContext.getEffectiveUserName();
	 * 			System.out.println(&quot;Effective user name is &quot; + name);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract String getEffectiveUserName() throws NotesApiException;

	/**
	 * The agent that's currently running.
	 * 
	 * @return The agent that's currently running.
	 * @throws NotesApiException
	 * @example This agent prints the name of the current agent.
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
	 * 			String name = agent.getName();
	 * 			System.out.println(&quot;Current agent is \&quot;&quot; + name + &quot;\&quot;&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesAgent getCurrentAgent() throws NotesApiException;

	/**
	 * The database in which the current agent resides.
	 * 
	 * @return The database in which the current agent resides.
	 * @throws NotesApiException
	 * @usage This property allows you to access a database without having to
	 *        specify its server and file name. Using getCurrentDatabase can
	 *        make programs more portable from one database to another.
	 * @example This agent example prints the title of the current database.
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
	 * 			System.out.println(&quot;Current database is \&quot;&quot; + title + &quot;\&quot;&quot;);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDatabase getCurrentDatabase() throws NotesApiException;

	/**
	 * The in-memory document when an agent starts.
	 * 
	 * @return The in-memory document when an agent starts.
	 * @throws NotesApiException
	 * @usage For an agent activated in a view through the Notes client UI, the
	 *        in-memory document is the document highlighted in the view.
	 * 
	 *        For an agent activated "Before New Mail Arrives," the in-memory
	 *        document is the email that is about to be delivered. Because the
	 *        agent is activated instantly for each email as it's about to be
	 *        saved into the mail database, each time the agent runs you are
	 *        working with a single unsaved document. The UnprocessedDocuments
	 *        property in AgentContext will not return any documents for this
	 *        agent type.
	 * 
	 *        For an agent run from a browser with the OpenAgent URL command,
	 *        the in-memory document is a new document containing an item for
	 *        each CGI (Common Gateway Interface) variable supported by Domino.
	 *        Each item has the name and current value of a supported CGI
	 *        variable. (No design work on your part is needed; the CGI
	 *        variables are available automatically.)
	 * 
	 *        For an agent run from a browser with @Command([RunAgent]) or
	 * @Command[ToolsRunMacro], the in-memory document is the current document.
	 *                          In the case of WebQueryOpen, this is the
	 *                          document before Domino converts it to HTML and
	 *                          sends it to the browser; in the case of
	 *                          WebQuerySave, this is the document before Domino
	 *                          saves it. If the form on which the document is
	 *                          based contains a field named the same as a
	 *                          Domino-supported CGI variable, the in-memory
	 *                          document also contains the value of that
	 *                          variable. (You must explicitly design the CGI
	 *                          variables into the form, for example, as hidden
	 *                          fields.)
	 * 
	 *                          See "Table of CGI Variables" in Application
	 *                          Development with Domino Designer for a list of
	 *                          the Lotus Domino-supported CGI variables.
	 * 
	 *                          Through the C or C++ API, an external program
	 *                          can create an in-memory document, then run an
	 *                          agent. The agent can use this property to access
	 *                          the in-memory document.
	 * 
	 *                          The save method immediately updates the document
	 *                          represented by the Document object returned by
	 *                          DocumentContext. For an agent working on a
	 *                          selected document in the Notes client, you must
	 *                          save before exiting to preserve any changes. For
	 *                          an agent called from a browser, any changes go
	 *                          back to the browser when the agent exits; you
	 *                          probably do not want to save before exiting, but
	 *                          let the browser handle the changes.
	 * 
	 *                          You cannot use the encrypt and remove methods on
	 *                          the Document object returned by
	 *                          getDocumentContext, nor use the compact method
	 *                          on the Database object that contains the
	 *                          Document object returned by getDocumentContext.
	 * @example This agent prints the value of the Subject field of the
	 *          in-memory document.
	 * 
	 *          1. This agent displays the Subject item of the current document
	 *          when run from a view in the Notes client.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 
	 * 	public void NotesMain() {
	 * 
	 *         try {
	 *           Session session = getSession();
	 *           AgentContext agentContext = session.getAgentContext();
	 * 
	 *           // (Your code goes here) 
	 *           Document doc = agentContext.getDocumentContext();
	 *           System.out.println
	 *             (doc.getItemValueString(&quot;Subject&quot;));/
	 * 
	 *         } catch(Exception e) {
	 *             e.printStackTrace();
	 *         }
	 *     }
	 * }
	 * </pre>
	 * 
	 *          2. This agent displays the Subject item of the current document
	 *          when run by @Command([RunAgent]) in a browser.
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
	 * 			Document doc = agentContext.getDocumentContext();
	 * 			PrintWriter pw = getAgentOutput();
	 * 			pw.println(&quot;&lt;H2&gt;&quot; + doc.getItemValueString(&quot;Subject&quot;) + &quot;&lt;/H2&gt;&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *          3. This agent displays the CGI variable Remote_Addr when run in
	 *          a browser by the OpenAgent URL command, or by
	 * @Command([ToolsRunMacro]) if Remote_Addr is a field on the form
	 *                           supporting the current document.
	 * 
	 *                           <pre>
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
	 * 			Document doc = agentContext.getDocumentContext();
	 * 			System.out.println(doc.getItemValueString(&quot;Remote_Addr&quot;));
	 * 			PrintWriter pw = getAgentOutput();
	 * 			pw.println(&quot;&lt;H2&gt;IP address is &quot;
	 * 					+ doc.getItemValueString(&quot;Remote_Addr&quot;) + &quot;&lt;/H2&gt;&quot;);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 * 
	 *                           4. This agent increments a counter. You can use
	 *                           it to track the number of times a Web page is
	 *                           opened by calling it from WebQueryOpen. The
	 *                           counter is maintained in a profile document as
	 *                           an item named Access_counter. An item of the
	 *                           name exists for display purposes only in the
	 *                           document being opened
	 * 
	 *                           <pre>
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
	 * 			Document doc = agentContext.getDocumentContext();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			Document profile = db.getProfileDocument(&quot;(AccessCounterProfile)&quot;,
	 * 					null);
	 * 			String numStr = profile.getItemValueString(&quot;Access_counter&quot;);
	 * 			String numStr2;
	 * 			if (numStr.equals(&quot; &quot;) || numStr.equals(&quot;&quot;)) {
	 * 				numStr2 = new String(&quot;1&quot;);
	 * 			} else {
	 * 				Integer numInt = new Integer(numStr);
	 * 				int num = numInt.intValue() + 1;
	 * 				Integer numInt2 = new Integer(num);
	 * 				numStr2 = new String(numInt2.toString());
	 * 			}
	 * 
	 * 			profile.replaceItemValue(&quot;Access_counter&quot;, numStr2);
	 * 			profile.save(false, false);
	 * 			doc.replaceItemValue(&quot;Access_counter&quot;, numStr2);
	 * 
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getDocumentContext() throws NotesApiException;

	/**
	 * The exit status code returned by the Agent Manager the last time the
	 * current agent ran.
	 * 
	 * @return The exit status code returned by the Agent Manager the last time
	 *         the current agent ran.
	 * @throws NotesApiException
	 * @usage This property returns 0 if the agent ran without errors.
	 * @example This agent prints the last exit status of the current agent.
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
	 * 			int status = agentContext.getLastExitStatus();
	 * 			System.out.println(&quot;Last exit status was &quot; + status);
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract int getLastExitStatus() throws NotesApiException;

	/**
	 * The date and time when the current agent was last executed.
	 * 
	 * @return The date and time when the current agent was last executed.
	 * @throws NotesApiException
	 * @usage If the agent never ran before, this property returns null.
	 * @example This agent prints the date and time that the agent last ran.
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
	 * 			DateTime date = agentContext.getLastRun();
	 * 			if (date.getDateOnly().equals(&quot;&quot;))
	 * 				System.out.println(&quot;Agent was not run before&quot;);
	 * 			else
	 * 				System.out.println(&quot;Agent was last run on &quot;
	 * 						+ date.getDateOnly() + &quot; at &quot; + date.getTimeOnly());
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDateTime getLastRun() throws NotesApiException;

	/**
	 * A document that an agent uses to store information between invocations.
	 * The agent can use the information in this document the next time the
	 * agent runs.
	 * 
	 * @return A document that an agent uses to store information between
	 *         invocations. The agent can use the information in this document
	 *         the next time the agent runs.
	 * @throws NotesApiException
	 * @usage The getSavedData document is created when you save an agent, and
	 *        it is stored in the same database as the agent. The document
	 *        replicates, but is not displayed in views.
	 * 
	 *        Each time you edit and re-save an agent, its getSavedData document
	 *        is deleted and a new, blank one is created. When you delete an
	 *        agent, its getSavedData document is deleted.
	 * @example This agent uses the save data record to find the maximum weekly
	 *          sales.The data records have Weeky_Sales and Name fields. The
	 *          saved data record has MaxSales and MaxSales_Salesperson fields.
	 *          The data record fields replace the agent record fields whenever
	 *          Weekly_Sales is greater than MaxSales.
	 * 
	 *          <pre>
	 * import lotus.domino.*;
	 * import java.util.Vector;
	 * import java.lang.Float;
	 * 
	 * public class JavaAgent extends AgentBase {
	 * 	public void NotesMain() {
	 * 		try {
	 * 			Session session = getSession();
	 * 			AgentContext agentContext = session.getAgentContext();
	 * 			// (Your code goes here)
	 * 			Document agentDoc = agentContext.getSavedData();
	 * 			Database db = agentContext.getCurrentDatabase();
	 * 			View view = db.getView(&quot;Weekly Sales&quot;);
	 * 			Document doc = view.getFirstDocument();
	 * 			if (!agentDoc.hasItem(&quot;MaxSales&quot;)) {
	 * 				agentDoc.replaceItemValue(&quot;MaxSales&quot;, &quot;0&quot;);
	 * 				agentDoc.save(true, true);
	 * 				agentDoc = agentContext.getSavedData();
	 * 			}
	 * 			while (doc != null) {
	 * 				Vector mvalue = agentDoc.getItemValue(&quot;MaxSales&quot;);
	 * 				Vector wvalue = doc.getItemValue(&quot;Weekly_Sales&quot;);
	 * 				Float maxSales = new Float((String) mvalue.firstElement());
	 * 				Float weeklySales = new Float((String) wvalue.firstElement());
	 * 				if (weeklySales.floatValue() &gt; maxSales.floatValue()) {
	 * 					agentDoc.replaceItemValue(&quot;MaxSales&quot;,
	 * 							doc.getItemValue(&quot;Weekly_Sales&quot;));
	 * 					agentDoc.replaceItemValue(&quot;MaxSales_Salesperson&quot;,
	 * 							doc.getItemValue(&quot;Name&quot;));
	 * 				}
	 * 				agentDoc.save(true, true);
	 * 				System.out.println(&quot;Best salesperson to date is &quot;
	 * 						+ agentDoc.getItemValue(&quot;MaxSales_Salesperson&quot;)
	 * 						+ &quot; who sold $&quot; + agentDoc.getItemValue(&quot;MaxSales&quot;));
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocument getSavedData() throws NotesApiException;

	/**
	 * The documents in a database that the current agent considers to be
	 * "unprocessed." The type of agent determines which documents are
	 * considered unprocessed.
	 * 
	 * @return The documents in a database that the current agent considers to
	 *         be "unprocessed." The type of agent determines which documents
	 *         are considered unprocessed.
	 * @throws NotesApiException
	 * @usage This method is valid only for agents.
	 * 
	 *        What documents are returned? <br>
	 *        The following table describes the documents that are returned by
	 *        getUnprocessedDocuments. Document selection occurs once, before
	 *        the agent runs.
	 *        <table border="1">
	 *        <tr>
	 *        <th>Agent runs on:</th>
	 *        <th>UnprocessedDocuments returns documents that meet all of these
	 *        requirements:</th>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in database</td>
	 *        <td>Meet the search criteria specified in Agent Properties box</td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        All new & modified documents</td>
	 *        <td>
	 *        <ul>
	 *        <li>Not processed by this agent with updateProcessedDoc</li>
	 *        <li>Created or modified since the agent last ran</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        All unread documents in view</td>
	 *        <td>
	 *        <ul>
	 *        <li>Are unread and in the view</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        <tr>
	 *        <td>All documents in view</td>
	 *        <td>
	 *        <ul>
	 *        <li>Are in the view</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        All selected documents</td>
	 *        <td>
	 *        <ul>
	 *        <li>Are selected in the view</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        None</td>
	 *        <td>Is the current document only</td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        Before New Mail Arrives</td>
	 *        <td>None (does not return any documents; use DocumentContext in
	 *        AgentContext instead)</td>
	 *        </tr>
	 *        <tr>
	 *        <td>After New Mail Arrives</td>
	 *        <td>
	 *        <ul>
	 *        <li>Mailed to the database since the agent last ran</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        Newly modified documents</td>
	 *        <td>
	 *        <ul>
	 *        <li>Modified since the agent last ran</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        <tr>
	 *        <td>
	 *        Pasted documents</td>
	 *        <td>
	 *        <ul>
	 *        <li>Pasted into the database since the agent last ran</li>
	 *        <li>Meet the search criteria specified in Agent Properties box</li>
	 *        </ul>
	 *        </td>
	 *        </tr>
	 *        </table>
	 * 
	 *        Using UpdateProcessedDoc <br>
	 *        For agents that run on new and modified documents, you must use
	 *        updateProcessedDoc in Session to mark each document as
	 *        "processed," which ensures that a document gets processed by the
	 *        agent only once (unless it's modified again). If you do not call
	 *        this method for each document, the agent processes the same
	 *        documents the next time it runs.
	 * 
	 *        The updateProcessedDoc method marks a document as processed only
	 *        for the particular agent from which it is called. Using
	 *        updateProcessedDoc in one agent has no effect on the documents
	 *        that another agent processes.
	 * @example If this agent runs on selected documents,
	 *          getUnprocessedDocuments returns the selected documents.
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
	 * 			DocumentCollection dc = agentContext.getUnprocessedDocuments();
	 * 			System.out.println(&quot;Count = &quot; + dc.getCount());
	 * 			Document doc = dc.getFirstDocument();
	 * 			while (doc != null) {
	 * 				System.out.println(doc.getItemValueString(&quot;Subject&quot;));
	 * 				doc = dc.getNextDocument();
	 * 			}
	 * 		} catch (Exception e) {
	 * 			e.printStackTrace();
	 * 		}
	 * 	}
	 * }
	 * </pre>
	 */
	public abstract NotesDocumentCollection getUnprocessedDocuments()
			throws NotesApiException;
}
