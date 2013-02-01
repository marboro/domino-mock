package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.DirectoryNavigator;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDirectoryNavigator;

public class NotesDirectoryNavigatorProdImpl extends NotesBaseProdImpl
		implements NotesDirectoryNavigator {

	private final DirectoryNavigator directoryNavigator;

	public NotesDirectoryNavigatorProdImpl(DirectoryNavigator directoryNavigator) {
		this.directoryNavigator = directoryNavigator;
	}

	public DirectoryNavigator get() {
		return directoryNavigator;
	}

	@Override
	public String getCurrentView() throws NotesApiException {
		try {
			return directoryNavigator.getCurrentView();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long getCurrentMatch() throws NotesApiException {
		try {
			return directoryNavigator.getCurrentMatch();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long getCurrentMatches() throws NotesApiException {
		try {
			return directoryNavigator.getCurrentMatches();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCurrentItem() throws NotesApiException {
		try {
			return directoryNavigator.getCurrentItem();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isNameLocated() throws NotesApiException {
		try {
			return directoryNavigator.isNameLocated();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isMatchLocated() throws NotesApiException {
		try {
			return directoryNavigator.isMatchLocated();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getCurrentName() throws NotesApiException {
		try {
			return directoryNavigator.getCurrentName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long findFirstName() throws NotesApiException {
		try {
			return directoryNavigator.findFirstName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long findNextName() throws NotesApiException {
		try {
			return directoryNavigator.findNextName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public long findNthName(int arg0) throws NotesApiException {
		try {
			return directoryNavigator.findNthName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findFirstMatch() throws NotesApiException {
		try {
			return directoryNavigator.findFirstMatch();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNextMatch() throws NotesApiException {
		try {
			return directoryNavigator.findNextMatch();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNthMatch(long arg0) throws NotesApiException {
		try {
			return directoryNavigator.findNthMatch(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getFirstItemValue() throws NotesApiException {
		try {
			return directoryNavigator.getFirstItemValue();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getNextItemValue() throws NotesApiException {
		try {
			return directoryNavigator.getNextItemValue();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getNthItemValue(int arg0) throws NotesApiException {
		try {
			return directoryNavigator.getNthItemValue(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}