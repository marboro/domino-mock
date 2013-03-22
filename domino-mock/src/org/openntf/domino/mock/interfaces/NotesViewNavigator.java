package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesViewNavigator extends NotesBase {
	public abstract boolean gotoFirst() throws NotesApiException;

	public abstract NotesViewEntry getFirst() throws NotesApiException;

	public abstract boolean gotoFirstDocument() throws NotesApiException;

	public abstract NotesViewEntry getFirstDocument() throws NotesApiException;

	public abstract boolean gotoNext() throws NotesApiException;

	public abstract NotesViewEntry getNext() throws NotesApiException;

	public abstract boolean gotoNextCategory() throws NotesApiException;

	public abstract boolean gotoNextDocument() throws NotesApiException;

	public abstract NotesViewEntry getNextCategory() throws NotesApiException;

	public abstract NotesViewEntry getNextDocument() throws NotesApiException;

	public abstract boolean gotoPrev() throws NotesApiException;

	public abstract NotesViewEntry getPrev() throws NotesApiException;

	public abstract boolean gotoPrevCategory() throws NotesApiException;

	public abstract boolean gotoPrevDocument() throws NotesApiException;

	public abstract NotesViewEntry getPrevCategory() throws NotesApiException;

	public abstract NotesViewEntry getPrevDocument() throws NotesApiException;

	public abstract NotesViewEntry getCurrent() throws NotesApiException;

	public abstract boolean gotoLast() throws NotesApiException;

	public abstract NotesViewEntry getLast() throws NotesApiException;

	public abstract boolean gotoLastDocument() throws NotesApiException;

	public abstract NotesViewEntry getLastDocument() throws NotesApiException;

	public abstract boolean gotoPos(String pos, char separator)
			throws NotesApiException;

	public abstract NotesViewEntry getPos(String pos, char separator)
			throws NotesApiException;

	public abstract NotesViewEntry getNth(int arg0) throws NotesApiException;

	public abstract boolean gotoChild() throws NotesApiException;

	public abstract NotesViewEntry getChild() throws NotesApiException;

	public abstract boolean gotoNextSibling() throws NotesApiException;

	public abstract NotesViewEntry getNextSibling() throws NotesApiException;

	public abstract boolean gotoPrevSibling() throws NotesApiException;

	public abstract NotesViewEntry getPrevSibling() throws NotesApiException;

	public abstract boolean gotoParent() throws NotesApiException;

	public abstract NotesViewEntry getParent() throws NotesApiException;

	public abstract boolean gotoEntry(Object entry) throws NotesApiException;

	public abstract boolean gotoNext(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getNext(NotesViewEntry entry)
			throws NotesApiException;

	public abstract boolean gotoPrev(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getPrev(NotesViewEntry entry)
			throws NotesApiException;

	public abstract boolean gotoChild(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getChild(NotesViewEntry entry)
			throws NotesApiException;

	public abstract boolean gotoNextSibling(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getNextSibling(NotesViewEntry entry)
			throws NotesApiException;

	public abstract boolean gotoPrevSibling(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getPrevSibling(NotesViewEntry entry)
			throws NotesApiException;

	public abstract boolean gotoParent(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getParent(NotesViewEntry entry)
			throws NotesApiException;

	public abstract int getCacheSize();

	public abstract void setCacheSize(int cachesize) throws NotesApiException;

	public abstract int getMaxLevel();

	public abstract void setMaxLevel(int level) throws NotesApiException;

	public abstract NotesView getParentView();

	public abstract int getCount();

	public abstract void markAllRead(String username) throws NotesApiException;

	public abstract void markAllUnread(String username)
			throws NotesApiException;

	public abstract void markAllRead() throws NotesApiException;

	public abstract void markAllUnread() throws NotesApiException;
}
