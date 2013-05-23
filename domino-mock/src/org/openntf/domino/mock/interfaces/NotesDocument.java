package org.openntf.domino.mock.interfaces;

import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesDocument extends NotesBase {
	public static final int CVT_RT_TO_PLAINTEXT = 1;
	public static final int CVT_RT_TO_HTML = 2;
	public static final int CVT_RT_TO_PLAINTEXT_AND_HTML = 3;

	public abstract NotesItem appendItemValue(String name, Object value)
			throws NotesApiException;

	public abstract NotesItem appendItemValue(String name)
			throws NotesApiException;

	public abstract NotesItem appendItemValue(String name, int value)
			throws NotesApiException;

	public abstract NotesItem appendItemValue(String name, double value)
			throws NotesApiException;

	public abstract boolean closeMIMEEntities() throws NotesApiException;

	public abstract boolean closeMIMEEntities(boolean saveChanges)
			throws NotesApiException;

	public abstract boolean closeMIMEEntities(boolean saveChanges,
			String entityItemName) throws NotesApiException;

	public abstract boolean computeWithForm(boolean doDataTypes,
			boolean raiseError) throws NotesApiException;

	public abstract void copyAllItems(NotesDocument doc, boolean replace)
			throws NotesApiException;

	public abstract NotesItem copyItem(NotesItem item, String newName)
			throws NotesApiException;

	public abstract NotesItem copyItem(NotesItem item) throws NotesApiException;

	public abstract NotesDocument copyToDatabase(NotesDatabase db)
			throws NotesApiException;

	public abstract NotesMIMEEntity createMIMEEntity() throws NotesApiException;

	public abstract NotesMIMEEntity createMIMEEntity(String itemName)
			throws NotesApiException;

	public abstract NotesRichTextItem createRichTextItem(String name)
			throws NotesApiException;

	public abstract NotesDocument createReplyMessage(boolean toAll)
			throws NotesApiException;

	public abstract void encrypt() throws NotesApiException;

	public abstract NotesEmbeddedObject getAttachment(String filename)
			throws NotesApiException;

	public abstract Vector getAuthors() throws NotesApiException;

	public abstract Vector getColumnValues() throws NotesApiException;

	public abstract NotesDateTime getCreated() throws NotesApiException;

	public abstract Vector getEmbeddedObjects() throws NotesApiException;

	public abstract Vector getEncryptionKeys() throws NotesApiException;

	public abstract void setEncryptionKeys(Vector keys)
			throws NotesApiException;

	public abstract NotesItem getFirstItem(String name)
			throws NotesApiException;

	public abstract int getFTSearchScore() throws NotesApiException;

	public abstract NotesDateTime getLastAccessed() throws NotesApiException;

	public abstract NotesDateTime getLastModified() throws NotesApiException;

	public abstract Vector getFolderReferences() throws NotesApiException;

	public abstract NotesMIMEEntity getMIMEEntity() throws NotesApiException;

	public abstract NotesMIMEEntity getMIMEEntity(String itemName)
			throws NotesApiException;

	public abstract Vector<NotesItem> getItems() throws NotesApiException;

	public abstract Vector getItemValue(String name) throws NotesApiException;

	public abstract String getItemValueString(String name)
			throws NotesApiException;

	public abstract int getItemValueInteger(String name)
			throws NotesApiException;

	public abstract double getItemValueDouble(String name)
			throws NotesApiException;

	public abstract Object getItemValueCustomData(String itemName,
			String dataTypeName) throws IOException, ClassNotFoundException,
			NotesApiException;

	public abstract Object getItemValueCustomData(String itemName)
			throws IOException, ClassNotFoundException, NotesApiException;

	public abstract byte[] getItemValueCustomDataBytes(String itemName,
			String dataTypeName) throws IOException, NotesApiException;

	public abstract Vector getItemValueDateTimeArray(String name)
			throws NotesApiException;

	public abstract String getKey() throws NotesApiException;

	public abstract String getNameOfProfile() throws NotesApiException;

	public abstract String getNoteID() throws NotesApiException;

	public abstract NotesDatabase getParentDatabase() throws NotesApiException;

	public abstract String getParentDocumentUNID() throws NotesApiException;

	public abstract NotesView getParentView() throws NotesApiException;

	public abstract NotesDocumentCollection getResponses()
			throws NotesApiException;

	public abstract String getSigner() throws NotesApiException;

	public abstract int getSize() throws NotesApiException;

	public abstract String getUniversalID() throws NotesApiException;

	public abstract void setUniversalID(String unid) throws NotesApiException;

	public abstract String getVerifier() throws NotesApiException;

	public abstract boolean hasEmbedded() throws NotesApiException;

	public abstract boolean hasItem(String name) throws NotesApiException;

	public abstract boolean isEncrypted() throws NotesApiException;

	public abstract boolean isEncryptOnSend() throws NotesApiException;

	public abstract void setEncryptOnSend(boolean flag)
			throws NotesApiException;

	public abstract boolean isNewNote() throws NotesApiException;

	public abstract boolean isProfile() throws NotesApiException;

	public abstract boolean isResponse() throws NotesApiException;

	public abstract boolean isSigned() throws NotesApiException;

	public abstract boolean isValid() throws NotesApiException;

	public abstract boolean isSaveMessageOnSend() throws NotesApiException;

	public abstract void setSaveMessageOnSend(boolean flag)
			throws NotesApiException;

	public abstract boolean isSentByAgent() throws NotesApiException;

	public abstract boolean isSignOnSend() throws NotesApiException;

	public abstract void setSignOnSend(boolean flag) throws NotesApiException;

	public abstract boolean isDeleted() throws NotesApiException;

	public abstract void makeResponse(NotesDocument doc)
			throws NotesApiException;

	public abstract void putInFolder(String name) throws NotesApiException;

	public abstract void putInFolder(String name, boolean createOnFail)
			throws NotesApiException;

	public abstract boolean remove(boolean force) throws NotesApiException;

	public abstract boolean removePermanently(boolean force)
			throws NotesApiException;

	public abstract void removeFromFolder(String name) throws NotesApiException;

	public abstract void removeItem(String name) throws NotesApiException;

	public abstract boolean renderToRTItem(NotesRichTextItem rtItem)
			throws NotesApiException;

	public abstract NotesItem replaceItemValue(String itemName, Object value)
			throws NotesApiException;

	public abstract NotesItem replaceItemValueCustomData(String itemName,
			String dataTypeName, Object userObj) throws IOException,
			NotesApiException;

	public abstract NotesItem replaceItemValueCustomData(String itemName,
			Object userObj) throws IOException, NotesApiException;

	public abstract NotesItem replaceItemValueCustomDataBytes(String itemName,
			String dataTypeName, byte[] byteArray) throws IOException,
			NotesApiException;

	public abstract boolean save(boolean force, boolean makeRespoonse,
			boolean markRead) throws NotesApiException;

	public abstract boolean save(boolean force, boolean makeResponse)
			throws NotesApiException;

	public abstract boolean save(boolean force) throws NotesApiException;

	public abstract boolean save() throws NotesApiException;

	public abstract void send(boolean attachForm, Vector recipients)
			throws NotesApiException;

	public abstract void send(Vector recipients) throws NotesApiException;

	public abstract void send(boolean attachForm, String recipient)
			throws NotesApiException;

	public abstract void send(String recipient) throws NotesApiException;

	public abstract void send(boolean attachForm) throws NotesApiException;

	public abstract void send() throws NotesApiException;

	public abstract void sign() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getNotesURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract String generateXML() throws NotesApiException;

	public abstract void generateXML(Writer writer) throws NotesApiException,
			IOException;

	public abstract void generateXML(Object style, NotesXSLTResultTarget result)
			throws IOException, NotesApiException;

	public abstract Vector getReceivedItemText() throws NotesApiException;

	public abstract Vector getLockHolders() throws NotesApiException;

	public abstract boolean lock() throws NotesApiException;

	public abstract boolean lock(boolean provisionalOk)
			throws NotesApiException;

	public abstract boolean lock(String name) throws NotesApiException;

	public abstract boolean lock(String name, boolean provisionalOk)
			throws NotesApiException;

	public abstract boolean lock(Vector names) throws NotesApiException;

	public abstract boolean lock(Vector names, boolean provisionalOk)
			throws NotesApiException;

	public abstract boolean lockProvisional() throws NotesApiException;

	public abstract boolean lockProvisional(String name)
			throws NotesApiException;

	public abstract boolean lockProvisional(Vector names)
			throws NotesApiException;

	public abstract void unlock() throws NotesApiException;

	public abstract void markUnread() throws NotesApiException;

	public abstract void markUnread(String userName) throws NotesApiException;

	public abstract void markRead() throws NotesApiException;

	public abstract void markRead(String userName) throws NotesApiException;

	public abstract void attachVCard(NotesBase document)
			throws NotesApiException;

	public abstract void attachVCard(NotesBase document, String fileName)
			throws NotesApiException;

	public abstract boolean getRead() throws NotesApiException;

	public abstract boolean getRead(String userName) throws NotesApiException;

	public abstract void convertToMIME() throws NotesApiException;

	public abstract void convertToMIME(int conversionType)
			throws NotesApiException;

	public abstract void convertToMIME(int conversionType, int options)
			throws NotesApiException;
}
