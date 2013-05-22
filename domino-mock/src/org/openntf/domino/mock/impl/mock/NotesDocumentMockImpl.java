package org.openntf.domino.mock.impl.mock;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesBase;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;
import org.openntf.domino.mock.interfaces.NotesEmbeddedObject;
import org.openntf.domino.mock.interfaces.NotesForm;
import org.openntf.domino.mock.interfaces.NotesItem;
import org.openntf.domino.mock.interfaces.NotesMIMEEntity;
import org.openntf.domino.mock.interfaces.NotesRichTextItem;
import org.openntf.domino.mock.interfaces.NotesView;
import org.openntf.domino.mock.interfaces.NotesXSLTResultTarget;

public class NotesDocumentMockImpl extends NotesBaseMockImpl implements NotesDocument {

	private Map<String, NotesItem> items;
	private boolean encrypted;
	private Vector encryptionKeys;
	private boolean encryptOnSend;
	private boolean newNote;
	private boolean isProfile;
	private boolean isResponse;
	private boolean isSigned;
	private boolean isValid;
	private boolean saveMessageOnSend;
	private boolean isSentByAgent;
	private boolean isSignedOnSend;
	private boolean isDeleted;
	private Vector authors;
	private NotesDateTime created;
	private Map<String, NotesEmbeddedObject> embeddedObjects;
	private NotesDateTime lastAccessed;
	private NotesDateTime lastModified;
	private Vector folderReferences;
	private String key;
	private String profileName;
	private String noteID;
	private NotesDatabase parentDatabase;
	private NotesDocument parentDocument;
	private NotesView parentView;
	private String signer;
	private int size;
	private String universalID;
	private String verifier;
	private String formName;
	private NotesForm form;
	private boolean isSend;
	private String url;
	private String notesURL;
	private String httpURL;
	private List<String> readBy;
	private boolean provisionalok;
	private Vector lockedBy;
	private boolean isSaved;

	public NotesDocumentMockImpl() {
		UUID uuid = UUID.randomUUID();
		universalID = uuid.toString();
		items = new HashMap<String, NotesItem>();
		readBy = new ArrayList<String>();
		lockedBy = new Vector();
		this.created = new NotesDateTimeMockImpl(new Date());
	}

	public NotesDocumentMockImpl(NotesDocument doc) throws NotesApiException {
		this();
		this.encrypted = doc.isEncrypted();
		this.encryptionKeys = doc.getEncryptionKeys();
		this.encryptOnSend = doc.isEncryptOnSend();
		this.isDeleted = doc.isDeleted();
		this.isProfile = doc.isProfile();
		this.isResponse = doc.isResponse();
		this.isSentByAgent = doc.isSentByAgent();
		this.isSigned = doc.isSigned();
		this.isSignedOnSend = doc.isSignOnSend();
		this.isValid = doc.isValid();
		this.newNote = doc.isNewNote();
		this.saveMessageOnSend = doc.isSaveMessageOnSend();
		doc.copyAllItems(this, true);
	}

	public void addNotesItem(String name, Object value, int type) {
		try {
			NotesItemMockImpl notesItem = new NotesItemMockImpl(name);
			notesItem.setType(type);
			Vector<Object> vector = new Vector();
			vector.addElement(value);
			notesItem.setValues(vector);
			addNotesItem(notesItem);
		} catch (NotesApiException e) {
			e.printStackTrace();
		}

	}

	public void addNotesItem(NotesItem item) {
		try {
			items.put(item.getName(), item);
		} catch (NotesApiException e) {
			e.printStackTrace();
		}
	}

	@Override
	public NotesItem appendItemValue(String name, Object value) throws NotesApiException {
		NotesItemMockImpl item = new NotesItemMockImpl(name);
		try {
			item.setValueCustomData(value);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NotesApiException e) {
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
			e.printStackTrace();
		}
		items.put(name, item);
		return item;
	}

	@Override
	public boolean closeMIMEEntities() throws NotesApiException {
		return closeMIMEEntities(false, "Body");
	}

