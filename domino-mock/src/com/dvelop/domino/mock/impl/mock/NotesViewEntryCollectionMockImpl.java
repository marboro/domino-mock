package com.dvelop.domino.mock.impl.mock;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesView;
import com.dvelop.domino.mock.interfaces.NotesViewEntry;
import com.dvelop.domino.mock.interfaces.NotesViewEntryCollection;

public class NotesViewEntryCollectionMockImpl extends NotesBaseMockImpl
		implements NotesViewEntryCollection {

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
	public NotesView getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getFirstEntry() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getNextEntry() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getPrevEntry() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getLastEntry() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getNthEntry(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getNextEntry(NotesViewEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getPrevEntry(NotesViewEntry arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesViewEntry getEntry(Object arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addEntry(Object arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEntry(Object arg0, boolean arg1) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteEntry(NotesViewEntry arg0) throws NotesApiException {
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
	public NotesViewEntryCollection cloneCollection() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}