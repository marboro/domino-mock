package com.dvelop.domino.mock.interfaces;

import java.util.Vector;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesViewEntry extends NotesBase {
	public static final byte TYPE_DOCUMENT = 1;
	public static final byte TYPE_CATEGORY = 2;
	public static final byte TYPE_TOTAL = 3;

	public abstract boolean isDocument() throws NotesApiException;

	public abstract boolean isCategory() throws NotesApiException;

	public abstract boolean isTotal() throws NotesApiException;

	public abstract Object getParent() throws NotesApiException;

	public abstract NotesDocument getDocument() throws NotesApiException;

	public abstract int getSiblingCount() throws NotesApiException;

	public abstract int getChildCount() throws NotesApiException;

	public abstract int getDescendantCount() throws NotesApiException;

	public abstract int getIndentLevel() throws NotesApiException;

	public abstract int getColumnIndentLevel() throws NotesApiException;

	public abstract String getPosition(char arg0) throws NotesApiException;

	public abstract String getNoteID() throws NotesApiException;

	public abstract String getUniversalID() throws NotesApiException;

	public abstract boolean isConflict() throws NotesApiException;

	public abstract Vector getColumnValues() throws NotesApiException;

	public abstract int getFTSearchScore() throws NotesApiException;

	public abstract boolean isValid() throws NotesApiException;

	public abstract boolean getRead() throws NotesApiException;

	public abstract boolean getRead(String arg0) throws NotesApiException;
}
