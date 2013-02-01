package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.ReplicationEntry;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesReplicationEntry;

public class NotesReplicationEntryProdImpl extends NotesBaseProdImpl implements
		NotesReplicationEntry {

	private final ReplicationEntry repEntry;

	public NotesReplicationEntryProdImpl(ReplicationEntry repEntry) {
		this.repEntry = repEntry;
	}

	public ReplicationEntry get() {
		return repEntry;
	}

	@Override
	public int save() throws NotesApiException {
		try {
			return repEntry.save();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int remove() throws NotesApiException {
		try {
			return repEntry.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getFormula() throws NotesApiException {
		try {
			return repEntry.getFormula();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setFormula(String arg0) throws NotesApiException {
		try {
			repEntry.setFormula(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getViews() throws NotesApiException {
		try {
			return repEntry.getViews();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setViews(String arg0) throws NotesApiException {
		try {
			repEntry.setViews(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSource() throws NotesApiException {
		try {
			return repEntry.getSource();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getDestination() throws NotesApiException {
		try {
			return repEntry.getDestination();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIncludeACL() throws NotesApiException {
		try {
			return repEntry.isIncludeACL();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIncludeACL(boolean arg0) throws NotesApiException {
		try {
			repEntry.setIncludeACL(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIncludeAgents() throws NotesApiException {
		try {
			return repEntry.isIncludeAgents();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIncludeAgents(boolean arg0) throws NotesApiException {
		try {
			repEntry.setIncludeAgents(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIncludeDocuments() throws NotesApiException {
		try {
			return repEntry.isIncludeDocuments();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIncludeDocuments(boolean arg0) throws NotesApiException {
		try {
			repEntry.setIncludeDocuments(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIncludeForms() throws NotesApiException {
		try {
			return repEntry.isIncludeForms();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIncludeForms(boolean arg0) throws NotesApiException {
		try {
			repEntry.setIncludeForms(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isIncludeFormulas() throws NotesApiException {
		try {
			return repEntry.isIncludeFormulas();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setIncludeFormulas(boolean arg0) throws NotesApiException {
		try {
			repEntry.setIncludeFormulas(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}