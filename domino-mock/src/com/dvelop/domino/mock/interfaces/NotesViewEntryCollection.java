package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesViewEntryCollection extends NotesBase {
	public abstract int getCount() throws NotesApiException;

	public abstract String getQuery() throws NotesApiException;

	public abstract NotesView getParent() throws NotesApiException;

	public abstract NotesViewEntry getFirstEntry() throws NotesApiException;

	public abstract NotesViewEntry getNextEntry() throws NotesApiException;

	public abstract NotesViewEntry getPrevEntry() throws NotesApiException;

	public abstract NotesViewEntry getLastEntry() throws NotesApiException;

	public abstract NotesViewEntry getNthEntry(int n) throws NotesApiException;

	public abstract NotesViewEntry getNextEntry(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getPrevEntry(NotesViewEntry entry)
			throws NotesApiException;

	public abstract NotesViewEntry getEntry(Object entry)
			throws NotesApiException;

	public abstract void addEntry(Object obj) throws NotesApiException;

	public abstract void addEntry(Object obj, boolean checkDups)
			throws NotesApiException;

	public abstract void deleteEntry(NotesViewEntry entry)
			throws NotesApiException;

	public abstract void FTSearch(String query) throws NotesApiException;

	public abstract void FTSearch(String query, int maxDocs)
			throws NotesApiException;

	public abstract void putAllInFolder(String folderName)
			throws NotesApiException;

	public abstract void putAllInFolder(String folderName, boolean createonfail)
			throws NotesApiException;

	public abstract void removeAll(boolean force) throws NotesApiException;

	public abstract void removeAllFromFolder(String folderName)
			throws NotesApiException;

	public abstract void stampAll(String itemName, Object value)
			throws NotesApiException;

	public abstract void updateAll() throws NotesApiException;

	public abstract void markAllRead(String username) throws NotesApiException;

	public abstract void markAllUnread(String username)
			throws NotesApiException;

	public abstract void markAllRead() throws NotesApiException;

	public abstract void markAllUnread() throws NotesApiException;

	public abstract void intersect(int noteID) throws NotesApiException;

	public abstract void intersect(String noteID) throws NotesApiException;

	public abstract void intersect(NotesBase base) throws NotesApiException;

	public abstract void merge(int noteID) throws NotesApiException;

	public abstract void merge(String noteID) throws NotesApiException;

	public abstract void merge(NotesBase base) throws NotesApiException;

	public abstract void subtract(int noteID) throws NotesApiException;

	public abstract void subtract(String noteID) throws NotesApiException;

	public abstract void subtract(NotesBase base) throws NotesApiException;

	public abstract boolean contains(int noteID) throws NotesApiException;

	public abstract boolean contains(String noteID) throws NotesApiException;

	public abstract boolean contains(NotesBase base) throws NotesApiException;

	public abstract NotesViewEntryCollection cloneCollection()
			throws NotesApiException;
}
