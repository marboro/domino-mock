package org.openntf.domino.mock.impl.mock;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDirectoryNavigator;

public class NotesDirectoryNavigatorMockImpl extends NotesBaseMockImpl implements NotesDirectoryNavigator {

	private String currentView;
	private long currentMatch;
	private Vector matches;
	private String currentName;

	public void setCurrentView(String currentView) {
		this.currentView = currentView;
	}

	@Override
	public String getCurrentView() throws NotesApiException {
		return currentView;
	}

	@Override
	public long getCurrentMatch() throws NotesApiException {
		return currentMatch;
	}

	@Override
	public long getCurrentMatches() throws NotesApiException {
		return matches.size();
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
		return currentName;
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
		if (matches.size() > 0) {
			currentMatch = 1;
			currentName = (String) matches.get(0);
			return true;
		}
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