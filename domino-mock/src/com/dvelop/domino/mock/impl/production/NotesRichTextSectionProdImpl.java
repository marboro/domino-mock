package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.RichTextSection;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesColorObject;
import com.dvelop.domino.mock.interfaces.NotesRichTextSection;
import com.dvelop.domino.mock.interfaces.NotesRichTextStyle;

public class NotesRichTextSectionProdImpl extends NotesBaseProdImpl implements
		NotesRichTextSection {

	private final RichTextSection rtSection;

	public NotesRichTextSectionProdImpl(RichTextSection rtSection) {
		this.rtSection = rtSection;
	}

	public RichTextSection get() {
		return rtSection;
	}

	@Override
	public void remove() throws NotesApiException {
		try {
			rtSection.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setBarColor(NotesColorObject arg0) throws NotesApiException {
		try {
			rtSection.setBarColor(((NotesColorObjectProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public String getTitle() throws NotesApiException {
		try {
			return rtSection.getTitle();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTitle(String arg0) throws NotesApiException {
		try {
			rtSection.setTitle(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesRichTextStyle getTitleStyle() throws NotesApiException {
		try {
			return new NotesRichTextStyleProdImpl(rtSection.getTitleStyle());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setTitleStyle(NotesRichTextStyle arg0) throws NotesApiException {
		try {
			rtSection.setTitleStyle(((NotesRichTextStyleProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public boolean isExpanded() throws NotesApiException {
		try {
			return rtSection.isExpanded();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setExpanded(boolean arg0) throws NotesApiException {
		try {
			rtSection.setExpanded(arg0);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public NotesColorObject getBarColor() throws NotesApiException {
		try {
			return new NotesColorObjectProdImpl(rtSection.getBarColor());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

}
