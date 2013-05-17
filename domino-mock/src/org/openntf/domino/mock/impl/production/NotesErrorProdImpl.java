package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.interfaces.NotesError;

public class NotesErrorProdImpl implements NotesError {

	@Override
	public String getErrorString(int errorNumber) {
		// lotus.domino.NotesErrorHelper.
		// TODO Error forwarden
		return "";
	}

}
