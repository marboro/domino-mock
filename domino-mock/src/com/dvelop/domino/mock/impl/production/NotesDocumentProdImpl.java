package com.dvelop.domino.mock.impl.production;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Vector;

import lotus.domino.DateTime;
import lotus.domino.Document;
import lotus.domino.EmbeddedObject;
import lotus.domino.Item;
import lotus.domino.NotesException;

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

public class NotesDocumentProdImpl extends NotesBaseProdImpl implements
		NotesDocument {

	private final Document doc;

	public NotesDocumentProdImpl(Document doc) {
		this.doc = doc;
	}

	public Document get() {
		return doc;
	}

	@Override
	public NotesItem appendItemValue(String arg0, Object arg1)
			throws NotesApiException {
		try {
			return new NotesItemProdImpl(doc.appendItemValue(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem appendItemValue(String arg0) throws NotesApiException {
		try {
			return new NotesItemProdImpl(doc.appendItemValue(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem appendItemValue(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesItemProdImpl(doc.appendItemValue(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem appendItemValue(String arg0, double arg1)
			throws NotesApiException {
		try {
			return new NotesItemProdImpl(doc.appendItemValue(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean closeMIMEEntities() throws NotesApiException {
		try {
			return doc.closeMIMEEntities();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean closeMIMEEntities(boolean arg0) throws NotesApiException {
		try {
			return doc.closeMIMEEntities(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean closeMIMEEntities(boolean arg0, String arg1)
			throws NotesApiException {
		try {
			return doc.closeMIMEEntities(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean computeWithForm(boolean arg0, boolean arg1)
			throws NotesApiException {
		try {
			return doc.computeWithForm(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void copyAllItems(NotesDocument arg0, boolean arg1)
			throws NotesApiException {
		try {
			NotesDocumentProdImpl document = (NotesDocumentProdImpl) arg0;
			doc.copyAllItems(document.get(), arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem copyItem(NotesItem arg0, String arg1)
			throws NotesApiException {
		try {
			NotesItemProdImpl notesItem = (NotesItemProdImpl) arg0;
			return new NotesItemProdImpl(doc.copyItem(notesItem.get(), arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem copyItem(NotesItem arg0) throws NotesApiException {
		try {
			NotesItemProdImpl notesItem = (NotesItemProdImpl) arg0;
			return new NotesItemProdImpl(doc.copyItem(notesItem.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument copyToDatabase(NotesDatabase arg0)
			throws NotesApiException {
		try {
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg0;
			return new NotesDocumentProdImpl(doc.copyToDatabase(db.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity createMIMEEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(doc.createMIMEEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity createMIMEEntity(String arg0)
			throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(doc.createMIMEEntity(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextItem createRichTextItem(String arg0)
			throws NotesApiException {
		try {
			return new NotesRichTextItemProdImpl(doc.createRichTextItem(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument createReplyMessage(boolean arg0)
			throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(doc.createReplyMessage(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void encrypt() throws NotesApiException {
		try {
			doc.encrypt();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesEmbeddedObject getAttachment(String arg0)
			throws NotesApiException {
		try {
			return new NotesEmbeddedObjectProdImpl(doc.getAttachment(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getAuthors() throws NotesApiException {
		try {
			return doc.getAuthors();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getColumnValues() throws NotesApiException {
		try {
			return doc.getColumnValues();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getCreated() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(doc.getCreated());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getEmbeddedObjects() throws NotesApiException {
		try {
			Vector<EmbeddedObject> embeddedObjects = doc.getEmbeddedObjects();
			Vector<NotesEmbeddedObject> notesEmbeddedObjects = new Vector<NotesEmbeddedObject>();
			for (EmbeddedObject embeddedObject : embeddedObjects) {
				notesEmbeddedObjects.add(new NotesEmbeddedObjectProdImpl(
						embeddedObject));
			}
			return notesEmbeddedObjects;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getEncryptionKeys() throws NotesApiException {
		try {
			return doc.getEncryptionKeys();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEncryptionKeys(Vector arg0) throws NotesApiException {
		try {
			doc.setEncryptionKeys(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem getFirstItem(String arg0) throws NotesApiException {
		try {
			return new NotesItemProdImpl(doc.getFirstItem(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFTSearchScore() throws NotesApiException {
		try {
			return doc.getFTSearchScore();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastAccessed() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(doc.getLastAccessed());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastModified() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(doc.getLastModified());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getFolderReferences() throws NotesApiException {
		try {
			return doc.getFolderReferences();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getMIMEEntity() throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(doc.getMIMEEntity());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesMIMEEntity getMIMEEntity(String arg0) throws NotesApiException {
		try {
			return new NotesMIMEEntityProdImpl(doc.getMIMEEntity(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getItems() throws NotesApiException {
		try {
			Vector<Item> items = doc.getItems();
			Vector<NotesItem> notesItems = new Vector<NotesItem>();
			for (Item item : items) {
				notesItems.add(new NotesItemProdImpl(item));
			}
			return notesItems;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getItemValue(String arg0) throws NotesApiException {
		try {
			Vector itemValue = doc.getItemValue(arg0);
			Vector<NotesDateTime> notesItemValues = new Vector<NotesDateTime>();
			if (itemValue.size() > 0) {
				if (itemValue.get(0) instanceof DateTime) {
					Iterator iterator = itemValue.iterator();
					while (iterator.hasNext()) {
						notesItemValues.add(new NotesDateTimeProdImpl(
								(DateTime) iterator.next()));
					}
					return notesItemValues;
				}
			}
			return itemValue;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getItemValueString(String arg0) throws NotesApiException {
		try {
			return doc.getItemValueString(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getItemValueInteger(String arg0) throws NotesApiException {
		try {
			return doc.getItemValueInteger(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public double getItemValueDouble(String arg0) throws NotesApiException {
		try {
			return doc.getItemValueDouble(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getItemValueCustomData(String arg0, String arg1)
			throws IOException, ClassNotFoundException, NotesApiException {
		try {
			return doc.getItemValueCustomData(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getItemValueCustomData(String arg0) throws IOException,
			ClassNotFoundException, NotesApiException {
		try {
			return doc.getItemValueCustomData(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public byte[] getItemValueCustomDataBytes(String arg0, String arg1)
			throws IOException, NotesApiException {
		try {
			return doc.getItemValueCustomDataBytes(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getItemValueDateTimeArray(String arg0)
			throws NotesApiException {
		try {
			Vector itemValue = doc.getItemValueDateTimeArray(arg0);
			Vector<NotesDateTime> notesItemValues = new Vector<NotesDateTime>();
			if (itemValue.size() > 0) {
				if (itemValue.get(0) instanceof DateTime) {
					Iterator iterator = itemValue.iterator();
					while (iterator.hasNext()) {
						notesItemValues.add(new NotesDateTimeProdImpl(
								(DateTime) iterator.next()));
					}
					return notesItemValues;
				}
			}
			return itemValue;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getKey() throws NotesApiException {
		try {
			return doc.getKey();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNameOfProfile() throws NotesApiException {
		try {
			return doc.getNameOfProfile();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNoteID() throws NotesApiException {
		try {
			return doc.getNoteID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParentDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(doc.getParentDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getParentDocumentUNID() throws NotesApiException {
		try {
			return doc.getParentDocumentUNID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView getParentView() throws NotesApiException {
		try {
			return new NotesViewProdImpl(doc.getParentView());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getResponses() throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(doc.getResponses());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSigner() throws NotesApiException {
		try {
			return doc.getSigner();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getSize() throws NotesApiException {
		try {
			return doc.getSize();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		try {
			return doc.getUniversalID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setUniversalID(String arg0) throws NotesApiException {
		try {
			doc.setUniversalID(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getVerifier() throws NotesApiException {
		try {
			return doc.getVerifier();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean hasEmbedded() throws NotesApiException {
		try {
			return doc.hasEmbedded();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean hasItem(String arg0) throws NotesApiException {
		try {
			return doc.hasItem(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isEncrypted() throws NotesApiException {
		try {
			return doc.isEncrypted();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isEncryptOnSend() throws NotesApiException {
		try {
			return doc.isEncryptOnSend();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEncryptOnSend(boolean arg0) throws NotesApiException {
		try {
			doc.setEncryptOnSend(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isNewNote() throws NotesApiException {
		try {
			return doc.isNewNote();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isProfile() throws NotesApiException {
		try {
			return doc.isProfile();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isResponse() throws NotesApiException {
		try {
			return doc.isResponse();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSigned() throws NotesApiException {
		try {
			return doc.isSigned();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isValid() throws NotesApiException {
		try {
			return doc.isValid();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSaveMessageOnSend() throws NotesApiException {
		try {
			return doc.isSaveMessageOnSend();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSaveMessageOnSend(boolean arg0) throws NotesApiException {
		try {
			doc.setSaveMessageOnSend(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSentByAgent() throws NotesApiException {
		try {
			return doc.isSentByAgent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isSignOnSend() throws NotesApiException {
		try {
			return doc.isSignOnSend();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSignOnSend(boolean arg0) throws NotesApiException {
		try {
			doc.setSignOnSend(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isDeleted() throws NotesApiException {
		try {
			return doc.isDeleted();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void makeResponse(NotesDocument arg0) throws NotesApiException {
		try {
			NotesDocumentProdImpl document = (NotesDocumentProdImpl) arg0;
			doc.makeResponse(document.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void putInFolder(String arg0) throws NotesApiException {
		try {
			doc.putInFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void putInFolder(String arg0, boolean arg1) throws NotesApiException {
		try {
			doc.putInFolder(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean remove(boolean arg0) throws NotesApiException {
		try {
			return doc.remove(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean removePermanently(boolean arg0) throws NotesApiException {
		try {
			return doc.removePermanently(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeFromFolder(String arg0) throws NotesApiException {
		try {
			doc.removeFromFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void removeItem(String arg0) throws NotesApiException {
		try {
			doc.removeItem(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean renderToRTItem(NotesRichTextItem arg0)
			throws NotesApiException {
		try {
			NotesRichTextItemProdImpl rtItem = (NotesRichTextItemProdImpl) arg0;
			return doc.renderToRTItem(rtItem.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem replaceItemValue(String arg0, Object arg1)
			throws NotesApiException {
		try {
			return new NotesItemProdImpl(doc.replaceItemValue(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem replaceItemValueCustomData(String arg0, String arg1,
			Object arg2) throws IOException, NotesApiException {
		try {
			return new NotesItemProdImpl(doc.replaceItemValueCustomData(arg0,
					arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem replaceItemValueCustomData(String arg0, Object arg1)
			throws IOException, NotesApiException {
		try {
			return new NotesItemProdImpl(doc.replaceItemValueCustomData(arg0,
					arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesItem replaceItemValueCustomDataBytes(String arg0, String arg1,
			byte[] arg2) throws IOException, NotesApiException {
		try {
			return new NotesItemProdImpl(doc.replaceItemValueCustomDataBytes(
					arg0, arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean save(boolean arg0, boolean arg1, boolean arg2)
			throws NotesApiException {
		try {
			return doc.save(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean save(boolean arg0, boolean arg1) throws NotesApiException {
		try {
			return doc.save(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean save(boolean arg0) throws NotesApiException {
		try {
			return doc.save(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean save() throws NotesApiException {
		try {
			return doc.save();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void send(boolean arg0, Vector arg1) throws NotesApiException {
		try {
			doc.send(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void send(Vector arg0) throws NotesApiException {
		try {
			doc.send(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void send(boolean arg0, String arg1) throws NotesApiException {
		try {
			doc.send(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void send(String arg0) throws NotesApiException {
		try {
			doc.send(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void send(boolean arg0) throws NotesApiException {
		try {
			doc.send(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void send() throws NotesApiException {
		try {
			doc.send();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void sign() throws NotesApiException {
		try {
			doc.sign();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getURL() throws NotesApiException {
		try {
			return doc.getURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNotesURL() throws NotesApiException {
		try {
			return doc.getNotesURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getHttpURL() throws NotesApiException {
		try {
			return doc.getHttpURL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String generateXML() throws NotesApiException {
		try {
			return doc.generateXML();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void generateXML(Writer arg0) throws NotesApiException, IOException {
		try {
			doc.generateXML(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void generateXML(Object arg0, NotesXSLTResultTarget arg1)
			throws IOException, NotesApiException {
		try {
			NotesXSLTResultTargetProdImpl xslResult = (NotesXSLTResultTargetProdImpl) arg1;
			doc.generateXML(arg0, xslResult.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getReceivedItemText() throws NotesApiException {
		try {
			return doc.getReceivedItemText();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getLockHolders() throws NotesApiException {
		try {
			return doc.getLockHolders();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock() throws NotesApiException {
		try {
			return doc.lock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(boolean arg0) throws NotesApiException {
		try {
			return doc.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0) throws NotesApiException {
		try {
			return doc.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(String arg0, boolean arg1) throws NotesApiException {
		try {
			return doc.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0) throws NotesApiException {
		try {
			return doc.lock(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lock(Vector arg0, boolean arg1) throws NotesApiException {
		try {
			return doc.lock(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional() throws NotesApiException {
		try {
			return doc.lockProvisional();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(String arg0) throws NotesApiException {
		try {
			return doc.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean lockProvisional(Vector arg0) throws NotesApiException {
		try {
			return doc.lockProvisional(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void unlock() throws NotesApiException {
		try {
			doc.unlock();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markUnread() throws NotesApiException {
		try {
			doc.markUnread();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markUnread(String arg0) throws NotesApiException {
		try {
			doc.markUnread(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markRead() throws NotesApiException {
		try {
			doc.markRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markRead(String arg0) throws NotesApiException {
		try {
			doc.markRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void attachVCard(NotesBase arg0) throws NotesApiException {
		try {
			NotesBaseProdImpl base = (NotesBaseProdImpl) arg0;
			doc.attachVCard(base.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void attachVCard(NotesBase arg0, String arg1)
			throws NotesApiException {
		try {
			NotesBaseProdImpl base = (NotesBaseProdImpl) arg0;
			doc.attachVCard(base.get(), arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getRead() throws NotesApiException {
		try {
			return doc.getRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getRead(String arg0) throws NotesApiException {
		try {
			return doc.getRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void convertToMIME() throws NotesApiException {
		try {
			doc.convertToMIME();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void convertToMIME(int arg0) throws NotesApiException {
		try {
			doc.convertToMIME(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void convertToMIME(int arg0, int arg1) throws NotesApiException {
		try {
			doc.convertToMIME(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}