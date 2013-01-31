package com.dvelop.domino.mock.impl.production;

import lotus.domino.Document;
import lotus.domino.NotesException;
import lotus.domino.ViewEntry;
import lotus.domino.ViewNavigator;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesView;
import com.dvelop.domino.mock.interfaces.NotesViewEntry;
import com.dvelop.domino.mock.interfaces.NotesViewNavigator;

public class NotesViewNavigatorProdImpl extends NotesBaseProdImpl implements
		NotesViewNavigator {

	private final ViewNavigator navigator;

	public NotesViewNavigatorProdImpl(ViewNavigator navigator) {
		this.navigator = navigator;
	}

	public ViewNavigator get() {
		return navigator;
	}

	@Override
	public boolean gotoFirst() throws NotesApiException {
		try {
			return navigator.gotoFirst();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getFirst() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getFirst());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoFirstDocument() throws NotesApiException {
		try {
			return navigator.gotoFirstDocument();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getFirstDocument() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getFirstDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoNext() throws NotesApiException {
		try {
			return navigator.gotoNext();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNext() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getNext());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoNextCategory() throws NotesApiException {
		try {
			return navigator.gotoNextCategory();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoNextDocument() throws NotesApiException {
		try {
			return navigator.gotoNextDocument();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNextCategory() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getNextCategory());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNextDocument() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getNextDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPrev() throws NotesApiException {
		try {
			return navigator.gotoPrev();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrev() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getPrev());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPrevCategory() throws NotesApiException {
		try {
			return navigator.gotoPrevCategory();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPrevDocument() throws NotesApiException {
		try {
			return navigator.gotoPrevDocument();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrevCategory() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getPrevCategory());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrevDocument() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getPrevDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getCurrent() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getCurrent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoLast() throws NotesApiException {
		try {
			return navigator.gotoLast();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getLast() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getLast());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoLastDocument() throws NotesApiException {
		try {
			return navigator.gotoLastDocument();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getLastDocument() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getLastDocument());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPos(String arg0, char arg1) throws NotesApiException {
		try {
			return navigator.gotoPos(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPos(String arg0, char arg1)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getPos(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNth(int arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getNth(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoChild() throws NotesApiException {
		try {
			return navigator.gotoChild();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getChild() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getChild());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoNextSibling() throws NotesApiException {
		try {
			return navigator.gotoNextSibling();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNextSibling() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getNextSibling());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPrevSibling() throws NotesApiException {
		try {
			return navigator.gotoPrevSibling();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrevSibling() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getPrevSibling());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoParent() throws NotesApiException {
		try {
			return navigator.gotoParent();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getParent() throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(navigator.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoEntry(Object arg0) throws NotesApiException {
		try {
			if (arg0 instanceof Document) {
				return navigator.gotoEntry((Document) arg0);
			} else if (arg0 instanceof ViewEntry) {
				return navigator.gotoEntry((ViewEntry) arg0);
			}
			return false;
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoNext(NotesViewEntry arg0) throws NotesApiException {
		try {
			return navigator.gotoNext(((NotesViewEntryProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNext(NotesViewEntry arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					navigator.getNext(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPrev(NotesViewEntry arg0) throws NotesApiException {
		try {
			return navigator.gotoPrev(((NotesViewEntryProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrev(NotesViewEntry arg0) throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					navigator.getPrev(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoChild(NotesViewEntry arg0) throws NotesApiException {
		try {
			return navigator.gotoChild(((NotesViewEntryProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getChild(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					navigator.getChild(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoNextSibling(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return navigator.gotoNextSibling(((NotesViewEntryProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getNextSibling(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					navigator.getNextSibling(((NotesViewEntryProdImpl) arg0)
							.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoPrevSibling(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return navigator.gotoPrevSibling(((NotesViewEntryProdImpl) arg0)
					.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getPrevSibling(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					navigator.getPrevSibling(((NotesViewEntryProdImpl) arg0)
							.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean gotoParent(NotesViewEntry arg0) throws NotesApiException {
		try {
			return navigator.gotoParent(((NotesViewEntryProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesViewEntry getParent(NotesViewEntry arg0)
			throws NotesApiException {
		try {
			return new NotesViewEntryProdImpl(
					navigator.getParent(((NotesViewEntryProdImpl) arg0).get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getCacheSize() {
		return navigator.getCacheSize();
	}

	@Override
	public void setCacheSize(int arg0) throws NotesApiException {
		try {
			navigator.setCacheSize(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getMaxLevel() {
		return navigator.getMaxLevel();
	}

	@Override
	public void setMaxLevel(int arg0) throws NotesApiException {
		try {
			navigator.setMaxLevel(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesView getParentView() {
		return new NotesViewProdImpl(navigator.getParentView());
	}

	@Override
	public int getCount() {
		return navigator.getCount();
	}

	@Override
	public void markAllRead(String arg0) throws NotesApiException {
		try {
			navigator.markAllRead(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllUnread(String arg0) throws NotesApiException {
		try {
			navigator.markAllUnread(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllRead() throws NotesApiException {
		try {
			navigator.markAllRead();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void markAllUnread() throws NotesApiException {
		try {
			navigator.markAllUnread();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}