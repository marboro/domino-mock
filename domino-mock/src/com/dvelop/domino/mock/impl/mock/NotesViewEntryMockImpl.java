package com.dvelop.domino.mock.impl.mock;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesViewEntry;

public class NotesViewEntryMockImpl extends NotesBaseMockImpl implements
		NotesViewEntry {

	@Override
	public boolean isDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCategory() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTotal() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocument() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getSiblingCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getChildCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getDescendantCount() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndentLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnIndentLevel() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getPosition(char arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNoteID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isConflict() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector getColumnValues() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getFTSearchScore() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isValid() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
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
}