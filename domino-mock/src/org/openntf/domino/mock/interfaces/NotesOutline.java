package org.openntf.domino.mock.interfaces;

import org.openntf.domino.mock.Exception.NotesApiException;

public interface NotesOutline extends NotesBase {
	public abstract int save() throws NotesApiException;

	public abstract NotesOutlineEntry getParent(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract NotesOutlineEntry getNext(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract NotesOutlineEntry getPrev(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract NotesOutlineEntry getNextSibling(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract NotesOutlineEntry getPrevSibling(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract NotesOutlineEntry getChild(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract NotesOutlineEntry getFirst() throws NotesApiException;

	public abstract NotesOutlineEntry getLast() throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String arg0)
			throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String entryName,
			NotesOutlineEntry referenceEntry) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String entryName,
			NotesOutlineEntry referenceEntry, boolean after) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(String entryName,
			NotesOutlineEntry referenceEntry, boolean after, boolean asChild)
			throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry fromEntry)
			throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry fromEntry,
			NotesOutlineEntry referenceEntry) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry fromEntry,
			NotesOutlineEntry referenceEntry, boolean after) throws NotesApiException;

	public abstract NotesOutlineEntry createEntry(NotesOutlineEntry fromEntry,
			NotesOutlineEntry referenceEntry, boolean after, boolean asChild)
			throws NotesApiException;

	public abstract void addEntry(NotesOutlineEntry entry, NotesOutlineEntry referenceEntry)
			throws NotesApiException;

	public abstract void addEntry(NotesOutlineEntry entry,
			NotesOutlineEntry referenceEntry, boolean after) throws NotesApiException;

	public abstract void addEntry(NotesOutlineEntry entry,
			NotesOutlineEntry referenceEntry, boolean after, boolean asChild)
			throws NotesApiException;

	public abstract void removeEntry(NotesOutlineEntry entry)
			throws NotesApiException;

	public abstract void moveEntry(NotesOutlineEntry entry,
			NotesOutlineEntry referenceEntry) throws NotesApiException;

	public abstract void moveEntry(NotesOutlineEntry entry,
			NotesOutlineEntry referenceEntry, boolean after) throws NotesApiException;

	public abstract void moveEntry(NotesOutlineEntry entry,
			NotesOutlineEntry referenceEntry, boolean after, boolean asChild)
			throws NotesApiException;

	public abstract String getName() throws NotesApiException;

	public abstract String getAlias() throws NotesApiException;

	public abstract String getComment() throws NotesApiException;

	public abstract NotesDatabase getParentDatabase() throws NotesApiException;

	public abstract void setName(String name) throws NotesApiException;

	public abstract void setAlias(String value) throws NotesApiException;

	public abstract void setComment(String value) throws NotesApiException;
}
