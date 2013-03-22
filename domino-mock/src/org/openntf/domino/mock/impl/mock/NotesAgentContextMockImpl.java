package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesAgent;
import org.openntf.domino.mock.interfaces.NotesAgentContext;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDateTime;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;

public class NotesAgentContextMockImpl extends NotesBaseMockImpl implements NotesAgentContext {

	private NotesAgent currentAgent;
	private NotesDatabase currentDatabase;
	private NotesDocument documentContext;
	private int lastExitStatus;
	private NotesDateTime lastRun;
	private NotesDocument savedData;
	private NotesDocumentCollection unprocessedDocuments;
	private NotesDocument processedDoc;
	private NotesDocumentCollection unprocessedFTSearch;
	private NotesDocumentCollection unprocessedSearch;
	private String effectiveUserName;

	@Override
	public void updateProcessedDoc(NotesDocument processedDoc) throws NotesApiException {
		this.processedDoc = processedDoc;
	}

	public void setUnprocessedFTSearch(NotesDocumentCollection unprocessedFTSearch) {
		this.unprocessedFTSearch = unprocessedFTSearch;
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearch(String arg0, int arg1) throws NotesApiException {
		return unprocessedFTSearch;

	}

	@Override
	public NotesDocumentCollection unprocessedFTSearch(String arg0, int arg1, int arg2, int arg3) throws NotesApiException {
		return unprocessedFTSearch;
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearchRange(String arg0, int arg1, int arg2) throws NotesApiException {
		return unprocessedFTSearch;
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearchRange(String arg0, int arg1, int arg2, int arg3, int arg4) throws NotesApiException {
		return unprocessedFTSearch;
	}

	public void setUnprocessedSearch(NotesDocumentCollection unprocessedSearch) {
		this.unprocessedSearch = unprocessedSearch;
	}

	@Override
	public NotesDocumentCollection unprocessedSearch(String arg0, NotesDateTime arg1, int arg2) throws NotesApiException {
		return unprocessedSearch;
	}

	public void setEffectiveUserName(String effectiveUserName) {
		this.effectiveUserName = effectiveUserName;

	}

	@Override
	public String getEffectiveUserName() throws NotesApiException {
		return effectiveUserName;
	}

	public void setCurrentAgent(NotesAgent currentAgent) {
		this.currentAgent = currentAgent;
	}

	@Override
	public NotesAgent getCurrentAgent() throws NotesApiException {
		return currentAgent;
	}

	public void setCurrentDatabase(NotesDatabase currentDatabase) {
		this.currentDatabase = currentDatabase;
	}

	@Override
	public NotesDatabase getCurrentDatabase() throws NotesApiException {
		return currentDatabase;
	}

	public void setDocumentContext(NotesDocument documentContext) {
		this.documentContext = documentContext;

	}

	@Override
	public NotesDocument getDocumentContext() throws NotesApiException {
		return documentContext;

	}

	public void setLastExitStatus(int lastExitStatus) {
		this.lastExitStatus = lastExitStatus;

	}

	@Override
	public int getLastExitStatus() throws NotesApiException {
		return lastExitStatus;

	}

	public void setLastRun(NotesDateTime lastRun) {
		this.lastRun = lastRun;
	}

	@Override
	public NotesDateTime getLastRun() throws NotesApiException {
		return lastRun;

	}

	public void setSavedData(NotesDocument savedData) {
		this.savedData = savedData;

	}

	@Override
	public NotesDocument getSavedData() throws NotesApiException {
		return savedData;

	}

	public void setUnprocessedDocuments(NotesDocumentCollection unprocessedDocuments) {
		this.unprocessedDocuments = unprocessedDocuments;

	}

	@Override
	public NotesDocumentCollection getUnprocessedDocuments() throws NotesApiException {
		return unprocessedDocuments;
	}

	@Override
	public String toString() {
		return effectiveUserName;
	}
}