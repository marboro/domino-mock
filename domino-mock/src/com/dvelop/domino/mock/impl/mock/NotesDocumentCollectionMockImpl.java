package com.dvelop.domino.mock.impl.mock;

import java.util.ArrayList;
import java.util.List;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;

public class NotesDocumentCollectionMockImpl extends NotesBaseMockImpl implements NotesDocumentCollection {

	private NotesDatabase parent;
	private List<NotesDocument> documents;
	private int currentDoc;

	public NotesDocumentCollectionMockImpl() {
		documents = new ArrayList<NotesDocument>();
	}

	public NotesDocumentCollectionMockImpl(NotesDocumentCollection documentCollection) {
		try {
			this.parent = documentCollection.getParent();
		} catch (NotesApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.documents = ((NotesDocumentCollectionMockImpl) documentCollection).getDocuments();
		this.currentDoc = 0;
	}

	public List<NotesDocument> getDocuments() {
		return documents;
	}

	@Override
	public int getCount() throws NotesApiException {
		return documents.size();
	}

	@Override
	public String getQuery() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		return parent;
	}

	@Override
	public NotesDocument getFirstDocument() throws NotesApiException {
		if (documents.size() > 0) {
			currentDoc = 0;
			return documents.get(currentDoc);
		}
		return null;
	}

	@Override
	public NotesDocument getLastDocument() throws NotesApiException {
		if (documents.size() > 0) {
			currentDoc = documents.size() - 1;
			return documents.get(currentDoc);
		}
		return null;
	}

	@Override
	public NotesDocument getNthDocument(int n) throws NotesApiException {
		if (documents.size() >= n) {
			currentDoc = n - 1;
			return documents.get(currentDoc);
		}
		return null;
	}

	@Override
	public NotesDocument getNextDocument(NotesDocument doc) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getPrevDocument(NotesDocument doc) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNextDocument() throws NotesApiException {
		if (documents.size() > currentDoc) {
			currentDoc++;
			return documents.get(currentDoc);
		}
		return null;
	}

	@Override
	public NotesDocument getPrevDocument() throws NotesApiException {
		if (documents.size() >= currentDoc) {
			currentDoc--;
			return documents.get(currentDoc);
		}
		return null;
	}

	@Override
	public NotesDocument getDocument(NotesDocument doc) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDocument(NotesDocument doc) throws NotesApiException {
		documents.add(doc);

	}

	@Override
	public void addDocument(NotesDocument doc, boolean checkDups) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDocument(NotesDocument doc) throws NotesApiException {
		documents.remove(doc);
	}

	@Override
	public void FTSearch(String query) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String query, int maxDocs) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSorted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putAllInFolder(String folderName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAllInFolder(String folderName, boolean createOnFail) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll(boolean force) throws NotesApiException {
		documents.clear();
	}

	@Override
	public void removeAllFromFolder(String folderName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void stampAll(String itemName, Object value) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateAll() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDateTime getUntilTime() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void markAllRead(String userName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread(String userName) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllRead() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread() throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(int noteID) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(String noteID) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(NotesBase documents) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(int noteID) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(String noteID) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(NotesBase documents) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(int noteID) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(String noteID) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(NotesBase documents) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(int noteID) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String noteID) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(NotesBase documents) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesDocumentCollection cloneCollection() throws NotesApiException {
		return new NotesDocumentCollectionMockImpl(this);
	}

}