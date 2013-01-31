package com.dvelop.domino.mock.interfaces;

import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDocument extends NotesBase {
	public static final int CVT_RT_TO_PLAINTEXT = 1;
	public static final int CVT_RT_TO_HTML = 2;
	public static final int CVT_RT_TO_PLAINTEXT_AND_HTML = 3;

	public abstract NotesItem appendItemValue(String arg0, Object arg1)
			throws NotesApiException;

	public abstract NotesItem appendItemValue(String arg0)
			throws NotesApiException;

	public abstract NotesItem appendItemValue(String arg0, int arg1)
			throws NotesApiException;

	public abstract NotesItem appendItemValue(String arg0, double arg1)
			throws NotesApiException;

	public abstract boolean closeMIMEEntities() throws NotesApiException;

	public abstract boolean closeMIMEEntities(boolean arg0)
			throws NotesApiException;

	public abstract boolean closeMIMEEntities(boolean arg0, String arg1)
			throws NotesApiException;

	public abstract boolean computeWithForm(boolean arg0, boolean arg1)
			throws NotesApiException;

	public abstract void copyAllItems(NotesDocument arg0, boolean arg1)
			throws NotesApiException;

	public abstract NotesItem copyItem(NotesItem arg0, String arg1)
			throws NotesApiException;

	public abstract NotesItem copyItem(NotesItem arg0) throws NotesApiException;

	public abstract NotesDocument copyToDatabase(NotesDatabase arg0)
			throws NotesApiException;

	public abstract NotesMIMEEntity createMIMEEntity() throws NotesApiException;

	public abstract NotesMIMEEntity createMIMEEntity(String arg0)
			throws NotesApiException;

	public abstract NotesRichTextItem createRichTextItem(String arg0)
			throws NotesApiException;

	public abstract NotesDocument createReplyMessage(boolean arg0)
			throws NotesApiException;

	public abstract void encrypt() throws NotesApiException;

	public abstract NotesEmbeddedObject getAttachment(String arg0)
			throws NotesApiException;

	public abstract Vector getAuthors() throws NotesApiException;

	public abstract Vector getColumnValues() throws NotesApiException;

	public abstract NotesDateTime getCreated() throws NotesApiException;

	public abstract Vector getEmbeddedObjects() throws NotesApiException;

	public abstract Vector getEncryptionKeys() throws NotesApiException;

	public abstract void setEncryptionKeys(Vector arg0)
			throws NotesApiException;

	public abstract NotesItem getFirstItem(String arg0)
			throws NotesApiException;

	public abstract int getFTSearchScore() throws NotesApiException;

	public abstract NotesDateTime getLastAccessed() throws NotesApiException;

	public abstract NotesDateTime getLastModified() throws NotesApiException;

	public abstract Vector getFolderReferences() throws NotesApiException;

	public abstract NotesMIMEEntity getMIMEEntity() throws NotesApiException;

	public abstract NotesMIMEEntity getMIMEEntity(String arg0)
			throws NotesApiException;

	public abstract Vector getItems() throws NotesApiException;

	public abstract Vector getItemValue(String arg0) throws NotesApiException;

	public abstract String getItemValueString(String arg0)
			throws NotesApiException;

	public abstract int getItemValueInteger(String arg0)
			throws NotesApiException;

	public abstract double getItemValueDouble(String arg0)
			throws NotesApiException;

	public abstract Object getItemValueCustomData(String arg0, String arg1)
			throws IOException, ClassNotFoundException, NotesApiException;

	public abstract Object getItemValueCustomData(String arg0)
			throws IOException, ClassNotFoundException, NotesApiException;

	public abstract byte[] getItemValueCustomDataBytes(String arg0, String arg1)
			throws IOException, NotesApiException;

	public abstract Vector getItemValueDateTimeArray(String arg0)
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

	public abstract void setUniversalID(String arg0) throws NotesApiException;

	public abstract String getVerifier() throws NotesApiException;

	public abstract boolean hasEmbedded() throws NotesApiException;

	public abstract boolean hasItem(String arg0) throws NotesApiException;

	public abstract boolean isEncrypted() throws NotesApiException;

	public abstract boolean isEncryptOnSend() throws NotesApiException;

	public abstract void setEncryptOnSend(boolean arg0)
			throws NotesApiException;

	public abstract boolean isNewNote() throws NotesApiException;

	public abstract boolean isProfile() throws NotesApiException;

	public abstract boolean isResponse() throws NotesApiException;

	public abstract boolean isSigned() throws NotesApiException;

	public abstract boolean isValid() throws NotesApiException;

	public abstract boolean isSaveMessageOnSend() throws NotesApiException;

	public abstract void setSaveMessageOnSend(boolean arg0)
			throws NotesApiException;

	public abstract boolean isSentByAgent() throws NotesApiException;

	public abstract boolean isSignOnSend() throws NotesApiException;

	public abstract void setSignOnSend(boolean arg0) throws NotesApiException;

	public abstract boolean isDeleted() throws NotesApiException;

	public abstract void makeResponse(NotesDocument arg0)
			throws NotesApiException;

	public abstract void putInFolder(String arg0) throws NotesApiException;

	public abstract void putInFolder(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract boolean remove(boolean arg0) throws NotesApiException;

	public abstract boolean removePermanently(boolean arg0)
			throws NotesApiException;

	public abstract void removeFromFolder(String arg0) throws NotesApiException;

	public abstract void removeItem(String arg0) throws NotesApiException;

	public abstract boolean renderToRTItem(NotesRichTextItem arg0)
			throws NotesApiException;

	public abstract NotesItem replaceItemValue(String arg0, Object arg1)
			throws NotesApiException;

	public abstract NotesItem replaceItemValueCustomData(String arg0,
			String arg1, Object arg2) throws IOException, NotesApiException;

	public abstract NotesItem replaceItemValueCustomData(String arg0,
			Object arg1) throws IOException, NotesApiException;

	public abstract NotesItem replaceItemValueCustomDataBytes(String arg0,
			String arg1, byte[] arg2) throws IOException, NotesApiException;

	public abstract boolean save(boolean arg0, boolean arg1, boolean arg2)
			throws NotesApiException;

	public abstract boolean save(boolean arg0, boolean arg1)
			throws NotesApiException;

	public abstract boolean save(boolean arg0) throws NotesApiException;

	public abstract boolean save() throws NotesApiException;

	public abstract void send(boolean arg0, Vector arg1)
			throws NotesApiException;

	public abstract void send(Vector arg0) throws NotesApiException;

	public abstract void send(boolean arg0, String arg1)
			throws NotesApiException;

	public abstract void send(String arg0) throws NotesApiException;

	public abstract void send(boolean arg0) throws NotesApiException;

	public abstract void send() throws NotesApiException;

	public abstract void sign() throws NotesApiException;

	public abstract String getURL() throws NotesApiException;

	public abstract String getNotesURL() throws NotesApiException;

	public abstract String getHttpURL() throws NotesApiException;

	public abstract String generateXML() throws NotesApiException;

	public abstract void generateXML(Writer arg0) throws NotesApiException,
			IOException;

	public abstract void generateXML(Object arg0, NotesXSLTResultTarget arg1)
			throws IOException, NotesApiException;

	public abstract Vector getReceivedItemText() throws NotesApiException;

	public abstract Vector getLockHolders() throws NotesApiException;

	public abstract boolean lock() throws NotesApiException;

	public abstract boolean lock(boolean arg0) throws NotesApiException;

	public abstract boolean lock(String arg0) throws NotesApiException;

	public abstract boolean lock(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract boolean lock(Vector arg0) throws NotesApiException;

	public abstract boolean lock(Vector arg0, boolean arg1)
			throws NotesApiException;

	public abstract boolean lockProvisional() throws NotesApiException;

	public abstract boolean lockProvisional(String arg0)
			throws NotesApiException;

	public abstract boolean lockProvisional(Vector arg0)
			throws NotesApiException;

	public abstract void unlock() throws NotesApiException;

	public abstract void markUnread() throws NotesApiException;

	public abstract void markUnread(String arg0) throws NotesApiException;

	public abstract void markRead() throws NotesApiException;

	public abstract void markRead(String arg0) throws NotesApiException;

	public abstract void attachVCard(NotesBase arg0) throws NotesApiException;

	public abstract void attachVCard(NotesBase arg0, String arg1)
			throws NotesApiException;

	public abstract boolean getRead() throws NotesApiException;

	public abstract boolean getRead(String arg0) throws NotesApiException;

	public abstract void convertToMIME() throws NotesApiException;

	public abstract void convertToMIME(int arg0) throws NotesApiException;

	public abstract void convertToMIME(int arg0, int arg1)
			throws NotesApiException;
}
