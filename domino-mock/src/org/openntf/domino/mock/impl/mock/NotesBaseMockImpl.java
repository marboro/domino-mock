package org.openntf.domino.mock.impl.mock;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesBase;


public class NotesBaseMockImpl implements NotesBase {

	private boolean isRecycled;

	@Override
	public void recycle() throws NotesApiException {
		this.isRecycled = true;
	}

	@Override
	public void recycle(Vector arg0) throws NotesApiException {
		for (Object object : arg0) {
			if (object instanceof NotesBase) {
				((NotesBase) object).recycle();
			}
		}

	}
}