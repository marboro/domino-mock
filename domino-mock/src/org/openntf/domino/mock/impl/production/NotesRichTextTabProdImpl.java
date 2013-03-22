package org.openntf.domino.mock.impl.production;

import org.openntf.domino.mock.Exception.NotesApiException;
import org.openntf.domino.mock.interfaces.NotesRichTextTab;

import lotus.domino.NotesException;
import lotus.domino.RichTextTab;


public class NotesRichTextTabProdImpl extends NotesBaseProdImpl implements
		NotesRichTextTab {

	private final RichTextTab rtTab;

	public NotesRichTextTabProdImpl(RichTextTab rtTab) {
		this.rtTab = rtTab;
	}

	@Override
	public void clear() throws NotesApiException {
		try {
			rtTab.clear();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public int getPosition() throws NotesApiException {
		try {
			return rtTab.getPosition();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getType() throws NotesApiException {
		try {
			return rtTab.getType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

}
