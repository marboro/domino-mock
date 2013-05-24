package org.openntf.domino.mock.interfaces;

import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

/**
 * Represents a document in a database
 * 
 * @author Sven Dreher
 * @access To create a new Document object, use {@link NotesDatabase#createDocument()} in Database.<br>
 * 
 *         To access existing documents:<br>
 *         <ul>
 *         <li>
 *         To get all the documents in a database, use getAllDocuments in Database.</li>
 *         <li>To get a document based on its position in a view, use a View object.</li>
 *         <li>To get a document based on its position in a response hierarchy, use a View object.</li>
 *         <li>To get all documents that are responses to a particular document, use getResponses in Document.</li>
 *         <li>To get a response document's parent document, use getParentDocumentUNID in Document followed by getDocumentByUNID in Database.</li>
 *         <li>To get all the documents that match a full-text search query, use FTSearch in Database or FTSearch in View.</li>
 *         <li>To get all the documents in a database that meet search criteria, where the criteria are defined using the formula language, use search in Database.</li>
 *         <li>To get documents in a database not yet processed by the current agent, use getUnprocessedDocuments, unprocessedFTSearch, and unprocessedSearch in AgentContext.</li>
 *         <li>To get a document based on its note ID or UNID, use getDocumentByID or getDocumentByUNID in Database.</li>
 *         </ul>
 *         Once you have a view, you can navigate to a specific document using methods in the View class.<br>
 * 
 *         Once you have a collection of documents, you can navigate to a specific document using methods in the DocumentCollection class.<br>
 * 
 *         Saving changes After you create, modify, or delete a document, you must save the changes by calling the save method. If you don't call save before the program finishes, all of your changes
 *         to a Document are lost.<br>
 * 
 *         If you create and save a new document without adding any items to it, the document is saved with one item "$UpdatedBy." This item contains the name of the creator of the document.<br>
 * 
 *         Encryption A program attempts to decrypt an encrypted document the first time the program accesses one of the Document properties or methods. If decryption fails, an exception is thrown.<br>
 * @example 1. This agent creates a document and saves it in the current database
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
 * 			doc.replaceItemValue(&quot;Form&quot;, &quot;Main Topic&quot;);
 * 			doc.replaceItemValue(&quot;Subject&quot;, &quot;New building&quot;);
 * 			if (doc.save())
 * 				System.out.println(&quot;Document created and saved&quot;);
 * 			else
 * 				System.out.println(&quot;Something went wrong&quot;);
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 * 
 *          2. This agent creates a document and sends it. The document is not saved.
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
 * 			doc.replaceItemValue(&quot;Form&quot;, &quot;Memo&quot;);
 * 			doc.replaceItemValue(&quot;Subject&quot;, &quot;Reminder&quot;);
 * 			doc.setEncryptOnSend(true);
 * 			doc.replaceItemValue(&quot;Body&quot;, &quot;A document awaits your approval in &quot; + db.getTitle() + &quot;.&quot;);
 * 			doc.send(&quot;Robert Smith&quot;);
 * 		} catch (Exception e) {
 * 			e.printStackTrace();
 * 		}
 * 	}
 * }
 * </pre>
 */
public interface NotesDocument extends NotesBase {
	/**
	 * {@value}
	 */
	public static final int CVT_RT_TO_PLAINTEXT = 1;
	/**
	 * {@value}
	 */
	public static final int CVT_RT_TO_HTML = 2;
	/**
	 * {@value}
	 */
	public static final int CVT_RT_TO_PLAINTEXT_AND_HTML = 3;

	/**
	 * Creates a new item in a document and optionally sets the item value.
	 * 
	 * In general, replaceItemValue is favored over appendItemValue. If an item of the same name already exists in a document, appendItemValue creates a second item of the same name, and the duplicate
	 * items are not accessible except through a work-around. If you are creating a new document, appendItemValue is safe
	 * 
	 * @param name
	 *            The name of the new item
	 * @param value
	 *            The value of the new item
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem appendItemValue(String name, Object value) throws NotesApiException;

	/**
	 * Creates a new item in a document and optionally sets the item value.
	 * 
	 * In general, replaceItemValue is favored over appendItemValue. If an item of the same name already exists in a document, appendItemValue creates a second item of the same name, and the duplicate
	 * items are not accessible except through a work-around. If you are creating a new document, appendItemValue is safe
	 * 
	 * @param name
	 *            The name of the new item
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem appendItemValue(String name) throws NotesApiException;

	/**
	 * Creates a new item in a document and optionally sets the item value.
	 * 
	 * In general, replaceItemValue is favored over appendItemValue. If an item of the same name already exists in a document, appendItemValue creates a second item of the same name, and the duplicate
	 * items are not accessible except through a work-around. If you are creating a new document, appendItemValue is safe
	 * 
	 * @param name
	 *            The name of the new item
	 * @param value
	 *            The value of the new item
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem appendItemValue(String name, int value) throws NotesApiException;

	/**
	 * Creates a new item in a document and optionally sets the item value.
	 * 
	 * In general, replaceItemValue is favored over appendItemValue. If an item of the same name already exists in a document, appendItemValue creates a second item of the same name, and the duplicate
	 * items are not accessible except through a work-around. If you are creating a new document, appendItemValue is safe
	 * 
	 * @param name
	 *            The name of the new item
	 * @param value
	 *            The value of the new item
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem appendItemValue(String name, double value) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean closeMIMEEntities() throws NotesApiException;

	/**
	 * @param saveChanges
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean closeMIMEEntities(boolean saveChanges) throws NotesApiException;

	/**
	 * @param saveChanges
	 * @param entityItemName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean closeMIMEEntities(boolean saveChanges, String entityItemName) throws NotesApiException;

	/**
	 * @param doDataTypes
	 * @param raiseError
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean computeWithForm(boolean doDataTypes, boolean raiseError) throws NotesApiException;

	/**
	 * @param doc
	 * @param replace
	 * @throws NotesApiException
	 */
	public abstract void copyAllItems(NotesDocument doc, boolean replace) throws NotesApiException;

