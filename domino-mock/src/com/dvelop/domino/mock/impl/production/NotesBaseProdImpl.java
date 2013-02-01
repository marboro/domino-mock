package com.dvelop.domino.mock.impl.production;

import java.util.Vector;

import lotus.domino.Base;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;

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