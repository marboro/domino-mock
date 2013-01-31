package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesRichTextNavigator extends NotesBase {
	public abstract boolean findNthElement(int arg0, int arg1)
			throws NotesApiException;

	public abstract boolean findFirstElement(int arg0) throws NotesApiException;

	public abstract boolean findNextElement() throws NotesApiException;

	public abstract boolean findNextElement(int arg0) throws NotesApiException;

	public abstract boolean findNextElement(int arg0, int arg1)
			throws NotesApiException;

	public abstract boolean findLastElement(int arg0) throws NotesApiException;

	public abstract NotesBase getElement() throws NotesApiException;

	public abstract NotesBase getNthElement(int arg0, int arg1)
			throws NotesApiException;

	public abstract NotesBase getFirstElement(int arg0)
			throws NotesApiException;

	public abstract NotesBase getNextElement() throws NotesApiException;

	public abstract NotesBase getNextElement(int arg0) throws NotesApiException;

	public abstract NotesBase getNextElement(int arg0, int arg1)
			throws NotesApiException;

	public abstract NotesBase getLastElement(int arg0) throws NotesApiException;

	public abstract boolean findFirstString(String arg0)
			throws NotesApiException;

	public abstract boolean findFirstString(String arg0, int arg1)
			throws NotesApiException;

	public abstract boolean findNextString(String arg0)
			throws NotesApiException;

	public abstract boolean findNextString(String arg0, int arg1)
			throws NotesApiException;

	public abstract NotesRichTextNavigator Clone() throws NotesApiException;

	public abstract void setPosition(NotesBase arg0) throws NotesApiException;

	public abstract void setPositionAtEnd(NotesBase arg0)
			throws NotesApiException;

	public abstract void setCharOffset(int arg0) throws NotesApiException;
}
