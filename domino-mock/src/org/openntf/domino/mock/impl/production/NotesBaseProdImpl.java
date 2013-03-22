package org.openntf.domino.mock.impl.production;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesBase;

import lotus.domino.Base;
import lotus.domino.NotesException;


public class NotesBaseProdImpl implements NotesBase {

	private Base base = null;

	public NotesBaseProdImpl(Base base) {
		this.base = base;
	}

	public NotesBaseProdImpl() {
		super();
	}

	@Override
	public void recycle() throws NotesApiException {
		try {
			base.recycle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void recycle(Vector arg0) throws NotesApiException {
		try {
			base.recycle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	public Base get() {
		return base;
	}
}