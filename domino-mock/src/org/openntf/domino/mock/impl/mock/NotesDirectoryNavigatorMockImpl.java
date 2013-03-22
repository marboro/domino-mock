package org.openntf.domino.mock.impl.mock;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDirectoryNavigator;


public class NotesDirectoryNavigatorMockImpl extends NotesBaseMockImpl
		implements NotesDirectoryNavigator {

	@Override
	public String getCurrentView() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getCurrentMatch() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long getCurrentMatches() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCurrentItem() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNameLocated() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isMatchLocated() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getCurrentName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long findFirstName() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long findNextName() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long findNthName(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean findFirstMatch() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNextMatch() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findNthMatch(long arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Vector getFirstItemValue() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getNextItemValue() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getNthItemValue(int arg0) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}