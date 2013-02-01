package com.dvelop.domino.mock.impl.production;

import java.util.Iterator;
import java.util.Vector;

import lotus.domino.DateTime;
import lotus.domino.NotesException;
import lotus.domino.View;
import lotus.domino.ViewEntry;
import lotus.domino.ViewEntryCollection;
import lotus.domino.ViewNavigator;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesViewEntry;

public class NotesViewEntryProdImpl extends NotesBaseProdImpl implements
		NotesViewEntry {

	private final ViewEntry viewEntry;

	public NotesViewEntryProdImpl(ViewEntry viewEntry) {
		this.viewEntry = viewEntry;
	}

	public ViewEntry get() {
		return viewEntry;
	}

	@Override
	public boolean isDocument() throws NotesApiException {
		try {
			return viewEntry.isDocument();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isCategory() throws NotesApiException {
		try {
			return viewEntry.isCategory();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isTotal() throws NotesApiException {
		try {
			return viewEntry.isTotal();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Object getParent() throws NotesApiException {
		try {
			Object parent = viewEntry.getParent();
			if (parent instanceof View) {
				return new NotesViewProdImpl((View) parent);
			} else if (parent instanceof ViewEntryCollection) {
				return new NotesViewEntryCollectionProdImpl(
						(ViewEntryCollection) parent);
			} else if (parent instanceof ViewNavigator) {
				return new NotesViewNavigatorProdImpl((ViewNavigator) parent);
			}
			return null;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocument() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(viewEntry.getDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getSiblingCount() throws NotesApiException {
		try {
			return viewEntry.getSiblingCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getChildCount() throws NotesApiException {
		try {
			return viewEntry.getChildCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getDescendantCount() throws NotesApiException {
		try {
			return viewEntry.getDescendantCount();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getIndentLevel() throws NotesApiException {
		try {
			return viewEntry.getIndentLevel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getColumnIndentLevel() throws NotesApiException {
		try {
			return viewEntry.getColumnIndentLevel();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getPosition(char arg0) throws NotesApiException {
		try {
			return viewEntry.getPosition(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getNoteID() throws NotesApiException {
		try {
			return viewEntry.getNoteID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getUniversalID() throws NotesApiException {
		try {
			return viewEntry.getUniversalID();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isConflict() throws NotesApiException {
		try {
			return viewEntry.isConflict();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public Vector getColumnValues() throws NotesApiException {
		try {
			Vector columnValues = viewEntry.getColumnValues();
			if (columnValues.size() > 0) {
				if (columnValues.get(0) instanceof DateTime) {
					Vector<NotesDateTime> vector = new Vector<NotesDateTime>();
					Iterator iterator = columnValues.iterator();
					while (iterator.hasNext()) {
						vector.add(new NotesDateTimeProdImpl(
								(DateTime) iterator.next()));
					}
					return vector;
				}
			}
			return columnValues;

		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getFTSearchScore() throws NotesApiException {
		try {
			return viewEntry.getFTSearchScore();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isValid() throws NotesApiException {
		try {
			return viewEntry.isValid();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getRead() throws NotesApiException {
		try {
			return viewEntry.getRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean getRead(String arg0) throws NotesApiException {
		try {
			return viewEntry.getRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}