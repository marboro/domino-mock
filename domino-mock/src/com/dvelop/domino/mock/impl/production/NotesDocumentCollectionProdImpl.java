package com.dvelop.domino.mock.impl.production;

import lotus.domino.DocumentCollection;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;

public class NotesDocumentCollectionProdImpl extends NotesBaseProdImpl
		implements NotesDocumentCollection {

	private final DocumentCollection docCol;

	public NotesDocumentCollectionProdImpl(DocumentCollection docCol) {
		this.docCol = docCol;
	}

	public DocumentCollection get() {
		return docCol;

	}

	@Override
	public int getCount() throws NotesApiException {
		try {
			return docCol.getCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getQuery() throws NotesApiException {
		try {
			return docCol.getQuery();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(docCol.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getFirstDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(docCol.getFirstDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getLastDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(docCol.getLastDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getNextDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			return new NotesDocumentProdImpl(docCol.getNextDocument(doc.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getPrevDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			return new NotesDocumentProdImpl(docCol.getPrevDocument(doc.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getNthDocument(int arg0) throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(docCol.getNthDocument(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getNextDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(docCol.getNextDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getPrevDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(docCol.getPrevDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocument(NotesDocument arg0)
			throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			return new NotesDocumentProdImpl(docCol.getDocument(doc.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void addDocument(NotesDocument arg0) throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			docCol.addDocument(doc.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void addDocument(NotesDocument arg0, boolean arg1)
			throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			docCol.addDocument(doc.get(), arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void deleteDocument(NotesDocument arg0) throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			docCol.deleteDocument(doc.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void FTSearch(String arg0) throws NotesApiException {
		try {
			docCol.FTSearch(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void FTSearch(String arg0, int arg1) throws NotesApiException {
		try {
			docCol.FTSearch(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isSorted() throws NotesApiException {
		try {
			return docCol.isSorted();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void putAllInFolder(String arg0) throws NotesApiException {
		try {
			docCol.putAllInFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void putAllInFolder(String arg0, boolean arg1)
			throws NotesApiException {
		try {
			docCol.putAllInFolder(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void removeAll(boolean arg0) throws NotesApiException {
		try {
			docCol.removeAll(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void removeAllFromFolder(String arg0) throws NotesApiException {
		try {
			docCol.removeAllFromFolder(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void stampAll(String arg0, Object arg1) throws NotesApiException {
		try {
			docCol.stampAll(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void updateAll() throws NotesApiException {
		try {
			docCol.updateAll();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesDateTime getUntilTime() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(docCol.getUntilTime());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllRead(String arg0) throws NotesApiException {
		try {
			docCol.markAllRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void markAllUnread(String arg0) throws NotesApiException {
		try {
			docCol.markAllUnread(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void markAllRead() throws NotesApiException {
		try {
			docCol.markAllRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void markAllUnread() throws NotesApiException {
		try {
			docCol.markAllUnread();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void intersect(int arg0) throws NotesApiException {
		try {
			docCol.intersect(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void intersect(String arg0) throws NotesApiException {
		try {
			docCol.intersect(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void intersect(NotesBase arg0) throws NotesApiException {
		try {
			NotesBaseProdImpl base = (NotesBaseProdImpl) arg0;
			docCol.intersect(base.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void merge(int arg0) throws NotesApiException {
		try {
			docCol.merge(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void merge(String arg0) throws NotesApiException {
		try {
			docCol.merge(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void merge(NotesBase arg0) throws NotesApiException {
		try {
			NotesBaseProdImpl base = (NotesBaseProdImpl) arg0;
			docCol.merge(base.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void subtract(int arg0) throws NotesApiException {
		try {
			docCol.subtract(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void subtract(String arg0) throws NotesApiException {
		try {
			docCol.subtract(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void subtract(NotesBase arg0) throws NotesApiException {
		try {
			NotesBaseProdImpl base = (NotesBaseProdImpl) arg0;
			docCol.subtract(base.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean contains(int arg0) throws NotesApiException {
		try {
			return docCol.contains(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean contains(String arg0) throws NotesApiException {
		try {
			return docCol.contains(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean contains(NotesBase arg0) throws NotesApiException {
		try {
			NotesBaseProdImpl base = (NotesBaseProdImpl) arg0;
			return docCol.contains(base.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection cloneCollection() throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(docCol.cloneCollection());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}