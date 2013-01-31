package com.dvelop.domino.mock.interfaces;

import com.dvelop.domino.mock.Exception.NotesApiException;

public interface NotesAgentContext extends NotesBase {

	public abstract void updateProcessedDoc(NotesDocument doc)
			throws NotesApiException;

	public abstract NotesDocumentCollection unprocessedFTSearch(String query,
			int maxDocs) throws NotesApiException;

	public abstract NotesDocumentCollection unprocessedFTSearch(String query,
			int maxDocs, int sortOpt, int otherOpt) throws NotesApiException;

	public abstract NotesDocumentCollection unprocessedFTSearchRange(
			String query, int maxDocs, int start) throws NotesApiException;

	public abstract NotesDocumentCollection unprocessedFTSearchRange(
			String query, int maxdocs, int sortopt, int otheropt, int start)
			throws NotesApiException;

	public abstract NotesDocumentCollection unprocessedSearch(String formula,
			NotesDateTime limit, int maxDocs) throws NotesApiException;

	public abstract String getEffectiveUserName() throws NotesApiException;

	public abstract NotesAgent getCurrentAgent() throws NotesApiException;

	public abstract NotesDatabase getCurrentDatabase() throws NotesApiException;

	public abstract NotesDocument getDocumentContext() throws NotesApiException;

	public abstract int getLastExitStatus() throws NotesApiException;

	public abstract NotesDateTime getLastRun() throws NotesApiException;

	public abstract NotesDocument getSavedData() throws NotesApiException;

	public abstract NotesDocumentCollection getUnprocessedDocuments()
			throws NotesApiException;
}