	@Override
	public boolean closeMIMEEntities(boolean saveChanges) throws NotesApiException {
		return closeMIMEEntities(saveChanges, "Body");
	}

	@Override
	public boolean closeMIMEEntities(boolean saveChanges, String entityItemName) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean computeWithForm(boolean doDataTypes, boolean raiseError) throws NotesApiException {
		// TODO Validate
		return isValid;
	}

	@Override
	public void copyAllItems(NotesDocument doc, boolean replace) throws NotesApiException {
		for (NotesItem item : items.values()) {
			if (!doc.hasItem(item.getName()) || replace) {
				doc.copyItem(item);
			}
		}

	}

	@Override
	public NotesItem copyItem(NotesItem item, String newName) throws NotesApiException {
		NotesItemMockImpl newItem = new NotesItemMockImpl(item);
		newItem.setName(newName);
		items.put(newName, newItem);
		return items.get(newName);
	}

	@Override
	public NotesItem copyItem(NotesItem item) throws NotesApiException {
		NotesItemMockImpl newItem = new NotesItemMockImpl(item);
		items.put(item.getName(), newItem);
		return items.get(item.getName());
	}

	@Override
	public NotesDocument copyToDatabase(NotesDatabase db) throws NotesApiException {
		return (NotesDocumentMockImpl) ((NotesDatabaseMockImpl) db).addDocument(this);
	}

	@Override
	public NotesMIMEEntity createMIMEEntity() throws NotesApiException {
		return createMIMEEntity("Body");
	}

	@Override
	public NotesMIMEEntity createMIMEEntity(String itemName) throws NotesApiException {
		NotesItemMockImpl item = new NotesItemMockImpl(itemName);
		item.setType(NotesItem.MIME_PART);
		return item.getMIMEEntity();
	}

	@Override
	public NotesRichTextItem createRichTextItem(String name) throws NotesApiException {
		NotesRichTextItemMockImpl rtItem = new NotesRichTextItemMockImpl(name);
		items.put(name, rtItem);
		return rtItem;
	}

	@Override
	public NotesDocument createReplyMessage(boolean toAll) throws NotesApiException {
		NotesDocumentMockImpl doc = new NotesDocumentMockImpl();
		doc.copyItem(items.get("From"), "SendTo");
		doc.appendItemValue("SendTo", items.get("SendTo").getValues());
		doc.copyItem(items.get("CopyTo"));
		doc.copyItem(items.get("BlindCopyTo"));
		return doc;
	}

	@Override
	public void encrypt() throws NotesApiException {
		encrypted = true;
	}

	@Override
	public NotesEmbeddedObject getAttachment(String filename) throws NotesApiException {
		return embeddedObjects.get(filename);
	}

	@Override
	public Vector getAuthors() throws NotesApiException {
		return authors;
	}

