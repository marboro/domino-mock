package org.openntf.domino.mock.interfaces;

import java.util.Vector;

import org.openntf.domino.mock.Exception.NotesApiException;


public interface NotesDirectoryNavigator extends NotesBase {
	public abstract String getCurrentView() throws NotesApiException;

	public abstract long getCurrentMatch() throws NotesApiException;

	public abstract long getCurrentMatches() throws NotesApiException;

	public abstract String getCurrentItem() throws NotesApiException;

	public abstract boolean isNameLocated() throws NotesApiException;

	public abstract boolean isMatchLocated() throws NotesApiException;

	public abstract String getCurrentName() throws NotesApiException;

	public abstract long findFirstName() throws NotesApiException;

	public abstract long findNextName() throws NotesApiException;

	public abstract long findNthName(int n) throws NotesApiException;

	public abstract boolean findFirstMatch() throws NotesApiException;

	public abstract boolean findNextMatch() throws NotesApiException;

	public abstract boolean findNthMatch(long n) throws NotesApiException;

	public abstract Vector getFirstItemValue() throws NotesApiException;

	public abstract Vector getNextItemValue() throws NotesApiException;

	public abstract Vector getNthItemValue(int n) throws NotesApiException;
}
