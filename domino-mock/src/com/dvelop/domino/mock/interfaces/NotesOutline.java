package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesOutline extends NotesBase {
	public abstract int save() throws NotesApiException;

	public abstract NotesOutlineEntry getParent(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry getNext(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry getPrev(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry getNextSibling(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry getPrevSibling(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry getChild(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry getFirst() throws NotesApiException;

	public abstract NotesOutlineEntry getLast() throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String arg0,
			NotesOutlineEntry arg1) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String arg0,
			NotesOutlineEntry arg1, boolean arg2) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String arg0,
			NotesOutlineEntry arg1, boolean arg2, boolean arg3)
			throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2, boolean arg3)
			throws NotesApiException;

	public abstract void addEntry(NotesOutlineEntry arg0, NotesOutlineEntry arg1)
			throws NotesApiException;

	public abstract void addEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2) throws NotesApiException;

	public abstract void addEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2, boolean arg3)
			throws NotesApiException;

	public abstract void removeEntry(NotesOutlineEntry arg0)
			throws NotesApiException;

	public abstract void moveEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1) throws NotesApiException;

	public abstract void moveEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2) throws NotesApiException;

	public abstract void moveEntry(NotesOutlineEntry arg0,
			NotesOutlineEntry arg1, boolean arg2, boolean arg3)
			throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract String getAlias() throws NotesApiException;

	public abstract String getComment() throws NotesApiException;

	public abstract NotesDatabase getParentDatabase() throws NotesApiException;

	public abstract void setName(String arg0) throws NotesApiException;

	public abstract void setAlias(String arg0) throws NotesApiException;

	public abstract void setComment(String arg0) throws NotesApiException;
}