	@Override
	public Vector getColumnValues() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		return created;
	}

	@Override
	public Vector getEmbeddedObjects() throws NotesApiException {
		return new Vector(embeddedObjects.values());
	}

	@Override
	public Vector getEncryptionKeys() throws NotesApiException {
		return encryptionKeys;
	}

	@Override
	public void setEncryptionKeys(Vector encryptionKeys) throws NotesApiException {
		this.encryptionKeys = encryptionKeys;

	}

	@Override
	public NotesItem getFirstItem(String name) throws NotesApiException {
		NotesItem notesItem = null;
		if (items.containsKey(name)) {
			notesItem = items.get(name);
		}
		return notesItem;
	}

	@Override
	public int getFTSearchScore() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDateTime getLastAccessed() throws NotesApiException {
		return lastAccessed;
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		return lastModified;
	}

	@Override
	public Vector getFolderReferences() throws NotesApiException {
		return folderReferences;
	}

	@Override
	public NotesMIMEEntity getMIMEEntity() throws NotesApiException {
		return getMIMEEntity("Body");
	}

	@Override
	public NotesMIMEEntity getMIMEEntity(String itemName) throws NotesApiException {
		return items.get(itemName).getMIMEEntity();
	}

	@Override
	public Vector getItems() throws NotesApiException {
		return new Vector(items.values());
	}

	@Override
	public Vector getItemValue(String name) throws NotesApiException {
		return items.get(name).getValues();
	}

	@Override
	public String getItemValueString(String name) throws NotesApiException {
		return items.get(name).getValueString();
	}

	@Override
	public int getItemValueInteger(String name) throws NotesApiException {
		return items.get(name).getValueInteger();
	}

	@Override
	public double getItemValueDouble(String name) throws NotesApiException {
		return items.get(name).getValueDouble();
	}

	@Override
	public Object getItemValueCustomData(String itemName, String dataTypeName) throws IOException, ClassNotFoundException, NotesApiException {
		return items.get(itemName).getValueCustomData(dataTypeName);
	}

	@Override
	public Object getItemValueCustomData(String itemName) throws IOException, ClassNotFoundException, NotesApiException {
		return getItemValueCustomData(itemName, "");
	}

	@Override
	public byte[] getItemValueCustomDataBytes(String itemName, String dataTypeName) throws IOException, NotesApiException {
		return items.get(itemName).getValueCustomDataBytes(dataTypeName);
	}

	@Override
	public Vector getItemValueDateTimeArray(String name) throws NotesApiException {
		return items.get(name).getValueDateTimeArray();
	}

	@Override
	public String getKey() throws NotesApiException {
		if (isProfile) {
			return key;
		}
		return null;
	}

	@Override
	public String getNameOfProfile() throws NotesApiException {
		if (isProfile) {
			return profileName;
		}
		return null;
	}

	@Override
	public String getNoteID() throws NotesApiException {
		return noteID;
	}

	@Override
	public NotesDatabase getParentDatabase() throws NotesApiException {
		return parentDatabase;
	}

	@Override
	public String getParentDocumentUNID() throws NotesApiException {
		return parentDocument.getUniversalID();
	}

	@Override
	public NotesView getParentView() throws NotesApiException {
		return parentView;
	}

	@Override
	public NotesDocumentCollection getResponses() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSigner() throws NotesApiException {
		return signer;
	}

	@Override
	public int getSize() throws NotesApiException {
		return size;
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		return universalID;
	}

	@Override
	public void setUniversalID(String unid) throws NotesApiException {
		this.universalID = unid;
	}

	@Override
	public String getVerifier() throws NotesApiException {
		return verifier;
	}

	@Override
	public boolean hasEmbedded() throws NotesApiException {
		if (!embeddedObjects.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean hasItem(String name) throws NotesApiException {
		if (items.containsKey(name)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isEncrypted() throws NotesApiException {
		return encrypted;

	}

	@Override
	public boolean isEncryptOnSend() throws NotesApiException {
		return encryptOnSend;

	}

	@Override
	public void setEncryptOnSend(boolean encryptOnSend) throws NotesApiException {
		this.encryptOnSend = encryptOnSend;
	}

	@Override
	public boolean isNewNote() throws NotesApiException {
		return newNote;
	}

	@Override
	public boolean isProfile() throws NotesApiException {
		return isProfile;
	}

	@Override
	public boolean isResponse() throws NotesApiException {
		return isResponse;
	}

	@Override
	public boolean isSigned() throws NotesApiException {
		return isSigned;
	}

	@Override
	public boolean isValid() throws NotesApiException {
		return isValid;
	}

	@Override
	public boolean isSaveMessageOnSend() throws NotesApiException {
		return saveMessageOnSend;
	}

	@Override
	public void setSaveMessageOnSend(boolean saveMessageOnSend) throws NotesApiException {
		this.saveMessageOnSend = saveMessageOnSend;
	}

	@Override
	public boolean isSentByAgent() throws NotesApiException {
		return isSentByAgent;
	}

	@Override
	public boolean isSignOnSend() throws NotesApiException {
		return isSignedOnSend;
	}

	@Override
	public void setSignOnSend(boolean isSignedOnSend) throws NotesApiException {
		this.isSignedOnSend = isSignedOnSend;
	}

	@Override
	public boolean isDeleted() throws NotesApiException {
		return isDeleted;
	}

	@Override
	public void makeResponse(NotesDocument doc) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putInFolder(String name) throws NotesApiException {
		putInFolder(name, true);
	}

	@Override
	public void putInFolder(String name, boolean createOnFail) throws NotesApiException {
		if (parentDatabase.getView(name) == null) {
			if (createOnFail) {
				NotesViewMockImpl folder = (NotesViewMockImpl) parentDatabase.createView(name);
				folder.setIsFolder(true);
			} else {
				throw new NotesApiException(new IllegalArgumentException("Folder does not exist"));
			}
		}
		folderReferences.add(name);

	}

	@Override
	public boolean remove(boolean force) throws NotesApiException {
		// TODO what to do on force?
		isDeleted = true;
		return isDeleted;
	}

	@Override
	public boolean removePermanently(boolean force) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeFromFolder(String name) throws NotesApiException {
		folderReferences.removeElement(name);
	}

	@Override
	public void removeItem(String name) throws NotesApiException {
		items.remove(name);
	}

	@Override
	public boolean renderToRTItem(NotesRichTextItem rtItem) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesItem replaceItemValue(String itemName, Object value) throws NotesApiException {
		NotesItemMockImpl newItem = (NotesItemMockImpl) items.get(itemName);
		if (newItem == null) {
			newItem = new NotesItemMockImpl(itemName);
			items.put(itemName, newItem);
		}
		if (value instanceof String) {
			newItem.setValueString((String) value);
		} else if (value instanceof Integer) {
			newItem.setValueInteger((Integer) value);
		} else if (value instanceof Double) {
			newItem.setValueDouble((Double) value);
		} else if (value instanceof NotesDateTime) {
			newItem.setDateTimeValue((NotesDateTime) value);
		} else if (value instanceof Vector) {
			newItem.setValues((Vector) value);
		} else if (value instanceof NotesItem) {
			newItem.setValues(((NotesItem) value).getValues());
		}
		return newItem;
	}

	@Override
	public NotesItem replaceItemValueCustomData(String itemName, String dataTypeName, Object userObj) throws IOException, NotesApiException {
		NotesItemMockImpl newItem = (NotesItemMockImpl) items.get(itemName);
		if (newItem == null) {
			newItem = new NotesItemMockImpl(itemName);
			items.put(itemName, newItem);
		}
		newItem.setValueCustomData(dataTypeName, userObj);
		return newItem;
	}

	@Override
	public NotesItem replaceItemValueCustomData(String itemName, Object userObj) throws IOException, NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesItem replaceItemValueCustomDataBytes(String itemName, String dataTypeName, byte[] byteArray) throws IOException, NotesApiException {
		NotesItemMockImpl newItem = (NotesItemMockImpl) items.get(itemName);
		if (newItem == null) {
			newItem = new NotesItemMockImpl(itemName);
			items.put(itemName, newItem);
		}
		newItem.setValueCustomDataBytes(dataTypeName, byteArray);
		return newItem;
	}

	@Override
	public boolean save(boolean force, boolean makeRespoonse, boolean markRead) throws NotesApiException {
		// TODO save changes
		// boolean forceIf true, the document is saved even if someone else
		// edits and saves the document while the program is running. The last
		// version of the document that was saved wins; the earlier version is
		// discarded.
		//
		// If false, and someone else edits the document while the program is
		// running, the makeresponse argument determines what happens.
		//
		// boolean makeresponseIf true, the current document becomes a response
		// to the original document (this is what the replicator does when
		// there's a replication conflict). If false, the save is canceled. If
		// the force parameter is true, the makeresponse parameter has no
		// effect.
		//
		// boolean markreadIf true, the document is marked as read on behalf of
		// the current user ID. If false (default), the document is not marked
		// as read.
		//
		// Note If the database does not track unread marks, all documents are
		// considered read, and this parameter has no effect.
		this.isSaved = true;
		return isSaved;
	}

	public boolean isSaved() {
		return isSaved;
	}

	@Override
	public boolean save(boolean force, boolean makeResponse) throws NotesApiException {
		return save(force, makeResponse, false);
	}

	@Override
	public boolean save(boolean force) throws NotesApiException {
		return save(force, false, false);
	}

	@Override
	public boolean save() throws NotesApiException {
		return save(false, false, false);
	}

	@Override
	public void send(boolean attachForm, Vector recipients) throws NotesApiException {
		if (!hasItem("SendTo")) {
			replaceItemValue("SendTo", recipients);
		}
		if (attachForm) {
			form = parentDatabase.getForm(this.formName);
		}
		appendItemValue("$AssistMail", 1);
		replaceItemValue("From", parentDatabase.getParent().getUserName());
		isSend = true;
	}

	@Override
	public void send(Vector recipients) throws NotesApiException {
		send(false, recipients);

	}

	@Override
	public void send(boolean attachForm, String recipient) throws NotesApiException {
		Vector recipients = new Vector();
		if (!"".equalsIgnoreCase(recipient))
			recipients.add(recipient);
		send(attachForm, recipients);

	}

	@Override
	public void send(String recipient) throws NotesApiException {
		send(false, recipient);

	}

	@Override
	public void send(boolean attachForm) throws NotesApiException {
		send(attachForm, "");

	}

	@Override
	public void send() throws NotesApiException {
		send(false, "");

	}

	@Override
	public void sign() throws NotesApiException {
		signer = parentDatabase.getParent().getUserName();
		isSigned = true;
	}

	@Override
	public String getURL() throws NotesApiException {
		return url;
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		return notesURL;
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		return httpURL;
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
		return lockedBy;
	}

	@Override
	public boolean lock() throws NotesApiException {
		return lock(false);
	}

	@Override
	public boolean lock(boolean provisionalok) throws NotesApiException {
		return lock(parentDatabase.getParent().getUserName(), provisionalok);
	}

	@Override
	public boolean lock(String name) throws NotesApiException {
		return lock(name, false);
	}

	@Override
	public boolean lock(String name, boolean provisionalok) throws NotesApiException {
		Vector vector = new Vector();
		vector.add(name);
		return lock(vector, provisionalok);
	}

	@Override
	public boolean lock(Vector names) throws NotesApiException {
		return lock(names, false);
	}

	@Override
	public boolean lock(Vector names, boolean provisionalok) throws NotesApiException {
		if (names.isEmpty() || "".equalsIgnoreCase((String) names.firstElement())) {
			return false;
		}

		if (lockedBy.isEmpty() || lockedBy.containsAll(names)) {
			lockedBy.addAll(names);
			this.provisionalok = provisionalok;
			return true;
		}
		return false;
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		return lock(true);
	}

	@Override
	public boolean lockProvisional(String name) throws NotesApiException {
		return lock(name, true);
	}

	@Override
	public boolean lockProvisional(Vector names) throws NotesApiException {
		return lock(names, true);
	}

	@Override
	public void unlock() throws NotesApiException {
		this.provisionalok = false;
		lockedBy.removeAllElements();
	}

	@Override
	public void markUnread() throws NotesApiException {
		markUnread(parentDatabase.getParent().getUserName());

	}

	@Override
	public void markUnread(String userName) throws NotesApiException {
		readBy.remove(userName);

	}

	@Override
	public void markRead() throws NotesApiException {
		markRead(parentDatabase.getParent().getUserName());

	}

	@Override
	public void markRead(String userName) throws NotesApiException {
		readBy.add(userName);

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
		return getRead(parentDatabase.getParent().getUserName());
	}

	@Override
	public boolean getRead(String userName) throws NotesApiException {
		return readBy.contains(userName);
	}

	@Override
	public void convertToMIME() throws NotesApiException {
		convertToMIME(CVT_RT_TO_PLAINTEXT_AND_HTML, 0);
	}

	@Override
	public void convertToMIME(int conversionType) throws NotesApiException {
		convertToMIME(conversionType, 0);
	}

	@Override
	public void convertToMIME(int conversionType, int options) throws NotesApiException {
		// TODO Auto-generated method stub

	}

}