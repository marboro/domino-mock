package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.RichTextTab;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesRichTextTab;

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
