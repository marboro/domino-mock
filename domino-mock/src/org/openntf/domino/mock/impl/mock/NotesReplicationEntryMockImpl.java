package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesReplicationEntry;

public class NotesReplicationEntryMockImpl extends NotesBaseMockImpl implements
		NotesReplicationEntry {

	@Override
	public int save() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove() throws NotesApiException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getFormula() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFormula(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getViews() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setViews(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public String getSource() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDestination() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isIncludeACL() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIncludeACL(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isIncludeAgents() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIncludeAgents(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isIncludeDocuments() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIncludeDocuments(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isIncludeForms() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIncludeForms(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isIncludeFormulas() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setIncludeFormulas(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}