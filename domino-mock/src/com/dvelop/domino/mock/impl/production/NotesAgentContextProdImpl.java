package com.dvelop.domino.mock.impl.production;

import lotus.domino.AgentContext;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesAgent;
import com.dvelop.domino.mock.interfaces.NotesAgentContext;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDateTime;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesDocumentCollection;

public class NotesAgentContextProdImpl extends NotesBaseProdImpl implements
		NotesAgentContext {

	private final AgentContext agentContext;

	public NotesAgentContextProdImpl(AgentContext agentContext) {
		this.agentContext = agentContext;
	}

	public AgentContext get() {
		return agentContext;
	}

	@Override
	public void updateProcessedDoc(NotesDocument arg0) throws NotesApiException {
		try {
			NotesDocumentProdImpl doc = (NotesDocumentProdImpl) arg0;
			agentContext.updateProcessedDoc(doc.get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesDocumentCollection unprocessedFTSearch(String arg0, int arg1)
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					agentContext.unprocessedFTSearch(arg0, arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearch(String arg0, int arg1,
			int arg2, int arg3) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					agentContext.unprocessedFTSearch(arg0, arg1, arg2, arg3));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearchRange(String arg0,
			int arg1, int arg2) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					agentContext.unprocessedFTSearchRange(arg0, arg1, arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection unprocessedFTSearchRange(String arg0,
			int arg1, int arg2, int arg3, int arg4) throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					agentContext.unprocessedFTSearchRange(arg0, arg1, arg2,
							arg3, arg4));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection unprocessedSearch(String arg0,
			NotesDateTime arg1, int arg2) throws NotesApiException {
		try {
			NotesDateTimeProdImpl dateTime = (NotesDateTimeProdImpl) arg1;
			return new NotesDocumentCollectionProdImpl(
					agentContext.unprocessedSearch(arg0, dateTime.get(), arg2));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getEffectiveUserName() throws NotesApiException {
		try {
			return agentContext.getEffectiveUserName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesAgent getCurrentAgent() throws NotesApiException {
		try {
			return new NotesAgentProdImpl(agentContext.getCurrentAgent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDatabase getCurrentDatabase() throws NotesApiException {
		try {
			return new NotesDatabaseProdImpl(agentContext.getCurrentDatabase());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getDocumentContext() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(agentContext.getDocumentContext());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getLastExitStatus() throws NotesApiException {
		try {
			return agentContext.getLastExitStatus();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDateTime getLastRun() throws NotesApiException {
		try {
			return new NotesDateTimeProdImpl(agentContext.getLastRun());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument getSavedData() throws NotesApiException {
		try {
			return new NotesDocumentProdImpl(agentContext.getSavedData());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocumentCollection getUnprocessedDocuments()
			throws NotesApiException {
		try {
			return new NotesDocumentCollectionProdImpl(
					agentContext.getUnprocessedDocuments());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}