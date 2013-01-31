package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextTab extends NotesBase {
	public abstract void clear() throws NotesApiException;

	public abstract int getPosition() throws NotesApiException;

	public abstract int getType() throws NotesApiException;

}
