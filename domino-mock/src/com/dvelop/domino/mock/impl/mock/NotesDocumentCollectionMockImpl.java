package com.dvelop.domino.mock.impl.mock;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;

public class NotesDocumentCollectionMockImpl extends NotesBaseMockImpl
		implements NotesDocumentCollection {

	@Override
	public int getCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getQuery() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getFirstDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getLastDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNextDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getPrevDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNthDocument(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getNextDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getPrevDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocument(NotesDocument arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addDocument(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addDocument(NotesDocument arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteDocument(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void FTSearch(String arg0, int arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSorted() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void putAllInFolder(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void putAllInFolder(String arg0, boolean arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAll(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAllFromFolder(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void stampAll(String arg0, Object arg1) throws NotesApiException {
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
	public void markAllRead(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void markAllUnread(String arg0) throws NotesApiException {
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
	public void intersect(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void intersect(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void merge(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void subtract(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean contains(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(NotesBase arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public NotesDocumentCollection cloneCollection() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}