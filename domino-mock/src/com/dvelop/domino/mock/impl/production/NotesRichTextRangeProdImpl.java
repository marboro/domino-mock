package com.dvelop.domino.mock.impl.production;

import lotus.domino.NotesException;
import lotus.domino.RichTextRange;

import com.dvelop.domino.mock.Exception.NotesApiException;
import com.dvelop.domino.mock.interfaces.NotesBase;
import com.dvelop.domino.mock.interfaces.NotesRichTextNavigator;
import com.dvelop.domino.mock.interfaces.NotesRichTextRange;
import com.dvelop.domino.mock.interfaces.NotesRichTextStyle;

public class NotesRichTextRangeProdImpl extends NotesBaseProdImpl implements
		NotesRichTextRange {

	private final RichTextRange range;

	public NotesRichTextRangeProdImpl(RichTextRange range) {
		this.range = range;
	}

	public RichTextRange get() {
		return range;
	}

	@Override
	public void setStyle(NotesRichTextStyle arg0) throws NotesApiException {
		try {
			range.setStyle(((NotesRichTextStyleProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}

	}

	@Override
	public void remove() throws NotesApiException {
		try {
			range.remove();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setBegin(NotesBase arg0) throws NotesApiException {
		try {
			range.setBegin(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void setEnd(NotesBase arg0) throws NotesApiException {
		try {
			range.setEnd(((NotesBaseProdImpl) arg0).get());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public void reset(boolean arg0, boolean arg1) throws NotesApiException {
		try {
			range.reset(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int findandReplace(String arg0, String arg1)
			throws NotesApiException {
		try {
			return range.findandReplace(arg0, arg1);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int findandReplace(String arg0, String arg1, long arg2)
			throws NotesApiException {
		try {
			return range.findandReplace(arg0, arg1, arg2);
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextRange Clone() throws NotesApiException {
		try {
			return new NotesRichTextRangeProdImpl(range.Clone());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public int getType() throws NotesApiException {
		try {
			return range.getType();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTextRun() throws NotesApiException {
		try {
			return range.getTextRun();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public String getTextParagraph() throws NotesApiException {
		try {
			return range.getTextParagraph();
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextStyle getStyle() throws NotesApiException {
		try {
			return new NotesRichTextStyleProdImpl(range.getStyle());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}

	@Override
	public NotesRichTextNavigator getNavigator() throws NotesApiException {
		try {
			return new NotesRichTextNavigatorProdImpl(range.getNavigator());
		} catch (NotesException e) {
			throw new NotesApiException(e);
		}
	}
}