package org.openntf.domino.mock.impl.mock;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesDatabase;
import org.openntf.domino.mock.interfaces.NotesDocument;
import org.openntf.domino.mock.interfaces.NotesDocumentCollection;
import org.openntf.domino.mock.interfaces.NotesNewsletter;
import org.openntf.domino.mock.interfaces.NotesSession;

public class NotesNewsletterMockImpl extends NotesBaseMockImpl implements
		NotesNewsletter {

	private NotesDocumentCollection collection;
	private final NotesSession parent;

	public NotesNewsletterMockImpl(NotesDocumentCollection collection,
			NotesSession parent) {
		this.collection = collection;
		this.parent = parent;

	}

	@Override
	public NotesDocument formatMsgWithDoclinks(NotesDatabase arg0)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesDocument formatDocument(NotesDatabase arg0, int arg1)
			throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSubjectItemName() throws NotesApiException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setSubjectItemName(String arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDoScore() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDoScore(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDoSubject() throws NotesApiException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setDoSubject(boolean arg0) throws NotesApiException {
		// TODO Auto-generated method stub

	}
}