package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesDocumentCollection extends NotesBase {
	public abstract int getCount() throws NotesApiException;

	public abstract String getQuery() throws NotesApiException;

	public abstract NotesDatabase getParent() throws NotesApiException;

	public abstract NotesDocument getFirstDocument() throws NotesApiException;

	public abstract NotesDocument getLastDocument() throws NotesApiException;

	public abstract NotesDocument getNextDocument(NotesDocument arg0)
			throws NotesApiException;

	public abstract NotesDocument getPrevDocument(NotesDocument arg0)
			throws NotesApiException;

	public abstract NotesDocument getNthDocument(int arg0)
			throws NotesApiException;

	public abstract NotesDocument getNextDocument() throws NotesApiException;

	public abstract NotesDocument getPrevDocument() throws NotesApiException;

	public abstract NotesDocument getDocument(NotesDocument arg0)
			throws NotesApiException;

	public abstract void addDocument(NotesDocument arg0)
			throws NotesApiException;

	public abstract void addDocument(NotesDocument arg0, boolean arg1)
			throws NotesApiException;

	public abstract void deleteDocument(NotesDocument arg0)
			throws NotesApiException;

	public abstract void FTSearch(String arg0) throws NotesApiException;

	public abstract void FTSearch(String arg0, int arg1)
			throws NotesApiException;

	public abstract boolean isSorted() throws NotesApiException;

	public abstract void putAllInFolder(String arg0) throws NotesApiException;

	public abstract void putAllInFolder(String arg0, boolean arg1)
			throws NotesApiException;

	public abstract void removeAll(boolean arg0) throws NotesApiException;

	public abstract void removeAllFromFolder(String arg0)
			throws NotesApiException;

	public abstract void stampAll(String arg0, Object arg1)
			throws NotesApiException;

	public abstract void updateAll() throws NotesApiException;

	public abstract NotesDateTime getUntilTime() throws NotesApiException;

	public abstract void markAllRead(String arg0) throws NotesApiException;

	public abstract void markAllUnread(String arg0) throws NotesApiException;

	public abstract void markAllRead() throws NotesApiException;

	public abstract void markAllUnread() throws NotesApiException;

	public abstract void intersect(int arg0) throws NotesApiException;

	public abstract void intersect(String arg0) throws NotesApiException;

	public abstract void intersect(NotesBase arg0) throws NotesApiException;

	public abstract void merge(int arg0) throws NotesApiException;

	public abstract void merge(String arg0) throws NotesApiException;

	public abstract void merge(NotesBase arg0) throws NotesApiException;

	public abstract void subtract(int arg0) throws NotesApiException;

	public abstract void subtract(String arg0) throws NotesApiException;

	public abstract void subtract(NotesBase arg0) throws NotesApiException;

	public abstract boolean contains(int arg0) throws NotesApiException;

	public abstract boolean contains(String arg0) throws NotesApiException;

	public abstract boolean contains(NotesBase arg0) throws NotesApiException;

	public abstract NotesDocumentCollection cloneCollection()
			throws NotesApiException;
}
