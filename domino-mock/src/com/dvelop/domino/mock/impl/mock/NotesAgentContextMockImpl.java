package com.dvelop.domino.mock.impl.mock;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesAgentContext;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;

public class NotesAgentContextMockImpl extends NotesBaseMockImpl implements
		NotesAgentContext {

	@Override
	public void updateProcessedDoc(NotesDocument arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public NotesDocumentCollection unprocessedFTSearch(String arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearch(String arg0, int arg1,
			int arg2, int arg3) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearchRange(String arg0,
			int arg1, int arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearchRange(String arg0,
			int arg1, int arg2, int arg3, int arg4) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection unprocessedSearch(String arg0,
			NotesDateTime arg1, int arg2) throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEffectiveUserName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesAgent getCurrentAgent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDatabase getCurrentDatabase() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getDocumentContext() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLastExitStatus() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public NotesDateTime getLastRun() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument getSavedData() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocumentCollection getUnprocessedDocuments()
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}
}