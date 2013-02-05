package com.dvelop.domino.mock.impl.mock;

import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;
import com.dvelop.domino.mock.interfaces.NotesEmbeddedObject;
import com.dvelop.domino.mock.interfaces.NotesItem;
import com.dvelop.domino.mock.interfaces.NotesMIMEEntity;
import com.dvelop.domino.mock.interfaces.NotesRichTextItem;
import com.dvelop.domino.mock.interfaces.NotesView;
import com.dvelop.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesDocumentMockImpl extends NotesBaseMockImpl implements NotesDocument {

	@Override
	public NotesItem appendItemValue(String arg0, Object arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem appendItemValue(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem appendItemValue(String arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem appendItemValue(String arg0, double arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean closeMIMEEntities() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeMIMEEntities(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeMIMEEntities(boolean arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean computeWithForm(boolean arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void copyAllItems(NotesDocument arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesItem copyItem(NotesItem arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem copyItem(NotesItem arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument copyToDatabase(NotesDatabase arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createMIMEEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createMIMEEntity(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextItem createRichTextItem(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument createReplyMessage(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encrypt() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesEmbeddedObject getAttachment(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getAuthors() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getColumnValues() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getEmbeddedObjects() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getEncryptionKeys() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setEncryptionKeys(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesItem getFirstItem(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFTSearchScore() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDateTime getLastAccessed() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getFolderReferences() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getMIMEEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity getMIMEEntity(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getItems() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getItemValue(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getItemValueString(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getItemValueInteger(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getItemValueDouble(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItemValueCustomData(String arg0, String arg1) throws IOException, ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItemValueCustomData(String arg0) throws IOException, ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getItemValueCustomDataBytes(String arg0, String arg1) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getItemValueDateTimeArray(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getKey() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameOfProfile() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoteID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParentDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getParentDocumentUNID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesView getParentView() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getResponses() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSigner() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSize() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setUniversalID(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getVerifier() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasEmbedded() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasItem(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEncrypted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEncryptOnSend() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setEncryptOnSend(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isNewNote() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isProfile() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isResponse() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSigned() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValid() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSaveMessageOnSend() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSaveMessageOnSend(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSentByAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isSignOnSend() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setSignOnSend(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDeleted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeResponse(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePermanently(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFromFolder(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItem(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderToRTItem(NotesRichTextItem arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesItem replaceItemValue(String arg0, Object arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomData(String arg0, String arg1, Object arg2) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomData(String arg0, Object arg1) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomDataBytes(String arg0, String arg1, byte[] arg2) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(boolean arg0, boolean arg1, boolean arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(boolean arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void send(boolean arg0, Vector arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(boolean arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void sign() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateXML() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void generateXML(Writer arg0) throws NotesApiException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateXML(Object arg0, NotesXSLTResultTarget arg1) throws IOException, NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public Vector getReceivedItemText() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean lock() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void unlock() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markUnread() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markUnread(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markRead() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markRead(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachVCard(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachVCard(NotesBase arg0, String arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getRead() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRead(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void convertToMIME() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToMIME(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToMIME(int arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		// TODO getUniversalID
		return super.toString();
	}
}