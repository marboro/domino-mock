package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesBase {
	public abstract void recycle() throws NotesApiException;

	public abstract void recycle(Vector objects) throws NotesApiException;
}
