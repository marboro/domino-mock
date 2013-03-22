package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesRichTextTab extends NotesBase {
	public abstract void clear() throws NotesApiException;

	public abstract int getPosition() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

}
