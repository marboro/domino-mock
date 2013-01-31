package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.RichTextNavigator;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesRichTextNavigator;

public class NotesRichTextNavigatorProdImpl extends NotesBaseProdImpl implements
		NotesRichTextNavigator {

	private final RichTextNavigator navigator;

	public NotesRichTextNavigatorProdImpl(RichTextNavigator navigator) {
		this.navigator = navigator;
	}

	public RichTextNavigator get() {
		return navigator;
	}

	@Override
	public boolean findNthElement(int arg0, int arg1) throws NotesApiException {
		try {
			return navigator.findNthElement(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findFirstElement(int arg0) throws NotesApiException {
		try {
			return navigator.findFirstElement(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNextElement() throws NotesApiException {
		try {
			return navigator.findNextElement();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNextElement(int arg0) throws NotesApiException {
		try {
			return navigator.findNextElement(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNextElement(int arg0, int arg1) throws NotesApiException {
		try {
			return navigator.findNextElement(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findLastElement(int arg0) throws NotesApiException {
		try {
			return navigator.findLastElement(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getElement() throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getElement());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getNthElement(int arg0, int arg1) throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getNthElement(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getFirstElement(int arg0) throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getFirstElement(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getNextElement() throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getNextElement());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getNextElement(int arg0) throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getNextElement(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getNextElement(int arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getNextElement(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesBase getLastElement(int arg0) throws NotesApiException {
		try {
			return new NotesBaseProdImpl(navigator.getLastElement(arg0));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findFirstString(String arg0) throws NotesApiException {
		try {
			return navigator.findFirstString(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findFirstString(String arg0, int arg1)
			throws NotesApiException {
		try {
			return navigator.findFirstString(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNextString(String arg0) throws NotesApiException {
		try {
			return navigator.findNextString(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean findNextString(String arg0, int arg1)
			throws NotesApiException {
		try {
			return navigator.findNextString(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextNavigator Clone() throws NotesApiException {
		try {
			return new NotesRichTextNavigatorProdImpl(navigator.Clone());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPosition(NotesBase arg0) throws NotesApiException {
		try {
			navigator.setPosition(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setPositionAtEnd(NotesBase arg0) throws NotesApiException {
		try {
			navigator.setPositionAtEnd(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void setCharOffset(int arg0) throws NotesApiException {
		try {
			navigator.setCharOffset(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}