package com.dvelop.domino.mock.impl.mock;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;
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

	private Map<String, NotesItem> items;

	public NotesDocumentMockImpl() {
		items = new HashMap<String, NotesItem>();
	}

	@Override
	public NotesItem appendItemValue(String name, Object value) throws NotesApiException {
		NotesItemMockImpl item = new NotesItemMockImpl(name);
		try {
			item.setValueCustomData(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotesApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		items.put(name, item);
		return item;
	}

	@Override
	public NotesItem appendItemValue(String name) throws NotesApiException {
		NotesItemMockImpl item = new NotesItemMockImpl(name);
		items.put(name, item);
		return item;
	}

	@Override
	public NotesItem appendItemValue(String name, int value) throws NotesApiException {
		NotesItemMockImpl item = new NotesItemMockImpl(name);
		try {
			item.setValueInteger(value);
		} catch (NotesApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		items.put(name, item);
		return item;
	}

	@Override
	public NotesItem appendItemValue(String name, double value) throws NotesApiException {
		NotesItemMockImpl item = new NotesItemMockImpl(name);
		try {
			item.setValueDouble(value);
		} catch (NotesApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		items.put(name, item);
		return item;
	}

	@Override
	public boolean closeMIMEEntities() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeMIMEEntities(boolean saveChanges) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean closeMIMEEntities(boolean saveChanges, String entityItemName) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean computeWithForm(boolean doDataTypes, boolean raiseError) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void copyAllItems(NotesDocument doc, boolean replace) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesItem copyItem(NotesItem item, String newName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem copyItem(NotesItem item) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument copyToDatabase(NotesDatabase db) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createMIMEEntity() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesMIMEEntity createMIMEEntity(String itemName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesRichTextItem createRichTextItem(String name) throws NotesApiException {
		NotesRichTextItemMockImpl rtItem = new NotesRichTextItemMockImpl(name);
		items.put(name, rtItem);
		return rtItem;
	}

	@Override
	public NotesDocument createReplyMessage(boolean toAll) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void encrypt() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesEmbeddedObject getAttachment(String filename) throws NotesApiException {
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
	public void setEncryptionKeys(Vector keys) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesItem getFirstItem(String name) throws NotesApiException {
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
	public NotesMIMEEntity getMIMEEntity(String itemName) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getItems() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getItemValue(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getItemValueString(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getItemValueInteger(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getItemValueDouble(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getItemValueCustomData(String itemName, String dataTypeName) throws IOException, ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getItemValueCustomData(String itemName) throws IOException, ClassNotFoundException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] getItemValueCustomDataBytes(String itemName, String dataTypeName) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getItemValueDateTimeArray(String name) throws NotesApiException {
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
	public void setUniversalID(String unid) throws NotesApiException {
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
	public boolean hasItem(String name) throws NotesApiException {
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
	public void setEncryptOnSend(boolean flag) throws NotesApiException {
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
	public void setSaveMessageOnSend(boolean flag) throws NotesApiException {
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
	public void setSignOnSend(boolean flag) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDeleted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void makeResponse(NotesDocument doc) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String name) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String name, boolean createOnFail) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean remove(boolean force) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removePermanently(boolean force) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFromFolder(String name) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeItem(String name) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean renderToRTItem(NotesRichTextItem rtItem) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesItem replaceItemValue(String itemName, Object value) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomData(String itemName, String dataTypeName, Object userObj) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomData(String itemName, Object userObj) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomDataBytes(String itemName, String dataTypeName, byte[] byteArray) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save(boolean force, boolean makeRespoonse, boolean markRead) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(boolean force, boolean makeResponse) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save(boolean force) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean save() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void send(boolean attachForm, Vector recipients) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(Vector recipients) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(boolean attachForm, String recipient) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(String recipient) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void send(boolean attachForm) throws NotesApiException {
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
	public void generateXML(Writer writer) throws NotesApiException, IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateXML(Object style, NotesXSLTResultTarget result) throws IOException, NotesApiException {
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
	public boolean lock(boolean provisionalOk) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(String name, boolean provisionalOk) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lock(Vector names, boolean provisionalOk) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(String name) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean lockProvisional(Vector names) throws NotesApiException {
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
	public void markUnread(String userName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markRead() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markRead(String userName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachVCard(NotesBase document) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void attachVCard(NotesBase document, String fileName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean getRead() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getRead(String userName) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void convertToMIME() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToMIME(int conversionType) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void convertToMIME(int conversionType, int options) throws NotesApiException {
		// TODO Auto-generated method stub

	}

}