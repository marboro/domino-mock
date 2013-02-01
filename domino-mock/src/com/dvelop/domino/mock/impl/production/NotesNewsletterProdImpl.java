package com.dvelop.domino.mock.impl.production;

import lotus.domino.Newsletter;
import lotus.domino.NotesException;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesDatabase;
import com.dvelop.domino.mock.interfaces.NotesDocument;
import com.dvelop.domino.mock.interfaces.NotesNewsletter;
import com.dvelop.domino.mock.interfaces.NotesSession;

public class NotesNewsletterProdImpl extends NotesBaseProdImpl implements
		NotesNewsletter {

	private final Newsletter newsletter;

	public NotesNewsletterProdImpl(Newsletter newsletter) {
		this.newsletter = newsletter;
	}

	public Newsletter get() {
		return newsletter;
	}

	@Override
	public NotesDocument formatMsgWithDoclinks(NotesDatabase arg0)
			throws NotesApiException {
		try {
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg0;
			return new NotesDocumentProdImpl(
					newsletter.formatMsgWithDoclinks(db.get()));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesDocument formatDocument(NotesDatabase arg0, int arg1)
			throws NotesApiException {
		try {
			NotesDatabaseProdImpl db = (NotesDatabaseProdImpl) arg0;
			return new NotesDocumentProdImpl(newsletter.formatDocument(
					db.get(), arg1));
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesSession getParent() throws NotesApiException {
		try {
			return new NotesSessionProdImpl(newsletter.getParent());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getSubjectItemName() throws NotesApiException {
		try {
			return newsletter.getSubjectItemName();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setSubjectItemName(String arg0) throws NotesApiException {
		try {
			newsletter.setSubjectItemName(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isDoScore() throws NotesApiException {
		try {
			return newsletter.isDoScore();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDoScore(boolean arg0) throws NotesApiException {
		try {
			newsletter.setDoScore(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public boolean isDoSubject() throws NotesApiException {
		try {
			return newsletter.isDoSubject();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setDoSubject(boolean arg0) throws NotesApiException {
		try {
			newsletter.setDoSubject(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}
}