	/**
	 * @param item
	 * @param newName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem copyItem(NotesItem item, String newName) throws NotesApiException;

	/**
	 * @param item
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem copyItem(NotesItem item) throws NotesApiException;

	/**
	 * @param db
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument copyToDatabase(NotesDatabase db) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesMIMEEntity createMIMEEntity() throws NotesApiException;

	/**
	 * @param itemName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesMIMEEntity createMIMEEntity(String itemName) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesRichTextItem createRichTextItem(String name) throws NotesApiException;

	/**
	 * @param toAll
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocument createReplyMessage(boolean toAll) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void encrypt() throws NotesApiException;

	/**
	 * @param filename
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesEmbeddedObject getAttachment(String filename) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getAuthors() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getColumnValues() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getCreated() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getEmbeddedObjects() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getEncryptionKeys() throws NotesApiException;

	/**
	 * @param keys
	 * @throws NotesApiException
	 */
	public abstract void setEncryptionKeys(Vector keys) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem getFirstItem(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getFTSearchScore() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getLastAccessed() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDateTime getLastModified() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getFolderReferences() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesMIMEEntity getMIMEEntity() throws NotesApiException;

	/**
	 * @param itemName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesMIMEEntity getMIMEEntity(String itemName) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector<NotesItem> getItems() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getItemValue(String name) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getItemValueString(String name) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getItemValueInteger(String name) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract double getItemValueDouble(String name) throws NotesApiException;

	/**
	 * @param itemName
	 * @param dataTypeName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NotesApiException
	 */
	public abstract Object getItemValueCustomData(String itemName, String dataTypeName) throws IOException, ClassNotFoundException, NotesApiException;

	/**
	 * @param itemName
	 * @return
	 * @throws IOException
	 * @throws ClassNotFoundException
	 * @throws NotesApiException
	 */
	public abstract Object getItemValueCustomData(String itemName) throws IOException, ClassNotFoundException, NotesApiException;

	/**
	 * @param itemName
	 * @param dataTypeName
	 * @return
	 * @throws IOException
	 * @throws NotesApiException
	 */
	public abstract byte[] getItemValueCustomDataBytes(String itemName, String dataTypeName) throws IOException, NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getItemValueDateTimeArray(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getKey() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getNameOfProfile() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getNoteID() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDatabase getParentDatabase() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getParentDocumentUNID() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesView getParentView() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesDocumentCollection getResponses() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getSigner() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract int getSize() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getUniversalID() throws NotesApiException;

	/**
	 * @param unid
	 * @throws NotesApiException
	 */
	public abstract void setUniversalID(String unid) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String getVerifier() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean hasEmbedded() throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean hasItem(String name) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isEncrypted() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isEncryptOnSend() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setEncryptOnSend(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isNewNote() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isProfile() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isResponse() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isSigned() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isValid() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isSaveMessageOnSend() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setSaveMessageOnSend(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isSentByAgent() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isSignOnSend() throws NotesApiException;

	/**
	 * @param flag
	 * @throws NotesApiException
	 */
	public abstract void setSignOnSend(boolean flag) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean isDeleted() throws NotesApiException;

	/**
	 * @param doc
	 * @throws NotesApiException
	 */
	public abstract void makeResponse(NotesDocument doc) throws NotesApiException;

	/**
	 * @param name
	 * @throws NotesApiException
	 */
	public abstract void putInFolder(String name) throws NotesApiException;

	/**
	 * @param name
	 * @param createOnFail
	 * @throws NotesApiException
	 */
	public abstract void putInFolder(String name, boolean createOnFail) throws NotesApiException;

	/**
	 * @param force
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean remove(boolean force) throws NotesApiException;

	/**
	 * @param force
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean removePermanently(boolean force) throws NotesApiException;

	/**
	 * @param name
	 * @throws NotesApiException
	 */
	public abstract void removeFromFolder(String name) throws NotesApiException;

	/**
	 * @param name
	 * @throws NotesApiException
	 */
	public abstract void removeItem(String name) throws NotesApiException;

	/**
	 * @param rtItem
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean renderToRTItem(NotesRichTextItem rtItem) throws NotesApiException;

	/**
	 * @param itemName
	 * @param value
	 * @return
	 * @throws NotesApiException
	 */
	public abstract NotesItem replaceItemValue(String itemName, Object value) throws NotesApiException;

	/**
	 * @param itemName
	 * @param dataTypeName
	 * @param userObj
	 * @return
	 * @throws IOException
	 * @throws NotesApiException
	 */
	public abstract NotesItem replaceItemValueCustomData(String itemName, String dataTypeName, Object userObj) throws IOException, NotesApiException;

	/**
	 * @param itemName
	 * @param userObj
	 * @return
	 * @throws IOException
	 * @throws NotesApiException
	 */
	public abstract NotesItem replaceItemValueCustomData(String itemName, Object userObj) throws IOException, NotesApiException;

	/**
	 * @param itemName
	 * @param dataTypeName
	 * @param byteArray
	 * @return
	 * @throws IOException
	 * @throws NotesApiException
	 */
	public abstract NotesItem replaceItemValueCustomDataBytes(String itemName, String dataTypeName, byte[] byteArray) throws IOException, NotesApiException;

	/**
	 * @param force
	 * @param makeRespoonse
	 * @param markRead
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean save(boolean force, boolean makeRespoonse, boolean markRead) throws NotesApiException;

	/**
	 * @param force
	 * @param makeResponse
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean save(boolean force, boolean makeResponse) throws NotesApiException;

	/**
	 * @param force
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean save(boolean force) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean save() throws NotesApiException;

	/**
	 * @param attachForm
	 * @param recipients
	 * @throws NotesApiException
	 */
	public abstract void send(boolean attachForm, Vector recipients) throws NotesApiException;

	/**
	 * @param recipients
	 * @throws NotesApiException
	 */
	public abstract void send(Vector recipients) throws NotesApiException;

	/**
	 * @param attachForm
	 * @param recipient
	 * @throws NotesApiException
	 */
	public abstract void send(boolean attachForm, String recipient) throws NotesApiException;

	/**
	 * @param recipient
	 * @throws NotesApiException
	 */
	public abstract void send(String recipient) throws NotesApiException;

	/**
	 * @param attachForm
	 * @throws NotesApiException
	 */
	public abstract void send(boolean attachForm) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void send() throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void sign() throws NotesApiException;

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
	 * @return
	 * @throws NotesApiException
	 */
	public abstract String generateXML() throws NotesApiException;

	/**
	 * @param writer
	 * @throws NotesApiException
	 * @throws IOException
	 */
	public abstract void generateXML(Writer writer) throws NotesApiException, IOException;

	/**
	 * @param style
	 * @param result
	 * @throws IOException
	 * @throws NotesApiException
	 */
	public abstract void generateXML(Object style, NotesXSLTResultTarget result) throws IOException, NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getReceivedItemText() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract Vector getLockHolders() throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock() throws NotesApiException;

	/**
	 * @param provisionalOk
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(boolean provisionalOk) throws NotesApiException;

	/**
	 * @param name
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(String name) throws NotesApiException;

	/**
	 * @param name
	 * @param provisionalOk
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(String name, boolean provisionalOk) throws NotesApiException;

	/**
	 * @param names
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(Vector names) throws NotesApiException;

	/**
	 * @param names
	 * @param provisionalOk
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean lock(Vector names, boolean provisionalOk) throws NotesApiException;

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
	 * @throws NotesApiException
	 */
	public abstract void markUnread() throws NotesApiException;

	/**
	 * @param userName
	 * @throws NotesApiException
	 */
	public abstract void markUnread(String userName) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void markRead() throws NotesApiException;

	/**
	 * @param userName
	 * @throws NotesApiException
	 */
	public abstract void markRead(String userName) throws NotesApiException;

	/**
	 * @param document
	 * @throws NotesApiException
	 */
	public abstract void attachVCard(NotesBase document) throws NotesApiException;

	/**
	 * @param document
	 * @param fileName
	 * @throws NotesApiException
	 */
	public abstract void attachVCard(NotesBase document, String fileName) throws NotesApiException;

	/**
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean getRead() throws NotesApiException;

	/**
	 * @param userName
	 * @return
	 * @throws NotesApiException
	 */
	public abstract boolean getRead(String userName) throws NotesApiException;

	/**
	 * @throws NotesApiException
	 */
	public abstract void convertToMIME() throws NotesApiException;

	/**
	 * @param conversionType
	 * @throws NotesApiException
	 */
	public abstract void convertToMIME(int conversionType) throws NotesApiException;

	/**
	 * @param conversionType
	 * @param options
	 * @throws NotesApiException
	 */
	public abstract void convertToMIME(int conversionType, int options) throws NotesApiException;
}
