package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDocumentCollection extends NotesBase {
	public abstract int getCount() throws NotesApiException;

	public abstract String getQuery() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;

	public abstract NotesDocument getFirstDocument() throws NotesApiException;

	public abstract NotesDocument getLastDocument() throws NotesApiException;

	public abstract NotesDocument getNextDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getPrevDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocument getNthDocument(int n)
			throws NotesApiException;

	public abstract NotesDocument getNextDocument() throws NotesApiException;

	public abstract NotesDocument getPrevDocument() throws NotesApiException;

	public abstract NotesDocument getDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract void addDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract void addDocument(NotesDocument doc, boolean checkDups)
			throws NotesApiException;

	public abstract void deleteDocument(NotesDocument doc)
			throws NotesApiException;

	public abstract void FTSearch(String query) throws NotesApiException;

	public abstract void FTSearch(String query, int maxDocs)
			throws NotesApiException;

	public abstract boolean isSorted() throws NotesApiException;

	public abstract void putAllInFolder(String folderName) throws NotesApiException;

	public abstract void putAllInFolder(String folderName, boolean createOnFail)
			throws NotesApiException;

	public abstract void removeAll(boolean force) throws NotesApiException;

	public abstract void removeAllFromFolder(String folderName)
			throws NotesApiException;

	public abstract void stampAll(String itemName, Object value)
			throws NotesApiException;

	public abstract void updateAll() throws NotesApiException;

	public abstract NotesDateTime getUntilTime() throws NotesApiException;

	public abstract void markAllRead(String userName) throws NotesApiException;

	public abstract void markAllUnread(String userName) throws NotesApiException;

	public abstract void markAllRead() throws NotesApiException;

	public abstract void markAllUnread() throws NotesApiException;

	public abstract void intersect(int noteID) throws NotesApiException;

	public abstract void intersect(String noteID) throws NotesApiException;

	public abstract void intersect(NotesBase documents) throws NotesApiException;

	public abstract void merge(int noteID) throws NotesApiException;

	public abstract void merge(String noteID) throws NotesApiException;

	public abstract void merge(NotesBase documents) throws NotesApiException;

	public abstract void subtract(int noteID) throws NotesApiException;

	public abstract void subtract(String noteID) throws NotesApiException;

	public abstract void subtract(NotesBase documents) throws NotesApiException;

	public abstract boolean contains(int noteID) throws NotesApiException;

	public abstract boolean contains(String noteID) throws NotesApiException;

	public abstract boolean contains(NotesBase documents) throws NotesApiException;

	public abstract NotesDocumentCollection cloneCollection()
			throws NotesApiException;
}
