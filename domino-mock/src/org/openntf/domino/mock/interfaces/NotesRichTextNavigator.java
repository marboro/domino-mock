package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesRichTextNavigator extends NotesBase {
	public abstract boolean findNthElement(int type, int occurrence)
			throws NotesApiException;

	public abstract boolean findFirstElement(int type) throws NotesApiException;

	public abstract boolean findNextElement() throws NotesApiException;

	public abstract boolean findNextElement(int type) throws NotesApiException;

	public abstract boolean findNextElement(int type, int occurrence)
			throws NotesApiException;

	public abstract boolean findLastElement(int type) throws NotesApiException;

	public abstract NotesBase getElement() throws NotesApiException;

	public abstract NotesBase getNthElement(int tpe, int occurrence)
			throws NotesApiException;

	public abstract NotesBase getFirstElement(int type)
			throws NotesApiException;

	public abstract NotesBase getNextElement() throws NotesApiException;

	public abstract NotesBase getNextElement(int type) throws NotesApiException;

	public abstract NotesBase getNextElement(int type, int occurrence)
			throws NotesApiException;

	public abstract NotesBase getLastElement(int type) throws NotesApiException;

	public abstract boolean findFirstString(String target)
			throws NotesApiException;

	public abstract boolean findFirstString(String target, int options)
			throws NotesApiException;

	public abstract boolean findNextString(String target)
			throws NotesApiException;

	public abstract boolean findNextString(String target, int options)
			throws NotesApiException;

	public abstract NotesRichTextNavigator Clone() throws NotesApiException;

	public abstract void setPosition(NotesBase element)
			throws NotesApiException;

	public abstract void setPositionAtEnd(NotesBase element)
			throws NotesApiException;

	public abstract void setCharOffset(int offset) throws NotesApiException;
}
